<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="service.DAOService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
	List<Product> listproduct = request.getAttribute("listproduct") == null ? new ArrayList<Product>()
			: (List<Product>) request.getAttribute("listproduct");
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
					<h1>
						Sản Phẩm <small>Sort Your Data</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="Manage"><i class="fa fa-dashboard"></i>
								Thống Kê</a></li>
						<li class="active"><i class="fa fa-table"></i> Sản Phẩm</li>
					</ol>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-10">
					<h2>Sản Phẩm</h2>
					<div class="table-responsive">
						<table
							class="table table-bordered table-hover table-striped tablesorter">
							<thead>
								<tr>
									<th>Tên<i class="fa fa-sort"></i></th>
									<th>Mô tả<i class="fa fa-sort"></i></th>
									<th>Giá<i class="fa fa-sort"></i></th>
									<th>Loại<i class="fa fa-sort"></i></th>
									<th>Số Lượng<i class="fa fa-sort"></i></th>
									<th>Hình Ảnh<i class="fa fa-sort"></i></th>
									<th>Thao Tác</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Product p : listproduct) {
								%>
								<tr>
									<td><%=p.getProductName() %></td>
									<td><%=p.getDescription() %></td>
									<td><%=p.getPrice() %></td>
									<td><%=p.getProductType().getDescription() %></td>
									<td><%=p.getQuantity() %></td>
									<td><%=p.getImagePath() %></td>
									<td><code><a href="DeleteProduct?product=<%=p.getProductId() %>" class="btn btn-danger">Xóa</a>
										<a href="" class="btn btn-primary">Sửa</a></code>
									</td>
									
								<tr>
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