<%@include file="../../../common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết</title>
</head>
<body>
<div>
    <h3>${model.getName()}</h3>
    <hr />
    <p>
        <a href="<c:url value='/admin-productcategory?type=add'/>" class="btn btn-primary ">
            <i class="fa fa-plus-square" aria-hidden="true"></i>
            Thêm mới
        </a>
    </p>
    <table class="table table-striped table-dark">
        <tr>
            <td>Tên danh mục sản phẩm</td>
            <td>${model.getName()}</td>
        </tr>
        <tr>
            <td>Hình ảnh</td>
            <td><img src="${model.getImage()}" /></td>
        </tr>
        <tr>
            <td>Tiêu đề</td>
            <td>${model.getTitle()}</td>
        </tr>
        <tr>
            <td>Danh mục cha</td>
            <td>${model.getParentID()}</td>
        </tr>
        <tr>
            <td>Thứ tự hiển thị</td>
            <td>${model.getDisplayOrder()}</td>
        </tr>
        <tr>
            <td>Tiêu đề SEO</td>
            <td>${model.getSeoTitle()}</td>
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
            <td>Hiển thị trên trang chủ</td>
            <td><input type="checkbox" disabled id="showOnHome" /></td>
        </tr>
        <tr>
            <td>Trạng thái</td>
            <td><input type="checkbox" disabled id="status"/></td>
        </tr>
    </table>

</div>

<a class="btn btn-primary" href="<c:url value='/admin-productcategory?type=edit&ID=${model.getID()}'/> ">
    Sửa
</a>
<a class="btn btn-primary" href="<c:url value='/admin-productcategory?type=list'/> ">
    Trở về
</a>
<br />
<hr/>
<script>
    $('#showOnHome').attr('checked', ${model.isShowOnHome()});
    $('#status').attr('checked', ${model.isStatus()});
</script>
</body>
</html>
