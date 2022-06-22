
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
    <div class="menu-detail">
        <h3 class="heading">Hồ sơ của tôi</h3>
        <p class="desc">Quản lý thông tin hồ sơ để bảo vệ tài khoản</p>
        <div class="spacer"></div>
        <div class="col-10 content">
            <%
                Account account = (Account) session.getAttribute("userLogin");
                
            %>
            <div class="content-body">
                <%
                    if (account.getType().getAccountTypeId() == 1) { // Nurse login
                %>
                <div>

                    <div class="content-header__info content-header__account">

                        <span style="color: blue;font-size: 2rem;font-weight: 500;">Tên đăng nhập:</span>
                    </div>

                    <div class="content-middle"> 
                        <div class="content-middle__lylich">
                            <span class="info-label">Lý lịch cá nhân</span>
                            <ul class="info-detail">
                                <li>Email:
                            </ul>
                        </div>
                    </div>
                </div>
                <div><img class="content-img" src=""/></div>
                    <%
                        }
                    %>
            
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
