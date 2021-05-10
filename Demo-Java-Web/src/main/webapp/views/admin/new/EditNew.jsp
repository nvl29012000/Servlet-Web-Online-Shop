<%@include file="../../../common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa tin tức</title>
</head>
<body>
<br/>
<div>
    <a href="<c:url value='/admin-new?type=list&page=1&items=3' />" class="btn btn-primary"><span
            class="fa fa-backward"></span> Quay lại</a>
</div>
<br/>
<h2>${model.getName()}</h2>
<form id="data-submit">
    <input type="hidden" value="${model.getID()}" id="id" name="id" />
    <div class="form-horizontal">
        <p id="message" class="text-danger"></p>
        <div class="form-group">
            <div class="col-md-10">
                <label for="name">New Name</label>
                <input type="text" value="${model.getName()}" id="name" name="name" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="title">New Title</label>
                <input type="text" value="${model.getTitle()}" id="title" name="title" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="description">New Description</label>
                <input type="text" value="${model.getDescription()}" id="description" name="description" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="image">New Image</label>
                <input type="text" id="image" name="image" value="${model.getImage()}" class="form-control"/>
                <br/>
                <a href="#" id="select-image" class="btn btn-primary">Chọn ảnh</a>
            </div>
        </div>
        <br/>
        <div class="form-group">
            <div class="col-md-10">
                <label for="newDetail">New Details</label>
                <input type="text" id="newDetail" value='${model.getNewDetail()}' name="newDetail" class="form-control" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="categoryID">Base Category</label>
                <input list="new-categoryID" id="categoryID" name="categoryID" class="form-control" value="${model.getCategoryID()}"/>
                <datalist id="new-categoryID">
                    <c:forEach var="item" items="${cate.getListResult()}">
                        <option value="${item.getID()}">${item.getName()}</option>
                    </c:forEach>
                </datalist>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="metaKeyword">Meta Keyword</label>
                <input type="text" value="${model.getMetaKeyword()}" id="metaKeyword" name="metaKeyword" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-10">
                <label for="metaDescription">Meta Description</label>
                <input type="text" value="${model.getMetaDescription()}" id="metaDescription" name="metaDescription" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-10">
                <label for="tag">Tag</label>
                <input type="text" value="${model.getTag()}" id="tag" name="tag" class="form-control"/>
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
                <a href="#" class="btn btn-primary" id="EditNew">Lưu thay đổi</a>
            </div>
        </div>
    </div>
    <br/>
</form>
<script>
    $('#status').attr('checked', ${model.isStatus()});
    CKEDITOR.replace('newDetail');
    let editor = CKEDITOR.instances['newDetail'];
    CKFinder.setupCKEditor(editor, '/Assets/admin/libraries/ckfinder/');
    // alert($('#productDetail').val());
    editor.setData($('#newDetail').val());
    $('#select-image').click(function (e) {
        e.preventDefault();
        let finder = new CKFinder();
        finder.selectActionFunction = function (url) {
            $('#image').val(url);
        };
        finder.popup();
    })

    $('#EditNew').click(function (e){
        e.preventDefault();
        let data = {};
        let formData = $('#data-submit').serializeArray({
        });
        $.each(formData, function (index, value){
            data[""+value.name+""] = value.value;
        });
        data["status"] = $('#status').is(':checked');
        data["newDetail"] = CKEDITOR.instances['newDetail'].getData();
        $.ajax({
            url: '/api-new-edit',
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
