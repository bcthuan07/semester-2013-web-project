<%@page import="java.util.ArrayList"%>
<%@page import="model.Ads"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath() + "/";
	String path = contextPath + "manage/";

	List<Ads> list = request.getAttribute("listads") == null ? new ArrayList<Ads>()
			: (List<Ads>) request.getAttribute("listads");
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
<link href="<%=path %>css/bootstrap.css" rel="stylesheet">

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
							class="fa fa-bar-chart-o"></i> Khách Hàng</a></li>
					<li><a href="<%=contextPath%>Manage/Order"><i
							class="fa fa-table"></i> Hóa Đơn</a></li>
					<li><a href="<%=contextPath%>Manage/Product"><i
							class="fa fa-edit"></i> Sản Phẩm</a></li>

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
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<%for(Ads a: list){ %>
				<p><%=a.getName() %></p>
				<p><%=a.getLink() %></p>
				<p><%=a.getContent() %></p>
				<img alt="Ảnh" src="<%=contextPath %><%=a.getImagePath()%>">
				<a href="<%=contextPath %>Manage/AdDetail?ad=<%=a.getId() %>">Chỉnh Sửa</a>
				<br><br>
				
				<%} %>
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
