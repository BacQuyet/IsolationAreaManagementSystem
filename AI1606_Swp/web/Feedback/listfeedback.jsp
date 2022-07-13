<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Quản lý feedback </span>
        <div class="spacer2"></div>
    </div>
    <div class="table-list">
        <table class="table-list__user">
            <tr>
                <th width="10%">Mã</th>
                <th width="30%">Nội Dung</th>
                <th width="20%">Ngày Tạo</th>
            </tr>
            <c:forEach var="feedback" items="${list}">
                <tr>
                    <td>${feedback.getFeedback_id()}</td>
                    <td>${feedback.getContent()}</td>
                    <td>${feedback.getCreateDate()}</td>
                 
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="content-pad">
            <c:if test="${currentPage * 5 > noOfRecords}">
                <div class="content-pad__label">Showing ${(currentPage-1)*5+1} to ${noOfRecords} of ${noOfRecords} entries</div>
            </c:if>
            <c:if test="${currentPage * 5 <= noOfRecords}">
                <div class="content-pad__label">Showing ${(currentPage-1)*5+1} to ${currentPage * 5} of ${noOfRecords} entries</div>
            </c:if>

            <div class="content-pad__info">
                <c:if test="${currentPage != 1}">
                    <a href="<%=request.getContextPath()%>/Doctors/ViewDoctor?page=${currentPage - 1}"> < </a>

                </c:if>

                <c:forEach begin="1" end="${noOfPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <a href="">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="<%=request.getContextPath()%>/Doctors/ViewDoctor?page=${i}"> ${i} </a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test = "${currentPage lt noOfPages}">
                    <a href="<%=request.getContextPath()%>/Doctors/ViewDoctor?page=${currentPage+1}"> > </a>
                </c:if>
            </div>
        </div>
    
</div>


</div>
