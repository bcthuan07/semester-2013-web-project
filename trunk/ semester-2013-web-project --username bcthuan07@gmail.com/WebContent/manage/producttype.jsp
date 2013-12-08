<%@page import="dao.ProductTypeDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductType"%>
<%@page import="service.DAOService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		DAOService<ProductType,Integer> daoService = new DAOService<ProductType, Integer>(new ProductTypeDAO());
		List<ProductType> listProductTypes = daoService.listObject();
		String error = "";
		if(request.getAttribute("error")!=null)
			error=(String) request.getAttribute("error");
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loại Sản Phẩm</title>
</head>
<body>
<%for(ProductType pt: listProductTypes){ %>
<%=pt.toString() %>
<%} %>
<form action="../AddProductType" method="post">
	<label>Thêm loại sản phẩm:</label><input type="text" name="description">
	<input type="submit" value="Thêm">
	<span><%=error %></span>
</form>
</body>
</html>