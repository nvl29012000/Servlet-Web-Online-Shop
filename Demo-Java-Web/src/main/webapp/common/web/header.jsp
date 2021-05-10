<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">
                    <ul>
                        <c:if test="${not empty USER}">
                            <li><a href="#"><i class="fa fa-user"></i> My Account</a></li>
                            <li><a href="<c:url value='/gio-hang' /> "><i class="fa fa-shopping-cart"></i> My Cart</a></li>
                            <li><a href="<c:url value='/thoat'/> "><i class="fa fa-sign-out"></i>Logout</a></li>
                        </c:if>
                        <c:if test="${empty USER}">
                            <li><a href="#myModal" class="form-btn" data-toggle="modal"><i class="fa fa-sign-in"></i>Login</a>
                            </li>
                            <li><a href="#myModel" class="form-btn" data-toggle="modal"><i
                                    class="fa fa-plus-circle"></i>Sign up</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <%--    Login Form--%>
    <div id="myModal" class="modal fade">
        <div id="overlay">
            <div class="cv-spinner">
                <span class="spinner"></span>
            </div>
        </div>
        <div class="modal-dialog modal-login">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="avatar text-center">
                        <img src="<c:url value='/image/human.png' />" alt="Avatar"/>
                    </div>
                </div>
                <div class="modal-body">
                    <p class="text-danger text-center" id="message"></p>
                    <div class="form-group">
                        <input type="text" class="form-control" name="userName" id="userName" placeholder="Username"
                               required="required"/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password"
                               required="required"/>
                    </div>
                    <div class="form-group">
                        <button id="login-btn" class="btn btn-primary btn-lg btn-block login-btn">Login</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--    End Login Form--%>
    <%--    Register Form --%>
    <div id="myModel" class="modal fade">
        <div id="overlay1">
            <div class="cv-spinner">
                <span class="spinner"></span>
            </div>
        </div>
        <div class="modal-dialog modal-login">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="avatar text-center">
                        <img src="<c:url value='/image/register.png' />" alt="Avatar"/>
                    </div>
                </div>
                <div class="modal-body">
                    <p class="text-danger text-center" id="register-message"></p>
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" id="name" placeholder="Họ và tên"
                               required="required"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="phone" id="phone" placeholder="Số điện thoại"
                               required="required"/>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="userName" id="register-userName"
                               placeholder="Tài khoản" required="required"/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" id="register-password"
                               placeholder="Mật khẩu" required="required"/>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" id="re-password"
                               placeholder="Nhập lại mật khẩu" required="required"/>
                    </div>
                    <div class="form-group">
                        <button id="register-btn" class="btn btn-primary btn-lg btn-block login-btn">Sign up</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--    End Register Form --%>
</div>
<!-- End header area -->
<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="logo">
                    <h1><a href=""><img alt="" src=""></a></h1>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="shopping-item position-static">
                    <a href="<c:url value="/gio-hang"/> ">Giỏ hàng <span class="cart-amunt"></span> <i class="fa fa-shopping-cart"></i> <span
                            class="product-count">${Cart.getProductList().size()}</span></a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End site branding area -->

<div class="mainmenu-area">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="${pageContext.request.requestURI.contains('/trang-chu') ? 'active' : ''}">
                        <a href="<c:url value='/trang-chu' />">Trang chủ</a>
                    </li>
                    <li class="${pageContext.request.requestURI.contains('/san-pham') ? 'active' : ''} ${pageContext.request.requestURI.contains('/chi-tiet-san-pham') ? 'active' : ''}">
                        <a href="<c:url value='/san-pham' />">Sản phẩm</a>
                    </li>
                    <li class="${pageContext.request.requestURI.contains('/tin-tuc') ? 'active' : ''} ">
                        <a href="<c:url value='/tin-tuc' />">Tin tức</a>
                    </li>
                    <li><a href="">Về chúng tôi</a></li>
                    <li><a href="">Liên hệ</a></li>
                    <li class="${pageContext.request.requestURI.contains('/gio-hang') ? 'active' : ''}" >
                        <a href="<c:url value='/gio-hang' />" >Giỏ hàng</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- End mainmenu area -->
