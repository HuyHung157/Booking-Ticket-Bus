<%-- 
    Document   : signin
    Created on : Jan 3, 2022, 3:32:05 PM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section class="login-page">
    <h1 class="text-center text-info">Đăng nhập</h1>

    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            Tên đăng nhập hoặc mật khẩu không hợp lệ !!!
        </div>
    </c:if>

    <c:url value="/login" var="action"/>
    <form method="post" action="${action}" >
        <div class="form-group">
            <label for="username"> Tên đăng nhập </label>
            <input type="text" name="username" class="form-control" />
        </div>

        <div class="form-group">
            <label for="password"> Mật khẩu </label>
            <input type="password" name="password" class="form-control" />
        </div>


        <div class="form-action text-center">
            <button type="submit" class="m-0auto btn btn-primary"> Đăng nhập </button>
        </div>    
    </form>
</section>
