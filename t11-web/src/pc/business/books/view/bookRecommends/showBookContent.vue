<template>
  <div>���: <input type="text" v-model="bookRecommendsEntity.code" /></div>
  <div>����: <input type="text" v-model="bookRecommendsEntity.name" /></div>
  <div>�Ƿ�����: <input type="text" v-model="bookRecommendsEntity.isValid" /></div>
  <div>�����: <input type="text" v-model="bookRecommendsEntity.sortNum" /></div>

</template>

<script  lang="ts" setup>
import {useUpdateBookRecommends} from '@/pc/business/books/hook/bookRecommendsHook'
const {initUpdate, bookRecommendsRelateList, bookRecommendsEntity,
  updateBookRecommends,
} = useUpdateBookRecommends()
initUpdate()
</script>
