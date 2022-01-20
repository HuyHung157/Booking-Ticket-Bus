<%-- 
    Document   : header
    Created on : Dec 19, 2021, 10:48:57 PM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">Nhà xe ABC</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
            </li>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="nav-item">
                    <a href="<c:url value="/login" />" class="nav-link">
                        <i class="fa fa-user" aria-hidden="true"></i> Đăng nhập
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<c:url value="/register" />" class="nav-link">
                        <i class="fa fa-check" aria-hidden="true"></i> Đăng ký
                    </a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item">
                    <a href="<c:url value="/" />" class="nav-link">
                        <c:if test="${currentUser.imgUrl != null}">
                            <img style="width:30px;" src="${currentUser.imgUrl}" class="rounded-circle" />
                        </c:if>
                        <c:if test="${currentUser.imgUrl == null}">
                            <i class="fa fa-user"></i>
                        </c:if>
                        Chào, ${currentUser.lastName} ${currentUser.firstName}
                    </a>
                </li>
                <li class="nav-item">
                    <a href="<c:url value="/logout" />" class="nav-link">
                        Đăng xuất
                    </a>
                </li>
            </c:if>


        </ul>
    </div>

    <c:url value="/" var="actionProduct" />
    <form class="form-inline" action="${actionProduct}">
        <input class="form-control mr-sm-2" name="kw" type="text" placeholder="Nhập từ khóa">
        <button class="btn btn-success" type="submit">Tìm kiếm</button>
    </form>
</nav>
