<%@page import="dao.ProductTypeDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductType"%>
<%@page import="service.DAOService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
	DAOService<ProductType, Integer> daoService = new DAOService<ProductType, Integer>(
			new ProductTypeDAO());
	List<ProductType> listProductTypes = daoService.listObject();
	String error = "";
	if (request.getAttribute("error") != null)
		error = (String) request.getAttribute("error");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loại Sản Phẩm</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="../js/jquery.1.7.js"></script>
<script src="../js/jquery.masonry.min.js"></script>
<script src="../js/modernizr-2.5.3.min.js"></script>
<script src="../js/home.js"></script>
<script src="../js/top.js"></script>
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
					<li><a class="menuitem" href="../home.jsp" id="trangchu">Trang
							Chủ </a></li>
					<li><a class="menuitem" href="user.jsp">Khách Hàng</a></li>
					<li><a class="menuitem" href="product.jsp">Sản Phẩm</a></li>
					<li><a class="menuitem" href="../manage/order.jsp">Hóa
							Đơn</a></li>
				</ul>
			</div>

			<a class="back-to-top" href="#" title="Quay lên trên">Lên Đầu
				Trang</a>
		</div>

		<div class="right">
			<%
				for (ProductType pt : listProductTypes) {
			%>
			<%=pt.toString()%>
			<%
				}
			%>
			<form action="../AddProductType" method="post">
				<label>Thêm loại sản phẩm:</label><input type="text"
					name="description"> <input type="submit" value="Thêm">
				<span><%=error%></span>
			</form>

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