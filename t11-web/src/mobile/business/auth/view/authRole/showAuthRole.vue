<template>
<div>编号: <input type="text" v-model="authRoleEntity.code" /></div>
<div>名称: <input type="text" v-model="authRoleEntity.name" /></div>
<div>是否启用: <input type="text" v-model="authRoleEntity.isValid" /></div>
<div>排序号: <input type="text" v-model="authRoleEntity.sortNum" /></div>
</template>
<script  lang="ts" setup>
import {useUpdateAuthRole} from '@/mobile/business/auth/hook/authRoleHook'
const {initUpdate, authRoleRelateList, authRoleEntity,
  updateAuthRole,
  } = useUpdateAuthRole()
  initUpdate()
</script>
