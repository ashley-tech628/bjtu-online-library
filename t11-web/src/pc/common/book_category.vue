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
                <li><a href="/pc/main/bookshelf">Bookshelf</a></li>
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
          <li><a href="/pc/main/myAccount"><i class="fa fa-user"></i> Account</a></li>
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
              <!--              <p class="compare-product"><span>6</span> Product Found of <span>12</span></p>-->
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
                  <button class="dropdown-toggle header-action-btn" data-bs-toggle="dropdown">{{ currentSort }}
                    <i class="fa fa-angle-down"></i></button>
                  <ul class="dropdown-menu dropdown-menu-right">
                    <li><a class="dropdown-item" @click="sortBooks" href="#">Title, A to Z</a>
<!--                    <button @click="sortBooks">Sort</button>-->
<!--                      <ul>-->
<!--                        <li v-for="book in dataShow" :key="book.id">-->
<!--                          {{ book.title }}-->
<!--                        </li>-->
<!--                      </ul>-->
                    </li>
                    <li><a class="dropdown-item" @click="sortAlterBooks" href="#">Title, Z to A</a></li>
                    <li><a class="dropdown-item" @click="sortAuthor"  href="#">Author</a></li>
                  </ul>
                </div>
                <!-- Single Wedge Start -->
              </div>
              <!-- Right Side End -->
            </div>
            <!-- Shop Top Area End -->
            <!-- Shop Bottom Area Start -->
            <div class="shop-bottom-area">
<!--              <p> {{showBookLibrary(bookLibraryEntityList)}} </p>-->
              <!-- Tab Content Area Start -->
              <div class="row">
                <div class="col">
                  <div class="tab-content">
                    <div class="tab-pane fade show active" id="shop-grid">
                      <div class="row mb-n-30px">
                        <!--                        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">-->
                        <!--                        <div v-for="(book, index) in bookLibraryEntityList" :key="book.id" class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">-->
<!--                        <ul v-for="(page, index) in totalPage" :key="index">-->
<!--                          <li v-for="book in page" :key="book.id" class="book-item">-->
<!--                            <span>{{ book.name }}</span>-->
<!--                            &lt;!&ndash; Add other book properties as needed &ndash;&gt;-->
<!--                          </li>-->
<!--                        </ul>-->
                        <div v-for="book in dataShow" :key="book.id" class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">
                          <!-- Single Prodect -->
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
<!--                              <span class="category"><a>{{book.title}}</a></span>-->
                              <span class="category"><a>{{book.type}}</a></span>
                              <h5 class="title"><a @click = "toBookDetails(book.id)">{{book.title}}
                              </a>
                              </h5>
                              <span class="category"><a>{{book.author}}</a></span>
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

<!--                        <div class="pagination">-->
<!--&lt;!&ndash;                          <p>{{ totalPage + "123" }}</p >&ndash;&gt;-->
<!--                          <button @click="prePage" :disabled="currentPage === 1">上一页</button>-->
<!--&lt;!&ndash;                          <button @click="refreshPageBeforeNext" :disabled="currentPage === 0">上一页</button>&ndash;&gt;-->
<!--                          <span>{{ currentPage }}</span>-->
<!--                          <button @click="refreshPageBeforeNext" :disabled="currentPage === totalPage">下一页</button>-->
<!--                        </div>-->

                        <!--                        <div class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">-->
                        <!--                          &lt;!&ndash; Single Prodect &ndash;&gt;-->
                        <!--                          <div class="product">-->
                        <!--                                                        <span class="badges">-->
                        <!--                                                        </span>-->
                        <!--                            <div class="thumb">-->
                        <!--                              <a href="single-product.html" class="image">-->
                        <!--                                <img src="../../assets/images/product-image/6.webp"-->
                        <!--                                     alt="Product"/>-->
                        <!--                                <img class="hover-image"-->
                        <!--                                     src="../../assets/images/product-image/6.webp"-->
                        <!--                                     alt="Product"/>-->
                        <!--                              </a>-->
                        <!--                            </div>-->
                        <!--                            <div class="content">-->
                        <!--                              <span class="category"><a href="#">Accessories</a></span>-->
                        <!--                              <h5 class="title"><a href="single-product.html">Smart Table-->
                        <!--                                Camera-->
                        <!--                              </a>-->
                        <!--                              </h5>-->
                        <!--                            </div>-->
                        <!--                            <div class="actions">-->
                        <!--                              <button class="action wishlist" title="Wishlist"-->
                        <!--                                      data-bs-toggle="modal"-->
                        <!--                                      data-bs-target="#exampleModal-Wishlist"><i-->
                        <!--                                  class="pe-7s-like"></i></button>-->
                        <!--                              <button class="action quickview"-->
                        <!--                                      data-link-action="quickview" title="Quick view"-->
                        <!--                                      data-bs-toggle="modal" data-bs-target="#exampleModal"><i-->
                        <!--                                  class="pe-7s-look"></i></button>-->
                        <!--                            </div>-->
                        <!--                          </div>-->
                        <!--                        </div>-->
                      </div>
                    </div>
<!--                    <div v-for="(item,index) in bookLibraryEntityList" :key="item.id"-->
<!--                    <div v-for="book in dataShow" :key="book.id" >-->
                      <div class="tab-pane fade mb-n-30px" id="shop-list">
                        <div class="shop-list-wrapper mb-30px">
<!--                          <div v-for="book in dataShow" :key="book.id" class="col-lg-4 col-md-6 col-sm-6 col-xs-6 mb-30px">-->
                          <div v-for="(item,index) in dataShow" :key="item.id" class="product-list-item">
                          <div class="row">
                            <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">
                              <div class="product">
                                <div class="thumb">
                                  <a @click = "toBookDetails(item.id)" class="image">
                                    <img :src="item.cover" alt="Product" />
                                    <img class="hover-image" :src="item.cover" alt="Product" />
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
                                  <h5 class="title"><a href="single-product.html">{{item.title}}</a></h5>
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
                        </div>
<!--                      </div>-->


<!--                      <div class="shop-list-wrapper mb-30px">-->
<!--                        <div class="row">-->
<!--                          <div class="col-md-5 col-lg-5 col-xl-4 mb-lm-30px">-->
<!--                            <div class="product">-->
<!--                              <div class="thumb">-->
<!--                                <a href="single-product.html" class="image">-->
<!--                                  <img src="../../assets/images/product-image/7.webp"-->
<!--                                       alt="Product"/>-->
<!--                                  <img class="hover-image"-->
<!--                                       src="../../assets/images/product-image/7.webp"-->
<!--                                       alt="Product"/>-->
<!--                                </a>-->
<!--                                <span class="badges">-->
<!--                                                                    <span class="sale">-10%</span>-->
<!--                                                                </span>-->
<!--                              </div>-->
<!--                            </div>-->
<!--                          </div>-->
<!--                          <div class="col-md-7 col-lg-7 col-xl-8">-->
<!--                            <div class="content-desc-wrap">-->
<!--                              <div class="content">-->
<!--                                                                <span class="category"><a-->
<!--                                                                    href="#">Accessories</a></span>-->
<!--                                <h5 class="title"><a href="single-product.html">Smart-->
<!--                                  Table Camera</a></h5>-->
<!--                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing-->
<!--                                  elit,-->
<!--                                  sed do eiusmodol tempor incididunt ut labore et-->
<!--                                  dolore-->
<!--                                  magna aliqua. Ut enim ad minim veni quis nostrud-->
<!--                                  exercitation ullamco laboris </p>-->
<!--                              </div>-->
<!--                              <div class="box-inner">-->
<!--                                                                <span class="price">-->
<!--                                                                    <span class="old">$48.50</span>-->
<!--                                                                    <span class="new">$38.50</span>-->
<!--                                                                </span>-->
<!--                                <div class="actions">-->
<!--                                  <button title="Add To Cart"-->
<!--                                          class="action add-to-cart"-->
<!--                                          data-bs-toggle="modal"-->
<!--                                          data-bs-target="#exampleModal-Cart"><i-->
<!--                                      class="pe-7s-shopbag"></i></button>-->
<!--                                  <button class="action wishlist" title="Wishlist"-->
<!--                                          data-bs-toggle="modal"-->
<!--                                          data-bs-target="#exampleModal-Wishlist"><i-->
<!--                                      class="pe-7s-like"></i></button>-->
<!--                                  <button class="action quickview"-->
<!--                                          data-link-action="quickview" title="Quick view"-->
<!--                                          data-bs-toggle="modal"-->
<!--                                          data-bs-target="#exampleModal"><i-->
<!--                                      class="pe-7s-look"></i></button>-->
<!--                                  <button class="action compare" title="Compare"-->
<!--                                          data-bs-toggle="modal"-->
<!--                                          data-bs-target="#exampleModal-Compare"><i-->
<!--                                      class="pe-7s-refresh-2"></i></button>-->
<!--                                </div>-->
<!--                              </div>-->
<!--                            </div>-->
<!--                          </div>-->
<!--                        </div>-->
<!--                      </div>-->
                    </div>
                  </div>
                </div>
              </div>
              <!-- Tab Content Area End -->

              <!--  Pagination Area Start -->
              <div class="pro-pagination-style text-center text-lg-end" data-aos="fade-up"
                   data-aos-delay="200">
                <div class="pages">
<!--                  <p>{{ totalPage.value +"123"}}</p >-->
                                    <ul id="paginationList">
                                      <li class="li"><a class="page-link" href="#" @click="prePage" :disabled="currentPage === 1"><i
                                          class="fa fa-angle-left"></i></a>
                                      </li>
                                      <li class="li" v-for="(page, index) in totalPage" :key="index + 1">
                                        <!-- 将每个索引加1传递给 changePage 方法 -->
                                        <a class="page-link" href="#" @click="changePage(index)" :class="{ active: currentPage === index + 1 }">
                                          {{ index + 1 }}
                                        </a>
                                      </li>
                                      <li class="li"><a class="page-link" href="#" @click="refreshPageBeforeNext" :disabled="currentPage === totalPage"><i
                                          class="fa fa-angle-right"></i></a>
                                      </li>
                                    </ul>

<!--                  <ul id="paginationList">-->
<!--                    <li class="li">-->
<!--                      <a class="page-link" href="#" @click="moveBorder('left')" :disabled="currentPage === 1">-->
<!--                        <i class="fa fa-angle-left"></i>-->
<!--                      </a>-->
<!--                    </li>-->
<!--                    <li class="li">-->
<!--                      <a class="page-link" href="#" @click="moveBorder('1')" :disabled="currentPage === 1">1</a>-->
<!--                    </li>-->
<!--                    <li class="li">-->
<!--                      <a class="page-link active" href="#" @click="moveBorder('2')">2</a>-->
<!--                    </li>-->
<!--                    <li class="li">-->
<!--                      <a class="page-link" href="#" @click="moveBorder('right')" :disabled="currentPage === totalPage">-->
<!--                        <i class="fa fa-angle-right"></i>-->
<!--                      </a>-->
<!--                    </li>-->
<!--                  </ul>-->





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
                  <ul>
                    <li><a href="/pc/main/category" class="selected m-0" @click="changePageCount(6)"> All
                      <span>(36)</span> </a></li>
                    <li><a href="#"  @click="filterBooks('Earth Sciences')"> Earth Sciences
                      <span>(12)</span> </a></li>
                    <li><a href="#" class="" @click="filterBooks('Health & Fitness')"> Health & Fitness
                      <span>(12)</span> </a></li>
                    <li><a href="#" class="" @click="filterBooks('Nature, Animals & Pets')"> Nature, Animals & Pets
                      <span>(12)</span> </a></li>
                  </ul>
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
<!--              <img src="@/assets/images/product-image/1.webp" alt="Modern Smart Phone">-->
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
import {computed, onMounted, ref} from "vue";
// initMenuData()
import router from "@/common/router";

const initialClassName = 'item-div'
const {initMenuData} = useMenuData()
const menuArrRef = ref()
initMenuData(initialClassName, menuArrRef)
let lastClickedItem: any = null
//
// import {usePageBookLibrary} from '@/pc/business/bookLibrary/hook/bookLibraryHook'
//
// const {hasPerm, toShow, initPage: initBookLibrary, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
//   setPageNo,
//   toCreate, toUpdate, deleteBookLibrary, importExcel, exportExcel
// }=usePageBookLibrary()

import {useBookLibrary} from '@/pc/business/bookLibrary/hook/bookLibraryHook'

const {hasPerm, toShow, initPage2: initBookLibrary, bookLibraryParam, bookLibraryRelateList,  bookLibraryEntityList,
  setPageNo,
  toCreate, toUpdate, deleteBookLibrary, importExcel, exportExcel
}=useBookLibrary()
initBookLibrary()

const activeType = ref(null);

const booksToShow = computed(() => {
  return activeType.value
      ? bookLibraryEntityList.value.filter((book) => book.type.includes(activeType.value))
      : bookLibraryEntityList.value;
});

const books = ref(bookLibraryEntityList);
const filterBooks =(bookType) => {
  activeType.value = bookType;
   // router.push({path:'/pc/main/category'});
  // refreshPage();
  currentPage.value = 0
  // books.value = books.value.filter(book => bookType.includes(book.type))
  // books.value = books.value.filter(book => book.type === bookType);
  // refreshPage()
  // const originalBooks = bookLibraryEntityList;
  //
  // // 使用 Array.prototype.filter 过滤符合条件的书籍
  // books.value = originalBooks.filter(book => book.type === bookType);

};
const filterBook =(bookType) => {
  books.value = books.value.filter(book => book.type === bookType);
}

const sortBooks = () => {
  books.value.sort((a, b) => {
    const titleA = a.title.toUpperCase();
    const titleB = b.title.toUpperCase();

    if (titleA < titleB) {
      return -1;
    }
    if (titleA > titleB) {
      return 1;
    }
    return 0;
  });
  updateSort('Title, A to Z');
};

const sortAuthor = () => {
  books.value.sort((a, b) => {
    const authorA = a.author.toUpperCase();
    const authorB = b.author.toUpperCase();

    if (authorA < authorB) {
      return -1;
    }
    if (authorA > authorB) {
      return 1;
    }
    return 0;
  });
  updateSort('Author');
};


const sortAlterBooks = () => {
  books.value.sort((a, b) => {
    const titleA = a.title.toUpperCase();
    const titleB = b.title.toUpperCase();

    if (titleA > titleB) {
      return -1; // 将返回值调整为 -1，以实现从 Z 到 A 的排序
    }
    if (titleA < titleB) {
      return 1; // 将返回值调整为 1，以实现从 Z 到 A 的排序
    }
    return 0;
  });
  updateSort('Title, Z to A');
};


import { useInPage } from '@/framework/page/usePage'
const { total, pageNo, pageCount, pageCountSliceArr,
  prevPageNo, nextPageNo, toPageNo, pageNoClass, } = useInPage()

function showBookLibrary(bookLibrary)
{
  console.log("Books: "+bookLibrary)
}

const currentSort = ref('Default');

const updateSort = (sortType) => {
  currentSort.value = sortType;
  // 这里可以添加其他逻辑，比如调用排序函数
};

function logout(item: any) {
  onLogout()
  location.assign('/pc/login')
}


// function changePage(index:number){
//   changeActive(number);
//   goToPage(number);
// }
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
function toBookDetails(bookId)
{
  router.push({path:'/pc/main/bookInfo/'+bookId})
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





const pageSize = 6;
const pageNum = computed(() => Math.ceil(booksToShow.value.length / pageSize) || 1);
const totalPage = computed(() => {
  const pages = [];
  for (let i = 0; i < pageNum.value; i++) {
    pages[i] = booksToShow.value.slice(pageSize * i, pageSize * (i + 1));
  }
  return pages;
});

const currentPage = ref(0);
const dataShow = computed(() => totalPage.value[currentPage.value]);

const nextPage = () => {
  if (currentPage.value === pageNum.value - 1) return;
  currentPage.value++;
  // refreshPage(); // Refresh the page before moving to the next page
};

const prePage = () => {
  if (currentPage.value === 0) return;
  currentPage.value--;
  // changeActive(1);
  // moveBorder('left');
};

const goToPage = (i) => {
  currentPage.value = i - 1;
};

const changePage = (page) => {
  currentPage.value = page;
};

const refreshPageBeforeNext = () => {
  nextPage();
  // refreshPage();
};
const refreshPage = () => {
  location.reload();
};


const moveBorder = (direction) => {
  const paginationList = document.getElementById('paginationList');
  const activeElement = paginationList.querySelector('.active');
  const activeElementRect = activeElement.getBoundingClientRect();

  if (direction === 'left') {
    paginationList.style.setProperty('--border-translate', `-${activeElementRect.width}px`);
  } else if (direction === 'right') {
    paginationList.style.setProperty('--border-translate', `${activeElementRect.width}px`);
  } else {
    paginationList.style.setProperty('--border-translate', '0');
  }

  // Your existing logic for changing the active page goes here
};


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
