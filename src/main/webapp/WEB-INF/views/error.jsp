<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout title="Error">
    <jsp:attribute name="navbar">
        <jsp:include page="../components/navbar.jsp" />
    </jsp:attribute>

    <jsp:body>


        <t:section>
            <jsp:attribute name="title">
                <i class="fas fa-info-circle"></i> Info
            </jsp:attribute>
            <jsp:body>
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <h1 class="display-4">Beklenmeyen Bir Hata Oluştu</h1>
                        <hr/>
                        <p class="lead">
                            <a href="${pageContext.request.contextPath}/"> linke </a>
                            tıklayarak anasayfaya yönlenebilirsiniz.
                        </p>
                    </div>
                </div>
            </jsp:body>

        </t:section>
    </jsp:body>
</t:layout>
