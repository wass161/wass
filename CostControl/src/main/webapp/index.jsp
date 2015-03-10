<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h2>Your Cost Control</h2>
<table>
<c:forEach var="var" items="${groupsList}">
    <tr>
        <td>
            <c:out value="${var.id}"/>
        </td>
    <td>
        <c:out value="${var.name}"/>
    </td>
    </tr>
</c:forEach>
</table>

</body>
</html>
