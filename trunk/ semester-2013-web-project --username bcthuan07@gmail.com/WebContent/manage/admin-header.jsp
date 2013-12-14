<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();

	User user = (User) session.getAttribute("user");
	boolean permission = user == null ? false : user.getPermission();
	if (permission) {
		String username = user.getUsername();
%>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=path%>manage.jsp">Thống Kê</a>
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
						class="fa fa-user"></i><%=username%><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-user"></i> Tài Khoản</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-power-off"></i> Thoát</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
	<%
		} else {
			%>
			<jsp:forward page="managelogin.jsp"></jsp:forward>
			<%
		}
	%>

