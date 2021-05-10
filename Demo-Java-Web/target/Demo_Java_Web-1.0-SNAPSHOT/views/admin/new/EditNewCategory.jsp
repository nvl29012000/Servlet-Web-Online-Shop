<%@include file="../../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa</title>
</head>
<body>
<br />
<div>
    <a href="<c:url value='/admin-newcategory?type=list' />" class="btn btn-primary"><span class="fa fa-backward"></span> Quay lại</a>
</div>
<br />
<h2>${model.getName()}</h2>
<form id="data-submit">
    <div class="form-horizontal">
        <p id="message" class="text-danger"></p>
        <input type="hidden" value="${model.getID()}" name="id" id="id" />
        <div class="form-group">
            <div class="col-md-10">
                <label for="name">Category Name</label>
                <input type="text" value="${model.getName()}" id="name" name="name" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="title">Title</label>
                <input type="text" value="${model.getTitle()}" id="title" name="title" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="parentID">Base Category</label>
                <input list="newcategory-parentid" id="parentID" name="parentID" class="form-control" value="${model.getParentID()}"/>
                <datalist id="newcategory-parentid" >
                    <c:forEach var="item" items="${model.getListResult()}">
                        <c:if test="${item.getID()==model.getParentID()}">
                            <option value="${item.getID()}">${item.getName()}</option>
                        </c:if>
                        <c:if test="${item.getID()!=model.getParentID()}">
                            <option value="${item.getID()}">${item.getName()}</option>
                        </c:if>
                    </c:forEach>
                </datalist>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="displayOrder">Display Order</label>
                <input type="number" min="0" value="${model.getDisplayOrder()}" id="displayOrder" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="seoTitle">Seo Title</label>
                <input type="text" value="${model.getSeoTitle()}" id="seoTitle" name="seoTitle" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metaKeyword">Meta Keyword</label>
                <input type="text" value="${model.getMetaKeyword()}" id="metaKeyword" name="metaKeyword" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metaDescription">Meta Discription</label>
                <input type="text" value="${model.getMetaDescription()}" id="metaDescription" name="metaDescription" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="showonhome">Show On Home</label>
                <div class="checkbox">
                    <input type="checkbox"  id="showOnHome" />
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="status">Status</label>
                <div class="checkbox">
                    <input type="checkbox"  id="status" />
                </div>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <a href="#" class="btn btn-primary" id="EditNewCategory">Lưu thay đổi</a>
            </div>
        </div>
    </div>
    <br />
</form>
<script>
    $('#showOnHome').attr('checked', ${model.isShowOnHome()});
    $('#status').attr('checked', ${model.isStatus()});
    $('#EditNewCategory').click(function (e){
        e.preventDefault();
        let data = {};
        let formData = $('#data-submit').serializeArray({
        });
        $.each(formData, function (index, value){
            data[""+value.name+""] = value.value;
        });
        data["showOnHome"] = $('#showOnHome').is(':checked');
        data["status"] = $('#status').is(':checked');
        console.log(data);
        $.ajax({
            url: '/api-newcategory-edit',
            type: 'put',
            contentType : 'application/json',
            data: JSON.stringify(data),
            dataType : 'json',
            success: function (respone) {
                if(respone.isUpdate){
                    alert("Lưu thông tin thành công");
                    window.location.href = respone.url;
                }else{
                    alert("Có lỗi gì đó ! Vui lòng thử lại sau");
                }
            },
            error: function (respone) {
                console.log(respone);
            }
        })
    });
</script>
</body>
</html>
