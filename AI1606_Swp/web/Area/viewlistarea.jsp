<%@page import="entity.Account"%>
<%@page import="dao.RoomDAO"%>
<%@page import="entity.Room"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">

<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý phòng bệnh</span>
        <div class="spacer2"></div>
    </div>
    <%
        Account account = (Account) session.getAttribute("userLogin");
        if (account.getType().getAccountTypeId() == 1) {
    %>
    <div class="btn-add">
        <a href="<%=request.getContextPath()%>/Area/addarea"><i class="fas fa-plus-circle"></i>
            <span>Thêm khu vực</span>
        </a>
    </div>
    <% }
    %>
    
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="10%">Mã khu vực</th>
                <th width="20%">Tên khu vực</th>
                <th width="10%">Địa chỉ khu vực</th>  
                <th width="20">Liên lạc</th>  
                <th width="15%">Hành động</th>
            </tr>
            
            <c:forEach items="${listArea}" var="area">
                <tr>
                    <td>${area.getAreaId()}</td>
                    <td>${area.getAreaName()}</td>
                    <td>${area.getAreaAddress()}</td>
                    <td>${area.getContact()}</td>
                    <td class="td-action">
                        <a href="<%=request.getContextPath()%>/Area/viewdetailroom?roomId=${room.getRoomId()}"><i class="far fa-calendar-alt"></i></a>
                        <a href="<%=request.getContextPath()%>/Area/updateroom?roomId=${room.getRoomId()}"><i class="fas fa-pen"></i></a>
                        <a href="<%=request.getContextPath()%>/Area/deletearea?areaId=${area.getAreaId()}" style="background-color: red"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
