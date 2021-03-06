
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/assets/css/accountDetail.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/detail.css">
<div class=" user-container ">
    <div class="menu">
        <ul>
            <li><div><img class="menu-img" src="<%=request.getContextPath()%>/${initParam.imgPath}${userLogin.getAvatar()}"/></div>
                <div style="margin-left: 24px;"><h3>${userLogin.getUserName()}</h3>
                    <a href="<%=request.getContextPath()%>/myaccount/EditAccount?account_id=${userLogin.getAccountId()}"><i class="fas fa-pen"></i>Sửa hồ sơ</a>
                </div>
            <li class="spacer"></li>

            <li class="menu-li"><a class="menu-item"><i class="far fa-user-circle"></i> Tài khoản của tôi</a></li>
            <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/viewAccount" class="menu-item depend"> Hồ sơ</a></li>
            <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/ChangePassword.jsp" class="menu-item depend"> Đổi mật khẩu</a></li>
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
                <%                    if (account.getType().getAccountTypeId() == 1) { // admin login
                %>
                <div>

                    <div class="content-header__info content-header__account">

                        <span style="color: blue;font-size: 2rem;font-weight: 500;">Tên đăng nhập: ${userLogin.getUserName()}</span>
                    </div>

                    <div class="content-middle"> 
                        <div class="content-middle__lylich">
                            <span class="info-label">Lý lịch cá nhân</span>
                            <ul class="info-detail">
                                <li>Email: ${userLogin.getEmail()}
                            </ul>
                        </div>
                    </div>
                </div>
               
                    <%
                        }
                    %>
                    <%
                        if (account.getType().getAccountTypeId() == 2) { // Doctor login
                    %>
                <div>

                    <div class="content-header__info content-header__account">

                        <span style="color: blue;font-size: 2rem;font-weight: 500;">Tên đăng nhập: ${userLogin.getUserName()}</span>
                    </div>

                    <div class="content-middle"> 
                        <div class="content-middle__lylich">
                            <span class="info-label">Lý lịch cá nhân</span>
                            <ul class="info-detail">
                                <li>Họ và tên: ${d.getFullName()}</li>
                                <li>Số điện thoại: ${d.getPhone()}</li>
                                <li>Địa chỉ: ${d.getAddress()}</li>
                                <li>Email: ${userLogin.getEmail()}</li>
                            </ul>
                        </div>
                    </div>
                </div>
               
                    <%
                        }
                    %>
                    <%
                        if (account.getType().getAccountTypeId() == 3) { // Nurse login
%>
                <div>

                    <div class="content-header__info content-header__account">

                        <span style="color: blue;font-size: 2rem;font-weight: 500;">Tên đăng nhập: ${userLogin.getUserName()}</span>
                    </div>

                    <div class="content-middle"> 
                        <div class="content-middle__lylich">
                            <span class="info-label">Lý lịch cá nhân</span>
                            <ul class="info-detail">

                                <li>Họ và tên: ${nurse.getName_nurse()} </li>
                                <li>Số điện thoại: ${nurse.getPhone()}</li>
                                <li>Địa chỉ: ${nurse.getAddress()} </li>
                                <li>Email: ${userLogin.getEmail()} </li>
                            </ul>
                        </div>
                    </div>
                </div>
                
                    <%
                        }
                    %>
                    <%
                    if (account.getType().getAccountTypeId() == 4) { // Patient login
%>
                <div>

                    <div class="content-header__info content-header__account">

                        <span style="color: blue;font-size: 2rem;font-weight: 500;">Tên đăng nhập: ${userLogin.getUserName()}</span>
                    </div>

                    <div class="content-middle"> 
                        <div class="content-middle__lylich">
                            <span class="info-label">Lý lịch cá nhân</span>
                            <ul class="info-detail">

                                <li>Họ và tên: ${patient.getPatientName()}</li>
                                <li>Số điện thoại: ${patient.getPhoneNumber()}</li>
                                <li>Địa chỉ: ${patient.getAddress()}</li>
                                <li>Email: ${userLogin.getEmail()}</li>
                            </ul>
                        </div>
                    </div>
                </div>
                
                    <%
                        }
                    %>                
            </div>
        </div>

    </div>
</div>
