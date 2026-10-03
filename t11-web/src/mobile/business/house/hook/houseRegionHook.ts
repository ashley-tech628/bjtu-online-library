import {reactive, ref, toRaw} from 'vue'
import type {HouseRegionParam, HouseRegionEntity, HouseRegionRelateList} from '@/business/house/model/houseRegionModel'
import { useHouseRegionModel } from '@/business/house/model/houseRegionModel'
const { createHouseRegionParam, createHouseRegionEntity } = useHouseRegionModel()
import axiosInstance from '@/framework/axios'
import * as qs from 'qs'
import router from '@/common/router'
import { usePerm } from '@/common/permHook'
const { hasPerm } = usePerm()
import { usePage } from '@/framework/page/usePage'
import {initialPageSize} from '@/common/constant'
import editor from '@tinymce/tinymce-vue'
import type { BasicFileEntity } from '@/business/basic/model/basicFileModel'
import {useUploadBasicFile} from '@/mobile/business/basic/hook/basicFileHook'
const { uploadImg, deleteImg, pageImg, handleEditorImage } = useUploadBasicFile()

const { setPageNo, setPage } = usePage()
const pageNo = ref(1)
const pageSize = ref(initialPageSize)
const houseRegionParam = reactive(<HouseRegionParam>{});
const houseRegionEntity = reactive(<HouseRegionEntity>{})
const houseRegionRelateList = ref(<HouseRegionRelateList>{})
const houseRegionEntityList = ref(<HouseRegionEntity[]>[])
const apiPrefix = '/houseRegion'
const routerPrefix = '/mobile/houseRegion'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawHouseRegionRelateList = resp.data.result
    houseRegionRelateList.value = rawHouseRegionRelateList
}
async function get(id: any){
    let newHouseRegionParam: HouseRegionParam = createHouseRegionParam()
    newHouseRegionParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newHouseRegionParam)
    const data = resp.data
    console.log('data',data)
    const rawHouseRegionEntity = resp.data.result
    Object.assign(houseRegionEntity, rawHouseRegionEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createHouseRegion'})
}
async function initCreate(){
    Object.assign(houseRegionEntity, createHouseRegionEntity())
    const estateCardGroupIdResp = await axiosInstance.post('/basicFile/getNewGroupId')
    houseRegionEntity.estateCardGroupId = estateCardGroupIdResp.data.groupId
    relateList()
    estateCardGroupIdBasicFileList.value = []
}
async function createHouseRegion(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(houseRegionEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageHouseRegion'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateHouseRegion',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(houseRegionEntity, createHouseRegionEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
    const estateCardGroupIdGroupId = houseRegionEntity.estateCardGroupId
    const estateCardGroupIdResult = await pageImg(estateCardGroupIdGroupId, 1, 30)
    estateCardGroupIdBasicFileList.value = estateCardGroupIdResult.items
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showHouseRegion',query: {id: item.id}})
}
function initPage(){
    Object.assign(houseRegionParam, createHouseRegionParam())
    houseRegionEntityList.value = []
    setPage(pageNo, pageSize, pageHouseRegion)
    relateList()
    setPageNo(pageNo.value)
}
async function updateHouseRegion(){
    const rawHouseRegionEntity  = toRaw(houseRegionEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawHouseRegionEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageHouseRegion'})
}
async function deleteHouseRegion(item: any){
    let newHouseRegionParam: HouseRegionParam = createHouseRegionParam()
    newHouseRegionParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newHouseRegionParam)
    console.log('resp',resp)
    router.push({path:'/mobile/empty',query: {toPath: routerPrefix + '/pageHouseRegion'}})
}

async function pageHouseRegion(pageNo: any,pageSize: any){
    const data = {...toRaw(houseRegionParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    houseRegionEntityList.value = result.items
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
    const rawHouseRegionParam  = toRaw(houseRegionParam)
    const paramStr = qs.stringify(rawHouseRegionParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}
const estateCardGroupIdBasicFileList = ref()
async function uploadEstateCardGroupIdBasicFile(e: any){
    const groupId = houseRegionEntity.estateCardGroupId
    await uploadImg(e, groupId)
    const {items, total} = await pageImg(groupId, 1, 30)
    estateCardGroupIdBasicFileList.value = items
}
async function deleteEstateCardGroupIdBasicFile(item: any){
    const groupId = houseRegionEntity.estateCardGroupId
    await deleteImg(item)
    const {items, total} = await pageImg(groupId, 1, 30)
    estateCardGroupIdBasicFileList.value = items
}

export const usePageHouseRegion = ()=>{
    return {hasPerm, toShow, initPage, houseRegionParam, houseRegionRelateList,  houseRegionEntityList,
        setPageNo, toCreate, toUpdate, deleteHouseRegion, importExcel, exportExcel
    }
}
export const useCreateHouseRegion = ()=>{
    return { initCreate, houseRegionRelateList, houseRegionEntity,
        createHouseRegion,
        uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}
export const useUpdateHouseRegion = ()=>{
    return { initUpdate,  houseRegionRelateList, houseRegionEntity,
        updateHouseRegion,
        uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}


