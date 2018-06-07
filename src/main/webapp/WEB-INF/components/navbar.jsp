<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-lg navbar-light text-center text-lg-left py-0">
    <a class="navbar-brand py-5" href="/">
        <img src="${assets}/img/logo_ico.png" class="img-fluid"/>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">

            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/index.php?page=patterns">
                    Design Pattern <i class="fas fa-object-ungroup"></i>
                </a>
            </li>


            <li class="nav-item ">
                <a class="nav-link" href="${pageContext.request.contextPath}/github">
                    Github <i class="fab fa-github"></i>
                </a>
            </li>


            <li class="nav-item ">
                <a class="nav-link" href="/index.php?page=cv">
                    CV <i class="fas fa-user"></i>
                </a>
            </li>


            <li class="nav-item ">
                <a class="nav-link" href="/index.php?page=linux">
                    Linux <i class="fab fa-linux"></i>
                </a>
            </li>

            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}//">
                    Home <i class="fas fa-home"></i>
                </a>
            </li>
        </ul>
    </div>
</nav>




