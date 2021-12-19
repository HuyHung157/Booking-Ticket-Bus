<%-- 
    Document   : baseAdmin
    Created on : Dec 19, 2021, 10:48:57 PM
    Author     : TIM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <tiles:insertAttribute name="title"/> - Nhà xe ABC </title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value='/css/sidebar.css'/>"  /></link>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>

<body>
    <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>Bến xe ABC</h3>
                <strong>ABC</strong>
            </div>

            <button type="button" id="sidebarCollapse" class="btn btn-info">
                <i class="fa fa-chevron-left"></i>
            </button>

            <ul class="list-unstyled components">
                <li>
                    <a href=""> <i class="fa fa-home"></i> Home </a>
                </li>                

                <li>
                    <a href="#accountSubmenu" data-toggle="collapse" aria-expanded="false">
                        <i class="fa fa-file"></i>
                        Tài khoản
                    </a>
                    <ul class="collapse list-unstyled" id="accountSubmenu">
                        <li><a href=""><i class="fa fa-user"></i>Cư dân</a></li>
                        <li><a href=""><i class="fa fa-user-cog"></i>Nhân viên</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#serviceSubmenu" data-toggle="collapse" aria-expanded="false">
                        <i class="fa fa-hand-holding-heart"></i>
                        Dịch vụ
                    </a>
                    <ul class="collapse list-unstyled" id="serviceSubmenu">
                        <li><a href="")"><i class="fa fa-clipboard-list"></i>Hóa đơn</a></li>
                        <li><a href=""><i class="fa fa-list-ul"></i>Loại dịch vụ</a></li>
                    </ul>
                </li>
                <li> <a href="#"> <i class="fas fa-cog"></i>  Cài đặt </a> </li>
            </ul>
        </nav>

        <!-- Page Content Holder -->
        <div id="content">
            <div class="content__container h-100 d-flex flex-column">

                <div class="main-content" style="flex: 1">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <div class="container-fluid">
                            
                            Đăng Nhập
                            
                        </div>
                    </nav>
                    <div class="container">
                        <tiles:insertAttribute name="contentAdmin" />
                    </div>

                </div>
                
                <tiles:insertAttribute name="footer" />
                
            </div>
        </div>
        
    </div>
</body>
</html>
