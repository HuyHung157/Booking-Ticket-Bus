<%-- 
    Document   : user-form
    Created on : Jan 3, 2022, 3:36:36 PM
    Author     : TIM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center">
    <c:if test="${mode=='User' or mode==null}">
        <a class="btn btn-danger" href="<c:url value="/admin/user/" />">
            Back
        </a>
    </c:if>

    <c:if test="${mode=='Employee'}">
        <a class="btn btn-danger" href="<c:url value="/admin/employee/" />">
            Back
        </a>
    </c:if>
    <h1 class="text-center m-0auto"> 
    <span>Tạo tài khoản</span>
    <c:if test="${mode=='User' or mode==null}">
        <span>khách hàng</span>
    </c:if>
    <c:if test="${mode=='Employee'}">
        <span>nhân viên</span>
    </c:if>
</h1>
</div>


<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/admin/user/create" var="action" />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="user">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-row">
        <div class="form-group w-50">
            <label for="name">Họ</label>
            <form:input path="firstName" class="form-control" id="firstName" />
            <form:errors path="firstName" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="name">Tên</label>
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
    <div class="form-row">
        <div class="form-group w-50">
            <label for="userRole">Loại tài khoản</label>
            <form:select path="userRole" class="form-control" id="userRole">
                <c:forEach items="${roleList}" var="r" varStatus="loop">
                    <form:option value="${r.getKey()}">${r.getValue()}</form:option> 
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group w-50">
            <label for="avatar">Avatar</label>
            <form:input type="file" id="avatar" path="file" class="form-control" />
        </div>
    </div>
    <div class="form-group">
        <label for="description">Ghi chú</label>
        <form:textarea path="description" class="form-control" id="description" />
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>

    <div class="form-action text-center">
        <button type="submit" class=" btn btn-success">Thêm tài khoản</button>
    </div>    
</form:form>