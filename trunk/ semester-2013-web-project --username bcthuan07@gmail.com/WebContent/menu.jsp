<%@page import="model.User"%>
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
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");

	GeneralDAO<ProductType, Integer> dao = new ProductTypeDAO();
	List<ProductType> list = dao.listObject();

	List<Product> listProduct = new ArrayList<Product>();
	String ptString = "";
	if (request.getAttribute("listproduct") != null) {
		listProduct = (List<Product>) request
				.getAttribute("listproduct");
	} else if (request.getAttribute("producttype") != null) {
		ProductType pt = (ProductType) request
				.getAttribute("producttype");
		ptString = pt.getDescription();
		Set<Product> set = pt.getProducts();
		listProduct.addAll(set);
	} else {
		listProduct = new ProductDAO().listObject();
	}
	
	User user = (User) session.getAttribute("user");
	String username = user==null? "Thành Viên": "Xin Chào "+user.getUsername();
	boolean permission = user == null? false: user.getPermission();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Thực Đơn</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link href="css/3-col-portfolio.css" rel="stylesheet">
<style>
.ac {
	background-color: #43bc9f;
}
</style>
</head>

<body>

	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="http://startbootstrap.com">Start
					Bootstrap</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#about">About</a></li>
					<li><a href="#services">Services</a></li>
					<li><a href="#contact">Contact</a></li>

					<li class="dropdown"><a href="" class="dropdown-toggle"
						data-toggle="dropdown"><%=username%><b class="caret"></b></a>
						<ul class="dropdown-menu">
							<%
								if (user == null) {
							%><li><a href="login.jsp">Đăng Nhập</a></li>
							<li><a href="register.jsp">Đăng Ký</a></li>
							<%
								}
							%>
							<li><a href="order/cartview.jsp">Giỏ Hàng</a></li>
							<li class="divider"></li>
							<!--<li class="dropdown-header">Nav header</li>-->
							<%
								if (user != null) {
							%>
							<%
								if (permission) {
							%>
							<li><a href="Manage">Trang Quản Lý</a></li>
							<%
								}
							%>
							<li><a href="Logout">Thoát</a></li>
							<%
								}
							%>
						</ul></li>
					<li>
						<form action="SearchProductByName"
							class="navbar-form navbar-right" role="form">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Tìm Kiếm Món Ăn" name="search">
							</div>
							<input type="submit" value="Tìm" class="btn btn-success">
						</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<br>
	<nav class="navbar navbar-inverse"
		style="background-color: white; border-radius: 0; border: 0;"
		role="navigation">
		<div class="container"
			style="max-width: 1200px; margin-right: auto; margin-left: auto; background-color: #63cab3;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" style="border: white;"
					data-toggle="collapse" data-target=".navbar-ex2-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Menu">Thực Đơn</a>
			</div>

			<div class="collapse navbar-collapse navbar-ex2-collapse">
				<ul class="nav navbar-nav">
					<%
						for (ProductType pt : list) {
							String c = "";
							if (ptString.equals(pt.getDescription())) {
								c = "ac";
							}
					%>

					<li class="<%=c%>"><a
						href="Menu?producttype=<%=pt.getProductTypeId()%>" title="Món ăn"><%=pt.getDescription()%></a></li>

					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>


	<div class="container">
		<%
			int count = 0;
			for (Product product : listProduct) {
				count++;
				if (count % 3 == 1) {
		%>
		<div class="row">
			<%
				}
			%>

			<div class="col-md-4 portfolio-item">
				<a href="ProductInfo?product=<%=product.getProductId()%>"><img
					class="img-responsive" src="http://placehold.it/700x400"></a>
				<h3>
					<a href="ProductInfo?product=<%=product.getProductId()%>"><%=product.getProductName()%></a>
				</h3>
				<p><%=product.getDescription()%></p>
			</div>
			<%
				if (count % 3 == 0) {
			%>
		</div>

		<%
			}
			}
		%>
	</div>
	<div class="container">

		<hr>

		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Company 2013</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- JavaScript -->
	<script src="js/jquery-1.10.2.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>