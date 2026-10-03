<template>
  <div v-if=" ! isWeCom">
    <div>用户名：<input type="text" v-model="usernameRef"></div>
    <div>密码：<input type="text" v-model="passwordRef"></div>
    <div><button @click="handleLogin">登陆</button></div>
    <div><button  @click="toRegisterPage">注册</button></div>

  </div>
</template>
<script setup lang="ts">
import {login, usernameRef, passwordRef,} from '@/common/LoginHook'
import {isWeCom} from 'check-platform'
import {usePageAuthUser} from '@/pc/business/auth/hook/authUserHook'

const {hasPerm, toShow, initPage, authUserParam, authUserRelateList,  authUserEntityList,
  setPageNo,
  toCreate, toUpdate, deleteAuthUser, importExcel, exportExcel, toRegister
}=usePageAuthUser()
async function handleLogin(){
  await login()
  location.assign('/mobile/menu')
}

async function toRegisterPage() {
  // Replace '/register' with the actual route for your registration page
  // For example, if your registration page is '/register', use:
  // location.assign('/register')
  location.assign('/mobile/register')
}
</script>