<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
	<!-- 查询用户表单部分 -->
	<form action="/netbank/admin/search" method="post">
		输入要查询的用户的真实姓名:
		<input name="personinfo.realname" />
		<input name="status.id" type="hidden" value="${status.id}" />
		&nbsp;&nbsp;&nbsp;<input type="submit" value="提交"/>		
	</form>
	
	<table width="100%" height="73" border="1" align="center" cellpadding="0" 
		cellspacing="0" bordercolor="#999999" bgcolor="#999999">
		<!-- 用户信息显示表头部分 -->
		<tr>
			<td height="20" nowrap bgcolor="#999999">
				<div align="center"><font color="#FFFFFF">序号</font></div>
			</td>
			<td nowrap bgcolor="#999999">
				<div align="center"><font color="#FFFFFF">账户</font></div>
			</td>
			<td nowrap bgcolor="#999999">
				<div align="center"><font color="#FFFFFF">用户名</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">账户余额</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">姓名</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">详细地址</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">身份证号</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">电话</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">状态</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">操作</font></div>
			</td>
			<td nowrap bgcolor="#808080">
				<div align="center"><font color="#FFFFFF">&nbsp;</font></div>
			</td>
		</tr>
		
		<!-- 循环显示用户信息部分 -->
		<s:iterator	value="#request.users" status="status">
		<tr bgcolor="#FFFFFF">
			<td height="20" valign="middle">
				<div id="noWrap" align="center"><s:property value="#status.count" /></div>
			</td>
			<td valign="middle">
				<div id="noWrap" align="center"><s:property value="account.accountid" /></div>
			</td>
			<td valign="middle">
				<div id="noWrap" align="center"><s:property value="account.username" /></div>
			</td>
			<td height="20" valign="middle">
				<div id="noWrap" align="center"><s:property value="account.balance" /></div>
			</td>
			<td height="20" valign="middle">
				<div id="noWrap" align="center"><s:property value="realname" /></div>
			</td>
			<td height="20" valign="middle">
				<div id="noWrap" align="center"><s:property value="address" /></div>
			</td>
			<td height="20" valign="middle">
				<div id="noWrap" align="center"><s:property value="cardid" /></div>
			</td>
			<td height="20" valign="middle">
				<div id="noWrap" align="center"><s:property value="telephone" /></div>
			</td>
			<td height="20" valign="middle">
				<div id="noWrap" align="center"><s:property value="account.status.name" /></div>
			</td>
			<td>
				<div id="noWrap" align="center">
					<s:if test="account.status.name=='active'">
						<input type="button" value="frozen" onclick="javascript:location.href='/netbank/admin/locking?id=${account.accountid}&status.id=${status.id}'">
					</s:if>
					<s:else>
						<input type="button" value="active" onclick="javascript:location.href='/netbank/admin/enabled?id=${account.accountid}&status.id=${status.id}'">
					</s:else>
				</div>
			</td>
			<td valign="middle">
				<div id="noWrap" align="center">
					<a href="/netbank/admin/del?id=${account.accountid}&status.id=${status.id}" >&nbsp;删除&nbsp;</a>
				</div>
			</td>
		</tr>
		</s:iterator>
		<tr>
			<td height="20" colspan="14" valign="middle">
			</td>
	</table>
  </body>
</html>
