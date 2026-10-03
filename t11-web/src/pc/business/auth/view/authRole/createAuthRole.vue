<template>
<div>编号: <input type="text" v-model="authRoleEntity.code" /></div>
<div>名称: <input type="text" v-model="authRoleEntity.name" /></div>
<div>是否启用: <input type="text" v-model="authRoleEntity.isValid" /></div>
<div>排序号: <input type="text" v-model="authRoleEntity.sortNum" /></div>
  <div><button @click="createAuthRole">提交</button></div>
</template>
<script  lang="ts" setup>
import {useCreateAuthRole} from '@/pc/business/auth/hook/authRoleHook'
const {initCreate, authRoleRelateList, authRoleEntity,
  createAuthRole,
  } = useCreateAuthRole()
  initCreate()
</script>

