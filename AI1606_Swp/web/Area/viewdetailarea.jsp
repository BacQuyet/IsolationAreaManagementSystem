<%@page import="utils.Utils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/detail.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý khu vực > Xem chi tiết</span>
        <div class="spacer2"></div>
    </div>
    <div class="content-body">
        <div>
            <div class="content-header__info content-header__account">
                <span>Mã khu vực: ${areadetail.getAreaId()}</span>
                <span>Tên khu vực: ${areadetail.getAreaName()}</span>
                <span style="color: blue;font-size: 2rem;font-weight: 500;">Địa chỉ khu vực: ${areadetail.getAreaAddress()}</span>
                <span style="color: blue;font-size: 2rem;font-weight: 500;">Liên hệ: ${areadetail.getContact()}</span>

            </div>
        </div>               
    </div>
</div>
