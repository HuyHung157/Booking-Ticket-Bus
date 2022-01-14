<%-- 
    Document   : admin-user
    Created on : Jan 3, 2022, 3:32:45 PM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <h1 > 
        <span>Danh sách</span>
        <c:if test="${mode=='User' or mode==null}">
            <span>khách hàng</span>
        </c:if>
        <c:if test="${mode=='Employee'}">
            <span>nhân viên</span>
        </c:if>
    </h1>

    <c:if test="${mode=='User' or mode==null}">
        <a class="btn btn-success" href="<c:url value="/admin/user/create" />">
            Tạo mới
        </a>
    </c:if>

    <c:if test="${mode=='Employee'}">
        <a class="btn btn-success" href="<c:url value="/admin/employee/create" />">
            Tạo mới
        </a>
    </c:if>
</div>
