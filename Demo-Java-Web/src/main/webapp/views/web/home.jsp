<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>NVL Store</title>
</head>
<body>
<div id="overlay2">
    <div class="cv-spinner">
        <span class="spinner"></span>
    </div>
</div>
<div class="slider-area">
    <!-- Slider -->
    <div class="block-slider block-slider4">
        <ul class="" id="bxslider-home4">
            <c:forEach var="item" items="${slide}">
                <li style="float: left; list-style: none; position: relative; width: 1068px;">
                    <img src="${item.getImage()}" alt="Slide">
                    <div class="caption-group">
                        <h2 class="caption title">
                            <span class="primary"><strong>${item.getDescription()}</strong></span>
                        </h2>
                            <%--                        <h4 class="caption subtitle">Dual SIM</h4>--%>
                        <a class="caption button-radius" href="#"><span class="icon"></span>Shop now</a>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <!-- ./Slider -->
</div> <!-- End slider area -->

<div class="promo-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo1">
                    <i class="fa fa-refresh"></i>
                    <p>30 Days return</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo2">
                    <i class="fa fa-truck"></i>
                    <p>Free shipping</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo3">
                    <i class="fa fa-lock"></i>
                    <p>Secure payments</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="single-promo promo4">
                    <i class="fa fa-gift"></i>
                    <p>New products</p>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End promo area -->

<div class="maincontent-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="latest-product">
                    <h2 class="section-title">Latest Products</h2>
                    <div class="product-carousel">
                        <c:forEach var="item" items="${last}">
                            <div class="single-product">
                                <div class="product-f-image">
                                    <img src="${item.getImage()}" alt="">
                                    <div class="product-hover">
                                        <a href="#" class="add-to-cart-link" id="${item.getID()}"><i class="fa fa-shopping-cart"></i> Add to
                                            cart</a>
                                        <a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                    </div>
                                </div>

                                <h2><a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>">${item.getName()}</a></h2>

                                <div class="product-carousel-price">
                                    <jsp:useBean id="current" class="java.util.Date" />
                                    <c:if test="${not empty item.getSaleDate()}">
                                        <c:if test="${item.getSaleDate() > current}">
                                            <ins>${item.getSalePrice()} VNĐ</ins>
                                            <del>${item.getPrice()} VNĐ</del>
                                        </c:if>
                                        <c:if test="${item.getSaleDate() < current}">
                                            <ins>${item.getPrice()} VNĐ</ins>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${empty item.getSaleDate()}">
                                        <ins>${item.getPrice()} VNĐ</ins>
                                    </c:if>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End main content area -->

<div class="brands-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="brand-wrapper">
                    <div class="brand-list">
                        <c:forEach var="item" items="${category}">
                            <a href="<c:url value='/san-pham?category=${item.getTitle()}&icate=${item.getID()}' />">
                                <img src="${item.getImage()}" alt="">
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End brands area -->

<div class="product-widget-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="single-product-widget">
                    <h2 class="product-wid-title">Top Sales</h2>
                    <a href="" class="wid-view-more">View All</a>
                    <c:forEach var="item" items="${sales}">
                        <div class="single-wid-product">
                            <a href=""><img src="${item.getImage()}" alt=""
                                            class="product-thumb"></a>
                            <h2><a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>">${item.getName()}</a></h2>
                            <div class="product-wid-price">
                                <jsp:useBean id="currentsales" class="java.util.Date" />
                                <c:if test="${not empty item.getSaleDate()}">
                                    <c:if test="${item.getSaleDate() > currentsales}">
                                        <ins>${item.getSalePrice()} VNĐ</ins>
                                        <del>${item.getPrice()} VNĐ</del>
                                    </c:if>
                                    <c:if test="${item.getSaleDate() < currentsales}">
                                        <ins>${item.getPrice()} VNĐ</ins>
                                    </c:if>
                                </c:if>
                                <c:if test="${empty item.getSaleDate()}">
                                    <ins>${item.getPrice()} VNĐ</ins>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-4">
                <div class="single-product-widget">
                    <h2 class="product-wid-title">Most Viewed</h2>
                    <a href="#" class="wid-view-more">View All</a>
                    <c:forEach var="item" items="${views}">
                        <div class="single-wid-product">
                            <a href=""><img src="${item.getImage()}" alt=""
                                                               class="product-thumb"></a>
                            <h2><a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>">${item.getName()}</a></h2>
                            <div class="product-wid-price">
                                <jsp:useBean id="currentviews" class="java.util.Date" />
                                <c:if test="${not empty item.getSaleDate()}">
                                    <c:if test="${item.getSaleDate() > currentviews}">
                                        <ins>${item.getSalePrice()} VNĐ</ins>
                                        <del>${item.getPrice()} VNĐ</del>
                                    </c:if>
                                    <c:if test="${item.getSaleDate() < currentviews}">
                                        <ins>${item.getPrice()} VNĐ</ins>
                                    </c:if>
                                </c:if>
                                <c:if test="${empty item.getSaleDate()}">
                                    <ins>${item.getPrice()} VNĐ</ins>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="col-md-4">
                <div class="single-product-widget">
                    <h2 class="product-wid-title">Top New</h2>
                    <a href="#" class="wid-view-more">View All</a>
                    <c:forEach var="item" items="${news}">
                        <div class="single-wid-product">
                            <a href=""><img src="${item.getImage()}" alt=""
                                            class="product-thumb"></a>
                            <h2><a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>">${item.getName()}</a></h2>
                            <div class="product-wid-price">
                                <jsp:useBean id="currentnews" class="java.util.Date" />
                                <c:if test="${not empty item.getSaleDate()}">
                                    <c:if test="${item.getSaleDate() > currentnews}">
                                        <ins>${item.getSalePrice()} VNĐ</ins>
                                        <del>${item.getPrice()} VNĐ</del>
                                    </c:if>
                                    <c:if test="${item.getSaleDate() < currentnews}">
                                        <ins>${item.getPrice()} VNĐ</ins>
                                    </c:if>
                                </c:if>
                                <c:if test="${empty item.getSaleDate()}">
                                    <ins>${item.getPrice()} VNĐ</ins>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End product widget area -->
</body>
</html>
