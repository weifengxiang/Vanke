<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/channel/detailbasechannel.js'></script>
<script type="text/javascript">
var EDUCATION=<%=DictUtils.getDictItem("EDUCATION")%>;
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailbasechannelform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>姓名:</label></th>
					<td><input class="easyui-textbox" name="name"
						data-options="required:true"></input></td>

					<th><label>性别:</label></th>
					<td>
						<input type="radio" name="sex" value='M' checked>男</input>
						<input type="radio" name="sex" value='F'>女</input>
					</td>
				  </tr>
				  <tr>
					<th><label>年龄:</label></th>
					<td><input class="easyui-numberbox" name="age"
						data-options="required:true"></input></td>
					
					<th><label>身份证号码:</label></th>
					<td><input class="easyui-textbox" name="idcard"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
				  	<th><label>电话:</label></th>
					<td><input class="easyui-textbox" name="tel"
						data-options="required:true"></input></td>
						
					<th><label>邮箱:</label></th>
					<td><input class="easyui-textbox" name="email"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>最高学历:</label></th>
					<td><input class="easyui-combobox" name="education"
						data-options="required:true,editable:false,
									data:EDUCATION,
									valueField:'code',    
									textField:'name'"></input></td>

					<th><label>毕业院校:</label></th>
					<td><input class="easyui-textbox" name="school"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>专业:</label></th>
					<td><input class="easyui-textbox" name="major"
						data-options="required:true"></input></td>

					<th><label>工作时间:</label></th>
					<td><input class="easyui-numberbox" name="workDate"
						data-options="required:true,precision:1"></input>年</td>
				  </tr>
				  <tr>
					<th><label>工作经历:</label></th>
					<td  colspan='3'><input class="easyui-textbox" name="workHis" style="width:80%;height:60px"
						data-options="multiline:true"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="remark" style="width:80%;height:60px"
						data-options="multiline:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>