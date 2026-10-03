import type { RouteRecordRaw } from 'vue-router'
export const authRoleRouter: RouteRecordRaw[] = [
    {path:'/pc/authRole/pageAuthRole', component: () => import('@/pc/business/auth/view/authRole/pageAuthRole.vue')},
    {path:'/pc/authRole/createAuthRole', component: () => import('@/pc/business/auth/view/authRole/createAuthRole.vue')},
    {path:'/pc/authRole/updateAuthRole', component: () => import('@/pc/business/auth/view/authRole/updateAuthRole.vue')},
    {path:'/pc/authRole/showAuthRole', component: () => import('@/pc/business/auth/view/authRole/showAuthRole.vue')}
]