<template>
  <div>
  主键:<input type="text" v-model="authRoleParam.id" />
  编号:<input type="text" v-model="authRoleParam.code" />
     <button @click="setPageNo(1)">搜索</button>
     <button v-show="hasPerm('authRole.read')" @click="exportExcel">导出</button>
  </div>
  <div v-show="hasPerm('authRole.write')"><button  @click="toCreate">新建</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
     <th>主键</th>
     <th>编号</th>
     <th>名称</th>
     <th>是否启用</th>
     <th>排序号</th>
      <th>操作</th>
    </tr>
    <tr v-for="(item,index) in authRoleEntityList" :key="item.id">
     <td>{{item.id}}</td>
     <td>{{item.code}}</td>
     <td>{{item.name}}</td>
     <td>{{item.isValid}}</td>
     <td>{{item.sortNum}}</td>
      <td>
         <button v-show="hasPerm('authRole.read')"  @click="toShow(item)">查看</button>
         <button v-show="hasPerm('authRole.write')" @click="toUpdate(item)">修改</button>
         <button v-show="hasPerm('authRole.write')" @click="deleteAuthRole(item)">删除</button>
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageAuthRole} from '@/pc/business/auth/hook/authRoleHook'

const {hasPerm, toShow, initPage, authRoleParam, authRoleRelateList,  authRoleEntityList,
  setPageNo,
  toCreate, toUpdate, deleteAuthRole, importExcel, exportExcel
}=usePageAuthRole()
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


