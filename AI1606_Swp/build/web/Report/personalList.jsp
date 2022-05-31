<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">

<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Báo cáo sức khỏe</span>
        <div class="spacer2"></div>
    </div>
    
  
    <div style="margin: 50px 350px 50px 50px;">
    <h2>Lọc danh sách</h2>
    <p style="font-size: 1.6rem;">Nhập bất kỳ thông tin liên quan trong bảng:</p>  
    <input style="font-size: 1.6rem;" class="form-control" id="myInput" type="text" placeholder="Search..">
    </div>
    
    
    <div class="btn-add">
        <a href="<%=request.getContextPath()%>/Report/add.jsp"><i class="fas fa-plus-circle"></i>
            <span>Thêm</span>
        </a>
    </div>

    <div class="table-list">
        <table class="table-list__user">
            <thead>
                <th width="15%">Mã report</th>
                <th width="40%">Nội dung báo cáo</th>
                <th width="20%">Thời gian</th>  
                <th width="25%">Hành động</th>
            </thead>
            <tbody id="myTable">
                <tr></tr>
            </tbody>
        </table>
    </div>
    </div>
</div>

<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
  });
});
</script>