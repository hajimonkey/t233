<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<title>AppInfoSystem</title>
	<!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath }/css/nprogress.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/css/custom.min.css" rel="stylesheet">
</head>
<body class="login">
 <div>
  <div class="login_wrapper">
  	<div class="animate form login_form">
  	 
  	 	<h1>APP信息管理平台</h1>
  	 	<div>
  	 		<a href="${pageContext.request.contextPath }/backendLogin">后台管理员入口</a>
  	 	</div>
  	 	<div>
  	 		<a href="${pageContext.request.contextPath }/devLogin">开发者用户入口</a>
  	 	</div>
  	</div>
  </div>
 </div>
</body>
</html>
