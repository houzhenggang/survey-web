<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Editing ${each.getTitle()}">

    <!-- survey -->
    <form class="card custom-form survey-form" action="<c:url value="/secure/survey/save"/>" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="hidden" name="surveyId" value="${survey.getSurveyId()}">
        <div class="form-group">
            <label for="description">Survey Title</label>
            <input type="text" class="form-control" id="title" placeholder="Untitled Survey" name="title"
                   value="${survey.getTitle()}">
        </div>
        <div class="form-group">
            <label for="description">Survey Description</label>
            <input type="text" class="form-control" id="description" placeholder="Description" name="description"
                   value="${survey.getDescription()}">
        </div>
        <!--   question -->
        <c:set var="qc" value="0"/>

        <div class="questions">
            <c:forEach var="question" items="${survey.getQuestions()}">
                <div class="form-group card question" data-qindex="${qc}">
                    <label for="questions[${qc}].title">Question ${qc+1}</label>
                    <div class="form-group">
                        <input type="hidden" name="questions[${qc}].id" value="${question.getId()}">
                        <input type="text" class="form-control" name="questions[${qc}].title"
                               id="questions[${qc}].title"
                               placeholder="Title of the Survey"
                               value="${question.getTitle()}">
                    </div>

                    <!-- choice -->
                    <div class="choices">
                        <c:set var="ac" value="0"/>
                        <c:forEach var="answer" items="${question.getChoices()}">
                            <input type="hidden" value="${answer.getId()}" name="questions[${qc}].choices[${ac}].id">
                            <label for="answer${ac}">Choice ${ac+1}</label>
                            <div class="col-lg-12 form-group form-check-inline">
                                <i class="far fa-circle fake-radio"></i>
                                <input type="text" class="form-control" name="questions[${qc}].choices[${ac}].content"
                                       id="answer${ac}"
                                       value="${answer.getContent()}">
                            </div>
                            <c:set var="ac" value="${ac + 1}"/>
                        </c:forEach>
                    </div>
                    <button type="button" class="btn btn-primary btn-block add-choice-btn" data-next="${ac}">
                        Add Choice to Question ${qc + 1}
                    </button>

                </div>
                <c:set var="qc" value="${qc + 1}"/>
            </c:forEach>
        </div>
        <button type="button" class="btn btn-secondary add-question-btn" data-next="${qc}">Add New Question</button>
        <hr>
        <button type="submit" class="btn btn-default">Save</button>
    </form>

    <script type="text/javascript">
        $(".survey-form").find(".add-choice-btn").on('click', appendChoice);

        function appendChoice() {

            let next = $(this).data("next");
            let question = $(this).closest(".question").data("qindex");
            let choices = $(this).closest(".question").find(".choices");
            let id = 'answer' + next;

            /**/
            let label = document.createElement('label');
            label.setAttribute('for', id);
            label.innerText = 'Choice ' + (next + 1);


            /**/
            let i = document.createElement('i');
            i.setAttribute('class', 'far fa-circle fake-radio');

            // .........
            let input = document.createElement('input');
            input.setAttribute('type', 'text');
            input.setAttribute('class', 'form-control');
            input.setAttribute('name', 'questions[' + question + '].choices[' + next + '].content');
            input.setAttribute('id', id);

            // .........
            let div = document.createElement('div');
            div.setAttribute('class', 'col-lg-12 form-group form-check-inline');
            div.appendChild(i);
            div.appendChild(input);

            /**/
            choices.append(label);
            choices.append(div);

            $(this).data("next", next + 1);
        }

        $(".survey-form").find(".add-question-btn").on('click', function () {

            let questions = $(this).parent().find(".questions");
            let next = $(this).data("next");
            let id = "question" + next;

            // .........
            let label = document.createElement("label");
            label.setAttribute('for', id);
            label.innerText = 'Question ' + (next + 1);

            // .........
            let input = document.createElement('input');
            input.setAttribute('type', 'text');
            input.setAttribute('class', 'form-control');
            input.setAttribute('name', 'questions[' + next + '].title');
            input.setAttribute('id', id);

            let formGroup = document.createElement("div");
            formGroup.setAttribute("class", "form-group");
            formGroup.appendChild(input);

            // .........
            let choices = document.createElement("div");
            choices.setAttribute("class", "choices");


            // .........
            let button = document.createElement("button");
            button.setAttribute("type", "button");
            button.setAttribute("class", "btn btn-primary add-choice-btn");
            button.setAttribute("data-next", 0);
            button.innerText = "Add Choice to Question " + (next + 1);
            button.onclick = appendChoice;

            // .........
            let questionDiv = document.createElement("div");
            questionDiv.setAttribute("class", "form-group card question");
            questionDiv.setAttribute("data-qindex", next);

            questionDiv.appendChild(label);
            questionDiv.appendChild(formGroup);
            questionDiv.appendChild(choices);
            questionDiv.appendChild(button);

            /**/
            questions.append(questionDiv);
            $(this).data("next", next + 1);
        });


    </script>


</t:layout>


