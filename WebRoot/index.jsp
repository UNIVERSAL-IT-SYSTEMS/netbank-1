<%@ page contentType="text/html;charset=gb2312" import="java.sql.*,java.util.*"%>
<%
	if(session.getAttribute("user") == null){  
%>
	<jsp:forward page="login.jsp"></jsp:forward>	
<%
	}
%>	

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>网上银行</title>
  </head>
  
  <frameset framespacing="0" border="false" cols="270,*" frameborder="no">
  	<frame name="left" scrolling="no" marginwidth="0" marginheight="0" src="/netbank/left.jsp">
  	<frame name="right" scrolling="yes" src="/netbank/information.jsp">
  </frameset>
  <noframes>
  </noframes>

</html>
