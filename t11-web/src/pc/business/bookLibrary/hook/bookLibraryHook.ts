import {reactive, ref, toRaw} from 'vue'
import type {BookLibraryParam, BookLibraryEntity, BookLibraryRelateList} from '@/business/bookLibrary/model/bookRegionModel'
import { useBookLibraryModel } from '@/business/bookLibrary/model/bookRegionModel'
const { createBookLibraryParam, createBookLibraryEntity } = useBookLibraryModel()
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
const bookLibraryParam = reactive(<BookLibraryParam>{});
const bookLibraryEntity = reactive(<BookLibraryEntity>{})
const bookLibraryRelateList = ref(<BookLibraryRelateList>{})
const bookLibraryEntityList = ref(<BookLibraryEntity[]>[])
const apiPrefix = '/bookLibrary'
const routerPrefix = '/pc/bookLibrary'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
   // console.log('data',data)
    const rawBookLibraryRelateList = resp.data.result
    bookLibraryRelateList.value = rawBookLibraryRelateList
}
async function get(id: any){
    let newBookLibraryParam: BookLibraryParam = createBookLibraryParam()
    newBookLibraryParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newBookLibraryParam)
    const data = resp.data
    console.log('data',data)
    const rawBookLibraryEntity = resp.data.result
    Object.assign(bookLibraryEntity, rawBookLibraryEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createBookLibrary'})
}
async function initCreate(){
    Object.assign(bookLibraryEntity, createBookLibraryEntity())
    const estateCardGroupIdResp = await axiosInstance.post('/basicFile/getNewGroupId')
    // bookLibraryEntity.estateCardGroupId = estateCardGroupIdResp.data.groupId
    relateList()
    estateCardGroupIdBasicFileList.value = []
}
async function createBookLibrary(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(bookLibraryEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageBookLibrary'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateBookLibrary',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(bookLibraryEntity, createBookLibraryEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
    // const estateCardGroupIdGroupId = bookLibraryEntity.estateCardGroupId
    // const estateCardGroupIdResult = await pageImg(estateCardGroupIdGroupId, 1, 30)
    // estateCardGroupIdBasicFileList.value = estateCardGroupIdResult.items
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showBookLibrary',query: {id: item.id}})
}
function initPage(){
    Object.assign(bookLibraryParam, createBookLibraryParam())
    bookLibraryEntityList.value = []
    setPage(pageNo, pageSize, pageBookLibrary)
    relateList()
    setPageNo(pageNo.value)
}

function initPage2(){
    Object.assign(bookLibraryParam, createBookLibraryParam())
    bookLibraryEntityList.value = []
    setPage(pageNo, pageSize, pageBookLibrary2)
    relateList()
    setPageNo(pageNo.value)
}
async function updateBookLibrary(){
    const rawBookLibraryEntity  = toRaw(bookLibraryEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawBookLibraryEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageBookLibrary'})
}
async function deleteBookLibrary(item: any){
    let newBookLibraryParam: BookLibraryParam = createBookLibraryParam()
    newBookLibraryParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newBookLibraryParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageBookLibrary'}})
}

async function pageBookLibrary(pageNo: any,pageSize: any){
    const data = {...toRaw(bookLibraryParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    console.log('ppp', resp)
    const result = resp.data.result
    const { items, total } = result
    bookLibraryEntityList.value = result.items
    return result
}

async function pageBookLibrary2(pageNo: any,pageSize: any){
    const data = {...toRaw(bookLibraryParam)}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    console.log('ppp', resp)
    const result = resp.data.result
    const { items, total } = result
    bookLibraryEntityList.value = result.items
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
    const rawBookLibraryParam  = toRaw(bookLibraryParam)
    const paramStr = qs.stringify(rawBookLibraryParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}
const estateCardGroupIdBasicFileList = ref()
async function uploadEstateCardGroupIdBasicFile(e: any){
    // const groupId = bookLibraryEntity.estateCardGroupId
    // await uploadImg(e, groupId)
    // const {items, total} = await pageImg(groupId, 1, 30)
    // estateCardGroupIdBasicFileList.value = items
}
async function deleteEstateCardGroupIdBasicFile(item: any){
    // const groupId = bookLibraryEntity.estateCardGroupId
    // await deleteImg(item)
    // const {items, total} = await pageImg(groupId, 1, 30)
    // estateCardGroupIdBasicFileList.value = items
}

export const usePageBookLibrary = ()=>{
    return {hasPerm, toShow, initPage, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
        setPageNo, toCreate, toUpdate, deleteBookLibrary, importExcel, exportExcel
    }
}

export const useBookLibrary = ()=>{
    return {hasPerm, toShow, initPage2, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
        setPageNo, toCreate, toUpdate, deleteBookLibrary, importExcel, exportExcel
    }
}
export const useCreateBookLibrary = ()=>{
    return { initCreate, bookLibraryRelateList, bookLibraryEntity,
        createBookLibrary,
        uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}
export const useUpdateBookLibrary = ()=>{
    return { initUpdate,  bookLibraryRelateList, bookLibraryEntity,
        updateBookLibrary,
        uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}


