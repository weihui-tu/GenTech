<%@ page import="metier.Produit" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: woshi
  Date: 2021/3/23
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        ArrayList<Produit> listPromo=(ArrayList<Produit>)request.getAttribute("listPromo");
        Produit p=(Produit)request.getAttribute("unProduit");
        DecimalFormat df = new DecimalFormat("0.00");//decimal formate
        String email = (String)session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Produit</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href=".\resources\plugins\fontawesome-free\css\all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href=".\resources\dist\css\adminlte.min.css">
</head>

<body class="hold-transition sidebar-mini">
<!-- Content Header (Page header) -->
<div class="container-fluid">
    <div class="row mb-2">
        <div class="col-sm-6">
            <h2></h2>
        </div>
        <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">

            </ol>
        </div>
    </div>
</div><!-- /.container-fluid -->
</section>

<!-- Main content -->
<section class="content">

    <!-- Default box -->
    <div class="card card-solid">
        <div class="card-body">
            <div class="row">
                <div class="col-12 col-sm-6">
                    <h3 class="d-inline-block d-sm-none"><%out.print(p.getLibelleProduit()); %></h3>
                    <!-- Les images de produit -->
                    <!-- 大图 -->
                    <div class="col-12">
                        <img src="images/<%out.print(p.getCodeProduit()); %>.jpg" class="product-image" alt="Product Image">
                    </div>
                    <!-- 缩略图 -->
                    <div class="col-12 product-image-thumbs">
                        <div class="product-image-thumb active"><img src="images/<%out.print(p.getCodeProduit()); %>.jpg" alt="Product Image"></div>
                        <div class="product-image-thumb" ><img src="images/<%out.print(p.getCodeProduit()); %>.jpg" alt="Product Image"></div>
                        <div class="product-image-thumb" ><img src="images/<%out.print(p.getCodeProduit()); %>.jpg" alt="Product Image"></div>
                        <div class="product-image-thumb" ><img src="images/<%out.print(p.getCodeProduit()); %>.jpg" alt="Product Image"></div>
                    </div>

                    <div class="col-12">
                        <br>
                        <br>
                        <h3 style="color:#4169E1">Ingrédients / Composition</h3>
                        <br>
                        <h5 style="color:#4169E1">Composition</h5>

                        <table class="table">
                            <tr><td></td><td style="color:#0e3368;text-align: right;">Valeurs nutritionnelles   pour 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Valeur énergétique (kJ)</td><td style="color:#6a5d6a;text-align: right;">922 kJ / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Valeur énergétique (kcal)</td><td style="color:#6a5d6a;text-align: right;">221 kcal / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Matieres grasses</td><td style="color:#6a5d6a;text-align: right;">12 g / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Dont acides gras saturés</td><td style="color:#6a5d6a;text-align: right;">7 g / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Glucides</td><td style="color:#6a5d6a;text-align: right;">25 g / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Dont sucres</td><td style="color:#6a5d6a;text-align: right;">23 g / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Fibres alimentaires</td><td style="color:#6a5d6a;text-align: right;">1.5 g / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Protéines</td><td style="color:#6a5d6a;text-align: right;">3.1 g / 100 g</td></tr>
                            <tr><td style="color:#0e3368;text-align: left;">Sel</td><td style="color:#6a5d6a;text-align: right;">0.14 g / 100 g</td></tr>

                        </table>
                    </div>
                </div>

                <div class="col-12 col-sm-6">
                    <h3 class="my-3" style="color:#4169E1"><%out.print(p.getLibelleProduit());%></h3>
                    <p style="color:#6a5d6a">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi vitae condimentum erat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed posuere, purus at efficitur hendrerit, augue elit lacinia arcu, a eleifend sem elit et nunc. Sed rutrum vestibulum est, sit amet cursus dolor fermentum vel. Suspendisse mi nibh, congue et ante et, commodo mattis lacus. Duis varius finibus purus sed venenatis. Vivamus varius metus quam, id dapibus velit mattis eu. Praesent et semper risus. Vestibulum erat erat, condimentum at elit at, bibendum placerat orci. Nullam gravida velit mauris, in pellentesque urna pellentesque viverra. Nullam non pellentesque justo, et ultricies neque. Praesent vel metus rutrum, tempus erat a, rutrum ante. Quisque interdum efficitur nunc vitae consectetur. Suspendisse venenatis, tortor non convallis interdum, urna mi molestie eros, vel tempor justo lacus ac justo. Fusce id enim a erat fringilla sollicitudin ultrices vel metus.</p>

                    <hr>
                    <h4 style="color:#4169E1">Nutri-Score:<%out.print( p.getNutriScore());%></h4>
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <img STYLE="height: 30px;width: 80px" src="images/Nutri/<%out.print( p.getNutriScore());%>.PNG" alt="">
                    </div>

                    <div class="bg-gray py-2 px-3 mt-4">
                        <h2 class="mb-0">
                            Le prix de produit
                        </h2>
                        <h4 class="mt-0">
                            <%if (listPromo.contains(p)){

                              %>
                            <span style="text-decoration-line: line-through;color: #1d455b"><%out.print(p.getPrixVente());%> € </span>
                            <span ><% out.print(df.format(p.getPrixVente()*0.8));%> € </span>

                            <%
                            }else{
                            %>
                            <small><%out.print(p.getPrix());%>  € </small>
                            <%
                            }//fin else
                            %>
                        </h4>
                    </div>

                    <div class="mt-4">
                        <div class="btn btn-primary btn-lg btn-flat">
                            <a id="btnaddpanier" email="<%out.print(email); %>" idP="<%out.print(p.getCodeProduit()); %>">
                                <i class="fas fa-cart-plus fa-lg mr-2"></i>
                                Ajouter au panier
                            </a>
                        </div>

                        <div class="btn btn-default btn-lg btn-flat">
                            <a id="btnaddpre" email="<%out.print(email); %>" idP="<%out.print(p.getCodeProduit()); %>">
                            <i class="fas fa-heart fa-lg mr-2"></i>
                            Préférer
                        </a></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.card-body -->
    </div>
</section>
    <!-- /.card -->
</body>

</html>