<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="renderer" content="webkit"/>
    <meta name="force-rendering" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="report" content='{"pid":"blog"}'>
    <meta name="referrer" content="always">
    <meta http-equiv="Cache-Control" content="no-siteapp" /><link rel="alternate" media="handheld" href="#" />

<%--    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>--%>
<%--    <meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />--%>
    <link href="css/defaultStyle.css" rel='stylesheet' type='text/css' />
    <link href="images/avtar.png" rel="SHORTCUT ICON" />
    <script src="js/jquery/jquery-3.4.1.js"></script>
</head>

<body>
<script>
    $(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.login-form').fadeOut('slow', function(c){
            $('.login-form').remove();
        });
    });
});

    function doSubmit() {

    }
</script>

<!--SIGN UP-->
<h1> Welcome</h1>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="images/avtar.png" />
    </div>
    <form action="login/in" method="post" name="login_form" >
        <input type="text" class="text" name="userId" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >
        <div class="key">
            <input type="password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
        </div>
        <div class="signin">
            <input type="submit" name="loginSubmit" value="Login" >
        </div>
    </form>
</div>
<div class="copy-rights">
    <p>Copyright &copy; 2015.Company name All rights reserved.</p>
</div>

</body>
</html>

