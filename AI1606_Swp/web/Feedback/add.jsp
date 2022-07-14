<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/assets/css/list/add.css">
<div class="col-10 content">
    <div class="content-label">
        <span class="content-label__menu">Bảng điều khiển</span>
        <span class="content-label__info"><i class="fas fa-home"></i> Hệ thống > Góp ý</span>
        <div class="spacer2"></div>
    </div>
    
    <div class="form-container">
        <form action="addFeedback" method="POST" id="form-dn" class="form">
            <div class="form-group form-group__special">
                <label for="feedbackName" class="form-label">Nội dung góp ý</label>
                <textarea id="feedbackName" class="form-control" name="feedbackName" type="text" required ></textarea>
                <span class="form-message"></span>
            </div>
        </form>
    </div>
</div>
