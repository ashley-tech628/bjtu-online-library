import {reactive, ref, toRaw} from 'vue'
import type {BookRecommendsParam, BookRecommendsEntity, BookRecommendsRelateList} from '@/business/books/model/bookRecommendsModel'
import { useBookRecommendsModel } from '@/business/books/model/bookRecommendsModel'
const { createBookRecommendsParam, createBookRecommendsEntity } = useBookRecommendsModel()
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
const bookRecommendsParam = reactive(<BookRecommendsParam>{});
const bookRecommendsEntity = reactive(<BookRecommendsEntity>{})
const bookRecommendsRelateList = ref(<BookRecommendsRelateList>{})
const bookRecommendsEntityList = ref(<BookRecommendsEntity[]>[])
const apiPrefix = '/bookRecommends'
const routerPrefix = '/pc/bookRecommends'
async function relateList(){
    const resp = await axiosInstance.post(apiPrefix + '/relateList')
    const data = resp.data
    console.log('data',data)
    const rawBookRecommendsRelateList = resp.data.result
    bookRecommendsRelateList.value = rawBookRecommendsRelateList
}
async function get(id: any){
    let newBookRecommendsParam: BookRecommendsParam = createBookRecommendsParam()
    newBookRecommendsParam.id = id
    const resp = await axiosInstance.post(apiPrefix + '/get',newBookRecommendsParam)
    const data = resp.data
    console.log('data',data)
    const  rawBookRecommendsEntity = resp.data.result
    Object.assign(bookRecommendsEntity, rawBookRecommendsEntity)
}

async function toCreate(){
    router.push({path: routerPrefix + '/createBookRecommends'})
}
async function initCreate(){
    Object.assign(bookRecommendsEntity, createBookRecommendsEntity())
    relateList()
}
async function createBookRecommends(){
    const resp = await axiosInstance.post(apiPrefix + '/create', toRaw(bookRecommendsEntity))
    console.log('respr',resp)
    router.push({path: routerPrefix + '/pageBookRecommends'})
}
function toUpdate(item: any){
    router.push({path: routerPrefix + '/updateBookRecommends',query: {id: item.id}})
}
async function initUpdate(){
    Object.assign(bookRecommendsEntity, createBookRecommendsEntity())
    const id = router.currentRoute.value.query.id
    await get(id)
    relateList()
}
function toShow(item: any){
    router.push({path: routerPrefix + '/showBookRecommends',query: {id: item.id}})
}
function initPage(){
    Object.assign(bookRecommendsParam, createBookRecommendsParam())
    bookRecommendsEntityList.value = []
    setPage(pageNo, pageSize, pageBookRecommends)
    relateList()
    setPageNo(pageNo.value)
}
async function updateBookRecommends(){
    const rawBookRecommendsEntity  = toRaw(bookRecommendsEntity)
    const resp = await axiosInstance.post(apiPrefix + '/update', rawBookRecommendsEntity)
    console.log('resp',resp)
    router.push({path: routerPrefix + '/pageBookRecommends'})
}
async function deleteBookRecommends(item: any){
    let newBookRecommendsParam: BookRecommendsParam = createBookRecommendsParam()
    newBookRecommendsParam.id = item.id
    const resp = await axiosInstance.post(apiPrefix + '/delete', newBookRecommendsParam)
    console.log('resp',resp)
    router.push({path:'/pc/empty',query: {toPath: routerPrefix + '/pageBookRecommends'}})
}

async function pageBookRecommends(pageNo: any,pageSize: any){
    const data = {...toRaw(bookRecommendsParam), pageNo, pageSize}
    const resp = await axiosInstance.post(apiPrefix + '/page', data)
    const result = resp.data.result
    const { items, total } = result
    bookRecommendsEntityList.value = result.items
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
    const rawBookRecommendsParam  = toRaw(bookRecommendsParam)
    const paramStr = qs.stringify(rawBookRecommendsParam)
    window.location.href = '/api' + apiPrefix + '/exportExcel?' + paramStr
}

export const usePageBookRecommends = ()=>{
    return {hasPerm, toShow, initPage, bookRecommendsParam, bookRecommendsRelateList,  bookRecommendsEntityList,
        setPageNo, toCreate, toUpdate, deleteBookRecommends, importExcel, exportExcel
    }
}
export const useCreateBookRecommends = ()=>{
    return { initCreate, bookRecommendsRelateList, bookRecommendsEntity,
        createBookRecommends,
    }
}
export const useUpdateBookRecommends = ()=>{
    return { initUpdate,  bookRecommendsRelateList, bookRecommendsEntity,
        updateBookRecommends,
    }
}



