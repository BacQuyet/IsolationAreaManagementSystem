
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
<!--
class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý tài khoản </span>
        <div class="spacer2"></div>
    </div>
    <div class="btn-add">
        
            <span>Thêm nhân viên</span>
        </a>
    </div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="10%">Mã</th>
                <th width="30%">Họ tên</th>
                <th width="20%">Địa chỉ</th>
                <th width="20%">Số điện thoại</th>
                
                <th width="20%">Hệ thống</th>
            </tr>

        </table>
    </div>
            <div style="margin: 35px">
                 <nav aria-label="..." class="d-flex justify-content-center">
                                            <ul class="pagination pagination-lg">
                                            </ul>
                                        </nav>

    
    !-->
<!--
div class="col-10 content">
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
!-->
<!--
div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Ngưới cách ly > Thêm người cách ly</span>
        <div class="spacer2"></div>
    </div>

    <div class="form-container">
        <form action="add" method="POST" id="form-dn" class="form">
            <div class="form-header">
                <div class="form-group form-group__special">
                    <label for="fullname" class="form-label">Họ và tên:</label>
                    <input id="fullname" class="form-control" name="fullname" type="text" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="suspicionLevel" class="form-label">Phân loại:</label>
                    <select name="suspicionLevel" id="suspicionLevel">
                        <option value="F1">F1</option>
                        <option value="F2">F2</option>
                        <option value="F3">F3</option>
                        <option value="F4" selected="selected">F4</option>
                    </select>
                </div>
            </div>
            <span class="form-span">Lý lịch cá nhân</span>
            <div class="form-group">
                <label for="age" class="form-label">Tuổi:</label>
                <input id="age" class="form-control" name="age" type="text" pattern="[0-9]{1,2}" title="Vui lòng nhập đúng số tuổi">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="gender" class="form-label">Giới tính:</label>
                <select name="gender" id="gender" class="form-control">
                    <option value="Nam" selected="selected">Nam</option>
                    <option value="Nữ">Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="passport" class="form-label">Mã căn cước:</label>
                <input id="passport" class="form-control" name="passport" type="text" >
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="region" class="form-label">Quốc tịch:</label>
                <input id="region" class="form-control" name="region" type="text" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="address" class="form-label">Địa chỉ:</label>
                <input id="address" class="form-control" name="address" type="text" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="phone" class="form-label">Số điện thoại:</label>
                <input id="phone" class="form-control" name="phone" type="text" pattern="[0-9]{8,11}" title="Vui lòng nhập đúng số điện thoại">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="roomName" class="form-label">Xếp vào phòng số</label>
                <select name="roomName" id="roomName" class="form-control" required>
                    
                </select>
            </div>
            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>

!-->
<!--
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
!-->
<!--
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Ngưới cách ly > Chỉnh sửa lý lịch</span>
        <div class="spacer2"></div>
    </div>

    <div class="form-container">
        <form action="update" method="POST" id="form-dn" class="form">
            <input id="patientId" name="patientId" style="display: none" value="">
            <div class="form-header">
                <div class="form-group form-group__special">
                    <label for="fullname" class="form-label">Họ và tên:</label>
                    <input id="fullname" class="form-control" name="fullname" type="text" value="" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="suspicionLevel" class="form-label">Phân loại:</label>
                    <select name="suspicionLevel" id="suspicionLevel">
                        <option value="F1">F1</option>
                        <option value="F2">F2</option>
                        <option value="F3">F3</option>
                        <option value="F4">F4</option>
                    </select>
                </div>
            </div>
            <span class="form-span">Lý lịch cá nhân</span>
            <div class="form-group">
                <label for="age" class="form-label">Tuổi:</label>
                <input id="age" class="form-control" name="age" type="text" value="" pattern="[0-9]{1,2}" title="Vui lòng nhập đúng số tuổi">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="gender" class="form-label">Giới tính:</label>
                <select name="gender" id="gender" class="form-control">
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="passport" class="form-label">Mã căn cước:</label>
                <input id="passport" class="form-control" name="passport" type="text" value="">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="region" class="form-label">Quốc tịch:</label>
                <input id="region" class="form-control" name="region" type="text" value="" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="address" class="form-label">Địa chỉ:</label>
                <input id="address" class="form-control" name="address" type="text" value="" required>
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="phoneNumber" class="form-label">Số điện thoại:</label>
                <input id="phoneNumber" class="form-control" name="phoneNumber" type="text" value="" pattern="[0-9]{8,11}" title="Vui lòng nhập đúng số điện thoại">
                <span class="form-message"></span>
            </div>
            <div class="form-group">
                <label for="roomName" class="form-label">Xếp vào phòng số</label>
                <select name="roomName" id="phong" class="form-control" required>
                </select>
                
            </div>
            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>

!-->
<script>
    $('td[data-filetype="F1"]').css({'color': 'red', 'font-weight': '500'});
    $('td[data-filetype="F2"]').css({'color': '#FFC806', 'font-weight': '500'});
    $('td[data-filetype="F3"]').css({'color': 'blue', 'font-weight': '500'});
    $('td[data-filetype="F4"]').css({'color': 'black', 'font-weight': '500'});
</script>
