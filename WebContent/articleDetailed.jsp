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

    <title>${article.getA_title()}</title>
</head>
<body>
	<div>
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
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-6">
			<br>
			<h3>${article.getA_title()}</h3>
            <br>
            <div>
               <p>
                  <span style="margin-right: 20px;">${article.getA_publish_time()}</span>
                  <span style="margin-right: 20px;">作者 / 胡锦波</span >
                  <span style="margin-right: 20px;">浏览 / ${article.getA_page_view()}</span>
               </p> 
            </div>
            <br>
            <p>${article.getA_context()}</p>
			</div>
			<div class="col-2"></div>
			<div class="col-4">
				<h3># 推荐阅读</h3>
                <br>
                <div>
                    <img  style="width: 100%;height: 100%;"src="http://pic1.win4000.com/wallpaper/3/584636ff7af8f.jpg" alt="">
                </div>
                <br>
                <c:forEach items="${tags}" var="tag">
                	<a href="/blog-jsp/article/detailed?id=${tag.getA_id()}"><p style="margin-top: 10px;">${tag.getA_title()}</p></a>
                </c:forEach>
                 
			</div>
		</div>
	</div>
</body>
</html>