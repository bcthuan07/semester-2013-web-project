<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath() + "/";
	String path = request.getContextPath() + "/manage/";
	String error1 = request.getAttribute("error1") == null ? ""
			: (String) request.getAttribute("error1");
	String error2 = request.getAttribute("error2") == null ? ""
			: (String) request.getAttribute("error2");
	String error3 = request.getAttribute("error3") == null ? ""
			: (String) request.getAttribute("error3");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Quản Lý Hình Ảnh - Admin</title>

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
		<h1>Trang Chủ</h1>
		
					<div class="row">
				<img class="" src="<%=contextPath%>image/home/img1.jpg">
				<form action="<%=contextPath%>Manage/EditImage" method="post">
					<input type="hidden" name="index" value="1"> <input
						type="file" name="image"> <input type="submit" value="Đổi">
				</form>
			</div>
			<div class="row">
				<img class="" src="<%=contextPath%>image/home/img2.jpg">

				<form action="<%=contextPath%>Manage/EditImage" method="post">
					<input type="hidden" name="index" value="2"> <input
						type="file" name="image"> <input type="submit" value="Đổi">
				</form>

			</div>
			<div class="row">
				<img class="" src="<%=contextPath%>image/home/img3.jpg">

				<form action="<%=contextPath%>Manage/EditImage" method="post">
					<input type="hidden" name="index" value="3"> <input
						type="file" name="image"> <input type="submit" value="Đổi">
				</form>

			</div>
		
		
		<h1>Menu</h1>
			<div class="row">
				<img class="" src="<%=contextPath%>image/menu-slide/img1.jpg">
				<form action="<%=contextPath%>Manage/EditImage" method="post">
					<input type="hidden" name="index" value="4"> <input
						type="file" name="image"> <input type="submit" value="Đổi">
				</form>
			</div>
			<div class="row">
				<img class="" src="<%=contextPath%>image/menu-slide/img2.jpg">

				<form action="<%=contextPath%>Manage/EditImage" method="post">
					<input type="hidden" name="index" value="5"> <input
						type="file" name="image"> <input type="submit" value="Đổi">
				</form>

			</div>
			<div class="row">
				<img class="" src="<%=contextPath%>image/menu-slide/img3.jpg">

				<form action="<%=contextPath%>Manage/EditImage" method="post">
					<input type="hidden" name="index" value="6"> <input
						type="file" name="image"> <input type="submit" value="Đổi">
				</form>

			</div>
		</div>
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
