<%--
  Created by IntelliJ IDEA.
  User: vbrovkin
  Date: 11.03.15
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Items</title>
    <link href="<c:url value="/css/items.css" />" rel="stylesheet"/>
</head>
<body>
    <h1>Items</h1>
    <a href="/CC">Список групп</a>
    <p><c:out value="${nameGroup}"/></p>
    <form action="<c:url value="/items"/>" method="POST" accept-charset="UTF-8">
        <table border="1" cellpadding="5">
            <c:set var="summary_cash" scope="session" value="0"/>
            <c:forEach var="var" items="${itemCosts}">
                <c:set var="summary_cash" scope="session" value="${summary_cash + var.cash}"/>
                <tr>
                    <td>
                        <c:out value="${var.name}"/>
                    </td>
                    <td>
                        <c:out value="${var.cash}"/>
                    </td>
                    <td>
                        <input type="checkbox" name="delId" value="${var.id}">
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                    ИТОГО:
                </td>
                <td>
                    <c:out value="${summary_cash}"/>
                </td>
            </tr>
        </table>
        <p><button type="submit">Удалить отмеченные</button></p>
    </form>
    Введите название нового пункта покупки:
    <form action="<c:url value="/items"/>" method="POST" accept-charset="UTF-8">
        <p>Наименование:<input type="text" name="newItemName"></p>
        <p>Стоимость:<input type="text" name="newItemCash"></p>
        <p><button type="submit">Добавить</button></p>
    </form>
</body>
</html>