<%--
  Created by IntelliJ IDEA.
  User: mrloc
  Date: 18/04/2021
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin liên hệ</title>
</head>
<body>
<br />
<div>
  <a href="<c:url value='/admin-contact' />" class="btn btn-primary"><span class="fa fa-backward"></span> Quay lại</a>
</div>
<br />
<h2>Thông tin liên hệ</h2>
<form id="data-submit">
  <div class="form-horizontal">
    <p id="message" class="text-danger"></p>
    <input type="hidden" value="${model.getID()}" name="id" id="id" />
    <div class="form-group">
      <div class="col-md-10">
        <label for="content">Nội dung</label>
        <input type="text" value="${model.getContent()}" id="content" name="content" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="col-md-10">
        <label for="facebook">Title</label>
        <input type="text" value="${model.getFacebook()}" id="facebook" name="facebook" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="col-md-10">
        <label for="youtube">Title</label>
        <input type="text" value="${model.getYoutube()}" id="youtube" name="youtube" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="col-md-10">
        <label for="gmail">Title</label>
        <input type="text" value="${model.getGmail()}" id="gmail" name="gmail" class="form-control" />
      </div>
    </div>
    <br/>
    <div class="form-group">
      <div class="col-md-offset-2 col-md-10">
        <a href="#" class="btn btn-primary" id="EditContact">Lưu thay đổi</a>
      </div>
    </div>
  </div>
  <br />
</form>
<script>
  $('#EditContact').click(function (e){
    e.preventDefault();
    let data = {};
    let formData = $('#data-submit').serializeArray({
    });
    $.each(formData, function (index, value){
      data[""+value.name+""] = value.value;
    });
    console.log(data);
    $.ajax({
      url: '/api-contact-edit',
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
