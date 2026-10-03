import type {RouteRecordRaw} from 'vue-router'
import {createRouter, createWebHistory} from 'vue-router'

const mobileRouteArr: Record<string, unknown> = import.meta.glob('@/mobile/business/**/router/*.ts', {eager: true})
const pcRouteArr: Record<string, unknown> = import.meta.glob('@/pc/business/**/router/*.ts', {eager: true})
const mobileArr = getRouterArr(mobileRouteArr)
const pcArr = getRouterArr(pcRouteArr)

console.log("pcArr: ", pcArr)

function getRouterArr(routeArr: Record<string, unknown>): RouteRecordRaw[] {
    let arr: RouteRecordRaw[] = []
    Object.keys(routeArr).map(ele => {
        const mod = routeArr[ele] as Record<string, RouteRecordRaw[]>
        Object.keys(mod).map(ss => {
            const uu = mod[ss]
            arr.push(...uu)
            // console.log('uu',arr)
        })
    })
    return arr
}

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        ///wecomIndex接入企业微信
        {path: '/wecomIndex', component: () => import('@/common/wecom/index.vue')},
        {path: '/wecomLogin', component: () => import('@/common/wecom/login.vue')},

        {path: '', redirect: '/pc/login'},

        {path: '/mobile/menu', component: () => import('@/mobile/common/menu.vue')},

        {path: '/mobile/login', component: () => import('@/mobile/common/login/login.vue')},
        {path: '/mobile/wecom/login', component: () => import('@/mobile/common/login/wecom/login.vue')},
        {path: '/mobile/register', redirect: '/pc/register'},
        {path: '/mobile/wecom/loginCallBack', component: () => import('@/mobile/common/login/wecom/loginCallBack.vue')},
        {path: '/mobile/main', component: () => import('@/mobile/common/main.vue'),
            children: [
                ...mobileArr
            ]
        },
        {path: '/pc/login', component: () => import('@/pc/common/login/login.vue')},
        {path: '/pc/register', component: () => import('@/pc/common/register/register.vue')},
        {path: '/pc/main/bookshelf', component: () => import('@/pc/common/bookshelf.vue')},
        {path: '/pc/main/allBooks', component: () => import('@/pc/common/bookshelf.vue')},
        {path: '/pc/main/myAccount', component: () => import('@/pc/common/myAccount.vue')},
        {path: '/pc/main/editMyAccount', component: () => import('@/pc/common/AccountEdit.vue')},

        {path: '/pc/main/category', component: () => import('@/pc/common/book_category.vue')},

        {path: '/pc/main/bookInfo/:bookId',
            component: () => import('@/pc/common/book_info.vue'),
            props: true
        },

        {path: '/pc/wecom/login', component: () => import('@/pc/common/login/wecom/login.vue')},
        {path: '/pc/wecom/loginCallBack', component: () => import('@/pc/common/login/wecom/loginCallBack.vue')},
        {path: '/pc/main', component: () => import('@/pc/common/main.vue'),
            children: [
                {path: '/pc/empty', component: () => import('@/framework/empty.vue')},
                ...pcArr
            ]
        },
    ]
})
console.log('route', router.getRoutes())
export default router
