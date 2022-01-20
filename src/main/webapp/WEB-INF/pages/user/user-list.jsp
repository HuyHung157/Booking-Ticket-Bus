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

<table  class="content-table">
    <tr>
        <th> ID </th>
        <th> Họ và Tên </th>
        <th> Tài khoản </th>
        <th> Email </th>
        <th> Role </th>
        <th> Chức năng </th>
    </tr>

    <c:forEach items="${userList}" var="item" varStatus="loop">

        <tr>
            <td> ${item.id} </td>
            <td> ${item.lastName} ${item.firstName} </td>
            <td> ${item.username} </td>
            <td> ${item.email} </td>
            <td> ${item.userRole} </td>
            <td class="list-action">
                <a data-toggle="tooltip" 
                   title="Chỉnh sửa" class="text-primary" 
                   href="">
                    <i class="fa fa-pencil-alt"></i>
                </a>

                <a data-toggle="tooltip" 
                   title="Chi tiết" 
                   class="text-warning" 
                   href="">
                    <i class="fa fa-eye"></i>
                </a>

                <a data-toggle="tooltip" 
                   title="Xóa" 
                   class="text-danger" 
                   href="">
                    <i class="fa fa-trash-alt"></i>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>