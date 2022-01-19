<%-- 
    Document   : location-form
    Created on : Jan 15, 2022, 12:40:33 AM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <a class="btn btn-danger" href="<c:url value="/admin/location" />">
        Back
    </a>

    <h1 class="text-center m-0auto"> Tạo địa điểm</h1>
</div>

<c:url value="/admin/location/create" var="action" />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="location">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-row">
        <div class="form-group w-50">
            <label for="name">Tên địa điểm</label>
            <form:input path="locationName" class="form-control" id="locationName" />
            <form:errors path="locationName" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="locationKey">Kí hiệu địa điểm</label>
            <form:input path="locationKey" class="form-control" id="locationKey" />
            <form:errors path="locationKey" element="div" cssClass="text-danger" />
        </div>
    </div>

    <div class="form-group w-50">
        <label for="image">Hình ảnh</label>
        <form:input type="file" id="image" path="file" class="form-control" />
    </div>

    <div class="form-group">
        <label for="description">Ghi chú</label>
        <form:textarea path="description" class="form-control" id="description" />
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>

    <div class="form-action text-center">
        <button type="submit" class=" btn btn-success">Thêm địa điểm</button>
    </div>   

</form:form>