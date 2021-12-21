<%--
  Created by IntelliJ IDEA.
  User: Thinh PC
  Date: 12/21/2021
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<div class="js-login" id="login-main" style="z-index: 1000">
  <div class="login js-login-container">
    <div class="title-login">
      <a class="close-login" role="button"></a>
      <h1 class="title-login-main">Đăng nhập</h1>
      <p class="slogan-login">Hãy tham gia cùng chúng tôi</p>
    </div>
    <div class="border"></div>
    <form action="" class="login-form">
      <div class="input-login">
        <input class="input-items" placeholder="Tên đăng nhập" required type="text">
        <input class="input-items" placeholder="Mật khẩu" required type="password">
      </div>
      <button class="btn-login">Đăng nhập</button>
    </form>
    <div class="forgot-pass-main">
      <a class="forgot-pass js-forgot-pass" role="button">Quên mật khẩu</a>
    </div>
    <div class="border"></div>
    <div class="new-account">
      <a class="btn-new-account js-new-account" role="button">Tạo tài khoản mới</a>
    </div>
  </div>
</div>
