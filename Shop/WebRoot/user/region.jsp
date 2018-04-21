<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="/Shop/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/Shop/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/Shop/js/region.js"></script>
	<link rel="stylesheet" type="text/css" href="/Shop/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/Shop/css/region.css">
    
  </head>
  
  <body>
  <div class="nav">
      <div class="logo">
         <img src="/Shop/images/logo.gif">
      </div>
      <div class="logo">欢迎注册</div>
  </div>
  <div class="formdata">
    <form method="POST" action="controller/UserControl" class="form-horizontal" role="form">
	    <div class="form-group">
		    <label for="name" class="col-sm-2 control-label">姓名<font color="red">*</font></label>
		    <div class="col-sm-10">
		      <input type="text" onchange="check_username();"  class="form-control"  placeholder="请输入姓名" name="username" id="username">
		       <div id="tips_name" style="color:red;font-size:15px;display:none;">用户名已存在!!!</div>
		    </div>
        </div>
	    <div class="form-group">
		    <label for="passowrd" class="col-sm-2 control-label">密码<font color="red">*</font></label>
		    <div class="col-sm-10">
		      <input type="password" onchange="check_password();" class="form-control"  placeholder="请输入6位数字密码" name="password" id="password" >
			  <div id="tips_check_pass" style="color:red;font-size:15px;display:none;">密码长度不对!!!</div>
		    </div>
      </div>
      <div class="form-group">
		    <label for="passowrd" class="col-sm-2 control-label">确认密码<font color="red">*</font></label>
		    <div class="col-sm-10">
		      <input type="password" onchange="password_sure();" class="form-control"  placeholder="请确认密码" name="surepassword" id="surepassword" >
		      <div id="tips_pass" style="color:red;font-size:15px;display:none;">密码与确认密码不一致，请重新输入!!!</div>
		    </div>
      </div>
      
	   <div class="form-group">
		    <label for="telnum" class="col-sm-2 control-label">电话<font color="red">*</font></label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="lastname" placeholder="请输入11位的手机号码" name="telnum" >
		    </div>
	  </div>
	   <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn btn-primary btn-lg">注册</button>
		    </div>
	  </div> 
    </form>
   </div>
  </body>
</html>
