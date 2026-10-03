<template></template>
<script setup lang="ts">
import {openWecomLoginUrl} from '@/common/LoginHook'
import * as constant from '@/common/constant'
const redirectUri = constant.mobileHttpUrl + '/mobile/wecom/loginCallBack'
openWecomLoginUrl(redirectUri)
</script>