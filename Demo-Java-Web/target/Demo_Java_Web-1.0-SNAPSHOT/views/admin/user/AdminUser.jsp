<%@include file="../../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Người dùng</title>
</head>
<body>
<br />
<h2>Tài khoản quản trị viên</h2>


<p>
    <a href="#myModal" class="form-btn btn btn-primary" data-toggle="modal">Thêm mới</a>
</p>
<div id="myModal" class="modal fade">
    <div id="overlay">
        <div class="cv-spinner">
            <span class="spinner"></span>
        </div>
    </div>
    <div class="modal-dialog modal-login">
        <div class="modal-content">
            <div class="modal-header text-center">
                <p class="text-center"><h3>Thêm mới</h3></p>
            </div>
            <div class="modal-body">
                <p class="text-danger text-center" id="message"></p>
                <div class="form-group">
                    <input type="text" class="form-control" name="userName" id="userName" placeholder="Username" required="required"/>
                </div>
                <br/>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password" required="required"/>
                </div>
                <br/>
                <div class="form-group">
                    <button id="add-btn" class="btn btn-primary btn-lg btn-block login-btn">Thêm mới</button>
                </div>
            </div>
        </div>
    </div>
</div>
<table class="table" id="table-user">
    <thead class="thead-dark">
    <tr>
        <th>
            Tên đăng nhập
        </th>
        <th>
            Trạng thái
        </th>
        <th>Vô hiệu hóa</th>
    </tr>
    </thead>
    <c:forEach var="item" items="${user}">
        <tr id="tr-${item.getID()}">
            <th>
                ${item.getUsername()}
            </th>
            <th>
                <input type="checkbox" id="ckb-${item.getID()}" disabled="disabled" ${item.isStatus() ? "checked" : ""}>
            </th>
            <th>
                <button class="btn btn-primary change" id="${item.getID()}">${item.isStatus() ? "Vô hiệu hóa" : "Kích hoạt"}</button>
            </th>
        </tr>
    </c:forEach>
</table>
<br />

</body>
</html>
