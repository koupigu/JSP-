<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>  <style>
* { margin: 0; padding: 0; }
         html { height: 100%; }
         body {height: 100%; background:#F8F8FF url(img/background.jpg) 100% 100% no-repeat; background-size: cover;}
         .dowebok { position: absolute; left: 50%; top: 40%; width: 430px; height: 500px; margin: -215px 0 0 -215px; border: 1px solid LightPink; border-radius: 20px; overflow: hidden;}
         .logo { width: 400px; height: 50px; margin: 50px auto 80px;  background-size:60%;}
        .form-item {position: relative; width: 360px; margin: 0 auto; padding-bottom: 30px;}
         .form-item input {width: 288px; height: 48px; padding-left: 70px; border: 1px solid LavenderBlush; border-radius: 25px; font-size: 18px; color: LavenderBlush; background-color: transparent; outline: none;}
         .form-item button {width: 288px; height: 50px; border: 0; border-radius: 25px; font-size: 18px; color: #1f6f4a; outline: none; cursor: pointer; background-color: #fffcc; }
         .reg-bar { width: 360px; margin: 20px auto 0; font-size: 14px; overflow: hidden;}
         .reg-bar a { color: #fff; text-decoration: none; }
         .reg-bar a:hover { text-decoration: underline; }
         .reg-bar .reg { float: left; }
         .reg-bar .forget { float: right; }
         .dowebok ::-webkit-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
         .dowebok :-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
         .dowebok ::-moz-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
         .dowebok :-ms-input-placeholder { font-size: 18px; line-height: 1.4; color: #fff;}
        
    }
  </style>

</head>
<body>


	<div class="dowebok">
         <div class="logo"><br>
         <p style="text-align:center"><font face="Bradley Hand ITC" size="50" color="#87CEEB">welcome</font></p>
         </div> <center>
        <form class="form-horizontal">
         <div class="form-item">
             <input id="username" type="text" color="#000999"autocomplete="off" name="username" placeholder="账号";>
         </div>
         <div class="form-item">
             <input id="password" type="password" autocomplete="off" name="password" placeholder="密码">
         </div>
         <div class="form-item"><button id="submit" class="btn btn-success">登 录</button></div>
         <div class="reg-bar">
             <a class="reg" href="register.jsp">立即注册</a>
          </div>
 	 </div>
 	 <div class="form-group">
					<div class="col-sm-offset-4 col-sm-6">
					</div>
				</div>
     </form>
</body>
</html>