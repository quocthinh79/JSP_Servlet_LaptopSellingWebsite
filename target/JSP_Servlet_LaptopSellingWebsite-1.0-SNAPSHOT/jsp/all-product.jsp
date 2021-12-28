<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="root"/>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Metaverse Laptop</title>
    <link href="${root}image/logo-re.png" rel="icon">
    <link href="${root}css/style.css" rel="stylesheet">
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
    <link href="${root}css/responsiveIndex.css" rel="stylesheet">
</head>
<body>
<div id="main">
    <%@include file="../layout/header.jsp" %>
    <%@include file="../layout/cart-hover.jsp" %>
    <div id="content1">
        <div id="title-pro-all" class="title-pro-all">
            <jsp:useBean id="allProducer" scope="request" type="java.util.List"/>
            <c:forEach var="x" items="${allProducer}">
                <div class="logo-lap" style="background-image: url('${root}${x.logoNgang}')"></div>
                <span>${x.slogan}</span>
            </c:forEach>
        </div>
        <div class="filter-product">
            <div class="title-filter-product">
                <div style="border-left: 3px solid #111111;padding-left: 8px">Bộ lọc</div>
            </div>
            <%--            <form id="sort1" action="Sort" method="post">--%>
            <div id="fiter-hangsx" class="filter">
                <div class="title-filter">
                    Thương hiệu
                </div>
                <div class="filter-items">
                    <%--                    <jsp:useBean id="allProducer" scope="request" type="java.util.List"/>--%>
                    <c:forEach var="x" items="${allProducer}">
                        <button onclick="loadProduct(this)" name="hang" value="${x.tenHang}" class="filter-item fiter-hangsx">${x.tenHang}
                            <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                        </button>

                    </c:forEach>
                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Màu sắc
                </div>
                <div class="filter-items">
                    <jsp:useBean id="allProduct" scope="request" type="java.util.List"/>
                    <c:forEach var="x" items="${allProduct}">
                        <jsp:useBean id="list" class="java.util.ArrayList"/>
                        <c:if test="${!list.contains(x.mau)}">
                            <c:set var="noUse" value="${list.add(x.mau)}"/>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="z" items="${list}">
                        <button onclick="loadProduct(this)" name="mau" value="${z}" class="filter-item">${z}
                            <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Series CPU
                </div>
                <div class="filter-items">
                    <c:forEach var="x" items="${allProduct}">
                        <c:set var="cpuParts" value="${fn:split(x.cpu, ' ')}"/>
                        <c:set var="string" value="${cpuParts[1]}${' '}${cpuParts[2]}"/>
                        <jsp:useBean id="listCPU" class="java.util.ArrayList"/>
                        <c:if test="${!listCPU.contains(string)}">
                            <c:set var="noUse" value="${listCPU.add(string)}"/>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="x" items="${listCPU}">
                        <button onclick="loadProduct(this)" name="cpu" value="${x}" class="filter-item">${x}
                            <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Dung lượng RAM
                </div>
                <div class="filter-items">
                    <c:forEach var="x" items="${allProduct}">
                        <jsp:useBean id="listRAM" class="java.util.ArrayList"/>
                        <c:if test="${!listRAM.contains(x.ram)}">
                            <c:set var="noUse" value="${listRAM.add(x.ram)}"/>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="x" items="${listRAM}">
                        <button onclick="loadProduct(this)" name="ram" value="${x}" class="filter-item">${x}
                            <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <div class="filter">
                <div class="title-filter">
                    Series
                </div>
                <div class="filter-items">
                    <c:forEach var="x" items="${allProduct}">
                        <jsp:useBean id="listSeries" class="java.util.ArrayList"/>
                        <c:if test="${!listSeries.contains(x.series)}">
                            <c:set var="noUse" value="${listSeries.add(x.series)}"/>
                        </c:if>
                    </c:forEach>
                    <c:forEach var="x" items="${listSeries}">
                        <button onclick="loadProduct(this)" name="series" value="${x}" class="filter-item">${x}
                            <div class="tick"><i class="fas fa-check" style="position: absolute;  left: 7px"></i></div>
                        </button>
                    </c:forEach>
                </div>
            </div>
            <%--            </form>--%>
        </div>
        <div class="filter-another">
            <div class="title-filter">
                Sắp xếp theo
            </div>
            <div class="filter-items">
                <%--                <button name="btnFilterPrice" value="bestSeller" class="filter-item-another">Bán chạy--%>
                <%--                    <div class="tick tick-another"><i class="fas fa-check" style="position: absolute;  left: 7px"></i>--%>
                <%--                    </div>--%>
                <%--                </button>--%>
                <button onclick="loadProduct(this)" id="desc" name="desc" value="desc" class="filter-item-another">Giá giảm dần
                    <div class="tick tick-another"><i class="fas fa-check" style="position: absolute;  left: 7px"></i>
                    </div>
                </button>
                <button onclick="loadProduct(this)" id="asc" name="asc" value="asc" class="filter-item-another">Giá tăng dần
                    <div class="tick tick-another"><i class="fas fa-check" style="position: absolute;  left: 7px"></i>
                    </div>
                </button>
                <%--                <c:if test="${btnSortPrice != null}">--%>
                <%--                <form style="display: flex" action="SortByPrice?idHang=${btnSortPrice}" method="post"></c:if>--%>
                <%--                    <c:if test="${btnSortPrice == null}">--%>
                <%--                    <form style="display: flex" action="SortByPrice" method="post"></c:if>--%>
                <div class="price-filter">
                    <div class="filter-item-another" style="cursor: auto">
                        <input id="lowestPrice" name="lowestPrice" class="input-filter-product" placeholder="Giá thấp nhất">
                    </div>
                    <span style="line-height: 2; text-align: center">-</span>
                    <div class="filter-item-another" style="cursor: auto">
                        <input id="highPrice" name="highPrice" class="input-filter-product" placeholder="Giá cao nhất">
                    </div>
                </div>
                <button onclick="loadProduct(this)" name="btn-filter-price" class="btn-search-filter" type="submit">Tìm</button>
                <%--                    </form>--%>
            </div>
        </div>
        <div class="cover-all-product">
            <div id="product"  class="all-product-cover">
                <c:forEach var="x" items="${allProduct}">
                    <div class="hover-all-product">
                        <a class="all-product-item" href="${pageContext.request.contextPath}/Product?id=${x.maLapTop}">
                            <div class="status-sale">-11%</div>
                            <div class="img-all-product-item"
                                 style="background-image: url('${root}${x.linkHinh1}')">
                            </div>
                            <div class="status">HẾT HÀNG</div>
                            <div class="infor-all-product-item">
                                    ${x.tenLaptop}
                            </div>
                            <div class="price-all-product-item">
                                    ${x.giaBan}
                            </div>
                            <div class="sale-all-product-item">
                                <span class="origin-price">33.999.000đ</span> <span>11%</span>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="pagination p1">
            <ul>
                <c:forEach var="i" begin="1" end="${totalPage}">
                    <c:if test="${i == page}">
                        <a value="${i}" class="paging is-active"  ><li>${i}</li></a>
                    </c:if>
                    <c:if test="${i != page}">
                        <a value="${i}" class="paging"  ><li>${i}</li></a>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
        <%--        <div class="dots-slick"></div>--%>
    </div>
    <%@include file="../layout/footer.jsp" %>
</div>
<%@include file="../layout/login.jsp" %>
<%@include file="../layout/fogot.jsp" %>
<%@include file="../layout/register.jsp" %>
<!--Back to top-->
<%@include file="../layout/back-to-top.jsp" %>
</body>
<script>
    let paging = document.querySelectorAll('.paging');
    let searchParams = new URLSearchParams(window.location.search)
    let param = searchParams.get('idHang')
    for (let i = 0; i < paging.length; i++) {
        paging[i].addEventListener('click', function () {
            $.ajax({
                url: '${pageContext.request.contextPath}/AllProduct',
                type: 'POST',
                data: {
                    page : paging[i].getAttribute('value'),
                    idHang: param
                },
                success: function (response) {
                    $('#product').html(response)
                },
                error: function () {
                }
            });
            for (let i = 0; i < paging.length; i++) {
                paging[i].classList.remove('is-active')
            }
            paging[i].classList.add('is-active');
        });
    }
</script>
<script>
    let price = document.querySelectorAll('.price-all-product-item');
    for (let i = 0; i < price.length; i++) {
        price[i].innerHTML = parseInt(price[i].textContent).toLocaleString('it-IT', {
            style: 'currency',
            currency: 'VND'
        });
    }
</script>
<script>
    let hangSX = document.querySelectorAll('.fiter-hangsx');
    let filterHangSX = document.getElementById('fiter-hangsx');
    let logoLap = document.querySelectorAll('.logo-lap');
    let allProductLogo = document.getElementById('title-pro-all');
    if (logoLap.length > 1) {
        allProductLogo.style.display = 'none';
    }
    if (hangSX.length <= 1) {
        filterHangSX.style.display = 'none';
    }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function loadProduct(button) {
        let value = $(button).val();
        let name = $(button).attr("name");
        let lowestPrice = document.getElementById('lowestPrice').value;
        let highPrice = document.getElementById('highPrice').value;
        $.ajax({
            url: '${pageContext.request.contextPath}/Sort',
            type: 'POST',
            data: {
                value : value,
                name : name,
                lowestPrice : lowestPrice,
                highPrice: highPrice
            },
            success: function (response) {
                $('#product').html(response)
            },
            error: function () {
            }
        });
    }
    <%--function loadProduct(button) {--%>
    <%--    let value = $(button).val();--%>
    <%--    let name = $(button).attr("name");--%>
    <%--    let lowestPrice = document.getElementById('lowestPrice').value;--%>
    <%--    let highPrice = document.getElementById('highPrice').value;--%>
    <%--    $.ajax({--%>
    <%--        url: '${pageContext.request.contextPath}/Sort',--%>
    <%--        type: 'POST',--%>
    <%--        dataType: "json",--%>
    <%--        data: {--%>
    <%--            value : value,--%>
    <%--            name : name,--%>
    <%--            lowestPrice : lowestPrice,--%>
    <%--            highPrice: highPrice--%>
    <%--        },--%>
    <%--        success: function (response) {--%>
    <%--            // $('#product').append(response);--%>
    <%--        },--%>
    <%--        error: function () {--%>
    <%--        }--%>
    <%--    });--%>
    <%--}--%>
</script>
<script src="${root}js/register.js"></script>
<script src="${root}js/register.js"></script>
<script crossorigin="anonymous" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script crossorigin="anonymous"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        referrerpolicy="no-referrer"
        src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
<script src="${root}js/nav-responsive.js"></script>
<script src="${root}js/BackToTop.js"></script>
<script src="${root}js/Scroll-Indicator.js"></script>
<script src="${root}js/visibleCart.js"></script>
<%--<script src="${root}js/slick-all-product.js"></script>--%>
<script src="${root}js/click-filter.js"></script>
</html>
