<%@include file="../../../common/taglib.jsp" %>
>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin liên hệ</title>
</head>
<body>
<br/>
<h2>Thông tin liên hệ</h2>

<p>
    <a href="<c:url value='/admin-contact?type=edit&ID=${model.getID()}' />" class="btn btn-primary">
        Chỉnh sửa
    </a>
</p>
<table class="table" id="replace-table">
    <thead class="thead-dark">
    <tr>
        <th>Tiêu đề</th>
        <th>Chi tiết</th>
    </tr>
    </thead>
    <tr>
        <td>Nội dung</td>
        <td class="font-weight-bold">
            ${model.getContent()}
        </td>
    </tr>
    <tr>
        <td>Liên kết Facebook</td>
        <td class="font-weight-bold">
            ${model.getFacebook()}
            </a>
        </td>
    </tr>
    <tr>
        <td>Kênh Youtube</td>
        <td class="font-weight-bold">
            ${model.getYoutube()}
            </a>
        </td>
    </tr>
    <tr>
        <td>Hòm thư Gmail</td>
        <td class="font-weight-bold">
            ${model.getGmail()}
            </a>
        </td>
    </tr>
</table>
</body>
</html>
