import type { RouteRecordRaw } from 'vue-router'
export const basicFileRouter: RouteRecordRaw[] = [
    {path:'/mobile/basicFile/pageBasicFile', component: () => import('@/mobile/business/basic/view/basicFile/pageBasicFile.vue')},
    {path:'/mobile/basicFile/createBasicFile', component: () => import('@/mobile/business/basic/view/basicFile/createBasicFile.vue')},
    {path:'/mobile/basicFile/updateBasicFile', component: () => import('@/mobile/business/basic/view/basicFile/updateBasicFile.vue')},
    {path:'/mobile/basicFile/showBasicFile', component: () => import('@/mobile/business/basic/view/basicFile/showBasicFile.vue')}
]