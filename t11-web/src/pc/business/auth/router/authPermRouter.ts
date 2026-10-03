import type { RouteRecordRaw } from 'vue-router'
export const authPermRouter: RouteRecordRaw[] = [
    {path:'/pc/authPerm/pageAuthPerm', component: () => import('@/pc/business/auth/view/authPerm/pageAuthPerm.vue')},
    {path:'/pc/authPerm/createAuthPerm', component: () => import('@/pc/business/auth/view/authPerm/createAuthPerm.vue')},
    {path:'/pc/authPerm/updateAuthPerm', component: () => import('@/pc/business/auth/view/authPerm/updateAuthPerm.vue')},
    {path:'/pc/authPerm/showAuthPerm', component: () => import('@/pc/business/auth/view/authPerm/showAuthPerm.vue')}
]