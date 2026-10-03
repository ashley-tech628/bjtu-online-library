import type { RouteRecordRaw } from 'vue-router'
export const authPermRouter: RouteRecordRaw[] = [
    {path:'/mobile/authPerm/pageAuthPerm', component: () => import('@/mobile/business/auth/view/authPerm/pageAuthPerm.vue')},
    {path:'/mobile/authPerm/createAuthPerm', component: () => import('@/mobile/business/auth/view/authPerm/createAuthPerm.vue')},
    {path:'/mobile/authPerm/updateAuthPerm', component: () => import('@/mobile/business/auth/view/authPerm/updateAuthPerm.vue')},
    {path:'/mobile/authPerm/showAuthPerm', component: () => import('@/mobile/business/auth/view/authPerm/showAuthPerm.vue')}
]