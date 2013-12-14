<%@page import="model.User"%>
<%@page import="model.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductTypeDAO"%>
<%@page import="service.DAOService"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");
	User user = (User) session.getAttribute("user");
	boolean permission = user == null ? false : user.getPermission();
	String username = "";
	if (!permission) {
		response.sendRedirect(request.getContextPath() + "/home.jsp");
		username=user.getUsername();
	}
	Product product = (Product) request.getAttribute("product");
	String name = product==null? "": product.getProductName();
	String description = product==null?"":product.getDescription();
	String price = product==null?"":product.getPrice().toString();
	String productType = product==null?"":product.getProductType().getDescription();
	
	
	String name_err= request.getAttribute("name_err")==null?"":(String)request.getAttribute("name_err");
	String description_err=request.getAttribute("description_err")==null?"":(String)request.getAttribute("description_err");
	String price_err=request.getAttribute("price_err")==null?"":(String)request.getAttribute("price_err");
	
	DAOService<ProductType, Integer> daoService = new DAOService<ProductType, Integer>(
			new ProductTypeDAO());
	List<ProductType> list = daoService.listObject();
	String path = request.getContextPath()+"/manage/";

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
<link href="<%=path %>css/bootstrap.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="<%=path %>css/sb-admin.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path %>font-awesome/css/font-awesome.min.css">
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
		<form>
			<div class="form-group">
			<label for="name">Tên Sản Phẩm:</label> 
			<input type="text" name="name" value="<%=name%>" class="form-control" id="name">
			<p><%=name_err %></p>
			</div>
			
			<div class="form-group">
			<label for="des">Mô Tả Sản Phẩm:</label> 
			<input type="text"	name="description" value="<%=description%>" class="form-control" id="des">
			<p><%=description_err %></p>
			</div>
			
			<div class="form-group"> 
			<label for="price">Giá:</label> 
			<input	type="text" name="price" value="<%=price%>" class="form-control" id="price">
			<p><%=price_err %></p>
			</div>
			
			<div class="form-group"> 
			<label for="type">Loại Sản Phẩm:</label> 
			<select	name="producttype" class="form-control" id="type">
				<%
					for (ProductType pt : list) {
						String selected = pt.getDescription().equals(productType) ? "selected"
								: "";
				%>
				<option value="<%=pt.getProductTypeId()%>" <%=selected%>><%=pt.getDescription()%></option>
				<%
					}
				%>
			</select>
			</div> 
			<input type="submit" class="form-control" value="Lưu">
		</form>
		</div>
		<!-- JavaScript -->
		<script src="<%=path %>js/jquery-1.10.2.js"></script>
		<script src="<%=path %>js/bootstrap.js"></script>

		<!-- Page Specific Plugins -->
		<script
			src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
		<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
		<script src="<%=path %>js/morris/chart-data-morris.js"></script>
		<script src="<%=path %>js/tablesorter/jquery.tablesorter.js"></script>
		<script src="<%=path %>js/tablesorter/tables.js"></script>
</body>
</html>