<template>
<div>来源表: <input type="text" v-model="basicFileEntity.fromType" /></div>
<div>附件组ID: <input type="text" v-model="basicFileEntity.groupId" /></div>
<div>附件名: <input type="text" v-model="basicFileEntity.name" /></div>
<div>附件拓展名: <input type="text" v-model="basicFileEntity.extName" /></div>
<div>文件类型: <input type="text" v-model="basicFileEntity.contentType" /></div>
<div>附件大小: <input type="text" v-model="basicFileEntity.size" /></div>
<div>附件存储相对地址: <input type="text" v-model="basicFileEntity.path" /></div>
<div>是否启用: <input type="text" v-model="basicFileEntity.isValid" /></div>
<div>排序号: <input type="text" v-model="basicFileEntity.sortNum" /></div>
<div><button @click="updateBasicFile">提交</button></div>
</template>
<script  lang="ts" setup>
import {useUpdateBasicFile} from '@/pc/business/basic/hook/basicFileHook'
const {initUpdate, basicFileRelateList, basicFileEntity,
  updateBasicFile,
  } = useUpdateBasicFile()
  initUpdate()
</script>

