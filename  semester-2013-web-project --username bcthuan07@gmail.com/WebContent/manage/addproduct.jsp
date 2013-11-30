<%@page import="java.util.List"%>
<%@page import="dao.ProductTypeDAO"%>
<%@page import="model.ProductType"%>
<%@page import="dao.GeneralDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	GeneralDAO<ProductType, Integer> dao = new ProductTypeDAO();
	List<ProductType> list = dao.listObject();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm Sản Phẩm</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="../js/jquery.1.7.js"></script>
<script src="../js/jquery.masonry.min.js"></script>
<script src="../js/modernizr-2.5.3.min.js"></script>
<script src="../js/home.js"></script>
<script src="../js/top.js"></script>
<style type="text/css">
.regis {
	display: block;
	width: 800px;
	float: left;
	padding-bottom: 50px;
	padding-right: 50px;
}

.regis .input {
	min-width: 400px;
	margin-right: 60px;
	font-family: sans-serif;
	font-size: 20px;
	font-weight: normal;
	margin-right: 60px;
}

.regis select {
	min-width: 400px;
	margin-right: 60px;
	font-family: sans-serif;
	font-size: 20px;
	font-weight: normal;
	margin-right: 60px;
	float: right;
}

.regis label {
	font-family: sans-serif;
	font-size: 20px;
	font-weight: normal;
	margin-left: 80px;
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
	min-width: 200px;
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
</style>
</head>
<body>
	<div class="container">
		<div class="left">
			<div class="logo">
				<a href="#"> <img src="../images/logo.png" />
				</a>
				<div class="share">
					<ul>
						<li><a href="#"> <img src="../images/icon/tumblr.png"></a>
						</li>
						<li><a href="#"> <img src="../images/icon/pinterest.png">
						</a></li>
						<li><a href="#"> <img src="../images/icon/flickr.png">
						</a></li>
						<li><a href="#"> <img src="../images/icon/facebook.png">
						</a></li>
						<li><a href="#"> <img src="../images/icon/dribbble.png">
						</a></li>
						<li><a href="#"> <img src="../images/icon/behance.png">
						</a></li>
						<li><a href="#"> <img src="../images/icon/aim.png">
						</a></li>
					</ul>
				</div>
			</div>
			<div class="menu">
				<ul>
					<li><a href="../home.html">Trang Chủ </a></li>
					<li><a href="../add/register.jsp" id="trangchu">Đăng
							Nhập/Đăng kí</a>
					<li><a href="../menu.jsp">Thực Đơn </a></li>
					<li><a href="#">Đặt Hàng</a></li>
					<li><a href="../lienhe.html">Liên Hệ </a></li>
				</ul>
			</div>

			<a class="back-to-top" href="#" title="Quay lên trên">Lên Đầu
				Trang</a>
		</div>
		<!-- hết phần trái -->
		<div class="right">
			<div class="regis">
				<h1>Thêm Sản Phẩm</h1>
				<div class="divide"></div>
				<form action="register" method="post">
					<label style="float: left;">Tên: </label> <input class="input"
						style="float: right;" name="productname" type="text"> <br>
					<br> <label style="float: left;">Mô Tả: </label> <input
						class="input" style="float: right;" name="description" type="text">
					<br> <br> <label style="float: left;">Ảnh trưng
						bày </label> <input class="input" style="float: right;" name="firstname"
						type="file"> <br> <br> <label
						style="float: left;">Loại Sản Phẩm:</label> <select>
						<%
							for (ProductType pt : list) {
						%>
						<option value="<%=pt.getProductTypeId()%>"><%=pt.getDescription()%></option>
						<%
							}
						%>
					</select> <br>
					<br> <input class="submit" type="submit" value="Đăng Kí">
				</form>
			</div>
		</div>
	</div>

	<footer>
		<div class="info">
			<p>COPYRIGHT © 2013</p>
			<a href="../lienhe.html"> <b>Liên Hệ </b>
			</a>
		</div>
	</footer>
</body>
</html>