
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Người cách ly > Cập nhật xét nghiệm</span>
        <div class="spacer2"></div>
    </div>



    <div class="form-container">
        <form action="add-test" method="POST" id="form-xn" class="form">
            <div class="form-header">
                <div class="content-header__info">
                    <span class="content-one">Mã người cách ly: </span>
                    <span class="content-two">Họ và tên: </span>
                </div>
                <input id="id" name="id" type="text" value="" style="display: none">

            </div>
            <span class="form-span">Xét nghiệm</span>
            <div class="form-group">
                <label for="time" class="form-label">Thời gian:</label>
                <input type="datetime-local" id="timeIn" class="form-control"
                       name="time" value="" max="">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="test_name" class="form-label">Loại xét nghiệm:</label>
                <input id="test_name" class="form-control" name="test_name" type="text" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="result" class="form-label" style="width: 145px">Kết quả</label>
                <select name="testresult" id="testresult">
                     <option value="positive">Dương tính</option>
                     <option value="negative">Âm tính</option>
                </select>
            </div>
            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>