<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <style>  
        #test  
        {  
            position: absolute;  
            top: 10px;  
            right: 10px;  
            width: 130px;  
            height: 60px;  
            background: #555;  
            color: #fff;  
            font-size: 13px;  
        }  
    </style> 
<script type="text/javascript" src="/Shop/js/jquery-3.3.1.min.js"></script>
  <script language="javascript">  
        $(document).ready(function () {  
            var menuYloc = $("#test").offset().top;  
            $(window).scroll(function () {  
                var offsetTop = menuYloc + $(window).scrollTop() + "px";  
                $("#test").animate({ top: offsetTop }, { duration: 600, queue: false });  
            });  
        });   
    </script> 
</head>
	<body>
	<div id="test">
	 <a href="/Shop/goods/shopping_car.jsp"><img src="/Shop/images/car.jpg"  width="400px;" height="100px;" style="float:right;"></a>
	</div>
<div>
 
  <% Cookie[] cookies = request.getCookies(); 
 
  if(cookies != null && cookies.length > 0){
     if(cookies.length == 1){%>
       <a href="/Shop/user/login.jsp">亲，请登陆 </a> 
    <% }
      if((cookies.length>1)&&(cookies[1].getValue()!=null)){
       String name =java.net.URLDecoder.decode(cookies[1].getValue(),"UTF-8");
      %>
                                 欢迎，<%=name %>|<a href="/Shop/controller/Login?action=logout">退出</a>
       <% }
        if((cookies.length>1)&&(cookies[1].getValue()==null)){%>
            <a href="/Shop/user/login.jsp">亲，请登陆 </a>
      <% } 
      
   }else{ %>
        <a href="/Shop/user/login.jsp">亲，请登陆 </a> 
   
   <% }

  %>
    |   <a href="/Shop/user/region.jsp"> 没有账号？免费注册</a>
 </div>
  
</body>
</html>