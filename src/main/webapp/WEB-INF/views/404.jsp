<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Error">

    <jsp:attribute name="navbar">
        <jsp:include page="../components/navbar.jsp" />
    </jsp:attribute>

    <jsp:body>
        <t:section>
            <jsp:attribute name="title">
                <h1 class="display-4">İstenilen Sayfa Bulunamadıki</h1>
            </jsp:attribute>

            <jsp:body>
                <div class="container">
                    <hr/>
                    <p class="lead">
                        <a href="${pageContext.request.contextPath}/"> linke </a>
                        tıklayarak anasayfaya yönlenebilirsiniz.
                    </p>
                </div>
            </jsp:body>
        </t:section>
    </jsp:body>
</t:layout>
