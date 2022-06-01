<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/detail.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Xem chi tiết phòng bệnh</span>
        <div class="spacer2"></div>
    </div>

    <div class="content-header">
        <div class="content-header__info">
            <span>Khu cách ly: </span>
            <span>Khu cách ly: </span>
            <span>Mã phòng:  -  Tên phòng: </span>
        </div>
        
    </div>
    <div class="content-middle"> 
        <div class="content-middle__lylich space3">
            <span class="info-label">Thông tin</span>
            <ul class="info-detail">
                <li>Số giường tối đa: </li>
                <li>Số bệnh nhân hiện có: </li>
                <li>Ghi chú: </li>
                
            </ul>
        </div>
        
    </div>   
    <div class="content-history">
        <span class="info-label">Bệnh nhân hiện có</span>
    </div>
</div>