<template>
  <div>
    <p>{{ userDetailsEntityList }}</p>
    id:<input type="text" v-model="userDetailsParam.user_id" />
    name:<input type="text" v-model="userDetailsParam.user_name" />
    <button @click="setPageNo(1)">search</button>
<!--    <button v-show="hasPerm('userDetails.read')" @click="exportExcel">����</button>-->
  </div>
  <div v-show="hasPerm('authPerm.write')"><button  @click="toCreate">�½�</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
      <th>user_id</th>
      <th>user_name</th>
      <th>books</th>
    </tr>
    <tr v-for="(items,index) in userDetailsEntityList" :key="items.user_id">
      <td >{{items.user_id}}</td>
      <td v-if="authUserEntity.id === items.user_id">{{items.user_name}}</td>
      <td v-if="authUserEntity.id === items.user_id">{{items.books}}</td>
      <td>
        <button @click="toShow(items)">check</button>
        <button @click="toUpdate(items)">update</button>
<!--        <button @click="deleteUserDetails(item)">ɾ��</button>-->
      </td>
    </tr>
<!--    <tr v-for="(item,index) in houseRegionEntityList" :key="item.id">-->
<!--      <td>{{item.id}}</td>-->
<!--      <td>{{item.code}}</td>-->
<!--      <td>{{item.name}}</td>-->
<!--      <td>{{item.shortName}}</td>-->
<!--      <td>{{item.landArea}}</td>-->
<!--      <td>{{item.constructionArea}}</td>-->
<!--      <td>-->
<!--        <button v-show="hasPerm('houseRegion.read')"  @click="toShow(item)">�鿴</button>-->
<!--        <button v-show="hasPerm('houseRegion.write')" @click="toUpdate(item)">�޸�</button>-->
<!--        <button v-show="hasPerm('houseRegion.write')" @click="deleteHouseRegion(item)">ɾ��</button>-->
<!--      </td>-->
<!--    </tr>-->
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageUserDetails} from '@/pc/business/userDetails/hook/userDetailsHook'
import {useCreateAuthUser} from "@/pc/business/auth/hook/authUserHook";
import axiosInstance from "@/framework/axios";

const { initCreate: initCreateAuthUser, authUserEntity, createAuthUser } = useCreateAuthUser()
const {hasPerm, toShow, initPage, userDetailsParam, userDetailsRelateList,  userDetailsEntityList,
  setPageNo,
  toCreate, toUpdate, deleteUserDetails, importExcel, exportExcel
}=usePageUserDetails()

import { ref } from 'vue';

//
// import {usePageHouseRegion} from '@/pc/business/house/hook/houseRegionHook'
//
// const {hasPerm: hasPerm2, toShow: toShow2 , initPage : initPage2, houseRegionParam, houseRegionRelateList,  houseRegionEntityList,
//   setPageNo: setPageNo2, toCreate : toCreate2, toUpdate : toUpdate2, deleteHouseRegion, importExcel : importExcel2, exportExcel :exportExcel2
// }=usePageHouseRegion()
// initPage2()
initPage()
initFunction()

async function initFunction()
{
  const response = await axiosInstance.post("/userDetails" + "/getID");
  authUserEntity.id = response.data;
  console.log("ID : "+ authUserEntity.id );
  console.log("EL: " + userDetailsEntityList);

  // console.log("userDetailsEntityList: "+userDetailsEntityList)
}
function initFunction2()
{

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