<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>文件上传</title>
</head>
<style>
	body{
		
	}
</style>
<body>
	<div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="/blog-jsp/file">文件后台管理</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="/blog-jsp/admin/file">首页</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/blog-jsp/admin/file">文件管理</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/blog-jsp/admin/uploadFile.jsp">文件上传</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/blog-jsp/admin/article">文章管理</a>
          </li>
          <li class="nav-item">
	        <a class="nav-link" href="/blog-jsp/admin/kind">分类管理</a>
          </li>
          <li class="nav-item">
	        <a class="nav-link" href="/blog-jsp/admin/tag">标签管理</a>
	      </li>
	    </ul>
	  </div>
	</nav>      
	</div>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-2">
                <br>
                <h3>注意:</h3>
                <p>现在只能上传图片，其他格式文件还未编写</p>
             </div>
             
            <div class="col-10">
            	<br>
				<h3>文件上传</h3>
				<br>
				<form action="/blog-jsp/admin/upload" method="post" enctype="multipart/form-data">
					<input type="file" name="file">
					<input type="text" name="name" placeholder="自定义文件名字">
					<input class="btn btn-success" type="submit" value="上传文件">
				</form>
				<br>
				<br>
				<div>
					<c:if test = "${url != null}">
						<p>图片地址：<a href="${url}">${url}</a></p>
						<img src="${url}" style="width: 30%;height: 30%;">
					</c:if>
				</div>
			</div>
    	</div>
   </div>

</body>
</html>