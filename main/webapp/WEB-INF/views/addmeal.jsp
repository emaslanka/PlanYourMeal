<%--
  Created by IntelliJ IDEA.
  User: eve
  Date: 24.05.2021
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>AddMeal</title>

</head>
<body>

<form:form method="post" modelAttribute="meal" class="form-horizontal">
    <fieldset>


        <legend>Dodaj  posiłek</legend>


        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Nazwa</label>
            <div class="col-md-5">
                <form:input path="name" id="name" placeholder="np.jajecznica" class="form-control input-md"/>
                <form:errors path="name"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="category">Wybierz kategorię</label>
            <div class="col-md-5">
                <form:select id="category" path="category" class="form-control" items = "${categories}" itemLabel="name" itemValue="id" />
                <form:errors  path="category"/>

            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="ingredients">Składniki</label>
            <div class="col-md-5">
                <form:input path="ingredients" id="ingredients" placeholder="np.jajko,masło, chlebek" class="form-control input-md"/>
                <form:errors path="ingredients"/>

            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="timeOfPrep">Czas przygotowania [min]</label>

            <div class="col-md-5">
                <form:input id="timeOfPrep" path="timeOfPrep" type="number" min="1" max="1000"/>
                <form:errors  path="timeOfPrep"/>
            </div>

        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="linkToRecipe">Podaj link (opcjonalnie)</label>
            <div class="col-md-5">
                <form:input path="linkToRecipe" id="linkToRecipe" placeholder="np.www.kwestiasmaku..." class="form-control input-md"/>
                <form:errors path="linkToRecipe"/>

            </div>
        </div>

        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Dodaj</button>
        </div>
    </fieldset>
</form:form>

<%@ include file="jspf/footer.jsp" %>
</body>
</html>
