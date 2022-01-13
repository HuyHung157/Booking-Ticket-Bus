<%-- 
    Document   : signin
    Created on : Jan 3, 2022, 3:32:05 PM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info">Login</h1>

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
    
    <button type="submit" class="btn btn-primary"> Đăng nhập </button>
    <br/><br/>
</form>
