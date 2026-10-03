import {reactive, ref, toRaw} from 'vue'
import type {AuthPermParam, AuthPermEntity, AuthPermRelateList} from '@/business/auth/model/authPermModel'
import { useAuthPermModel } from '@/business/auth/model/authPermModel'
const { createAuthPermParam, createAuthPermEntity } = useAuthPermModel()
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
const authPermParam = reactive(<AuthPermParam>{});
const authPermEntity = reactive(<AuthPermEntity>{})
const authPermRelateList = ref(<AuthPermRelateList>{})
const authPermEntityList = ref(<AuthPermEntity[]>[])
const apiPrefix = '/authPerm'
const routerPrefix = '/mobile/authPerm'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawAuthPermRelateList = resp.data.result
    authPermRelateList.value = rawAuthPermRelateList
}
async function get(id: any){
    let newAuthPermParam: AuthPermParam = createAuthPermParam()
    newAuthPermParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newAuthPermParam)
    const data = resp.data
    console.log('data',data)
    const rawAuthPermEntity = resp.data.result
    Object.assign(authPermEntity, rawAuthPermEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createAuthPerm'})
}
async function initCreate(){
    Object.assign(authPermEntity, createAuthPermEntity())
    relateList()
}
async function createAuthPerm(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(authPermEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageAuthPerm'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateAuthPerm',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(authPermEntity, createAuthPermEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showAuthPerm',query: {id: item.id}})
}
function initPage(){
    Object.assign(authPermParam, createAuthPermParam())
    authPermEntityList.value = []
    setPage(pageNo, pageSize, pageAuthPerm)
    relateList()
    setPageNo(pageNo.value)
}
async function updateAuthPerm(){
    const rawAuthPermEntity  = toRaw(authPermEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawAuthPermEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageAuthPerm'})
}
async function deleteAuthPerm(item: any){
    let newAuthPermParam: AuthPermParam = createAuthPermParam()
    newAuthPermParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newAuthPermParam)
    console.log('resp',resp)
    router.push({path:'/mobile/empty',query: {toPath: routerPrefix + '/pageAuthPerm'}})
}

async function pageAuthPerm(pageNo: any,pageSize: any){
    const data = {...toRaw(authPermParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    authPermEntityList.value = result.items
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
    const rawAuthPermParam  = toRaw(authPermParam)
    const paramStr = qs.stringify(rawAuthPermParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}

export const usePageAuthPerm = ()=>{
    return {hasPerm, toShow, initPage, authPermParam, authPermRelateList,  authPermEntityList,
        setPageNo, toCreate, toUpdate, deleteAuthPerm, importExcel, exportExcel
    }
}
export const useCreateAuthPerm = ()=>{
    return { initCreate, authPermRelateList, authPermEntity,
        createAuthPerm,
    }
}
export const useUpdateAuthPerm = ()=>{
    return { initUpdate,  authPermRelateList, authPermEntity,
        updateAuthPerm,
    }
}


