<%@page import="entity.Account"%>
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
            <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/viewAccount" class="menu-item depend"> Hồ sơ</a></li>         
            <li class="menu-li"><a href="<%=request.getContextPath()%>/myaccount/ChangePassword.jsp" class="menu-item depend"> Đổi mật khẩu</a>

        </ul>
    </div>
    <div class="menu-detail">
        <h3 class="heading">Hồ sơ của tôi</h3>
        <p class="desc">Quản lý thông tin hồ sơ để bảo vệ tài khoản</p>
        <div class="spacer"></div>
        <div class="menu-list">
            <%
                Account account = (Account) session.getAttribute("userLogin");

            %>
            <%                    if (account.getType().getAccountTypeId() == 1) { // Admin login 
            %>
            <form action="editAccountAdmin" method="POST" id="form-user" class="form-user">
                <div class="form-group">
                    <label for="account_id" class="form-label">Mã</label>
                    <input id="account_id" class="form-control" name="account_id" type="text" readonly value="${userLogin.getAccountId()}">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="username" class="form-label">Tên đăng nhập</label>
                    <input id="ten_dang_nhap" class="form-control" name="username" type="text" readonly value="${userLogin.getUserName()}">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="email" class="form-label" >Email</label>
                    <input id="email" class="form-control" name="email" type="text" value="${userLogin.getEmail()}" pattern=".+@gmail\.com" required>
                    <span class="form-message"></span>
                </div>
                <button class="form-submit" type="submit">Save</button>
            </form>
            <%
                }
            %>
            <%                    if (account.getType().getAccountTypeId() == 2) { // Doctor login
            %>
            <form action="EditAccount" method="POST" id="form-user" class="form-user">
                <div class="form-group">
                    <label for="account_id" class="form-label">Mã</label>
                    <input id="account_id" class="form-control" name="account_id" type="text" readonly value="${userLogin.getAccountId()}">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="username" class="form-label">Tên đăng nhập</label>
                    <input id="ten_dang_nhap" class="form-control" name="username" type="text" readonly value="${userLogin.getUserName()}">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="full_name" class="form-label">Tên người dùng</label>
                    <input id="full_name" class="form-control" name="full_name" type="text" value="${d.getFullName()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="phone" class="form-label">Số điện thoại</label>
                    <input id="phone" class="form-control" name="phone" type="text" value="${d.getPhone()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input id="address" class="form-control" name="address" type="text" value="${d.getAddress()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" class="form-control" name="email" type="text" value="${userLogin.getEmail()}" pattern=".+@gmail\.com" required>
                    <span class="form-message"></span>
                </div>
                <button class="form-submit" type="submit">Save</button>
            </form>
            <%
                }
            %>
            <%                    if (account.getType().getAccountTypeId() == 3) { //Nurse logn
            %>
            <form action="editAccountNurse" method="POST" id="form-user" class="form-user">
                <div class="form-group">
                    <label for="account_id" class="form-label">Mã</label>
                    <input id="account_id" class="form-control" name="account_id" type="text" readonly value="${userLogin.getAccountId()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="username" class="form-label">Tên đăng nhập</label>
                    <input id="ten_dang_nhap" class="form-control" name="username" type="text" readonly value="${userLogin.getUserName()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="full_name" class="form-label">Tên người dùng</label>
                    <input id="full_name" class="form-control" name="full_name" type="text" value="${nurse.getFullName()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="phone" class="form-label">Số điện thoại</label>
                    <input id="phone" class="form-control" name="phone" type="text" value="${nurse.getPhone()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input id="address" class="form-control" name="address" type="text" value="${nurse.getAddress()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" class="form-control" name="email" type="text" value="${userLogin.getEmail()}" pattern=".+@gmail\.com" required>
                    <span class="form-message"></span>
                </div>
                <button class="form-submit" type="submit">Save</button>
            </form>
            <%
                }
            %>
            <%                    if (account.getType().getAccountTypeId() == 4) { //Patient login
            %>
            <form action="editAccountPatient" method="POST" id="form-user" class="form-user">
                <div class="form-group">
                    <label for="account_id" class="form-label">Mã</label>
                    <input id="account_id" class="form-control" name="account_id" type="text" readonly value="${userLogin.getAccountId()}">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="username" class="form-label">Tên đăng nhập</label>
                    <input id="ten_dang_nhap" class="form-control" name="username" type="text" readonly value="${userLogin.getUserName()}">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="full_name" class="form-label">Tên người dùng</label>
                    <input id="full_name" class="form-control" name="full_name" type="text" value="${patient.getPatientName()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="phone" class="form-label">Số điện thoại</label>
                    <input id="phone" class="form-control" name="phone" type="text" value="${patient.getPhoneNumber()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input id="address" class="form-control" name="address" type="text" value="${patient.getAddress()}" required>
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" class="form-control" name="email" type="text" value="${userLogin.getEmail()}" pattern=".+@gmail\.com" required>
                    <span class="form-message"></span>
                </div>
                <button class="form-submit" type="submit">Save</button>
            </form>
            <%
                }
            %>            
           
        </div>

    </div>
</div>
