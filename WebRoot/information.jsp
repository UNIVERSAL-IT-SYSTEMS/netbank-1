<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <table width="450" border="1" class="table">
    	<tbody>
    		<tr>
    			<td>账户：</td>
    			<td>&nbsp;${user.accountid}</td>
    		</tr>
    		<tr>
    			<td>姓名：</td>
    			<td>&nbsp;${personinfo.realname}</td>
    		</tr>
    		<tr>
    			<td>年龄：</td>
    			<td>&nbsp;${personinfo.age}</td>
    		</tr>
    		<tr>
    			<td>性别：</td>
    			<td>&nbsp;${personinfo.sex}</td>
    		</tr>
    		<tr>
    			<td>家庭住址：</td>
    			<td>&nbsp;${personinfo.address}</td>
    		</tr>
    		<tr>
    			<td>联系电话：</td>
    			<td>&nbsp;${personinfo.telephone}</td>
    		</tr>
    		<tr>
    			<td>证件号码：</td>
    			<td>&nbsp;${personinfo.cardid}</td>
    		</tr>
    		<tr>
    			<td>账户余额：</td>
    			<td>&nbsp;${user.balance}</td>
    		</tr>
    	</tbody>
    </table>
  </body>
</html>
