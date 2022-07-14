<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/detail.css">

<div class="col-10 content">
     <button onclick="history.back()">Back</button>
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Người cách ly > Xem chi tiết</span>
        <div class="spacer2"></div>
    </div>
    <div class="content-header">
        <div class="content-header__info">
            <span>Mã người cách ly: </span>
            <span>Họ và tên: </span>
        </div>
        <div class="content-header__btn"><a><i class="fas fa-sign-out-alt"></i> Ra viện</a></div>

    </div>
    <div class="content-middle"> 
        <div class="content-middle__lylich space3">
            <span class="info-label">Lý lịch cá nhân</span>
            <ul class="info-detail">
                <li>Tuổi: </li>
                <li>Giới tính: </li>
                <li>Mã căn cước: </li>
                <li>Quốc tịch: </li>
                <li>Đia chỉ: </li>
                <li>Số điện thoại: </li>
            </ul>
        </div>
        <div class="content-middle__cachly ">
            <span class="info-label">Thực hiện cách ly</span>
            <ul class="info-detail">
                <li>Mức độ nghi nhiễm: </li>
                <li>Ngày vào: <fmt:formatDate value="" pattern="" /></li>
                <li>Số ngày thực hiện: </li>
                <li>Phòng số: </li>
            </ul>
                
        </div>
    </div>   
    <div class="content-history">
        <span class="info-label">Lịch sử xét nghiệm</span>
    </div>

</div>