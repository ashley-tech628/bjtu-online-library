<template>

  <div>
    ����:<input type="text" v-model="bookRecommendsParam.id" />
    ���:<input type="text" v-model="bookRecommendsParam.code" />
    <button @click="setPageNo(1)">Search</button>
    <button v-show="hasPerm('authRole.read')" @click="exportExcel">Export</button>
  </div>


  <div><button  @click="toCreate">Create</button><input type="file" @change="importExcel" /></div>
  <table class="dataTable">
    <tr>
      <th>main</th>
      <th>���</th>
      <th>����</th>
      <th>�Ƿ�����</th>
      <th>�����</th>
      <th>����</th>
    </tr>
    <tr v-for="(item,index) in bookRecommendsEntityList" :key="item.id">
      <td>{{item.id}}</td>
      <td>{{item.code}}</td>
      <td>{{item.name}}</td>
      <td>{{item.isValid}}</td>
      <td>{{item.sortNum}}</td>
      <td>
        <button v-show="hasPerm('authRole.read')"  @click="toShow(item)">show</button>
        <button v-show="hasPerm('authRole.write')" @click="toUpdate(item)">update</button>
        <button @click="downloadFile('testBook.pdf')">Download</button> <!-- New Download button -->

        <!--        <button v-show="hasPerm('authRole.write')" @click="deleteAuthRole(item)">delete</button>-->
      </td>
    </tr>
  </table>
  <Page/>
</template>
<script lang="ts" setup>
import Page from "@/framework/page/page.vue";
import {usePageBookRecommends} from '@/pc/business/books/hook/bookRecommendsHook'

const {hasPerm, toShow, initPage, bookRecommendsParam, bookRecommendsRelateList,  bookRecommendsEntityList,
  setPageNo,
  toCreate, toUpdate, deleteBookRecommends, importExcel, exportExcel
}=usePageBookRecommends()


initPage()

function downloadFile(fileName) {
  // Construct the URL for the file in the 'public' folder
  const fileURL = `/bookFiles/type1/${fileName}`;

  // Create a virtual link element for downloading the file
  const downloadLink = document.createElement('a');
  downloadLink.href = fileURL;

  // Set the file name
  downloadLink.download = fileName;

  // Trigger the click event to start the download
  downloadLink.click();
}

// function downloadFile(item) {
//   // You can generate the file content or get its URL dynamically here.
//   // For this example, I'll create a simple text file.
//
//   // Create a blob with the file content
//   const fileContent = 'This is the content of the file.';
//   const blob = new Blob([fileContent], { type: 'text/plain' });
//
//   // Create a URL for the blob
//   const url = URL.createObjectURL(blob);
//
//   // Create a virtual link element for downloading the file
//   const downloadLink = document.createElement('a');
//   downloadLink.href = url;
//
//   // Set the file name
//   downloadLink.download = 'example.txt';
//
//   // Trigger the click event to start the download
//   downloadLink.click();
//
//   // Clean up by revoking the URL
//   URL.revokeObjectURL(url);
// }

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
