<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
<h2>Your Cost Control</h2>
<form action="<c:url value="/CC"/>" method="POST" accept-charset="UTF-8">
    <table>
    <c:forEach var="var" items="${groupsList}">
        <tr>
            <td>
                <a href="/items?id=${var.id}&name=${var.name}"><c:out value="${var.name}"/></a><input type="checkbox" name="delId" value="${var.id}">
            </td>
        </tr>
    </c:forEach>
    </table>
    <p><button type="submit">Удалить отмеченные группы</button></p>
</form>
Введите название новой группы:
<form action="<c:url value="/CC"/>" method="POST" accept-charset="UTF-8">
    <p><input type="text" name="newGroup"></p>
    <p><button type="submit">Добавить</button></p>
</form>
</body>
</html>
