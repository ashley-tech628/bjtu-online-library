import axiosInstance from "@/framework/axios";
import router from "@/common/router";
import {isMobile} from 'react-device-detect'
import {reactive, ref, unref, toRaw} from "vue";
import {encrypt, decrypt} from "@/framework/crypto";
import {isWeCom} from 'check-platform'
let indexPage = ''
// function setIndexPage(indexPageUri: any){
//     sessionStorage.setItem('indexPage', indexPageUri)
//     indexPage = indexPageUri
//     console.log('wwwwwww',indexPage)
// }
// function getIndexPage(){
//     return sessionStorage.getItem('indexPage')
// }
const usernameRef = ref('')
const passwordRef = ref('')

function toLogin() {
    const locationPathname = window.location.pathname
    console.log('aaa', locationPathname)
    const arr = locationPathname.split('/')
    //arr: ['', 'pc', 'main']
    const prefix = '/' + arr[1]
    console.log('prefix is ' + prefix)
    let suffix = '/login'
    if(isWeCom){
        suffix = '/wecom/login'
    }
    const url = prefix + suffix
    console.log('url is ' + url)
    location.assign(url)
    console.log('pupupupu')
}

async function login() {
    const username = usernameRef.value
    const password = passwordRef.value
    const resp = await axiosInstance({
        method: 'post',
        url: '/login',
        data: {username, password},
        headers: {'content-type': 'application/x-www-form-urlencoded'},
    })
    console.log('hhh', resp)
    onLogin(resp)
}

function onLogin(resp: any) {
    const data = resp.data.result
    const tokenKey = data.tokenKey
    const authorityArr = data.authorities
    console.log('resp1: ', resp.data)
    sessionStorage.setItem('tokenKey', tokenKey)
    const encryptAuthorityArrStr = encrypt(authorityArr)
    sessionStorage.setItem('authorityArrStr', encryptAuthorityArrStr)
}

function onLogout() {
    sessionStorage.setItem('tokenKey', '')
    sessionStorage.setItem('authorityArrStr', '')
    window.location.href = '/login'
}

function openWecomLoginUrl(redirectUri: any) {
    const appId: any = import.meta.env.VITE_WECOM_APP_ID || ''
    const agentId: any = import.meta.env.VITE_WECOM_AGENT_ID || ''
    const scope: any = 'snsapi_base'
    const state: any = 'leavequery'
    const url = `https://open.weixin.qq.com/connect/oauth2/authorize?appid=${appId}&redirect_uri=${redirectUri}&response_type=code&scope=${scope}&agentid=${agentId}&state=${state}#wechat_redirect`;
    location.assign(url)
}

export {
    usernameRef, passwordRef,
    toLogin, onLogin, login, openWecomLoginUrl, onLogout
}
