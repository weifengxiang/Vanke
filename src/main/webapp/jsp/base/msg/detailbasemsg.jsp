<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/msg/detailbasemsg.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailbasemsgform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>消息编号:</label></th>
					<td><input class="easyui-textbox" name="code"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>消息内容:</label></th>
					<td><input class="easyui-textbox" name="content"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>发送人:</label></th>
					<td><input class="easyui-textbox" name="sender"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>发送时间:</label></th>
					<td><input class="easyui-textbox" name="sendTime"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>发送方式:</label></th>
					<td><input class="easyui-textbox" name="sendType"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>接收人:</label></th>
					<td><input class="easyui-textbox" name="receiver"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>接收时间:</label></th>
					<td><input class="easyui-textbox" name="receiveTime"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>