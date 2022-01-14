<%-- 
    Document   : order-list
    Created on : Jan 15, 2022, 12:39:52 AM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <h1> Danh sách đơn hàng</h1>

    <a class="btn btn-success" href="<c:url value="/admin/order/create" />">
        Tạo mới
    </a>
</div>
