<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tin tức</title>
</head>
<body>
<br />
<h2>Tin tức</h2>

<p>
    <a href="<c:url value='/admin-new?type=add'/>" class="btn btn-primary">
        Thêm mới
    </a>
</p>
<select class="btn btn-primary" id="base-new">
    <option value="0">Tất cả tin tức</option>
    <c:forEach var="item" items="${newcate.getListResult()}">
        <option value="${item.getID()}">${item.getName()}</option>
    </c:forEach>

</select>
<hr />
<form action="<c:url value='/admin-new'/>" id="submit" method="get">
<table class="table" id="replace-table">
    <thead class="thead-dark">
    <tr>
        <th></th>
        <th>
            Tên tin tức
        </th>
        <th>
            Người tạo
        </th>
        <th>Chi tiết</th>
        <th>Sửa</th>
        <th>Xóa</th>
    </tr>
    </thead>

    <c:forEach var="item" items="${news.getListResult()}">
        <tr id="row-${item.getID()}">
            <td><img src="${item.getImage()}" style="width : 150px"  alt=""/></td>
            <td class="font-weight-bold">
                ${item.getName()}
            </td>
            <td class="font-weight-bold">
                ${item.getCreatedBy()}
            </td>
            <td class="font-weight-bold">
                <a href="<c:url value='/admin-new?type=detail&ID=${item.getID()}'/> ">
                    <i class="fa-lg fa fa-info-circle" aria-hidden="true"></i>
                </a>
            </td>
            <td class="font-weight-bold">
                <a href="<c:url value='/admin-new?type=edit&ID=${item.getID()}'/> ">
                    <i class="fa-lg fa fa-adjust" aria-hidden="true"></i>
                </a>
            </td>
            <td class="font-weight-bold">
                <a href="#" class="delete" id="${item.getID()}">
                    <i class="fa-lg fa fa-trash" aria-hidden="true"></i>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
    <ul id="luckmoshy"  class="pagination justify-content-center pagination-sm"></ul>
    <input type="hidden" id="page" name="page" />
    <input type="hidden" id="items" name="items" />
</form>
<script>
    let total = Math.ceil(${news.getTotal() / news.getItems()});
    let current = ${news.getPage()};
    let items = ${news.getItems()};
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
<script>
    $('.delete').click(function (e){
        e.preventDefault();
        let id = parseInt($(this).attr("id"));
        let data = {"id" : id};
        if(confirm("Bạn có chắc chắn muốn xóa?")){
            $.ajax({
                url: '/api-new-delete',
                type: 'delete',
                data: JSON.stringify(data),
                success: function (respone) {
                    if(respone.isDelete){
                        $('#row-'+id).remove();
                    }else{
                        alert("Có lỗi gì đó ! Vui lòng thử lại sau");
                    }
                },
                error: function (respone) {
                    console.log(respone);
                }
            })
        }else{}
    })
</script>
</body>
</html>
