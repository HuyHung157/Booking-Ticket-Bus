<%-- 
    Document   : register
    Created on : Jan 3, 2022, 3:31:56 PM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="register-page">
    <h1 class="text-center text-info">Đăng ký</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action" />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-row">
        <div class="form-group w-50">
            <label for="name">Tên</label>
            <form:input path="firstName" class="form-control" id="firstName" />
            <form:errors path="firstName" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="name">Họ</label>
            <form:input path="lastName" class="form-control" id="lastName" />
            <form:errors path="lastName" element="div" cssClass="text-danger" />
        </div>
    </div>
    <div class="form-row">
        <div class="form-group w-50">
            <label for="name">Tên đăng nhập</label>
            <form:input path="username" class="form-control" id="username" />
            <form:errors path="username" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="name">Email</label>
            <form:input path="email" class="form-control" id="email" />
            <form:errors path="email" element="div" cssClass="text-danger" />
        </div>
    </div>
    <div class="form-row">
        <div class="form-group w-50">
            <label for="name">Mật khẩu</label>
            <form:password path="password" class="form-control" id="password" />
            <form:errors path="password" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label>Xác nhận mật khẩu</label>
            <form:password path="confirmPassword" class="form-control" id="confirmPassword" />
            <form:errors path="confirmPassword" element="div" cssClass="text-danger" />
        </div>
    </div>
    <div class="form-row">
        <div class="form-group w-50">
            <label for="name">Số điện thoại</label>
            <form:input path="phone" class="form-control" id="name" />
            <form:errors path="phone" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="name">Địa chỉ</label>
            <form:input path="address" class="form-control" id="address" />
            <form:errors path="address" element="div" cssClass="text-danger" />
        </div>
    </div>

    <div class="form-action text-center">
        <button type="submit" class=" btn btn-success">Đăng ký</button>
    </div>    
</form:form>

</section>