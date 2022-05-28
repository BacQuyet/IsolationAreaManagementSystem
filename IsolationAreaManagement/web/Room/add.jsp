<%-- 
    Document   : add
    Created on : May 28, 2022, 1:24:20 PM
    Author     : Thanh Duy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="assets/css/list/add.css">

<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Quản lý phòng bệnh > Thêm phòng</span>
        <div class="spacer2"></div>
    </div>


    <div class="form-container">
        <form  method="POST"  class="form">

            <div class="form-group form-group__special">
                <label  class="form-label">Tên phòng</label>
                <input  class="form-control" type="text" required>
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label  class="form-label">Số giường tối đa:</label>
                <input  class="form-control"  type="text" pattern="[0-9]{1,2}" title="Vui lòng nhập đúng số giường">
                <span class="form-message"></span>
            </div>

            <div class="form-group">
                <label  class="form-label">Ghi chú</label>
                <input  class="form-control"  type="text" >
                <span class="form-message"></span>
            </div>

            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>

    </div>
</div>