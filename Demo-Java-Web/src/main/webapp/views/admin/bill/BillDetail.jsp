<%@include file="../../../common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết hóa đơn</title>
</head>
<body>
<br/>
<hr/>
<table>
    <tr>
        <td>Tên khách hàng : </td>
        <td>${bill.getName()}</td>
    </tr>
    <tr>
        <td>Ngày đặt</td>
        <td>${bill.getCreatedDate()}</td>
    </tr>
    <tr>
        <td>Số điện thoại : </td>
        <td>${bill.getPhone()}</td>
    </tr>
    <tr>
        <td>Địa chỉ : </td>
        <td>${bill.getAddress()}</td>
    </tr>
    <c:if test="${not empty bill.getEmail()}">
        <tr>
            <td>Email : </td>
            <td>${bill.getEmail()}</td>
        </tr>
    </c:if>
    <c:if test="${not empty bill.getConfirmDate()}">
        <tr>
            <td>Ngày thanh toán : </td>
            <td>${bill.getConfirmDate()}</td>
        </tr>
    </c:if>
    <c:if test="${not empty bill.getConfirmBy()}">
        <tr>
            <td>Người xác nhận : </td>
            <td>${bill.getConfirmBy()}</td>
        </tr>
    </c:if>
</table>
<hr/>
<br/>
<table class="table" id="replace-table">
    <thead class="thead-dark">
    <tr>
        <th></th>
        <th>Tên hàng</th>
        <th>Số lượng</th>
        <th>Đơn giá</th>
        <th>Thành tiền</th>
    </tr>
    </thead>
    <c:forEach var="item" items="${listBillDetail}">
        <tr id="row-${item.getID()}">
            <td>
                <img src="${item.getProductImage()}" alt="" style="width :100px" />
            </td>
            <td>
                    ${item.getProductName()}
            </td>
            <td class="font-weight-bold">
                    ${item.getQuantity()}
            </td>
            <td class="font-weight-bold">
                ${item.getPrice()}
            </td>
            <td>
                ${item.tongTien().toPlainString()}
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
