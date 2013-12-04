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
<title>Lien He</title>
<link rel="stylesheet" href="css/style.css" />
<!-- 			<script src="js/jquery.1.7.js" ></script>
			<script src="js/jquery.masonry.min.js" ></script>
			<script src="js/modernizr-2.5.3.min.js" ></script>
			<script src="js/home.js" ></script>  -->


</head>

<body>
	<div class="container">
		<div class="bg">
			<div class="left">
				<div class="logo">
					<a href="#"> <img src="images/logo.png" />
					</a>
					<div class="share">
						<ul>
							<li><a href="#"> <img src="images/icon/tumblr.png">
							</a></li>
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
						<li><a class="menuitem" href="home.jsp">Trang Chủ </a></li>
						<li><a class="menuitem" href="login.jsp">Đăng Nhập / Đăng Kí</a>
						<li><a class="menuitem" href="Menu">Thực Đơn </a></li>
						<li><a class="menuitem" href="order.jsp">Đặt Hàng</a></li>
						<li><a class="menuitem" href="lienhe.jsp" id="active">Liên Hệ </a></li>
					</ul>
				</div>
			</div>

			<div class="right" style="margin-left: 20px; margin-top: 20px;">
				<div class="lienhe a">
					<p id="lh">Liên Hệ</p>
					<div class="maps">
						<iframe width="450" height="350" frameborder="0" scrolling="no"
							marginheight="0" marginwidth="0"
							src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=vi&amp;geocode=&amp;q=tr%C6%B0%E1%BB%9Dng+%C4%91%E1%BA%A1i+h%E1%BB%8Dc+n%C3%B4ng+l%C3%A2m+th%C3%A0nh+ph%E1%BB%91+H%E1%BB%93+Ch%C3%AD+Minh&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=42.85226,86.572266&amp;vpsrc=6&amp;ie=UTF8&amp;hq=tr%C6%B0%E1%BB%9Dng+%C4%91%E1%BA%A1i+h%E1%BB%8Dc+n%C3%B4ng+l%C3%A2m&amp;hnear=Th%C3%A0nh+ph%E1%BB%91+H%E1%BB%93+Ch%C3%AD+Minh,+H%E1%BB%93+Ch%C3%AD+Minh,+Vi%E1%BB%87t+Nam&amp;ll=10.872103,106.792817&amp;spn=0.052091,0.084543&amp;t=m&amp;z=14&amp;iwloc=A&amp;cid=8109727644112951129&amp;output=embed"></iframe>
						<br /> <small><a
							href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=vi&amp;geocode=&amp;q=tr%C6%B0%E1%BB%9Dng+%C4%91%E1%BA%A1i+h%E1%BB%8Dc+n%C3%B4ng+l%C3%A2m+th%C3%A0nh+ph%E1%BB%91+H%E1%BB%93+Ch%C3%AD+Minh&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=42.85226,86.572266&amp;vpsrc=6&amp;ie=UTF8&amp;hq=tr%C6%B0%E1%BB%9Dng+%C4%91%E1%BA%A1i+h%E1%BB%8Dc+n%C3%B4ng+l%C3%A2m&amp;hnear=Th%C3%A0nh+ph%E1%BB%91+H%E1%BB%93+Ch%C3%AD+Minh,+H%E1%BB%93+Ch%C3%AD+Minh,+Vi%E1%BB%87t+Nam&amp;ll=10.872103,106.792817&amp;spn=0.052091,0.084543&amp;t=m&amp;z=14&amp;iwloc=A&amp;cid=8109727644112951129"
							style="color: #0000FF; text-align: left">Xem Bản đồ cỡ lớn
								hơn</a></small>
						<p></p>
						<ul>
							<li><a href="#"><b>Điện Thoại</b> : 11111111111</a> <a
								href="#"><b>Email</b> : contact@contact.vn</a> <a href="#"><b>Địa
										Chỉ</b> : TP Hồ Chí Minh</a></li>
						</ul>
					</div>
					<div class="mail">
						<form action="phanhoi" method="post">
							<h1>Email</h1>
							<p>Họ và tên :</p>
							<input type="text" name="hovaten"></input>
							<p>Địa chỉ Email :</p>
							<input type="text" name="email"></input>
							<p>Nội Dung :</p>
							<textarea style="font-size: 16px; font-family: tahoma;"
								name="content" id="nd"></textarea>
							<div class="submit">
								<input
									style="height: 80px; width: 100%; font-size: 20px; border: 0;"
									type="submit" value="Gửi Thư">
							</div>
						</form>
					</div>
				</div>




			</div>
			<!-- hết phần phải -->





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