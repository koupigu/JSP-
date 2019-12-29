<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件上传</title>
</head>
<style>
	body{
		
	}
</style>
<body>

<h3>文件上传</h3>
	<form action="/blog-jsp/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="text" name="name" placeholder="自定义文件名字">
		<input type="submit" value="上传文件">
	</form>
	<br>
	<br>
	<div>
		<c:if test = "${url != null}">
			<p>图片地址：<a href="${url}">${url}</a></p>
			<img src="${url}" style="width: 30%;height: 30%;">
		</c:if>
	</div>
</body>
</html>