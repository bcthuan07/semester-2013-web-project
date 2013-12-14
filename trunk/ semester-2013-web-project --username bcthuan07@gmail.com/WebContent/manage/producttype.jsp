<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="dao.ProductTypeDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductType"%>
<%@page import="service.DAOService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
	List<ProductType> listProductTypes = request
			.getAttribute("listproducttype") == null ? new ArrayList<ProductType>()
			: (List<ProductType>) request
					.getAttribute("listproducttype");
	String error = "";
	if (request.getAttribute("error") != null)
		error = (String) request.getAttribute("error");
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
				<div class="col-lg-8">
					<h2>Sản Phẩm</h2>
					<form action="<%=request.getContextPath()%>/AddProductType"
						method="post">

						<div class="table-responsive">
							<table
								class="table table-bordered table-hover table-striped tablesorter">
								<thead>
									<tr>
										<th>STT<i class="fa fa-sort"></i></th>
										<th>Loại<i class="fa fa-sort"></i></th>
										<th>Thao Tác</th>
									<tr>
								</thead>
								<tbody>
									<%
										int count = 0;
										for (ProductType pt : listProductTypes) {
											count++;
									%>
									<tr>
										<td><%=count%></td>
										<td><%=pt.toString()%></td>
										<td><a href="DeleteProductType?pt=<%=pt.getProductTypeId() %>" class="btn btn-danger">Xóa</a></td>
									</tr>

									<%
										}
									%>
									<tr>
										<td>
											<div class="form-group">
												<label for="des">Thêm loại sản phẩm:</label> <input
													type="text" name="description" class="form-control"
													id="des">
												<p class="help-block"><%=error%></p>
											</div>
										</td>
										<td><input class="form-control" type="submit"
											value="Thêm"></td>
								</tbody>
							</table>
						</div>

					</form>
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