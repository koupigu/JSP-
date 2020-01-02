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

    <link rel="stylesheet" href="editormd/css/editormd.css" />

<title>关于</title>
</head>
<body>

	<div>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  		<a class="navbar-brand" href="/blog-jsp/admin/adminIndex.jsp">个人博客后台管理</a>
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
          <ul>
           <li><a href="/blog-jsp/admin/editor.jsp">编写文章</a></li>
           <li><a href="/blog-jsp/admin/article">文章列表</a></li>
           <li><a href="/blog-jsp/admin/about">about页面</a></li>
         </ul>
      </div>

      <div class="col-9">
          <br>
        <form action="">
          <div class="row">
            <div class="col-4">
              <label>文章标题</label>
              <input class="form-control" type="text">
            </div>

            <div class="col-4">
              <label>标签</label>
              <input class="form-control" type="text">
            </div>

            <div class="col-2">
              <label>分类</label>
              <select class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
              </select>
            </div>
            <div class="col-2">
              <div style="margin-top: 30px;"></div>
              <button class="btn btn-success">发布文章</button>
            </div>
          </div>
          <br>
          <div id="test-editor">
            <textarea style="display:none;"></textarea>
          </div>
        </form>
      </div>

      <div class="col-1"></div>
		</div>
		</div>
    </div>

</body>
    <script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="editormd/editormd.min.js"></script>
    <script type="text/javascript">
        $(function() {
            var editor = editormd("test-editor", {
                width  : "100%",
                height : "600px",
                path   : "editormd/lib/"
            });
        });
    </script>
</html>