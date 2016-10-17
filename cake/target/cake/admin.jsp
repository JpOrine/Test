<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" 
						+ request.getServerName() + ":" 
						+ request.getServerPort() + path + "/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" >
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱心蛋糕</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/reset.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/admin/admin.css">
</head>
<body>
	<div id="slick-login">
		<span><h2>后台管理中心</h2></span></br></br>
        <label for="username">username</label><input type="text" name="username" class="placeholder" placeholder="用户名">
        <label for="password">password</label><input type="password" name="password" class="placeholder" placeholder="密码">
        <label for="code">code</label><input style="width: 100px;" type="text" name="code" class="placeholder" placeholder="验证码">
        <img title="点击刷新" src="<%=basePath %>admin/loginCode" onclick="reloadcode(this,'<%=basePath%>')" /><em class="codeRestar"></em>
        <input type="submit" id="loginAdmin" value="Log In">
    </div>
</body>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/admin/login.js"></script>
</html>