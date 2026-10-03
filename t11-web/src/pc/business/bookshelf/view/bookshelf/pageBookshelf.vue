<template>
  <div>
    <p>{{ bookshelfEntityList }}</p>
    id:<input type="text" v-model="bookshelfParam.id" />
    name:<input type="text" v-model="bookshelfParam.name" />
    <button @click="setPageNo(1)">search</button>
<!--    <button v-show="hasPerm('bookshelf.read')" @click="exportExcel">����</button>-->
  </div>
<!--  <div v-show="hasPerm('bookshelf.write')"><button  @click="toCreate">�½�</button><input type="file" @change="importExcel" /></div>-->
  <table class="dataTable">
    <tr>
      <th>id</th>
      <th>name</th>
      <th>allbooks</th>
    </tr>
    <tr v-for="(item,index) in bookshelfEntityList" :key="item.id">
      <td v-if="item.id == authUserEntity.id">{{item.id}}</td>
      <td v-if="item.id == authUserEntity.id">{{item.name}}</td>
      <td v-if="item.id == authUserEntity.id">{{item.allbooks}}</td>
      <td>
<!--        <button @click="toShow(item)">check</button>-->
        <button v-if="item.id == authUserEntity.id" @click="toUpdate(item)">change</button>
<!--        <button v-show="hasPerm('bookshelf.write')" @click="deleteBookshelf(item)">ɾ��</button>-->
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageBookshelfNew} from '@/pc/business/bookshelf/hook/bookshelfHook'
// import axiosInstance from "@/framework/axios";
import {useCreateAuthUser} from "@/pc/business/auth/hook/authUserHook";
import axiosInstance from "@/framework/axios";

const { initCreate: initCreateAuthUser, authUserEntity, createAuthUser } = useCreateAuthUser()



const {bookshelfParam, bookshelfEntityList, initPage, setPageNo, toUpdate}=usePageBookshelfNew()

initCreateAuthUser()
initPage()

initFunction()

async function initFunction()
{
  const response = await axiosInstance.post("/userDetails" + "/getID");
  authUserEntity.id = response.data;
  console.log("AID: "+authUserEntity.id);
  // console.log("userDetailsEntityList: "+userDetailsEntityList)
}

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

