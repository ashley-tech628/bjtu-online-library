<template>
  <div>
  主键:<input type="text" v-model="basicFileParam.id" />
  附件组ID:<input type="text" v-model="basicFileParam.groupId" />
     <button @click="setPageNo(1)">搜索</button>
     <button v-show="hasPerm('basicFile.read')" @click="exportExcel">导出</button>
  </div>
  <div v-show="hasPerm('basicFile.write')"><button  @click="toCreate">新建</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
     <th>主键</th>
     <th>来源表</th>
     <th>附件组ID</th>
     <th>附件名</th>
     <th>附件拓展名</th>
     <th>文件类型</th>
      <th>操作</th>
    </tr>
    <tr v-for="(item,index) in basicFileEntityList" :key="item.id">
     <td>{{item.id}}</td>
     <td>{{item.fromType}}</td>
     <td>{{item.groupId}}</td>
     <td>{{item.name}}</td>
     <td>{{item.extName}}</td>
     <td>{{item.contentType}}</td>
      <td>
         <button v-show="hasPerm('basicFile.read')"  @click="toShow(item)">查看</button>
         <button v-show="hasPerm('basicFile.write')" @click="toUpdate(item)">修改</button>
         <button v-show="hasPerm('basicFile.write')" @click="deleteBasicFile(item)">删除</button>
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageBasicFile} from '@/mobile/business/basic/hook/basicFileHook'

const {hasPerm, toShow, initPage, basicFileParam, basicFileRelateList,  basicFileEntityList,
  setPageNo,
  toCreate, toUpdate, deleteBasicFile, importExcel, exportExcel
}=usePageBasicFile()
initPage()
</script>
<style scoped>
.dataTable{
border-spacing: 0;
width: 760px;
}
.dataTable th,td{
}
.dataTable tr:nth-child(odd){
background-color: #f4f9fe;
}
.dataTable th{
background-color: #ebf1f7;
}
.dataTable td{
}
</style>


