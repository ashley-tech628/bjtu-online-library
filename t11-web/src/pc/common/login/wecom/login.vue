<template></template>
<script setup lang="ts">
import {openWecomLoginUrl} from '@/common/LoginHook'
import * as constant from '@/common/constant'
const redirectUri = constant.pcHttpUrl + '/pc/wecom/loginCallBack'
openWecomLoginUrl(redirectUri)
</script>