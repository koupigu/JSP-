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
    
	<title>文章</title>
</head>
<body>

	<div id="article">
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
        <br>
        <div class="container">
            
                            
            <div class="row">
                <div class="col-6">
                    <!-- 分类 -->
                    <div>
                        <div class="commonHeadLabel mt20">
                        		<span class="title mr20">
                        			<a href="/blog-jsp/article">全部</a>
                            	</span>
                        	<c:forEach items="${categories}" var="category">
                        		<span class="title mr20">
                        			<a href="/blog-jsp/article?kind=${category.getC_id()}">${category.getC_name()}</a>
                            	</span>
                        	</c:forEach>
                        </div>
                    </div>

                    <br><br>
                    <!-- 文章 -->
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
	                                <span style="margin-right: 20px;"class="label label-danger">${article.getA_publish_time()}</span>
	                                <span style="margin-right: 20px;"class="label label-success">作者: 胡锦波</span >
	                                <span style="margin-right: 20px;" class="badge">${article.getA_page_view() } 浏览</span>
	                            </p> 
	                            </div>
	                            <br>
                        	</div>
                        </c:forEach>

                    <!-- 分页 -->
                    <div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                        <c:if test = "${indexPage-1 >= 1}">
	                        <li class="page-item">
	                            <a class="page-link" href="/blog-jsp/article?kind=${kind}&page=${indexPage-1}" aria-label="Previous">
	                            <span aria-hidden="true">上一页</span>
	                            </a>
	                        </li>
						</c:if>
                        
						<c:if test = "${indexPage-2 >= 1}">
							<li class="page-item">
							<a class="page-link" href="/blog-jsp/article?kind=${kind}&page=${indexPage-2}">${indexPage-2}</a></li>
						</c:if>
						<c:if test = "${indexPage-1 >= 1}">
							<li class="page-item">
							<a class="page-link" href="/blog-jsp/article?kind=${kind}&page=${indexPage-1}">${indexPage-1}</a></li>
						</c:if>
						<li class="page-item"><a class="page-link" style="color:red" href="/blog-jsp/article?kind=${kind}&page=${indexPage}">${indexPage}</a></li>
						<c:if test = "${indexPage+1 <= totalPages}">
							<li class="page-item">
							<a class="page-link" href="/blog-jsp/article?kind=${kind}&page=${indexPage+1}">${indexPage+1}</a></li>
						</c:if>
						<c:if test = "${indexPage+2 <= totalPages}">
							<li class="page-item">
							<a class="page-link" href="/blog-jsp/article?kind=${kind}&page=${indexPage+2}">${indexPage+2}</a></li>
						</c:if>
						
						<c:if test = "${indexPage+1< totalPages}">
							<li class="page-item">
	                            <a class="page-link" href="/blog-jsp/article?kind=${kind}&page=${indexPage+1}" aria-label="Next">
	                            <span aria-hidden="true">下一页</span>
	                            </a>
	                        </li>
						</c:if>
						
                        </ul>
                    </nav>
                    </div>
                    </div>
                </div>
                <div class="col-2">.col-md-2</div>
                <!-- 标签 -->
                <div class="col-4">
                    <h3># 热门标签</h3>
                    <br>
                    <div>
                        <img  style="width: 100%;height: 100%;"src="http://pic1.win4000.com/wallpaper/f/5859f813abf3d.jpg" alt="">
                    </div>
                    <br>
                    <div class="indexTagGrid">
                    	<c:forEach items="${tags}" var="tag">
                    		<a href="/blog-jsp/tag?id=${tag.getT_id()}"><span class="item">${tag.getT_name()}</span></a>
                    	</c:forEach>
                        
                    </div>
                   
                </div>
            </div>
        </div>
    </div>
</body>
    <style>
    .blue-text a{
    	font-size: 20px;
    }
    .title a.on {
        font-size: 20px;
        color: #409eff;
    }
    .mr20 {
        margin-right: 20px;
    }
    .commonHeadLabel {
        position: relative;
        margin-bottom: 20px;
        
        font-size: 12px;
        color: #999;
        height: 24px;
        line-height: 24px;
        overflow: hidden;
    }
    .title a {
        font-size: 20px;
        color: #666;
    }
    .indexTagGrid .item {
        float: left;
        display: inline-block;
        padding: 0 20px;
        margin: 0 10px 10px 0;
        text-align: center;
        font-size: 13px;
        color: #666;
        height: 34px;
        line-height: 32px;
        overflow: hidden;
        transition: all .2s ease;
        border-radius: 18px;
        border: 1px solid #f6f6f6;
        background: #f6f6f6;
    }
    </style>
</html>