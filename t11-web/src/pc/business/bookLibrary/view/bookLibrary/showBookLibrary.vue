<template>
  <div>id: <input type="text" v-model="bookLibraryEntity.id" /></div>
  <div>title: <input type="text" v-model="bookLibraryEntity.title" /></div>
  <div>author: <input type="text" v-model="bookLibraryEntity.author" /></div>
  <div>type: <input type="text" v-model="bookLibraryEntity.type" /></div>
  <div>publicationTime: <input type="text" v-model="bookLibraryEntity.publicationTime" /></div>
  <div>cover: <input type="text" v-model="bookLibraryEntity.cover" /></div>
  <div>description: <input type="text" v-model="bookLibraryEntity.description" /></div>
</template>
<script  lang="ts" setup>
import {useUpdateBookLibrary} from '@/pc/business/bookLibrary/hook/bookLibraryHook'
const {initUpdate, bookLibraryRelateList, bookLibraryEntity,
  updateBookLibrary,
  uploadEstateCardGroupIdBasicFile, deleteEstateCardGroupIdBasicFile, estateCardGroupIdBasicFileList,
  editor, handleEditorImage
} = useUpdateBookLibrary()
initUpdate()
</script>
