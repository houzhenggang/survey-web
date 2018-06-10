<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Surveys">

    <c:forEach var="each" items="${surveyList}">

        <div class="card my-4">
            <div class="card-header">
                <h4 class="card-title">
                        ${each.getTitle()}
                </h4>
                <h6 class="card-subtitle mb-2 text-muted">
                        ${each.getDescription()}
                </h6>
            </div>

            <ul class="list-group list-group-flush">
                <sec:authorize access="isAuthenticated()">
                    <li class="list-group-item">
                        <a href="<c:url value="/secure/survey/${each.getSurveyId()}/edit"/>">
                            Edit
                        </a>
                    </li>
                </sec:authorize>
                <li class="list-group-item">
                    <a href="<c:url value="/survey/${each.getSurveyId()}/take"/>">
                        Apply
                    </a>
                </li>
            </ul>
        </div>

    </c:forEach>
</t:layout>



