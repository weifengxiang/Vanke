<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/parttimejobenroll/editbaseparttimejobenroll.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addeditbaseparttimejobenrollform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>任务号:</label></th>
					<td><input class="easyui-textbox" name="jobCode"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报名号:</label></th>
					<td><input class="easyui-textbox" name="code"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>渠道号:</label></th>
					<td><input class="easyui-textbox" name="chaCode"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报名时间:</label></th>
					<td><input class="easyui-textbox" name="enrollDate"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>状态(0:报名;1:录用):</label></th>
					<td><input class="easyui-textbox" name="state"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-save'
		onclick="submitAddEditBaseParttimeJobEnrollForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>