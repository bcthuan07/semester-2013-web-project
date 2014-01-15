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
	String image_err = request.getAttribute("image_err") == null ? ""
			: (String) request.getAttribute("image_err");
	String description = request.getAttribute("description") == null ? ""
			: (String) request.getAttribute("description");

	String contextPath = request.getContextPath() + "/";
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
<link rel="shortcut icon" href="<%=contextPath %>image/icon/icon.png" />

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
					<li class="active"><a href="<%=contextPath%>Manage"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Người Dùng <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<%=contextPath%>Manage/Staff">Nhân Viên</a></li>
							<li><a href="<%=contextPath%>Manage/Customer">Khách Hàng</a></li>
						</ul></li>
					<li><a href="<%=contextPath%>Manage/Order"><i
							class="fa fa-table"></i> Hóa Đơn</a></li>
					<li><a href="<%=contextPath%>Manage/Product"><i
							class="fa fa-edit"></i> Sản Phẩm</a></li>
					<li><a href="<%=contextPath%>Manage/Feedback"><i
							class="fa fa-edit"></i> Phản Hồi</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Cài đặt <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<%=contextPath%>Manage/Image">Hình ảnh</a></li>
							<li><a href="<%=contextPath%>Manage/Ad">Quảng cáo</a></li>
						</ul></li>
				</ul>
				<jsp:include page="admin-header.jsp"></jsp:include>
			</div>
		</nav>
		<div id="page-wrapper">
			<h1>Thêm Sản Phẩm</h1>
			<form action="<%=request.getContextPath()%>/Manage/AddProduct"
				method="post" enctype="multipart/form-data" class="form-horizontal">
				<div class="form-group">
					<label for="pro" class="col-sm-2 control-label">Tên: </label>
					<div class="col-sm-5">
						<input name="productname" type="text" class="form-control"
							id="pro">
						<p class="help-block"><%=name_err%></p>
					</div>
				</div>


				<div class="form-group">
					<label for="fn" class="col-sm-2 control-label">Ảnh trưng
						bày </label>
					<div class="col-sm-2">
						<input name="image" class="form-control" id="fn" type="file">
						<p class="help-block"><%=image_err%></p>
					</div>
				</div>

				<div class="form-group">
					<label for="pt" class="col-sm-2 control-label">Loại Sản
						Phẩm:</label>
					<div class="col-sm-4">
						<select id="pt" class="form-control" name="producttype">
							<%
								for (ProductType pt : list) {
							%>
							<option value="<%=pt.getProductTypeId()%>"><%=pt.getDescription()%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="price" class="col-sm-2 control-label">Giá: </label>
					<div class="col-sm-4">
						<input name="price" class="form-control" id="price" type="text">
						<p class="help-block"><%=price_err%></p>
					</div>
				</div>
				<div class="form-group">
					<label for="description" class="col-sm-2 control-label">Mô
						tả sản phẩm:</label>
					<div class="col-sm-7">
						<textarea rows="6" class="form-control" name="description"
							id="description"><%=description%></textarea>
						<p class="help-block"><%=description_err%></p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-2 col-sm-offset-2">
						<input class="form-control btn btn-success" type="submit"
							value="Thêm">
					</div>
				</div>
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