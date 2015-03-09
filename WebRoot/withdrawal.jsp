<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body onload="disptime()">
	<form action="/netbank/transaction/withdrawal" method="post" onsubmit="withdrawal()">
		<div align="center">
			<table width="400" border="0" class="table">
				<tbody>
					<tr>
						<td width="100">&nbsp;取款时间：</td>
						<td><input type="text" name="log.datetime" id="datetime"></td>
					</tr>
					<tr>
						<td>&nbsp;取款金额：</td>
						<td>
							<input type="text" name="log.trMoney" id="trMoney" value="${log.trMoney}">
							<span id="errormoney" style="color:red"></span>
						</td>						
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;<input type="submit" value="取款"></td>
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
