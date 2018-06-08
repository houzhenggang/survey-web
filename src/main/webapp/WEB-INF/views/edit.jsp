<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Editing ${each.getTitle()}">

    <h3>${survey.getTitle()}</h3>
    <p>${survey.getDescription()}</p>
    <form>
        <c:forEach var="question" items="${survey.getQuestions()}">
            <div class="form-group card">
                <div class="card-header">
                        ${question.getTitle()}
                </div>

                <div class="card-body">
                    <c:if test="${question.single()}">
                        <input type="text" id="${answer.getId()}" name="comment[1]" placeholder="${question.getHint()}" class="p-2" style="width: 100%"/>
                    </c:if>
                    <c:if test="${!question.single()}">
                        <c:forEach var="answer" items="${question.getChoices()}">
                            <div class="custom-control custom-radio">
                                <input type="radio" id="${answer.getId()}" name="choices[1]"
                                       class="custom-control-input">
                                <label class="custom-control-label" for="${answer.getId()}">
                                        ${answer.getContent()}
                                </label>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </c:forEach>
        <button type="submit" class="btn btn-default float-right">Submit</button>
    </form>
</t:layout>



