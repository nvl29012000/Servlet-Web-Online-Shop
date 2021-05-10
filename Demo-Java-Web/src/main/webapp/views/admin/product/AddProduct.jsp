<%@include file="../../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<br/>
<div>
    <a href="<c:url value='/admin-product?type=list&page=1&items=3' />" class="btn btn-primary"><span
            class="fa fa-backward"></span> Quay lại</a>
</div>
<br/>
<form id="data-submit">
    <div class="form-horizontal">
        <p id="message" class="text-danger"></p>
        <div class="form-group">
            <div class="col-md-10">
                <label for="name">Product Name</label>
                <input type="text" value="" id="name" name="name" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="productCode">Product Code</label>
                <input type="text" value="" id="productCode" name="productCode" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="description">Product Description</label>
                <input type="text" value="" id="description" name="description" class="form-control"/>
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
        <br/>
        <div class="form-group">
            <div class="col-md-10">
                <label for="price">Price</label>
                <input type="number" min="0" id="price" name="price" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="salePrice">Sale Price</label>
                <input type="number" min="0" id="salePrice" name="salePrice" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="saleDate">Sale Date</label>
                <input type="datetime-local" id="saleDate" name="saleDate" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="quantity">Quantity</label>
                <input type="number" min="0" id="quantity" name="quantity" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="productDetail">Product Details</label>
                <input type="text" id="productDetail" name="productDetail" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="categoryID">Base Category</label>
                <input list="product-categoryID" id="categoryID" name="categoryID" class="form-control" value=""/>
                <datalist id="product-categoryID">
                    <c:forEach var="item" items="${cate.getListResult()}">
                        <option value="${item.getID()}">${item.getName()}</option>
                    </c:forEach>
                </datalist>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="metaKeyword">Meta Keyword</label>
                <input type="text" value="" id="metaKeyword" name="metaKeyword" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metaDescription">Meta Description</label>
                <input type="text" value="" id="metaDescription" name="metaDescription" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="status">Status</label>
                <div class="checkbox">
                    <input type="checkbox" checked id="status"/>
                </div>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <a href="#" class="btn btn-primary" id="AddProduct">Thêm mới</a>
            </div>
        </div>
    </div>
    <br/>
</form>
<script>
    let editor = CKEDITOR.replace('productDetail');
    CKFinder.setupCKEditor(editor, '/Assets/admin/libraries/ckfinder/');
    $('#select-image').click(function (e) {
        e.preventDefault();
        let finder = new CKFinder();
        finder.selectActionFunction = function (url) {
            $('#image').val(url);
        };
        finder.popup();
    })

    $('#AddProduct').click(function (e){
        e.preventDefault();
        let data = {};
        let formData = $('#data-submit').serializeArray({
        });
        $.each(formData, function (index, value){
            data[""+value.name+""] = value.value;
        });
        data["status"] = $('#status').is(':checked');
        data["productDetail"] = CKEDITOR.instances['productDetail'].getData();
        $.ajax({
            url: '/api-product-new',
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
