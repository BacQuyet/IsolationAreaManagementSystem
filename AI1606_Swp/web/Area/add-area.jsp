<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Quản lý khu vực > Thêm khu vực</span>
        <div class="spacer2"></div>
    </div>
    
    <div class="form-container">
        <form action="addarea" method="POST" id="form-dn" class="form">
            <div class="form-group form-group__special">
                <label for="areaName" class="form-label">Tên khu vực</label>
                <input id="areaName" class="form-control" name="areaName" type="text" required>
                <span class="form-message"></span>
            </div>
            
            <div class="form-group">
                <label for="address" class="form-label">Địa chỉ khu vực: </label>
                <input id="address" class="form-control" name="" type="text" >
                <span class="form-message"></span>
            </div>
        </form>

    </div>

</div>
