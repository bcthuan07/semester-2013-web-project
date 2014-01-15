<%@page import="dao.OrderStatusDAO"%>
<%@page import="service.DAOService"%>
<%@page import="model.OrderStatus"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserOrder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath() + "/";
	String path = contextPath + "manage/";
	List<UserOrder> listUserOrders = request.getAttribute("listorder") == null ? new ArrayList<UserOrder>()
			: (List<UserOrder>) request.getAttribute("listorder");
	List<OrderStatus> orderStatus = new DAOService<OrderStatus, Integer>(
			new OrderStatusDAO()).listObject();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Quản Lý - Hóa Đơn</title>
<link rel="shortcut icon" href="<%=contextPath %>image/icon/icon.png" />

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
					<li><a href="<%=contextPath%>Manage"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>
					<li class="active"><a href="<%=contextPath%>Manage/Order"><i
							class="fa fa-table"></i> Hóa Đơn</a></li>
					<li><a href="<%=contextPath%>Manage/Feedback"><i
							class="fa fa-edit"></i> Phản Hồi</a></li>
				</ul>


				<jsp:include page="admin-header.jsp"></jsp:include>
			</div>
		</nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h2>Hóa Đơn</h2>
					<ol class="breadcrumb">
						<li><a href="Manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li class="active"><i class="fa fa-table"></i> Sản Phẩm</li>
					</ol>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<hr>
					<div class="table-responsive">
						<form method="post" action="<%=contextPath%>Manage/UpdateOrder">

							<table
								class="table table-bordered table-hover table-striped tablesorter">
								<thead>
									<tr>
										<th><i class="fa fa-sort"></i>Tên khách hàng</th>
										<th><i class="fa fa-sort"></i>Tình trạng thanh toán</th>
										<th><i class="fa fa-sort"></i>Ngày Lập</th>
										<th>Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (UserOrder userOrder : listUserOrders) {
									%>
									<tr>
										<td><%=userOrder.getUser().getFullname()%></td>
										<td><%=userOrder.getOrderStatus().getDescription()%></td>
										<td><%=userOrder.getOrderDate()%></td>
										<td><a class="btn btn-primary"
											href="<%=contextPath%>Manage/OrderDetail?idOrder=<%=userOrder.getUserOrderId()%>">Chi
												tiết</a><a class="btn btn-danger"
											style="width: 100px; margin-left: 10px;"
											href="<%=contextPath%>Manage/DeleteUserOrder?userorder=
										<%=userOrder.getUserOrderId()%>"
											onclick="return confirm('Bạn chắc chắn muốn xóa trường này chứ? \nThao tác này không thể undo')">Xóa</a></td>

									</tr>
									<%
										}
									%>
								</tbody>
							</table>
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