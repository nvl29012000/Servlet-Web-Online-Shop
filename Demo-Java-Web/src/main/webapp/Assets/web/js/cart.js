$(document).ready(function () {
    $(".add_to_cart_button,.add-to-cart-link").click(function (e) {
        e.preventDefault();
        let quantity = $('#product-quantity').val();
        if (quantity < 1) {
            alert("Số lượng không phù hợp");
            return;
        }
        if (quantity == null) {
            quantity = 1;
        }
        let id = parseInt($(this).attr('id'));
        post(id, quantity);
    })

    $(".remove").click(function (e) {
        e.preventDefault();
        let id = parseInt($(this).attr('id'));
        del(id);
    })

    $('.minus').click(function (e) {
        e.preventDefault();
        let id = parseInt($(this).attr('id'));
        let total = parseInt($('#total-quantity-' + id).val());
        if (total == 1) {
            del(id);
            $('#overlay2').hide();
        } else {
            post(id, -1);
            $('#total-quantity-' + id).val(total - 1);
            $('.sub-amount-' + id).text(parseFloat($('.sub-price-' + id).text()) * parseInt($('#total-quantity-' + id).val()));
        }
    })

    $('.plus').click(function (e) {
        e.preventDefault();
        let id = parseInt($(this).attr('id'));
        let total = parseInt($('#total-quantity-' + id).val());
        post(id, 1);
        $('#total-quantity-' + id).val(total + 1);
        $('.sub-amount-' + id).text(parseFloat($('.sub-price-' + id).text()) * parseInt($('#total-quantity-' + id).val()));
    })
});

function post(id, quantity) {
    let data = {};
    data["id"] = id;
    data["quantity"] = quantity;
    $(document).ajaxSend(function () {
        $('#overlay2').fadeIn(500);
    });
    $.ajax({
        url: '/add-to-cart',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (respone) {
            $("#overlay2").fadeOut();
            $(".product-count").html(respone.productList.length);
            $("#total-amount").text(respone.totalAmount + " VNĐ");
        },
        error: function (respone) {
            $("#overlay2").fadeOut();
            console.log(respone);
        }
    })
}

function del(id) {
    let data = {};
    data["id"] = id;
    $(document).ajaxSend(function () {
        $('#overlay2').fadeIn(300);
    });
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        $.ajax({
            url: '/add-to-cart',
            type: 'delete',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (respone) {
                $("#overlay2").fadeOut();
                if (respone.isDelete) {
                    $('#row-' + id).remove();
                    $(".product-count").html(respone.cart.productList.length);
                    if(respone.cart.productList.length == 0){
                        $("#cart-submit").addClass("invisible");
                    }
                    $("#total-amount").text(respone.cart.totalAmount + " VNĐ");
                } else {
                    alert("Có lỗi gì đó ! Vui lòng thử lại sau");
                }
            },
            error: function (respone) {
                $("#overlay2").fadeOut();
                console.log(respone);
            }
        })
    }
}