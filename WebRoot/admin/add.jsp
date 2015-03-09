<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>  
  <body>
    <form action="/netbank/admin/kaihu" method="post" name="myform">
    	<div align="center">
    		<table width="450"class="table">
    			<tbody>
    				<tr>
    					<td>用户名：</td>
    				 	<td>&nbsp;
    				 		<input type="text" name="account.username" value="${account.username}"/>
    				 	</td>
    				</tr>
    				<tr>
    					<td>密码：</td>
    				 	<td>&nbsp;
    				 		<input type="password" name="account.password" value="${account.password}"/>
    				 	</td>
    				</tr>
    				<tr>
    					<td>确认密码：</td>
    				 	<td>
    				 		<input type="password" name="account.confirmpwd" id="confirmpwd"/>
    				 		<span style="color:red;">*</span>
    				 		<span style="color:red;display:none;" id="secondpwd">两次密码不一致</span>
    				 	</td>
    				</tr>
    				<tr>
    					<td>开户金额：</td>
    				 	<td>&nbsp;
    				 		<input type="text" name="account.balance" value="${account.balance}"/>
    				 	</td>
    				</tr>
    				<tr>
    					<td>姓名：</td>
    				 	<td>&nbsp;
    				 		<input type="text" name="personinfo.realname" value="${personinfo.realname}"/>
    				 	</td>
    				</tr>
    				<tr>
    					<td>年龄：</td>
    				 	<td>&nbsp;
    				 		<input type="text" name="personinfo.age" value="${personinfo.age}"/>
    				 	</td>
    				</tr>
    				<tr>
    					<td>性别：</td>
    				 	<td>&nbsp;
    				 		<select name="personinfo.sex" >
    				 			<option value="m">m</option>
    				 			<option value="f">f</option>
    				 		</select>
    				 	</td>
    				</tr>
    				<tr>
    					<td>家庭住址：</td>
    				 	<td>&nbsp;
                      		<input type="text" name="personinfo.address" value="${personinfo.address}"/>
    				 	</td>
    				</tr>
    				<tr>
    					<td>联系电话：</td>
    				 	<td>&nbsp;
                      		<input type="text" name="personinfo.telephone" value="${personinfo.telephone}"/>
                      		<font size="1" style="color:red;">区号(3或4位)-电话(8或9位)</font>
    				 	</td>
    				</tr>
    				<tr>
    					<td>证件号码：</td>
    				 	<td>&nbsp;
                      		<input type="text" name="personinfo.cardid" value="${personinfo.cardid}"/>
                      		<font size="1" style="color:red;">15或18位</font>
    				 	</td>
    				</tr>	
    				
    				<tr>
    					<td>&nbsp;</td>
    				 	<td><input type="submit" value="提交" /></td>
    				</tr>
    			</tbody>
    		</table>
    		<div style="color:red;">
    			<s:fielderror />
    		</div>
    	</div>
    </form>
  </body>
</html>

