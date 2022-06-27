<%-- 
    Document   : EditPrescription
    Created on : Jun 27, 2022, 7:57:43 AM
    Author     : X1 Carbon Gen 7
--%>

<%@page import="entity.Medicine"%>
<%@page import="dao.MedicienDAO"%>
<%@page import="java.util.List"%>
<%@page import="entity.Patient"%>
<%@page import="dao.PatientDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Quản lý đơn thuốc > Chỉnh sửa đơn thuốc</span>
        <div class="spacer2"></div>
    </div>

    <%
        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAll();
        MedicienDAO medicineDAO = new MedicienDAO();
        List<Medicine> medicines = medicineDAO.getAll();
    %>

    <div class="form-container">

        <form action="edit" method="POST" id="form-dn">
            <input type="hidden" name="id" value="${prescription.getPresciptionId()}"/>
            <div class="form-group">
                <label class="form-label" for="prescriptionName">Tên đơn thuốc:</label>
                <input class="form-control" type="text" id="prescriptionName" name="prescriptionName" value="${prescription.getPresciptionName()}"><br/>
            </div>

<!--            <div class="form-group">
                <label class="form-label" for="time">Thời gian:</label>
                <input class="form-control" type="datetime-local" id="time" name="time"><br/>
            </div>-->

            <div class="form-group">
                <label class="form-label" for="patient" >Bệnh nhân:</label>
                <select class="form-control" name="patient" id="patient">
                    <% for (Patient patient : patients) {%>
                    <option value="<%=patient.getPatientId()%>" selected="${prescription.getPatient().getPatientId()}"><%=patient.getPatientName()%></option>
                    <% }%>
                </select><br/>
            </div>

            <div class="form-group">
                <label class="form-label" for="medicine">Thuốc:</label>
                <select class="form-control" name="medicine" id="medicine">
                    <% for (Medicine medicine : medicines) {%>
                    <option value="<%=medicine.getMedicienId()%>" selected="${prescription.getMedicine().getMedicienId()}"><%=medicine.getName()%></option>
                    <% }%>
                </select><br/>
            </div>
                
            <div class="form-group">
                <label class="form-label" for="quantity">Số lượng:</label>
                <input class="form-control" type="number" id="quantity" name="quantity" value="${prescription.getQuantity()}"><br/>
            </div>

            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>

        
    </div>
</div>
