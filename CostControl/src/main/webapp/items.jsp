<%--
  Created by IntelliJ IDEA.
  User: vbrovkin
  Date: 11.03.15
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
    <h2>Items</h2>
    <table>
        <c:forEach var="var" items="${itemCosts}">
            <tr>
                <td>
                    <c:out value="${var.id}"/>
                </td>
                <td>
                    <c:out value="${var.name}"/>
                </td>
                <td>
                    <c:out value="${var.cash}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    Введите название нового пункта покупки:
    <form action="<c:url value="/CC"/>" method="POST" accept-charset="UTF-8">
        <p><input type="text" name="newItemName"></p>
        <p><input type="text" name="newItemCash"></p>
        <p><button type="submit">Добавить</button></p>
    </form>
</body>
</html>