import {reactive, ref, toRaw} from 'vue'
import type {AuthRolePermRelParam, AuthRolePermRelEntity, AuthRolePermRelRelateList} from '@/business/auth/model/authRolePermRelModel'
import { useAuthRolePermRelModel } from '@/business/auth/model/authRolePermRelModel'
const { createAuthRolePermRelParam, createAuthRolePermRelEntity } = useAuthRolePermRelModel()
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
const authRolePermRelParam = reactive(<AuthRolePermRelParam>{});
const authRolePermRelEntity = reactive(<AuthRolePermRelEntity>{})
const authRolePermRelRelateList = ref(<AuthRolePermRelRelateList>{})
const authRolePermRelEntityList = ref(<AuthRolePermRelEntity[]>[])
const apiPrefix = '/authRolePermRel/manager'
const routerPrefix = '/pc/authRolePermRel'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawAuthRolePermRelRelateList = resp.data.result
    authRolePermRelRelateList.value = rawAuthRolePermRelRelateList
}
async function get(id: any){
    let newAuthRolePermRelParam: AuthRolePermRelParam = createAuthRolePermRelParam()
    newAuthRolePermRelParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newAuthRolePermRelParam)
    const data = resp.data
    console.log('data',data)
    const rawAuthRolePermRelEntity = resp.data.result
    Object.assign(authRolePermRelEntity, rawAuthRolePermRelEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createAuthRolePermRel'})
}
async function initCreate(){
    Object.assign(authRolePermRelEntity, createAuthRolePermRelEntity())
    relateList()
}
async function createAuthRolePermRel(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(authRolePermRelEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageAuthRolePermRel'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateAuthRolePermRel',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(authRolePermRelEntity, createAuthRolePermRelEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showAuthRolePermRel',query: {id: item.id}})
}
function initPage(){
    Object.assign(authRolePermRelParam, createAuthRolePermRelParam())
    authRolePermRelEntityList.value = []
    setPage(pageNo, pageSize, pageAuthRolePermRel)
    relateList()
    setPageNo(pageNo.value)
}
async function updateAuthRolePermRel(){
    const rawAuthRolePermRelEntity  = toRaw(authRolePermRelEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawAuthRolePermRelEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageAuthRolePermRel'})
}
async function deleteAuthRolePermRel(item: any){
    let newAuthRolePermRelParam: AuthRolePermRelParam = createAuthRolePermRelParam()
    newAuthRolePermRelParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newAuthRolePermRelParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageAuthRolePermRel'}})
}

async function pageAuthRolePermRel(pageNo: any,pageSize: any){
    const data = {...toRaw(authRolePermRelParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    authRolePermRelEntityList.value = result.items
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
    const rawAuthRolePermRelParam  = toRaw(authRolePermRelParam)
    const paramStr = qs.stringify(rawAuthRolePermRelParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}

export const usePageAuthRolePermRel = ()=>{
    return {hasPerm, toShow, initPage, authRolePermRelParam, authRolePermRelRelateList,  authRolePermRelEntityList,
        setPageNo, toCreate, toUpdate, deleteAuthRolePermRel, importExcel, exportExcel
    }
}
export const useCreateAuthRolePermRel = ()=>{
    return { initCreate, authRolePermRelRelateList, authRolePermRelEntity,
        createAuthRolePermRel,
    }
}
export const useUpdateAuthRolePermRel = ()=>{
    return { initUpdate,  authRolePermRelRelateList, authRolePermRelEntity,
        updateAuthRolePermRel,
    }
}


