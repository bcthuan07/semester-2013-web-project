<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String username = "";
	String phonenumber = "";
	String lastname = "";
	String firstname = "";
	String email = "";
	String street = "";
	String buildingnumber = "";
	String zipcode = "";
	String city = "";

	String username_err = "";
	String phonenumber_err = "";
	String lastname_err = "";
	String firstname_err = "";
	String email_err = "";
	String street_err = "";
	String buildingnumber_err = "";
	String zipcode_err = "";
	String city_err = "";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Kí</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="../js/jquery.1.7.js"></script>
<script src="../js/jquery.masonry.min.js"></script>
<script src="../js/modernizr-2.5.3.min.js"></script>
<script src="../js/home.js"></script>
<script src="../js/top.js"></script>
<style type="text/css">
.regis {
	display: block;
	width: 700px;
	float: left;
	padding-bottom: 50px;
	padding-right: 100px;
}

.regis .input {
	min-width: 200px;
	margin-right: 60px;
	font-family: sans-serif;
	font-size: 20px;
	font-weight: normal;
	margin-right: 60px;
}

.regis label {
	font-family: sans-serif;
	font-size: 20px;
	font-weight: normal;
	margin-left: 200px;
}

.divide {
	border-bottom: 1px solid rgb(214, 214, 214);
	margin-top: 10px;
	margin-bottom: 50px;
}

h1 {
	font-family: sans-serif;
}

.regis form ul li {
	list-style: none;
	float: right;
	margin-right: 110px;
}

.regis form ul li span {
	font-size: 20px;
	font-family: sans-serif;
	margin-right: 10px;
}

.regis form .submit {
	display: block;
	width: 200px;
	height: 50px;
	font-size: 24px;
	font-family: sans-serif;
	background: black;
	float: right;
	color: white;
	margin-right: 60px;
	border: 0;
	margin-top: 10px;
	margin-bottom: 10px;
}

.regis form .check {
	margin-right: 0;
	color: red;
	padding-top: 5;
	font-size: 18;
}

.regis form .error{
	color: red;
	font-size: 18px;
	margin-right: 0px;
	padding-right: 0px;
	
}
</style>
</head>
<body>
	<div class="container">
		<div class="left">
			<div class="logo">
				<a href="#"> <img src="images/logo.png" />
				</a>
				<div class="share">
					<ul>
						<li><a href="#"> <img src="images/icon/tumblr.png"></a>
						</li>
						<li><a href="#"> <img src="images/icon/pinterest.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/flickr.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/facebook.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/dribbble.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/behance.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/aim.png">
						</a></li>
					</ul>
				</div>
			</div>
			<div class="menu">
				<ul>
					<li><a class="menuitem" href="home.jsp">Trang Chủ </a></li>
					<li><a class="menuitem" href="register.jsp" id="active">Đăng
							Nhập/Đăng kí</a>
					<li><a class="menuitem" href="Menu">Thực Đơn </a></li>
					<li><a class="menuitem" href="order.jsp">Đặt Hàng</a></li>
					<li><a class="menuitem" href="lienhe.jsp">Liên Hệ </a></li>
				</ul>
			</div>

			<a class="back-to-top" href="#" title="Quay lên trên">Lên Đầu
				Trang</a>
		</div>
		<!-- hết phần trái -->
		<div class="right">
			<div class="regis">
				<h1>Đăng Kí</h1>
				<div class="divide"></div>
				<form action="register" method="post">
					<label style="float: left;">Username: </label><span
						class="check">*</span> <input class="input"
						style="float: right;" name="username" type="text"> <br><p class="error" style="float: right;">errp</p> <br> <label
						style="float: left;">Password: </label> <input class="input"
						style="float: right;" name="password" type="password"><span
						class="check">*</span> <br>
					<br> <label style="float: left;">Họ: </label> <input
						class="input" style="float: right;" name="firstname" type="text"><span
						class="check">*</span>
					<br> <br> <label style="float: left;">Tên: </label> <input
						class="input" style="float: right;" name="lastname" type="text"><span
						class="check">*</span>
					<br> <br> <label style="float: left;">Email: </label> <input
						class="input" style="float: right;" name="email" type="text"><span
						class="check">*</span><br>
					<br> <label style="float: left;">Số Điện Thoại: </label> <input
						class="input" style="float: right;" name="phonenumber" type="text"><span
						class="check">*</span><br>
					<br> <label style="float: left;">Giới Tính: </label>
					<ul>
						<li><input style="max-width: 100px;" name="gender"
							type="radio" value="Nam" checked><span>Nam</span>
						<li>
						<li><input style="max-width: 100px" name="gender"
							type="radio" value="Nữ"><span>Nữ</span></li>
					</ul><span
						class="check">*</span>
					<br>
					<br> <label style="float: left">Số Nhà</label><input
						class="input" style="float: right;" type="text"
						name="buildingnumber"><span
						class="check">*</span><br>
					<br> <label style="float: left">Đường</label><input
						class="input" style="float: right;" type="text" name="street"><span
						class="check">*</span><br>
					<br> <label style="float: left">Zip Code</label><input
						class="input" style="float: right;" type="text" name="zipcode"><span
						class="check">*</span><br>
					<br> <label style="float: left">Thành Phố</label><input
						class="input" style="float: right;" type="text" name="city"><span
						class="check">*</span><br>
					<br> <input class="submit" type="submit" value="Đăng Kí">
				</form>
			</div>
		</div>
	</div>

	<footer>
		<div class="info">
			<p>COPYRIGHT © 2013</p>
			<a href="lienhe.jsp"> <b>Liên Hệ </b>
			</a>
		</div>
	</footer>
</body>
</html>