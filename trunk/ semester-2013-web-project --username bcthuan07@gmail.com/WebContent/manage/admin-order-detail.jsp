<%@page import="dao.OrderStatusDAO"%>
<%@page import="model.OrderStatus"%>
<%@page import="model.UserOrder"%>
<%@page import="model.Feedback"%>
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
	String path = request.getContextPath() + "/manage/";
	String contextPath = request.getContextPath() + "/";
	List<OrderStatus> orderStatus = new DAOService<OrderStatus, Integer>(
			new OrderStatusDAO()).listObject();
	UserOrder order = (UserOrder) request.getAttribute("order");
	if (order == null)
		response.sendRedirect(path + "admin-order.jsp");
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
							Người Dùng<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="<%=contextPath%>Manage/Staff"> Nhân Viên</a></li>
							<li><a href="<%=contextPath%>Manage/Customer"> Khách
									Hàng</a></li>
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
			<div class="row">
				<div class="col-lg-12">
					<h2>Chi tiết hóa đơn</h2>
					<ol class="breadcrumb">
						<li><a href="<%=contextPath %>Manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li><i class="fa fa-table"></i> Hóa Đơn</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<hr>
				<div class="col-lg-9">
					<div class="well">
						<form action="<%=contextPath%>Manage/UpdateOrder" method="post">
							<div class="row" style="margin-bottom: 10px;">
								<label class="col-sm-3">Tên Khách Hàng</label>
								<div class="col-sm-6">
									<a href="" class="form-control"><%=order.getUser().getFullname()%></a>
								</div>


							</div>

							<div class="row">
								<label class="col-sm-3">Ngày Lập Hóa Đơn</label>
								<div class="col-sm-6">
									<p class="form-control"><%=order.getOrderDate().toString()%></p>
								</div>
							</div>
							<div class="row">
								<label class="col-sm-3">Tổng Tiền</label>
								<div class="col-sm-6">
									<p class="form-control"><%=order.getAmount().toString()%></p>
								</div>
							</div>
							<div class="row">
								<label class="col-sm-3">Tình trạng:</label>
								<div class="col-sm-7">
									<input type="hidden" name="idOrder"
										value="<%=order.getUserOrderId()%>"> <select
										name="idStatus" class="form-control">
										<%
											Integer id = order.getOrderStatus().getOrderStatusId();
										%>

										<%
											for (OrderStatus os : orderStatus) {
												String s = os.getOrderStatusId().equals(id) ? "selected" : "";
										%>
										<option value="<%=os.getOrderStatusId()%>" <%=s%>><%=os.getDescription()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-3 col-sm-offset-3" style="margin-top: 20px;">
									<input type="submit" value="Cập Nhật" class="btn btn-success">
								</div>
							</div>
						</form>
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