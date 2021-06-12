<%--
  Created by IntelliJ IDEA.
  User: eve
  Date: 25.05.2021
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>

<table border="1" style="width:100%">
    <thead>
    <th>Nazwa</th>
    <th>Kategoria</th>

    <th>składniki</th>

    <th>Czas przygotowania</th>
    <th>Link do strony</th>
    <th>Akcja</th>

    </thead>

    <tbody>

    <c:forEach items="${meals}" var="meal">

        <tr>

            <td><c:out value="${meal.name}"/></td>
            <td><c:out value="${meal.category.name}"/></td>

            <td><c:out value="${meal.ingredients}"/></td>

            <td><c:out value="${meal.timeOfPrep}"/></td>

            <td><a href="${meal.linkToRecipe}" target="_blank">${meal.linkToRecipe}</a></td>
            <td><a href="<c:url value="/meal/edit/${meal.id}"/>">Edytuj</a>/
            <a href="<c:url value="/meal/delete/${meal.id}"/>">Usuń</a></td>

        </tr>

    </c:forEach>

    </tbody>

</table>

<%@ include file="jspf/footer.jsp" %>
</body>
</html>
