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
                  <li><a href="src/assets/html/my-account.html"><i class="fa fa-user"></i> Account</a></li>
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
                <a href="src/assets/html/index.html"><img src="@/assets/images/logo/logo.png" alt="Site Logo"/></a>
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
                    <li><a href="src/assets/html/login.html">Earth Sciences</a></li>
                    <li><a href="src/assets/html/login.html">Health & Fitness</a></li>
                    <li><a href="src/assets/html/login.html">Nature, Animals & Pets</a></li>
                  </ul>
                </li>
                <li><a href="src/assets/html/login.html">Bookshelf</a></li>
                <li><a href="src/assets/html/wishlist.html">Search</a></li>
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
              <a href="src/assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/1.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Modern Smart Phone</a>
                <span class="quantity-price"><span class="amount">author</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/2.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Bluetooth Headphone</a>
                <span class="quantity-price"><span class="amount">author</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/3.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Smart Music Box</a>
                <span class="quantity-price"><span class="amount">author</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
          </ul>
        </div>
        <div class="foot">
          <div class="buttons">
            <a href="src/assets/html/wishlist.html" class="btn btn-dark btn-hover-primary mt-30px">view bookshelf</a>
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
              <a href="src/assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/1.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Modern Smart Phone</a>
                <span class="quantity-price">1 x <span class="amount">$18.86</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/2.webp" alt="Cart product Image"></a>
              <div class="content">
                <a href="src/assets/html/single-product.html" class="title">Bluetooth Headphone</a>
                <span class="quantity-price">1 x <span class="amount">$43.28</span></span>
                <a href="#" class="remove">×</a>
              </div>
            </li>
            <li>
              <a href="src/assets/html/single-product.html" class="image"><img
                  src="@/assets/images/product-image/3.webp" alt="Cart product Image"></a>
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
            <a href="src/assets/html/cart.html" class="btn btn-dark btn-hover-primary mb-30px">view cart</a>
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
          <li><a href="my-account.html"><i class="fa fa-user"></i> Account</a></li>
        </ul>
      </div>
      <div class="inner customScroll">
        <div class="offcanvas-menu mb-4">
          <ul>
            <li><a href="#"><span class="menu-text">Home</span></a>
              <ul class="sub-menu">
                <li><a href="src/assets/html/index.html"><span class="menu-text">Home 1</span></a></li>
                <li><a href="src/assets/html/index-2.html"><span class="menu-text">Home 2</span></a></li>
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
                    <li><a href="src/assets/html/shop-3-column.html">Shop 3 Column</a></li>
                    <li><a href="src/assets/html/shop-4-column.html">Shop 4 Column</a></li>
                    <li><a href="src/assets/html/shop-left-sidebar.html">Shop Left Sidebar</a></li>
                    <li><a href="src/assets/html/shop-right-sidebar.html">Shop Right Sidebar</a></li>
                    <li><a href="src/assets/html/shop-list-left-sidebar.html">Shop List Left Sidebar</a>
                    </li>
                    <li><a href="src/assets/html/shop-list-right-sidebar.html">Shop List Right Sidebar</a>
                    </li>
                  </ul>
                  <ul class="d-block">
                    <li class="title"><a href="#">product Details Page</a></li>
                    <li><a href="src/assets/html/single-product.html">Product Single</a></li>
                    <li><a href="src/assets/html/single-product-variable.html">Product Variable</a></li>
                    <li><a href="src/assets/html/single-product-affiliate.html">Product Affiliate</a></li>
                    <li><a href="src/assets/html/single-product-group.html">Product Group</a></li>
                    <li><a href="src/assets/html/single-product-tabstyle-2.html">Product Tab 2</a></li>
                    <li><a href="src/assets/html/single-product-tabstyle-3.html">Product Tab 3</a></li>
                  </ul>
                  <ul class="d-block">
                    <li class="title"><a href="#">Single Product Page</a></li>
                    <li><a href="src/assets/html/single-product-slider.html">Product Slider</a></li>
                    <li><a href="src/assets/html/single-product-gallery-left.html">Product Gallery Left</a></li>
                    <li><a href="src/assets/html/single-product-gallery-right.html">Product Gallery Right</a></li>
                    <li><a href="src/assets/html/single-product-sticky-left.html">Product Sticky Left</a>
                    </li>
                    <li><a href="src/assets/html/single-product-sticky-right.html">Product Sticky Right</a>
                    </li>
                    <li><a href="src/assets/html/cart.html">Book Shelf Page</a></li>
                  </ul>
                  <ul class="d-block p-0 border-0">
                    <li class="title"><a href="#">Single Product Page</a></li>
                    <li><a href="src/assets/html/checkout.html">Checkout Page</a></li>
                    <li><a href="src/assets/html/compare.html">Compare Page</a></li>
                    <li><a href="src/assets/html/wishlist.html">Wishlist Page</a></li>
                    <li><a href="src/assets/html/my-account.html">Account Page</a></li>
                    <li><a href="src/assets/html/login.html">Login & Register Page</a></li>
                    <li><a href="src/assets/html/empty-cart.html">Empty Shelf Page</a></li>
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
        <!-- OffCanvas Menu Start -->
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
            <h2 class="breadcrumb-title">Product Page</h2>
            <!-- breadcrumb-list start -->
            <ul class="breadcrumb-list">
              <li class="breadcrumb-item"><a href="index.html">Home</a></li>
              <li class="breadcrumb-item active">Shop</li>
            </ul>
            <!-- breadcrumb-list end -->
          </div>
        </div>
      </div>
    </div>
    <!-- breadcrumb-area end -->
    <!-- Shop Page Start  -->
    <div class="shop-category-area pt-100px pb-100px">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 order-lg-last col-md-12 order-md-first">
            <!-- Shop Top Area Start -->
            <div class="shop-top-bar d-flex">
              <p class="compare-product"><span>6</span> Product Found of <span>12</span></p>
              <!-- Left Side End -->
              <div class="shop-tab nav">
                <button class="active" data-bs-target="#shop-grid" data-bs-toggle="tab">
                  <i class="fa fa-th" aria-hidden="true"></i>
                </button>
                <button data-bs-target="#shop-list" data-bs-toggle="tab">
                  <i class="fa fa-list" aria-hidden="true"></i>
                </button>
              </div>
              <!-- Right Side Start -->
              <div class="select-shoing-wrap d-flex align-items-center">
                <div class="shot-product">
                  <p>Sort By:</p>
                </div>
                <!-- Single Wedge End -->
                <div class="header-bottom-set dropdown">
                  <button class="dropdown-toggle header-action-btn" data-bs-toggle="dropdown">Default
                    <i class="fa fa-angle-down"></i></button>
                  <ul class="dropdown-menu dropdown-menu-right">
                    <li><a class="dropdown-item" href="#">Title, A to Z</a></li>
                    <li><a class="dropdown-item" href="#">Title, Z to A</a></li>
                    <li><a class="dropdown-item" href="#">Author</a></li>
                  </ul>
                </div>
                <!-- Single Wedge Start -->
              </div>
              <!-- Right Side End -->
            </div>
            <!-- Shop Top Area End -->
            <!-- Shop Bottom Area Start -->
            <div class="shop-bottom-area">
              <!-- Tab Content Area Start -->
              <div class="row">
                <div class="col">
                  <div class="tab-content">
                    <div class="tab-pane fade show active" id="shop-grid">
                      <div class="row mb-n-30px">
<!--                        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">-->
<!--                        <div v-for="(item, index) in booksToShow" :key="item.id" class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">-->
                          <div v-for="book in booksToShow" :key="book.id" class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">
                          <!-- Single Prodect -->
                          <div class="product">
                                                        <span class="badges">
                                                        </span>
                            <div class="thumb">
                              <a href="src/assets/html/single-product.html" class="image">
                                <img :src="book.cover" alt="Product" />
                                <img class="hover-image" :src="book.cover" alt="Product" />
                              </a>
                            </div>
                            <div class="content">
                              <span class="category"><a href="#">Accessories</a></span>
                              <h5 class="title"><a href="single-product.html">Modern Smart
                                Phone
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
                        </div>

                        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">
                          <!-- Single Prodect -->
                          <div class="product">
                                                        <span class="badges">
                                                        </span>
                            <div class="thumb">
                              <a href="single-product.html" class="image">
                                <img src="@/assets/images/product-image/6.webp"
                                     alt="Product"/>
                                <img class="hover-image"
                                     src="@/assets/images/product-image/6.webp"
                                     alt="Product"/>
                              </a>
                            </div>
                            <div class="content">
                              <span class="category"><a href="#">Accessories</a></span>
                              <h5 class="title"><a href="single-product.html">Smart Table
                                Camera
                              </a>
                              </h5>
                            </div>
                            <div class="actions">
                              <button class="action wishlist" title="Wishlist"
                                      data-bs-toggle="modal"
                                      data-bs-target="#exampleModal-Wishlist"><i
                                  class="pe-7s-like"></i></button>
                              <button class="action quickview"
                                      data-link-action="quickview" title="Quick view"
                                      data-bs-toggle="modal" data-bs-target="#exampleModal"><i
                                  class="pe-7s-look"></i></button>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane fade mb-n-30px" id="shop-list">
                      <div class="shop-list-wrapper mb-30px">
                        <div class="row">
                          <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">
                            <div class="product">
                              <div class="thumb">
                                <a href="single-product.html" class="image">
                                  <img src="@/assets/images/product-image/1.webp"
                                       alt="Product"/>
                                  <img class="hover-image"
                                       src="@/assets/images/product-image/1.webp"
                                       alt="Product"/>
                                </a>
                                <span class="badges">
                                                                    <span class="new">New</span>
                                                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-7 col-lg-7 col-xl-8">
                            <div class="content-desc-wrap">
                              <div class="content">
                                                                <span class="category"><a
                                                                    href="#">Accessories</a></span>
                                <h5 class="title"><a href="single-product.html">Modern
                                  Smart Phone</a></h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                  elit,
                                  sed do eiusmodol tempor incididunt ut labore et
                                  dolore
                                  magna aliqua. Ut enim ad minim veni quis nostrud
                                  exercitation ullamco laboris </p>
                              </div>
                              <div class="box-inner">
                                                                <span class="price">
                                                                    <span class="new">$38.50</span>
                                                                </span>
                                <div class="actions">
                                  <button title="Add To Cart"
                                          class="action add-to-cart"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Cart"><i
                                      class="pe-7s-shopbag"></i></button>
                                  <button class="action wishlist" title="Wishlist"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Wishlist"><i
                                      class="pe-7s-like"></i></button>
                                  <button class="action quickview"
                                          data-link-action="quickview" title="Quick view"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal"><i
                                      class="pe-7s-look"></i></button>
                                  <button class="action compare" title="Compare"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Compare"><i
                                      class="pe-7s-refresh-2"></i></button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="shop-list-wrapper mb-30px">
                        <div class="row">
                          <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">
                            <div class="product">
                              <div class="thumb">
                                <a href="single-product.html" class="image">
                                  <img src="@/assets/images/product-image/2.webp"
                                       alt="Product"/>
                                  <img class="hover-image"
                                       src="@/assets/images/product-image/2.webp"
                                       alt="Product"/>
                                </a>
                                <span class="badges">
                                                                    <span class="sale">-10%</span>
                                                                    <span class="new">New</span>
                                                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-7 col-lg-7 col-xl-8">
                            <div class="content-desc-wrap">
                              <div class="content">
                                                                <span class="category"><a
                                                                    href="#">Accessories</a></span>
                                <h5 class="title"><a
                                    href="single-product.html">Bluetooth Headphone
                                </a></h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                  elit,
                                  sed do eiusmodol tempor incididunt ut labore et
                                  dolore
                                  magna aliqua. Ut enim ad minim veni quis nostrud
                                  exercitation ullamco laboris </p>
                              </div>
                              <div class="box-inner">
                                                                <span class="price">
                                                                    <span class="old">$48.50</span>
                                                                    <span class="new">$38.50</span>
                                                                </span>
                                <div class="actions">
                                  <button title="Add To Cart"
                                          class="action add-to-cart"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Cart"><i
                                      class="pe-7s-shopbag"></i></button>
                                  <button class="action wishlist" title="Wishlist"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Wishlist"><i
                                      class="pe-7s-like"></i></button>
                                  <button class="action quickview"
                                          data-link-action="quickview" title="Quick view"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal"><i
                                      class="pe-7s-look"></i></button>
                                  <button class="action compare" title="Compare"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Compare"><i
                                      class="pe-7s-refresh-2"></i></button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="shop-list-wrapper mb-30px">
                        <div class="row">
                          <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">
                            <div class="product">
                              <div class="thumb">
                                <a href="single-product.html" class="image">
                                  <img src="@/assets/images/product-image/3.webp"
                                       alt="Product"/>
                                  <img class="hover-image"
                                       src="@/assets/images/product-image/3.webp"
                                       alt="Product"/>
                                </a>
                                <span class="badges">
                                                                    <span class="new">Sale</span>
                                                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-7 col-lg-7 col-xl-8">
                            <div class="content-desc-wrap">
                              <div class="content">
                                                                <span class="category"><a
                                                                    href="#">Accessories</a></span>
                                <h5 class="title"><a href="single-product.html">Smart
                                  Music Box</a></h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                  elit,
                                  sed do eiusmodol tempor incididunt ut labore et
                                  dolore
                                  magna aliqua. Ut enim ad minim veni quis nostrud
                                  exercitation ullamco laboris </p>
                              </div>
                              <div class="box-inner">
                                                                <span class="price">
                                                                    <span class="new">$38.50</span>
                                                                </span>
                                <div class="actions">
                                  <button title="Add To Cart"
                                          class="action add-to-cart"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Cart"><i
                                      class="pe-7s-shopbag"></i></button>
                                  <button class="action wishlist" title="Wishlist"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Wishlist"><i
                                      class="pe-7s-like"></i></button>
                                  <button class="action quickview"
                                          data-link-action="quickview" title="Quick view"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal"><i
                                      class="pe-7s-look"></i></button>
                                  <button class="action compare" title="Compare"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Compare"><i
                                      class="pe-7s-refresh-2"></i></button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="shop-list-wrapper mb-30px">
                        <div class="row">
                          <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">
                            <div class="product">
                              <div class="thumb">
                                <a href="single-product.html" class="image">
                                  <img src="@/assets/images/product-image/4.webp"
                                       alt="Product"/>
                                  <img class="hover-image"
                                       src="@/assets/images/product-image/4.webp"
                                       alt="Product"/>
                                </a>
                                <span class="badges">
                                                                    <span class="new">New</span>
                                                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-7 col-lg-7 col-xl-8">
                            <div class="content-desc-wrap">
                              <div class="content">
                                                                <span class="category"><a
                                                                    href="#">Accessories</a></span>
                                <h5 class="title"><a href="single-product.html">Air Pods
                                  25Hjkl Black</a></h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                  elit,
                                  sed do eiusmodol tempor incididunt ut labore et
                                  dolore
                                  magna aliqua. Ut enim ad minim veni quis nostrud
                                  exercitation ullamco laboris </p>
                              </div>
                              <div class="box-inner">
                                                                <span class="price">
                                                                    <span class="new">$38.50</span>
                                                                </span>
                                <div class="actions">
                                  <button title="Add To Cart"
                                          class="action add-to-cart"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Cart"><i
                                      class="pe-7s-shopbag"></i></button>
                                  <button class="action wishlist" title="Wishlist"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Wishlist"><i
                                      class="pe-7s-like"></i></button>
                                  <button class="action quickview"
                                          data-link-action="quickview" title="Quick view"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal"><i
                                      class="pe-7s-look"></i></button>
                                  <button class="action compare" title="Compare"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Compare"><i
                                      class="pe-7s-refresh-2"></i></button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="shop-list-wrapper mb-30px">
                        <div class="row">
                          <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">
                            <div class="product">
                              <div class="thumb">
                                <a href="single-product.html" class="image">
                                  <img src="@/assets/images/product-image/5.webp"
                                       alt="Product"/>
                                  <img class="hover-image"
                                       src="@/assets/images/product-image/6.webp"
                                       alt="Product"/>
                                </a>
                                <span class="badges">
                                                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-7 col-lg-7 col-xl-8">
                            <div class="content-desc-wrap">
                              <div class="content">
                                                                <span class="category"><a
                                                                    href="#">Accessories</a></span>
                                <h5 class="title"><a href="single-product.html">Smart
                                  Hand Watch</a></h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                  elit,
                                  sed do eiusmodol tempor incididunt ut labore et
                                  dolore
                                  magna aliqua. Ut enim ad minim veni quis nostrud
                                  exercitation ullamco laboris </p>
                              </div>
                              <div class="box-inner">
                                                                <span class="price">
                                                                    <span class="new">$38.50</span>
                                                                </span>
                                <div class="actions">
                                  <button title="Add To Cart"
                                          class="action add-to-cart"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Cart"><i
                                      class="pe-7s-shopbag"></i></button>
                                  <button class="action wishlist" title="Wishlist"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Wishlist"><i
                                      class="pe-7s-like"></i></button>
                                  <button class="action quickview"
                                          data-link-action="quickview" title="Quick view"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal"><i
                                      class="pe-7s-look"></i></button>
                                  <button class="action compare" title="Compare"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Compare"><i
                                      class="pe-7s-refresh-2"></i></button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="shop-list-wrapper mb-30px">
                        <div class="row">
                          <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">
                            <div class="product">
                              <div class="thumb">
                                <a href="single-product.html" class="image">
                                  <img src="@/assets/images/product-image/7.webp"
                                       alt="Product"/>
                                  <img class="hover-image"
                                       src="@/assets/images/product-image/7.webp"
                                       alt="Product"/>
                                </a>
                                <span class="badges">
                                                                    <span class="sale">-10%</span>
                                                                </span>
                              </div>
                            </div>
                          </div>
                          <div class="col-md-7 col-lg-7 col-xl-8">
                            <div class="content-desc-wrap">
                              <div class="content">
                                                                <span class="category"><a
                                                                    href="#">Accessories</a></span>
                                <h5 class="title"><a href="single-product.html">Smart
                                  Table Camera</a></h5>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                                  elit,
                                  sed do eiusmodol tempor incididunt ut labore et
                                  dolore
                                  magna aliqua. Ut enim ad minim veni quis nostrud
                                  exercitation ullamco laboris </p>
                              </div>
                              <div class="box-inner">
                                                                <span class="price">
                                                                    <span class="old">$48.50</span>
                                                                    <span class="new">$38.50</span>
                                                                </span>
                                <div class="actions">
                                  <button title="Add To Cart"
                                          class="action add-to-cart"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Cart"><i
                                      class="pe-7s-shopbag"></i></button>
                                  <button class="action wishlist" title="Wishlist"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Wishlist"><i
                                      class="pe-7s-like"></i></button>
                                  <button class="action quickview"
                                          data-link-action="quickview" title="Quick view"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal"><i
                                      class="pe-7s-look"></i></button>
                                  <button class="action compare" title="Compare"
                                          data-bs-toggle="modal"
                                          data-bs-target="#exampleModal-Compare"><i
                                      class="pe-7s-refresh-2"></i></button>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- Tab Content Area End -->

              <!--  Pagination Area Start -->
              <div class="pro-pagination-style text-center text-lg-end" data-aos="fade-up"
                   data-aos-delay="200">
                <div class="pages">
                  <ul id="paginationList">
                    <li class="li"><a class="page-link" href="#" @click="changeActive(0)"><i
                        class="fa fa-angle-left"></i></a>
                    </li>
                    <li class="li"><a class="page-link" href="#" @click="changeActive(1)">1</a>
                    </li>
                    <li class="li"><a class="page-link active" href="#"
                                      @click="changeActive(2)">2</a></li>
                    <li class="li"><a class="page-link" href="#" @click="changeActive(3)">3</a>
                    </li>
                    <li class="li"><a class="page-link" href="#" @click="changeActive(4)"><i
                        class="fa fa-angle-right"></i></a>
                    </li>
                  </ul>
                </div>
              </div>
              <!--  Pagination Area End -->
            </div>
            <!-- Shop Bottom Area End -->
          </div>

          <!-- Sidebar Area Start -->
          <div class="col-lg-3 order-lg-first col-md-12 order-md-last">
            <div class="shop-sidebar-wrap">
              <!-- Sidebar single item -->
              <div class="sidebar-widget">
                <h4 class="sidebar-title">Top Categories</h4>
                <div class="sidebar-widget-category">
                  <div>
                    <ul class="sub-menu">
                      <li @click="filterBooks('Earth Sciences')"><a href="#">Earth Sciences</a></li>
                      <li @click="filterBooks('Health & Fitness')"><a href="#">Health & Fitness</a></li>
                      <li @click="filterBooks('Nature, Animals & Pets')"><a href="#">Nature, Animals & Pets</a></li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="sidebar-widget">
                <h4 class="sidebar-title">Color</h4>
                <div class="sidebar-widget-color">
                  <ul class="d-flex flex-wrap">
                    <li><a href="#" class="color-1"></a></li>
                    <li><a href="#" class="color-2"></a></li>
                    <li><a href="#" class="color-3"></a></li>
                    <li><a href="#" class="color-4"></a></li>
                    <li><a href="#" class="color-5"></a></li>
                    <li><a href="#" class="color-6"></a></li>
                    <li><a href="#" class="color-7"></a></li>
                    <li><a href="#" class="color-8"></a></li>
                    <li><a href="#" class="color-9"></a></li>
                    <li><a href="#" class="color-10"></a></li>
                    <li><a href="#" class="color-11"></a></li>
                    <li><a href="#" class="color-12"></a></li>
                    <li><a href="#" class="color-13"></a></li>
                    <li><a href="#" class="color-14"></a></li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Shop Page End  -->
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
                    <a href="src/assets/html/wishlist.html"><i class="pe-7s-like"></i></a>
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
// import {changeActive} from "@/common/pagination";
import {onLogout} from "@/common/LoginHook";
import {useMenuData} from "@/pc/common/menuData"
import {computed, ref} from "vue";
// initMenuData()
import router from "@/common/router";

const initialClassName = 'item-div'
const {initMenuData} = useMenuData()
const menuArrRef = ref()
initMenuData(initialClassName, menuArrRef)
let lastClickedItem: any = null

import {usePageBookLibrary} from '@/pc/business/house/hook/bookLibraryHook'

const {hasPerm, toShow, initPage, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
  setPageNo,
  toCreate, toUpdate, deleteBookLibrary, importExcel, exportExcel
}=usePageBookLibrary()
initPage()

const activeType = ref(null);

const booksToShow = computed(() => {
  return activeType.value
      ? bookLibraryEntityList.value.filter((book) => book.type.includes(activeType.value))
      : bookLibraryEntityList.value;
});

const filterBooks = (bookType) => {
  activeType.value = bookType;
};


function logout(item: any) {
onLogout()
location.assign('/pc/login')
}
function changeActive(index: number) {
  const links = document.querySelectorAll('#paginationList .page-link');
  let activeIndex = 0;

  links.forEach((link, i) => {
    if (link.classList.contains('active')) {
      activeIndex = i;
    }
  });

  links.forEach((link, i) => {
    if (i === index && index !== 0 && index !== 3) {
      link.classList.add('active');
    } else {
      link.classList.remove('active');
    }
  });

  if (index === 0) {
    console.log(index);
    const prevIndex = activeIndex - 1;
    if (prevIndex >=1) {
      links[prevIndex].classList.add('active');
    }
    else
      links[1].classList.add('active');
  } else {
    links[index].classList.add('active');
  }

  if (index === 4) {
    const nextIndex = activeIndex + 1;
    if (nextIndex <=3) {
      links[nextIndex].classList.add('active');
    }
    else
      links[3].classList.add('active');
  } else {
    links[index].classList.add('active');
  }
}

function toggleChildrenDisplay(item: any) {
console.log(item.childrenDisplay == "block")
if (item.childrenDisplay == "block") {
item.childrenDisplay = "none";
} else {
item.childrenDisplay = "block";
}
}

function clickItem(child: any) {
if (null != lastClickedItem) {
lastClickedItem.className = 'item-div'
}
child.className = 'clicked-item-div'
lastClickedItem = child
const toPath = child.path
router.replace({path: '/pc/empty', query: {toPath: toPath}})
}



</script>
<style scoped>
@import "src/assets/css/plugins.min.css";
@import "src/assets/css/style.min.css";

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
