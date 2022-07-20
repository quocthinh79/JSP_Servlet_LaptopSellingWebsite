<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<div id="cart-hover" class="hover-cart">
    <div class="cover-cart-item">
<%--        <div class="cart-item">--%>
<%--            <div class="img-cart-item" style="background-image: url(../image/image99.png)">--%>

<%--            </div>--%>
<%--            <div class="details-cart-item">--%>
<%--                <div class="infor-cart-item"></div>--%>
<%--                <div class="num-cart-item">Số lượng: </div>--%>
<%--                <div class="price-cart-item"></div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="cart-item">--%>
<%--            <div class="img-cart-item" style="background-image: url(../image/image99.png)">--%>

<%--            </div>--%>
<%--            <div class="details-cart-item">--%>
<%--                <div class="infor-cart-item">Màn hình LCD VIEWSONIC VP2458 (1920 x 1080/IPS/60Hz/5 ms)</div>--%>
<%--                <div class="num-cart-item">Số lượng: 2</div>--%>
<%--                <div class="price-cart-item">5.620.000đ</div>--%>
<%--            </div>--%>
<%--        </div>--%>
    </div>
    <div class="total-cart">
        <div class="total-price-infor">
<%--            <div class="total-product"></div>--%>
<%--            <div class="total-price"></div>--%>
            <div class="total-product">Tổng tiền (0) sản phẩm</div>
            <div class="total-price">0 VND</div>
        </div>
        <div role="button" class="btn-view-cart"><a href="cart.jsp" class="btn-tt">Xem giỏ hàng</a></div>
    </div>
</div>
