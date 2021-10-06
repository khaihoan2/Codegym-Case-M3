<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Team 2 | ... </title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../static/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Tempusdominus Bootstrap 4 -->
    <link rel="stylesheet" href="../static/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="../static/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- JQVMap -->
    <link rel="stylesheet" href="../static/plugins/jqvmap/jqvmap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../static/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="../static/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
    <!-- Daterange picker -->
    <link rel="stylesheet" href="../static/plugins/daterangepicker/daterangepicker.css">
    <!-- summernote -->
    <link rel="stylesheet" href="../static/plugins/summernote/summernote-bs4.min.css">
</head>
<<<<<<< HEAD


<body class="hold-transition sidebar-mini layout-fixed layout-navbar-fixed">
<div class="wrapper">

    <!-- Preloader -->
    <div class="preloader flex-column justify-content-center align-items-center" style="height: 0px;">
        <img class="animation__shake" src="../static/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60"
             style="display: none;">
    </div>

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-dark">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="/dashboard" class="nav-link">Dashboard</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Navbar Search -->
            <li class="nav-item">
                <a class="nav-link" data-widget="navbar-search" href="#" role="button">
                    <i class="fas fa-search"></i>
                </a>
                <div class="navbar-search-block">
                    <form class="form-inline">
                        <div class="input-group input-group-sm">
                            <input class="form-control form-control-navbar" type="search" placeholder="Search"
                                   aria-label="Search">
                            <div class="input-group-append">
                                <button class="btn btn-navbar" type="submit">
                                    <i class="fas fa-search"></i>
                                </button>
                                <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>
            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../static/dist/img/user1-128x128.jpg" alt="User Avatar"
                                 class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../static/dist/img/user8-128x128.jpg" alt="User Avatar"
                                 class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="../static/dist/img/user3-128x128.jpg" alt="User Avatar"
                                 class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">The subject goes here</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 new messages
                        <span class="float-right text-muted text-sm">3 mins</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 friend requests
                        <span class="float-right text-muted text-sm">12 hours</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 new reports
                        <span class="float-right text-muted text-sm">2 days</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
                </div>
            </li>
            <!-- Fullscreen Toggle -->
            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="/dashboard" class="brand-link">
            <img src="../static/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">Electro</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="image">
                    <img src="../static/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
                </div>
                <div class="info">
                    <a href="#" class="d-block">Chính Thành Hoàn Vũ</a>
                </div>
            </div>

            <!-- SidebarSearch Form -->
            <div class="form-inline">
                <div class="input-group" data-widget="sidebar-search">
                    <input class="form-control form-control-sidebar" type="search" placeholder="Search"
                           aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-sidebar">
                            <i class="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <%--                    Dashboard--%>
                    <li class="nav-item">
                        <a href="/dashboard" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Dashboard
                            </p>
                        </a>
                    </li>
                    <%--                    Product--%>
                    <li class="nav-item">
                        <a href="/products" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Products
                                <span class="right badge badge-danger">${products.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Categories--%>
                    <li class="nav-item">
                        <a href="/categories" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Categories
                                <span class="right badge badge-danger">${categories.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Brands--%>
                    <li class="nav-item">
                        <a href="/brands" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Brands
                                <span class="right badge badge-danger">${brands.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Vendors--%>
                    <li class="nav-item">
                        <a href="/vendors" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Vendors
                                <span class="right badge badge-danger">${vendors.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Discount--%>
                    <li class="nav-item">
                        <a href="/discounts" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Discounts
                                <span class="right badge badge-danger">${discounts.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Images--%>
                    <li class="nav-item">
                        <a href="/images" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Images
                                <span class="right badge badge-danger">${images.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Users--%>
                    <li class="nav-item">
                        <a href="/users" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Users
                                <span class="right badge badge-danger">${users.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Orders--%>
                    <li class="nav-item">
                        <a href="/order" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Orders
                                <span class="right badge badge-danger">${orders.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Payment--%>
                    <li class="nav-item">
                        <a href="/payment" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Payments
                                <span class="right badge badge-danger">${payments.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Shipments--%>
                    <li class="nav-item">
                        <a href="/shipment" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Shipments
                                <span class="right badge badge-danger">${shipments.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Statuses--%>
                    <li class="nav-item">
                        <a href="/status" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Statuses
                                <span class="right badge badge-danger">${statuses.size()}</span>
                            </p>
                        </a>
                    </li>
                    <%--                    Role--%>
                    <li class="nav-item">
                        <a href="/role" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                Roles
                                <span class="right badge badge-danger">${roles.size()}</span>
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Delete category</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Delete category</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- CHỈ CHỈNH SỬA PHẦN MAIN CONTENT NÀY THÔI NHÉ -->
        <!-- MẪU HTML CÓ THỂ LẤY TẠI " /static/pages/examples/..." -->
        <!-- Main content -->
        <!-- div class="content" -->

        <form method="post">
            <button>Yes, delete</button>
        </form>

        <!-- /.div -->
        <!-- /.content -->
        <!-- /.DỪNG Ở ĐÂY ĐƯỢC RỒI, ĐỪNG SỬA CÁC PHẦN KHÁC -->
        <!-- /.LÀM ƠN ĐỪNG SỬA CÁC PHẦN KHÁC -->

    </div>
    <!-- /.content-wrapper -->

    <!-- Footer -->
    <footer class="main-footer position-fixed">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.2.0-rc
        </div>
        <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
    </footer>
    <!-- /.footer -->
</div>


<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="../static/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../static/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="../static/dist/js/adminlte.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="../static/plugins/chart.js/Chart.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../static/dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../static/dist/js/pages/dashboard3.js"></script>
=======
<body>
<form method="post">
    <button>OK, Delete</button>
</form>
>>>>>>> hoannnk
</body>
</html>