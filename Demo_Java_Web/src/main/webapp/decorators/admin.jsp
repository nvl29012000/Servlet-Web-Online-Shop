<%@include file="../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><decorator:title default="Trang chủ Admin"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="theme-color" content="#ffffff">
    <link rel="icon" type="image/png" href="<c:url value='/Assets/admin/image/icons/favicon.ico' />" />
    <link href="<c:url value='/Assets/admin/css/Layout/all.min.css' />" rel="stylesheet" />
    <link href="<c:url value='/Assets/admin/css/bootstrap.min.css'/> " />
    <link href="<c:url value='/Assets/admin/css/Layout/notyf.min.css' />" rel="stylesheet" />
    <link href="<c:url value='/Assets/admin/css/Layout/volt.css' />" rel="stylesheet" />
    <link href="<c:url value='/Assets/admin/css/Common.css' />" rel="stylesheet" />
    <link href="<c:url value='/Assets/admin/css/jquerysctipttop.css'/> "/>
    <script src="<c:url value='/Assets/common/luckmoshyJqueryPagnation.js'/> "></script>
</head>
<body>
<nav class="navbar navbar-dark navbar-theme-primary px-4 col-12 d-md-none">
    <a class="navbar-brand mr-lg-5" href="#">
        <img class="navbar-brand-dark" src="<c:url value='/Assets/admin/image/icons/map-marker.png'/>" alt="Volt logo" />
        <img class="navbar-brand-light" src="<c:url value='/Assets/admin/image/icons/map-marker.png'/>" alt="Volt logo" />
    </a>
    <div class="d-flex align-items-center">
        <button class="navbar-toggler d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>

<div class="container-fluid bg-soft">
    <div class="row">
        <div class="col-12">
            <%@include file="../common/admin/Dashboard.jsp"%>
            <div class="content">
                <%@include file="../common/admin/TopElements.jsp"%>
                <decorator:body />
            </div>
        </div>
    </div>
</div>

<!-- Core -->
<script src="<c:url value='/Assets/admin/js/jquery-3.5.1.min.js'/>"></script>
<script src="<c:url value='/Assets/common/jquery-3.5.1.min.js'/> " ></script>
<script src="<c:url value='/Assets/admin/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/Assets/admin/js/jquery.unobtrusive-ajax.min.js'/>"></script>
<script src="<c:url value='/Assets/admin/js/jquery-3.5.1.slim.min.js'/> "></script>
<script src="<c:url value='/Assets/admin/js/admin.js' />" ></script>
<%--<script src="/Scripts/ckeditor/ckeditor.js"></script>--%>
<%--<script src="/Scripts/ckfinder/ckfinder.js"></script>--%>
</body>
</html>
