import {reactive, ref, toRaw} from 'vue'
import type {BookshelfParam, BookshelfEntity, BookshelfRelateList} from '@/business/bookshelf/model/bookshelfModel'
import { useBookshelfModel } from '@/business/bookshelf/model/bookshelfModel'
const { createBookshelfParam, createBookshelfEntity } = useBookshelfModel()
import axiosInstance from '@/framework/axios'
import * as qs from 'qs'
import router from '@/common/router'
import { usePerm } from '@/common/permHook'
const {hasPerm } = usePerm()
import { usePage } from '@/framework/page/usePage'
import {initialPageSize} from '@/common/constant'
import editor from '@tinymce/tinymce-vue'
import type { BasicFileEntity } from '@/business/basic/model/basicFileModel'
import {useUploadBasicFile} from '@/pc/business/basic/hook/basicFileHook'
const { uploadImg, deleteImg, pageImg, handleEditorImage } = useUploadBasicFile()

const { setPageNo, setPage } = usePage()
const pageNo = ref(1)
const pageSize = ref(initialPageSize)
const bookshelfParam = reactive(<BookshelfParam>{});
const bookshelfEntity = reactive(<BookshelfEntity>{})
const bookshelfRelateList = ref(<BookshelfRelateList>{})
const bookshelfEntityList = ref(<BookshelfEntity[]>[])
const apiPrefix = '/bookshelf'
const routerPrefix = '/pc/bookshelf'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawBookshelfRelateList = resp.data.result
    bookshelfRelateList.value = rawBookshelfRelateList
}
async function get(id: any){
    let newBookshelfParam: BookshelfParam = createBookshelfParam()
    newBookshelfParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newBookshelfParam)
    const data = resp.data
    console.log('data',data)
    const rawBookshelfEntity = resp.data.result
    Object.assign(bookshelfEntity, rawBookshelfEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createBookshelf'})
}
async function initCreate(){
    Object.assign(bookshelfEntity, createBookshelfEntity())
    const estateCardGroupIdResp = await axiosInstance.post('/basicFile/getNewGroupId')
    bookshelfEntity.id = estateCardGroupIdResp.data.groupId
    relateList()
    estateCardGroupIdBasicFileList.value = []
}
async function createBookshelf(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(bookshelfEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageBookshelf'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateBookshelf',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(bookshelfEntity, createBookshelfEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
    const estateCardGroupIdGroupId = bookshelfEntity.id
    const estateCardGroupIdResult = await pageImg(estateCardGroupIdGroupId, 1, 30)
    estateCardGroupIdBasicFileList.value = estateCardGroupIdResult.items
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showBookshelf',query: {id: item.id}})
}
function initPage(){
    Object.assign(bookshelfParam, createBookshelfParam())
    bookshelfEntityList.value = []
    setPage(pageNo, pageSize, pageBookshelf)
    relateList()
    setPageNo(pageNo.value)
}
async function updateBookshelf(){
    const rawBookshelfEntity  = toRaw(bookshelfEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawBookshelfEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageBookshelf'})
}
async function deleteBookshelf(item: any){
    let newBookshelfParam: BookshelfParam = createBookshelfParam()
    newBookshelfParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newBookshelfParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageBookshelf'}})
}

async function pageBookshelf(pageNo: any,pageSize: any){
    const data = {...toRaw(bookshelfParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    bookshelfEntityList.value = result.items
    return result
}
async function importExcel(e: any){
    const file = e.target.files[0]
    let formData = new FormData()
    formData.append('file', file)
    const resp = await axiosInstance.post(apiPrefix + '/importExcel', formData)
    const data = resp.data
}
async function exportExcel(){
    const rawBookshelfParam  = toRaw(bookshelfParam)
    const paramStr = qs.stringify(rawBookshelfParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}
const estateCardGroupIdBasicFileList = ref()
async function uploadEstateCardGroupIdBasicFile(e: any){
    const groupId = bookshelfEntity.id
    await uploadImg(e, groupId)
    const {items, total} = await pageImg(groupId, 1, 30)
    estateCardGroupIdBasicFileList.value = items
}
async function deleteEstateCardGroupIdBasicFile(item: any){
    const groupId = bookshelfEntity.id
    await deleteImg(item)
    const {items, total} = await pageImg(groupId, 1, 30)
    estateCardGroupIdBasicFileList.value = items
}

export const usePageBookshelf = ()=>{
    return {hasPerm, toShow, initPage, bookshelfParam, bookshelfRelateList,  bookshelfEntityList,
        setPageNo, toCreate, toUpdate, deleteBookshelf, importExcel, exportExcel
    }
}

export const usePageBookshelfNew = ()=>{
    return {bookshelfParam, bookshelfEntity, bookshelfEntityList, initPage, setPageNo, toUpdate}
}

export const usePageBookshelfNew2 = ()=>{
    return {bookshelfParam, bookshelfEntity, bookshelfEntityList, initPage, setPageNo}
}

export const useCreateBookshelf = ()=>{
    return { initCreate, bookshelfRelateList, bookshelfEntity,
        createBookshelf,
        uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}
export const useUpdateBookshelf = ()=>{
    return { initUpdate,  bookshelfRelateList, bookshelfEntity,
        updateBookshelf,
        uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}

