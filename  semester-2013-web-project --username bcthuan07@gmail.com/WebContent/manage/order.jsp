<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.UserOrder"%>
<%@page import="dao.UserOrderDAO"%>
<%@page import="service.DAOService"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	List<UserOrder> listUserOrders = new ArrayList();
	//if (user != null) {
		//boolean permission = user.getPermission();
		DAOService<UserOrder, Integer> daoService = new DAOService(
				new UserOrderDAO());
		listUserOrders = //permission ?
				daoService.listObject();// : new ArrayList();
	//}
	response.setHeader("Refresh", "10");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý hóa đơn</title>
</head>
<body>
<%for(UserOrder userOrder: listUserOrders){ %>
	<p>Tên KH: <%=userOrder.getUser().getFullname() %></p>
	<p>Tình Trạng Thanh Toán: <%=userOrder.getOrderStatus().getDescription() %></p>
	<p>Ngày lập: <%=userOrder.getOrderDate() %></p>
	
	
<%} %>
</body>
</html>