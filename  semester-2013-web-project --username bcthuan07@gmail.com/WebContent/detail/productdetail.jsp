<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Product product = (Product) session.getAttribute("product");
    	String name = "";
    	String description = "";
    	String type = "";
    	String price = "";
    	
    	if(product!=null){
    		name = product.getProductName();
    		description = product.getDescription();
    		type = product.getProductType().getDescription();
    		price = product.getPrice()+"";
    	}
    
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>