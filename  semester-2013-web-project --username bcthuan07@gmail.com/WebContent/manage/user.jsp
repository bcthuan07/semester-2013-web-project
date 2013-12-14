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
	String path = request.getContextPath() + "/manage/";
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
		<jsp:include page="admin-header.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1>Khách Hàng</h1>
					<ol class="breadcrumb">
						<li><a href="Manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li class="active"><i class="fa fa-table"></i> Sản Phẩm</li>
					</ol>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-8">
					<h2>Khách Hàng</h2>
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped tablesorter">
							<thead>
								<tr>
									<th><i class="fa fa-sort"></i>Tên</th>
									<th><i class="fa fa-sort"></i>Username</th>
									<th><i class="fa fa-sort"></i>Hình thức thanh toán</th>
									<th><i class="fa fa-sort"></i>Số ĐT</th>
									<th><i class="fa fa-sort"></i>Email</th>
									<th><i class="fa fa-sort"></i>Ngày Đăng Ký</th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>
								<%
									for(User c: listCustomer){
										String payment = c.getPaymentMethod().getDescription()==null?"": c.getPaymentMethod().getDescription();
								%>
								<tr>
									<td><%=c.getFullname() %></td>
									<td><%=c.getUsername() %></td>
									<td><%=payment %></td>
									<td><%=c.getPhoneNumber() %></td>
									<td><%=c.getEmail() %></td>
									<td><%=c.getDatecreated() %></td>
									<td><a href="DeleteUser?user=<%=c.getUserId() %>" class="btn btn-danger">Xóa</td>
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