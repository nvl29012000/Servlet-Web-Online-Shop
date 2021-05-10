<%@include file="../../../common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<br/>
<div>
    <a href="<c:url value='/admin-product?type=list&page=1&items=3' />" class="btn btn-primary"><span
            class="fa fa-backward"></span> Quay lại</a>
</div>
<br/>
<h2>${model.getName()}</h2>

<form id="data-submit">
    <div class="form-horizontal">
        <p id="message" class="text-danger"></p>
        <input type="hidden" value="${model.getID()}" id="id" name="id" />
        <div class="form-group">
            <div class="col-md-10">
                <label for="name">Product Name</label>
                <input type="text" value="${model.getName()}" id="name" name="name" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="productCode">Product Code</label>
                <input type="text" value="${model.getProductCode()}" id="productCode" name="productCode"
                       class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="title">Product Title</label>
                <input type="text" value="${model.getTitle()}" id="title" name="title"
                       class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="description">Product Description</label>
                <input type="text" value="${model.getDescription()}" id="description" name="description"
                       class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="image">Product Image</label>
                <input type="text" id="image" name="image" value="${model.getImage()}" class="form-control"/>
                <br/>
                <a href="#" id="select-image" class="btn btn-primary">Chọn ảnh</a>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-md-10">
                <label for="price">Price</label>
                <input type="number" min="0" id="price" value="${model.getPrice()}" name="price" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="salePrice">Sale Price</label>
                <input type="number" min="0" id="salePrice" value="${model.getSalePrice()}" name="salePrice"
                       class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="saleDate">Sale Date</label>
                <input type="datetime-local" id="saleDate" value="${model.getSaleDate().toLocalDateTime()}" name="saleDate"
                       class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="quantity">Quantity</label>
                <input type="number" min="0" id="quantity" value="${model.getQuantity()}" name="quantity"
                       class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="productDetail">Product Details</label>
                <input type="text" id="productDetail" value='${model.getProductDetail()}' name="productDetail" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="categoryID">Base Category</label>
                <input list="product-parentid" id="categoryID" name="categoryID" class="form-control"
                       value="${model.getCategoryID()}"/>
                <datalist id="product-parentid">
                    <c:forEach var="item" items="${cate.getListResult()}">
                        <option value="${item.getID()}">${item.getName()}</option>
                    </c:forEach>
                </datalist>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="metaKeyword">Meta Keyword</label>
                <input type="text" value="${model.getMetaKeyword()}" id="metaKeyword" name="metaKeyword"
                       class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metaDescription">Meta Discription</label>
                <input type="text" value="${model.getMetaDescription()}" id="metaDescription" name="metaDescription"
                       class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="status">Status</label>
                <div class="checkbox">
                    <input type="checkbox" id="status"/>
                </div>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <a href="#" class="btn btn-primary" id="EditProduct">Lưu thay đổi</a>
            </div>
        </div>
    </div>
    <br/>
</form>
<script>
    $('#status').attr('checked', ${model.isStatus()});
    CKEDITOR.replace('productDetail');
    let editor = CKEDITOR.instances['productDetail'];
    CKFinder.setupCKEditor(editor, '/Assets/admin/libraries/ckfinder/');
    // alert($('#productDetail').val());
    editor.setData($('#productDetail').val());
    <%--CKEDITOR.instances['productDetail'].setData(${model.getProductDetail()});--%>
    $('#select-image').click(function (e) {
        e.preventDefault();
        let finder = new CKFinder();
        finder.selectActionFunction = function (url) {
            $('#image').val(url);
        };
        finder.popup();
    })

    $('#EditProduct').click(function (e){
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
            url: '/api-product-edit',
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
