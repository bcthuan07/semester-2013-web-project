<%@page import="model.RoleMemberId"%>
<%@page import="model.RoleMember"%>
<%@page import="java.util.Set"%>
<%@page import="model.Role"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	User user = (User) session.getAttribute("user");
	String username = user == null ? "Thành Viên" : "Xin Chào "
			+ user.getUsername();
	boolean permission = false;
	if (user != null) {

		Set<RoleMember> roleSet = user.getUserRoleMembers();
		if (roleSet.contains(new RoleMember(new RoleMemberId(user
				.getUserId(), 1)))
				|| roleSet.contains(new RoleMember(new RoleMemberId(user
						.getUserId(), 2))))
			permission = true;
	}
	String contextPath = request.getContextPath() + "/";
%>


<li class="dropdown"><a href="" class="dropdown-toggle"
	data-toggle="dropdown"><%=username%><b class="caret"></b></a>
	<ul class="dropdown-menu">
		<%
			if (user == null) {
		%><li><a href="<%=contextPath%>login.jsp">Đăng Nhập</a></li>
		<li><a href="<%=contextPath%>register.jsp">Đăng Ký</a></li>
		<%
			}
		%>
		<li><a href="<%=contextPath%>order/cartview.jsp">Giỏ Hàng</a></li>
		<li class="divider"></li>
		<!--<li class="dropdown-header">Nav header</li>-->
		<%
			if (user != null) {
		%>
		<%
			if (permission) {
		%>
		<li><a href="<%=contextPath%>Manage">Trang Quản Lý</a></li>
		<%
			}
		%>
		<li><a href="<%=contextPath%>feedback.jsp">Gửi phản hồi</a></li>
		<li><a href="<%=contextPath%>Logout">Thoát</a></li>
		<%
			}
		%>
	</ul></li>
<li>
	<form action="<%=contextPath%>SearchProductByName"
		class="navbar-form navbar-right" role="form">
		<div class="form-group">
			<input type="text" class="form-control" placeholder="Tìm Kiếm Món Ăn"
				name="search">
		</div>
		<input type="submit" value="Tìm" class="btn btn-success">
	</form>
</li>
