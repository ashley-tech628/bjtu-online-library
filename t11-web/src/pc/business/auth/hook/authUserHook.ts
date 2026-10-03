import {reactive, ref, toRaw} from 'vue'
import type {AuthUserParam, AuthUserEntity, AuthUserRelateList} from '@/business/auth/model/authUserModel'
import { useAuthUserModel } from '@/business/auth/model/authUserModel'
const { createAuthUserParam, createAuthUserEntity } = useAuthUserModel()
import axiosInstance from '@/framework/axios'
import * as qs from 'qs'
import router from '@/common/router'
import { usePerm } from '@/common/permHook'
const {hasPerm } = usePerm()
import { usePage } from '@/framework/page/usePage'
import {initialPageSize} from '@/common/constant'
// import {AuthUserRoleRelEntity} from "@/business/auth/model/authUserRoleRelModel";
import type {AuthUserRoleRelParam, AuthUserRoleRelEntity, AuthUserRoleRelRelateList} from '@/business/auth/model/authUserRoleRelModel'
const { setPageNo, setPage } = usePage()
const pageNo = ref(1)
const pageSize = ref(initialPageSize)
const authUserParam = reactive(<AuthUserParam>{});
const authUserEntity = reactive(<AuthUserEntity>{})
const authUserRelateList = ref(<AuthUserRelateList>{})
const authUserEntityList = ref(<AuthUserEntity[]>[])
const apiPrefix = '/authUser'
const routerPrefix = '/pc/authUser'

const authUserRoleRelEntity = reactive(<AuthUserRoleRelEntity>{})
const apiPrefixRegister = '/authUserRoleRel/manager'

async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    console.log(axiosInstance);
    const data = resp.data
    console.log('data',data)
    const rawAuthUserRelateList = resp.data.result
    authUserRelateList.value = rawAuthUserRelateList
}
async function get(id: any){
    let newAuthUserParam: AuthUserParam = createAuthUserParam()
    newAuthUserParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newAuthUserParam)
    const data = resp.data
    console.log('data',data)
    const rawAuthUserEntity = resp.data.result
    Object.assign(authUserEntity, rawAuthUserEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createAuthUser'})
}
async function initCreate(){
    Object.assign(authUserEntity, createAuthUserEntity())
    relateList()
}
async function createAuthUser(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(authUserEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageAuthUser'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateAuthUser',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(authUserEntity, createAuthUserEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showAuthUser',query: {id: item.id}})
}
function initPage(){
    Object.assign(authUserParam, createAuthUserParam())
    authUserEntityList.value = []
    setPage(pageNo, pageSize, pageAuthUser)
    relateList()
    setPageNo(pageNo.value)
}
async function updateAuthUser(){
    const rawAuthUserEntity  = toRaw(authUserEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawAuthUserEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageAuthUser'})
}
async function deleteAuthUser(item: any){
    let newAuthUserParam: AuthUserParam = createAuthUserParam()
    newAuthUserParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newAuthUserParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageAuthUser'}})
}

async function pageAuthUser(pageNo: any,pageSize: any){
    const data = {...toRaw(authUserParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    authUserEntityList.value = result.items
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
    const rawAuthUserParam  = toRaw(authUserParam)
    const paramStr = qs.stringify(rawAuthUserParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}

async  function toRegister()
{

    toCreate();
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(authUserRoleRelEntity))

}

export const usePageAuthUser = ()=>{
    return {hasPerm, toShow, initPage, authUserParam, authUserRelateList,  authUserEntityList,
        setPageNo, toCreate, toUpdate, deleteAuthUser, importExcel, exportExcel, toRegister
    }
}

export const useMyAuthUser = ()=>{
    return {initPage, authUserEntity,  authUserEntityList}
}
export const useCreateAuthUser = ()=>{
    return { initCreate, authUserRelateList, authUserEntity,
        createAuthUser,
    }
}
export const useUpdateAuthUser = ()=>{
    return { initUpdate,  authUserRelateList, authUserEntity,
        updateAuthUser,
    }
}
export const useUpdateAuthUser2 = ()=>{
    return { initUpdate,  authUserRelateList,
        updateAuthUser,
    }
}

