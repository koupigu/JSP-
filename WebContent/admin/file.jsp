<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>文件管理</title>
</head>
<body>

	<div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="/blog-jsp/admin/adminIndex.jsp">文件后台管理</a>
  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>

	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	  <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="/blog-jsp/admin/adminIndex.jsp">首页</a>
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
	    <ul class="navbar-nav mr-auto">
		    <li class="nav-item">
		    	<a class="nav-link" href="/blog-jsp/index">前台页面</a>
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
                <div>
                <c:forEach items="${files}" var="file">
                <div style="float: left;margin-right: 20px;margin-top: 20px;">
                    <div class="card" style="width: 18rem;">
                        <img src="${file.getUrl()}" class="card-img-top" style="height: 160px" alt="...">
                        <div class="card-body">
                        	<h5 class="card-title">${file.getName() }</h5>
                            <!-- <p class="card-text">你的名字系列</p> -->
                            <a href="/blog-jsp/download?url=${file.getUrl()}" class="btn btn-primary btn-sm">下载</a>
                            <a href="${file.getUrl()}" class="btn btn-primary btn-sm">预览</a>
                            <a href="/blog-jsp/delete?url=${file.getUrl()}" class="btn btn-primary btn-sm">删除</a>
                            
                        </div>
                    </div>
                 </div>
             	</c:forEach>
             	
            </div>
		</div>
    </div>
   </div>

</body>
</html>