<%-- 
    Document   : trip-detail-list
    Created on : Jan 20, 2022, 10:05:09 PM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <h1> Danh sách chuyến đi</h1>

    <a class="btn btn-success" href="<c:url value="/admin/trip-detail/create" />">
        Tạo mới
    </a>
</div>
