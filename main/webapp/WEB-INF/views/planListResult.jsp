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
    <title>Plan list</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<div id="plan">
    <table>

        <table border="1">

            <thead>

            <th>Data</th>
            <th>Dzień</th>
            <th>Posiłki</th>
            <th>Akcja</th>

            </thead>

            <tbody>

            <c:forEach items="${plans}" var="plan">

                <tr>

                    <td><c:out value="${plan.date}"/></td>
                    <td><c:out value="${plan.day.name}"/></td>
                    <td><c:out value="${plan.meals.toString()}"/></td>


                    <td><a href="<c:url value="/plan/edit/${plan.id}"/>">Edytuj</a>/
                        <a href="<c:url value="/plan/delete/${plan.id}"/>">Usuń</a></td>

                </tr>

            </c:forEach>

            </tbody>

        </table>

    </table>
</div>
<br>
<div>
    <div align="center">
    <button class="btn" type="button" onclick="window.print()">Drukuj</button>
    </div>

</div>

<br>
<br>

<%@ include file="jspf/footer.jsp" %>

</body>
</html>
