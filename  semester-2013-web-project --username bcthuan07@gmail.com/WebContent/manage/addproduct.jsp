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
	DAOService<ProductType, Integer> dao = new DAOService<ProductType, Integer>(
			new ProductTypeDAO());
	List<ProductType> list = dao.listObject();

	String path = request.getContextPath() + "/manage/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Quản Lý - SB Admin</title>

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
			<h1>Thêm Sản Phẩm</h1>
			<form action="<%=request.getContextPath()%>/AddProduct" method="post">
				<label for="pro">Tên: </label> <input name="productname" type="text"
					class="form-control" id="pro"> <label for="des">Mô
					Tả: </label> <input name="description" type="text" class="form-control"
					id="des"> <label for="fn">Ảnh trưng bày </label> <input
					name="firstname" class="form-control" id="fn" type="file">
				<label for="pt">Loại Sản Phẩm:</label> <select id="pt"
					class="form-control" name="producttype">
					<%
						for (ProductType pt : list) {
					%>
					<option value="<%=pt.getProductTypeId()%>"><%=pt.getDescription()%></option>
					<%
						}
					%>
				</select> <label for="price">Giá: </label> <input name="price"
					class="form-control" id="price" type="text"> <label
					for="quantity">Số Lượng Sản Phẩm:</label> <input
					class="form-control" id="quantity" name="quantity" type="number">
				<input class="form-control" type="submit" value="Thêm">
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