import {reactive, ref, toRaw} from 'vue'
import type {AuthUserRoleRelParam, AuthUserRoleRelEntity, AuthUserRoleRelRelateList} from '@/business/auth/model/authUserRoleRelModel'
import { useAuthUserRoleRelModel } from '@/business/auth/model/authUserRoleRelModel'
const { createAuthUserRoleRelParam, createAuthUserRoleRelEntity } = useAuthUserRoleRelModel()
import axiosInstance from '@/framework/axios'
import * as qs from 'qs'
import router from '@/common/router'
import { usePerm } from '@/common/permHook'
const { hasPerm } = usePerm()
import { usePage } from '@/framework/page/usePage'
import {initialPageSize} from '@/common/constant'

const { setPageNo, setPage } = usePage()
const pageNo = ref(1)
const pageSize = ref(initialPageSize)
const authUserRoleRelParam = reactive(<AuthUserRoleRelParam>{});
const authUserRoleRelEntity = reactive(<AuthUserRoleRelEntity>{})
const authUserRoleRelRelateList = ref(<AuthUserRoleRelRelateList>{})
const authUserRoleRelEntityList = ref(<AuthUserRoleRelEntity[]>[])
const apiPrefix = '/authUserRoleRel'
const routerPrefix = '/mobile/authUserRoleRel'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawAuthUserRoleRelRelateList = resp.data.result
    authUserRoleRelRelateList.value = rawAuthUserRoleRelRelateList
}
async function get(id: any){
    let newAuthUserRoleRelParam: AuthUserRoleRelParam = createAuthUserRoleRelParam()
    newAuthUserRoleRelParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newAuthUserRoleRelParam)
    const data = resp.data
    console.log('data',data)
    const rawAuthUserRoleRelEntity = resp.data.result
    Object.assign(authUserRoleRelEntity, rawAuthUserRoleRelEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createAuthUserRoleRel'})
}
async function initCreate(){
    Object.assign(authUserRoleRelEntity, createAuthUserRoleRelEntity())
    relateList()
}
async function createAuthUserRoleRel(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(authUserRoleRelEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageAuthUserRoleRel'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateAuthUserRoleRel',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(authUserRoleRelEntity, createAuthUserRoleRelEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showAuthUserRoleRel',query: {id: item.id}})
}
function initPage(){
    Object.assign(authUserRoleRelParam, createAuthUserRoleRelParam())
    authUserRoleRelEntityList.value = []
    setPage(pageNo, pageSize, pageAuthUserRoleRel)
    relateList()
    setPageNo(pageNo.value)
}
async function updateAuthUserRoleRel(){
    const rawAuthUserRoleRelEntity  = toRaw(authUserRoleRelEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawAuthUserRoleRelEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageAuthUserRoleRel'})
}
async function deleteAuthUserRoleRel(item: any){
    let newAuthUserRoleRelParam: AuthUserRoleRelParam = createAuthUserRoleRelParam()
    newAuthUserRoleRelParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newAuthUserRoleRelParam)
    console.log('resp',resp)
    router.push({path:'/mobile/empty',query: {toPath: routerPrefix + '/pageAuthUserRoleRel'}})
}

async function pageAuthUserRoleRel(pageNo: any,pageSize: any){
    const data = {...toRaw(authUserRoleRelParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    authUserRoleRelEntityList.value = result.items
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
    const rawAuthUserRoleRelParam  = toRaw(authUserRoleRelParam)
    const paramStr = qs.stringify(rawAuthUserRoleRelParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}

export const usePageAuthUserRoleRel = ()=>{
    return {hasPerm, toShow, initPage, authUserRoleRelParam, authUserRoleRelRelateList,  authUserRoleRelEntityList,
        setPageNo, toCreate, toUpdate, deleteAuthUserRoleRel, importExcel, exportExcel
    }
}
export const useCreateAuthUserRoleRel = ()=>{
    return { initCreate, authUserRoleRelRelateList, authUserRoleRelEntity,
        createAuthUserRoleRel,
    }
}
export const useUpdateAuthUserRoleRel = ()=>{
    return { initUpdate,  authUserRoleRelRelateList, authUserRoleRelEntity,
        updateAuthUserRoleRel,
    }
}


