<%@include file="../../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đơn hàng</title>
</head>
<body>
<br/>
<h2>Đơn Đặt</h2>
<table class="table" id="replace-table">
    <thead class="thead-dark">
    <tr>
        <th>Tên khách hàng</th>
        <th>Ngày đặt</th>
        <th>Trạng thái</th>
        <th>Chi tiết</th>
        <th>Xác nhận thanh toán</th>
    </tr>
    </thead>
    <c:forEach var="item" items="${listBill}">
        <tr id="row-${item.getID()}">
            <td>
                ${item.getName()}
            </td>
            <td class="font-weight-bold">
                    ${item.getCreatedDate()}
            </td>
            <td class="font-weight-bold">
                Chưa thanh toán
            </td>
            <td class="font-weight-bold">
                <a href="<c:url value='/admin-detail-bill?billID=${item.getID()}'/> ">
                    <i class="fa-lg fa fa-adjust align-middle" aria-hidden="true"></i>
                </a>
            </td>
            <td class="font-weight-bold">
                <a href="<c:url value='/admin-confirm-bill?billID=${item.getID()}'/>"  id="${item.getID()}">
                    <i class="btn btn-primary" aria-hidden="true">Xác nhận đã thanh toán</i>
                </a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
