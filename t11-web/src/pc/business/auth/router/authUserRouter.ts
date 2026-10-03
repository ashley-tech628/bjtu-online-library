import type { RouteRecordRaw } from 'vue-router'
export const authUserRouter: RouteRecordRaw[] = [
    {path:'/pc/authUser/pageAuthUser', component: () => import('@/pc/business/auth/view/authUser/pageAuthUser.vue')},
    {path:'/pc/authUser/createAuthUser', component: () => import('@/pc/business/auth/view/authUser/createAuthUser.vue')},
    {path:'/pc/authUser/updateAuthUser', component: () => import('@/pc/business/auth/view/authUser/updateAuthUser.vue')},
    {path:'/pc/authUser/showAuthUser', component: () => import('@/pc/business/auth/view/authUser/showAuthUser.vue')}
]