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
    <title>EditPLan</title>

</head>
<body>

<form:form method="post"  modelAttribute="plan"  class="form-horizontal">
    <fieldset>


        <legend>Dodaj  Plan</legend>


        <div class="form-group">
            <label class="col-md-4 control-label" for="date">Planowana Data</label>
            <div class="col-md-5">
                <form:input value = "${plan.getDate()}"  path="date" id="date" type="date"  class="form-control input-md"/>
                <form:errors path="date"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="day">Wybierz dzień</label>
            <div class="col-md-5">
                <form:select id="day" path="day" class="form-control" items = "${days}" itemLabel="name" itemValue="id" />
                <form:errors  path="day"/>

            </div>
        </div>


        <div class="form-group">
            <label class="col-md-4 control-label" for="meals">Wybierz Posiłek</label>
            <div class="col-md-5">
                <form:select type="checkbox"   id="meals" path="meals" class="form-control" multiple="true" items = "${meals}" itemLabel="name" itemValue="id" />
                <form:errors  path="meals"/>

            </div>
        </div>



        <div>
            <input type="submit" name="Edytuj">
        </div>
    </fieldset>
</form:form>

<%@ include file="jspf/footer.jsp" %>

</body>
</html>
