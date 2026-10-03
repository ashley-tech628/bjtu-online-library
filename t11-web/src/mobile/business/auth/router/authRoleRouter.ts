import type { RouteRecordRaw } from 'vue-router'
export const authRoleRouter: RouteRecordRaw[] = [
    {path:'/mobile/authRole/pageAuthRole', component: () => import('@/mobile/business/auth/view/authRole/pageAuthRole.vue')},
    {path:'/mobile/authRole/createAuthRole', component: () => import('@/mobile/business/auth/view/authRole/createAuthRole.vue')},
    {path:'/mobile/authRole/updateAuthRole', component: () => import('@/mobile/business/auth/view/authRole/updateAuthRole.vue')},
    {path:'/mobile/authRole/showAuthRole', component: () => import('@/mobile/business/auth/view/authRole/showAuthRole.vue')}
]