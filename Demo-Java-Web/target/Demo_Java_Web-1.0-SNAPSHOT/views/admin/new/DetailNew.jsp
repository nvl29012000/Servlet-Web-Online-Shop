<%@include file="../../../common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết tin tức</title>
</head>
<div>
    <h3>${model.getName()}</h3>
    <hr/>
    <p>
        <a href="<c:url value='/admin-new?type=add'/>" class="btn btn-primary ">
            <i class="fa fa-plus-square" aria-hidden="true"></i>
            Thêm mới
        </a>
    </p>
    <table class="table table-striped table-dark">
        <tr>
            <td>Tên tin tức</td>
            <td>${model.getName()}</td>
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
            <td>Danh mục</td>
            <td>${model.getCategoryID()}</td>
        </tr>
        <tr>
            <td>Chi tiết tin tức</td>
            <td>${model.getNewDetail()}</td>
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
            <td>Views</td>
            <td>${model.getViews()}</td>
        </tr>
        <tr>
            <td>Tag</td>
            <td>${model.getTag()}</td>
        </tr>
        <tr>
            <td>Trạng thái</td>
            <td><input type="checkbox" disabled id="status"/></td>
        </tr>
    </table>
</div>
<a class="btn btn-primary" href="<c:url value='/admin-new?type=edit&ID=${model.getID()}'/> ">
    Sửa
</a>
<a class="btn btn-primary" href="<c:url value='/admin-new?type=list'/> ">
    Trở về
</a>
<br/>
<hr/>
<script>
    $('#status').attr('checked', ${model.isStatus()});
</script>
</body>
</html>
