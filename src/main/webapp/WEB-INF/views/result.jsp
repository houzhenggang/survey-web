<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:layout title="Resulting Survey ${surveyModel.getSurvey().getTitle()}">

    <div class="alert alert-success">
        Thank you for participating in our survey. Your answers have been saved to our system.
    </div>
    <hr>
    <h3>${surveyModel.getSurvey().getTitle()}</h3>
    <p>${surveyModel.getSurvey().getDescription()}</p>
    <c:set value="0" var="counter"/>
    <c:forEach var="questionModel" items="${surveyModel.getQuestionModelList()}">
        <div class="form-group card">
            <div class="card-header">
                    ${questionModel.getQuestion().getTitle()}
            </div>
            <div class="card-body">
                <c:if test="${questionModel.getQuestion().single()}">
                    <input type="text"
                           placeholder="${questionModel.getQuestion().getHint()}" class="p-2" style="width: 100%"
                           disabled value="${questionModel.getComment()}"/>
                </c:if>
                <c:if test="${!questionModel.getQuestion().single()}">
                    <c:forEach var="answer" items="${questionModel.getAnswerList()}">
                        <div class="custom-control custom-radio">
                            <input type="radio" id="${answer.getChoice().getId()}"
                                   name="results[${counter}].choiceId"
                                   value="${answer.getChoice().getId()}"
                            <c:if test="${answer.isSelected()}">
                                   checked
                            </c:if>
                                   disabled
                                   class="custom-control-input">
                            <label class="custom-control-label" for="${answer.getChoice().getId()}">
                                ${answer.getChoice().getContent()}
                            </label>
                            <div class="progress mt-2 mb-4">
                                <div class="progress-bar" style="width:${answer.getPercentageAsInt()}%; background:#97c513;">
                                    <div class="progress-value">${answer.getPercentageAsInt()}%</div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <c:set var="counter" value="${counter +1}"/>
    </c:forEach>
</t:layout>



