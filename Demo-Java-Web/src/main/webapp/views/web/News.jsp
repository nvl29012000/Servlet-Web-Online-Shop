<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tin tức</title>
</head>
<body>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Tin tức</h2>
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
                <c:forEach var="item" items="${newcategory}">
                    <li>
                        <a href="<c:url value='/tin-tuc?category=${item.getTitle()}&icate=${item.getID()}' />">
                            <h4>${item.getName()}</h4></a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <hr/>
        <div class="row">
            <div class="col-lg-8 col-md-8 col-sm-12">
                <c:forEach var="item" items="${news}">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <a href="<c:url value='/chi-tiet-san-pham?name=${item.getTitle()}&inew=${item.getID()}' />">
                                <img src="${item.getImage()}" alt="" style="width: 100%"/>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <a href="<c:url value='/chi-tiet-tin-tuc?name=${item.getTitle()}&inew=${item.getID()}' />">
                                <h3 class="text-left">${item.getName()}</h3>
                            </a>
                            <a href="<c:url value='/chi-tiet-tin-tuc?name=${item.getTitle()}&inew=${item.getID()}' />">
                                <p>
                                        ${item.getDescription()}
                                </p>
                            </a>
                        </div>
                    </div>
                    <hr/>
                </c:forEach>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-12">
                <c:forEach var="item" items="${lastnew}">
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <a href="<c:url value='/chi-tiet-san-pham?name=${item.getTitle()}&inew=${item.getID()}' />">
                                <img src="${item.getImage()}" alt="" style="width: 100%"/>
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12">
                            <a href="<c:url value='/chi-tiet-san-pham?name=${item.getTitle()}&inew=${item.getID()}' />">
                                <h4 class="text-left">${item.getName()}</h4>
                            </a>
                                <%--                        <a href="<c:url value='/chi-tiet-san-pham?name=${item.getTitle()}&inew=${item.getID()}' />">--%>
                                <%--                            <p>--%>
                                <%--                                    ${item.getDescription()}--%>
                                <%--                            </p>--%>
                                <%--                        </a>--%>
                        </div>
                    </div>
                    <hr/>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
