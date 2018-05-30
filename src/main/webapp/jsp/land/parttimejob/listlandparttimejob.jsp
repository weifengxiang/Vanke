<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/land/parttimejob/listlandparttimejob.js'></script>
<script type="text/javascript">
$(function() {
	init();
});
</script> 
</head>
<body class="easyui-layout" style="width: 100%; height: 100%; padding: 0; border: 0"
	  data-options='border:false,fit:true'>
<div data-options="region:'north',split:false,collapsible:false,iconCls:'icon-search'" class="easyui-panel" title="查询条件"
	   style="width:100%; height:100px; padding:0px;" cellpadding="0">
<table class='noborder'>
	<tr style="height: 34px">
		<th><label>任务编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入任务编号'" name="q_code"  id="q_code" ></input></td>				
		<th><label>任务名称:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入任务名称'" name="q_name"  id="q_name" ></input></td>				
		<th><label>意向楼盘:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入意向楼盘'" name="q_premises"  id="q_premises" ></input></td>				
		<th><label>工作地点:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入工作地点'" name="q_workPlace"  id="q_workPlace" ></input></td>				
	</tr>
	<tr style="height: 34px">
		<th><label>任务开始时间:</label></th>
		<td><input  class="easyui-datebox" data-options="prompt:'输入任务开始时间'" name="q_jobBegin"  id="q_jobBegin" ></input></td>				
		<th><label>任务结束时间:</label></th>
		<td><input  class="easyui-datebox" data-options="prompt:'输入任务结束时间'" name="q_jobEnd"  id="q_jobEnd" ></input></td>				
		<th><label>报名截止时间:</label></th>
		<td><input  class="easyui-datebox" data-options="prompt:'输入报名截止时间'" name="q_enrollEnd"  id="q_enrollEnd" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="兼职任务信息管理">
<table  id="listlandparttimejobdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listlandparttimejobdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'code',width:90,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">任务编号</th>
				<th data-options="field:'name',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">任务名称</th>
				<th data-options="field:'premises',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">意向楼盘</th>
				<th data-options="field:'workTimes',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">工作时间</th>
				<th data-options="field:'workPlace',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">工作地点</th>
				<th data-options="field:'reqNum',width:90,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">需求人数</th>
				<th data-options="field:'jobBegin',width:100,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">任务开始时间</th>
				<th data-options="field:'jobEnd',width:100,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">任务结束时间</th>
				<th data-options="field:'enrollEnd',width:100,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报名截止时间</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addLandParttimeJob()">发布</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editLandParttimeJob()">编辑</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delLandParttimeJob()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailLandParttimeJob()">查看明细</a>
</div>
</body>
</html>