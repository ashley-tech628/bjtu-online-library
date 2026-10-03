import type { RouteRecordRaw } from 'vue-router'
export const authUserRoleRelRouter: RouteRecordRaw[] = [
    {path:'/mobile/authUserRoleRel/pageAuthUserRoleRel', component: () => import('@/mobile/business/auth/view/authUserRoleRel/pageAuthUserRoleRel.vue')},
    {path:'/mobile/authUserRoleRel/createAuthUserRoleRel', component: () => import('@/mobile/business/auth/view/authUserRoleRel/createAuthUserRoleRel.vue')},
    {path:'/mobile/authUserRoleRel/updateAuthUserRoleRel', component: () => import('@/mobile/business/auth/view/authUserRoleRel/updateAuthUserRoleRel.vue')},
    {path:'/mobile/authUserRoleRel/showAuthUserRoleRel', component: () => import('@/mobile/business/auth/view/authUserRoleRel/showAuthUserRoleRel.vue')}
]