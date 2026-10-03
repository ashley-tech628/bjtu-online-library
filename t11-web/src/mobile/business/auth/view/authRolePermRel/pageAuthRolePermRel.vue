<template>
  <div>
  主键:<input type="text" v-model="authRolePermRelParam.id" />
 角色编号:<select v-model="authRolePermRelParam.roleId">
          <option value="" >请选择</option>
          <option :value="item.id" v-for="item in authRolePermRelRelateList.roleEntityList">{{item.name}}</option>
        </select>
 权限编号:<select v-model="authRolePermRelParam.permId">
          <option value="" >请选择</option>
          <option :value="item.id" v-for="item in authRolePermRelRelateList.permEntityList">{{item.name}}</option>
        </select>
     <button @click="setPageNo(1)">搜索</button>
     <button v-show="hasPerm('authRolePermRel.read')" @click="exportExcel">导出</button>
  </div>
  <div v-show="hasPerm('authRolePermRel.write')"><button  @click="toCreate">新建</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
     <th>主键</th>
     <th>角色编号</th>
     <th>权限编号</th>
     <th>是否启用</th>
     <th>排序号</th>
      <th>操作</th>
    </tr>
    <tr v-for="(item,index) in authRolePermRelEntityList" :key="item.id">
     <td>{{item.id}}</td>
     <td>{{item.roleId}}</td>
     <td>{{item.permId}}</td>
     <td>{{item.isValid}}</td>
     <td>{{item.sortNum}}</td>
      <td>
         <button v-show="hasPerm('authRolePermRel.read')"  @click="toShow(item)">查看</button>
         <button v-show="hasPerm('authRolePermRel.write')" @click="toUpdate(item)">修改</button>
         <button v-show="hasPerm('authRolePermRel.write')" @click="deleteAuthRolePermRel(item)">删除</button>
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageAuthRolePermRel} from '@/mobile/business/auth/hook/authRolePermRelHook'

const {hasPerm, toShow, initPage, authRolePermRelParam, authRolePermRelRelateList,  authRolePermRelEntityList,
  setPageNo,
  toCreate, toUpdate, deleteAuthRolePermRel, importExcel, exportExcel
}=usePageAuthRolePermRel()
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


