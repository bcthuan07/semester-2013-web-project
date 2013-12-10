<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng Nhập</title>
<link rel="stylesheet" href="css/style.css" />
<!-- 			<script src="js/jquery.1.7.js" ></script>
			<script src="js/jquery.masonry.min.js" ></script>
			<script src="js/modernizr-2.5.3.min.js" ></script>
			<script src="js/home.js" ></script>  -->
</head>
<body>
	<div class="container">
		<div class="left">
			<div class="logo">
				<a href="#"> <img src="images/logo.png" />
				</a>
				<div class="share">
					<ul>
						<li><a href="#"> <img src="images/icon/tumblr.png">
						</a></li>
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
					<li><a class="menuitem" href="login.jsp" id="active">Đăng
							Nhập / Đăng Kí</a>
					<li><a class="menuitem" href="Menu">Thực Đơn </a></li>
					<li><a class="menuitem" href="order.jsp">Đặt Hàng</a></li>
					<li><a class="menuitem" href="lienhe.jsp">Liên Hệ </a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="right">
		<form action="Login" method="post">
			<label>Username:</label><input type="text" name="username"> <label>Password:</label><input
				type="password" name="password"> <input type="submit"
				value="Đăng Nhập">
		</form>
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