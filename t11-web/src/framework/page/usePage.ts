import {reactive, ref} from "vue";

const pageNoClass = (item:number)=>{
    if(pageNo.value == item){
        return 'pageNoSpan'
    }
    return ''
}
let pageNo = ref(1)
let pageSize = ref(3)
let pageFunc:any = null
const total = ref(0)
const pageCount = ref(0)
const pageCountSliceArr = ref<number[]>()

const setPageCountSliceArr = ()=>{
    const len: number = 5
    const currPageNo:number = pageNo.value
    console.log('currPageNoa',currPageNo)
    let arr = []
    let startNum = currPageNo - len
    startNum = startNum < 1 ? 1 : startNum
    let endNum:number = currPageNo + len
    // let endNum = currPageNo + len
    console.log('len',len)
    console.log('endNumaaaaa',endNum)
    endNum = endNum > pageCount.value ? pageCount.value : endNum
    console.log('endNum',endNum)
    endNum++
    for(let i=startNum;i<endNum;i++){
        arr.push(i)
    }
    pageCountSliceArr.value = arr
}
function nextPageNo(){
    if(++pageNo.value > pageCount.value){
        pageNo.value = pageCount.value
    }
    setPageNo(pageNo.value)
}
function toPageNo(){
    setPageNo(pageNo.value)
}
function prevPageNo(){
    if(--pageNo.value < 1){
        pageNo.value = 1
    }
    setPageNo(pageNo.value)
}
function setPage(pageNoRef: any, pageSizeRef: any, func: any){
    pageNo = pageNoRef
    pageSize = pageSizeRef
    pageFunc = func
}
async function setPageNo(val: any){
    val = parseInt(val)
    pageNo.value = val
    const {items, total} = await pageFunc(pageNo.value, pageSize.value)
    setTotal(total)
}
function setTotal(totalParam: any){
    total.value = totalParam
    console.log('tt::',totalParam,pageNo.value, pageSize)
    pageCount.value = Math.trunc((totalParam-1) / pageSize.value) + 1
    console.log('pageCout::',pageCount.value)
    // setPageCountArr()
    setPageCountSliceArr()
    // emits('emitPageNo',pageNo.value)
}
export const usePage = ()=>{
    return { pageNo, pageSize, setPageNo, setPage }
}
export const useInPage = ()=>{
    return { total,  pageNo, pageCount, pageCountSliceArr,
        prevPageNo, nextPageNo, toPageNo ,setPageNo, pageNoClass,
    }
}