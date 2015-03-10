
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Your Cost Control</h2>
<c:forEach var="group" items="${groups.items}">
     <c:out value="${group.name}"/>
</c:forEach>


</body>
</html>
