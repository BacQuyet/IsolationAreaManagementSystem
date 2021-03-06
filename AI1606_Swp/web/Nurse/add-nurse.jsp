<%@page import="utils.Utils"%>
<%@page import="entity.Area"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
     <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý tài khoản > Thêm nhân sự</span>
        <div class="spacer2"></div>
     </div>
    <div class="form-container form-container_add">
        <div>
            <form action="addnurse" method="POST" id="form-xn" class="form">
                <div class="form-group">
                    <label for="name" class="form-label">Họ tên nhân viên:</label>
                    <input id="name" class="form-control" name="name" type="text" required>
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="username" class="form-label">Tên đăng nhập:</label>
                    <input id="username" class="form-control" name="username" type="text" required>
                    <span class="form-message"></span>
                </div>
               
                <div class="form-group">
                    <label for="password" class="form-label">Mật khẩu</label>
                    <input id="password" class="form-control" name="password" type="password" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="repass" class="form-label">Nhập Lại Mật khẩu</label>
                    <input id="repass" class="form-control" name="repass" type="password" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="phone" class="form-label">Số điện thoại:</label>
                    <input id="phone" class="form-control" name="phone" type="text" >
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="so_dien_thoai" class="form-label">Địa chỉ </label>
                    <input id="so_dien_thoai" class="form-control" name="address" type="text" >
                    <span class="form-message"></span>
                </div>
                 <div class="form-group">
                    <label for="email" class="form-label">Email </label>
                    <input id="email" class="form-control" name="email" type="text" >
                    <span class="form-message"></span>
                </div>
                
                <div class="form-group">
                <label for="loai" class="form-label">Khu vực: </label>
                <select name="loai" id="loai" class="form-control">
                    <option value="0">Chọn khu vực</option>
                    <c:forEach begin="0" end="${fn:length(emtrang)-1}" var="duy">
                        <option value="${emtrang[duy].areaId}">${emtrang[duy].areaName}</option>
                    </c:forEach>
                </select>
            </div>
                Select file to upload: <input type="file" id="file" name="file" /><br /><br /> 
                <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
            </form>
        </div>
    </div>
</div>
