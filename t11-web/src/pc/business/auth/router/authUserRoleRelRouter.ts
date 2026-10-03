import type { RouteRecordRaw } from 'vue-router'
export const authUserRoleRelRouter: RouteRecordRaw[] = [
    {path:'/pc/authUserRoleRel/pageAuthUserRoleRel', component: () => import('@/pc/business/auth/view/authUserRoleRel/pageAuthUserRoleRel.vue')},
    {path:'/pc/authUserRoleRel/createAuthUserRoleRel', component: () => import('@/pc/business/auth/view/authUserRoleRel/createAuthUserRoleRel.vue')},
    {path:'/pc/authUserRoleRel/updateAuthUserRoleRel', component: () => import('@/pc/business/auth/view/authUserRoleRel/updateAuthUserRoleRel.vue')},
    {path:'/pc/authUserRoleRel/showAuthUserRoleRel', component: () => import('@/pc/business/auth/view/authUserRoleRel/showAuthUserRoleRel.vue')}
]