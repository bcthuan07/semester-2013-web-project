<%@page import="dao.PaymentMethodDAO"%>
<%@page import="model.PaymentMethod"%>
<%@page import="model.City"%>
<%@page import="dao.CityDAO"%>
<%@page import="service.DAOService"%>
<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Product> list = (List<Product>) session
			.getAttribute("listproduct");
	Double amount = 0.0;

	DAOService<City, Integer> service = new DAOService<City, Integer>(
			new CityDAO());
	DAOService<PaymentMethod, Integer> paymentList = new DAOService<PaymentMethod, Integer>(
			new PaymentMethodDAO());
	if (list == null) {
		response.sendRedirect(request.getContextPath() + "/home.jsp");
	} else if (list.size() == 0) {
		response.sendRedirect(request.getContextPath() + "/Menu");
	}
	if (list != null)
		for (Product p : list)
			amount += p.getPrice();

	String fullname = request.getAttribute("fullname") == null ? ""
			: (String) request.getAttribute("fullname");
	String email = request.getAttribute("email") == null ? ""
			: (String) request.getAttribute("email");
	String phonenumber = request.getAttribute("phonenumber") == null ? ""
			: (String) request.getAttribute("phonenumber");
	String street = request.getAttribute("street") == null ? ""
			: (String) request.getAttribute("street");
	String buildingnumber = request.getAttribute("buildingnumber") == null ? ""
			: (String) request.getAttribute("buildingnumber");

	User user = (User) session.getAttribute("user");
	boolean hasLogin = user == null ? false : true;
	String disabled = hasLogin ? "disabled" : "";
	fullname = hasLogin ? user.getFullname() : "";
	email = hasLogin ? user.getEmail() : "";

	String fullname_err = request.getAttribute("fullname_err") == null ? ""
			: (String) request.getAttribute("fullname_err");
	String email_err = request.getAttribute("email_err") == null ? ""
			: (String) request.getAttribute("email_err");
	String phonenumber_err = request.getAttribute("phonenumber_err") == null ? ""
			: (String) request.getAttribute("phonenumber_err");
	String street_err = request.getAttribute("street_err") == null ? ""
			: (String) request.getAttribute("street_err");
	String buildingnumber_err = request
			.getAttribute("buildingnumber_err") == null ? ""
			: (String) request.getAttribute("buildingnumber_err");

	String contextPath = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Trang Chủ</title>

<!-- Bootstrap core CSS -->
<link href="<%=contextPath%>css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS for the '3 Col Portfolio' Template -->
<link href="<%=contextPath%>css/3-col-portfolio.css" rel="stylesheet">
<link href="<%=contextPath%>css/carousel.css" rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="http://startbootstrap.com">Nhà
					Hàng Jamie's Oliver</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">Trang Chủ</a></li>
					<li><a href="Menu">Thực Đơn</a></li>
					<li><a href="lienhe.jsp">Liên Hệ</a></li>
					<li><a href="<%=contextPath %>order/cartview.jsp">Giỏ Hàng</a></li>

					<jsp:include page="header.jsp"></jsp:include>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<div class="container">
		<form action="<%=request.getContextPath()%>/ValidateOrder"
			method="post">
			<legend>Thanh Toán</legend>
			<div class="form-group">
				<label for="fullname">Tên đầy đủ</label> <input class="form-control"
					id="fullname" type="text" name="fullname" value="<%=fullname%>"
					<%=disabled%>>
				<p class="help-block"><%=fullname_err%>
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input class="form-control"
					id="email" type="text" name="email" value="<%=email%>"
					<%=disabled%>>
				<p class="help-block"><%=email_err%></p>
			</div>

			<div class="form-group">
				<label for="phone">Số điện thoại</label> <input class="form-control"
					id="phone" type="text" name="phonenumber" value="<%=phonenumber%>">
				<p><%=phonenumber_err%></p>
			</div>

			<div class="form-group">
				<label for="street">Đường</label> <input class="form-control"
					id="street" type="text" name="street" value="<%=street%>">
				<p><%=street_err%></p>
			</div>

			<div class="form-group">
				<label for="city">Thành Phố</label> <select name="city"
					class="form-control" id="city">
					<%
						for (City c : service.listObject()) {
					%>
					<option value=<%=c.getId()%>><%=c.getName()%></option>
					<%
						}
					%>
				</select>
			</div>

			<div class="form-group">
				<label for="number">Số nhà</label> <input class="form-control"
					id="number" type="text" name="buildingnumber"
					value="<%=buildingnumber%>">
				<p><%=buildingnumber_err%></p>
			</div>

			<div class="form-group">
				<label for="payment">Hình thức thanh toán</label> <select
					class="form-control" id="payment" name="payment">
					<%
						for (PaymentMethod p : paymentList.listObject()) {
					%>
					<option value="<%=p.getPaymentMethodId()%>"><%=p.getDescription()%></option>
					<%
						}
					%>
				</select>

			</div>
			<div class="form-group">
				<label for="amount">Tổng Thành Tiền:</label>
				<p><%=amount%></p>
			</div>
			<input class="form-control" type="submit" value="Mua">

		</form>
	</div>
	<div class="container">

		<hr>

		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Copyright &copy; Company 2013</p>
				</div>
			</div>
		</footer>

	</div>
	<!-- /.container -->

	<!-- JavaScript -->
	<script src="<%=contextPath%>js/jquery-1.10.2.js"></script>
	<script src="<%=contextPath%>js/bootstrap.js"></script>

</body>

</html>