import type { RouteRecordRaw } from 'vue-router'
export const authUserRouter: RouteRecordRaw[] = [
    {path:'/mobile/authUser/pageAuthUser', component: () => import('@/mobile/business/auth/view/authUser/pageAuthUser.vue')},
    {path:'/mobile/authUser/createAuthUser', component: () => import('@/mobile/business/auth/view/authUser/createAuthUser.vue')},
    {path:'/mobile/authUser/updateAuthUser', component: () => import('@/mobile/business/auth/view/authUser/updateAuthUser.vue')},
    {path:'/mobile/authUser/showAuthUser', component: () => import('@/mobile/business/auth/view/authUser/showAuthUser.vue')}
]