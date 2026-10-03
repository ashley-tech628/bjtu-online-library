import type { RouteRecordRaw } from 'vue-router'
export const authRolePermRelRouter: RouteRecordRaw[] = [
    {path:'/mobile/authRolePermRel/pageAuthRolePermRel', component: () => import('@/mobile/business/auth/view/authRolePermRel/pageAuthRolePermRel.vue')},
    {path:'/mobile/authRolePermRel/createAuthRolePermRel', component: () => import('@/mobile/business/auth/view/authRolePermRel/createAuthRolePermRel.vue')},
    {path:'/mobile/authRolePermRel/updateAuthRolePermRel', component: () => import('@/mobile/business/auth/view/authRolePermRel/updateAuthRolePermRel.vue')},
    {path:'/mobile/authRolePermRel/showAuthRolePermRel', component: () => import('@/mobile/business/auth/view/authRolePermRel/showAuthRolePermRel.vue')}
]