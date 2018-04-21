<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="model.Goods" %>
<%@ page import="java.util.*" %>
<%@ page import="controller.SearchGoods" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="/Shop/js/jquery.min.js"></script>
<!-- for bootstrap working -->
<script type="text/javascript" src="/Shop/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/Shop/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/Shop/css/bootstrap.min.css">
<style>
  img{
   width:200px;
   hieght:150px;
  }
  td{
   width:250px;
  }
  font{
    color:red;
  }


</style>
</head>
	
<body>
<jsp:include page="user/top.jsp"/>
   <table align="center">
     <tr>
       <td colspan="3" align="center" > 
           <form class="form-inline" role="form" method="POST" action="controller/SearchGoods?action=SearchGoods">
            <div class="input-group">
           
            <input type="text" class="form-control" style="width: auto;" name="name">
            <button type="submit" class="btn btn-primary">查询</button>
            
          </div>
           
           </form>
       </td>
     </tr>
     
       <tr>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
       </tr>
         <tr>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
       </tr>
         <tr>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
         <td><img src="/Shop/images/6.jpg" ><br> 原价:<font><s>￥58</s> </font>现价<font>￥38 </font><br>初春好看的衣服</td>
       </tr>
      
      
     
   </table>   
</body>
</html>