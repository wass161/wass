
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="group" class="app.logic.ManagementSystem" />
<html>
<body>
<h2>You Cost Control</h2>
<c:set var="groups" value="${group.groups}" />

</body>
</html>
