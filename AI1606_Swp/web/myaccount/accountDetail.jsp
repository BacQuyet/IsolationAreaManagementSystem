<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/assets/css/accountDetail.css" rel="stylesheet">
<div class=" user-container ">
    <div class="menu">
        <ul>
            <li><div><img class="menu-img" src="<%=request.getContextPath()%>/${initParam.imgPath}${userLogin.getAvatar()}"/></div>
                <div style="margin-left: 24px;"><h3>${userLogin.getUserName()}</h3>
                    <a href=""><i class="fas fa-pen"></i>Sửa hồ sơ</a>
                </div>
            <li class="spacer"></li>

            <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/accountDetail.jsp" class="menu-item"><i class="far fa-user-circle"></i> Tài khoản của tôi</a></li>
            <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/accountDetail.jsp" class="menu-item depend"> Hồ sơ</a></li>
            <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/ChangePassword.jsp" class="menu-item depend"> Đổi mật khẩu</a></li>
            <li class="menu-li"><a href="<%=request.getContextPath()%>/Don/view-list" class="menu-item"><i class="far fa-check-circle"></i> Đơn của tôi</a></li>
        </ul>
    </div>
        <!--
         <div class="input-group mb-3">
                <div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s1" value="Sốt hoặc ớn lạnh"> Sốt hoặc ớn lạnh
                    </label>
                </div>
                <div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s2" value="Đau nhức cơ hoặc cơ thể"> Đau nhức cơ hoặc cơ thể
                    </label>
                </div>
                <div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s3" value="Mất vị giác hoặc mùi mới"> Mất vị giác hoặc mùi mới
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s4" value="Nghẹt mũi hay sổ mũi"> Nghẹt mũi hay sổ mũi
                    </label>
                </div>
                <br><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s5" value="Tiêu chảy"> Tiêu chảy
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s6" value="Mệt mỏi"> Mệt mỏi
                    </label>
                </div><div class="form-check" style="margin: 50px 20px"
                           <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s7" value="Đau đầu"> Đau đầu
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s8" value="Đau họng"> Đau họng
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s9" value="Buồn nôn hoặc nôn mửa"> Buồn nôn hoặc nôn mửa
                    </label>
                </div>
                <div class="form-check-inline">
                    <input type="checkbox" name="cother" value="1"> 
                        <input type="text" placeholder="Các triệu trứng khác" name="other" value="">
                </div>
            </div>

            <br>
            <h4>Kết quả xét nghiệm COVID-19 trong vòng 5 ngày qua :</h4>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="test" value="Âm tính" checked>Âm tính
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="test" value="Dương tính">Dương tính
                </label>
            </div>
            <div class="form-group">
                <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
            </div>
        </form>
!-->
         <!--
         <div class="input-group mb-3">
                <div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s1" value="Sốt hoặc ớn lạnh"> Sốt hoặc ớn lạnh
                    </label>
                </div>
                <div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s2" value="Đau nhức cơ hoặc cơ thể"> Đau nhức cơ hoặc cơ thể
                    </label>
                </div>
                <div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s3" value="Mất vị giác hoặc mùi mới"> Mất vị giác hoặc mùi mới
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s4" value="Nghẹt mũi hay sổ mũi"> Nghẹt mũi hay sổ mũi
                    </label>
                </div>
                <br><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s5" value="Tiêu chảy"> Tiêu chảy
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s6" value="Mệt mỏi"> Mệt mỏi
                    </label>
                </div><div class="form-check" style="margin: 50px 20px"
                           <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s7" value="Đau đầu"> Đau đầu
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s8" value="Đau họng"> Đau họng
                    </label>
                </div><div class="form-check" style="margin: 50px 20px">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="s9" value="Buồn nôn hoặc nôn mửa"> Buồn nôn hoặc nôn mửa
                    </label>
                </div>
                <div class="form-check-inline">
                    <input type="checkbox" name="cother" value="1"> 
                        <input type="text" placeholder="Các triệu trứng khác" name="other" value="">
                </div>
            </div>

            <br>
            <h4>Kết quả xét nghiệm COVID-19 trong vòng 5 ngày qua :</h4>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="test" value="Âm tính" checked>Âm tính
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="test" value="Dương tính">Dương tính
                </label>
            </div>
            <div class="form-group">
                <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
            </div>
        </form>
!-->
    <div class="menu-detail">
        <h3 class="heading">Hồ sơ của tôi</h3>
        <p class="desc">Quản lý thông tin hồ sơ để bảo vệ tài khoản</p>
        <div class="spacer"></div>
        <div class="menu-list">
            <form action="UpdateAccount" method="POST" id="form-user" class="form-user">
                <div class="form-group">
                    <label for="username" class="form-label">Tên đăng nhập</label>
                    <input id="ten_dang_nhap" class="form-control" name="username" type="text" readonly value="${userLogin.getUserName()}">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="full_name" class="form-label">Tên người dùng</label>
                    <input id="ten_nguoi_dung" class="form-control" name="full_name" type="text" value="${userLogin.getPatient().getPatientName()}">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="loai_tai_khoan" class="form-label">Loại tài khoản</label>
                    <input id=loai_tai_khoan" class="form-control" name="loai_tai_khoan" type="text" readonly value="${userLogin.getType().getAccountTypeName()}">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="phone" class="form-label">Số điện thoại</label>
                    <input id="phone" class="form-control" name="phone" type="text" value="${userLogin.getPatient().getPhoneNumber()}">
                    <span class="form-message"></span>
                </div>
                <button class="form-submit" type="submit">Save</button>
            </form>
            <div><img class="menu-detail-img" name ="file" id="output" src="<%=request.getContextPath()%>/${initParam.imgPath}/avatar-default.png"/>
                <input name="file" type="file" accept="image/*" onchange="loadFile(event)" id="getFile" style="display:none" >
                <button style="margin-top: 4px; display:block;width:80px; height:30px;" onclick="document.getElementById('getFile').click()">Chọn ảnh</button>
                <script>
                    var loadFile = function (event) {
                        var reader = new FileReader();
                        reader.onload = function () {
                            var output = document.getElementById('output');
                            output.src = reader.result;
                        };
                        reader.readAsDataURL(event.target.files[0]);
                    };
                </script>
            </div>
        </div>
        
    </div>
</div>
