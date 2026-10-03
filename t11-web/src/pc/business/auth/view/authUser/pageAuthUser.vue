<template>
  <div>
  主键:<input type="text" v-model="authUserParam.id" />
  用户名:<input type="text" v-model="authUserParam.username" />
  姓名:<input type="text" v-model="authUserParam.realName" />
     <button @click="setPageNo(1)">搜索</button>
     <button v-show="hasPerm('authUser.read')" @click="exportExcel">导出</button>
  </div>
  <div v-show="hasPerm('authUser.write')"><button  @click="toCreate">新建</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
     <th>主键</th>
     <th>用户名</th>
     <th>密码</th>
     <th>姓名</th>
     <th>最后登录时间</th>
     <th>头像</th>
      <th>操作</th>
    </tr>
    <tr v-for="(item,index) in authUserEntityList" :key="item.id">
     <td>{{item.id}}</td>
     <td>{{item.username}}</td>
     <td>{{item.password}}</td>
     <td>{{item.realName}}</td>
     <td>{{item.lastLoginTime}}</td>
     <td>{{item.avatarGroupId}}</td>
      <td>
         <button v-show="hasPerm('authUser.read')"  @click="toShow(item)">查看</button>
         <button v-show="hasPerm('authUser.write')" @click="toUpdate(item)">修改</button>
         <button v-show="hasPerm('authUser.write')" @click="deleteAuthUser(item)">删除</button>
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageAuthUser} from '@/pc/business/auth/hook/authUserHook'

const {hasPerm, toShow, initPage, authUserParam, authUserRelateList,  authUserEntityList,
  setPageNo,
  toCreate, toUpdate, deleteAuthUser, importExcel, exportExcel
}=usePageAuthUser()
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


