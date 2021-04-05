$(document).ready(function(){

$("#login-btn").click(function (){
    let un = $("#userName").val();
    let pw = $("#password").val();
    $(document).ajaxSend(function() {
        $("#overlay").show();
    });

    $.ajax({
        url : '/trang-chu',
        type : 'post',
        data : {
            userName : un,
            password : pw
        },
        success : function (respone){
            $("#overlay").hide();
            if(respone.isSuccess == false) {
                $("#message").html(respone.message);
            }else{
                window.location.href = respone.url;
            }
        },
        error : function (respone){
            $("#overlay").hide();
        }
    })
});

$("#register-btn").click(function (){
        let name = $("#name").val();
        let phone = $("#phone").val();
        let un = $("#register-userName").val();
        let pw = $("#register-password").val();
        let rp = $("#re-password").val();
        if(name.trim() == "" || phone.trim() == "" || un.trim() == "" || pw.trim() == ""){
            $("#register-message").html("Hãy nhập đủ thông tin");
            return;
        }
        if(pw.trim() != rp.trim()){
            $("#register-message").html("Mật khẩu không khớp");
            return;
        }
        $(document).ajaxSend(function() {
            $("#overlay1").show();
        });

        $.ajax({
            url : '/api-user-new',
            type : 'post',
            data : {
                userName : un,
                password : pw,
                name : name,
                phone : phone
            },
            success : function (respone){
                $("#overlay1").hide();
                if(respone.existed == true) {
                    $("#register-message").html(respone.message);
                }else{
                    location.reload();
                }
            },
            error : function (respone){
                $("#overlay1").hide();
            }
        })
    });
    
	$(".mainmenu-area").sticky({topSpacing:0});
    
    
    $('.product-carousel').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:3,
            },
            1000:{
                items:5,
            }
        }
    });  
    
    $('.related-products-carousel').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:2,
            },
            1000:{
                items:2,
            },
            1200:{
                items:3,
            }
        }
    });  
    
    $('.brand-list').owlCarousel({
        loop:true,
        nav:true,
        margin:20,
        responsiveClass:true,
        responsive:{
            0:{
                items:1,
            },
            600:{
                items:3,
            },
            1000:{
                items:4,
            }
        }
    });  


    // Bootstrap Mobile Menu fix
    //$(".navbar-nav li a").click(function(){
    //    $(".navbar-collapse").removeClass('in');
    //});    

    // //jQuery Scroll effect
    //$('.navbar-nav li a, .scroll-to-up').bind('click', function(event) {
    //    var $anchor = $(this);
    //    var headerH = $('.header-area').outerHeight();
    //    $('html, body').stop().animate({
    //        scrollTop : $($anchor.attr('href')).offset().top - headerH + "px"
    //    }, 1200, 'easeInOutExpo');

    //    event.preventDefault();
    //});    
    
     //Bootstrap ScrollPSY
    //$('body').scrollspy({ 
    //    target: '.navbar-collapse',
    //    offset: 95
    //})
});

    $('.navbar-nav li a').click(function () {
        $('.navbar-nav li').removeClass('active');
        alert("SMT");
    });
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-10146041-21', 'auto');
  ga('send', 'pageview');
