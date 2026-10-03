<template>
<div>编码: <input type="text" v-model="houseRegionEntity.code" /></div>
<div>名称: <input type="text" v-model="houseRegionEntity.name" /></div>
<div>校区简称: <input type="text" v-model="houseRegionEntity.shortName" /></div>
<div>宗地面积: <input type="text" v-model="houseRegionEntity.landArea" /></div>
<div>建筑面积: <input type="text" v-model="houseRegionEntity.constructionArea" /></div>
<div>道路面积: <input type="text" v-model="houseRegionEntity.roadArea" /></div>
<div>绿化面积: <input type="text" v-model="houseRegionEntity.greenArea" /></div>
<div>建筑数量: <input type="text" v-model="houseRegionEntity.constructionNum" /></div>
<div>   产权情况:
   <editor v-model="houseRegionEntity.ownerStatus"
       tinymce-script-src="/tinymce-dev/js/tinymce/tinymce.js"
       :init="{
        convert_urls: false,
       //images_upload_url: '/api/basicFile/simpleUpload',
        images_upload_handler: handleEditorImage,
        menubar: true,
        plugins: ['anchor','autolink','autosave','charmap','code',
        'codesample','directionality','emoticons','fullscreen','help',
        'image','importcss','insertdatetime','link','lists','media',
        'nonbreaking','pagebreak','preview','save',
        'searchreplace','table','template','visualblocks','visualchars','wordcount'
          ],
        toolbar:'undo redo bold italic underline strikethrough fontfamily fontsize blocks | alignleft aligncenter alignright alignjustify | outdent indent  numlist bullist forecolor backcolor removeformat pagebreak charmap emoticons fullscreen  preview  image media  link anchor| table code  codesample|\
           ltr rtl insertdatetime   nonbreaking    save searchreplace  template visualblocks visualchars wordcount',
        height: 500,
      }"
   ></editor>
</div>
<div>  不动产证:  <input type="file" @change="uploadEstateCardGroupIdBasicFile($event)" />
           <input type="hidden" v-model="houseRegionEntity.estateCardGroupId" />
           <div style="display: flex" >
            <div v-for="basicFile in estateCardGroupIdBasicFileList" >
             <img style="width:100px;height: 100px"  :key="basicFile.id"  :src="basicFile.uri"/>
                 <span @click="deleteEstateCardGroupIdBasicFile(basicFile)">删除</span>
             </div>
           </div>
</div>
<div>排序号: <input type="text" v-model="houseRegionEntity.sortNum" /></div>
<div><button @click="updateHouseRegion">提交</button></div>
</template>
<script  lang="ts" setup>
import {useUpdateHouseRegion} from '@/mobile/business/house/hook/houseRegionHook'
const {initUpdate, houseRegionRelateList, houseRegionEntity,
  updateHouseRegion,
   uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
   editor, handleEditorImage
  } = useUpdateHouseRegion()
  initUpdate()
</script>

