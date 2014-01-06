<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<%@page import="service.DAOService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");

	List<User> listCustomer = request.getAttribute("listcustomer") == null ? new ArrayList<User>()
			: (List<User>) request.getAttribute("listcustomer");
	List<User> listStaff = request.getAttribute("liststaff") == null ? new ArrayList<User>()
			: (List<User>) request.getAttribute("liststaff");
	String path = request.getContextPath() + "/manage/";
	String contextPath = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Quản Lý - Hóa Đơn</title>

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
					<li class="active"><a href="<%=contextPath%>Manage"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>
					<li><a href="<%=contextPath%>Manage/User"><i
							class="fa fa-bar-chart-o"></i> Người Dùng</a></li>
					<li><a href="<%=contextPath%>Manage/Order"><i
							class="fa fa-table"></i> Hóa Đơn</a></li>
					<li><a href="<%=contextPath%>Manage/Product"><i
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
					<h1>Người Dùng</h1>
					<ol class="breadcrumb">
						<li><a href="Manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li class="active"><i class="fa fa-table"></i> Sản Phẩm</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-7">
					<h2>Khách Hàng</h2>
					<div class="table-responsive">
						<table
							class="table table-bordered table-hover table-striped tablesorter">
							<thead>
								<tr>
									<th><i class="fa fa-sort"></i>Tên</th>
									<th><i class="fa fa-sort"></i>Username</th>
									<th><i class="fa fa-sort"></i>Hình Thức Thanh Toán</th>
									<th><i class="fa fa-sort"></i>Email</th>
									<th><i class="fa fa-sort"></i>Ngày Tạo</th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (User c : listCustomer) {
										String payment = c.getPaymentMethod().getDescription() == null ? ""
												: c.getPaymentMethod().getDescription();
								%>
								<tr>
									<td><%=c.getFullname()%></td>
									<td><%=c.getUsername()%></td>
									<td><%=payment %></td>
									<td><%=c.getEmail()%></td>
									<td><%=c.getDatecreated()%></td>
									<td><a href="Manage/DeleteUser?user=<%=c.getUserId()%>"
										class="btn btn-danger">Xóa</a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-5">
						<h2>Nhân Viên</h2>
						<div class="table-responsive">
							<table
								class="table table-bordered table-hover table-striped tablesorter">
								<thead>
									<tr>
										<th><i class="fa fa-sort"></i>Tên</th>
										<th><i class="fa fa-sort"></i>Username</th>
										<th><i class="fa fa-sort"></i>Email</th>
										<th><i class="fa fa-sort"></i>Ngày Đăng Ký</th>
										<th>Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (User c : listStaff) {
									%>
									<tr>
										<td><%=c.getFullname()%></td>
										<td><%=c.getUsername()%></td>
										<td><%=c.getEmail()%></td>
										<td><%=c.getDatecreated()%></td>
										<td><a href="Manage/DeleteUser?user=<%=c.getUserId()%>"
											class="btn btn-danger">Xóa</a></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
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