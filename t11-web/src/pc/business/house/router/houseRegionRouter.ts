import type { RouteRecordRaw } from 'vue-router'
export const houseRegionRouter: RouteRecordRaw[] = [
    {path:'/pc/houseRegion/pageHouseRegion', component: () => import('@/pc/business/house/view/houseRegion/pageHouseRegion.vue')},
    {path:'/pc/houseRegion/createHouseRegion', component: () => import('@/pc/business/house/view/houseRegion/createHouseRegion.vue')},
    {path:'/pc/houseRegion/updateHouseRegion', component: () => import('@/pc/business/house/view/houseRegion/updateHouseRegion.vue')},
    {path:'/pc/houseRegion/showHouseRegion', component: () => import('@/pc/business/house/view/houseRegion/showHouseRegion.vue')}
]