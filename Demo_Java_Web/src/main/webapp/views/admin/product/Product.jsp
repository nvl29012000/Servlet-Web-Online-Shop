<%@include file="../../../common/taglib.jsp"%>>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sản phẩm</title>
</head>
<body>
<br />
<h2>Sản phẩm</h2>

<p>
    <a href="" class="btn btn-primary">
        Thêm mới
    </a>
</p>
<select class="btn btn-primary" id="base-product">
    <option value="0">Tất cả sản phẩm</option>
    <c:forEach var="cate" items="${category.getListResult()}">
        <option value="${cate.getID().toString()}">${cate.getName()}</option>
    </c:forEach>
</select>
<hr />
<form action="<c:url value='/admin-product'/>" id="submit" method="get">
<table class="table" id="replace-table">
    <thead class="thead-dark">
    <tr>
        <th></th>
        <th>Tên sản phẩm</th>
        <th>Chi tiết</th>
        <th>Sửa</th>
        <th>Xóa</th>
    </tr>
    </thead>
    <c:forEach var="item" items="${product.getListResult()}">
        <tr id="">
            <td>
                <img src="" style="width :150px"  alt=""/>
            </td>
            <td class="font-weight-bold">
                ${item.getName()}
            </td>
            <td class="font-weight-bold">
                Chi tiết
            </td>
            <td class="font-weight-bold">
                Sửa
            </td>
            <td class="font-weight-bold">
                Xóa
            </td>
        </tr>
    </c:forEach>

</table>
    <ul id="luckmoshy"  class="pagination justify-content-center pagination-lg"></ul>
    <input type="hidden" id="page" name="page" />
    <input type="hidden" id="items" name="items" />
</form>
<script>
    let total = Math.ceil(${product.getTotal() / product.getItems()});
    let current = ${product.getPage()};
    let items = ${product.getItems()};
    $('#luckmoshy').luckmoshyPagination({
        totalPages: total,
// the current page that show on start
        startPage: current,
        cssStyle : 'dark-theme',
// maximum visible pages
        visiblePages: 3,

        initiateStartPageClick: true,

// template for pagination links
        href: false,

// variable name in href template for page number
        hrefVariable: '{{number}}',

// Text labels
        first: 'First',
        prev: 'Previous',
        next: 'Next',
        last: 'Last',

// carousel-style pagination
        loop: true,

// callback function
        onPageClick: function (event, page) {
            if(current != page){
                $('#page').val(page);
                $('#items').val(items);
                $('#submit').submit();
            }
            $('.page-active').removeClass('page-active');
            $('#container-pagnation'+page).addClass('page-active');
        },

// pagination Classes
        paginationClass: 'pagination',
        nextClass: 'next',
        prevClass: 'prev',
        lastClass: 'last',
        firstClass: 'first',
        pageClass: 'page-item ',
        activeClass: 'active',
        disabledClass: 'disabled'

    });
</script>
</body>
</html>
