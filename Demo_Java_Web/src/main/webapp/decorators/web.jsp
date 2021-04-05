<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" >
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><decorator:title default="NVL Store"/></title>

    <link href="<c:url value='/Assets/web/css/bootstrap.min.css' />" rel="stylesheet" />
    <link href="<c:url value='/Assets/web/css/font-awesome.min.css' />" rel="stylesheet" />
    <link href="<c:url value='/Assets/web/css/owl.carousel.css' />" rel="stylesheet" />
    <link href="<c:url value='/Assets/web/css/style.css' />" rel="stylesheet" />
    <script src="<c:url value='/Assets/web/css/responsive.css'/> " ></script>
</head>
<body>

<%@include file="/common/web/header.jsp"%>
<div>
    <decorator:body />
</div>
<%@include file="/common/web/footer.jsp"%>

    <script src="<c:url value='/Assets/common/jquery-3.5.1.min.js'/> " ></script>
    <script src="<c:url value='/Assets/common/bootstrap.min.js'/> " ></script>
    <script src="<c:url value='/Assets/web/js/owl.carousel.min.js' />"></script>
    <script src="<c:url value='/Assets/web/js/jquery.sticky.js' />"></script>
    <script src="<c:url value='/Assets/web/js/jquery.easing.1.3.min.js' />"></script>
    <script src="<c:url value='/Assets/web/js/web.js' />"></script>
    <script src="<c:url value='/Assets/web/js/bxslider.min.js' />"></script>
    <script src="<c:url value='/Assets/web/js/script.slider.js' />"></script>
</body>
</html>
