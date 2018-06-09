<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout title="Creating New Survey">

    <style>
        .custom-form {
            margin: 10px;
            padding: 10px;
            background-color: #fcfcfc !important;
        }

        .question {
            padding: 10px;
        }

        .fake-radio {
            margin-right: 10px;
        }
    </style>


    <script type="text/ecmascript-6">
        // shortid or an alternative can be added for unique id
        $(function () {

            var getQuestionId = (id) => {
                let questionRegExp = /^(q-)([a-zA-Z0-9_-]*)(\|)/;
                return parseInt(questionRegExp.exec(id)[2]);
            }

            var getChoiceId = (id) => {
                let choiceRegExp = /(\|choice-)([a-zA-Z0-9_-]*)/;
                return parseInt(choiceRegExp.exec(id)[2]);
            }

            var generateChoiceId = (id) => {
                return 'q-' + getQuestionId(id) + '|choice-' + (getChoiceId(id) + 1)
            }

            var getNewChoiceElement = (prevId) => {
                var newElementId = generateChoiceId(prevId);
                return '<div class="form-group form-check-inline"> ' +
                    '<i class="far fa-circle fake-radio"></i> ' +
                    '<input type="text" class="form-control" id=' + newElementId + ' > ' +
                    '</div>';
            }

            var getNewQuestionElement = (prevId) => {
                let newElementId = (getQuestionId(prevId) + 1);
                return '<div class="form-group card question"> ' +
                    '<div class="form-group"> ' +
                    '  <input type="text" class="form-control" id="q-' + newElementId + '|title" placeholder="Title of the Survey">  ' +
                    '</div>  ' +
                    '<div class="form-group form-check-inline"> ' +
                    '  <i class="far fa-circle fake-radio"></i> ' +
                    '  <input type="text" class="form-control" id="q-' + newElementId + '|choice-1" > ' +
                    '</div>' +
                    '<button type="button" class="btn btn-primary x">+</button>';
            }

            //delegated-event
            $("body").on("click", "button.x", function (e) {
                    e.preventDefault();
                    var prev = $(e.target).prev();
                    prev.after(getNewChoiceElement(prev.find('input').attr('id')))
                }
            );

            $("#addQuestion").click(() => {
                    var prev = $("#addQuestion").prev();
                    prev.after(getNewQuestionElement(prev.find('input').attr('id')))
                }
            );

        });
    </script>

    <!-- survey -->
    <form class="card custom-form">
        <div class="form-group">
            <input type="text" class="form-control" id="surveyTitle" placeholder="Untitled Survey">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="surveyDescription" placeholder="Description">
        </div>
        <!--   question -->
        <div class="form-group card question">
            <div class="form-group">
                <input type="text" class="form-control" id="questions[0]" placeholder="Title of the Survey">
            </div>
            <!-- choice -->
            <div class="form-group form-check-inline">
                <i class="far fa-circle fake-radio"></i>
                <input type="text" class="form-control" id="q-1|choice-1">
            </div>
            <div class="form-group form-check-inline">
                <i class="far fa-circle fake-radio"></i>
                <input type="text" class="form-control" id="q-1|choice-2">
            </div>
            <button type="button" class="btn btn-primary x">+</button>
        </div>
        <button type="button" id="addQuestion" class="btn btn-secondary">Add New Question</button>
        <hr>1
        <button type="submit" class="btn btn-default">Save</button>
    </form>


</t:layout>


