<template>
  <!-- 模板的头部、导航栏等其他部分 -->
  <!-- Header top area start -->
  <header>
    <div class="header-top">
      <div class="container">
        <div class="row justify-content-between align-items-center">
          <div class="col">
            <div class="welcome-text">
              <p>OneDay Library</p>
            </div>
          </div>
          <div class="col d-none d-lg-block">
            <div class="top-nav">
              <ul>
                <li><a href="tel:+86 0631-3806000"><i class="fa fa-phone"></i> +86 0631-3806000</a></li>
                <li><a href="mailto:whyjs@bjtu.edu.cn"><i class="fa fa-envelope-o"></i> whyjs@bjtu.edu.cn</a></li>
                <li><a href="my-account.html"><i class="fa fa-user"></i> Account</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- Header top area end -->
  <!-- breadcrumb-area start -->
  <div class="breadcrumb-area">
    <div class="container">
      <div class="row align-items-center justify-content-center">
        <div class="col-12 text-center">
          <h2 class="breadcrumb-title">Login</h2>
          <!-- breadcrumb-list start -->
          <ul class="breadcrumb-list">
            <li class="breadcrumb-item"><a href="index.html">ashley</a></li>
            <li class="breadcrumb-item active">Login</li>
          </ul>
          <!-- breadcrumb-list end -->
        </div>
      </div>
    </div>
  </div>
  <!-- breadcrumb-area end -->

  <!-- 登录区域 -->
  <div v-if="!isWeCom" class="login-register-area pt-100px pb-100px">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 col-md-12 ml-auto mr-auto">
          <div class="login-register-wrapper">
            <!-- Start (login/register)navigater -->
            <div class="login-register-tab-list nav">
              <a class="active" data-bs-toggle="tab" href="javascript:void(0)">
                <h4>login</h4>
              </a>
              <a data-bs-toggle="tab"  @click="toRegisterPage">
                <h4>register</h4>
              </a>
            </div>
            <!-- End (login/register)navigater -->

            <!-- Vue组件的登录表单 -->
            <div class="login-form-container">
              <div class="login-register-form">
                <form>
                  <input type="text" name="username" placeholder="Username" v-model="usernameRef">
                  <input type="password" name="password" placeholder="Password" v-model="passwordRef">
                  <div class="button-box">
                    <button type="button" @click="handleLogin">Login</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Footer Area Start -->
  <div class="footer-area">
    <div class="footer-container">
      <div class="footer-top">
        <div class="container">
          <div class="row">
            <!-- Start Footer Logo -->
            <div class="col-md-6 col-lg-3 mb-md-30px mb-lm-30px">
              <div class="single-wedge">
                <div class="footer-logo">
                  <a href="index.html"><img src="@/assets/images/logo/footer-logo.png" alt="Footer Logo Not Found"></a>
                </div>
                <p class="about-text">Our Product One Day Library</p>
              </div>
            </div>
            <!-- End Footer Logo -->

            <!-- Start Developer Name -->
            <div class="col-md-6 col-lg-3 col-sm-6 mb-lm-30px pl-lg-60px">
              <div class="single-wedge">
                <h4 class="footer-herading">Developer</h4>
                <div class="footer-links">
                  <div class="footer-row">
                    <ul class="align-items-center">
                      <li class="li"><a class="single-link" href="javascript:void(0)">Chen Yijun</a></li>
                      <li class="li"><a class="single-link" href="javascript:void(0)">Liu Xinying</a></li>
                      <li class="li"><a class="single-link" href="javascript:void(0)">Qiu Shenglan</a></li>
                      <li class="li"><a class="single-link" href="javascript:void(0)">Peng Shuo</a></li>
                      <li class="li"><a class="single-link" href="javascript:void(0)">Chen Jingxuan</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <!-- End Developer Name -->

            <!-- Start Email Address -->
            <div class="col-md-6 col-lg-3 col-sm-6 mb-lm-30px pl-lg-40px">
              <div class="single-wedge">
                <h4 class="footer-herading">Contact Us</h4>
                <!-- p class="phone">Phone/Fax:<a href="tel:13779935092"> 13779935092</a></p -->
                <div class="footer-links">
                  <div class="footer-row">
                    <ul class="align-items-center">
                      <li class="li"><a class="single-link" href="mailto:20722047@bjtu.edu.cn">20722047@bjtu.edu.cn</a></li>
                      <li class="li"><a class="single-link" href="mailto:20721054@bjtu.edu.cn">20721054@bjtu.edu.cn</a></li>
                      <li class="li"><a class="single-link" href="mailto:20726064@bjtu.edu.cn">20726064@bjtu.edu.cn</a></li>
                      <li class="li"><a class="single-link" href="mailto:20722101@bjtu.edu.cn">20722101@bjtu.edu.cn</a></li>
                      <li class="li"><a class="single-link" href="mailto:20722045@bjtu.edu.cn">20722045@bjtu.edu.cn</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <!-- End Email Address -->

            <!-- Start Institution Info -->
            <div class="col-md-6 col-lg-3 col-sm-12">
              <div class="single-wedge">
                <h4 class="footer-herading">Institution Info</h4>
                <div class="footer-links">
                  <!-- Text area -->
                  <p class="single-link"><a href="https://bjtu.edu.cn"> Beijing Jiao Tong University</a></p>
                  <p class="single-link"><a href="https://www.lancaster.ac.uk/"> Lancaster University</a></p>
                  <p class="address"> LUC-BJTU Weihai Campus</p>
                  <p class="address"> 69, XianDai Road</p>
                  <p class="address"> XiaoGuan WenDeng</p>
                  <p class="address"> Weihai Shandong China</p>
                  <!-- Text area  End -->
                </div>
              </div>
            </div>
            <!-- End  Institution Info  -->
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer Area End -->
  <!-- 模板的页脚等其他部分 -->
</template>
<script setup lang="ts">
import {login, usernameRef, passwordRef,} from '@/common/LoginHook'
import {isWeCom} from 'check-platform'
import router from "@/common/router";
async function handleLogin(){
  await login()
  location.assign('/pc/main')
}
async function toRegisterPage() {
  // Replace '/register' with the actual route for your registration page
  // For example, if your registration page is '/register', use:
  // location.assign('/register')
  location.assign('/pc/register')

  // router.push({path:'/pc/register'})

}
</script>


<style scoped>
@import 'src/assets/css/plugins.min.css';
@import "src/assets/css/style.min.css";
@keyframes backgroundSlide {
  0%, 33% {
    background-image: url('src/assets/images/about/01.webp');
  }
  34%, 66% {
    background-image: url('src/assets/images/about/02.webp');
  }
  67%, 100% {
    background-image: url('src/assets/images/about/03.webp');
  }
}

.breadcrumb-area {
  background-color: #cad5e1;
  background-repeat: no-repeat;
  background-position: center center;
  border-bottom-width: 0;
  height: 406px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -ms-flex-direction: column;
  flex-direction: column;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  background-size: cover;
  line-height: 1;
  animation: backgroundSlide 9s ease-in-out infinite;
}

/* 媒体查询和其他样式 */
@media only screen and (max-width: 767px), only screen and (min-width: 768px) and (max-width: 991px), only screen and (min-width: 992px) and (max-width: 1199px) {
  .breadcrumb-area { height: 300px; }
}

@media only screen and (max-width: 575px) {
  .breadcrumb-area { height: 260px; }
}

.breadcrumb-area .breadcrumb-title {
  font-weight: 400;
  text-transform: capitalize;
  font-size: 60px;
  color: #000;
  margin: 0;
}

@media only screen and (min-width: 768px) and (max-width: 991px) {
  .breadcrumb-area .breadcrumb-title { font-size: 42px; }
}

@media only screen and (max-width: 767px) {
  .breadcrumb-area .breadcrumb-title { font-size: 36px; }
}

.breadcrumb-list li {
  display: inline-block;
  /* 其他样式 */
}
</style>
