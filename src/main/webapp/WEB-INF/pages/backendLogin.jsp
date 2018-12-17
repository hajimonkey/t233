<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>开发者用户平台</title>
  <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath }/css/nprogress.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/css/custom.min.css" rel="stylesheet">
</head>
<body class="login">
	<div class="login_wrapper">
		<div class="animate form login_form">
          <section class="login_content">
            <form action="${pageContext.request.contextPath }/backendLogin" method="post">
              <h1>后台管理系统</h1>
              <div>
                <input name="backendName" type="text" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input name="backendPassword"  type="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
              <button class="btn btn-success" type="submit">登录</button>
              <button class="btn btn-default" type="reset">重填</button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">

                <div class="clearfix"></div>
                <br />

                <div>
                  
                  <p>©2016 All Rights Reserved.</p>
                </div>
              </div>
            </form>
          </section>
        </div>
	</div>
	
	
</body>
</html>