<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");

	String totalUser = "";
	String totalProduct = "";
	String totalOrder = "";
	String totalOrderIncomplete = "";
	totalUser = request.getAttribute("totaluser") == null ? ""
			: (String) request.getAttribute("totaluser");
	totalProduct = request.getAttribute("totalproduct") == null ? ""
			: (String) request.getAttribute("totalproduct");
	totalOrder = request.getAttribute("totalorder") == null ? ""
			: (String) request.getAttribute("totalorder");
	totalOrderIncomplete = request.getAttribute("totalorderincomplete") == null ? ""
			: (String) request.getAttribute("totalorderincomplete");
	String path = request.getContextPath() + "/manage/";
	String contextPath = request.getContextPath()+"/";
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
<link href="css/bootstrap.css" rel="stylesheet">

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
					<li class="active"><a href="<%=contextPath %>Manage"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>
					<li><a href="<%=contextPath %>Manage/User"><i
							class="fa fa-bar-chart-o"></i> Người Dùng</a></li>
					<li><a href="<%=contextPath %>Manage/Order"><i
							class="fa fa-table"></i> Hóa Đơn</a></li>
					<li><a href="<%=contextPath %>Manage/Product"><i
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

			<div class="row">
				<div class="col-lg-12">
					<h1>
						Dashboard <small>Statistics Overview</small>
					</h1>
					<ol class="breadcrumb">
						<li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
					</ol>
					<div class="alert alert-success alert-dismissable">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">&times;</button>
						Welcome to SB Admin by <a class="alert-link"
							href="http://startbootstrap.com">Start Bootstrap</a>! Feel free
						to use this template for your admin needs! We are using a few
						different plugins to handle the dynamic tables and charts, so make
						sure you check out the necessary documentation links provided.
					</div>
				</div>
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-3">
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-6">
									<i class="fa fa-comments fa-5x"></i>
								</div>
								<div class="col-xs-6 text-right">
									<p class="announcement-heading"><%=totalUser%></p>
									<p class="announcement-text">User!</p>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer announcement-bottom">
								<div class="row">
									<div class="col-xs-6">View Mentions</div>
									<div class="col-xs-6 text-right">
										<i class="fa fa-arrow-circle-right"></i>
									</div>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="panel panel-warning">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-6">
									<i class="fa fa-check fa-5x"></i>
								</div>
								<div class="col-xs-6 text-right">
									<p class="announcement-heading"><%=totalOrder%></p>
									<p class="announcement-text">Hóa Đơn Đã Thanh Toán</p>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer announcement-bottom">
								<div class="row">
									<div class="col-xs-6">Complete Tasks</div>
									<div class="col-xs-6 text-right">
										<i class="fa fa-arrow-circle-right"></i>
									</div>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="panel panel-danger">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-6">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-6 text-right">
									<p class="announcement-heading"><%=totalOrderIncomplete%></p>
									<p class="announcement-text">Hóa đơn chưa thanh toán</p>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer announcement-bottom">
								<div class="row">
									<div class="col-xs-6">Fix Issues</div>
									<div class="col-xs-6 text-right">
										<i class="fa fa-arrow-circle-right"></i>
									</div>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="panel panel-success">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-6">
									<i class="fa fa-comments fa-5x"></i>
								</div>
								<div class="col-xs-6 text-right">
									<p class="announcement-heading"><%=totalProduct%></p>
									<p class="announcement-text">Sản phẩm!</p>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer announcement-bottom">
								<div class="row">
									<div class="col-xs-6">Complete Orders</div>
									<div class="col-xs-6 text-right">
										<i class="fa fa-arrow-circle-right"></i>
									</div>
								</div>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- /.row -->


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
