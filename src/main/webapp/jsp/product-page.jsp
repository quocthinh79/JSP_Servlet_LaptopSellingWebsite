<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <title>Product</title>
    <title>Metaverse Laptop</title>
    <link rel="icon" href="${root}image/logo-re.png">
    <link href="${root}css/style-product.css" rel="stylesheet">
    <link href="${root}css/responsiveIndex.css" rel="stylesheet">
    <link href="${root}fonts/themify-icons/themify-icons.css" rel="stylesheet">
    <link href="${root}fonts/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet">
    <link href="${root}fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
          integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
          referrerpolicy="no-referrer" rel="stylesheet"/>
    <!--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css" integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A==" crossorigin="anonymous" referrerpolicy="no-referrer" />-->
    <link crossorigin="anonymous" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
          integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
          referrerpolicy="no-referrer" rel="stylesheet"/>

    <link rel="stylesheet" href="${root}css/reponsiveProduct.css">
</head>

<body>
<jsp:include page="../layout/header.jsp">
    <jsp:param name="productPage" value="product-page.jsp"/>
    <jsp:param name="tutorialPage" value="tutorial-page.jsp"/>
    <jsp:param name="aboutUs" value="about-us.jsp"/>
    <jsp:param name="cartPage" value="cart.jsp"/>
    <jsp:param name="indexPage" value="${root}index.jsp"/>
</jsp:include>
<%@include file="../layout/cart-hover.jsp" %>
<jsp:useBean id="productID" scope="request" type="java.util.List"/>
<c:forEach var="x" items="${productID}">
<div id="view-image-product">
    <div id="close-view-image-product"><i class="fas fa-times"></i></div>
    <div class="big-image-view-product" style="background-image: url('${root}${x.linkHinh1}')"></div>
    <div class="items-image-view-product">
        <div class="item-image-view-product"
             style="background-image: url('${root}${x.linkHinh1}')"></div>
        <div class="item-image-view-product"
             style="background-image: url('${root}${x.linkHinh2}')"></div>
        <div class="item-image-view-product"
             style="background-image: url('${root}${x.linkHinh3}')"></div>
        <div class="item-image-view-product"
             style="background-image: url('${root}${x.linkHinh4}')"></div>
        <div class="item-image-view-product"
             style="background-image: url('${root}${x.linkHinh5}')"></div>
    </div>
</div>
<div id="product-page">
    <div id="content-product">
            <div class="infor-product">
                <div class="product-details">
                    <div id="product-image" class="product-image"
                         style='background-image: url("${root}${x.linkHinh1}")'></div>
                    <div class="details-image">
                        <div class="details-image-item"
                             style='background-image: url("${root}${x.linkHinh1}")'></div>
                        <div class="details-image-item"
                             style="background-image: url('${root}${x.linkHinh2}')"></div>
                        <div class="details-image-item"
                             style="background-image: url('${root}${x.linkHinh3}')"></div>
                        <div class="details-image-item"
                             style="background-image: url('${root}${x.linkHinh4}')"></div>
                        <div class="details-image-item"
                             style="background-image: url('${root}${x.linkHinh5}')"></div>
                    </div>
                    <div class="border-pro"></div>
                    <div class="css-17aam1">- Kích thước: ${x.kichThuocManHinh}<br> - Tấm nền IPS, Góc nhìn:
                        178
                        (H) / 178 (V)<br> - Tần số quét: 60Hz , Thời gian phản hồi 5 ms<br>- HIển thị màu sắc: 16.7
                        triệu
                        màu<br> - Cổng hình ảnh: 1 x DisplayPort 1.2a, 1 x HDMI 1.4, 1 x VGA/D-sub
                    </div>
                </div>
                <div class="product-sale">
                    <h1 class="title-pro">${x.tenLaptop}</h1>
                    <div class="trademark">Thương hiệu: ${x.hangSX}</div>
                    <div class="price-product">${x.giaBan}</div>
                    <div class="border-pro"></div>
                    <div class="BOXKHUYENMAILIENQUAN">
                        <div class="css-mz7xyg">Khuyến mãi liên quan</div>
                        <ul>
                            <li>Nhập mã <strong>PV300</strong> giảm thêm 3% tối đa <span
                                    class="css-1m8enhf">300.000<span
                                    class="css-1ul6wk9">đ</span></span> khi thanh toán qua VNPAY-QR.
                            </li>
                            <li>Nhập mã <strong>APPLE800</strong> giảm thêm % tối đa <span
                                    class="css-1m8enhf">800.000<span
                                    class="css-1ul6wk9">đ</span></span>. Áp dụng cho một số sản phẩm Apple trên
                                20.000.000đ
                                khi thanh toán qua VNPAY-QR.
                            </li>
                            <li>Nhập mã <strong>APPLENEW</strong> giảm thêm 5% tối đa <span
                                    class="css-1m8enhf">1.000.000<span class="css-1ul6wk9">đ</span></span>. Áp dụng cho
                                các
                                sản phẩm iPhone 13, Ipad 9th GEN &amp; Mini 6 khi thanh toán qua VNPAY-QR.
                            </li>
                        </ul>
                    </div>
                    <div class="border-pro"></div>
                    <div class="btn-pro">
                        <div class="mua-ngay"><a href="" class="btn-mua ripple">MUA NGAY</a></div>
                        <div class="them-vao-gio"><a role="button" id="them-vao-gio" class="btn-mua ripple">THÊM VÀO GIỎ
                            HÀNG</a></div>
                    </div>
                </div>
            </div>
        <div class="sale-policy">
            <div style="display:flex;margin-bottom: 8px">
                <div class="img-sale-policy"
                     style="background-image: url('${root}image/icon-product/free-ship.png')"></div>
                <!--                <img src="${root}image/icon-product/free-ship.png" style="">-->
                <span style="margin: auto 0 auto 0">Sản phẩm được miễn phí giao hàng</span>
            </div>
            <div class="border-pro"></div>
            <div class="policy" type="subtitle">Chính sách bán hàng</div>
            <div style="display:flex;margin-bottom: 8px">
                <!--                <img src="${root}image/icon-product/ship.png" style="margin-right: 3px;line-height:normal">-->
                <div class="img-sale-policy" style="background-image: url('${root}image/icon-product/ship.png')"></div>

                <span style="margin: auto 0 auto 0">Miễn phí giao hàng cho đơn hàng từ 800K</span>
            </div>
            <div style="display:flex;margin-bottom: 8px">
                <!--                <img src="${root}image/icon-product/camket.png" style="margin-right: 3px;line-height:normal">-->
                <div class="img-sale-policy"
                     style="background-image: url('${root}image/icon-product/camket.png')"></div>

                <span style="margin: auto 0 auto 0">Cam kết hàng chính hãng 100%</span>
            </div>
            <div style="display:flex;margin-bottom: 8px">
                <!--                <img src="${root}image/icon-product/doitra.png" style="margin-right: 3px;line-height:normal">-->
                <div class="img-sale-policy"
                     style="background-image: url('${root}image/icon-product/doitra.png')"></div>

                <span style="margin: auto 0 auto 0">Đổi trả trong vòng 10 ngày</span>
            </div>
            <div class="policy" type="subtitle">Dịch vụ khác</div>
            <div style="display:flex;margin-bottom: 8px">
                <!--                <img src="${root}image/icon-product/suachua.png" style="margin-right: 3px;line-height:normal">-->
                <div class="img-sale-policy"
                     style="background-image: url('${root}image/icon-product/suachua.png')"></div>

                <span style="margin: auto 0 auto 0">Sửa chữa đồng giá 150.000đ.</span>
            </div>
            <div style="display:flex;margin-bottom: 8px">
                <!--                <img src="${root}image/icon-product/baotri.png" style="margin-right: 3px;line-height:normal">-->
                <div class="img-sale-policy"
                     style="background-image: url('${root}image/icon-product/baotri.png')"></div>

                <span style="margin: auto 0 auto 0">Vệ sinh máy tính, laptop.</span>
            </div>
            <div style="display:flex;margin-bottom: 8px">
                <!--                <img src="${root}image/icon-product/camket.png" style="margin-right: 3px;line-height:normal">-->
                <div class="img-sale-policy"
                     style="background-image: url('${root}image/icon-product/camket.png')"></div>

                <span style="margin: auto 0 auto 0">Bảo hành tại nhà.</span>
            </div>
        </div>
    </div>
    <div id="container">
        <div class="body-content">
            <div>
                <div class="tabs">
                    <a class="tab active" href="#">Thông số kỹ thuật</a>
                </div>
                <div class="tab-contents">
                    <div class="tab-content active" data-tabidx="1">
                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table-specs">
                                    <tbody>
                                    <tr>
                                        <td> Mã laptop</td>
                                        <td> ${x.maLapTop}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> Series</td>
                                        <td> ${x.series}</td>
                                    </tr>
                                    <tr>
                                        <td> Màu</td>
                                        <td> ${x.mau}</td>
                                    </tr>
                                    <tr>
                                        <td> CPU</td>
                                        <td> ${x.cpu}</td>
                                    </tr>
                                    <tr>
                                        <td> VGA</td>
                                        <td> ${x.vga}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> RAM</td>
                                        <td> ${x.ram}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> Kích thước màn hình</td>
                                        <td> ${x.kichThuocManHinh}</td>
                                    </tr>
                                    <tr>
                                        <td> Ổ cứng</td>
                                        <td> ${x.oCung}</td>
                                    </tr>
                                    <tr>
                                        <td> Bàn phím</td>
                                        <td> ${x.banPhim}</td>
                                    </tr>
                                    <tr>
                                        <td> Pin</td>
                                        <td> ${x.pin}</td>
                                    </tr>
                                    <tr>
                                        <td> Khối lượng</td>
                                        <td> ${x.khoiLuong}
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@include file="../layout/product-best-seller.jsp"%>
    <%@include file="../layout/footer.jsp" %>

</div>

</div>
</c:forEach>
<%@include file="../layout/login.jsp" %>
<%@include file="../layout/fogot.jsp" %>
<%@include file="../layout/register.jsp" %>
<!--Back to top-->
<%@include file="../layout/back-to-top.jsp" %>
</body>
<script>
    let price = document.querySelectorAll('.price-product');
    let price1 = document.querySelectorAll('.product-price');
    for (let i = 0; i < price.length; i++) {
        price[i].innerHTML = parseInt(price[i].textContent).toLocaleString('it-IT', {
            style: 'currency',
            currency: 'VND'
        });
    }
    for (let i = 0; i < price1.length; i++){
        price1[i].innerHTML = parseInt(price1[i].textContent).toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
    }
</script>
<script src="${root}js/register.js"></script>
<script src="${root}js/register.js"></script>
<script crossorigin="anonymous" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        referrerpolicy="no-referrer"
        src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<!--<script src="${root}js/slider.js"></script>-->
<script src="${root}js/CartAtHover.js"></script>
<script src="${root}js/ripple-button.js"></script>
<script src="${root}js/product-bestseller.js"></script>
<script src="${root}js/nav-responsive.js"></script>
<script src="${root}js/BackToTop.js"></script>
<script src="${root}js/Scroll-Indicator.js"></script>
<script src="${root}js/visibleCart.js"></script>
<script src="${root}js/clickAddCart.js"></script>
<script src="${root}js/hover-product.js"></script>
<script src="${root}js/view-image-product.js"></script>
</html>