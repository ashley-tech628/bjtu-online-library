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
              <li><a href="/pc/main/myAccount"><i class="fa fa-user"></i> Account</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Header top area end -->
  </header>
  <!-- Header action area start -->
  <header>
  <div class="header-bottom  d-none d-lg-block">
    <div class="container">
      <div class="row justify-content-between align-items-center">
        <div class="col-lg-3 col">
          <div class="header-logo">
            <a href="../../../index.html"><img src="../../assets/images/logo/logo.png" alt="Site Logo" /></a>
          </div>
        </div>
        <div class="col-lg-6 d-none d-lg-block">
          <div class="search-element">
            <form action="#">
              <input type="text" placeholder="Search" />
              <button><i class="pe-7s-search"></i></button>
            </form>
          </div>
        </div>
        <div class="col-lg-3 col">
          <div class="header-actions">
            <!-- Single Wedge Start -->
            <a href="#offcanvas-wishlist" class="header-action-btn offcanvas-toggle">
              <i class="pe-7s-like"></i>
            </a>
            <!-- Single Wedge End -->
            <a href="#offcanvas-cart" class="header-action-btn header-action-btn-cart offcanvas-toggle pr-0">
              <i class="pe-7s-shopbag"></i>
              <span class="header-action-num">01</span>
              <!-- <span class="cart-amount">��30.00</span> -->
            </a>
            <a href="#offcanvas-mobile-menu" class="header-action-btn header-action-btn-menu offcanvas-toggle d-lg-none">
              <i class="pe-7s-menu"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Header action area end -->
  </header>
  <!-- Header action area start -->
  <header>
  <div class="header-bottom d-lg-none sticky-nav style-1">
    <div class="container">
      <div class="row justify-content-between align-items-center">
        <div class="col-lg-3 col">
          <div class="header-logo">
            <a href="../../../index.html"><img src="../../assets/images/logo/logo.png" alt="Site Logo" /></a>
          </div>
        </div>
        <div class="col-lg-6 d-none d-lg-block">
          <div class="search-element">
            <form action="#">
              <input type="text" placeholder="Search" />
              <button><i class="pe-7s-search"></i></button>
            </form>
          </div>
        </div>
        <div class="col-lg-3 col">
          <div class="header-actions">
            <!-- Single Wedge Start -->
            <a href="#offcanvas-wishlist" class="header-action-btn offcanvas-toggle">
              <i class="pe-7s-like"></i>
            </a>
            <!-- Single Wedge End -->
            <a href="#offcanvas-cart" class="header-action-btn header-action-btn-cart offcanvas-toggle pr-0">
              <i class="pe-7s-shopbag"></i>
              <span class="header-action-num">01</span>
              <!-- <span class="cart-amount">��30.00</span> -->
            </a>
            <a href="#offcanvas-mobile-menu" class="header-action-btn header-action-btn-menu offcanvas-toggle d-lg-none">
              <i class="pe-7s-menu"></i>
            </a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Header action area end -->
  </header>
  <!-- header navigation area start -->
  <header>
  <div class="header-nav-area d-none d-lg-block sticky-nav">
    <div class="container">
      <div class="header-nav">
        <div class="main-menu position-relative">
          <ul>
            <li class="dropdown"><a href="#">Category <i class="fa fa-angle-down"></i></a>
              <ul class="sub-menu">
                <li><a href="book_category.html">Earth Sciences</a></li>
                <li><a href="book_category.html">Health & Fitness</a></li>
                <li><a href="book_category.html">Nature, Animals & Pets</a></li>
              </ul>
            </li>
            <li><a href="bookshelf.html">Bookshelf</a></li>
            <li><a href="homepage.html">Search</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- header navigation area end -->
  </header>

  <div class="mobile-search-box d-lg-none">
    <div class="container">
      <!-- mobile search start -->
      <div class="search-element max-width-100">
        <form action="#">
          <input type="text" placeholder="Search" />
          <button><i class="pe-7s-search"></i></button>
        </form>
      </div>
      <!-- mobile search end -->
    </div>
  </div>


  <!-- offcanvas overlay start -->
  <div class="offcanvas-overlay"></div>
  <!-- offcanvas overlay end -->

  <!-- OffCanvas Wishlist Start -->
  <div id="offcanvas-wishlist" class="offcanvas offcanvas-wishlist">
    <div class="inner">
      <div class="head">
        <span class="title">Wishlist</span>
        <button class="offcanvas-close">��</button>
      </div>
      <div class="body customScroll">
        <ul class="minicart-product-list">
          <li>
            <a href="single-product.html" class="image"><img src="../../assets/images/product-image/1.webp" alt="Cart product Image"></a>
            <div class="content">
              <a href="single-product.html" class="title">Modern Smart Phone</a>
              <span class="quantity-price">1 x <span class="amount">$21.86</span></span>
              <a href="#" class="remove">��</a>
            </div>
          </li>
          <li>
            <a href="single-product.html" class="image"><img src="../../assets/images/product-image/2.webp" alt="Cart product Image"></a>
            <div class="content">
              <a href="single-product.html" class="title">Bluetooth Headphone</a>
              <span class="quantity-price">1 x <span class="amount">$13.28</span></span>
              <a href="#" class="remove">��</a>
            </div>
          </li>
          <li>
            <a href="single-product.html" class="image"><img src="../../assets/images/product-image/3.webp" alt="Cart product Image"></a>
            <div class="content">
              <a href="single-product.html" class="title">Smart Music Box</a>
              <span class="quantity-price">1 x <span class="amount">$17.34</span></span>
              <a href="#" class="remove">��</a>
            </div>
          </li>
        </ul>
      </div>
      <div class="foot">
        <div class="buttons">
          <a href="wishlist.html" class="btn btn-dark btn-hover-primary mt-30px">view wishlist</a>
        </div>
      </div>
    </div>
  </div>
  <!-- OffCanvas Wishlist End -->

  <!-- OffCanvas Menu Start -->
  <div id="offcanvas-mobile-menu" class="offcanvas offcanvas-mobile-menu">
    <button class="offcanvas-close"></button>
    <div class="user-panel">
      <ul>
        <li><a href="tel:0123456789"><i class="fa fa-phone"></i> +012 3456 789</a></li>
        <li><a href="mailto:demo@example.com"><i class="fa fa-envelope-o"></i> demo@example.com</a></li>
        <li><a href="my-account.html"><i class="fa fa-user"></i> Account</a></li>
      </ul>
    </div>
  </div>
  <!-- OffCanvas Menu End -->

  <!-- breadcrumb-area start -->
  <div class="breadcrumb-area">
    <div class="container">
      <div class="row align-items-center justify-content-center">
        <div class="col-12 text-center">
          <h2 class="breadcrumb-title">Book Details</h2>
          <!-- breadcrumb-list start -->
          <ul class="breadcrumb-list">
            <li class="breadcrumb-item"><a href="/pc/main">Home</a></li>
            <li class="breadcrumb-item active">Book</li>
          </ul>
          <!-- breadcrumb-list end -->
        </div>
      </div>
    </div>
  </div>
  <!-- breadcrumb-area end -->

  <!-- Product Details Area Start -->
  <div class="product-details-area pt-100px pb-100px">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-sm-12 col-xs-12 mb-lm-30px mb-md-30px mb-sm-30px">
          <!-- Swiper -->
          <div class="swiper-container zoom-top">
            <div class="swiper-wrapper">
              <div class="swiper-slide">
                <template v-for="(item,index2) in bookLibraryEntityList">
                <img v-if="item.id == bookId" class="img-responsive m-auto" :src="item.cover"/>
                  </template>
                  <a class="venobox full-preview" data-gall="myGallery" href="../../assets/images/product-image/fe3a87b8d008e8bff6dadac1b91084b.jpg" alt="Cover">
                  <i class="fa fa-arrows-alt" aria-hidden="true"></i>
                </a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-6 col-sm-12 col-xs-12" data-aos="fade-up" data-aos-delay="200">
          <template v-for="(item,index2) in bookLibraryEntityList">
          <div class="product-details-content quickview-content ml-25px">

                <h2 v-if="item.id == bookId"> {{item.title}} </h2>
                <div v-if="item.id == bookId" class="pricing-meta">
                  <ul class="d-flex">
<!--                    <li class="new-price">{{ item.author }}</li>-->
                  </ul>
                </div>
                <div v-if="item.id == bookId" class="pro-details-rating-wrap">
                  <div class="rating-product">
<!--                    <i v-for="star in randomStars" :key="star" class="fa fa-star"></i>-->
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                </div>
                <p class="mt-30px" v-if="item.id == bookId">{{ item.author }}</p>

                <div v-if="item.id == bookId" class="pro-details-categories-info pro-details-same-style d-flex m-0">
                  <span></span>
                  <ul class="d-flex">
                    <br>
                  </ul>
                </div>
                <div v-if="item.id == bookId" class="pro-details-categories-info pro-details-same-style d-flex m-0">
                  <span>Categories: </span>
                  <ul class="d-flex">
                    <li>
                      <a href="#">{{ item.type }}</a>
                    </li>
                  </ul>
                </div>
                <div v-if="item.id == bookId" class="pro-details-categories-info pro-details-same-style d-flex m-0">
                  <span> </span>
                  <ul class="d-flex">
                    <br>
                  </ul>
                </div>
              <template v-for="(item2,index) in bookshelfEntityList">
                <template v-if="item2.id == authUserEntity.id">
                <div  v-if="item.id == bookId" class="pro-details-quality">
                  <div class="pro-details-cart">
                    <button @click = "addToBookshelf(item2, item.id, item.title)" class="add-cart"> Confirm Borrow</button>
                  </div>
                </div>
                </template>
              </template>
<!--              </template>-->
          </div>

          <!-- product details description area start -->

          <div v-if="item.id == bookId" class="description-review-wrapper">
            <div class="description-review-topbar nav">
              <button data-bs-toggle="tab" data-bs-target="#des-details2">Information</button>
              <button class="active" data-bs-toggle="tab" data-bs-target="#des-details1">Description</button>
            </div>
            <div class="tab-content description-review-bottom">
              <div id="des-details2" class="tab-pane">
                <div class="product-anotherinfo-wrapper text-start">
                  <ul>
                    <li><span>OneDay ID: </span>{{ item.id }}</li>
                    <li><span>Publication Time: </span>{{ item.publicationTime }}</li>
                    <li><span>Category: </span>{{ item.type }}</li>
                  </ul>
                </div>
              </div>
              <div id="des-details1" class="tab-pane active">
                <div class="product-description-wrapper">
                  <p>
                    {{ truncateDescription(item.description) }}
                    <span v-if="isTruncated(item.description)">  </span>
                      <button  @click="toggleFullDescription">
                        {{ showFullDescription ? 'Collapse' : 'Expand' }}
                      </button>
<!--                    {{item.description}}-->
                  </p>
                </div>
              </div>
            </div>
          </div>
          <!-- product details description area end -->
          </template>

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
            <!-- Start single blog -->
            <div class="col-md-6 col-lg-3 mb-md-30px mb-lm-30px">
              <div class="single-wedge">
                <div class="footer-logo">
                  <a href="../../../index.html"><img src="../../assets/images/logo/footer-logo.png" alt="Footer Logo"></a>
                </div>
                <p class="about-text">Our Product One Day Library</p>
                <ul class="link-follow">
                  <li>
                    <a class="m-0" title="Twitter" target="_blank" rel="noopener noreferrer" href="#"><i class="fa fa-facebook"
                                                                                                         aria-hidden="true"></i></a>
                  </li>
                  <li>
                    <a title="Tumblr" target="_blank" rel="noopener noreferrer" href="#"><i class="fa fa-tumblr" aria-hidden="true"></i>
                    </a>
                  </li>
                  <li>
                    <a title="Facebook" target="_blank" rel="noopener noreferrer" href="#"><i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                  </li>
                  <li>
                    <a title="Instagram" target="_blank" rel="noopener noreferrer" href="#"><i class="fa fa-instagram" aria-hidden="true"></i>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <!-- End single blog -->

            <!-- Start single blog -->
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
            <!-- End single blog -->
            <!-- Start single blog -->
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
            <!-- End single blog -->
            <!-- Start single blog -->
            <div class="col-md-6 col-lg-3 col-sm-12">
              <div class="single-wedge">
                <h4 class="footer-herading">Institution Info</h4>
                <div class="footer-links">
                  <!-- News letter area -->
                  <p class="single-link"><a href="https://bjtu.edu.cn"> Beijing Jiao Tong University</a></p>
                  <p class="single-link"><a href="https://www.lancaster.ac.uk/"> Lancaster University</a></p>
                  <p class="address"> LUC-BJTU Weihai Campus</p>
                  <p class="address"> 69, XianDai Road</p>
                  <p class="address"> XiaoGuan WenDeng</p>
                  <p class="address"> Weihai Shandong China</p>
                  <!-- News letter area  End -->
                </div>
              </div>
            </div>
            <!-- End single blog -->
          </div>
        </div>
      </div>

    </div>
  </div>
  <!-- Footer Area End -->
</template>

<script lang="ts" setup>

import {usePageBookLibrary} from "@/pc/business/bookLibrary/hook/bookLibraryHook";
import {usePageBookshelfNew} from "@/pc/business/bookshelf/hook/bookshelfHook";
const { bookId } = defineProps(['bookId']);
const {hasPerm, toShow, initPage, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
  setPageNo: setPageNo2, toCreate, toUpdate: toUpdate2, deleteBookLibrary, importExcel, exportExcel
}=usePageBookLibrary()

initPage()
// initTest()

import axiosInstance from "@/framework/axios";
import {useCreateAuthUser} from "@/pc/business/auth/hook/authUserHook";
import {ref, toRaw, computed } from "vue";
const {bookshelfParam, bookshelfEntity, bookshelfEntityList, initPage:initBookshelf, setPageNo, toUpdate}=usePageBookshelfNew()
const { initCreate: initCreateAuthUser, authUserEntity, createAuthUser } = useCreateAuthUser()

initBookshelf()
initCreateAuthUser()
function addToBookshelf(mybookshelfEntity, id, title)
{
  // �� mybookshelfEntity �⹹�� id �� name
  // ���� JSON �ַ���Ϊ����
  const allBooksObject = JSON.parse(mybookshelfEntity.allbooks);

  // ����һ���µ��鼮ID������򵥵�ʹ��ʱ�����
  // const newBookId = `book${Date.now()}`;

  // �������鵽����
  allBooksObject["book"+id] = title;

  // �����º�Ķ���ת���� JSON �ַ���
  mybookshelfEntity.allbooks = JSON.stringify(allBooksObject);

  // ����������鼮��Ϣ
  console.log("Added book:", id, title);

  // ʹ�� axios ���͸�������
  axiosInstance.post('/bookshelf'+'/update', toRaw(mybookshelfEntity));
}

initFunction()
async function initFunction()
{
  const response = await axiosInstance.post("/userDetails" + "/getID");
  authUserEntity.id = response.data;
  console.log("AID: "+authUserEntity.id);
  // console.log("userDetailsEntityList: "+userDetailsEntityList)
}
const randomStars = computed(() => {
  const minStars = 3;
  const maxStars = 5;
  const randomStarCount = Math.floor(Math.random() * (maxStars - minStars + 1)) + minStars;
  return Array.from({ length: randomStarCount }, (_, index) => index + 1);
});
const maxDescriptionLength = 500; // Set your desired maximum length
const showFullDescription = ref(false);

const truncateDescription = (description) => {
  return showFullDescription.value ? description : description.slice(0, maxDescriptionLength);
};

const isTruncated = (description) => description.length > maxDescriptionLength;

const toggleFullDescription = () => {
  showFullDescription.value = !showFullDescription.value;
};
</script>

<style scoped>
@import "src/assets/css/plugins.min.css";
@import "src/assets/css/style.min.css";


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

/* ý���ѯ��������ʽ */
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
  /* ������ʽ */
}

</style>