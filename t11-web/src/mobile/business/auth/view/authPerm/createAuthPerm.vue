<template>
<div>编号: <input type="text" v-model="authPermEntity.code" /></div>
<div>名称: <input type="text" v-model="authPermEntity.name" /></div>
<div>是否启用: <input type="text" v-model="authPermEntity.isValid" /></div>
<div>排序号: <input type="text" v-model="authPermEntity.sortNum" /></div>
  <div><button @click="createAuthPerm">提交</button></div>
</template>
<script  lang="ts" setup>
import {useCreateAuthPerm} from '@/mobile/business/auth/hook/authPermHook'
const {initCreate, authPermRelateList, authPermEntity,
  createAuthPerm,
  } = useCreateAuthPerm()
  initCreate()
</script>

