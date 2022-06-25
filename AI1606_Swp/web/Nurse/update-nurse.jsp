<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Cập nhật thông tin phòng</span>
        <div class="spacer2"></div>
    </div>


    <div class="form-container">
        <form action="updatenurse" method="POST" id="form-dn" class="form">
            
            <input id="nurseId" class="form-control" name="nurseId" type="text" value="${nurse.getId_nurse()}" style="display: none">
            <div class="form-group form-group__special">
                <label for="nurseName" class="form-label">Tên Y Tá:</label>
                <input id="nurseName" class="form-control" name="nurseName" type="text" required value ="${nurse.getName_nurse()}">
                <span class="form-message"></span>
            </div>


            <div class="form-group">
                <label for="phone" class="form-label">Số Điện Thoại:</label>
                <input id="phone" class="form-control" name="phone" type="text" title="Vui lòng nhập đúng số điện thoại" value="${nurse.getPhone()}">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="accountId" class="form-label">Tên Account:</label>
                <input id="accountId" class="form-control" name="accountId" type="text"  value="${nurse.getId_account().getAccountId()}" style="display: none">
                <input id="accountName" class="form-control" name="accountName" type="text" readonly  value="">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label for="address" class="form-label">Địa chỉ:</label>
                <input id="address" class="form-control" name="address" type="text" value = "">
                <span class="form-message"></span>
            </div>
                
            <div class="form-group">
                <label for="areaId" class="form-label">Tên Khu vực:</label>
                <input id="areaId" class="form-control" name="areaId" type="text"  value="" style="display: none">
                <input id="areaName" class="form-control" name="areaName" type="text" readonly  value="">
                <span class="form-message"></span>
            </div>
                
            <div class="form-group">
                <label for="fullname" class="form-label">Họ tên đầy đủ:</label>
                <input id="fullname" class="form-control" name="fullname" type="text" value = "">
                <span class="form-message"></span>
            </div>

            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>
