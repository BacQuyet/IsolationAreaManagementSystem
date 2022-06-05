
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link href="<%=request.getContextPath()%>/assets/css/form.css" rel="stylesheet">

<div class="form-container">
    <form action="ForgotPassword" method="POST" id="form-dn" class="form">
        <h3 class="heading">Tìm lại mật khẩu</h3>
        <p class="desc">Tìm lại mật khẩu để đăng nhập nào</p>

        <div class="spacer"></div>

        <div class="form-group">
            <label for="ten_dang_nhap" class="form-label">Tên đăng nhập</label>
            <input id="ten_dang_nhap" class="form-control" name="username" type="text" >
            <span class="form-message"></span>
        </div>

        <div class="form-group">
            <label for="password" class="form-label">Nhập mật khẩu</label>
            <input id="password" class="form-control" name="pass1" type="password" >
            <span class="form-message"></span>
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Nhập lại mật khẩu</label>
            <input id="password" class="form-control" name="pass2" type="password" >
            <span class="form-message"></span>
        </div>
        <button id="forgot" class="form-submit">Tiếp theo</button>
        <script>
            document.getElementById('forgot-alert').addEventListener('click', function () {
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Mật khẩu mới của bạn đã thay đổi. Kiểm tra email của bạn để thấy sự thay đổi',
                    showConfirmButton: false,
                    timer: 1500
                })
            })
        </script>
    </form>
</div>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="assets/js/validator.js"></script>
<script>
            Validator({
                form: "#form-dn",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired("#username"),
                    Validator.minLength("#email", 6),
                ]
            });
</script>

