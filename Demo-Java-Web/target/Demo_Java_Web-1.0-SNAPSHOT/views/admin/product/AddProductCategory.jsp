<%@include file="../../../common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<br />
<div>
    <a href="<c:url value='/admin-productcategory?type=list' />" class="btn btn-primary"><span class="fa fa-backward"></span> Quay lại</a>
</div>
<br />
<form id="data-submit">
    <div class="form-horizontal">
        <p id="message" class="text-danger"></p>
        <div class="form-group">
            <div class="col-md-10">
                <label for="name">Category Name</label>
                <input type="text" value="" id="name" name="name" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="image">Product Image</label>
                <input type="text" id="image" name="image" class="form-control"/>
                <br/>
                <a href="#" id="select-image" class="btn btn-primary">Chọn ảnh</a>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="parentID">Base Category</label>
                <input list="productcategory-parentid" id="parentID" name="parentID" class="form-control" value=""/>
                <datalist id="productcategory-parentid" >
                    <c:forEach var="item" items="${model.getListResult()}">
                        <option value="${item.getID()}">${item.getName()}</option>
                    </c:forEach>
                </datalist>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="displayOrder">Display Order</label>
                <input type="number" min="0" value="" id="displayOrder" name="displayOrder" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="seoTitle">Seo Title</label>
                <input type="text" value="" id="seoTitle" name="seoTitle" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metaKeyword">Meta Keyword</label>
                <input type="text" value="" id="metaKeyword" name="metaKeyword" class="form-control" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metaDescription">Meta Discription</label>
                <input type="text" value="" id="metaDescription" name="metaDescription" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="showOnHome">Show On Home</label>
                <div class="checkbox">
                    <input type="checkbox" checked id="showOnHome" />
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="status">Status</label>
                <div class="checkbox">
                    <input type="checkbox" checked id="status" />
                </div>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <a href="#" class="btn btn-primary" id="AddProductCategory">Thêm mới</a>
            </div>
        </div>
    </div>
    <br />
</form>
<script>
    $('#select-image').click(function (e) {
        e.preventDefault();
        let finder = new CKFinder();
        finder.selectActionFunction = function (url) {
            $('#image').val(url);
        };
        finder.popup();
    })
    $('#AddProductCategory').click(function (e){
        e.preventDefault();
        let data = {};
        let formData = $('#data-submit').serializeArray({
        });
        $.each(formData, function (index, value){
            data[""+value.name+""] = value.value;
        });
        data["showOnHome"] = $('#showOnHome').is(':checked');
        data["status"] = $('#status').is(':checked');
        $.ajax({
            url: '/api-productcategory-new',
            type: 'post',
            contentType : 'application/json',
            data: JSON.stringify(data),
            dataType : 'json',
            success: function (respone) {
                if(respone.isSuccess = true){
                    alert(respone.message);
                    window.location.href = respone.url;
                }else{
                    alert(respone.message);
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
