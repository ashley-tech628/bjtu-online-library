<template>
<div>用户名: <input type="text" v-model="authUserEntity.username" /></div>
<div>密码: <input type="text" v-model="authUserEntity.password" /></div>
<div>姓名: <input type="text" v-model="authUserEntity.realName" /></div>
<div>最后登录时间: <input type="text" v-model="authUserEntity.lastLoginTime" /></div>
<div>头像: <input type="text" v-model="authUserEntity.avatarGroupId" /></div>
<div>手机号: <input type="text" v-model="authUserEntity.mobile" /></div>
<div>备注: <input type="text" v-model="authUserEntity.remark" /></div>
<div>是否启用: <input type="text" v-model="authUserEntity.isValid" /></div>
<div>排序号: <input type="text" v-model="authUserEntity.sortNum" /></div>
  <div><button @click="createAuthUser">提交</button></div>
</template>
<script  lang="ts" setup>
import {useCreateAuthUser} from '@/pc/business/auth/hook/authUserHook'
const {initCreate, authUserRelateList, authUserEntity,
  createAuthUser,
  } = useCreateAuthUser()
  initCreate()
</script>

