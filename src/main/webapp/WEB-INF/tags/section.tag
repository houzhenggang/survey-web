<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="title" fragment="true" required="false" %>
<%@attribute name="cclass" required="false" %>

<%-- Attributes --%>

<section class="section rounded-bottom my-5 ${cclass}">

    <c:if test="${!empty(title)}">
        <div class="p-3 section-title bg-dark border border-dark">
            <jsp:invoke fragment="title"/>
        </div>
    </c:if>

    <div class="p-5 section-body">
        <jsp:doBody/>
    </div>
</section>


