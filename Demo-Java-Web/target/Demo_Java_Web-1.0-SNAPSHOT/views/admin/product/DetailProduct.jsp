<%@include file="../../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
</head>
<body>
<div>
    <h3>${model.getName()}</h3>
    <hr/>
    <p>
        <a href="<c:url value='/admin-product?type=add'/>" class="btn btn-primary ">
            <i class="fa fa-plus-square" aria-hidden="true"></i>
            Thêm mới
        </a>
    </p>
    <table class="table table-striped table-dark">
        <tr>
            <td>Tên sản phẩm</td>
            <td>${model.getName()}</td>
        </tr>

        <tr>
            <td>Mã sản phẩm</td>
            <td>${model.getProductCode()}</td>
        </tr>
        <tr>
            <td>Tiêu đề</td>
            <td>${model.getTitle()}</td>
        </tr>
        <tr>
            <td>Mô tả</td>
            <td>${model.getDescription()}</td>
        </tr>
        <tr>
            <td>Hình ảnh</td>
            <td><img src="${model.getImage()}" style="width : 150px" /> </td>
        </tr>
        <tr>
            <td>Giá</td>
            <td>${model.getPrice()}</td>
        </tr>
        <tr>
            <td>Giá khuyến mãi</td>
            <td>${model.getSalePrice()}</td>
        </tr>
        <tr>
            <td>Ngày kết thúc khuyến mãi</td>
            <td>${model.getSaleDate()}</td>
        </tr>
        <tr>
            <td>Số lượng còn</td>
            <td>${model.getQuantity()}</td>
        </tr>
        <tr>
            <td>Danh mục</td>
            <td>${model.getCategoryID()}</td>
        </tr>
        <tr>
            <td>Chi tiết sản phẩm</td>
            <td>${model.getProductDetail()}</td>
        </tr>
        <tr>
            <td>Ngày tạo</td>
            <td>${model.getCreatedDate()}</td>
        </tr>
        <tr>
            <td>Người tạo</td>
            <td>${model.getCreatedBy()}</td>
        </tr>
        <tr>
            <td>Ngày sửa</td>
            <td>${model.getModifiedDate()}</td>
        </tr>
        <tr>
            <td>Người sửa</td>
            <td>${model.getModifiedBy()}</td>
        </tr>
        <tr>
            <td>Meta Keyword</td>
            <td>${model.getMetaKeyword()}</td>
        </tr>
        <tr>
            <td>Meta Description</td>
            <td>${model.getMetaDescription()}</td>
        </tr>
        <tr>
            <td>Trạng thái</td>
            <td><input type="checkbox" disabled id="status"/></td>
        </tr>
    </table>

</div>

<a class="btn btn-primary" href="<c:url value='/admin-product?type=edit&ID=${model.getID()}'/> ">
    Sửa
</a>
<a class="btn btn-primary" href="<c:url value='/admin-product?type=list'/> ">
    Trở về
</a>
<br/>
<hr/>
<script>
    $('#status').attr('checked', ${model.isStatus()});
</script>
</body>
</html>
