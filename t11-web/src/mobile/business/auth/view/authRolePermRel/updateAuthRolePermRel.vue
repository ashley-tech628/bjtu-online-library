<template>
<div>
      角色编号:<select v-model="authRolePermRelEntity.roleId">
               <option value="" >请选择</option>
               <option :value="item.id" v-for="item in authRolePermRelRelateList.roleEntityList">{{item.name}}</option>
             </select>
</div>
<div>
      权限编号:<select v-model="authRolePermRelEntity.permId">
               <option value="" >请选择</option>
               <option :value="item.id" v-for="item in authRolePermRelRelateList.permEntityList">{{item.name}}</option>
             </select>
</div>
<div>是否启用: <input type="text" v-model="authRolePermRelEntity.isValid" /></div>
<div>排序号: <input type="text" v-model="authRolePermRelEntity.sortNum" /></div>
<div><button @click="updateAuthRolePermRel">提交</button></div>
</template>
<script  lang="ts" setup>
import {useUpdateAuthRolePermRel} from '@/mobile/business/auth/hook/authRolePermRelHook'
const {initUpdate, authRolePermRelRelateList, authRolePermRelEntity,
  updateAuthRolePermRel,
  } = useUpdateAuthRolePermRel()
  initUpdate()
</script>

