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
</head>
<body>

<div>
<p> Filtrowanie wyników</p>
    <form method="post">

        <div class="form-group">

            <div class="col-md-5">
                <input type = "date"  class="form-control" name = "date1" id = "date1"/>
                <input type = "date"  class="form-control" name = "date2" id = "date2"/>
            </div>

        </div>

        <div>
            <input type="submit" name="Wybierz">
        </div>
    </form>
</div>

<%@ include file="jspf/footer.jsp" %>
</body>
</html>
