import type { RouteRecordRaw } from 'vue-router'
export const houseRegionRouter: RouteRecordRaw[] = [
    {path:'/mobile/houseRegion/pageHouseRegion', component: () => import('@/mobile/business/house/view/houseRegion/pageHouseRegion.vue')},
    {path:'/mobile/houseRegion/createHouseRegion', component: () => import('@/mobile/business/house/view/houseRegion/createHouseRegion.vue')},
    {path:'/mobile/houseRegion/updateHouseRegion', component: () => import('@/mobile/business/house/view/houseRegion/updateHouseRegion.vue')},
    {path:'/mobile/houseRegion/showHouseRegion', component: () => import('@/mobile/business/house/view/houseRegion/showHouseRegion.vue')}
]