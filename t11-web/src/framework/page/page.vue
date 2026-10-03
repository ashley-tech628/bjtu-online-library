<template>
  <div class="page02">
    <span>共{{total}}条</span>
    <span  @click="prevPageNo">上一页</span>
    <span> <span :class="pageNoClass(item)" v-for="(item, index) in pageCountSliceArr" @click="setPageNo(item)" >{{item}}</span></span>
    <span  @click="nextPageNo">下一页</span>
    <span>共{{pageCount}}页</span>
    <span>到 <input style="text-align: center" size="4" type="text" v-model="pageNo"> 页</span>
    <span><button @click="toPageNo">确定</button></span>
  </div>
</template>
<script lang="ts" setup>
import { useInPage } from '@/framework/page/usePage'
const { total, pageNo, pageCount, pageCountSliceArr,
  prevPageNo, nextPageNo, toPageNo ,setPageNo, pageNoClass, } = useInPage()
</script>
<style scoped>
.page01 span{
  margin-left:3px
}
.page02 span,button{
  margin:0 5px;
  cursor:pointer;
}
.pageNoSpan{
  color:red
}
</style>
