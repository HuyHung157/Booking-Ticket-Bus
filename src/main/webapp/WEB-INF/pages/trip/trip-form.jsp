<%-- 
    Document   : trip-form
    Created on : Jan 15, 2022, 12:41:13 AM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <a class="btn btn-danger" href="<c:url value="/admin/trip" />">
        Back
    </a>

    <h1 class="text-center m-0auto"> Tạo hành trình</h1>

</div>


<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/admin/trip/create" var="action" />
<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="trip">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />

    <div class="form-row">
        <div class="form-group w-50">
            <label for="startPoint">Điểm đi</label>
            <form:select path="startPoint" class="form-control" id="startPoint">
                <c:forEach items="${locationList}" var="r" varStatus="loop">
                    <form:option value="${r.getId()}">${r.getLocationName()}</form:option> 
                </c:forEach>
            </form:select>
            <form:errors path="startPoint" element="div" cssClass="text-danger" />
        </div>
        <div class="form-group w-50">
            <label for="endPoint">Điểm đi</label>
            <form:select path="endPoint" class="form-control" id="endPoint">
                <c:forEach items="${locationList}" var="r" varStatus="loop">
                    <form:option value="${r.getId()}">${r.getLocationName()}</form:option> 
                </c:forEach>
            </form:select>
            <form:errors path="endPoint" element="div" cssClass="text-danger" />
        </div>
    </div>

    <div class="form-group">
        <label for="description">Ghi chú</label>
        <form:textarea path="description" class="form-control" id="description" />
        <form:errors path="description" element="div" cssClass="text-danger" />
    </div>

    <div class="form-action text-center">
        <button type="submit" class=" btn btn-success">Thêm hành trình</button>
    </div>    
</form:form>