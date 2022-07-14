<%@page import="utils.Utils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">
<div class='search col-10'>
<div class="col-10 content">
     <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Người cách ly </span>
        <div class="spacer2"></div>
     </div>
     <form action ="searchPatient" method="POST">
        <input type="text" class="search__text" placeholder="Nhập để tìm kiếm" id="key" name="key">
        <button type="SUBMIT"><i class="fas fa-search"></i></button>
     </form> 
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
             <c:forEach var="patient" items="${list}">
                <tr>
                    <td>${patient.getPatientId()}</td>
                    <td>${patient.getPatientName()}</td>
                    <td>${patient.getAge()}</td>
                    <td>${patient.getRoomName()}</td>
                    <td>${patient.getAreaName()}</td>
                    <td>${patient.getRegion()}</td>
                    <c:if test="${empty patient.getTimeOut()}"> <td>${Utils.getDistanceTime(patient.getTimeIn(), patient.getTimeOut()) + 1} ngày</td>
                    </c:if>
                    <c:if test="${not empty patient.getTimeOut()}"><td style="color: red; font-weight: 500;">Đã ra</td></c:if>
                    <td data-filetype="${patient.getSuspicionLevel()}">${patient.getSuspicionLevel()}</td>
                    <td class="td-action">
                        <a href="<%=request.getContextPath()%>/Patient/view-detail?id=${patient.getPatientId()}"><i class="far fa-calendar-alt"></i></a>
                        <a href="<%=request.getContextPath()%>/Patient/update.jsp?id=${patient.getPatientId()}"><i class="fas fa-pen"></i></a>
                        <a href="<%=request.getContextPath()%>/Patient/delete?id=${patient.getPatientId()}" style="background-color: red"><i class="fas fa-trash-alt"></i></a>
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
                    <a href="<%=request.getContextPath()%>/Patient/ViewPatient?page=${currentPage - 1}"> < </a>
                </c:if>

                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <a href="">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="<%=request.getContextPath()%>/Patient/ViewPatient?page=${i}"> ${i} </a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                 <c:if test = "${currentPage lt noOfPages}">
                    <a href="<%=request.getContextPath()%>/Patient/ViewPatient?page=${currentPage+1}"> > </a>
                 </c:if>
             </div>
         </div>
     </div>
</div>
</div>


