import type { RouteRecordRaw } from 'vue-router'
export const basicFileRouter: RouteRecordRaw[] = [
    {path:'/pc/basicFile/pageBasicFile', component: () => import('@/pc/business/basic/view/basicFile/pageBasicFile.vue')},
    {path:'/pc/basicFile/createBasicFile', component: () => import('@/pc/business/basic/view/basicFile/createBasicFile.vue')},
    {path:'/pc/basicFile/updateBasicFile', component: () => import('@/pc/business/basic/view/basicFile/updateBasicFile.vue')},
    {path:'/pc/basicFile/showBasicFile', component: () => import('@/pc/business/basic/view/basicFile/showBasicFile.vue')}
]