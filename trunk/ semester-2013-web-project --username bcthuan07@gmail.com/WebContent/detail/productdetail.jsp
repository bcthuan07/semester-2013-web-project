<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Product product = (Product) session.getAttribute("product");
    	String name = "";
    	String description = "";
    	String type = "";
    	String price = "";
    	String id = "";
    	
    	if(product!=null){
    		name = product.getProductName();
    		description = product.getDescription();
    		type = product.getProductType().getDescription();
    		price = product.getPrice()+"";
    		id=product.getProductId()+"";
    	}
    
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p><%=name %></p>
<p><%=description %></p>
<p><%=type %></p>
<p><%=price %></p>
<a href="ChooseProduct?idProducts=<%=id %>">Them vao gio hang</a>
</body>
</html>