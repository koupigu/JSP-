<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册账号</title>
<style type="text/css">
	body{
		font-family : "正楷";
		text-align : center;
		vertical-align : top;
		margin : 0;
		margin-top : 10%;
		background:url('img/background5.jpg') no-repeat center center;
		background-size:cover;
	}
</style>
</head>
<body>
<div class="container">
		<h1 class="page-header">新用户注册</h1>	
		<div class="col-sm-offset-3 col-sm-6">
		<form  class="form-horizontal" action="/blog-jsp/register" method="post">
			<div class="form-group">
				<label class="col-sm-4 control-label">姓名：</label>
					<input type="text" name="name" class="form-control" >
					<font color="red">*</font>
			</div><br>
			<div class="form-group">
				<label class="col-sm-4 control-label">昵称：</label>
					<input type="text" name="nickname" class="form-control" >
					<font color="red">*</font>
			</div><br>
			<div class="form-group">
				<label class="control-label col-sm-4">密码：</label>
					<input type="password" name="password" class="form-control" >
					<font color="red">*</font>
			</div><br>
			<div class="form-group">
				<label class="col-sm-4 control-label">电话：</label>
					<input type="text" name="phone" class="form-control" >
					<font color="red">*</font>
			</div><br>
			<div class="form-group">
				<label class="control-label col-sm-4">邮件：</label>
					<input type="text" name="email" class="form-control">
					<font color="red">*</font>
			</div><br>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-success">注册</button>
				</div>
			</div><br>
	</form>
	</div>
	</div>
</body>
</html>