<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Cập nhật thông tin khu vực</span>
        <div class="spacer2"></div>
    </div>


    <div class="form-container">
        <form action="updatearea" method="POST" id="form-dn" class="form">

            <input id="areaId" class="form-control" name="areaId" type="text" value="${area.getAreaId()}" style="display: none">
            <div class="form-group form-group__special">
                <label for="areaName" class="form-label">Tên khu vực</label>
                <input id="areaName" class="form-control" name="areaName" type="text" required value="${area.getAreaName()}">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="areaAddress" class="form-label">Ghi chú</label>
                <input id="areaAddress" class="form-control" name="areaAddress" type="text" value="${area.getAreaAddress()}">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="areaContact" class="form-label">Ghi chú</label>
                <input id="areaContact" class="form-control" name="areaContact" type="text" value = "">
                <span class="form-message"></span>
            </div>

            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>