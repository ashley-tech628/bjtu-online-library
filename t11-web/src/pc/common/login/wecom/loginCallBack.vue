<template></template>
<script setup lang="ts">
import router from '@/common/router'
import axiosInstance from "@/framework/axios";
import { onLogin } from "@/common/LoginHook";
const code = router.currentRoute.value.query.code
const resp = await axiosInstance.post('/wecomLogin',{code});
onLogin(resp)
location.assign('/pc/main')
</script>