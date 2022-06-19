<%-- 
    Document   : AddPrescription
    Created on : Jun 20, 2022, 12:37:30 AM
    Author     : X1 Carbon Gen 7
--%>

<%@page import="entity.Medicine"%>
<%@page import="java.util.List"%>
<%@page import="entity.Patient"%>
<%@page import="dao.PatientDAO"%>
<%@page import="dao.MedicienDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Quản lý đơn thuốc > Thêm đơn thuốc</span>
        <div class="spacer2"></div>
    </div>

    <%
        PatientDAO patientDAO = new PatientDAO();
        List<Patient> patients = patientDAO.getAll();
        MedicienDAO medicineDAO = new MedicienDAO();
        List<Medicine> medicines = medicineDAO.getAll();
    %>

    <div class="form-container">
        <form action="/Prescription/add" method="POST" id="form-dn" class="form">
            <div class="form-header">
                <div class="form-group form-group__special">
                    <label for="prescriptionName" class="form-label">Tên đơn thuốc:</label>
                    <input id="prescriptionName" class="form-control" name="prescriptionName" type="text" required>
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="time" class="form-label">Thời gian:</label>
                    <input type="datetime-local" id="timeIn" class="form-control"
                           name="time" >
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="patient" class="form-label">Bệnh nhân:</label>
                    <select name="patient" id="patient" class="form-control" required>
                        <% for (Patient patient : patients) {%>
                        <option value="<%=patient.getPatientId()%>"><%=patient.getPatientName()%></option>
                        <% }%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="patient" class="form-label">Thuốc:</label>
                    <select name="patient" id="patient" class="form-control" required>
                        <% for (Medicine medicine : medicines) {%>
                        <option value="<%=medicine.getMedicienId()%>"><%=medicine.getName()%></option>
                        <% }%>
                    </select>
                </div>

                <div class="form-group">
                    <label for="quantity" class="form-label">Số lượng:</label>
                    <input id="quantity" class="form-control" name="quantity" type="number" required>
                    <span class="form-message"></span>
                </div>

                <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>
    </div>
</div>

