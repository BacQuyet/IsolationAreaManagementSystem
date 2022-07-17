<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý tài khoản </span>
        <div class="spacer2"></div>
    </div>
    <div class='search col-7' style="margin-left: 22px; margin-top: 10px;">
        <form action ="searchNurse" method="POST">
            <input type="text" class="search__text" placeholder="Nhập để tìm kiếm" id="key" name="key">
            <button type="SUBMIT"><i class="fas fa-search"></i></button>
        </form>
    </div>
    <div class="btn-add">
        <a href="<%=request.getContextPath()%>/Nurse/addnurse"><i class="fas fa-plus-circle"></i>
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
            <c:forEach var="nurse" items="${listnurse}">
                <tr>
                    <td>${nurse.getId_nurse()}</td>
                    <td>${nurse.getFullName()}</td>
                    <td>${nurse.getAddress()}</td>
                    <td>${nurse.getPhone()}</td>
                    <td class="td-action">
                        <a href="<%=request.getContextPath()%>/Nurse/viewdetailnurse?nurseId=${nurse.getId_nurse()}"><i class="far fa-calendar-alt"></i></a>
                        <a href="<%=request.getContextPath()%>/Nurse/updatenurse?nurseId=${nurse.getId_nurse()}"><i class="fas fa-pen"></i></a>
                        <a href="<%=request.getContextPath()%>/Nurse/deletenurse?nurseId=${nurse.getId_nurse()}" style="background-color: red"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="content-pad">
            <c:if test="${currentPage * 5 > noOfRecords}">
                <div class="content-pad__label">Showing ${(currentPage-1)*5+1} to ${noOfRecords} of ${noOfRecords} entries</div>
            </c:if>
            <c:if test="${currentPage * 5 <= noOfRecords}">
                <div class="content-pad__label">Showing ${(currentPage-1)*5+1} to ${currentPage * 5} of ${noOfRecords} entries</div>
            </c:if>

            <div class="content-pad__info">
                <c:if test="${currentPage != 1}">
                    <a href="<%=request.getContextPath()%>/Nurse/viewnurse?page=${currentPage - 1}"> < </a>
                </c:if>

                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <a href="">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="<%=request.getContextPath()%>/Nurse/viewnurse?page=${i}"> ${i} </a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test = "${currentPage lt noOfPages}">
                    <a href="<%=request.getContextPath()%>/Nurse/viewnurse?page=${currentPage+1}"> > </a>
                </c:if>
            </div>
        </div>
    </div>           
</div>
