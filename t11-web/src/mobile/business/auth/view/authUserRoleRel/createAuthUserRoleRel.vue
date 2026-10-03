<template>
<div>
      用户编号:<select v-model="authUserRoleRelEntity.userId">
               <option value="" >请选择</option>
               <option :value="item.id" v-for="item in authUserRoleRelRelateList.userEntityList">{{item.username}}</option>
             </select>
</div>
<div>
      角色编号:<select v-model="authUserRoleRelEntity.roleId">
               <option value="" >请选择</option>
               <option :value="item.id" v-for="item in authUserRoleRelRelateList.roleEntityList">{{item.name}}</option>
             </select>
</div>
<div>是否启用: <input type="text" v-model="authUserRoleRelEntity.isValid" /></div>
<div>排序号: <input type="text" v-model="authUserRoleRelEntity.sortNum" /></div>
  <div><button @click="createAuthUserRoleRel">提交</button></div>
</template>
<script  lang="ts" setup>
import {useCreateAuthUserRoleRel} from '@/mobile/business/auth/hook/authUserRoleRelHook'
const {initCreate, authUserRoleRelRelateList, authUserRoleRelEntity,
  createAuthUserRoleRel,
  } = useCreateAuthUserRoleRel()
  initCreate()
</script>

