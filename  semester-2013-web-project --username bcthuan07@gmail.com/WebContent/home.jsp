<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		User user = (User) session.getAttribute("user");
		List<Product> listProduct = (List<Product>) session.getAttribute("listproduct");
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhà Hàng</title>
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery.1.7.js"></script>
<script src="js/jquery.masonry.min.js"></script>
<script src="js/modernizr-2.5.3.min.js"></script>
<script src="js/home.js"></script>
<script src="js/top.js"></script>
</head>
<body>
	<div class="container">
		<!--<div class="bg">-->
		<div class="left">
			<div class="logo">
				<a href="#"> <img src="images/logo.png" />
				</a>
				<div class="share">
					<ul>
						<li><a href="#"> <img src="images/icon/tumblr.png"></a>
						</li>
						<li><a href="#"> <img src="images/icon/pinterest.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/flickr.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/facebook.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/dribbble.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/behance.png">
						</a></li>
						<li><a href="#"> <img src="images/icon/aim.png">
						</a></li>
					</ul>
				</div>
			</div>
			<div class="menu">
				<ul>
					<%if(user!=null){%>
						<li><label>Xin Chào <a class="username" href="" >TEst</a></label></li>
					<%}%>
					<li><a class="menuitem" href="home.jsp" id="active">Trang Chủ </a></li>
					<li><a class="menuitem" href="login.jsp">Đăng Nhập/Đăng kí</a>
					<li> <a  class="menuitem" href="Menu">Thực Đơn </a> </li>
					<li> <a class="menuitem" href="order.jsp">Đặt Hàng</a> </li>
					<li> <a class="menuitem" href="lienhe.jsp">Liên Hệ </a> </li>
					
				</ul>
	</div>
	
	<a class="back-to-top" href="#" title="Quay lên trên">Lên Đầu Trang</a>
</div> <!-- hết phần trái -->
	<div class="right">
							<div class="khoi1 a"> <!-- khối to thứ nhất -->
		<div class="anh">
				<a href="#">
			<img src="images/9.jpg" />
			</a>
		</div>
		
		<div class="tin">
			<div class="tieude" id="xanhlama">
				<b>
					<a href="#">Tiêu Đề</a>
					<!--<b id="view"> </b>					-->
				</b>
			</div>
			<div class="link">
				<i>
					<a href="#">Tác giả</a>
				</i>
			</div>
			<div class="noidung">
				<p> Nội dung</p>
			</div>
			<div class="morexanhlama">
				
				<a href="#">
					<span></span>Xem Tiếp
				</a>
			</div>
		
		</div>
		
	</div>
	<div class="khoi2 a"> <!-- khối to thứ nhất -->
		<div class="anh">
		<a href="#">
			<img src="images/1.jpg" />
		</a>	
		</div>
		
		<div class="tin">
			<div class="tieude">
				<b>
					<a href="#">Tiêu Đề </a>
					
				</b>
			</div>
			<div class="link">
				<i>
					<a href="#">Tác Giả</a>
				</i>
			</div>
			<div class="noidung">
				<p>Nội dung.</p>
			</div>
			<div class="more">
				
				<a href="#">
					<span></span>Xem Tiếp
				</a>
			</div>
		
		</div>
		
	</div>
	<div class="khoi2 a"> <!-- khối to thứ nhất -->
		<div class="anh">
		<a href="#">
			<img src="images/1.jpg" />
		</a>	
		</div>
		
		<div class="tin">
			<div class="tieude">
				<b>
					<a href="#">Tiêu Đề </a>
					
				</b>
			</div>
			<div class="link">
				<i>
					<a href="#">Tác Giả</a>
				</i>
			</div>
			<div class="noidung">
				<p>Nội dung.</p>
			</div>
			<div class="more">
				
				<a href="#">
					<span></span>Xem Tiếp
				</a>
			</div>
		
		</div>
		
	</div>
	<div class="khoi2 a"> <!-- khối to thứ nhất -->
		<div class="anh">
		<a href="#">
			<img src="images/1.jpg" />
		</a>	
		</div>
		
		<div class="tin">
			<div class="tieude">
				<b>
					<a href="#">Tiêu Đề </a>
					
				</b>
			</div>
			<div class="link">
				<i>
					<a href="#">Tác Giả</a>
				</i>
			</div>
			<div class="noidung">
				<p>Nội dung.</p>
			</div>
			<div class="more">
				
				<a href="#">
					<span></span>Xem Tiếp
				</a>
			</div>
		
		</div>
		
	</div>
	<div class="khoi2 a"> <!-- khối to thứ nhất -->
		<div class="anh">
		<a href="#">
			<img src="images/1.jpg" />
		</a>	
		</div>
		
		<div class="tin">
			<div class="tieude">
				<b>
					<a href="#">Tiêu Đề </a>
					
				</b>
			</div>
			<div class="link">
				<i>
					<a href="#">Tác Giả</a>
				</i>
			</div>
			<div class="noidung">
				<p>Nội dung.</p>
			</div>
			<div class="more">
				
				<a href="#">
					<span></span>Xem Tiếp
				</a>
			</div>
		
		</div>
		
	</div>
	<div class="khoi2 a"> <!-- khối to thứ nhất -->
		<div class="anh">
		<a href="#">
			<img src="images/1.jpg" />
		</a>	
		</div>
		
		<div class="tin">
			<div class="tieude">
				<b>
					<a href="#">Tiêu Đề </a>
					
				</b>
			</div>
			<div class="link">
				<i>
					<a href="#">Tác Giả</a>
				</i>
			</div>
			<div class="noidung">
				<p>Nội dung.</p>
			</div>
			<div class="more">
				
				<a href="#">
					<span></span>Xem Tiếp
				</a>
			</div>
		
		</div>
		
	</div>
	<div class="khoi2 a"> <!-- khối to thứ nhất -->
		<div class="anh">
		<a href="#">
			<img src="images/1.jpg" />
		</a>	
		</div>
		
		<div class="tin">
			<div class="tieude">
				<b>
					<a href="#">Tiêu Đề </a>
					
				</b>
			</div>
			<div class="link">
				<i>
					<a href="#">Tác Giả</a>
				</i>
			</div>
			<div class="noidung">
				<p>Nội dung.</p>
			</div>
			<div class="more">
				
				<a href="#">
					<span></span>Xem Tiếp
				</a>
			</div>
		
		</div>
		
	</div>
 
</div> <!-- hết phần phải -->

					</div>
<!--</div>-->
<footer>
	<div class="info">
		<p>COPYRIGHT © 2013 </p>
		<a href="../mainpage/lienhe.html"> <b>Liên Hệ </b> </a>
	</div>
</footer>

</body>
</html>