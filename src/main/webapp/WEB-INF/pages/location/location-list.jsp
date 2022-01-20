<%-- 
    Document   : location-list
    Created on : Jan 15, 2022, 12:40:10 AM
    Author     : TIM
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="header-list d-flex align-items-center justify-content-between">
    <h1> Danh sách địa điểm</h1>

    <a class="btn btn-success" href="<c:url value="/admin/location/create" />">
        Tạo mới
    </a>
</div>

<table  class="content-table">
    <tr>
        <th> ID </th>
        <th> Địa điểm </th>
        <th> Chức năng </th>
    </tr>

    <c:forEach items="${locationList}" var="item" varStatus="loop">
        
        <tr>
            <td> ${item.getId()} </td>
            <td> ${item.getLocationName()} </td>
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

