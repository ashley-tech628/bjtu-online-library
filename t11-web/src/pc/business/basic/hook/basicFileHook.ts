import * as imageConversion from 'image-conversion'
import {reactive, ref, toRaw} from 'vue'
import type {BasicFileParam, BasicFileEntity, BasicFileRelateList} from '@/business/basic/model/basicFileModel'
import { useBasicFileModel } from '@/business/basic/model/basicFileModel'
const { createBasicFileParam, createBasicFileEntity } = useBasicFileModel()
import axiosInstance from '@/framework/axios'
import * as qs from 'qs'
import router from '@/common/router'
import { usePerm } from '@/common/permHook'
const {hasPerm } = usePerm()
import { usePage } from '@/framework/page/usePage'
import {initialPageSize} from '@/common/constant'

const { setPageNo, setPage } = usePage()
const pageNo = ref(1)
const pageSize = ref(initialPageSize)
const basicFileParam = reactive(<BasicFileParam>{});
const basicFileEntity = reactive(<BasicFileEntity>{})
const basicFileRelateList = ref(<BasicFileRelateList>{})
const basicFileEntityList = ref(<BasicFileEntity[]>[])
const apiPrefix = '/basicFile'
const routerPrefix = '/pc/basicFile'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawBasicFileRelateList = resp.data.result
    basicFileRelateList.value = rawBasicFileRelateList
}
async function get(id: any){
    let newBasicFileParam: BasicFileParam = createBasicFileParam()
    newBasicFileParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newBasicFileParam)
    const data = resp.data
    console.log('data',data)
    const rawBasicFileEntity = resp.data.result
    Object.assign(basicFileEntity,rawBasicFileEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createBasicFile'})
}
async function initCreate(){
    Object.assign(basicFileEntity, createBasicFileEntity())
    relateList()
}
async function createBasicFile(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(basicFileEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageBasicFile'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateBasicFile',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(basicFileEntity, createBasicFileEntity())
    relateList()
    const id = router.currentRoute.value.query.id
    await get(id)
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showBasicFile',query: {id: item.id}})
}
function initPage(){
    Object.assign(basicFileParam, createBasicFileParam())
    basicFileEntityList.value = []
    setPage(pageNo, pageSize, pageBasicFile)
    relateList()
    setPageNo(pageNo.value)
}
async function updateBasicFile(){
    const rawBasicFileEntity  = toRaw(basicFileEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawBasicFileEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageBasicFile'})
}
async function deleteBasicFile(item: any){
    let newBasicFileParam: BasicFileParam = createBasicFileParam()
    newBasicFileParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newBasicFileParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageBasicFile'}})
}

async function pageBasicFile(pageNo: any,pageSize: any){
    const data = {...toRaw(basicFileParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    basicFileEntityList.value = result.items
    // console.log("Result000: "+result.items);
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
    const rawBasicFileParam  = toRaw(basicFileParam)
    const paramStr = qs.stringify(rawBasicFileParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}

export const usePageBasicFile = ()=>{
    return {hasPerm, toShow, initPage, basicFileParam, basicFileRelateList,  basicFileEntityList,
        setPageNo, toCreate, toUpdate, deleteBasicFile, importExcel, exportExcel
    }
}
export const useCreateBasicFile = ()=>{
    return { initCreate, basicFileRelateList, basicFileEntity,
        createBasicFile,
    }
}
export const useUpdateBasicFile = ()=>{
    return { initUpdate,  basicFileRelateList, basicFileEntity,
        updateBasicFile,
    }
}

/***below is about img code***/

async function uploadImg(e: any, groupId: any) {
    const file = e.target.files[0]
    let formData = new FormData()
    const fileResp = await imageConversion.compressAccurately(file, {size: 500})
    formData.append('file', fileResp)
    // formData.append('estateCardGroupId', houseRegionEntity.estateCardGroupId)
    formData.append('groupId', groupId)
    const resp = await axiosInstance.post(apiPrefix + '/upload', formData)
    const data = resp.data
}
async function deleteImg(item: any){
    let newBasicFileParam: BasicFileParam = createBasicFileParam()
    newBasicFileParam.id = item.id
    const params = {params: newBasicFileParam}
    const resp = await axiosInstance.post(apiPrefix + '/delete', params)
}
async function pageImg(groupId: any, pageNo: any,pageSize: any){
   const params = {params: {groupId, pageNo, pageSize}}
   const resp = await axiosInstance.post(apiPrefix + '/page', params)
   const result = resp.data.result
   const { items, total } = result
   basicFileEntityList.value = items
   return { items, total }
}
async function handleEditorImage(blobInfo: any, progress: any){
    const file = blobInfo.blob()
    let formData = new FormData()
    const fileResp = await imageConversion.compressAccurately(file, {size: 500, width: 500, height:500})
    formData.append('file', fileResp)
    const resp = await axiosInstance.post(apiPrefix + '/simpleUpload', formData)
    const data = resp.data
    console.log('lololo:',data.location)
    return data.location
}

export const useUploadBasicFile = ()=>{
    return { uploadImg, deleteImg, pageImg, handleEditorImage
    }
}


