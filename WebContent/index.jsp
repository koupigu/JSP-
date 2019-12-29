<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  /* Make the image fully responsive   */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
      .li {
        margin-right: 30px;
    }
    .blue-text {
        color: #0181da;
        font-size:20px;
    }
    .item{
        width: 500px;
        height: 200px;
        margin-left: 10%;
        background-color: #fff;
    }
    a{
      cursor: pointer
    }

  </style>

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <title>个人博客</title>
</head>
<body>

    <div id="index_page">
      <!-- 导航 -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="/blog-jsp/index">个人博客</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="/blog-jsp/index">首页</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/blog-jsp/article">文章</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/blog-jsp/about">关于</a>
	      </li>
	    </ul>
	    
	    <button class="btn btn-outline-success my-2 my-sm-0"><a href="#">登录</a></button>
	  </div>
	</nav>

    <div class="container">
      <div class="row">
        
        <div class="col-5">
		        <div id="demo" class="carousel slide" data-ride="carousel">
		 
		  <!-- 指示符 -->
		  <ul class="carousel-indicators">
		    <li data-target="#demo" data-slide-to="0" class="active"></li>
		    <li data-target="#demo" data-slide-to="1"></li>
		    <li data-target="#demo" data-slide-to="2"></li>
		  </ul>
		 
		  <!-- 轮播图片 -->
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="http://pic1.win4000.com/wallpaper/e/584635dae4b24.jpg">
		    </div>
		    <div class="carousel-item">
		      <img src="http://pic1.win4000.com/wallpaper/e/584635dcaf352.jpg">
		    </div>
		    <div class="carousel-item">
		      <img src="http://pic1.win4000.com/wallpaper/3/584636ff7af8f.jpg">
		    </div>
		  </div>
		 
		  <!-- 左右切换按钮 -->
		  <a class="carousel-control-prev" href="#demo" data-slide="prev">
		    <span class="carousel-control-prev-icon"></span>
		  </a>
		  <a class="carousel-control-next" href="#demo" data-slide="next">
		    <span class="carousel-control-next-icon"></span>
		  </a>
		 
		</div>
      </div>
    </div>
 <div class="row">
    <div class="col-5">
      <!-- 最新文章 -->
      <div style="margin-top:4%;">
        <h3>最新文章：</h3>
        <br>
      </div>
      <!-- 文章列表 -->
	  <div>
		<!-- 文章列表 -->
		<c:forEach items="${articles}" var="article">
			<div>
				<div>
					<h4 class="blue-text">
						<a href="/blog-jsp/article/detailed?id=${article.getA_id()}">${article.getA_title()}</a>
					</h4>
					<p style="margin-top: 20px;">
						${article.getA_preview_text()}
					</p>
					<p>
					<span style="margin-right: 20px;" class="label label-danger">${article.getA_publish_time()}</span>
					<span style="margin-right: 20px;" class="label label-success">作者:胡锦波</span>
					<span style="margin-right: 20px;" class="badge">${article.getA_page_view()} 浏览</span>
					</p>
				</div>
				<br>
				</div>
		</c:forEach>
	</div>

					<!-- 分页 -->
      

    <!-- 
    <div class="col-4">col-4</div>

    <div class="col-3">col-3</div>
    -->   
 	</div>
 </div>
 </div>
</body>
</html>