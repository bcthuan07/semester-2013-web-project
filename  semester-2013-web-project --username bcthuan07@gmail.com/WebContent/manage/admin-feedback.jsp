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

	List<Feedback> listFeedback = request.getAttribute("listfeedback") == null ? new ArrayList<Feedback>()
			: (List<Feedback>) request.getAttribute("listfeedback");
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
<link rel="shortcut icon" href="<%=contextPath%>image/icon/icon.png" />

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
					<li class="active"><a href="<%=contextPath%>Manage/Feedback"><i
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
					<h1>Phản Hồi</h1>
					<ol class="breadcrumb">
						<li><a href="Manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li class="active"><i class="fa fa-table"></i> Phản Hồi</li>
					</ol>
				</div>
			</div>
			<div class="row">

				<div class="col-lg-12">
					<hr>
					<div class="table-responsive">
						<table
							class="table table-bordered table-hover table-striped tablesorter">
							<thead>
								<tr>
									<th><i class="fa fa-sort"></i>Họ và tên</th>
									<th><i class="fa fa-sort"></i>Email</th>
									<th><i class="fa fa-sort"></i>Nội dung phản hồi</th>
									<th><i class="fa fa-sort"></i>Ngày Tạo</th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Feedback c : listFeedback) {
								%>
								<tr>
									<td><%=c.getFullname()%></td>
									<td><%=c.getEmail()%></td>
									<%
										String content = c.getContent();
											if (content.length() > 40)
												content = content.subSequence(0, 40) + "....";
									%>
									<td><%=content%></td>
									<td><%=c.getDateCreated()%></td>
									<td><code>
											<a class="btn btn-primary"
												href="<%=contextPath%>Manage/FeedbackDetail?feedbackid=<%=c.getFeedbackId()%>">Chi
												tiết</a> <a class="btn btn-danger"
												href="<%=contextPath%>Manage/DeleteFeedback?feedbackid=<%=c.getFeedbackId()%>"
												onclick="return confirm('Bạn chắc chắn muốn xóa trường này chứ? \nThao tác này không thể undo')">Xóa</a>
										</code></td>
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