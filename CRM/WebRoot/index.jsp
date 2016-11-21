<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>hello world</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
    <script type="text/javascript">
    	var _home = "<%=request.getContextPath()%>";
    </script>
    
    <script type="text/javascript">
    	$(function(){
    	
    		
    		$("#btn").click(function(){
    			var param={};
    			param.userName=$("#userName").val();
    			param.password=$("#password").val();
    			param.vcode=$("#vcode").val();
    			console.log(param);
        		$.post(_home+"/system/regUser.forward",param,function(data){
        			console.log(data.results.success);
        		},"json")	
    		})
    		
    		
    		
    		$("getCode").click(function(){
    			var path = $(this).attr("src");
        		$(this).attr("src",path+"?date="+new Date());
    		})	
    	})

    	
    	
    
    	
    </script>
    
    
  </head>
  
  
  
  
  <body>
    
    userName:<input type="text" name="userName" id="userName">
    password:<input type="text" name="password" id="password">
    vcode:<input type="text" name="vcode"  id="vcode"   >

    <img alt="验证码" src="<%=request.getContextPath()%>/getCode"  onclick="refresh(this)" id="getCode" >
    
    
    <input type="button" id="btn"  name="btn" value="提交">
    <img alt="xxx" src="<%=request.getContextPath()%>/images/webIco.png">
    
  </body>
</html>
