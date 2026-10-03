<template>
  <div class="main-wrapper">
    <header>
      <!-- Header top area start -->
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

      <!-- Header action area start -->
      <div class="header-bottom  d-none d-lg-block">
        <div class="container">
          <div class="row justify-content-between align-items-center">
            <div class="col-lg-3 col">
              <div class="header-logo">
                <a href="../../assets/html/index.html"><img src="@/assets/images/logo/logo.png" alt="Site Logo"/></a>
              </div>
            </div>
            <div class="col-lg-6 d-none d-lg-block">
              <div class="search-element">
                <form action="#">
                  <input type="text" placeholder="Search"/>
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
                  <!-- <span class="cart-amount">€30.00</span> -->
                </a>
                <a href="#offcanvas-mobile-menu"
                   class="header-action-btn header-action-btn-menu offcanvas-toggle d-lg-none">
                  <i class="pe-7s-menu"></i>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Header action area end -->
      <!-- header navigation area start -->
      <div class="header-nav-area d-none d-lg-block sticky-nav">
        <div class="container">
          <div class="header-nav">
            <div class="main-menu position-relative">
              <ul>
                <li class="dropdown"><a href="#">Category <i class="fa fa-angle-down"></i></a>
                  <ul class="sub-menu">
                    <li><a href="../../assets/html/login.html">Earth Sciences</a></li>
                    <li><a href="../../assets/html/login.html">Health & Fitness</a></li>
                    <li><a href="../../assets/html/login.html">Nature, Animals & Pets</a></li>
                  </ul>
                </li>
                <li><a href="/pc/main/bookshelf">Bookshelf</a></li>
                <li><a href="../../assets/html/wishlist.html">Search</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <!-- header navigation area end -->
      <div class="mobile-search-box d-lg-none">
        <div class="container">
          <!-- mobile search start -->
          <div class="search-element max-width-100">
            <form action="#">
              <input type="text" placeholder="Search"/>
              <button><i class="pe-7s-search"></i></button>
            </form>
          </div>
          <!-- mobile search start -->
        </div>
      </div>
    </header>
    <!-- offCanvas overlay start -->
    <div class="offcanvas-overlay"></div>
    <!-- offCanvas overlay end -->
    <!-- OffCanvas Wishlist Start -->
    <div id="offcanvas-wishlist" class="offcanvas offcanvas-wishlist">
      <div class="inner">
        <div class="head">
          <span class="title">Bookshelf</span>
          <button class="offcanvas-close">×</button>
        </div>
        <div class="body customScroll">
          <ul class="minicart-product-list">
            <li>
              <a href="../../assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/1.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="../../assets/html/single-product.html" class="title">Modern Smart Phone</a>
                <span class="quantity-price"><span class="amount">author</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="../../assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/2.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="../../assets/html/single-product.html" class="title">Bluetooth Headphone</a>
                <span class="quantity-price"><span class="amount">author</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="../../assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/3.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="../../assets/html/single-product.html" class="title">Smart Music Box</a>
                <span class="quantity-price"><span class="amount">author</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
          </ul>
        </div>
        <div class="foot">
          <div class="buttons">
            <a href="../../assets/html/wishlist.html" class="btn btn-dark btn-hover-primary mt-30px">view bookshelf</a>
          </div>
        </div>
      </div>
    </div>
    <!-- OffCanvas Wishlist End -->
    <!-- OffCanvas Cart Start -->
    <div id="offcanvas-cart" class="offcanvas offcanvas-cart">
      <div class="inner">
        <div class="head">
          <span class="title">Cart</span>
          <button class="offcanvas-close">×</button>
        </div>
        <div class="body customScroll">
          <ul class="minicart-product-list">
            <li>
              <a href="../../assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/1.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="../../assets/html/single-product.html" class="title">Modern Smart Phone</a>
                <span class="quantity-price">1 x <span class="amount">$18.86</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="../../assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/2.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="../../assets/html/single-product.html" class="title">Bluetooth Headphone</a>
                <span class="quantity-price">1 x <span class="amount">$43.28</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="../../assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/3.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="../../assets/html/single-product.html" class="title">Smart Music Box</a>
                <span class="quantity-price">1 x <span class="amount">$37.34</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
          </ul>
        </div>
        <div class="foot">
          <div class="buttons mt-30px">
            <a href="../../assets/html/cart.html" class="btn btn-dark btn-hover-primary mb-30px">view cart</a>
            <a href="../../assets/html/checkout.html" class="btn btn-outline-dark current-btn">checkout</a>
          </div>
        </div>
      </div>
    </div>
    <!-- OffCanvas Cart End -->
    <!-- OffCanvas Menu Start -->
    <div id="offcanvas-mobile-menu" class="offcanvas offcanvas-mobile-menu">
      <button class="offcanvas-close"></button>
      <div class="user-panel">
        <ul>
          <li><a href="tel:0123456789"><i class="fa fa-phone"></i> +012 3456 789</a></li>
          <li><a href="mailto:demo@example.com"><i class="fa fa-envelope-o"></i> demo@example.com</a></li>
          <li><a href="/pc/main/myAccount"><i class="fa fa-user"></i> Account</a></li>
        </ul>
      </div>
      <div class="inner customScroll">
        <div class="offcanvas-menu mb-4">
          <ul>
            <li><a href="/pc/main"><span class="menu-text">Home</span></a>
              <ul class="sub-menu">
                <li><a href="/pc/main"><span class="menu-text">Home 1</span></a></li>
                <li><a href="/pc/main"><span class="menu-text">Home 2</span></a></li>
              </ul>
            </li>
            <li><a href="about.html">About</a></li>
            <li>
              <a href="#"><span class="menu-text">Pages</span></a>
              <ul class="sub-menu">
                <li>
                  <a href="#"><span class="menu-text">Inner Pages</span></a>
                  <ul class="sub-menu">
                    <li><a href="404.html">404 Page</a></li>
                    <li><a href="order-tracking.html">Order Tracking</a></li>
                    <li><a href="faq.html">Faq Page</a></li>
                    <li><a href="coming-soon.html">Coming Soon Page</a></li>
                  </ul>
                </li>
                <li>
                  <a href="#"><span class="menu-text"> Other Shop Pages</span></a>
                  <ul class="sub-menu">
                    <li><a href="cart.html">Cart Page</a></li>
                    <li><a href="checkout.html">Checkout Page</a></li>
                    <li><a href="compare.html">Compare Page</a></li>
                    <li><a href="wishlist.html">Wishlist Page</a></li>
                  </ul>
                </li>
                <li>
                  <a href="#"><span class="menu-text">Related Shop Page</span></a>
                  <ul class="sub-menu">
                    <li><a href="my-account.html">Account Page</a></li>
                    <li><a href="login.html">Login & Register Page</a></li>
                    <li><a href="empty-cart.html">Empty Cart Page</a></li>
                    <li><a href="thank-you-page.html">Thank You Page</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li class="dropdown position-static"><a href="#">Shop <i
                class="fa fa-angle-down"></i></a>
              <ul class="mega-menu d-block">
                <li class="d-flex">
                  <ul class="d-block">
                    <li class="title"><a href="#">Shop Page</a></li>
                    <li><a href="../../assets/html/shop-3-column.html">Shop 3 Column</a></li>
                    <li><a href="../../assets/html/shop-4-column.html">Shop 4 Column</a></li>
                    <li><a href="../../assets/html/shop-left-sidebar.html">Shop Left Sidebar</a></li>
                    <li><a href="../../assets/html/shop-right-sidebar.html">Shop Right Sidebar</a></li>
                    <li><a href="../../assets/html/shop-list-left-sidebar.html">Shop List Left Sidebar</a>
                    </li>
                    <li><a href="../../assets/html/shop-list-right-sidebar.html">Shop List Right Sidebar</a>
                    </li>
                  </ul>
                  <ul class="d-block">
                    <li class="title"><a href="#">product Details Page</a></li>
                    <li><a href="../../assets/html/single-product.html">Product Single</a></li>
                    <li><a href="../../assets/html/single-product-variable.html">Product Variable</a></li>
                    <li><a href="../../assets/html/single-product-affiliate.html">Product Affiliate</a></li>
                    <li><a href="../../assets/html/single-product-group.html">Product Group</a></li>
                    <li><a href="../../assets/html/single-product-tabstyle-2.html">Product Tab 2</a></li>
                    <li><a href="../../assets/html/single-product-tabstyle-3.html">Product Tab 3</a></li>
                  </ul>
                  <ul class="d-block">
                    <li class="title"><a href="#">Single Product Page</a></li>
                    <li><a href="../../assets/html/single-product-slider.html">Product Slider</a></li>
                    <li><a href="../../assets/html/single-product-gallery-left.html">Product Gallery Left</a></li>
                    <li><a href="../../assets/html/single-product-gallery-right.html">Product Gallery Right</a> </li>
                    <li><a href="../../assets/html/single-product-sticky-left.html">Product Sticky Left</a>
                    </li>
                    <li><a href="../../assets/html/single-product-sticky-right.html">Product Sticky Right</a>
                    </li>
                    <li><a href="../../assets/html/cart.html">Book Shelf Page</a></li>
                  </ul>
                  <ul class="d-block p-0 border-0">
                    <li class="title"><a href="#">Single Product Page</a></li>
                    <li><a href="../../assets/html/checkout.html">Checkout Page</a></li>
                    <li><a href="../../assets/html/compare.html">Compare Page</a></li>
                    <li><a href="../../assets/html/wishlist.html">Wishlist Page</a></li>
                    <li><a href="../../assets/html/my-account.html">Account Page</a></li>
                    <li><a href="../../assets/html/login.html">Login & Register Page</a></li>
                    <li><a href="../../assets/html/empty-cart.html">Empty Shelf Page</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li><a href="#"><span class="menu-text">Blog</span></a>
              <ul class="sub-menu">
                <li><a href="src/assets/blog-grid.html">Blog Grid Page</a></li>
                <li><a href="src/assets/blog-grid-left-sidebar.html">Grid Left Sidebar</a></li>
                <li><a href="src/assets/blog-grid-right-sidebar.html">Grid Right Sidebar</a></li>
                <li><a href="src/assets/blog-list.html">Blog List Page</a></li>
                <li><a href="src/assets/blog-list-left-sidebar.html">List Left Sidebar</a></li>
                <li><a href="src/assets/blog-list-right-sidebar.html">List Right Sidebar</a></li>
                <li><a href="src/assets/blog-single.html">Blog Single Page</a></li>
                <li><a href="src/assets/blog-single-left-sidebar.html">Single Left Sidebar</a></li>
                <li><a href="src/assets/blog-single-right-sidebar.html">Single Right Sidbar</a></li>
              </ul>
            </li>
            <li><a href="contact.html">Contact Us</a></li>
          </ul>
        </div>
        <!-- header navigation area end -->
        <!-- OffCanvas Menu End -->
        <div class="offcanvas-social mt-auto">
          <ul>
            <li>
              <a href="#"><i class="fa fa-facebook"></i></a>
            </li>
            <li>
              <a href="#"><i class="fa fa-twitter"></i></a>
            </li>
            <li>
              <a href="#"><i class="fa fa-google"></i></a>
            </li>
            <li>
              <a href="#"><i class="fa fa-youtube"></i></a>
            </li>
            <li>
              <a href="#"><i class="fa fa-instagram"></i></a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <!-- OffCanvas Menu End -->
    <!-- breadcrumb-area start -->
    <div class="breadcrumb-area">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-12 text-center">
            <h2 class="breadcrumb-title">bookshelf</h2>
            <!-- breadcrumb-list start -->
            <ul class="breadcrumb-list">
              <li class="breadcrumb-item"><a href="/pc/main">Home</a></li>
              <li class="breadcrumb-item active">bookshelf</li>
            </ul>
            <!-- breadcrumb-list end -->
          </div>
        </div>
      </div>
    </div>
    <!-- breadcrumb-area end -->
    <!-- Wishlist Area Start -->
    <div class="cart-main-area pt-100px pb-100px">
      <div class="container">
        <h3 class="cart-page-title">Your bookshelf</h3>
        <div class="row">
          <div class="col-lg-12 col-md-12 col-sm-12 col-12">
            <form action="#">
              <div class="table-content table-responsive cart-table-content">
                <table>
                  <thead>
                  <tr>
                    <th>Image</th>
                    <th>title</th>
                    <th>author</th>
                    <th>category</th>
                    <th>download</th>
                    <th>Action</th>
                  </tr>
                  </thead>
                  <tbody>
<!--                  <tr v-for="(item,index) in bookshelfEntityList" v-if="item.id == authUserEntity.id">-->


                <template v-for="(item,index) in bookshelfEntityList">
                  <template v-if="item.id == authUserEntity.id">
                    <tr v-for="([book, type]) in Object.entries(JSON.parse(item.allbooks))" :key="book">
<!--                      <td>-->
<!--                        {{book + type}}-->
<!--                      </td>-->
                      <template v-for="(item2,index2) in bookLibraryEntityList">

                        <td v-if="type == item2.title">
                          <a href="../../assets/html/single-product.html" class="image">
                            <img class="img-responsive ml-15px" :src="item2.cover"/>
<!--                            <img class="hover-image" :src="item2.cover" alt="Product" />-->
                          </a>
                        </td>
                        <td v-if="type == item2.title">
                          {{ item2.title }}
                        </td>
                        <td v-if="type == item2.title">
                          {{ item2.author}}
                        </td>
                        <td v-if="type == item2.title">
                          {{ item2.type}}
                        </td>
                        <td class="product-wishlist-cart" v-if="type == item2.title">
                          <a @click="downloadFile(item2.type,item2.title+'.pdf')">download</a>
                        </td>
                        <td class="product-remove" v-if="type == item2.title">
                          <a @click="deleteBook(item, book)"><i class="fa fa-times"></i></a>
                        </td>
                      </template>
                    </tr>

                  </template>

                </template>





<!--                  <tr v-for="(item,index) in bookshelfEntityList">-->
<!--                    <template v-if="item.id == authUserEntity.id">-->
<!--                      <td>{{JSON.parse(item.allbooks).book1}}</td>-->
<!--                      <td>-->
<!--                      &lt;!&ndash; 获取所有书籍和类型的信息 &ndash;&gt;-->
<!--                        <ul>-->
<!--                          <li v-for="([book, type]) in Object.entries(JSON.parse(item.allbooks))" :key="book">-->
<!--                            {{ book }}: {{ type }}-->
<!--                          </li>-->
<!--                        </ul>-->
<!--                      </td>-->
<!--                      <td>{{item.id}}</td>-->
<!--                      <td>{{item.name}}</td>-->
<!--                      <td>{{item.allbooks}}</td>-->
<!--                      <td>-->
<!--                        &lt;!&ndash;        <button @click="toShow(item)">check</button>&ndash;&gt;-->
<!--                        <button v-if="item.id == authUserEntity.id" @click="toUpdate(item)">change</button>-->
<!--                        &lt;!&ndash;        <button v-show="hasPerm('bookshelf.write')" @click="deleteBookshelf(item)">删除</button>&ndash;&gt;-->
<!--                      </td>-->
<!--                    </template>-->
<!--                  </tr>-->
                  <tr >
                    <td class="product-thumbnail">
                      <a href="#"><img class="img-responsive ml-15px" src="@/assets/images/product-image/3.webp"
                                       alt=""/></a>
                    </td>
                    <td class="product-name"><a href="#">NULL</a></td>
                    <td class="product-price-cart"><span class="amount">NULL</span></td>
                    <td class="product-name"><span class="amount">NULL</span></td>
                    <td class="product-name">
                      <a href="#">NULL</a>
                    </td>
                    <td class="product-remove">
                      <a href="/pc/main/category" @click="toAllBooks">TO ADD MORE</a>
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Shelf Area End -->
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
                    <a href="javascript:void(0)"><img src="@/assets/images/logo/footer-logo.png"
                                                      alt="Footer Logo Not Found"></a>
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
                  <div class="footer-links">
                    <div class="footer-row">
                      <ul class="align-items-center">
                        <li class="li"><a class="single-link"
                                          href="mailto:20722047@bjtu.edu.cn">20722047@bjtu.edu.cn</a></li>
                        <li class="li"><a class="single-link"
                                          href="mailto:20721054@bjtu.edu.cn">20721054@bjtu.edu.cn</a></li>
                        <li class="li"><a class="single-link"
                                          href="mailto:20726064@bjtu.edu.cn">20726064@bjtu.edu.cn</a></li>
                        <li class="li"><a class="single-link"
                                          href="mailto:20722101@bjtu.edu.cn">20722101@bjtu.edu.cn</a></li>
                        <li class="li"><a class="single-link"
                                          href="mailto:20722045@bjtu.edu.cn">20722045@bjtu.edu.cn</a></li>
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
  </div>
  <!-- Modal -->
  <div class="modal modal-2 fade" id="exampleModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-body">
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="pe-7s-close"></i>
          </button>
          <div class="row">
            <div class="col-lg-6 col-sm-12 col-xs-12 mb-lm-30px mb-md-30px mb-sm-30px">
              <!-- Swiper -->
              <div class="swiper-container gallery-top">
                <div class="swiper-wrapper">
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/zoom-image/1.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/zoom-image/2.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/zoom-image/3.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/zoom-image/4.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/zoom-image/5.webp" alt="">
                  </div>
                </div>
              </div>
              <div class="swiper-container gallery-thumbs mt-20px slider-nav-style-1 small-nav">
                <div class="swiper-wrapper">
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/small-image/1.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/small-image/2.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/small-image/3.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/small-image/4.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="@/assets/images/product-image/small-image/5.webp" alt="">
                  </div>
                </div>
                <!-- Add Arrows -->
                <div class="swiper-buttons">
                  <div class="swiper-button-next"></div>
                  <div class="swiper-button-prev"></div>
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-sm-12 col-xs-12" data-aos="fade-up" data-aos-delay="200">
              <div class="product-details-content quickview-content">
                <h2>Modern Smart Phone</h2>
                <div class="pricing-meta">
                  <ul class="d-flex">
                    <li class="new-price">$20.90</li>
                  </ul>
                </div>
                <div class="pro-details-rating-wrap">
                  <div class="rating-product">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <span class="read-review"><a class="reviews" href="#">( 2 Review )</a></span>
                </div>
                <p class="mt-30px">Lorem ipsum dolor sit amet, consecte adipisicing elit, sed do eiusmll tempor
                  incididunt ut labore et dolore magna aliqua. Ut enim ad mill veniam, quis nostrud exercitation ullamco
                  laboris nisi ut aliquip exet commodo consequat. Duis aute irure dolor</p>
                <div class="pro-details-categories-info pro-details-same-style d-flex m-0">
                  <span>SKU:</span>
                  <ul class="d-flex">
                    <li>
                      <a href="#">Ch-256xl</a>
                    </li>
                  </ul>
                </div>
                <div class="pro-details-categories-info pro-details-same-style d-flex m-0">
                  <span>Categories: </span>
                  <ul class="d-flex">
                    <li>
                      <a href="#">Smart Device, </a>
                    </li>
                    <li>
                      <a href="#">ETC</a>
                    </li>
                  </ul>
                </div>
                <div class="pro-details-categories-info pro-details-same-style d-flex m-0">
                  <span>Tags: </span>
                  <ul class="d-flex">
                    <li>
                      <a href="#">Smart Device, </a>
                    </li>
                    <li>
                      <a href="#">Phone</a>
                    </li>
                  </ul>
                </div>
                <div class="pro-details-quality">
                  <div class="cart-plus-minus">
                    <input class="cart-plus-minus-box" type="text" name="qtybutton" value="1"/>
                  </div>
                  <div class="pro-details-cart">
                    <button class="add-cart"> Add To
                      Cart
                    </button>
                  </div>
                  <div class="pro-details-compare-wishlist pro-details-wishlist ">
                    <a href="../../assets/html/wishlist.html"><i class="pe-7s-like"></i></a>
                  </div>
                </div>
                <div class="payment-img">
                  <a href="#"><img src="@/assets/images/icons/payment.png" alt=""></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Modal end -->
  <!-- Modal Cart -->
  <div class="modal customize-class fade" id="exampleModal-Cart" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-body text-center">
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="pe-7s-close"></i>
          </button>
          <div class="tt-modal-messages">
            <i class="pe-7s-check"></i> Added to bookshelf successfully!
          </div>
          <div class="tt-modal-product">
            <div class="tt-img">
              <img src="@/assets/images/product-image/1.webp" alt="Modern Smart Phone">
            </div>
            <h2 class="tt-title"><a href="#">Modern Smart Phone</a></h2>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Modal wishlist -->
  <div class="modal customize-class fade" id="exampleModal-Wishlist" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-body text-center">
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="pe-7s-close"></i>
          </button>
          <div class="tt-modal-messages">
            <i class="pe-7s-check"></i> Added to Wishlist successfully!
          </div>
          <div class="tt-modal-product">
            <div class="tt-img">
              <img src="@/assets/images/product-image/1.webp" alt="Modern Smart Phone">
            </div>
            <h2 class="tt-title"><a href="#">Modern Smart Phone</a></h2>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>

import {onLogout} from "@/common/LoginHook";
import {useMenuData} from "@/pc/common/menuData"
import {ref, toRaw} from "vue";
// initMenuData()
import router from "@/common/router";
import {usePageBookshelfNew} from "@/pc/business/bookshelf/hook/bookshelfHook";
import {useCreateAuthUser} from "@/pc/business/auth/hook/authUserHook";
import axiosInstance from "@/framework/axios";
import {usePageBookLibrary} from "@/pc/business/bookLibrary/hook/bookLibraryHook";

const {bookshelfParam,bookshelfEntity, bookshelfEntityList, initPage, setPageNo, toUpdate}=usePageBookshelfNew()

initPage()


const initialClassName = 'item-div'
const {initMenuData} = useMenuData()
const menuArrRef = ref()
initMenuData(initialClassName, menuArrRef)
let lastClickedItem: any = null
const { initCreate: initCreateAuthUser, authUserEntity, createAuthUser } = useCreateAuthUser()

initFunction()

const {hasPerm, toShow, initPage: initPage2, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
  setPageNo: setPageNo2,
  toCreate, toUpdate: toUpdate2, deleteBookLibrary, importExcel, exportExcel
}=usePageBookLibrary()
initPage2()


async function initFunction()
{
  const response = await axiosInstance.post("/userDetails" + "/getID");
  authUserEntity.id = response.data;
  console.log("AID: "+authUserEntity.id);
  // console.log("userDetailsEntityList: "+userDetailsEntityList)
}


function logout(item: any) {
  onLogout()
  location.assign('/pc/login')
}

function toggleChildrenDisplay(item: any) {
  console.log(item.childrenDisplay == "block")
  if (item.childrenDisplay == "block") {
    item.childrenDisplay = "none";
  } else {
    item.childrenDisplay = "block";
  }
}

function deleteBook(mybookshelfEntity, book)
{
  mybookshelfEntity.id = authUserEntity.id;
  mybookshelfEntity.name = authUserEntity.username;
  console.log("delete" + book)
  // 解析 JSON 字符串为对象
  const allBooksObject = JSON.parse(mybookshelfEntity.allbooks);

  // 使用 delete 操作符删除指定属性
  delete allBooksObject[book];

  // 将更新后的对象转换回 JSON 字符串
  mybookshelfEntity.allbooks = JSON.stringify(allBooksObject);

  console.log("after delete " + mybookshelfEntity.allbooks);

  axiosInstance.post('/bookshelf' + '/update', toRaw(mybookshelfEntity))
}

function clickItem(child: any) {
  if (null != lastClickedItem) {
    lastClickedItem.className = 'item-div'
  }
  child.className = 'clicked-item-div'
  lastClickedItem = child
  const toPath = child.path
  // router.replace({path: '/pc/empty', query: {toPath: toPath}})
}

function toAllBooks()
{
  router.push({path:'/pc/main/allBooks'})
}
function downloadFile(type, fileName) {
  // Construct the URL for the file in the 'public' folder

  const fileURL = `/bookFiles/`+ type +`/${fileName}`;
  // const fileURL = `/bookFiles/Earth Sciences/Meteorology Today An Introduction to Weather, Climate and the Environment (Twelfth Edition).pdf`;

  // Create a virtual link element for downloading the file
  const downloadLink = document.createElement('a');
  downloadLink.href = fileURL;

  // Set the file name
  downloadLink.download = fileName;

  // Trigger the click event to start the download
  downloadLink.click();
}

</script>
<style scoped>

@import "@/assets/css/plugins.min.css";
@import "@/assets/css/style.min.css";

.branch-div {
  padding: 8px;
  cursor: pointer;
}

.item-div {
  padding: 8px;
  cursor: pointer;
}

.clicked-item-div {
  padding: 8px;
  cursor: pointer;
  background-color: #e6eff8;
  border-right: 2px solid #018ffb;
}

.flex-div {
  display: flex;
  justify-content: space-between;
  align-items: center;
  color: #ffffff
}

.div3 {
  display: flex;
  justify-content: flex-start;
}

.menuUnit li {
  list-style-type: none;
}

/*   !* 在scoped内定义样式 *!*/
/*.bg-color1 {*/
/*  background-image: url("../../assets/images/hero/bg/hero-bg-1.webp") !important;*/
/*  !* 其他样式属性 *!*/
/* }*/

</style>
