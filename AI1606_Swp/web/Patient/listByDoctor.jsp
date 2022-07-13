
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/list.css">

<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> > Hệ thống > Theo dõi bệnh nhân </span>
        <div class="spacer2"></div>
    </div>



    <div style="margin: 50px 350px 50px 50px;">
        <h2>Lọc danh sách</h2>
        <p style="font-size: 1.6rem;">Nhập bất kỳ thông tin liên quan trong bảng:</p>  
        <input style="font-size: 1.6rem;" class="form-control" id="myInput" type="text" placeholder="Search..">
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

            <tbody id="myTable">
                <tr></tr>
                <c:forEach var="patient" items="listPatient">
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
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="content-pad">
        <c:if test="${currentPage * 10 > noOfRecords}">
            <div class="content-pad__label">Showing ${(currentPage-1)*10+1} to ${noOfRecords} of ${noOfRecords} entries</div>
        </c:if>
        <c:if test="${currentPage * 10 <= noOfRecords}">
            <div class="content-pad__label">Showing ${(currentPage-1)*10+1} to ${currentPage * 10} of ${noOfRecords} entries</div>
        </c:if>

        <div class="content-pad__info">
            <c:if test="${currentPage != 1}">
                <a href="<%=request.getContextPath()%>/Patient/ListPatientByDoctor?page=${currentPage - 1}"> < </a>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <a href="">${i}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="<%=request.getContextPath()%>/Patient/ListPatientByDoctor?page=${i}"> ${i} </a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test = "${currentPage lt noOfPages}">
                <a href="<%=request.getContextPath()%>/Patient/ListPatientByDoctor?page=${currentPage+1}"> > </a>
            </c:if>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#myInput").on("keyup", function () {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function () {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
            });
        });
    });
</script>
