
<%@page import="model.Ads"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath() + "/";
	String path = contextPath + "manage/";

	Ads ads = (Ads) request.getAttribute("ads");
	String name = ads == null ? "" : ads.getName();
	String link = ads == null ? "" : ads.getLink();
	String content = ads == null ? "" : ads.getContent();
	String imagePath = ads == null ? "" : ads.getImagePath();

	String name_err = request.getAttribute("name_err") == null ? ""
			: (String) request.getAttribute("name_err");
	String link_err = request.getAttribute("link_err") == null ? ""
			: (String) request.getAttribute("link_err");
	String content_err = request.getAttribute("content_err") == null ? ""
			: (String) request.getAttribute("content_err");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Quản Lý - SB Admin</title>

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
				<a class="navbar-brand" href="<%=path%>manage.jsp">Thống Kê</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="<%=contextPath%>Manage"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>
					<li><a href="<%=contextPath%>Manage/User"><i
							class="fa fa-bar-chart-o"></i> Người Dùng</a></li>
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
						</ul>
				</ul>

				<jsp:include page="admin-header.jsp"></jsp:include>
			</div>
		</nav>
		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h1>
						Thống Kê <small>Quảng cáo</small>
					</h1>
					<ol class="breadcrumb">
						<li><i class="fa fa-dashboard"></i> Thống kê</li>
						<li><i class="fa fa-dashboard"></i> Cài đặt</li>
						<li class="active"><i class="fa fa-dashboard"></i> Quảng cáo</li>
					</ol>
				</div>
			</div>
			<!-- /.row -->
			<h2>Thông tin chi tiết quảng cáo</h2>
			<hr>
			<div class="col-sm-9 well">
				<form action="<%=contextPath%>Manage/EditAd" method="post"
					class="form-horizontal" enctype="multipart/form-data">
					<input type="hidden" name="id" value="<%=ads.getId()%>">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Tên</label>
						<div class="col-sm-4">
							<input class="form-control" type="text" name="name" id="name"
								value="<%=name%>">
							<p class="help-block"><%=name_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="img" class="col-sm-2 control-label">Hình Ảnh</label>
						<div class="col-sm-3">
							<input class="form-control" type="file" name="image" id="img">

						</div>
						<div class="col-sm-6">
							<p class="help-block">Kích thước hình ảnh phải có kích cỡ là
								140x140px</p>
						</div>
					</div>
					<div class="form-group">
						<label for="link" class="col-sm-2 control-label">Đường dẫn</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name="link" id="link"
								value="<%=link%>">
							<p class="help-block"><%=link_err%></p>
						</div>
					</div>

					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">Nội
							dung</label>
						<div class="col-sm-6">
							<textarea class="form-control" name="content" id="content"
								rows="4"><%=content%></textarea>
							<p class="help-block"><%=content_err%></p>
						</div>
					</div>


					<div class="form-group">
						<div class=" col-sm-2 col-sm-offset-2">
							<input class="form-control" type="submit" value="Lưu">
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

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
