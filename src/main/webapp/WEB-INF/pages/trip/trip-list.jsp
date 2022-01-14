<%-- 
    Document   : trip-list
    Created on : Jan 15, 2022, 12:40:48 AM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <h1> Danh sách chuyến đi</h1>

    <a class="btn btn-success" href="<c:url value="/admin/trip/create" />">
        Tạo mới
    </a>
</div>
