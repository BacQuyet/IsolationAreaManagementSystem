
<%@page import="utils.Utils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý tài khoản > Cập nhật thông tin bác sĩ</span>
        <div class="spacer2"></div>
    </div>
    <div class="form-container form-container_add">
        <div>
            <form action="UpdateDoctor" method="POST" id="form-xn" class="form" >
                <div class="form-group">
                    <label for="id_doctor" class="form-label">Mã:</label>
                    <input id="ho_ten" class="form-control" name="id_doctor" type="text" required readonly="" value="${doctor.getDoctor()}" >
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="fullname" class="form-label">Họ tên nhân viên:</label>
                    <input id="ho_ten" class="form-control" name="fullname" type="text" required value="${doctor.getFullName()}">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="phone" class="form-label">Số điện thoại:</label>
                    <input id="so_dien_thoai" class="form-control" name="phone" type="text" value="${doctor.getPhone()}" > 
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="address" class="form-label">Địa chỉ </label>
                    <input id="so_dien_thoai" class="form-control" name="address" type="text" value="${doctor.getAddress()}">
                    <span class="form-message" ></span>
                </div>                              
                <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
            </form>
        </div>
    </div>
</div>

s