<template>
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
            <li class="breadcrumb-item"><a href="homepage_user">Home</a></li>
            <li class="breadcrumb-item active">Login</li>
          </ul>
          <!-- breadcrumb-list end -->
        </div>
      </div>
    </div>
  </div>
  <!-- breadcrumb-area end -->

  <!-- Register Start-->
  <div v-if="!isWeCom" class="login-register-area pt-100px pb-100px">
    <div class="container">
      <div class="row">
        <div class="col-lg-7 col-md-12 ml-auto mr-auto">
          <div class="login-register-wrapper">

            <!-- Start (login/register)navigater -->
            <div class="login-register-tab-list nav">
              <a data-bs-toggle="tab" @click="toLoginPage">
                <h4>login</h4>
              </a>
              <a class="active" data-bs-toggle="tab" href="javascript:void(0)" @click = "toLoginPage">
                <h4>register</h4>
              </a>
            </div>
            <!-- End (login/register)navigater -->

            <!-- Start Register Info -->
            <div class="login-form-container">
              <div class="login-register-form">
                <form>
                  <input type="text" placeholder="Username" v-model="authUserEntity.username">
                  <input type="text" placeholder="Password" v-model="authUserEntity.password">
                  <input type="text" placeholder="Real Name" v-model="authUserEntity.realName" >
                  <input type="text" placeholder="Avatar Picture" v-model="authUserEntity.avatarGroupId">
                  <input type="text" placeholder="Phone Number" v-model="authUserEntity.mobile">
                  <input type="text" placeholder="Remark" v-model="authUserEntity.remark">
                  <div class="button-box">
                    <button type="button" @click="submitRegistration">Submit</button>
                  </div>
                </form>
              </div>
            </div>
            <!-- End Register Info -->
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Register End -->

  <!--
  <div>
    <div>Username: <input type="text" v-model="authUserEntity.username" /></div>
    <div>Password: <input type="text" v-model="authUserEntity.password" /></div>
    <div>Real Name: <input type="text" v-model="authUserEntity.realName" /></div>
    <div>Avatar Picture: <input type="text" v-model="authUserEntity.avatarGroupId" /></div>
    <div>Phone Number: <input type="text" v-model="authUserEntity.mobile" /></div>
    <div>Remark : <input type="text" v-model="authUserEntity.remark" /></div>
    <div><button @click="submitRegistration">Submit</button></div>
  </div>
  -->
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
                  <a href="javascript:void(0)"><img src="@/assets/images/logo/footer-logo.png" alt="Footer Logo Not Found"></a>
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
  <!--  <div>-->
  <!--    <div>Username: <input type="text" v-model="authUserEntity.username" /></div>-->
  <!--    <div>Password: <input type="text" v-model="authUserEntity.password" /></div>-->
  <!--    <div>Real Name: <input type="text" v-model="authUserEntity.realName" /></div>-->
  <!--    <div>Avatar Picture: <input type="text" v-model="authUserEntity.avatarGroupId" /></div>-->
  <!--    <div>Phone Number: <input type="text" v-model="authUserEntity.mobile" /></div>-->
  <!--    <div>Remark : <input type="text" v-model="authUserEntity.remark" /></div>-->
  <!--&lt;!&ndash;    <div>�Ƿ�����: <input type="text" v-model="authUserEntity.isValid" /></div>&ndash;&gt;-->
  <!--&lt;!&ndash;    <div>�����: <input type="text" v-model="authUserEntity.sortNum" /></div>&ndash;&gt;-->
  <!--    <div><button @click="submitRegistration">Submit</button></div>-->
  <!--  </div>-->
</template>


<script setup lang="ts">
import { useCreateAuthUser } from '@/pc/business/auth/hook/authUserHook';
import { useCreateUserDetails } from '@/pc/business/userDetails/hook/userDetailsHook';
import axiosInstance from "@/framework/axios";
import {reactive, ref, toRaw} from 'vue';
import router from "@/common/router";
// import BCryptPasswordEncoder from '@/springsecurity/configure/SecurityConfig'

import {useCreateAuthUserRoleRel} from '@/pc/business/auth/hook/authUserRoleRelHook'
const {initCreate, authUserRoleRelRelateList, authUserRoleRelEntity, createAuthUserRoleRel} = useCreateAuthUserRoleRel()
const { initCreate: initCreateAuthUser, authUserEntity, createAuthUser } = useCreateAuthUser()
// const { initCreate: initCreateUserDetails, userDetailsEntity, createUserDetails} = useCreateUserDetails()
import {usePageBookshelfNew2} from '@/pc/business/bookshelf/hook/bookshelfHook'
import {toLogin} from "@/common/LoginHook";

const {bookshelfParam, bookshelfEntity, bookshelfEntityList, initPage, setPageNo}=usePageBookshelfNew2()



// Initialize the registration form
initCreate()
initCreateAuthUser()
// initCreateUserDetails()
initPage()

function generateRandomNumber() {
  return Math.floor(1000000 + Math.random() * 9000000);
}
function toLoginPage()
{
  router.push({path:'/pc/login'});
}

// Function to submit the registration form
async function submitRegistration() {

  const userId = generateRandomNumber();
  authUserEntity.isValid = 1;
  authUserEntity.sortNum = 1;
  authUserEntity.id = userId;
  // authUserEntity.password = authUserEntity.password;

  axiosInstance.post('/authUser' + '/create', toRaw(authUserEntity))

  authUserRoleRelEntity.userId = userId;
  authUserRoleRelEntity.roleId = 2;
  authUserRoleRelEntity.isValid = 1;
  authUserRoleRelEntity.sortNum = 1;

  axiosInstance.post('/authUserRoleRel' + '/create', toRaw(authUserRoleRelEntity))

  bookshelfEntity.id = userId;
  bookshelfEntity.name = authUserEntity.username;
  bookshelfEntity.allbooks = "{}";

  axiosInstance.post('/bookshelf' + '/create', toRaw(bookshelfEntity))

  console.log("bsID: "+bookshelfEntity.id);

 router.push({path:'/pc/login'})

}
</script>

<style scoped>
@import "@/assets/css/plugins.min.css";
@import "@/assets/css/style.min.css";

.breadcrumb-area {

  align-items: center;
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
  background-size: cover;
  line-height: 1;
  animation: backgroundSlide 9s ease-in-out infinite;
}

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
}
</style>