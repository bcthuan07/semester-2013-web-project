<%@page import="service.DAOService"%>
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

	List<ProductType> list = request.getAttribute("listproducttype") == null ? new ArrayList<ProductType>()
			: (List<ProductType>) request
					.getAttribute("listproducttype");

	List<Product> listProduct = request.getAttribute("listproduct") == null ? new DAOService<Product, Integer>(
			new ProductDAO()).listObject() : (List<Product>) request
			.getAttribute("listproduct");
	ProductType pt = request.getAttribute("producttype") == null ? new ProductType(
			"") : (ProductType) request.getAttribute("producttype");

	int count = request.getAttribute("count") == null ? 1
			: (Integer) request.getAttribute("count");
	int index = request.getAttribute("index") == null ? 1
			: (Integer) request.getAttribute("index");
	String contextPath = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Thực Đơn</title>
<link rel="shortcut icon" href="<%=contextPath%>image/icon/icon.png" />

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/3-col-portfolio.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">
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
				<a class="navbar-brand" href="home.jsp">Nhà Hàng Jamie Oliver's</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">Home</a></li>
					<li class="active"><a href="Menu">Thực Đơn</a></li>
					<li><a href="lienhe.jsp">Liên Hệ</a></li>
					<li><a href="order/cartview.jsp">Giỏ Hàng</a></li>

					<jsp:include page="header.jsp"></jsp:include>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<p class="lead">Thực Đơn</p>
				<div class="list-group">
					<%
						for (ProductType ptype : list) {
							String c = "";
							if (pt != null) {
								if (pt.getDescription().equals(ptype.getDescription())) {
									c = "active";
								}
							}
					%>

					<a class="list-group-item <%=c%>"
						href="Menu?producttype=<%=ptype.getProductTypeId()%>"
						title="Món ăn"><%=ptype.getDescription()%></a>

					<%
						}
					%>
				</div>
			</div>
			<div class="col-md-9">
				<div class="row carousel-holder">

					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image"
										src="<%=contextPath%>image/menu-slide/img1.jpg">
								</div>
								<div class="item">
									<img class="slide-image"
										src="<%=contextPath%>image/menu-slide/img2.jpg">
								</div>
								<div class="item">
									<img class="slide-image"
										src="<%=contextPath%>image/menu-slide/img3.jpg">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>
				<div class="row">
					<%
						for (Product product : listProduct) {
					%>
					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
							<a href="ProductInfo?product=<%=product.getProductId()%>"><img
								src="<%=product.getImagePath()%>" alt=""></a>
							<div class="caption">
								<h4 class="pull-right">
									Giá:
									<%=product.getPrice()%></h4>
								<h4>
									<a href="ProductInfo?product=<%=product.getProductId()%>"><%=product.getProductName()%></a>
								</h4>
								<p><%=product.getDescription()%></p>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
				<div class="center-block">
					<ul class="pagination">
						<%
							int next = index == count ? count : (index + 1);
							int prev = index == 1 ? 1 : index - 1;
							String productTypeId = pt.getProductTypeId() == null ? "" : pt
									.getProductTypeId().toString();
						%>
						<li><a
							href="Menu?index=<%=prev%>&producttype=<%=productTypeId%>">&laquo;</a></li>

						<%
							for (int i = 0; i < count; i++) {
								String c = ((i + 1) == index) ? "active" : "";
						%>
						<li class="<%=c%>"><a
							href="Menu?index=<%=(i + 1)%>&producttype=<%=productTypeId%>"><%=(i + 1)%></a></li>
						<%
							}
						%>
						<li><a
							href="Menu?index=<%=next%>&producttype=<%=productTypeId%>">&raquo;</a></li>

					</ul>
				</div>

			</div>
		</div>
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