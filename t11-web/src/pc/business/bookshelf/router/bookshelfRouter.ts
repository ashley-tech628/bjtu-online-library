import type { RouteRecordRaw } from 'vue-router'
export const bookshelfRouter: RouteRecordRaw[] = [
    {path:'/pc/bookshelf/pageBookshelf', component: () => import('@/pc/business/bookshelf/view/bookshelf/pageBookshelf.vue')},
    // {path:'/pc/bookshelf/createBookshelf', component: () => import('@/pc/business/bookshelf/view/bookshelf/createBookshelf.vue')},
    // {path:'/pc/bookshelf/updateBookshelf', component: () => import('@/pc/business/bookshelf/view/bookshelf/updateBookshelf.vue')},
    // {path:'/pc/bookshelf/showBookshelf', component: () => import('@/pc/business/bookshelf/view/bookshelf/showBookshelf.vue')}
]
