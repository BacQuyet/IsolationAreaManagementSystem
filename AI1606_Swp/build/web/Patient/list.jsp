<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Người cách ly </span>
        <div class="spacer2"></div>
    </div>
    <div class="btn-add">

        <a href="<%=request.getContextPath()%>/Patient/add.jsp"><i class="fas fa-plus-circle"></i>
            <span>Thêm</span>
        </a>
    </div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="5%">Mã Bệnh Nhân</th>
                <th width="17%">Họ tên</th>
                <th width="5%">Tuổi</th>
                <th width="5%">Phòng</th>
                <th width="5%">Khu cách ly</th>
                <th width="10%">Quốc tịch</th>
                <th width="15%">Tình trạng</th>
                <th width="19%">Mức độ nghi nhiễm</th>
                <th width="19%">Hành động</th>
            </tr>
        </table>
    </div>
    </div>
</div>

<script>
    $('td[data-filetype="F1"]').css({'color': 'red', 'font-weight': '500'});
    $('td[data-filetype="F2"]').css({'color': '#FFC806', 'font-weight': '500'});
    $('td[data-filetype="F3"]').css({'color': 'blue', 'font-weight': '500'});
    $('td[data-filetype="F4"]').css({'color': 'black', 'font-weight': '500'});
</script>
