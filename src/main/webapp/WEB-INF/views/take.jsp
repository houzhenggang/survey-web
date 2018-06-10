<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout title="Taking Survey${survey.getTitle()}">

    <h3>${survey.getTitle()}</h3>
    <p>${survey.getDescription()}</p>
    <form action="<c:url value="/survey/end"/>" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="surveyId" value="${survey.getSurveyId()}"/>
        <c:set value="0" var="counter"/>
        <c:forEach var="question" items="${survey.getQuestions()}">
            <div class="form-group card">
                <div class="card-header">
                        ${question.getTitle()}
                </div>
                <input type="hidden" name="results[${counter}].userId" value="1"/>
                <input type="hidden" name="results[${counter}].surveyId" value="${survey.getSurveyId()}"/>
                <input type="hidden" name="results[${counter}].questionId" value="${question.getId()}"/>
                <div class="card-body">
                    <c:if test="${question.single()}">
                        <input type="text" id="${choice.getId()}" name="results[${counter}].comment"
                               placeholder="${question.getHint()}" class="p-2" style="width: 100%"/>
                    </c:if>
                    <c:if test="${!question.single()}">
                        <c:forEach var="choice" items="${question.getChoices()}">
                            <div class="custom-control custom-radio">
                                <input type="radio" id="${choice.getId()}"
                                       name="results[${counter}].choiceId"
                                       value="${choice.getId()}"
                                       class="custom-control-input">
                                <label class="custom-control-label" for="${choice.getId()}">
                                        ${choice.getContent()}
                                </label>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
            <c:set var="counter" value="${counter +1}"/>
        </c:forEach>
        <button type="submit" class="btn btn-default float-right">Submit</button>
    </form>
</t:layout>



