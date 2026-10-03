import type { RouteRecordRaw } from 'vue-router'
export const bookRecommendsRouter: RouteRecordRaw[] = [
    {path:'/pc/bookRecommends/pageBookRecommends', component: () => import('@/pc/business/books/view/bookRecommends/pageBookRecommends.vue')},
    // {path:'/pc/bookRecommends/createBookRecommends', component: () => import('@/pc/business/books/view/bookRecommends/createBookRecommends.vue')},
    // {path:'/pc/bookRecommends/updateBookRecommends', component: () => import('@/pc/business/books/view/bookRecommends/updateBookRecommends.vue')},
    {path:'/pc/bookRecommends/showBookContent', component: () => import('@/pc/business/books/view/bookRecommends/showBookContent.vue')}
]
