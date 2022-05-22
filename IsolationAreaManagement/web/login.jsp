
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="assets/css/form.css" rel="stylesheet">
<div class="form-container">
    <form action="" method="POST" id="form-dn" class="form">
        <h3 class="heading">Đăng nhập</h3>
        <p class="desc">Đăng nhập để trải nghiệm toàn bộ tiện ích nào</p>

        <div class="spacer"></div>

        <div class="form-group">
            <label for="" class="form-label">Tên đăng nhập</label>
            <input id="ten_dang_nhap" class="form-control" name="username" type="text" >
            <span class="form-message"></span>
        </div>

        <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" class="form-control" name="password" type="password" >
            <span class="form-message"></span>
        </div>
        <a href="" style="font-size: 20px">Quên mật khẩu</a>
        <button class="form-submit">Đăng nhập</button>
    </form>
</div>

