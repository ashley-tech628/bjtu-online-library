import type { RouteRecordRaw } from 'vue-router'
export const bookLibraryRouter: RouteRecordRaw[] = [
    {path:'/pc/bookLibrary/pageBookLibrary', component: () => import('@/pc/business/bookLibrary/view/bookLibrary/pageBookLibrary.vue')},
    {path:'/pc/bookLibrary/createBookLibrary', component: () => import('@/pc/business/bookLibrary/view/bookLibrary/createBookLibrary.vue')},
    {path:'/pc/bookLibrary/updateBookLibrary', component: () => import('@/pc/business/bookLibrary/view/bookLibrary/updateBookLibrary.vue')},
    {path:'/pc/bookLibrary/showBookLibrary', component: () => import('@/pc/business/bookLibrary/view/bookLibrary/showBookLibrary.vue')}
]