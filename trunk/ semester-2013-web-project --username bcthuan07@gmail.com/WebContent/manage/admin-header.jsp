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
		if (roleSet.contains(new RoleMember(new RoleMemberId(user
				.getUserId(), 1)))
				|| roleSet.contains(new RoleMember(new RoleMemberId(
						user.getUserId(), 2))))
			permission = true;
		if (permission) {
			String username = user.getUsername();
%>


<ul class="nav navbar-nav navbar-right navbar-user">
	<li class="dropdown user-dropdown"><a href="#"
		class="dropdown-toggle" data-toggle="dropdown"><i
			class="fa fa-user"></i> <%=username%><b class="caret"></b></a>
		<ul class="dropdown-menu">
			<li><a href="<%=path%>ProlifeInfo"> Tài Khoản</a></li>
			<li><a href="<%=path%>home.jsp" title="Quay lại trang chính"> Trang
					Chính</a></li>
			<li class="divider"></li>
			<li><a href="<%=path%>Logout"><i class="fa fa-power-off"></i>
					Thoát</a></li>
		</ul></li>
</ul>
<%
	} else {
%>
<jsp:forward page="managelogin.jsp"></jsp:forward>
<%
	}
	} else {
%>
<jsp:forward page="managelogin.jsp"></jsp:forward>
<%
	}
%>

