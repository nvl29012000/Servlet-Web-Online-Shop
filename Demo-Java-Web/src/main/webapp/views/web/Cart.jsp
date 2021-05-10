<%@include file="../../common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<div id="overlay2">
    <div class="cv-spinner">
        <span class="spinner"></span>
    </div>
</div>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Giỏ Hàng</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="single-product-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12 col-sm-12">
                <div class="product-content-right">
                    <div class="woocommerce">
                        <table cellspacing="0" class="shop_table cart">
                            <thead>
                            <tr>
                                <th class="product-remove">&nbsp;</th>
                                <th class="product-thumbnail">&nbsp;</th>
                                <th class="product-name">Sản phẩm</th>
                                <th class="product-price">Giá</th>
                                <th class="product-quantity">Số lượng</th>
                                <th class="product-subtotal">Tạm tính</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${Cart.getProductList()}">
                            <tr class="cart_item" id="row-${item.getID()}">
                                <td class="product-remove">
                                    <a title="Remove this item" class="remove" id="${item.getID()}" href="#">×</a>
                                </td>

                                <td class="product-thumbnail">
                                    <a href="<c:url value="/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}" />"><img
                                            width="145" height="145" alt=""
                                            class="shop_thumbnail"
                                            src="${item.getImage()}"></a>
                                </td>

                                <td class="product-name">
                                    <a href="<c:url value="/chi-tiet-san-pham?pname=${item.getTitle()}&pid=${item.getID()}" />">${item.getName()}</a>
                                </td>

                                <td class="product-price">
                                    <jsp:useBean id="current" class="java.util.Date"/>
                                    <c:if test="${empty item.getSalePrice()}">
                                        <span class="sub-price-${item.getID()}">${item.getPrice()}</span>
                                    </c:if>
                                    <c:if test="${not empty item.getSalePrice()}">
                                        <c:if test="${item.getSaleDate() > current}">
                                            <span class="sub-price-${item.getID()}">${item.getSalePrice()}</span>
                                        </c:if>
                                        <c:if test="${item.getSaleDate() < current || empty item.getSaleDate()}">
                                            <span class="sub-price-${item.getID()}">${item.getPrice()}</span>
                                        </c:if>
                                    </c:if>
                                </td>

                                <td class="product-quantity">
                                    <div class="quantity buttons_added">
                                        <input type="button" class="minus" id="${item.getID()}" value="-">
                                        <input type="number" size="4" class="input-text qty text" title="Qty"
                                               id="total-quantity-${item.getID()}"
                                               value="${item.getQuantity()}" min="0" step="1" disabled>
                                        <input type="button" class="plus" id="${item.getID()}" value="+">
                                    </div>
                                </td>
                                <td class="product-subtotal">
                                    <c:if test="${empty item.getSalePrice()}">
                                        <span class="sub-amount-${item.getID()}">${item.getPrice() * item.getQuantity()}</span>
                                    </c:if>
                                    <c:if test="${not empty item.getSalePrice()}">
                                        <c:if test="${item.getSaleDate() > current}">
                                            <span class="sub-amount-${item.getID()}">${item.getSalePrice() * item.getQuantity()}</span>
                                        </c:if>
                                        <c:if test="${item.getSaleDate() < current || empty item.getSaleDate()}">
                                            <span class="sub-amount-${item.getID()}">${item.getPrice() * item.getQuantity()}</span>
                                        </c:if>
                                    </c:if>
                                </td>
                            </tr>
                            </tbody>
                            </c:forEach>
                        </table>
                        <div class="row">
                            <div class="cart_totals col-lg-6 col-md-6 col-sm-12">
                                <table cellspacing="0">
                                    <tbody>
                                    <tr class="shipping">
                                        <th>Shipping and Handling</th>
                                        <td>Free Shipping</td>
                                    </tr>
                                    <tr class="order-total">
                                        <th>Order Total</th>
                                        <td><strong><span class="amount" id="total-amount">${Cart.totalAmountToString()} VNĐ</span></strong>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <c:if test="${empty USER}">
                                    <form id="cart-submit" class="shipping_calculator ${empty Cart.getProductList() ? "invisible" : "visible"}">
                                        <p class="form-row form-row-wide"><input type="text" id="name"
                                                                                 name="name"
                                                                                 placeholder="Họ tên" value=""
                                                                                 class="input-text" required></p>
                                        <p class="form-row form-row-wide"><input type="text" id="phone"
                                                                                 name="phone"
                                                                                 placeholder="Điện thoại" value=""
                                                                                 class="input-text" required></p>
                                        <p>
                                        <p class="form-row form-row-wide"><input type="text" id="address"
                                                                                 name="address"
                                                                                 placeholder="Địa chỉ" value=""
                                                                                 class="input-text" required></p>
                                        <p>
                                        <p class="form-row form-row-wide"><input type="text" id="email"
                                                                                 name="email"
                                                                                 placeholder="Email" value=""
                                                                                 class="input-text"></p>
                                        <p>
                                            <button class="button-order btn btn-primary" value="1" name="calc_shipping" type="button">Đặt
                                                hàng
                                            </button>
                                        </p>
                                        </section>
                                    </form>
                                </c:if>
                                <c:if test="${not empty USER}">
                                    <form id="cart-submit" class="shipping_calculator ${empty Cart.getProductList() ? "invisible" : "visible"}">
                                        <input type="hidden" id="userID" name="userID" value="${USER.getID()}">
                                        <p class="form-row form-row-wide"><input type="text" id="name"
                                                                                 name="name"
                                                                                 placeholder="Họ tên" value="${USER.getName()}"
                                                                                 class="input-text" required disabled></p>
                                        <p class="form-row form-row-wide"><input type="text" id="phone"
                                                                                 name="phone"
                                                                                 placeholder="Điện thoại" value="${USER.getPhone()}"
                                                                                 class="input-text" required disabled></p>
                                        <p>
                                        <p class="form-row form-row-wide"><input type="text" id="address"
                                                                                 name="address"
                                                                                 placeholder="Địa chỉ" value="${USER.getAddress()}"
                                                                                 class="input-text" required></p>
                                        <p>
                                        <p class="form-row form-row-wide"><input type="text" id="email"
                                                                                 name="email"
                                                                                 placeholder="Email" value="${USER.getEmail()}"
                                                                                 class="input-text"></p>
                                        <p>
                                            <button class="button-order btn btn-primary" value="1" name="calc_shipping" type="button">Đặt
                                                hàng
                                            </button>
                                        </p>
                                        </section>
                                    </form>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(".button-order").click(function (e){
        e.preventDefault();
        let data = {};
        let formData = $('#cart-submit').serializeArray({
        });
        $.each(formData, function (index, value){
            data[""+value.name+""] = value.value;
        });
        $.ajax({
            url: '/api-bill-add',
            type: 'post',
            contentType : 'application/json',
            data: JSON.stringify(data),
            dataType : 'json',
            success: function (respone) {
                if(respone.Success){
                    alert("Đặt hàng thành công! Nhân viên cửa hàng sẽ sớm liên hệ bạn!")
                    window.location.href = respone.url;
                }else{
                    alert("Có lỗi gì đó! Thử lại sau!")
                }
            },
            error: function (respone) {
                console.log(respone);
            }
        })
    })
</script>
</body>
</html>
