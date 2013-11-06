<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String username = (String) request.getAttribute("username");
	String username_err = "";if(request.getAttribute("username_err")!=null) username_err = (String) request.getAttribute("username_err");
	String password_err = "";if(request.getAttribute("password_err")!=null) password_err = (String) request.getAttribute("password_err");
	System.out.println(username_err);%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Nhà Hàng Jamie Oliver's</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--<meta name="description" content="">
    <meta name="author" content="">-->

<!-- Le styles -->
<link href="css\bootstrap.css" rel="stylesheet">
<style>
body {
	margin: 120px;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 400px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"]{
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
	padding-bottom: 10px;
}
</style>
<link href="css\bootstrap-responsive.css" rel="stylesheet">

<!-- Fav and touch icons -->
<link rel="shortcut icon" href=" ico/favicon.png">
</head>

<body>

	<div id="top" class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="index.html">Jamie Oliver's </a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="index.html">Trang Chủ</a></li>
						<li><a href="about.html">Giới Thiệu</a></li>
						<li><a href="contact.html">Liên Hệ</a></li>
						<li><a href="">Đặt Bàn Online</a></li>
						<!--drop down menu-->
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Thực đơn <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="foods.jsp">Món Ăn</a></li>
								<li><a href="">Đồ Uống</a></li>
							</ul></li>
					</ul>
					
				</div>
			</div>
		</div>
	</div>
	<div class="container">

		
      <form class="form-signin" method="post" action="login">
        <h2 class="form-signin-heading">Vui lòng đăng nhập</h2>
        <input name="username" type="text" class="input-block-level" placeholder="Username"><span class="text-error"style="font-size: 12pt;"><%=username_err %></span>
        <input name="password" type="password" class="input-block-level" placeholder="Password"><span class="text-error"style="font-size: 12pt;;"><%=password_err %></span>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Đăng nhập</button>
      </form>
		<hr class="featurette-divider">
		
	</div>
	<!-- /container -->


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap-transition.js"></script>
	<script src="js/bootstrap-alert.js"></script>
	<script src="js/bootstrap-modal.js"></script>
	<script src="js/bootstrap-dropdown.js"></script>
	<script src="js/bootstrap-scrollspy.js"></script>
	<script src="js/bootstrap-tab.js"></script>
	<script src="js/bootstrap-tooltip.js"></script>
	<script src="js/bootstrap-popover.js"></script>
	<script src="js/bootstrap-button.js"></script>
	<script src="js/bootstrap-collapse.js"></script>
	<script src="js/bootstrap-carousel.js"></script>
	<script src="js/bootstrap-typeahead.js"></script>

</body>
</html>
