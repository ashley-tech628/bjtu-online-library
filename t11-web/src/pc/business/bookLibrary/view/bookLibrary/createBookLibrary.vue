<template>
  <div>id: <input type="text" v-model="bookLibraryEntity.id" /></div>
  <div>title: <input type="text" v-model="bookLibraryEntity.title" /></div>
  <div>author: <input type="text" v-model="bookLibraryEntity.author" /></div>
  <div>type: <input type="text" v-model="bookLibraryEntity.type" /></div>
  <div>publicationTime: <input type="text" v-model="bookLibraryEntity.publicationTime" /></div>
  <div>cover: <input type="text" v-model="bookLibraryEntity.cover" /></div>
  <div>description: <input type="text" v-model="bookLibraryEntity.description" /></div>
  <div><button @click="createBookLibrary">update</button></div>
</template>
<script  lang="ts" setup>
import {useCreateBookLibrary} from '@/pc/business/bookLibrary/hook/bookLibraryHook'
const {initCreate, bookLibraryRelateList, bookLibraryEntity,
  createBookLibrary,
  uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
  editor, handleEditorImage
} = useCreateBookLibrary()
initCreate()
</script>

