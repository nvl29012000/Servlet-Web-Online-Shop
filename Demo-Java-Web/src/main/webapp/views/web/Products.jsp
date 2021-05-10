<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<div id="overlay2">
    <div class="cv-spinner">
        <span class="spinner"></span>
    </div>
</div>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <c:if test="${empty catename}">
                        <h2>Shop</h2>
                    </c:if>
                    <c:if test="${not empty catename}">
                        <h2>${catename.getName()}</h2>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <c:forEach var="item" items="${category}">
                    <li>
                        <a href="<c:url value='/san-pham?category=${item.getTitle()}&icate=${item.getID()}' />"><h4>${item.getName()}</h4></a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <hr/>
        <div class="row">
            <c:forEach var="item" items="${products}">
                <div class="col-md-3 col-lg-3 col-xl-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <img src="${item.getImage()}" alt="" />
                        </div>
                        <h2><a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/> ">${item.getName()}</a></h2>
                        <div class="product-carousel-price">
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

                        <div class="product-option-shop">
                            <a class="add_to_cart_button" id="${item.getID()}" rel="nofollow" href="#">Add to cart</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="product-pagination text-center">
                    <nav>
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
