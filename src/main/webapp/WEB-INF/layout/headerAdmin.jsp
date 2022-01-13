<%-- 
    Document   : headerAdmin
    Created on : Jan 14, 2022, 12:16:30 AM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <div>
        <a href="<c:url value="/" />" class="nav-link text-success">
            <c:if test="${currentUser.imgUrl != null}">
                <img style="width:30px;" src="${currentUser.imgUrl}" class="rounded-circle" />
            </c:if>
            <c:if test="${currentUser.imgUrl == null}">
                <i class="fa fa-user"></i>
            </c:if>
            Chào,${currentUser.lastName} ${currentUser.firstName}
        </a>
    </div>
    <div>
        <a href="<c:url value="/logout" />" class="nav-link text-success">
            Đăng xuất
        </a>
    </div>
</c:if>
