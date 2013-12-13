<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String error = "";
	if (request.getAttribute("error") != null)
		error = (String) request.getAttribute("error");
	
	String contextPath = request.getContextPath()+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=contextPath %>css/style.css" />
<script src="<%=contextPath %>js/jquery.1.7.js"></script>
<script src="<%=contextPath %>js/jquery.masonry.min.js"></script>
<script src="<%=contextPath %>js/modernizr-2.5.3.min.js"></script>
<script src="<%=contextPath %>js/home.js"></script>
<script src="<%=contextPath %>js/top.js"></script>
<title>Lỗi</title>
</head>
<body>
	<div class="container">
		<div class="left">
			<div class="logo">
				<a href="#"> <img src="<%=contextPath %>images/logo.png" />
				</a>
				<div class="share">
					<ul>
						<li><a href="#"> <img src="<%=contextPath %>images/icon/tumblr.png"></a>
						</li>
						<li><a href="#"> <img src="<%=contextPath %>images/icon/pinterest.png">
						</a></li>
						<li><a href="#"> <img src="<%=contextPath %>images/icon/flickr.png">
						</a></li>
						<li><a href="#"> <img src="<%=contextPath %>images/icon/facebook.png">
						</a></li>
						<li><a href="#"> <img src="<%=contextPath %>images/icon/dribbble.png">
						</a></li>
						<li><a href="#"> <img src="<%=contextPath %>images/icon/behance.png">
						</a></li>
						<li><a href="#"> <img src="<%=contextPath %>images/icon/aim.png">
						</a></li>
					</ul>
				</div>
			</div>
			<div class="menu">
				<ul>
					<li><a class="menuitem" href="../home.jsp" id="trangchu">Trang
							Chủ </a></li>
					<li><a class="menuitem" href="user.jsp">Khách Hàng</a></li>
					<li><a class="menuitem" href="product.jsp">Sản Phẩm</a></li>
					<li><a class="menuitem" href="../manage/order.jsp">Hóa
							Đơn</a></li>
				</ul>
			</div>

			<a class="back-to-top" href="#" title="Quay lên trên">Lên Đầu
				Trang</a>
		</div>
		<div class="right">
			<%=error%>
		</div>
	</div>
	<footer>
		<div class="info">
			<p>COPYRIGHT © 2013</p>
			<a href="lienhe.jsp"> <b>Liên Hệ </b>
			</a>
		</div>
	</footer>
</body>
</html>