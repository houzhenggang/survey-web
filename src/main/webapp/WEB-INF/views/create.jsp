<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Creating New Survey">
    <form class="card custom-form survey-form" action="<c:url value="/secure/survey/create"/>" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <%-- Survey Title --%>
        <div class="form-group">
            <label for="description">Survey Title</label>
            <input type="text" class="form-control" id="title" placeholder="Untitled Survey" name="title"/>
        </div>

            <%-- Survey Description --%>
        <div class="form-group">
            <label for="description">Survey Description</label>
            <input type="text" class="form-control" id="description" placeholder="Description" name="description"/>
        </div>

            <%-- Questions --%>
        <div class="questions">
        </div>
        <hr/>

            <%-- Add Question --%>
        <button type="button" class="btn btn-secondary add-question-btn" data-next="0">Add New Question</button>
        <hr/>

            <%-- Save Survey --%>
        <input type="submit" class="btn btn-default" value="Save"/>
    </form>

    <script type="text/javascript">
        $(".survey-form").find(".add-choice-btn").on('click', appendChoice);

        function appendChoice() {

            let next = $(this).data("next");
            let question = $(this).closest(".question").data("qindex");
            let choices = $(this).closest(".question").find(".choices");
            let id = 'choice' + next;

            /**/
            let label = document.createElement('label');
            label.setAttribute('for', id);
            label.innerText = 'Choice ' + next;


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
            button.innerText = "Add Choice to Question " + (next+1);
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


