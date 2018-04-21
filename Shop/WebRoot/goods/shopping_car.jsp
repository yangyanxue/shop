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
   width:150px;
   hieght:100px;
  }
 table th, table td {  
  text-align: center;  
  vertical-align: middle!important;  
}

</style>
</head>
	
<body>
  <jsp:include page="../user/top.jsp"/>
   <table align="center" class="table table-hover" style="width:800px">
    	<thead>
		<tr>
			<th>名称</th>
			<th>图片</th>
			<th>价格</th>
			<th>件数</th>
			<th>颜色</th>
			<th>型号</th>
		</tr>
	</thead>
     <tbody>
      <% ArrayList<Goods> list = (ArrayList<Goods>)session.getAttribute("car"); 
      if(list == null || list.size()==0) { %>
        <tr>
            <td colspan="6">暂无数据</td>
        </tr>
      <%}else{
         for(int i = 0;i<list.size();i++){
             Goods good = list.get(i);%>
             <tr>
				<td><%=good.getName() %></td>
				<td><img src=<%=good.getImages() %> ></td>
				<td>￥<%=good.getNow_price() %></td>
				<td>1</td>
				<td><%=good.getColor() %></td>
				<td><%=good.getSize() %></td>
		    </tr>
         <% }
      }%>
		
		
	</tbody>
     
     
     
   </table>   
</body>
</html>