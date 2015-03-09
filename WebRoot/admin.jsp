<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <table cellpadding=0 cellspacing=0 width=200 align="center" class="table">
    	<tr>
    		<td height=25 align="center" bgcolor="#DBC2B0">
    			<b>后台管理</b>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<table cellpadding=0 cellspacing=0 align="center" width=180 class="table">
    				<tr>
    					<td height=20><a href="/netbank/admin/listUsers?status.id=0" target="right">所有账户</a></td>
    				</tr>
    				<tr>
    					<td height=20><a href="/netbank/admin/listUsers?status.id=2" target="right">已冻结账户</a></td>
    				</tr>
    				<tr>
    					<td height=20><a href="/netbank/admin/listUsers?status.id=1" target="right">已启用账户</a></td>
    				</tr>
    				<tr>
    					<td height=20><a href="/netbank/admin/add.jsp" target="right">开户</a></td>
    				</tr>
    				<tr>
    					<td height=20><a href="/netbank/changeadminpwd.jsp" target="right">修改个人密码</a></td>
    				</tr>
    				<tr>
    					<td height=20><a href="/netbank/admin/logout" target="_top">注销</a></td>
    				</tr>

    			</table>
    		</td>
    	</tr>
    </table>
  </body>
</html>
