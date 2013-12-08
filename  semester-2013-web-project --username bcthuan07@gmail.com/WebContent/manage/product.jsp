<%@page import="java.util.List"%>
<%@page import="dao.ProductDAO"%>
<%@page import="model.Product"%>
<%@page import="service.DAOService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		DAOService<Product, Integer> daoService = new DAOService<Product, Integer>(new ProductDAO());
		List<Product> list = daoService.listObject();
		
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sản phẩm</title>
</head>
<body>
<%for(Product p : list){ %>
<%=p.toString() %>
<%} %>
</body>
</html>