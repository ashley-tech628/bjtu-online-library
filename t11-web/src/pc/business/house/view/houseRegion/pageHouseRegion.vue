<template>
  <div>
  主键:<input type="text" v-model="houseRegionParam.id" />
  名称:<input type="text" v-model="houseRegionParam.name" />
     <button @click="setPageNo(1)">搜索</button>
     <button v-show="hasPerm('houseRegion.read')" @click="exportExcel">导出</button>
  </div>
  <div v-show="hasPerm('houseRegion.write')"><button  @click="toCreate">新建</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
     <th>主键</th>
     <th>编码</th>
     <th>名称</th>
     <th>校区简称</th>
     <th>宗地面积</th>
     <th>建筑面积</th>
      <th>操作</th>
    </tr>
    <tr v-for="(item,index) in houseRegionEntityList" :key="item.id">
     <td>{{item.id}}</td>
     <td>{{item.code}}</td>
     <td>{{item.name}}</td>
     <td>{{item.shortName}}</td>
     <td>{{item.landArea}}</td>
     <td>{{item.constructionArea}}</td>
      <td>
         <button v-show="hasPerm('houseRegion.read')"  @click="toShow(item)">查看</button>
         <button v-show="hasPerm('houseRegion.write')" @click="toUpdate(item)">修改</button>
         <button v-show="hasPerm('houseRegion.write')" @click="deleteHouseRegion(item)">删除</button>
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageHouseRegion} from '@/pc/business/house/hook/houseRegionHook'
import axiosInstance from "@/framework/axios";

const {hasPerm, toShow, initPage, houseRegionParam, houseRegionRelateList,  houseRegionEntityList,
  setPageNo,
  toCreate, toUpdate, deleteHouseRegion, importExcel, exportExcel
}=usePageHouseRegion()
initPage()
initFunction()
async function initFunction()
{
  // const response = await axiosInstance.post("/userDetails" + "/getID");
  // authUserEntity.id = response.data;
  // console.log("ID : "+ authUserEntity.id );
  console.log("EL: " + houseRegionEntityList.value);
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


