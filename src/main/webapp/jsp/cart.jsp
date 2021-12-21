<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Metaverse Laptop</title>
    <link rel="icon" href="../image/logo-re.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/fontawesome.min.css"
          integrity="sha512-Rcr1oG0XvqZI1yv1HIg9LgZVDEhf2AHjv+9AuD1JXWGLzlkoKDVvE925qySLcEywpMAYA/rkg296MkvqBF07Yw=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="../css/cart.css">
    <link href="../css/responsiveIndex.css" rel="stylesheet">
    <link href="../fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/cartResponsive.css">
</head>
<body>
<div id="cart-main">

    <%@include file="../layout/header.jsp" %>
    <div class="cart" class="bg-gray">
        <div class="container padding padding-top-60">
            <div class="address-menu">
                <div class="sub-container">
                    <div class="home-btn sub-container-content">
                        <a role="button" class="btn-circle white-bg" href="../index.jsp">
                            <i class="fas fa-home"></i>
                        </a>
                    </div>
                    <div class="arrow">
                        <i class="fas fa-arrow-right"></i>
                    </div>
                    <div class="current-btn sub-container-content">
                        <span class="info-content black-text rounded-border">Giỏ hàng</span>
                    </div>
                </div>
            </div>
            <div class="cart-info">
                <div class="left-content">
                    <div id="your-cart">
                        <div class="container">
                            <div class="top-content">
                                <div class="top-content-container">
                                    <div class="title">
                                    <span class="content">
                                        <span class="big-text bolder">Giỏ hàng của bạn</span>
                                    </span>
                                    </div>
                                    <div class="btn-clear">
                                        <button class="clear">
                                            <span>Xóa tất cả</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="cart-item">
                        <div class="cart-container">
                            <div class="cart-header">
                                <div class="left-provider-content">
                                    <div class="provider-container">
                                        <div class="provider-padding provider-checkbox">
                                            <input type="checkbox" name="checkAllProduct" value="">
                                        </div>
                                        <div class="provider-padding-left provider-info">
                                            <div class="provider-icon">
                                                <img class="provider-logo" src="../image/asus-logo.png" alt="Asus">
                                            </div>
                                        </div>
                                        <div class="provider-padding provider-name">
                                            <span class="normal-text bolder">Asus</span>
                                        </div>
                                        <div class="provider-padding verified-logo">
                                            <i class="fas fa-check-circle"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="right-provider-content">
                                    <span class="total-pay blue-text bolder"> 84000000<span>đ</span></span>
                                </div>
                            </div>
                            <div class="cart-item-info">
                                <div class="container">
                                    <div class="item">
                                        <div class="left-cart-item">
                                            <div class="item-checkbox item-padding">
                                                <input type="checkbox" name="checkItem" value="">
                                            </div>
                                            <div class="item-thumbnail item-padding">
                                                <img class="item-logo-thumbnail" src="../image/man-hinh-asus.jpg">
                                            </div>
                                            <div class="item-info-container item-padding">
                                                <span class="item-info-name smaller-text">Màn hình LCD ASUS VL249HE (1920 x 1080/IPS/75Hz/5 ms)</span>
                                                <span class=" item-info-sku smaller-text light-gray-text">Mã Laptop: 191100961</span>
                                            </div>
                                        </div>
                                        <div class="right-cart-item">
                                            <div class="btn-add-subtract">
                                                <button class="btn-padding btn-subtract">
                                                    <i class="icon-btn fas fa-chevron-down"></i>
                                                </button>
                                                <div class="btn-padding number">1</div>
                                                <button class="btn-padding btn-add">
                                                    <i class="icon-btn fas fa-chevron-up"></i>
                                                </button>
                                            </div>
                                            <div class="price">
                                                <span class="bolder gray-text price-text">4300000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="cart-item-info">
                                <div class="container">
                                    <div class="item">
                                        <div class="left-cart-item">
                                            <div class="item-checkbox item-padding">
                                                <input type="checkbox" name="checkItem" value="">
                                            </div>
                                            <div class="item-thumbnail item-padding">
                                                <img class="item-logo-thumbnail" src="../image/man-hinh-asus.jpg">
                                            </div>
                                            <div class="item-info-container item-padding">
                                                <span class="item-info-name smaller-text">Màn hình LCD ASUS VL249HE (1920 x 1080/IPS/75Hz/5 ms)</span>
                                                <span class=" item-info-sku smaller-text light-gray-text">Mã Laptop: 191100961</span>
                                            </div>
                                        </div>
                                        <div class="right-cart-item">
                                            <div class="btn-add-subtract">
                                                <button class="btn-padding btn-subtract">
                                                    <i class="icon-btn fas fa-chevron-down"></i>
                                                </button>
                                                <div class="btn-padding number">1</div>
                                                <button class="btn-padding btn-add">
                                                    <i class="icon-btn fas fa-chevron-up"></i>
                                                </button>
                                            </div>
                                            <div class="price">
                                                <span class="bolder gray-text price-text">4300000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="cart-item-info">
                                <div class="container">
                                    <div class="item">
                                        <div class="left-cart-item">
                                            <div class="item-checkbox item-padding">
                                                <input type="checkbox" name="checkItem" value="">
                                            </div>
                                            <div class="item-thumbnail item-padding">
                                                <img class="item-logo-thumbnail" src="../image/man-hinh-asus.jpg">
                                            </div>
                                            <div class="item-info-container item-padding">
                                                <span class="item-info-name smaller-text">Màn hình LCD ASUS VL249HE (1920 x 1080/IPS/75Hz/5 ms)</span>
                                                <span class=" item-info-sku smaller-text light-gray-text">Mã Laptop: 191100961</span>
                                            </div>
                                        </div>
                                        <div class="right-cart-item">
                                            <div class="btn-add-subtract">
                                                <button class="btn-padding btn-subtract">
                                                    <i class="icon-btn fas fa-chevron-down"></i>
                                                </button>
                                                <div class="btn-padding number">1</div>
                                                <button class="btn-padding btn-add">
                                                    <i class="icon-btn fas fa-chevron-up"></i>
                                                </button>
                                            </div>
                                            <div class="price">
                                                <span class="bolder gray-text price-text">4300000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>


                        </div>
                    </div>
                    <div class="cart-item">
                        <div class="cart-container">
                            <div class="cart-header">
                                <div class="left-provider-content">
                                    <div class="provider-container">
                                        <div class="provider-padding provider-checkbox">
                                            <input type="checkbox" name="checkAllProduct" value="">
                                        </div>
                                        <div class="provider-padding-left provider-info">
                                            <div class="provider-icon">
                                                <img class="provider-logo" src="../image/asus-logo.png" alt="Asus">
                                            </div>
                                        </div>
                                        <div class="provider-padding provider-name">
                                            <span class="normal-text bolder">Asus</span>
                                        </div>
                                        <div class="provider-padding verified-logo">
                                            <i class="fas fa-check-circle"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="right-provider-content">
                                    <span class="total-pay blue-text bolder"> 84000000<span>đ</span></span>
                                </div>
                            </div>
                            <div class="cart-item-info">
                                <div class="container">
                                    <div class="item">
                                        <div class="left-cart-item">
                                            <div class="item-checkbox item-padding">
                                                <input type="checkbox" name="checkItem" value="">
                                            </div>
                                            <div class="item-thumbnail item-padding">
                                                <img class="item-logo-thumbnail" src="../image/man-hinh-asus.jpg">
                                            </div>
                                            <div class="item-info-container item-padding">
                                                <span class="item-info-name smaller-text">Màn hình LCD ASUS VL249HE (1920 x 1080/IPS/75Hz/5 ms)</span>
                                                <span class=" item-info-sku smaller-text light-gray-text">Mã Laptop: 191100961</span>
                                            </div>
                                        </div>
                                        <div class="right-cart-item">
                                            <div class="btn-add-subtract">
                                                <button class="btn-padding btn-subtract">
                                                    <i class="icon-btn fas fa-chevron-down"></i>
                                                </button>
                                                <div class="btn-padding number">1</div>
                                                <button class="btn-padding btn-add">
                                                    <i class="icon-btn fas fa-chevron-up"></i>
                                                </button>
                                            </div>
                                            <div class="price">
                                                <span class="bolder gray-text price-text">4300000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="cart-item-info">
                                <div class="container">
                                    <div class="item">
                                        <div class="left-cart-item">
                                            <div class="item-checkbox item-padding">
                                                <input type="checkbox" name="checkItem" value="">
                                            </div>
                                            <div class="item-thumbnail item-padding">
                                                <img class="item-logo-thumbnail" src="../image/man-hinh-asus.jpg">
                                            </div>
                                            <div class="item-info-container item-padding">
                                                <span class="item-info-name smaller-text">Màn hình LCD ASUS VL249HE (1920 x 1080/IPS/75Hz/5 ms)</span>
                                                <span class=" item-info-sku smaller-text light-gray-text">Mã Laptop: 191100961</span>
                                            </div>
                                        </div>
                                        <div class="right-cart-item">
                                            <div class="btn-add-subtract">
                                                <button class="btn-padding btn-subtract">
                                                    <i class="icon-btn fas fa-chevron-down"></i>
                                                </button>
                                                <div class="btn-padding number">1</div>
                                                <button class="btn-padding btn-add">
                                                    <i class="icon-btn fas fa-chevron-up"></i>
                                                </button>
                                            </div>
                                            <div class="price">
                                                <span class="bolder gray-text price-text">4300000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="cart-item-info">
                                <div class="container">
                                    <div class="item">
                                        <div class="left-cart-item">
                                            <div class="item-checkbox item-padding">
                                                <input type="checkbox" name="checkItem" value="">
                                            </div>
                                            <div class="item-thumbnail item-padding">
                                                <img class="item-logo-thumbnail" src="../image/man-hinh-asus.jpg">
                                            </div>
                                            <div class="item-info-container item-padding">
                                                <span class="item-info-name smaller-text">Màn hình LCD ASUS VL249HE (1920 x 1080/IPS/75Hz/5 ms)</span>
                                                <span class=" item-info-sku smaller-text light-gray-text">SKU: 191100961</span>
                                            </div>
                                        </div>
                                        <div class="right-cart-item">
                                            <div class="btn-add-subtract">
                                                <button class="btn-padding btn-subtract">
                                                    <i class="icon-btn fas fa-chevron-down"></i>
                                                </button>
                                                <div class="btn-padding number">1</div>
                                                <button class="btn-padding btn-add">
                                                    <i class="icon-btn fas fa-chevron-up"></i>
                                                </button>
                                            </div>
                                            <div class="price">
                                                <span class="bolder gray-text price-text">4300000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="right-content">
                    <div class="container">
                        <div class="coupon">
                            <div class="container">
                                <div class="coupon-header">
                                    <span class="coupon-text">Mã giảm giá</span>
                                    <div class="coupon-input-container">
                                        <input class="coupon-input" type="text" placeholder="Nhập mã của bạn">
                                        <button class="confirm-btn"><span>Áp dụng ngay</span></button>
                                    </div>
                                </div>
                                <div class="break">
                                    <hr class="hr-break">
                                </div>
                                <div class="list-applied-coupon">
                                    <div class="coupon container">
                                        <div class="applied-coupon-left">
                                            <div class="coupon-applied">
                                                <div class="coupon-code">
                                                    <span class="bolder larger-text">123Y681209</span>
                                                </div>
                                                <div class="coupon-name padding-10">
                                                    <span class="blue-text smaller-text">Giảm giá 30% dành cho đồ điện tử</span>
                                                </div>
                                                <div class="active-day padding-10">
                                                    <span class="experied-day smaller-text">HSD:</span>
                                                    <span class="red-text smaller-text">đến 30/10/2021</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="applied-coupon-right">
                                            <div class="returned-money">
                                                <span>-</span>
                                                <span class="blue-text">30000<span>đ</span></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="coupon container">
                                        <div class="applied-coupon-left">
                                            <div class="coupon-applied">
                                                <div class="coupon-code">
                                                    <span class="bolder larger-text">123Y681209</span>
                                                </div>
                                                <div class="coupon-name padding-10">
                                                    <span class="blue-text smaller-text">Giảm giá 30% dành cho đồ điện tử</span>
                                                </div>
                                                <div class="active-day padding-10">
                                                    <span class="experied-day smaller-text">HSD:</span>
                                                    <span class="red-text smaller-text">đến 30/10/2021</span>
                                                </div>

                                            </div>
                                        </div>

                                        <div class="applied-coupon-right">
                                            <span>-</span>
                                            <span class="blue-text returned-money">30000<span>đ</span></span>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="cash">
                            <div class="container">
                                <div class="cash-title">
                                    <span class="large-text bolder">Thanh toán</span>
                                </div>
                                <!-- <div class="provisional-price" class="padding-10">
                                    <span class="left gray-text">Tạm tính</span>
                                    <span class="right provisional-cash bolder">4300000<span>đ</span></span>
                                </div> -->
                                <div class="final-price" class="padding-10 padding-bottom-20">
                                    <span class="left gray-text">Thành tiền</span>
                                    <span class="right final-cash large-text red-text bolder">4300000<span>đ</span></span>
                                </div>
                                <!-- <div class="VAT" class="padding-10">
                                    <span class="gray-text">(Đã bao gồm VAT)</span>
                                </div> -->
                                <div class="buy">
                                    <button class="buy-btn">Mua hàng</button>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="../layout/footer.jsp" %>
</div>
<%@include file="../layout/login.jsp" %>
<%@include file="../layout/fogot.jsp" %>
<%@include file="../layout/register.jsp" %>
<!--Back to top-->
<%@include file="../layout/back-to-top.jsp" %>
</body>
<script src="../js/register.js"></script>
<script crossorigin="anonymous" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        referrerpolicy="no-referrer"
        src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script src="../js/nav-responsive.js"></script>
<script src="../js/BackToTop.js"></script>
<script src="../js/Scroll-Indicator.js"></script>
</html>
