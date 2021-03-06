<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 2021/3/24
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mon Compte</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="./Front-End/resources/dist/css/adminlte.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="./Front-End/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
</head>

<body class="hold-transition sidebar-mini layout-fixed" data-panel-auto-height-mode="height">
<div class="wrapper">

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
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
                    <form class="form-inline" method="GET" action="" >
                        <div class="input-group input-group-sm">
                            <ul>
                                <input class="form-control form-control-navbar" type="search" id="rechercher" placeholder="Search" aria-label="Search">
                                <!--afficher liste-->

                                <div class="input-group-append">
                                    <button class="btn btn-navbar" type="submit">
                                        <i class="fas fa-search"></i>
                                    </button><!--button de rechercher-->
                                    <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                                        <i class="fas fa-times"></i>
                                    </button><!--button d'annuler recherche-->
                                </div>
                                <li>
                                    <textarea id="zoneaff"></textarea>
                                </li>
                            </ul>
                        </div>
                    </form>
                </div>
            </li>

            <!-- Messages Dropdown Menu -->

            <!--Panier-->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="fas fa-shopping-basket"></i>
                    <span class="badge badge-danger navbar-badge">0</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Premier Produit -->
                        <div class="media">
                            <!-- image de Produi -->
                            <img src="" alt="User Avatar" class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nom Produit
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> <!-- ?????????????????? -->
                                </h3>
                            </div>
                        </div></a>

                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">Valider mon panier</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="fas fa-store"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <div class="media">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nom magasin 1
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> <!-- ?????????????????? -->
                                </h3>
                            </div>
                        </div></a>
                    <a href="#" class="dropdown-item">
                        <div class="media">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nom magasin 2
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span> <!-- ?????????????????? -->
                                </h3>
                            </div>
                        </div></a>

                </div>
            </li>


            <li class="nav-item">
                <a class="nav-link" data-widget="fullscreen" href="#" role="button">
                    <i class="fas fa-expand-arrows-alt"></i>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>

        </ul>
    </nav>
    <!-- /.navbar -->



    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="ServletAccueil" class="brand-link">
            <img src=".\Front-End\resources\image\logo.PNG" alt="logo" class="brand-image img-circle elevation-3" style="opacity: .8"> <!--notre Logo-->
            <span class="brand-text font-weight-light">Magasin en ligne!</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user panel (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <div class="info">
                        <a href="#" class="d-block"><%out.print(session.getAttribute("email"));%></a><!-- ??????login -->
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

                    <li class="nav-header">LABELS</li>
                    <li class="nav-item">
                        <a href="#cmd"><i class="nav-icon far fa-circle text-danger"></i>
                        Commandes</a >
                    </li>
                    <li class="nav-item">
                        <a href="#listeC"><i class="nav-icon far fa-circle text-info"></i>
                            liste des courses</a>
                    </li>

                    <li class="nav-item">
                        <a href="#pref"><i class="nav-icon far fa-circle text-info"></i>
                        habitude</a>
                    </li>

                    <li class="nav-item">
                        <a href="#profile">
                            <i class="nav-icon far fa-circle text-warning"></i>
                            profile</a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper iframe-mode" data-widget="iframe" data-loading-screen="750">


        <!--Afficher-->

        <div class="tab-content" >
            <jsp:include page="./Front-End/pageCompte.jsp"></jsp:include>

        </div>

    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">

    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- jQuery -->
<script src=".\Front-End\resources\plugins\jquery\jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="Front-End/resources/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="Front-End/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- overlayScrollbars -->
<script src="Front-End/resources/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="Front-End/resources/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="Front-End/resources/dist/js/demo.js"></script>
</body>
</html>
