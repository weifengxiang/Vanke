<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/land/parttimejob/editlandparttimejob.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addeditlandparttimejobform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>任务编号:</label></th>
					<td><input class="easyui-textbox" name="code"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>任务名称:</label></th>
					<td><input class="easyui-textbox" name="name"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>意向楼盘:</label></th>
					<td><input class="easyui-textbox" name="premises"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>薪资:</label></th>
					<td><input class="easyui-textbox" name="salary"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>工作时间:</label></th>
					<td><input class="easyui-textbox" name="workTimes"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>工作地点:</label></th>
					<td><input class="easyui-textbox" name="workPlace"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>需求人数:</label></th>
					<td><input class="easyui-textbox" name="reqNum"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>结算方式:</label></th>
					<td><input class="easyui-textbox" name="settlementType"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>岗位综述:</label></th>
					<td><input class="easyui-textbox" name="postMsg"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>岗位要求:</label></th>
					<td><input class="easyui-textbox" name="postReq"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>其他信息:</label></th>
					<td><input class="easyui-textbox" name="otherMgs"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>简历投递:</label></th>
					<td><input class="easyui-textbox" name="resumeType"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>任务开始时间:</label></th>
					<td><input class="easyui-textbox" name="jobBegin"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>任务结束时间:</label></th>
					<td><input class="easyui-textbox" name="jobEnd"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报名截止时间:</label></th>
					<td><input class="easyui-textbox" name="enrollEnd"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>发布人:</label></th>
					<td><input class="easyui-textbox" name="pubUser"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>发布单位:</label></th>
					<td><input class="easyui-textbox" name="pubOrg"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-save'
		onclick="submitAddEditLandParttimeJobForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>