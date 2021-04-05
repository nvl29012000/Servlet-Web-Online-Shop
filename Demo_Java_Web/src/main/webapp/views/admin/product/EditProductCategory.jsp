<%@include file="../../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa</title>
</head>
<body>
<br />
<div>
    <a href="<c:url value='/admin-productcategory?type=list' />" class="btn btn-primary"><span class="fa fa-backward"></span> Quay lại</a>
</div>
<br />
<h2>${model.getName()}</h2>

<form>
    <div class="form-horizontal">
        <p id="message" class="text-danger"></p>
        <div class="form-group">
            <div class="col-md-10">
                <label for="productcategory-name">Category Name</label>
                <input type="text" value="${model.getName()}" id="productcategory-name" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="productcategory-title">Title</label>
                <input type="text" value="${model.getTitle()}" id="productcategory-title" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="productcategory-parentid">Base Category</label>
                <input list="parentid" id="productcategory-parentid" class="form-control" value="${model.getParentID()}"/>
                <datalist id="parentid" >
                    <option value="">1</option>
                    <option value="">2</option>
                    <option value="">3</option>
                </datalist>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="productcategory-order">Display Order</label>
                <input type="number" value="${model.getDisplayOrder()}" id="productcategory-order" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="productcategory-seo">Seo Title</label>
                <input type="text" value="${model.getSeoTitle()}" id="productcategory-seo" class="form-control" />
            </div>
        </div>

<%--        <div class="form-group">--%>
<%--            <div class="col-md-10">--%>
<%--                <label for="createddate">Created Date</label>--%>
<%--                <input type="datetime" value="${model.getCreatedDate()}" id="createddate" class="form-control" readonly />--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <div class="col-md-10">--%>
<%--                <label for="createdby">Creator</label>--%>
<%--                <input type="text" value="${model.getCreatedBy()}" id="createdby" class="form-control" readonly />--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metakeyword">Meta Keyword</label>
                <input type="text" value="${model.getMetaKeyword()}" id="metakeyword" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metadiscription">Meta Discription</label>
                <input type="text" value="${model.getMetaDescription()}" id="metadiscription" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="showonhome">Show On Home</label>
                <div class="checkbox">
                    <input type="checkbox" checked="${model.isShowOnHome()}" id="showonhome" />
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="status">Status</label>
                <div class="checkbox">
                    <input type="checkbox" checked="${model.isStatus()}" id="status" />
                </div>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <a href="#" class="btn btn-primary" id="EditProductCategory">Lưu thay đổi</a>
            </div>
        </div>
    </div>
    <br />
</form>
</body>
</html>
