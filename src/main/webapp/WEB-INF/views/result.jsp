<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout title="Resulting Survey ${surveyModel.getSurvey().getTitle()}">

    <h3>${surveyModel.getSurvey().getTitle()}</h3>
    <p>${surveyModel.getSurvey().getDescription()}</p>
    <form action="<c:url value="/survey/end"/>" method="post">
        <c:set value="0" var="counter"/>
        <c:forEach var="questionModel" items="${surveyModel.getQuestionModelList()}">
            <div class="form-group card">
                <div class="card-header">
                        ${questionModel.getQuestion().getTitle()}
                </div>
                <div class="card-body">
                    <c:if test="${question.single()}">
                        <input type="text" id="${answer.getId()}" name="results[${counter}].comment"
                               placeholder="${question.getHint()}" class="p-2" style="width: 100%" disabled/>
                    </c:if>
                    <c:if test="${!question.single()}">
                        <c:forEach var="answerModel" items="${questionModel.getAnswerModelList()}">
                            <div class="custom-control custom-radio">
                                <input type="radio" id="${answerModel.getAnswer().getId()}"
                                       name="results[${counter}].answerId"
                                       value="${answerModel.getAnswer().getId()}"
                                <c:if test="${answerModel.isSelected()}">
                                       selected
                                </c:if>
                                       class="custom-control-input">
                                <label class="custom-control-label" for="${answerModel.getAnswer().getId()}">
                                        ${answerModel.getAnswer().getContent()}
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



