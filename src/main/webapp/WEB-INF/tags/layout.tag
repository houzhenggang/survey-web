<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" required="true" %>
<%@attribute name="navbar" fragment="true" required="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>${title}</title>


    <c:set var="assets" value="${pageContext.request.contextPath}/resources" scope="request"/>
    <c:set var="appname" value="Diplom Takip Sistemi" scope="request"/>
    <link rel="stylesheet" href="${assets}/css/index.min.css"/>

</head>


<body>
<script>
    var CONTEXT_PATH = "${pageContext.request.contextPath}";
</script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${assets}/js/jquery.min.js"></script>
<script src="${assets}/js/fontawesome-all.min.js"></script>
<script src="${assets}/js/popper.min.js"></script>
<script src="${assets}/js/bootstrap.min.js"></script>
<script src="${assets}/js/prism.js"></script>

<%-- page navbar --%>

<div class="container">
    <main id="main">
        <jsp:invoke fragment="navbar"/>
        <jsp:doBody/>
    </main>
</div>

</body>

</html>



