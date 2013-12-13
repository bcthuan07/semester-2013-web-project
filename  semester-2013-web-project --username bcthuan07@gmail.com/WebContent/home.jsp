<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf8");
	response.setCharacterEncoding("utf8");

	User user = (User) session.getAttribute("user");
	List<Product> listProduct = (List<Product>) session
			.getAttribute("listproduct");
	String username = user==null? "Thành Viên": "Xin Chào "+user.getUsername();
	boolean permission = user==null? false: user.getPermission();
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
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS for the '3 Col Portfolio' Template -->
    <link href="css/3-col-portfolio.css" rel="stylesheet">
	<link href="css/carousel.css" rel="stylesheet">

  </head>

  <body>

    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="http://startbootstrap.com">Nhà Hàng Jamie's Oliver</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#about" >Trang Chủ</a></li>
            <li><a href="#services">Thực Đơn</a></li>
            <li><a href="#contact">Liên Hệ</a></li>
			
			<li class="dropdown">
			<a href="" class="dropdown-toggle" data-toggle="dropdown"><%=username %><b class="caret"></b></a>
			<ul class="dropdown-menu">
			<%if(user==null){ %><li><a href="login.jsp">Đăng Nhập</a></li>
			<li><a href="register.jsp">Đăng Ký</a></li><%} %>
			<li><a href="order/cartview.jsp">Giỏ Hàng</a></li>
			<li class="divider"></li>
			<!--<li class="dropdown-header">Nav header</li>-->
			<%if(user!=null){ %>
			<%if(permission){ %>
				<li><a href="Manage">Trang Quản Lý</a></li>
			<%} %>
			<li><a href="Logout">Thoát</a></li><%} %>
			</ul>
			</li>
			<li>
				<form class="navbar-form navbar-right" role="form">
					<div class="form-group"><input type="text" class="form-control" placeholder="Tìm Kiếm Món Ăn"></div>
					<input type="submit" value="Tìm" class="btn btn-success">
				</form >
			</li>			
			</ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container -->
    </nav>

     <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1" class=""></li>
        <li data-target="#myCarousel" data-slide-to="2" class=""></li>
      </ol>
      <div class="carousel-inner">
        <div class="item active">
		<img src="image/background/bg.jpg">
          <div class="container">
            <div class="carousel-caption">
              <h1>Đăng kí thành viên</h1>
              <p>Đăng kí làm thành viên ngay, để nhận hàng loạt ưu đãi hấp dẫn!</p>
              <p><a class="btn btn-lg btn-primary" href="register.jsp" role="button">Đăng kí</a></p>
            </div>
          </div>
        </div>
        <div class="item">
		<img src="image/background/bg.jpg">
          <div class="container">
            <div class="carousel-caption">
              <h1>Thực Đơn</h1>
              <p>Thực đơn phong phú, hấp dẫn</p>
              <p><a class="btn btn-lg btn-primary" href="Menu" role="button">Xem Thực Đơn</a></p>
            </div>
          </div>
        </div>
       
        <div class="item">
		<img src="image/background/bg.jpg">
          <div class="container">
            <div class="carousel-caption">
              <h1>Liên Hệ</h1>
              <p>Thực đơn phong phú, hấp dẫn</p>
              <p><a class="btn btn-lg btn-primary" href="lienhe.jsp" role="button">Xem</a></p>
            </div>
          </div>
        </div>
       
      </div>
      <a class="left carousel-control" href="http://getbootstrap.com/examples/carousel/#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="http://getbootstrap.com/examples/carousel/#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
	  
    </div><!-- /.carousel -->

    <div class="container">

      <hr>

      <footer>
        <div class="row">
          <div class="col-lg-12">
            <p>Copyright &copy; Company 2013</p>
          </div>
        </div>
      </footer>
      
    </div><!-- /.container -->

   
	
	    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/holder.js"></script>


  </body>

</html>