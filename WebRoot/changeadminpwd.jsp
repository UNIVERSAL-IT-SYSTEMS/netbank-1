<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  	<form action="/netbank/admin/changepwd" method="post" >
  		<table align="center">
  		<tr>
  		<td>&nbsp;&nbsp;</td>
  		</tr>
    	<tr>
    		<td>
    			&nbsp;用户名：
    		</td>
    		<td>
    			<input type="text" value="${admin.username}" name="admin.username" />
    		</td>
    	</tr>
    	<tr>
    		<td>
    			&nbsp;密码：
    		</td>
    		<td>
    			<input type="password" value="${admin.pwd}" name="admin.pwd" />
    		</td>
    	</tr>
    	<tr>
    		<td/>
    		<td>
    			<input type="submit" value="提交" align="middle" />
    		</td>
    	</tr>
    </table>
  	</form>   
  </body>
</html>
