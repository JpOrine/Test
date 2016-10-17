<%@page import="org.aspectj.weaver.patterns.TypePatternQuestions.Question"%>
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin/index.css">
<title>蛋糕管理系统</title>
</head>
<body>
	<h1>欢迎登录</h1>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/admin/index.js"></script>
<script type="text/javascript">
</script>
</html>