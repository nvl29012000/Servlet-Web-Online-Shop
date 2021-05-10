<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${model.getName()}</title>
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
                    <h2>Shop</h2>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="single-sidebar">
                    <h2 class="sidebar-title">Search Products</h2>
                    <form action="">
                        <input type="text" placeholder="Search products...">
                        <input type="submit" value="Search">
                    </form>
                </div>

                <div class="single-sidebar">
                    <h2 class="sidebar-title">Lastest Products</h2>
                    <c:forEach var="item" items="${last}">
                        <div class="thubmnail-recent">
                            <img src="${item.getImage()}" class="recent-thumb" alt="">
                            <h2><a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>">${item.getName()}</a></h2>
                            <div class="product-sidebar-price">
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

<%--                <div class="single-sidebar">--%>
<%--                    <h2 class="sidebar-title">Recent Posts</h2>--%>
<%--                    <ul>--%>
<%--                        <li><a href="">Sony Smart TV - 2015</a></li>--%>
<%--                        <li><a href="">Sony Smart TV - 2015</a></li>--%>
<%--                        <li><a href="">Sony Smart TV - 2015</a></li>--%>
<%--                        <li><a href="">Sony Smart TV - 2015</a></li>--%>
<%--                        <li><a href="">Sony Smart TV - 2015</a></li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
            </div>

            <div class="col-md-8">
                <div class="product-content-right">
                    <div class="product-breadcroumb">
                        <a href="<c:url value='/chi-tiet-san-pham?pname=${singleproduct.getTitle()}&pid=${singleproduct.getID()}'/>">${singleproduct.getName()}</a>
                    </div>

                    <div class="row">
                        <div class="col-sm-6">
                            <div class="product-images">
                                <div class="product-main-img">
                                    <img src="${singleproduct.getImage()}" alt="">
                                </div>

<%--                                <div class="product-gallery">--%>
<%--                                    <img src="img/product-thumb-1.jpg" alt="">--%>
<%--                                    <img src="img/product-thumb-2.jpg" alt="">--%>
<%--                                    <img src="img/product-thumb-3.jpg" alt="">--%>
<%--                                </div>--%>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="product-inner">
                                <h2 class="product-name">${singleproduct.getName()}</h2>
                                <div class="product-inner-price">
                                    <c:if test="${not empty singleproduct.getSaleDate()}">
                                        <c:if test="${singleproduct.getSaleDate() > currentsales}">
                                            <ins>${singleproduct.getSalePrice()} VNĐ</ins>
                                            <del>${singleproduct.getPrice()} VNĐ</del>
                                        </c:if>
                                        <c:if test="${singleproduct.getSaleDate() < currentsales}">
                                            <ins>${singleproduct.getPrice()} VNĐ</ins>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${empty singleproduct.getSaleDate()}">
                                        <ins>${singleproduct.getPrice()} VNĐ</ins>
                                    </c:if>
                                </div>

                                <form action="" class="cart">
                                    <div class="quantity">
                                        <input type="number" size="4" class="input-text qty text" id="product-quantity" title="Qty" value="1" name="quantity" min="1" step="1">
                                    </div>
                                    <button class="add_to_cart_button" id="${singleproduct.getID()}" type="button">Add to cart</button>
                                </form>

                                <div class="product-inner-category">
                                    <p>Code <a href="">${singleproduct.getProductCode()}</a>. Keyword: <a href="">${singleproduct.getMetaKeyword()}</a>. </p>
                                </div>

                                <div role="tabpanel">
                                    <ul class="product-tab" role="tablist">
                                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
                                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane fade in active" id="home">
                                            <h2>${singleproduct.getDescription()}</h2>
                                            <p>${singleproduct.getProductDetail()}</p>
                                        </div>
                                        <div role="tabpanel" class="tab-pane fade" id="profile">
                                            <h2>Reviews</h2>
                                            <div class="submit-review">
                                                <p><label for="name">Name</label> <input name="name" id="name" type="text"></p>
                                                <p><label for="email">Email</label> <input name="email" id="email" type="email"></p>
<%--                                                <div class="rating-chooser">--%>
<%--                                                    <p>Your rating</p>--%>

<%--                                                    <div class="rating-wrap-post">--%>
<%--                                                        <i class="fa fa-star"></i>--%>
<%--                                                        <i class="fa fa-star"></i>--%>
<%--                                                        <i class="fa fa-star"></i>--%>
<%--                                                        <i class="fa fa-star"></i>--%>
<%--                                                        <i class="fa fa-star"></i>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
                                                <p><label for="review">Your review</label> <textarea name="review" id="review" cols="30" rows="10"></textarea></p>
                                                <p><input type="submit" value="Submit"></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>


                    <div class="related-products-wrapper">
                        <h2 class="related-products-title">Related Products</h2>
                        <div class="related-products-carousel">
                            <c:forEach var="item" items="${related}">
                                <div class="single-product">
                                    <div class="product-f-image">
                                        <img src="${item.getImage()}" alt="">
                                        <div class="product-hover">
                                            <a href="" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                            <a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                        </div>
                                    </div>

                                    <h2><a href="<c:url value='/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}'/>">${item.getName()}</a></h2>

                                    <div class="product-carousel-price">
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
        </div>
    </div>
</div>
</body>
</html>
