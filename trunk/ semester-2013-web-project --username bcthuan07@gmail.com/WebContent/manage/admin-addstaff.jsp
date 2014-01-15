<%@page import="dao.CityDAO"%>
<%@page import="dao.PaymentMethodDAO"%>
<%@page import="model.PaymentMethod"%>
<%@page import="model.City"%>
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

	String path = request.getContextPath() + "/manage/";
	String contextPath = request.getContextPath() + "/";

	String username = request.getAttribute("username") != null ? (String) request
			.getAttribute("username") : "";
	String phonenumber = request.getAttribute("phonenumber") != null ? (String) request
			.getAttribute("phonenumber") : "";
	String fullname = request.getAttribute("fullname") != null ? (String) request
			.getAttribute("fullname") : "";
	String email = request.getAttribute("email") != null ? (String) request
			.getAttribute("email") : "";
	String street = request.getAttribute("street") != null ? (String) request
			.getAttribute("street") : "";
	String buildingnumber = request.getAttribute("buildingnumber") != null ? (String) request
			.getAttribute("buildingnumber") : "";

	String username_err = request.getAttribute("username_err") != null ? (String) request
			.getAttribute("username_err") : "";
	String phonenumber_err = request.getAttribute("phonenumber_err") != null ? (String) request
			.getAttribute("phonenumber_err") : "";
	String fullname_err = request.getAttribute("fullname_err") != null ? (String) request
			.getAttribute("fullname_err") : "";
	String email_err = request.getAttribute("email_err") != null ? (String) request
			.getAttribute("email_err") : "";
	String street_err = request.getAttribute("street_err") != null ? (String) request
			.getAttribute("street_err") : "";
	String buildingnumber_err = request
			.getAttribute("buildingnumber_err") != null ? (String) request
			.getAttribute("buildingnumber_err") : "";
	String password_err = request.getAttribute("password_err") != null ? (String) request
			.getAttribute("password_err") : "";

	DAOService<City, Integer> service = new DAOService<City, Integer>(
			new CityDAO());
	List<City> list = service.listObject();
	DAOService<PaymentMethod, Integer> paymentList = new DAOService<PaymentMethod, Integer>(
			new PaymentMethodDAO());
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
			<h1>Thêm Nhân Viên</h1>
			<form action="<%=request.getContextPath()%>/Manage/AddStaff"
				method="post" class="form-horizontal">
				<div class="well">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">Username:</label>
						<div class="col-sm-5">
							<input type="text" class=" form-control" id="username"
								placeholder="Username" name="username" value="<%=username%>">
							<p class="help-block"><%=username_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">Password:</label>
						<div class="col-sm-5">
							<input type="password" class="form-control" id="password"
								placeholder="Password" name="password">
							<p class="help-block"><%=password_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="fullname" class="col-sm-2 control-label">Họ và
							tên:</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="fullname"
								placeholder="Họ và tên" name="fullname" value="<%=fullname%>">
							<p class="help-block"><%=fullname_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email:</label>
						<div class="col-sm-5">
							<input type="email" class="form-control" id="email"
								placeholder="Email" name="email" value="<%=email%>">
							<p class="help-block"><%=email_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-2 control-label">Số Điện
							Thoại:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="phone"
								placeholder="Số Điện Thoại" name="phonenumber"
								value="<%=phonenumber%>">
							<p class="help-block"><%=phonenumber_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="gend" class="col-sm-2 control-label">Giới
							Tính:</label>
						<div class="col-sm-6" id="gend">
							<label class="radio-inline"> <input type="radio"
								value="Nam" name="gender" checked="checked"> Nam
							</label> <label class="radio-inline"> <input type="radio"
								value="Nu" name="gender" checked="checked"> Nữ
							</label>
						</div>
					</div>
				</div>
				<h4>Thông tin liên hệ</h4>
				<div class="well">
					<div class="form-group">
						<label for="buildingnumber" class="col-sm-2 control-label">Số
							Nhà:</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="buildingnumber"
								placeholder="Số Nhà" name="buildingnumber"
								value="<%=buildingnumber%>">
							<p class="help-block"><%=buildingnumber_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="street" class="col-sm-2 control-label">Đường:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="street"
								placeholder="Tên đường" name="street" value="<%=street%>">
							<p class="help-block"><%=street_err%></p>
						</div>
					</div>
					<div class="form-group">
						<label for="city" class="col-sm-2 control-label">Thành
							Phố:</label>
						<div class="col-sm-3">
							<select id="city" class="form-control" name="city">
								<%
									for (City c : list) {
								%>
								<option value="<%=c.getId()%>"><%=c.getName()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="payment" class="col-sm-2 control-label">Hình
							thức thanh toán:</label>
						<div class="col-sm-3">
							<select id="payment" name="payment" class="form-control">
								<%
									for (PaymentMethod p : paymentList.listObject()) {
								%>
								<option value="<%=p.getPaymentMethodId()%>"><%=p.getDescription()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-2 col-sm-offset-2">
							<input type="submit" class="form-control" value="Đăng Ký">
						</div>
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