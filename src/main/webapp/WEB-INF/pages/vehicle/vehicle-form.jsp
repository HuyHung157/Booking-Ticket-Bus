<%-- 
    Document   : vehicle-form
    Created on : Jan 15, 2022, 12:41:40 AM
    Author     : TIM
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <a class="btn btn-danger" href="<c:url value="/admin/vehicle" />">
        Back
    </a>

    <h1 class="text-center m-0auto"> Tạo phương tiện</h1>
</div>

<c:url value="/admin/vehicle/create" var="action" />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="vehicle">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-row">
        <div class="form-group w-50">
            <label for="vehicleNumber">Số thứ tự phương tiện</label>
            <form:input path="vehicleNumber" class="form-control" id="vehicleNumber" />
            <form:errors path="vehicleNumber" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="licensePlates">Biển số phương tiện</label>
            <form:input path="licensePlates" class="form-control" id="licensePlates" />
            <form:errors path="licensePlates" element="div" cssClass="text-danger" />
        </div>
    </div>

    <div class="form-row">
        <div class="form-group w-50">
            <label for="vehicleName">Tên phương tiện</label>
            <form:input path="vehicleName" class="form-control" id="vehicleName" />
            <form:errors path="vehicleName" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="vehicleBranch">Thương hiệu phương tiện</label>
            <form:input path="vehicleBranch" class="form-control" id="vehicleBranch" />
            <form:errors path="vehicleBranch" element="div" cssClass="text-danger" />
        </div>
    </div>

    <div class="form-row">
        <div class="form-group w-50">
            <label for="totalSeatUpper">Số ghế tầng trên</label>
            <form:input path="totalSeatUpper" class="form-control" id="totalSeatUpper" />
            <form:errors path="totalSeatUpper" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="totalSeatLower">Số ghế tầng dưới</label>
            <form:input path="totalSeatLower" class="form-control" id="totalSeatLower" />
            <form:errors path="totalSeatLower" element="div" cssClass="text-danger" />
        </div>
    </div>

    <div class="form-row">
        <div class="form-group w-50">
            <label for="totalSeat">Tổng số ghế</label>
            <form:input path="totalSeat" class="form-control" id="totalSeat" />
            <form:errors path="totalSeat" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="image">Hình ảnh</label>
            <form:input type="file" id="image" path="file" class="form-control" />
        </div>
    </div>

    <div class="form-group ">
        <label for="status">Trạng thái</label>
        <form:input id="status" path="status" class="form-control" />
    </div>

    <div class="form-group">
        <label for="description">Ghi chú</label>
        <form:textarea path="description" class="form-control" id="description" />
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>

    <div class="form-action text-center">
        <button type="submit" class=" btn btn-success">Thêm phương tiện</button>
    </div>   

</form:form>