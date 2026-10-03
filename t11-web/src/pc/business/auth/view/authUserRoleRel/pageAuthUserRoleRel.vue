<template>
  <div>
  主键:<input type="text" v-model="authUserRoleRelParam.id" />
 用户编号:<select v-model="authUserRoleRelParam.userId">
          <option value="" >请选择</option>
          <option :value="item.id" v-for="item in authUserRoleRelRelateList.userEntityList">{{item.username}}</option>
        </select>
 角色编号:<select v-model="authUserRoleRelParam.roleId">
          <option value="" >请选择</option>
          <option :value="item.id" v-for="item in authUserRoleRelRelateList.roleEntityList">{{item.name}}</option>
        </select>
     <button @click="setPageNo(1)">搜索</button>
     <button v-show="hasPerm('authUserRoleRel.read')" @click="exportExcel">导出</button>
  </div>
  <div v-show="hasPerm('authUserRoleRel.write')"><button  @click="toCreate">新建</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
     <th>主键</th>
     <th>用户编号</th>
     <th>角色编号</th>

     <th>是否启用</th>
     <th>排序号</th>
      <th>操作</th>
    </tr>
    <tr v-for="(item,index) in authUserRoleRelEntityList" :key="item.id">
     <td>{{item.id}}</td>
     <td>{{item.userId}}</td>
     <td>{{item.roleId}}</td>
     <td>{{item.isValid}}</td>
     <td>{{item.sortNum}}</td>
      <td>
         <button v-show="hasPerm('authUserRoleRel.read')"  @click="toShow(item)">查看</button>
         <button v-show="hasPerm('authUserRoleRel.write')" @click="toUpdate(item)">修改</button>
         <button v-show="hasPerm('authUserRoleRel.write')" @click="deleteAuthUserRoleRel(item)">删除</button>
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageAuthUserRoleRel} from '@/pc/business/auth/hook/authUserRoleRelHook'

const {hasPerm, toShow, initPage, authUserRoleRelParam, authUserRoleRelRelateList,  authUserRoleRelEntityList,
  setPageNo,
  toCreate, toUpdate, deleteAuthUserRoleRel, importExcel, exportExcel
}=usePageAuthUserRoleRel()
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


