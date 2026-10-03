import {reactive, ref, toRaw} from 'vue'
import type {AuthRoleParam, AuthRoleEntity, AuthRoleRelateList} from '@/business/auth/model/authRoleModel'
import { useAuthRoleModel } from '@/business/auth/model/authRoleModel'
const { createAuthRoleParam, createAuthRoleEntity } = useAuthRoleModel()
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
const authRoleParam = reactive(<AuthRoleParam>{});
const authRoleEntity = reactive(<AuthRoleEntity>{})
const authRoleRelateList = ref(<AuthRoleRelateList>{})
const authRoleEntityList = ref(<AuthRoleEntity[]>[])
const apiPrefix = '/authRole/manager'
const routerPrefix = '/pc/authRole'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawAuthRoleRelateList = resp.data.result
    authRoleRelateList.value = rawAuthRoleRelateList
}
async function get(id: any){
    let newAuthRoleParam: AuthRoleParam = createAuthRoleParam()
    newAuthRoleParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newAuthRoleParam)
    const data = resp.data
    console.log('data',data)
    const rawAuthRoleEntity = resp.data.result
    Object.assign(authRoleEntity, rawAuthRoleEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createAuthRole'})
}
async function initCreate(){
    Object.assign(authRoleEntity, createAuthRoleEntity())
    relateList()
}
async function createAuthRole(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(authRoleEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageAuthRole'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateAuthRole',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(authRoleEntity, createAuthRoleEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showAuthRole',query: {id: item.id}})
}
function initPage(){
    Object.assign(authRoleParam, createAuthRoleParam())
    authRoleEntityList.value = []
    setPage(pageNo, pageSize, pageAuthRole)
    relateList()
    setPageNo(pageNo.value)
}
async function updateAuthRole(){
    const rawAuthRoleEntity  = toRaw(authRoleEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawAuthRoleEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageAuthRole'})
}
async function deleteAuthRole(item: any){
    let newAuthRoleParam: AuthRoleParam = createAuthRoleParam()
    newAuthRoleParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newAuthRoleParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageAuthRole'}})
}

async function pageAuthRole(pageNo: any,pageSize: any){
    const data = {...toRaw(authRoleParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    authRoleEntityList.value = result.items
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
    const rawAuthRoleParam  = toRaw(authRoleParam)
    const paramStr = qs.stringify(rawAuthRoleParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}

export const usePageAuthRole = ()=>{
    return {hasPerm, toShow, initPage, authRoleParam, authRoleRelateList,  authRoleEntityList,
        setPageNo, toCreate, toUpdate, deleteAuthRole, importExcel, exportExcel
    }
}
export const useCreateAuthRole = ()=>{
    return { initCreate, authRoleRelateList, authRoleEntity,
        createAuthRole,
    }
}
export const useUpdateAuthRole = ()=>{
    return { initUpdate,  authRoleRelateList, authRoleEntity,
        updateAuthRole,
    }
}


