<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>


<title>分类管理</title>
</head>
<body>

	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/blog-jsp/index">个人博客后台管理</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="/blog-jsp/admin/file">首页</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blog-jsp/admin/file">文件管理</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blog-jsp/admin/uploadFile.jsp">文件上传</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blog-jsp/admin/article">文章管理</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blog-jsp/admin/kind">分类管理</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/blog-jsp/admin/tag">标签管理</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-2">
				<br>
				<form action="/blog-jsp/admin/category/add" method="get">
				<h3>添加分类</h3>
				<input type="text" name="name">
				<br><br>
				<button type="submit" class="btn btn-warning">添加</button>
				<br><br>
				<p style="color:red">${msg}</p>
				</form>
			</div>

			<div class="col-9">
				<br>
				<div>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">编号</th>
								<th scope="col">分类</th>
								<th scope="col">修改</th>
								<th scope="col">操作</th>
							</tr>
						</thead>
						<tbody>
						
						<c:forEach items="${kinds}" var="kind" varStatus="begin">
							<form action="/blog-jsp/admin/category/change" method="get">
							<tr>
								<th scope="row">${begin.index }</th>
								<td>${kind.getC_name()}</td>
								<td>
									<input type="hidden" name="id" value="${kind.getC_id()}">
									<input type="text" name="name">
									<button type="submit" class="btn btn-success">修改</button>
								</td>
								<td>
								<a class="btn btn-primary" href="/blog-jsp/admin/category/detele?id=${kind.getC_id()}" role="button">删除</a>
								</td>
							</tr>
							</form>
						</c:forEach>
						
						</tbody>
					</table>

				</div>

				<div>
					<div>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:if test="${indexPage-1 >= 1}">
									<li class="page-item"><a class="page-link"
										href="/blog-jsp/admin/kind?page=${indexPage-1}"
										aria-label="Previous"> <span aria-hidden="true">上一页</span>
									</a></li>
								</c:if>

								<c:if test="${indexPage-2 >= 1}">
									<li class="page-item"><a class="page-link"
										href="/blog-jsp/admin/kind?page=${indexPage-2}">${indexPage-2}</a></li>
								</c:if>
								<c:if test="${indexPage-1 >= 1}">
									<li class="page-item"><a class="page-link"
										href="/blog-jsp/admin/kind?page=${indexPage-1}">${indexPage-1}</a></li>
								</c:if>
								<li class="page-item"><a class="page-link"
									style="color: red"
									href="/blog-jsp/admin/kind?page=${indexPage}">${indexPage}</a></li>
								<c:if test="${indexPage+1 <= totalPages}">
									<li class="page-item"><a class="page-link"
										href="/blog-jsp/admin/kind?page=${indexPage+1}">${indexPage+1}</a></li>
								</c:if>
								<c:if test="${indexPage+2 <= totalPages}">
									<li class="page-item"><a class="page-link"
										href="/blog-jsp/admin/kind?page=${indexPage+2}">${indexPage+2}</a></li>
								</c:if>

								<c:if test="${indexPage+1<= totalPages}">
									<li class="page-item"><a class="page-link"
										href="/blog-jsp/admin/kind?page=${indexPage+1}"
										aria-label="Next"> <span aria-hidden="true">下一页</span>
									</a></li>
								</c:if>

							</ul>
						</nav>
					</div>

				</div>

				<div class="col-1"></div>
			</div>
		</div>
	</div>

</body>

</html>