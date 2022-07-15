<%@page import="entity.Feedback"%>
<%@page import="dao.FeedbackDAO"%>
<%@page import="java.util.List"%>
<%@page import="entity.Patient"%>
<%@page import="dao.PatientDAO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Góp ý</span>
        <div class="spacer2"></div>
    </div>

    <div class="form-container">
        <form action="updateFeedback" method="POST" id="form-dn" class="form">
            <input type="text" id="feedbackId" name="feedbackId" value="${feedback.getFeedback_id()}" style="display: none"/>
            <input type="text" id="PatientId" name="PatientId" value="${feedback.getPatient().getPatientId()}" style="display: none"/>
            <div class="form-group form-group__special">
                <label for="feedbackName" class="form-label">Cập nhật góp ý</label>
                <input value="${feedback.getContent()}" id="feedbackName" class="form-control" name="feedbackName" type="text" required />
                <span class="form-message"></span>
            </div>

            <button type = "submit" class="form-submit"><i class="far fa-save"></i><span>Lưu</span></button>
        </form>

    </div>
</div>

