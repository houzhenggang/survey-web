<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Login">

    <c:url var="loginUrl" value="/login"/>
    <form action="${loginUrl}" method="post" style="max-width: 500px" class="mt-4 mx-auto">
        <c:if test="${param.error != null}">
            <hr/>
            <div class="alert alert-danger">
                Invalid username and password.
            </div>
            <hr/>
        </c:if>
        <c:if test="${param.logout != null}">
            <hr/>
            <div class="alert alert-success">
                You have been logged out successfully.
            </div>
            <hr/>
        </c:if>

        <div class="form-group">
            <label>User Name</label>
            <input type="text" class="form-control" placeholder="User Name" name="ssoId" tabindex="1">
        </div>
        <div class="form-group">
            <label>Password</label>
            <input type="password" class="form-control" placeholder="Password" name="password" tabindex="2">
        </div>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary float-right">Login</button>
    </form>
</t:layout>


