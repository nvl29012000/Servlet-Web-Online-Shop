<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ Admin</title>
</head>
<body>
    <c:forEach var="pc" items="${model.getListResult()}">
        <h1>${pc.getName()}</h1>
    </c:forEach>
</body>
</html>
