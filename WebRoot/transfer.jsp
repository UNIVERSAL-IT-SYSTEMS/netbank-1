<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body onload="disptime()">
	<form action="/netbank/transaction/transfer" method="post" onsubmit="transfer()">
		<div align="center">
			<table width="400" border="0" class="table">
				<tbody>
					<tr>
						<td>&nbsp;转账时间：</td>
						<td><input type="text" name="log.datetime" id="datetime"></td>
					</tr>
					<tr>
						<td width="100">&nbsp;对方账户：</td>
						<td>
							<input type="text" name="log.otherid" id="otherid" value="${log.otherid}">
							<span id="errorotherid" style="color:red"></span>
						</td>						
					</tr>
					<tr>
						<td>&nbsp;转账金额：</td>
						<td>
							<input type="text" name="log.trMoney" id="trMoney" value="${log.trMoney}">
							<span id="errormoney" style="color:red"></span>
						</td>						
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;<input type="submit" value="转账"></td>
					</tr>
				</tbody>
			</table>
			<div style="color:red">
				<s:fielderror />
			</div>
		</div>
	</form>
  </body>
</html>
