<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<script type="text/javascript">
		function select(){
			var curPage = document.getElementById("curPage").value;
			location.href="/netbank/transaction/list?pager.curPage=" + curPage;			
		}
	</script>
  </head>
  
  <body>
    <table width="450" border="1" class="table">
    	<tbody align="center">
    		<tr>
    			<td colspan="5" style="font-size:20;">交易记录</td>
    		</tr>
    		<tr>
    			<td width="50">&nbsp;序号</td>
    			<td width="80">&nbsp;对方账户</td>
    			<td width="80">&nbsp;交易金额</td>
    			<td width="80">&nbsp;交易类型</td>
    			<td >&nbsp;交易日期</td>
    		</tr>	
    		<s:iterator value="#request.logs" status="status">
    		<tr>
    			<td>&nbsp;<s:property value="#status.count" /></td>		
    			<s:if test="otherid==#session.user.accountid && transactionType.name!='deposit'">
    			<td>&nbsp;<s:property value="account.accountid" /></td>
    			<td>&nbsp;-<s:property value="trMoney" /></td>	
    			</s:if>
    			<s:else>
    			<td>&nbsp;<s:property value="otherid" /></td>
    			<td>&nbsp;<s:property value="trMoney" /></td>
    			</s:else>
    			<td><s:property value="transactionType.name" /></td>
    			<td>&nbsp;<s:property value="datetime" /></td>
    		</s:iterator>    		
    	</tbody>
    </table>
    
    <!-- 分页超链接部分 -->
    <table>
    	<tr>
    		<td width="10"></td>
    		<td width="130">
    			<s:if test="pager.curPage>1">
    				<a href='/netbank/transaction/list?pager.curPage=1'>首页</a>&nbsp;&nbsp;
    				<a href='/netbank/transaction/list?pager.curPage=${pager.curPage-1}'>上一页</a>
    			</s:if>
    		</td>
    		<td width="130">
    			<s:if test="pager.curPage<pager.pageCount">
    				<a href='/netbank/transaction/list?pager.curPage=${pager.curPage+1}'>下一页</a>&nbsp;&nbsp;
    				<a href='/netbank/transaction/list?pager.curPage=${pager.pageCount}'>尾页</a>
    			</s:if>
    		</td>
    		<td>共${pager.curPage}/${pager.pageCount}页&nbsp;&nbsp;
    			转至<select onchange="select()" id="curPage">
    			<s:iterator begin="1" end="pager.pageCount" status="status" >
    			  	<s:if test="#status.count==pager.curPage">
    					<option value="${status.count}" selected="selected">${status.count}</option>
    				</s:if>
    				<s:else>
    					<option value="${status.count}">${status.count}</option>
    				</s:else>
    			</s:iterator>
    			</select>页
    		</td>
    </table>
  </body>
</html>
