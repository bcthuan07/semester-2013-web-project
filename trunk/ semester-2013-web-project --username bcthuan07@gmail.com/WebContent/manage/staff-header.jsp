<%@page import="model.RoleMemberId"%>
<%@page import="model.RoleMember"%>
<%@page import="java.util.Set"%>
<%@page import="model.Role"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath() + "/";

	User user = (User) session.getAttribute("user");
	boolean permission = false;
	if (user != null) {
		Set<RoleMember> roleSet = user.getUserRoleMembers();
		if(roleSet.contains(new RoleMember(new RoleMemberId(user
				.getUserId(), 1))) || roleSet.contains(new RoleMember(new RoleMemberId(user
						.getUserId(),2))))
			permission = true;
		if (permission) {
			String username = user.getUsername();
%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<%=path%>manage.jsp">Thống Kê</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		
		<ul class="nav navbar-nav navbar-right navbar-user">
			<li class="dropdown user-dropdown"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"><i
					class="fa fa-user"></i><%=username%><b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="fa fa-user"></i> Tài Khoản</a></li>
					<li class="divider"></li>
					<li><a href="<%=path%>Logout"><i class="fa fa-power-off"></i>
							Thoát</a></li>
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
	} else {
%>
<jsp:forward page="managelogin.jsp"></jsp:forward>
<%} %>

