<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	User user = (User) session.getAttribute("user");
	List<Product> listProduct;
	double amount = 0.0;
	if (session.getAttribute("listproduct") != null) {
		listProduct = (List<Product>) session
				.getAttribute("listproduct");
		for(Product p: listProduct){
			amount+=p.getPrice();
		}
	} else {
		listProduct = new ArrayList<Product>();
	}
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ Hàng</title>
</head>
<body>
<%=listProduct %>
<%=amount %>
</body>
</html>