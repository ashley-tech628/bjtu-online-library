import type { RouteRecordRaw } from 'vue-router'
export const userDetailsRouter: RouteRecordRaw[] = [
    {path:'/pc/userDetails/pageUserDetails', component: () => import('@/pc/business/userDetails/view/userDetails/pageUserDetails.vue')},
    // {path:'/pc/userDetails/createUserDetails', component: () => import('@/pc/business/userDetails/view/userDetails/createUserDetails.vue')},
    {path:'/pc/userDetails/updateUserDetails', component: () => import('@/pc/business/userDetails/view/userDetails/updateUserDetails.vue')},
    // {path:'/pc/userDetails/showUserDetails', component: () => import('@/pc/business/userDetails/view/userDetails/showUserDetails.vue')}
]
