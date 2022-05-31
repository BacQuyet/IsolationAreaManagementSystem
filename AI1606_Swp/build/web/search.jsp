
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Tìm kiếm </span>
        <div class="spacer2"></div>
    </div>
    <div class = "search_results">
        <div class="search_results-filter"> Bộ lọc  <i class="fas fa-filter"></i> </div>
    </div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="24%">Họ tên</th>
                <th width="7%">Tuổi</th>
                <th width="40%">Khu cách ly</th>
<!--                <th width="7%">Phòng</th>-->
                <th width="20%">Mức độ nghi nhiễm</th>

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
