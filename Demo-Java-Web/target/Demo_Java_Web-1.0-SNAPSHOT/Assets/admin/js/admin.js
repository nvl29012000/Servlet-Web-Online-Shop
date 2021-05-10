$(document).ready(function () {
    $(document).on('click', '.change', function () {
        let id = parseInt($(this).attr('id'));
        $.ajax({
            type: 'POST',
            data: {ID: id},
            url: '/api-adminuser-active',
            success: function (respone) {
                let x;
                if (respone.Status) {
                    $('#ckb-' + id).attr("checked", "checked")
                    x = "Vô hiệu hóa";
                } else {
                    $('#ckb-' + id).removeAttr("checked");
                    x = "Kích hoạt";
                }
                $('#' + id).html(x);
            }
        })
    });


    $("#add-btn").click(function () {
        let un = $("#userName").val();
        let pw = $("#password").val();
        $(document).ajaxSend(function() {
            $("#overlay").show();
        });

        $.ajax({
            url: '/api-adminuser-new',
            type: 'post',
            data: {
                username: un,
                password: pw
            },
            success: function (respone) {
                $("#overlay").hide();
                if (respone.existed == true) {
                    $("#message").html(respone.message);
                } else {
                    location.reload();
                }
            },
            error: function (respone) {
                $("#overlay").hide();
            }
        })
    });
})