import {reactive, ref, toRaw} from 'vue'
import type {UserDetailsParam, UserDetailsEntity, UserDetailsRelateList} from '@/business/userDetails/model/userDetailsModel'
import { useUserDetailsModel } from '@/business/userDetails/model/userDetailsModel'
const { createUserDetailsParam, createUserDetailsEntity } = useUserDetailsModel()
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
const userDetailsParam = reactive(<UserDetailsParam>{});
const userDetailsEntity = reactive(<UserDetailsEntity>{})
const userDetailsRelateList = ref(<UserDetailsRelateList>{})
const userDetailsEntityList = ref(<UserDetailsEntity[]>[])
const apiPrefix = '/userDetails'
const routerPrefix = '/pc/userDetails'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawUserDetailsRelateList = resp.data.result
    userDetailsRelateList.value = rawUserDetailsRelateList
}
async function get(id: any){
    let newUserDetailsParam: UserDetailsParam = createUserDetailsParam()
    newUserDetailsParam.user_id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newUserDetailsParam)
    const data = resp.data
    console.log('data',data)
    const rawUserDetailsEntity = resp.data.result
    Object.assign(userDetailsEntity, rawUserDetailsEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createUserDetails'})
}
async function initCreate(){
    Object.assign(userDetailsEntity, createUserDetailsEntity())
    relateList()
}
async function createUserDetails(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(userDetailsEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageUserDetails'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateUserDetails',query: {user_id: item.user_id}})
}
async function initUpdate(){
    Object.assign(userDetailsEntity, createUserDetailsEntity())
    const id = router.currentRoute.value.query.user_id
    await get(id)
    relateList()
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showUserDetails',query: {user_id: item.user_id}})
}
function initPage(){
    Object.assign(userDetailsParam, createUserDetailsParam())
    userDetailsEntityList.value = []
    setPage(pageNo, pageSize, pageUserDetails)
    relateList()
    setPageNo(pageNo.value)
}
async function updateUserDetails(){
    const rawUserDetailsEntity  = toRaw(userDetailsEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawUserDetailsEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageUserDetails'})
}
async function deleteUserDetails(item: any){
    let newUserDetailsParam: UserDetailsParam = createUserDetailsParam()
    newUserDetailsParam.user_id = item.user_id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newUserDetailsParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageUserDetails'}})
}

async function pageUserDetails(pageNo: any,pageSize: any){
    const data = {...toRaw(userDetailsParam), pageNo, pageSize}
    // console.log("data0: "+data);
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result

    const { items, total } = result
    userDetailsEntityList.value = result.items
    console.log("Result123: "+result.items);
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
    const rawUserDetailsParam  = toRaw(userDetailsParam)
    const paramStr = qs.stringify(rawUserDetailsParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}
const estateCardGroupIdBasicFileList = ref()

export const usePageUserDetails = ()=>{
    return {hasPerm, toShow, initPage, userDetailsParam, userDetailsRelateList,  userDetailsEntityList,
        setPageNo, toCreate, toUpdate, deleteUserDetails, importExcel, exportExcel
    }
}
export const useCreateUserDetails = ()=>{
    return { initCreate, userDetailsRelateList, userDetailsEntity,
        createUserDetails, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}
export const useUpdateUserDetails = ()=>{
    return { initUpdate,  userDetailsRelateList, userDetailsEntity,
        updateUserDetails, estateCardGroupIdBasicFileList,
        editor, handleEditorImage
    }
}

