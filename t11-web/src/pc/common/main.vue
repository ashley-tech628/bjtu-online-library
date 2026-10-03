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
                  <li @click="toMyAccount"><a @click="toMyAccount"><i class="fa fa-user"></i> Account</a></li>
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
                <a href="index.html"><img src="../../assets/images/logo/logo.png" alt="Site Logo" /></a>
              </div>
            </div>
            <div class="col-lg-6 d-none d-lg-block">
<!--              <div class="search-element">-->
<!--                <form action="#">-->
<!--                  <input type="text" placeholder="Search" />-->
<!--                  <button @click="btn" class="pe-7s-search">搜索</button>-->
<!--                  <button><i class="pe-7s-search"></i></button>-->
<!--                </form>-->
<!--              </div>-->
              <div class="safetyInfo">
<!--                <input type="text" placeholder="搜索" v-model="search" />-->
<!--                <button @click="btn">搜索</button>-->
                <div class="search-element">
                  <form @submit.prevent="btn">
                    <input v-model="search" type="text" placeholder="Search" />
<!--                    <button type="submit" class="pe-7s-search">搜索</button>-->
<!--                    <button type="button" @click="clearSearch"><i class="pe-7s-search"></i></button>-->
                    <button><i @click="btn" class="pe-7s-search"></i></button>
                  </form>
                </div>
                <ul v-if="searchData.length > 0">
                  <li v-for="book in searchData" :key="book.name">
                    <div class="product">
                                                        <span class="badges">
                                                        </span>
                      <div class="thumb">
                        <a @click = "toBookDetails(book.id)" class="image">
                          <img :src="book.cover" alt="Product" />
                          <img class="hover-image" :src="book.cover" alt="Product" />
                        </a>
                      </div>
                      <div class="content">
                        <span class="category"><a>{{book.type}}</a></span>
                        <h5 class="title">
                          <a @click = "toBookDetails(book.id)">{{book.author}}
                        </a>
                        </h5>
                      </div>
                      <div class="actions">
                        <button title="Add To Cart" class="action add-to-cart"
                                data-bs-toggle="modal"
                                data-bs-target="#exampleModal-Cart"><i
                            class="pe-7s-shopbag"></i></button>
                        <button class="action wishlist" title="Wishlist"
                                data-bs-toggle="modal"
                                data-bs-target="#exampleModal-Wishlist"><i
                            class="pe-7s-like"></i></button>
                        <button class="action quickview"
                                data-link-action="quickview" title="Quick view"
                                data-bs-toggle="modal" data-bs-target="#exampleModal"><i
                            class="pe-7s-look"></i></button>
                        <button class="action compare" title="Compare"
                                data-bs-toggle="modal"
                                data-bs-target="#exampleModal-Compare"><i
                            class="pe-7s-refresh-2"></i></button>
                      </div>
                    </div>
                  </li>
                </ul>
                <div v-else>
                  没有找到匹配数据
                </div>
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
                <a href="#offcanvas-mobile-menu" class="header-action-btn header-action-btn-menu offcanvas-toggle d-lg-none">
                  <i class="pe-7s-menu"></i>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Header action area end -->

      <!-- Header action area start -->
      <div class="header-bottom d-lg-none sticky-nav style-1">
        <div class="container">
          <div class="row justify-content-between align-items-center">
            <div class="col-lg-3 col">
              <div class="header-logo">
                <a href="index.html"><img src="../../assets/images/logo/logo.png" alt="Site Logo" /></a>
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
                  <!-- <span class="cart-amount">€30.00</span> -->
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
      <!-- header navigation area start -->
<!--      <div class="header-nav-area d-none d-lg-block sticky-nav">-->
<!--        <div class="container">-->
<!--          <div class="header-nav">-->
<!--            <div class="main-menu position-relative">-->
<!--              <ul>-->
<!--                <li class="dropdown"><a href="#">Home <i class="fa fa-angle-down"></i></a>-->
<!--                  <ul class="sub-menu">-->
<!--                    <li><a href="src/assets/html/homepage_user.html">Home Page</a></li>-->
<!--                    <li><a href="src/assets/html/homepage_administrater.html">Administration</a></li>-->
<!--                  </ul>-->
<!--                </li>-->

<!--                <li class="dropdown"><a href="#">Category <i class="fa fa-angle-down"></i></a>-->
<!--                  <ul class="sub-menu">-->
<!--                    <li><a href="src/assets/html/homepage_user.html">Home Page</a></li>-->
<!--                    <li><a href="src/assets/html/homepage_administrater.html">Administration</a></li>-->
<!--                  </ul>-->
<!--                </li>-->

<!--                <li><a href="src/assets/html/about.html">About</a></li>-->
<!--                <li class="dropdown position-static"><a href="src/assets/html/about.html">Pages <i class="fa fa-angle-down"></i></a>-->
<!--                  <ul class="mega-menu d-block">-->
<!--                    <li class="d-flex">-->
<!--                      <ul class="d-block">-->
<!--                        <li class="title"><a href="#">Inner Pages</a></li>-->
<!--                        <li><a href="src/assets/html/404.html">404 Page</a></li>-->
<!--                        <li><a href="src/assets/html/order-tracking.html">Order Tracking</a></li>-->
<!--                        <li><a href="src/assets/html/faq.html">Faq Page</a></li>-->
<!--                        <li><a href="src/assets/html/coming-soon.html">Coming Soon Page</a></li>-->
<!--                      </ul>-->
<!--                      <ul class="d-block">-->
<!--                        <li class="title"><a href="#">Other Shop Pages</a></li>-->
<!--                        <li><a href="src/assets/html/cart.html">Book Shelf Page</a></li>-->
<!--                        <li><a href="src/assets/html/checkout.html">Checkout Page</a></li>-->
<!--                        <li><a href="src/assets/html/compare.html">Compare Page</a></li>-->
<!--                        <li><a href="src/assets/html/wishlist.html">Wishlist Page</a></li>-->
<!--                      </ul>-->
<!--                      <ul class="d-block">-->
<!--                        <li class="title"><a href="#">Related Shop Pages</a></li>-->
<!--                        <li><a href="src/assets/html/my-account.html">Account Page</a></li>-->
<!--                        <li><a href="src/assets/html/login.html">Login & Register Page</a></li>-->
<!--                        <li><a href="src/assets/html/empty-cart.html">Empty Cart Page</a></li>-->
<!--                        <li><a href="src/assets/html/thank-you-page.html">Thank You Page</a></li>-->
<!--                      </ul>-->
<!--                      <ul class="d-flex align-items-center p-0 border-0 flex-column justify-content-center">-->
<!--                        <li>-->
<!--                          <a class="p-0" href="src/assets/html/shop-left-sidebar.html"><img class="img-responsive w-100" src="../../assets/images/banner/menu-banner.png" alt=""></a>-->
<!--                        </li>-->
<!--                      </ul>-->
<!--                    </li>-->
<!--                  </ul>-->
<!--                </li>-->
<!--                <li class="dropdown position-static"><a href="#">Shop <i-->
<!--                    class="fa fa-angle-down"></i></a>-->
<!--                  <ul class="mega-menu d-block">-->
<!--                    <li class="d-flex">-->
<!--                      <ul class="d-block">-->
<!--                        <li class="title"><a href="#">Shop Page</a></li>-->
<!--                        <li><a href="src/assets/html/shop-3-column.html">Shop 3 Column</a></li>-->
<!--                        <li><a href="src/assets/html/shop-4-column.html">Shop 4 Column</a></li>-->
<!--                        <li><a href="src/assets/html/shop-left-sidebar.html">Shop Left Sidebar</a></li>-->
<!--                        <li><a href="src/assets/html/shop-right-sidebar.html">Shop Right Sidebar</a></li>-->
<!--                        <li><a href="src/assets/html/shop-list-left-sidebar.html">Shop List Left Sidebar</a>-->
<!--                        </li>-->
<!--                        <li><a href="src/assets/html/shop-list-right-sidebar.html">Shop List Right Sidebar</a>-->
<!--                        </li>-->
<!--                      </ul>-->
<!--                      <ul class="d-block">-->
<!--                        <li class="title"><a href="#">product Details Page</a></li>-->
<!--                        <li><a href="single-product.html">Product Single</a></li>-->
<!--                        <li><a href="single-product-variable.html">Product Variable</a></li>-->
<!--                        <li><a href="single-product-affiliate.html">Product Affiliate</a></li>-->
<!--                        <li><a href="single-product-group.html">Product Group</a></li>-->
<!--                        <li><a href="single-product-tabstyle-2.html">Product Tab 2</a></li>-->
<!--                        <li><a href="single-product-tabstyle-3.html">Product Tab 3</a></li>-->
<!--                      </ul>-->
<!--                      <ul class="d-block">-->
<!--                        <li class="title"><a href="#">Single Product Page</a></li>-->
<!--                        <li><a href="single-product-slider.html">Product Slider</a></li>-->
<!--                        <li><a href="single-product-gallery-left.html">Product Gallery Left</a></li>-->
<!--                        <li><a href="single-product-gallery-right.html">Product Gallery Right</a> </li>-->
<!--                        <li><a href="single-product-sticky-left.html">Product Sticky Left</a>-->
<!--                        </li>-->
<!--                        <li><a href="single-product-sticky-right.html">Product Sticky Right</a>-->
<!--                        </li>-->
<!--                        <li><a href="cart.html">Book Shelf Page</a></li>-->
<!--                      </ul>-->
<!--                      <ul class="d-block p-0 border-0">-->
<!--                        <li class="title"><a href="#">Single Product Page</a></li>-->
<!--                        <li><a href="src/assets/html/checkout.html">Checkout Page</a></li>-->
<!--                        <li><a href="src/assets/html/compare.html">Compare Page</a></li>-->
<!--                        <li><a href="src/assets/html/wishlist.html">Wishlist Page</a></li>-->
<!--                        <li><a href="src/assets/html/my-account.html">Account Page</a></li>-->
<!--                        <li><a href="src/assets/html/login.html">Login & Register Page</a></li>-->
<!--                        <li><a href="src/assets/html/empty-cart.html">Empty Shelf Page</a></li>-->
<!--                      </ul>-->
<!--                    </li>-->
<!--                  </ul>-->
<!--                </li>-->
<!--                <li class="dropdown "><a href="#">Blog <i class="fa fa-angle-down"></i></a>-->
<!--                  <ul class="sub-menu">-->
<!--                    <li class="dropdown position-static"><a href="src/assets/html/blog-grid-left-sidebar.html">Blog Grid-->
<!--                      <i class="fa fa-angle-right"></i></a>-->
<!--                      <ul class="sub-menu sub-menu-2">-->
<!--                        <li><a href="src/assets/html/blog-grid.html">Blog Grid</a></li>-->
<!--                        <li><a href="src/assets/html/blog-grid-left-sidebar.html">Blog Grid Left Sidebar</a></li>-->
<!--                        <li><a href="src/assets/html/blog-grid-right-sidebar.html">Blog Grid Right Sidebar</a></li>-->
<!--                      </ul>-->
<!--                    </li>-->
<!--                    <li class="dropdown position-static"><a href="blog-list-left-sidebar.html">Blog List-->
<!--                      <i class="fa fa-angle-right"></i></a>-->
<!--                      <ul class="sub-menu sub-menu-2">-->
<!--                        <li><a href="src/assets/html/blog-list.html">Blog List</a></li>-->
<!--                        <li><a href="src/assets/html/blog-list-left-sidebar.html">Blog List Left Sidebar</a></li>-->
<!--                        <li><a href="src/assets/html/blog-list-right-sidebar.html">Blog List Right Sidebar</a></li>-->
<!--                      </ul>-->
<!--                    </li>-->
<!--                    <li class="dropdown position-static"><a href="blog-single-left-sidebar.html">Single-->
<!--                      Blog <i class="fa fa-angle-right"></i></a>-->
<!--                      <ul class="sub-menu sub-menu-2">-->
<!--                        <li><a href="blog-single.html">Single Blog</a></li>-->
<!--                        <li><a href="blog-single-left-sidebar.html">Single Blog Left Sidebar</a>-->
<!--                        </li>-->
<!--                        <li><a href="blog-single-right-sidebar.html">Single Blog Right Sidebar</a>-->
<!--                        </li>-->
<!--                      </ul>-->
<!--                    </li>-->
<!--                  </ul>-->
<!--                </li>-->
<!--                <li><a href="contact.html">Contact</a></li>-->
<!--              </ul>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--      &lt;!&ndash; header navigation area end &ndash;&gt;-->
      <!-- header navigation area start -->


      <div class="header-nav-area d-none d-lg-block sticky-nav">
        <div class="container">
          <div class="header-nav">
            <div class="main-menu position-relative">
              <ul>
                <li class="dropdown"> <a href="/pc/main/category"> Category <i class="fa fa-angle-down"></i> </a>
                  <ul class="sub-menu">
                    <li><a href="/pc/main/category">Earth Sciences </a></li>
                    <li><a href="/pc/main/category">Health & Fitness </a></li>
                    <li><a href="/pc/main/category">Nature, Animals & Pets </a></li>
                  </ul>
                </li>
                <li> <a href="/pc/main/bookshelf">Bookshelf </a></li>
                <li><a href="#">Search </a></li>
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
              <input type="text" placeholder="Search" />
              <button><i class="pe-7s-search"></i></button>
            </form>
          </div>
          <!-- mobile search start -->
        </div>
      </div>
    </header>
    <!-- offcanvas overlay start -->
    <div class="offcanvas-overlay"></div>
    <!-- offcanvas overlay end -->
    <!-- OffCanvas Wishlist Start -->
    <div id="offcanvas-wishlist" class="offcanvas offcanvas-wishlist">
      <div class="inner">
        <div class="head">
          <span class="title">Wishlist</span>
          <button class="offcanvas-close">×</button>
        </div>
        <div class="body customScroll">
          <ul class="minicart-product-list">
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img src="../../assets/images/product-image/1.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Modern Smart Phone</a>
                <span class="quantity-price">1 x <span class="amount">$21.86</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img src="../../assets/images/product-image/2.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Bluetooth Headphone</a>
                <span class="quantity-price">1 x <span class="amount">$13.28</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img src="../../assets/images/product-image/3.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Smart Music Box</a>
                <span class="quantity-price">1 x <span class="amount">$17.34</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
          </ul>
        </div>
        <div class="foot">
          <div class="buttons">
            <a href="src/assets/html/wishlist.html" class="btn btn-dark btn-hover-primary mt-30px">view wishlist</a>
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
              <a href="src/assets/html/single-product.html" class="image"><img src="../../assets/images/product-image/1.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Modern Smart Phone</a>
                <span class="quantity-price">1 x <span class="amount">$18.86</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img src="../../assets/images/product-image/2.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Bluetooth Headphone</a>
                <span class="quantity-price">1 x <span class="amount">$43.28</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img src="../../assets/images/product-image/3.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Smart Music Box</a>
                <span class="quantity-price">1 x <span class="amount">$37.34</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
          </ul>
        </div>
        <div class="foot">
          <div class="buttons mt-30px">
            <a href="src/assets/html/cart.html" class="btn btn-dark btn-hover-primary mb-30px">view bookshelf</a>
            <a href="src/assets/html/checkout.html" class="btn btn-outline-dark current-btn">checkout</a>
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
            <li><a href="#"><span class="menu-text">Home</span></a>
              <ul class="sub-menu">
                <li><a href="index.html"><span class="menu-text">Home 1</span></a></li>
                <li><a href="src/assets/html/index-2.html"><span class="menu-text">Home 2</span></a></li>
              </ul>
            </li>
            <li><a href="src/assets/html/about.html">About</a></li>
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
                    <li><a href="cart.html">bookshelf Page</a></li>
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
                    <li><a href="empty-cart.html">Empty Bookshelf Page</a></li>
                    <li><a href="thank-you-page.html">Thank You Page</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li><a href="#"><span class="menu-text">Shop</span></a>
              <ul class="sub-menu">
                <li>
                  <a href="#"><span class="menu-text">Shop Page</span></a>
                  <ul class="sub-menu">
                    <li><a href="shop-3-column.html">Shop 3 Column</a></li>
                    <li><a href="shop-4-column.html">Shop 4 Column</a></li>
                    <li><a href="shop-left-sidebar.html">Shop Left Sidebar</a></li>
                    <li><a href="shop-right-sidebar.html">Shop Right Sidebar</a></li>
                    <li><a href="shop-list-left-sidebar.html">Shop List Left Sidebar</a>
                    </li>
                    <li><a href="shop-list-right-sidebar.html">Shop List Right Sidebar</a>
                    </li>
                    <li><a href="cart.html">Bookshelf Page</a></li>
                    <li><a href="checkout.html">Checkout Page</a></li>
                  </ul>
                </li>
                <li>
                  <a href="#"><span class="menu-text">product Details Page</span></a>
                  <ul class="sub-menu">
                    <li><a href="single-product.html">Product Single</a></li>
                    <li><a href="single-product-variable.html">Product Variable</a></li>
                    <li><a href="single-product-affiliate.html">Product Affiliate</a></li>
                    <li><a href="single-product-group.html">Product Group</a></li>
                    <li><a href="single-product-tabstyle-2.html">Product Tab 2</a></li>
                    <li><a href="single-product-tabstyle-3.html">Product Tab 3</a></li>
                    <li><a href="single-product-slider.html">Product Slider</a></li>
                    <li><a href="single-product-gallery-left.html">Product Gallery Left</a></li>
                  </ul>
                </li>
                <li>
                  <a href="#"><span class="menu-text">Single Product Page</span></a>
                  <ul class="sub-menu">
                    <li><a href="single-product-gallery-right.html">Product Gallery
                      Right</a> </li>
                    <li><a href="single-product-sticky-left.html">Product Sticky Left</a>
                    </li>
                    <li><a href="single-product-sticky-right.html">Product Sticky Right</a>
                    </li>
                    <li><a href="compare.html">Compare Page</a></li>
                    <li><a href="wishlist.html">Wishlist Page</a></li>
                    <li><a href="my-account.html">Account Page</a></li>
                    <li><a href="login.html">Login & Register Page</a></li>
                    <li><a href="empty-cart.html">Empty Bookshelf Page</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li><a href="#"><span class="menu-text">Blog</span></a>
              <ul class="sub-menu">
                <li><a href="blog-grid.html">Blog Grid Page</a></li>
                <li><a href="blog-grid-left-sidebar.html">Grid Left Sidebar</a></li>
                <li><a href="blog-grid-right-sidebar.html">Grid Right Sidebar</a></li>
                <li><a href="blog-list.html">Blog List Page</a></li>
                <li><a href="blog-list-left-sidebar.html">List Left Sidebar</a></li>
                <li><a href="blog-list-right-sidebar.html">List Right Sidebar</a></li>
                <li><a href="blog-single.html">Blog Single Page</a></li>
                <li><a href="blog-single-left-sidebar.html">Single Left Sidebar</a></li>
                <li><a href="blog-single-right-sidebar.html">Single Right Sidbar</a></li>
              </ul>
            </li>
            <li><a href="contact.html">Contact Us</a></li>
          </ul>
        </div>
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
    <!-- Hero/Intro Slider Start -->
    <div class="section ">
      <div class="hero-slider swiper-container slider-nav-style-1 slider-dot-style-1">
        <!-- Hero slider Active -->
        <div class="swiper-wrapper">
          <!-- Single slider item -->
          <div
              class="hero-slide-item slider-height-2 swiper-slide bg-color1"
              :style="{ backgroundImage: 'url(/src/assets/images/hero/bg/hero-bg-1.webp) !important' }"
          >
            <div class="container h-100">
              <div class="row h-100 flex-row-reverse">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 align-self-center sm-center-view">
<!--                  <div class="hero-slide-content hero-slide-content-2 slider-animated-1">-->
                  <div class="hero-slide-content hero-slide-content-2 ">
                    <h2 class="title-1">Earth <br>
                      Portrait of a Planet<br>
                      6th Edition</h2>
                    <span class="price">
                                            <span class="mini-title">Author</span>
                                        <span class="amount">Stephen Marshak</span>
                                        </span>
                    <a href="../../assets/html/shop-left-sidebar.html" class="btn btn-primary text-capitalize">Show More</a>
                  </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 d-flex justify-content-center position-relative align-items-center">
                  <div class="show-case">
                    <div class="slider-2">
<!--                    <div class="hero-slide-image ">-->
                      <img src="../../assets/images/hero/inner-img/user-homepage-1.jpeg" alt="recommend book 1" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Single slider item -->
          <div
              class="hero-slide-item slider-height-2 swiper-slide bg-color1"
              :style="{backgroundImage: `url('/src/assets/images/hero/bg/hero-bg-2-1.webp') !important`, }"
          >
            <div class="container h-100">
              <div class="row h-100 flex-row-reverse">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 align-self-center sm-center-view">
<!--                  <div class="hero-slide-content hero-slide-content-2 slider-animated-1">-->
                  <div class="hero-slide-content hero-slide-content-2">
                    <h2 class="title-1">Understanding Geology <br>
                      through Maps </h2>
                    <span class="price">
                                            <span class="mini-title">Author</span>
                                        <span class="amount">Graham Borradaile</span>
                                        </span>
                    <a href="../../assets/html/shop-left-sidebar.html" class="btn btn-primary text-capitalize">Show More</a>
                  </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 d-flex justify-content-center position-relative align-items-center">
                  <div class="show-case">
<!--                    <div class="hero-slide-image slider-2">-->
                    <div class="slider-2">
                      <img src="../../assets/images/hero/inner-img/user-homepage-2.jpeg" alt="recommend book2" />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Add Pagination -->
        <div class="swiper-pagination swiper-pagination-white"></div>
        <!-- Add Arrows -->
        <div class="swiper-buttons">
          <!-- Button to go to the previous slide -->
<!--          <div class="swiper-button-prev" @click="prevSlide"></div>-->

          <!-- Button to go to the next slide -->
<!--          <div class="swiper-button-next" @click="nextSlide"></div>-->

          <div class="swiper-button-next"></div>
          <div class="swiper-button-prev"></div>
        </div>
      </div>
    </div>
    <!-- Hero/Intro Slider End -->
    <!-- Banner Area Start -->
    <div class="banner-area style-two pt-100px pb-100px">
    </div>
    <!-- Banner Area End -->
    <!-- Product Area Start -->
    <div class="product-area pb-100px">
      <div class="container">
        <!-- Section Title & Tab Start -->
        <div class="row">
          <div class="col-12">
            <div class="section-title text-center">
              <h2 class="title">New Books</h2>
              <p>There are 3 categories of book now available.<br>
                Click any cover to browse more!</p>
            </div>
          </div>
        </div>
        <!-- Section Title & Tab End -->
        <div class="row">
          <div class="col">
            <div class="row mb-n-30px">
<!--              <div class="col-lg-4 col-xl-3 col-md-6 col-sm-6 col-xs-6 mb-30px">-->
                <!-- Single Prodect -->
              <!-- Single Prodect -->
              <div v-for="(item, index) in bookLibraryEntityList" :key="item.id" class="col-lg-4 col-xl-3 col-md-6 col-sm-6 col-xs-6 mb-30px">
                <div class="product">
                      <span class="badges">
                        <span class="new">New</span>
                      </span>
                  <div class="thumb">

                    <a @click = "toBookDetails(item.id)" class="image">
                      <img :src="item.cover" alt="Product" />
                      <img class="hover-image" :src="item.cover" alt="Product" />
                    </a>

                  </div>
                </div>
                <div class="content">
                  <span class="category"><a href="#">{{ item.type }}</a></span>
                  <h5 class="title"><a href="src/assets/html/single-product.html">
                    {{ item.title  }}</a>
                  </h5>
                  <span class="price">
                                            <span class="new">{{ item.author }}</span>
                                        </span>
                </div>
                <div class="actions">
                  <!--                    <button title="Add To Cart" class="action add-to-cart" data-bs-toggle="modal" data-bs-target="#exampleModal-Cart"><i-->
                  <!--                        class="pe-7s-shopbag"></i></button>-->
                  <button class="action wishlist" title="Wishlist" data-bs-toggle="modal" data-bs-target="#exampleModal-Wishlist"><i
                      class="pe-7s-like"></i></button>
                  <button class="action quickview" data-link-action="quickview" title="Quick view" data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="pe-7s-look"></i></button>
                  <!--                    <button class="action compare" title="Compare" data-bs-toggle="modal" data-bs-target="#exampleModal-Compare"><i-->
                  <!--                        class="pe-7s-refresh-2"></i></button>-->
                </div>
                <!--                </div>-->
              </div>
            </div>

            <!-- 分页按钮 -->
            <!--            <p>{{ pageCountSliceArr+"11111111" }}</p >-->
            <div class="pagination-container">
              <span class="total">共{{ total }}条</span>
              <span><button  @click="prevPageNo" >&#8249; 上一页</button></span>
              <span>
      <span
          :class="pageNoClass(item)"
          v-for="(item, index) in pageCountSliceArr"
          @click="setPageNo(item)"
          :key="index"
      >
        {{ item }}
      </span>
    </span>
              <span> <button href="#" @click="nextPageNo" >下一页 &#8250;</button></span>
              <span class="total-pages">共{{ pageCount }}页</span>
<!--              <span style="white-space: nowrap;">到 <input style="text-align: center" size="5" type="text" v-model="pageNo"> 页-->
<!--    </span>-->
<!--              <span><button @click="toPageNo" class="page-btn">确定</button></span>-->
              </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Product Area End -->
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
                    <a href="index.html"><img src="../../assets/images/logo/footer-logo.png" alt="Footer Logo"></a>
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
  </div>
  <!-- Modal -->
  <div class="modal modal-2 fade" id="exampleModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-body">
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"> <i class="pe-7s-close"></i></button>
          <div class="row">
            <div class="col-lg-6 col-sm-12 col-xs-12 mb-lm-30px mb-md-30px mb-sm-30px">
              <!-- Swiper -->
              <div class="swiper-container gallery-top">
                <div class="swiper-wrapper">
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/zoom-image/1.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/zoom-image/2.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/zoom-image/3.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/zoom-image/4.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/zoom-image/5.webp" alt="">
                  </div>
                </div>
              </div>
              <div class="swiper-container gallery-thumbs mt-20px slider-nav-style-1 small-nav">
                <div class="swiper-wrapper">
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/small-image/1.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/small-image/2.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/small-image/3.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/small-image/4.webp" alt="">
                  </div>
                  <div class="swiper-slide">
                    <img class="img-responsive m-auto" src="../../assets/images/product-image/small-image/5.webp" alt="">
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
                <p class="mt-30px">Lorem ipsum dolor sit amet, consecte adipisicing elit, sed do eiusmll tempor incididunt ut labore et dolore magna aliqua. Ut enim ad mill veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip exet commodo consequat. Duis aute irure dolor</p>
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
                    <input class="cart-plus-minus-box" type="text" name="qtybutton" value="1" />
                  </div>
                  <div class="pro-details-cart">
                    <button class="add-cart"> Add To
                      Cart</button>
                  </div>
                  <div class="pro-details-compare-wishlist pro-details-wishlist ">
                    <a href="src/assets/html/wishlist.html"><i class="pe-7s-like"></i></a>
                  </div>
                </div>
                <div class="payment-img">
                  <a href="#"><img src="../../assets/images/icons/payment.png" alt=""></a>
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
  <div class="modal customize-class fade" id="exampleModal-Cart" tabindex="-1"   aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-body text-center">
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="pe-7s-close"></i></button>
          <div class="tt-modal-messages">
            <i class="pe-7s-check"></i> Added to bookshelf successfully!
          </div>
          <div class="tt-modal-product">
            <div class="tt-img">
              <img src="../../assets/images/product-image/1.webp" alt="Modern Smart Phone">
            </div>
            <h2 class="tt-title"><a href="#">Modern Smart Phone</a></h2>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Modal wishlist -->
  <div class="modal customize-class fade" id="exampleModal-Wishlist" tabindex="-1"   aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-body text-center">
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="pe-7s-close"></i></button>
          <div class="tt-modal-messages">
            <i class="pe-7s-check"></i> Added to Wishlist successfully!
          </div>
          <div class="tt-modal-product">
            <div class="tt-img">
              <img src="../../assets/images/product-image/1.webp" alt="Modern Smart Phone">
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
import {ref} from "vue";
// initMenuData()
import router from "@/common/router";

const initialClassName = 'item-div'
const { initMenuData } = useMenuData()
const menuArrRef = ref()
initMenuData(initialClassName, menuArrRef)
let showDiv1: boolean = true
let lastClickedItem: any = null

import {usePageBookLibrary} from '@/pc/business/bookLibrary/hook/bookLibraryHook'

const {hasPerm, toShow, initPage, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
  setPageNo,
  toCreate, toUpdate, deleteBookLibrary, importExcel, exportExcel
}=usePageBookLibrary()

import { useInPage } from '@/framework/page/usePage'
const { total, pageNo, pageCount, pageCountSliceArr,
  prevPageNo, nextPageNo, toPageNo, pageNoClass, } = useInPage()

initPage()

function toMyAccount()
{
  router.push({path:'/pc/main/myAccount'})
}


function logout(item: any){
  onLogout()
  location.assign('/pc/login')
}
function toggleChildrenDisplay(item: any){
  console.log(item.childrenDisplay == "block")
  if(item.childrenDisplay == "block"){
    item.childrenDisplay = "none";
  }else{
    item.childrenDisplay = "block";
  }
}
function clickItem(child: any){
  if(null != lastClickedItem){
    lastClickedItem.className = 'item-div'
  }
  child.className = 'clicked-item-div'
  lastClickedItem = child
  const toPath = child.path
  router.replace({path:'/pc/empty',query: {toPath: toPath}})
}
function toBookDetails(bookId)
{
  router.push({path:'/pc/main/bookInfo/'+bookId})
}


const search = ref('');
const searchData = ref([]);
const btn = () => {
  const searchTerm = search.value.toLowerCase().replace(/[\-,]/g, ''); // 将逗号和连字符替换为空白字符
  if (searchTerm) {
    searchData.value = bookLibraryEntityList.value.filter(book =>
        Object.values(book).some(value =>
            String(value).toLowerCase().replace(/[\-,]/g, '').includes(searchTerm)
        )
    );
  } else {
    searchData.value = [];
  }
};


</script>

<style scoped>
@import "src/assets/css/plugins.min.css";
@import "src/assets/css/style.min.css";
.branch-div{
    padding:8px;
    cursor: pointer;
}
.item-div{
  padding:8px;
  cursor: pointer;
}
.clicked-item-div{
  padding:8px;
  cursor: pointer;
  background-color: #e6eff8;
  border-right: 2px solid #018ffb;
}
.flex-div {
  display: flex;
  justify-content: space-between;
  align-items: center;
  color:#ffffff
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

.pagination-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 20px;
  background-color: #f8f8f8;
  padding: 10px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.pagination-btn {
  cursor: pointer;
  padding: 8px 16px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.pagination-btn:hover {
  background-color: #45a049;
}

.prev-btn {
  margin-right: 10px;
}

.next-btn {
  margin-left: 10px;
}

.page-input {
  text-align: center;
  padding: 6px;
  border: 1px solid #ddd;
  border-radius: 3px;
}

.page-btn {
  cursor: pointer;
  padding: 8px 16px;
  background-color: #3498db;
  color: white;
  border: none;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.page-btn:hover {
  background-color: #2980b9;
}

</style>