
<%@page import="utils.Utils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/addDoctor.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý tài khoản > Thêm nhân sự</span>
        <div class="spacer2"></div>
    </div>
    <div class="form-container form-container_add">
        <div>
            <form action="addDoctor" method="GET" id="form-xn" class="form">
                <div class="form-group">
                    <label for="ho_ten" class="form-label">Họ tên nhân viên:</label>
                    <input id="ho_ten" class="form-control" name="name" type="text" required>
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="ten_dang_nhap" class="form-label">Tên đăng nhập:</label>
                    <input id="ten_dang_nhap" class="form-control" name="username" type="text" required>
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="mat_khau" class="form-label">Mật khẩu</label>
                    <input id="mat_khau" class="form-control" name="password" type="password" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="mat_khau" class="form-label">Nhập Lại Mật khẩu</label>
                    <input id="mat_khau1" class="form-control" name="repass" type="password" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="so_dien_thoai" class="form-label">Số điện thoại:</label>
                    <input id="so_dien_thoai" class="form-control" name="phone" type="text" required >
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="so_dien_thoai" class="form-label">Địa chỉ </label>
                    <input id="so_dien_thoai" class="form-control" name="address" type="text" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="email" class="form-label">Email </label>
                    <input id="email" class="form-control" name="email" type="text" pattern=".+@gmail\.com"  required >
                    <span class="form-message"></span>
                </div>
                Select file to upload: <input type="file" id="file" name="file" /><br /><br /> 
                <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
            </form>
        </div>


            <script>
                var loadFile = function (event) {
                    var reader = new FileReader();
                    reader.onload = function () {
                        var output = document.getElementById('output');
                        output.src = reader.result;
                    };
                    reader.readAsDataURL(event.target.files[0]);
                };

            </script>
        </div>
    </div>
</div>
<script src="<%=request.getContextPath()%>/assets/js/validator.js"></script>
<script>
    Validator({
        form: "#form-xn",
        errorSelector: '.form-message',
        rules: [
            Validator.minLength("#mat_khau", 6),
            Validator.minLength("#mat_khau1", 6),
            Validator.minLength("#so_dien_thoai", 9),
        ]
    });
</script>