<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <form action="user/changepwd" method="post" name="myform" onsubmit="check()">
    	<div align="center">
    		<table width="400" border="0" class="table">
    			<tbody>
    				<tr>
    					<td>&nbsp;当前密码：</td>
    				 	<td>
    				 		<input type="password" name="pwd.oldpwd" id="oldpwd"/>
    				 		<span style="color:red;">*<s:fielderror/></span>
    				 	</td>
    				</tr>
    				<tr>
    					<td>&nbsp;新密码：</td>
    				 	<td>
    				 		<input type="password" name="pwd.newpwd" id="newpwd"/>
    				 		<span style="color:red;">*</span>
    				 	</td>
    				</tr>
    				<tr>
    					<td>&nbsp;确认密码：</td>
    				 	<td>
    				 		<input type="password" name="pwd.confirmpwd" id="confirmpwd"/>
    				 		<span style="color:red;">*</span>
    				 		<span style="color:red;display:none;" id="secondpwd">两次密码不一致</span>
    				 	</td>
    				</tr>
    				<tr>
    					<td>&nbsp;</td>
    				 	<td>&nbsp;
                      		<input type="submit" value="修改"/>
    				 	</td>
    				</tr>	
    			</tbody>
    		</table>
    	</div>
    </form>
  </body>
</html>
