<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Đăng nhập</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--    <link rel="icon" type="image/png" href="<c:url value="/Assets/admin/image/icons/favicon.ico"/> " />--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/Assets/admin/css/bootstrap.min.css" /> " />--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/Assets/admin/css/font-awesome.min.css" /> " />--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/Assets/admin/css/icon-font.min.css" />" />--%>
<%--    <!--=================================================================================-->--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/Assets/admin/css/util.css" />" />--%>
<%--    <link rel="stylesheet" type="text/css" href="<c:url value="/Assets/admin/css/main.css" />" />--%>
</head>
<body>
<div class="limiter">
    <div id="overlay">
        <div class="cv-spinner">
            <span class="spinner"></span>
        </div>
    </div>
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-form-title">
                <img src="<c:url value="/Assets/login/image/bg-01.jpg"/> "  alt=""/>
					<span class="login100-form-title-1">
						Sign In
					</span>
            </div>
            <p id="message" class="text-danger text-center"></p>
            <div class="login100-form validate-form">
                <div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
                    <span class="label-input100">Username</span>
                    <label>
                        <input class="input100" type="text" name="username" id="username" placeholder="Enter username">
                    </label>
                    <span class="focus-input100"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
                    <span class="label-input100">Password</span>
                    <label>
                        <input class="input100" type="password" name="pass" id="password" placeholder="Enter password">
                    </label>
                    <span class="focus-input100"></span>
                </div>

<%--                <div class="flex-sb-m w-full p-b-30">--%>
<%--                    <div class="contact100-form-checkbox">--%>
<%--                        <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">--%>
<%--                        <label class="label-checkbox100" for="ckb1">--%>
<%--                            Remember me--%>
<%--                        </label>--%>
<%--                    </div>--%>

<%--                    <div>--%>
<%--                        <a href="#" class="txt1">--%>
<%--                            Forgot Password?--%>
<%--                        </a>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Login
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<script src="<c:url value="/Assets/common/jquery-3.5.1.min.js" />"></script>--%>
<%--<script src="<c:url value="/Assets/common/bootstrap.min.js"/> "></script>--%>
<%--<script src="<c:url value="/Assets/common/main.js"/> "></script>--%>
</body>
</html>
