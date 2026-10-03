<template>
  <div>
    <p>{{ bookLibraryEntityList + "123" }}</p >
    id:<input type="text" v-model="bookLibraryParam.id" />
    title:<input type="text" v-model="bookLibraryParam.title" />
    <button @click="setPageNo(1)">search</button>
    <button v-show="hasPerm('authPerm.read')" @click="exportExcel">导出</button>
  </div>
  <div v-show="hasPerm('authPerm.write')"><button  @click="toCreate">新建</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
      <th>id</th>
      <th>title</th>
      <th>author</th>
      <th>type</th>
      <th>publicationTime</th>
      <th>cover</th>
      <th>description</th>
      <th>operation</th>
    </tr>
    <tr v-for="(item,index) in bookLibraryEntityList" :key="item.id">
      <td>{{item.id}}</td>
      <td>{{item.title}}</td>
      <td>{{item.author}}</td>
      <td>{{item.type}}</td>
      <td>{{item.publicationTime}}</td>
      <td><img :src="item.cover" style="width: 100px;height:100px"/></td>
      <td>{{item.description}}</td>
      <td>
        <button v-show="hasPerm('authPerm.read')"  @click="toShow(item)">查看</button>
        <button v-show="hasPerm('authPerm.write')" @click="toUpdate(item)">修改</button>
        <button v-show="hasPerm('authPerm.write')" @click="deleteBookLibrary(item)">删除</button>
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageBookLibrary} from '@/pc/business/bookLibrary/hook/bookLibraryHook'

const {hasPerm, toShow, initPage, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
  setPageNo,
  toCreate, toUpdate, deleteBookLibrary, importExcel, exportExcel
}=usePageBookLibrary()
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


