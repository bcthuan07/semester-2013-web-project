<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	Product product = (Product) request.getAttribute("product");
	String name = "";
	String description = "";
	String type = "";
	String price = "";
	String id = "";
	String number_err = "";
	String quantity = "";
	if (product != null) {
		name = product.getProductName();
		description = product.getDescription();
		type = product.getProductType().getDescription();
		price = product.getPrice().toString();
		id = product.getProductId() + "";

	}
	if (request.getAttribute("number_err") != null) {
		number_err = (String) request.getAttribute("number_err");
	}
	String contextPath = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title><%=product.getProductName()%></title>
<link rel="shortcut icon" href="<%=contextPath %>image/icon/icon.png" />

<!-- Bootstrap core CSS -->
<link href="<%=contextPath%>css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link href="<%=contextPath%>css/3-col-portfolio.css" rel="stylesheet">
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
				<a class="navbar-brand" href="<%=contextPath%>home.jsp">Nhà Hàng
					Jamie's Oliver</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">Trang Chủ</a></li>
					<li><a href="Menu">Thực Đơn</a></li>
					<li><a href="lienhe.jps">Liên Hệ</a></li>
					<li><a href="<%=contextPath%>order/cartview.jsp">Giỏ Hàng</a></li>

					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<br> <br> <br>
		<div class="row">
			<div class="col-md-4">
				<a href="ProductInfo?product=<%=product.getProductId()%>"><img
					class="img-responsive"
					src="<%=contextPath%><%=product.getImagePath()%>"></a>
			</div>
			<div class="col-md-7">
				<div class="well">
					<div class="row">
						<label class="col-sm-3">Tên Sản Phẩm:</label>
						<div class="col-sm-3">
							<span class="form-control"><%=name%></span>
						</div>
					</div>
					<br>
					<div class="row">
						<label class="col-sm-3">Loại</label>
						<div class="col-sm-4">
							<span class="form-control"><%=type%></span>
						</div>
					</div>
					<br>
					<div class="row">
						<label class="col-sm-3">Giá Tiền:</label>
						<div class="col-sm-4">
							<span class="form-control"><%=price%></span>
						</div>
					</div><br>
					<form action="ChooseProduct" method="post">
						<div class="row">
							<label class="col-sm-3">Số Lượng Muốn Mua:</label> <input
								type="hidden" name="id" value="<%=id%>">
							<div class="col-sm-4">
								<input class="form-control" type="number" name="number"
									value="1">
								<p class="help-block"><%=number_err%></p>
							</div>
						</div><br>
						<div class="row">
							<div class="col-sm-2 col-sm-offset-3">
								<input class="btn btn-primary" type="submit"
									value="Thêm vào giỏ hàng">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>