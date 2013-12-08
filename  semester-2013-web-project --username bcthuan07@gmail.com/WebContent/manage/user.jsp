<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<%@page import="service.DAOService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	DAOService<User, Integer> daoService = new DAOService<User, Integer>(new UserDAO());
    	List<User> listUser = daoService.listObject();
    	List<User> listCustomer = new ArrayList<User>();
    	for(User user: listUser){
    		if(!user.getPermission()){
    			listCustomer.add(user);
    		}
    	}
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản Lý Khách Hàng</title>
</head>
<body>
<%=listCustomer %>
<%=listUser %>

</body>
</html>