<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath() + "/";
	String path = contextPath + "manage/";

	String home1 = request.getAttribute("home1") == null ? ""
			: (String) request.getAttribute("home1");
	String home2 = request.getAttribute("home2") == null ? ""
			: (String) request.getAttribute("home2");
	String home3 = request.getAttribute("home3") == null ? ""
			: (String) request.getAttribute("home3");
	String menu1 = request.getAttribute("menu1") == null ? ""
			: (String) request.getAttribute("menu1");
	String menu2 = request.getAttribute("menu2") == null ? ""
			: (String) request.getAttribute("menu2");
	String menu3 = request.getAttribute("menu3") == null ? ""
			: (String) request.getAttribute("menu3");
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
				<a class="navbar-brand" href="<%=path%>manage.jsp">Thống Kê</a>
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
			<h1>Trang Chủ</h1>
			<div class="row">
				<div class="col-md-4">
					<img class="img-responsive"
						src="<%=contextPath%>image/home/img1.jpg">
					<form action="<%=contextPath%>Manage/EditImage" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<input type="hidden" name="index" value="1" /><input type="hidden"
								name="origin" value="image/home/img1.jpg"><label
								for="home1">Đổi</label> <input type="file" class="form-control"
								name="image" id="home1"> <input class="form-control"
								type="submit" value="Đổi">
						</div>
					</form>
				</div>
				<div class="col-md-4">
					<img class="img-responsive"
						src="<%=contextPath%>image/home/img2.jpg">
					<form action="<%=contextPath%>Manage/EditImage" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<input type="hidden" name="index" value="2"><input
								type="hidden" name="origin" value="image/home/img2.jpg"><label
								for="home2">Đổi</label> <input type="file" id="home2"
								class="form-control" name="image"> <input type="submit"
								value="Đổi" class="form-control">

						</div>
					</form>
				</div>
				<div class="col-md-4">
					<img class="img-responsive"
						src="<%=contextPath%>image/home/img3.jpg">
					<form action="<%=contextPath%>Manage/EditImage" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<input type="hidden" name="index" value="3"><input
								type="hidden" name="origin" value="image/home/img3.jpg">
							<label for="home3">Đổi</label> <input id="home3" type="file"
								class="form-control" name="image"> <input type="submit"
								class="form-control" value="Đổi">
						</div>
					</form>
				</div>
				<h1>Menu</h1>
				<div class="row">
					<div class="col-md-4">
						<img class="img-responsive"
							src="<%=contextPath%>image/menu-slide/img1.jpg">
						<form action="<%=contextPath%>Manage/EditImage" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<input type="hidden" name="index" value="4"><input
									type="hidden" name="origin" value="image/menu-slide/img1.jpg"><label
									for="menu1">Đổi</label> <input class="form-control" id="menu1"
									type="file" name="image"> <input type="submit"
									class="form-control" value="Đổi">
							</div>
						</form>
					</div>
					<div class="col-md-4">
						<img class="img-responsive"
							src="<%=contextPath%>image/menu-slide/img2.jpg">
						<form action="<%=contextPath%>Manage/EditImage" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<input type="hidden" name="index" value="5"><input
									type="hidden" name="origin" value="image/menu-slide/img2.jpg"><label
									for="menu2">Đổi</label> <input class="form-control" id="menu2"
									type="file" name="image"> <input type="submit"
									class="form-control" value="Đổi">
							</div>
						</form>
					</div>
					<div class="col-md-4">
						<img class="img-responsive"
							src="<%=contextPath%>image/menu-slide/img3.jpg">
						<form action="<%=contextPath%>Manage/EditImage" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<input type="hidden" name="index" value="6"><input
									type="hidden" name="origin" value="image/menu-slide/img3.jpg"><label
									for="menu3">Đổi</label> <input class="form-control" id="menu3"
									type="file" name="image"> <input type="submit"
									class="form-control" value="Đổi">
							</div>
						</form>
					</div>
				</div>
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
