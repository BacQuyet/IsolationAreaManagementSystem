<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">

<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý phòng bệnh</span>
        <div class="spacer2">
            
        </div>
    </div>
    <div class="btn-add">
        <a href="<%=request.getContextPath()%>/Room/add.jsp"><i class="fas fa-plus-circle"></i>
            <span>Thêm phòng</span>
        </a>
<!--            bang benh nhan-->
    </div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="10%">Mã phòng</th>
                <th width="20%">Tên phòng</th>
                <th width="10%">Sức chứa</th>  
                <th width="20">Khu cách ly</th>  
                <th width="25%">Ghi chú</th>
                <th width="15%">Hành động</th>
            </tr>
        </table>

    </div>
    </div>
</div>
