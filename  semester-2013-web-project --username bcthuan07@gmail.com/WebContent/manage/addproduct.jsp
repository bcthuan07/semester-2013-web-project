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

	User user = (User) session.getAttribute("user");
	boolean permission = user == null ? false : user.getPermission();
	if (!permission)
		response.sendRedirect("home.jsp");
	String username = user == null ? "" : user.getUsername();
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
<link href="css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
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
				<a class="navbar-brand" href="index.html">SB Admin</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="index.html"><i
							class="fa fa-dashboard"></i> Thống Kê</a></li>
					<li><a href="charts.html"><i class="fa fa-bar-chart-o"></i>
							Charts</a></li>
					<li><a href="tables.html"><i class="fa fa-table"></i>
							Tables</a></li>
					<li><a href="forms.html"><i class="fa fa-edit"></i> Forms</a></li>
					<li><a href="typography.html"><i class="fa fa-font"></i>
							Typography</a></li>
					<li><a href="bootstrap-elements.html"><i
							class="fa fa-desktop"></i> Bootstrap Elements</a></li>
					<li><a href="bootstrap-grid.html"><i class="fa fa-wrench"></i>
							Bootstrap Grid</a></li>
					<li><a href="blank-page.html"><i class="fa fa-file"></i>
							Blank Page</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i>
							Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Dropdown Item</a></li>
							<li><a href="#">Another Item</a></li>
							<li><a href="#">Third Item</a></li>
							<li><a href="#">Last Item</a></li>
						</ul></li>
				</ul>

				<ul class="nav navbar-nav navbar-right navbar-user">


					<li class="dropdown user-dropdown"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"><i
							class="fa fa-user"></i> <%=username%> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="fa fa-user"></i> Tài Khoản</a></li>
							<li class="divider"></li>
							<li><a href="#"><i class="fa fa-power-off"></i> Thoát</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
		<h1>Thêm Sản Phẩm</h1>
		<form action="<%=request.getContextPath()%>/AddProduct" method="post">
			<label>Tên: </label> <input name="productname" type="text">
			<br> <label>Mô Tả: </label> <input name="description"
				type="text"> <label>Ảnh trưng bày </label> <input
				name="firstname" type="file"> <label>Loại
				Sản Phẩm:</label> <select name="producttype">
				<%
					for (ProductType pt : list) {
				%>
				<option value="<%=pt.getProductTypeId()%>"><%=pt.getDescription()%></option>
				<%
					}
				%>
			</select> <label>Giá: </label> <input name="price" type="text"> <label>Số
				Lượng Sản Phẩm:</label><input name="quantity" type="number"> <input
				type="submit" value="Thêm">
		</form>
	</div>

</body>
</html>