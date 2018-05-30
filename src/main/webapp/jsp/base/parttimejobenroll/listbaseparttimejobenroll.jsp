<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/parttimejobenroll/listbaseparttimejobenroll.js'></script>
<script type="text/javascript">
$(function() {
	init();
});
</script> 
</head>
<body class="easyui-layout" style="width: 100%; height: 100%; padding: 0; border: 0"
	  data-options='border:false,fit:true'>
<div data-options="region:'north',split:false,collapsible:false,iconCls:'icon-search'" class="easyui-panel" title="查询条件"
	   style="width:100%; height:63px; padding:0px;" cellpadding="0">
<table class='noborder'>
	<tr style="height: 34px">
		<th><label>任务号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入任务号'" name="q_jobCode"  id="q_jobCode" ></input></td>				
		<th><label>报名号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报名号'" name="q_code"  id="q_code" ></input></td>				
		<th><label>渠道号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入渠道号'" name="q_chaCode"  id="q_chaCode" ></input></td>				
		<th><label>报名时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报名时间'" name="q_enrollDate"  id="q_enrollDate" ></input></td>				
		<th><label>状态(0:报名;1:录用):</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入状态(0:报名;1:录用)'" name="q_state"  id="q_state" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="兼职报名信息管理">
<table  id="listbaseparttimejobenrolldg" class="easyui-datagrid" style="width: 100%; height: 100%"
	data-options="
			region:'center',
			fit:true,
			border:false,
			remoteSort : false,
			toolbar: '#tb',
			pagination:true,
			rownumbers: true,
			checkbox:true,
			singleSelect:true,
			selectOnCheck:false,
			checkOnSelect:false,
			onDblClickRow:function(rowIndex, rowData){
								//SKY_EASYUI.beginEdit('listbaseparttimejobenrolldg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'jobCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">任务号</th>
				<th data-options="field:'code',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报名号</th>
				<th data-options="field:'chaCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">渠道号</th>
				<th data-options="field:'enrollDate',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报名时间</th>
				<th data-options="field:'state',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">状态(0:报名;1:录用)</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addBaseParttimeJobEnroll()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editBaseParttimeJobEnroll()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delBaseParttimeJobEnroll()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailBaseParttimeJobEnroll()">查看明细</a>
</div>
</body>
</html>