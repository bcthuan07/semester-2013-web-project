<%@page import="model.User"%>
<%@page import="service.DAOService"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductTypeDAO"%>
<%@page import="model.ProductType"%>
<%@page import="dao.GeneralDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
	DAOService<ProductType, Integer> dao = new DAOService<ProductType, Integer>(
			new ProductTypeDAO());
	List<ProductType> list = dao.listObject();

	String path = request.getContextPath() + "/manage/";

	String name_err = request.getAttribute("name_err") == null ? ""
			: (String) request.getAttribute("name_err");
	String description_err = request.getAttribute("description_err") == null ? ""
			: (String) request.getAttribute("description_err");
	String price_err = request.getAttribute("price_err") == null ? ""
			: (String) request.getAttribute("price_err");
	String quantity_err = request.getAttribute("quantity_err") == null ? ""
			: (String) request.getAttribute("quantity_err");
	String image_err = request.getAttribute("image_err") == null ? ""
			: (String) request.getAttribute("image_err");
	
	String contextPath = request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Thêm Sản Phẩm - Admin</title>

<!-- Bootstrap core CSS -->
<link href="<%=path%>css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="<%=path%>css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="<%=path%>font-awesome/css/font-awesome.min.css">
<!-- Page Specific CSS -->
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
</head>

<body>

	<div id="wrapper">

		<!-- Sidebar -->

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=contextPath%>Manage">Thống Kê</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="<%=contextPath %>Manage"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>
					<li><a href="<%=contextPath%>Manage/User"><i
							class="fa fa-bar-chart-o"></i> Người Dùng</a></li>
					<li><a href="<%=contextPath%>Manage/Order"><i class="fa fa-table"></i>
							Hóa Đơn</a></li>
					<li class="active"><a href="<%=contextPath%>Manage/Product"><i
							class="fa fa-edit"></i> Sản Phẩm</a></li>
					<li><a href="<%=contextPath%>Manage/Image"><i
							class="fa fa-edit"></i> Hình Ảnh</a></li>
					<li><a href="<%=contextPath%>Manage/Ad"><i
							class="fa fa-edit"></i> Quảng Cáo</a></li>
				</ul>
				<jsp:include page="admin-header.jsp"></jsp:include>
			</div>
		</nav>
		<div id="page-wrapper">
			<h1>Thêm Sản Phẩm</h1>
			<form action="<%=request.getContextPath()%>/Manage/AddProduct"
				method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="pro">Tên: </label> <input name="productname"
						type="text" class="form-control" id="pro">
					<p class="help-block"><%=name_err%></p>
				</div>

				<div class="form-group">
					<label for="description">Mô tả sản phẩm:</label> <input
						class="form-control" type="text" name="description"
						id="description">
				</div>
				<div class="devider"></div>

				<div class="form-group">
					<label for="fn">Ảnh trưng bày </label> <input name="image"
						class="form-control" id="fn" type="file">

					<p class="help-block"><%=image_err%></p>
				</div>

				<div class="form-group">
					<label for="pt">Loại Sản Phẩm:</label> <select id="pt"
						class="form-control" name="producttype">
						<%
							for (ProductType pt : list) {
						%>
						<option value="<%=pt.getProductTypeId()%>"><%=pt.getDescription()%></option>
						<%
							}
						%>
					</select>
				</div>

				<div class="form-group">
					<label for="price">Giá: </label> <input name="price"
						class="form-control" id="price" type="text">
					<p class="help-block"><%=price_err%></p>
				</div>

				<div class="form-group">
					<label for="quantity">Số Lượng Sản Phẩm:</label> <input
						class="form-control" id="quantity" name="quantity" type="number">
					<p class="help-block"><%=quantity_err%></p>
				</div>

				<input class="form-control" type="submit" value="Thêm">
			</form>
		</div>
	</div>
	<!-- JavaScript -->
	<script src="<%=path%>js/jquery-1.10.2.js"></script>
	<script src="<%=path%>js/bootstrap.js"></script>

	<!-- Page Specific Plugins -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
	<script src="<%=path%>js/morris/chart-data-morris.js"></script>
	<script src="<%=path%>js/tablesorter/jquery.tablesorter.js"></script>
	<script src="<%=path%>js/tablesorter/tables.js"></script>
</body>
</html>