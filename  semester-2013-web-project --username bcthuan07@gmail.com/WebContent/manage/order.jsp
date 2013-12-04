<%@page import="java.util.List"%>
<%@page import="model.UserOrder"%>
<%@page import="dao.UserOrderDAO"%>
<%@page import="service.DAOService"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	boolean permission = user.getPermission();
	if(user!=null && permission){
		DAOService<UserOrder, Integer> daoService = new DAOService(new UserOrderDAO());
		List<UserOrder> listUserOrders = daoService.listObject();
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý hóa đơn</title>
</head>
<body>
	
	
</body>
</html>