<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/23/2021
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<div class="bestseller">
    <div class="bestseller-main">
        <div class="title-bestseller">
            <div class="border-bestseller"></div>
            <div class="title-main-bestseller">Bán chạy nhất</div>
            <a class="view-all-bestseller" href="">Xem tất cả <i class="fas fa-angle-right"></i></a>
        </div>
        <div class="product-bestseller">
            <jsp:useBean id="productsProductBS" scope="request" type="java.util.List"/>
            <c:forEach var="x" items="${productsProductBS}">
                <a class="click-action" href="">
                    <div class="product-bestseller-items">
                        <div class="img-product-bestseller" style="background-image: url('${x.linkHinh1}')"></div>
                        <div class="product-bestseller-name">
                            <div class="product-name">${x.tenLaptop}</div>
                            <div class="product-status">Còn 1 sản phẩm</div>
                        </div>
                        <div class="product-price">${x.giaBan}</div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
