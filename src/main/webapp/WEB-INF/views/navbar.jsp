<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<?xml version="1.0" encoding="UTF-8"?>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="container">
        <a class="navbar-brand" href="<c:url value="/"/>">${appname}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/home"/>">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/surveys"/>">
                        Surveys
                    </a>
                </li>
            </ul>
            <sec:authorize access="isAuthenticated()">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:void(0)" style="cursor: default">
                            Welcome <sec:authentication property="principal.username"/>
                        </a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0" action="<c:url value="/logout" />">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
                </form>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <form class="form-inline my-2 my-lg-0" action="<c:url value="/login"/>">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
                </form>
            </sec:authorize>
        </div>

    </div>
</nav>
