<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="MainController?action=home">BOOK STORE</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test="${sessionScope.USER.getRoleID() == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="MainController?action=manager">Manager Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="MainController?action=discount">Create Discount</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.USER != null}">
                    <li class="nav-item">
                        <a class="nav-link" >Hello ${sessionScope.USER.getUserName()}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="MainController?action=History">History Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="MainController?action=Logout">Logout</a>
                    </li> 
                </c:if>
            </ul>
            <form action="MainController" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="" name="search" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" name="action" value="Search" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <c:if test="${sessionScope.USER.getRoleID() == 2}">
                <a class="btn btn-success btn-sm ml-3" href="MainController?action=showcart">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">${sessionScope.CART.size()}</span>
                </a>
                </c:if>
            </form>
        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">You will get a lot of thing if you come here</h1>
        <p class="lead text-muted mb-0">Prestige creates a brand with more than 10 years of supplying and importing products from Vietnam</p>
    </div>
</section>
<!--end of menu-->
