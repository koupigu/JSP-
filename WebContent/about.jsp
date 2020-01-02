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
    
    <link rel="stylesheet" href="admin/editormd/css/editormd.preview.css" />
    
	<title>关于</title>
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
	    
	    <button class="btn btn-outline-success my-2 my-sm-0"><a href="login.jsp">登录</a></button>
	  </div>
	</nav>      
	</div>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<br>
				<div id="test-markdown-view">
				    <textarea style="display:none;">${about.getContent()}</textarea>             
				</div>
			</div>
		</div>
	</div>
</body>

<script src="admin/editormd/editormd.js"></script>
<script src="admin/editormd/lib/marked.min.js"></script>
<script src="admin/editormd/lib/prettify.min.js"></script>
<script type="text/javascript">
	$(function() {
		var testView = editormd.markdownToHTML("test-markdown-view", {
		// markdown : "[TOC]\n### Hello world!\n## Heading 2", // Also, you can dynamic set Markdown text
		// htmlDecode : true,  // Enable / disable HTML tag encode.
		// htmlDecode : "style,script,iframe",  // Note: If enabled, you should filter some dangerous HTML tags for website security.
		});
	});
</script>
</html>