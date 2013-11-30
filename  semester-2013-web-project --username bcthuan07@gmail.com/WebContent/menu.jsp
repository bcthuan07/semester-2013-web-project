<%@page import="java.util.Set"%>
<%@page import="dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductTypeDAO"%>
<%@page import="model.ProductType"%>
<%@page import="dao.GeneralDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	GeneralDAO<ProductType, Integer> dao = new ProductTypeDAO();
	List<ProductType> list = dao.listObject();

	List<Product> listProduct = new ArrayList<Product>();
	String ptString = "";
	if(request.getAttribute("producttype")!=null){
		ProductType pt = (ProductType) request.getAttribute("producttype");
		ptString = pt.getDescription();
		Set<Product> set = pt.getProducts();
		listProduct.addAll(set);
	} else {
		listProduct = new ProductDAO().listObject();
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thực Đơn</title>
<link rel="stylesheet" href="css/style.css" />
<script src="js/top.js"></script>
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
					<li><a href="home.html" id="trangchu">Trang Chủ </a></li>
					<li><a href="add/register.jsp">Đăng Nhập/Đăng kí</a>
					<li><a href="#">Thực Đơn </a></li>
					<li><a href="#">Đặt Hàng</a></li>
					<li><a href="lienhe.html">Liên Hệ </a></li>
				</ul>
			</div>

			<a class="back-to-top" href="#" title="Quay lên trên">Lên Đầu
				Trang</a>
		</div>
		<div class="topmenu">
			<ul>
				<%
					for (ProductType pt : list) {
						String c = "";
						if(ptString.equals(pt.getDescription())){
							c="menuactive";
						}
				%>
				<li class="<%=c %>"><a href="Menu?idproducttype=<%=pt.getProductTypeId()%>"
					title="Món ăn"><%=pt.getDescription()%></a></li>

				<%
					}
				%>
			</ul>
		</div>
		<div class="right">
		<%for(Product product: listProduct){ %>
				<div class="boxitem">
				<div class="proimage">
					<a href="ProductDetail?productid=<%=product.getProductId() %>"><img alt="" src="<%=product.getImagePath() %>"></a>
				</div>
					<div class="info">
					ajgakjgakjgh
					</div>
				</div>
		<% } %>
		</div>
	</div>
	<footer>
	<div class="info">
		<p>COPYRIGHT © 2013 </p>
		<a href="lienhe.html"> <b>Liên Hệ </b> </a>
	</div>
</footer>
</body>
</html>