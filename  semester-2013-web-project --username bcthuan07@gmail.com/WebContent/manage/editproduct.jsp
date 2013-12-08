<%@page import="model.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductTypeDAO"%>
<%@page import="service.DAOService"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Product product = (Product) request.getAttribute("product");
    	String name = "";
    	String description = "";
    	String price = "";
    	String productType = "";
    	String imagePath = "";
    	if(product != null){
    		name = product.getProductName();
    		description = product.getDescription();
    		price = product.getPrice()+"";
    		imagePath = product.getImagePath();
    	}
    	DAOService<ProductType,Integer> daoService = new DAOService<ProductType,Integer>(new ProductTypeDAO());
    	List<ProductType> list = daoService.listObject();
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chỉnh Sửa Sản Phẩm</title>
</head>
<body>
<form>
<label>Tên Sản Phẩm:</label><input type="text" name="name" value="<%=name %>">
<label>Mô Tả Sản Phẩm:</label><input type="text" name="description" value="<%=description %>">
<label>Giá:</label><input type="text" name="price" value="<%=price %>">
<label>Loại Sản Phẩm:</label>
<select name="producttype">
	<% for(ProductType pt: list){
		String selected = pt.getDescription().equals(productType)? "selected":"";	
	%>
		<option value="<%=pt.getProductTypeId()%>" <%=selected %>><%=pt.getDescription() %></option>
	<%} %>
</select>
</form>
</body>
</html>