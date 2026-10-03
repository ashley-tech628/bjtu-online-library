import type { RouteRecordRaw } from 'vue-router'
export const authRolePermRelRouter: RouteRecordRaw[] = [
    {path:'/pc/authRolePermRel/pageAuthRolePermRel', component: () => import('@/pc/business/auth/view/authRolePermRel/pageAuthRolePermRel.vue')},
    {path:'/pc/authRolePermRel/createAuthRolePermRel', component: () => import('@/pc/business/auth/view/authRolePermRel/createAuthRolePermRel.vue')},
    {path:'/pc/authRolePermRel/updateAuthRolePermRel', component: () => import('@/pc/business/auth/view/authRolePermRel/updateAuthRolePermRel.vue')},
    {path:'/pc/authRolePermRel/showAuthRolePermRel', component: () => import('@/pc/business/auth/view/authRolePermRel/showAuthRolePermRel.vue')}
]