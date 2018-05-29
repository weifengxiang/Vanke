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
	   style="width:100%; height:63px; padding:0px;" cellpadding="0">
<table class='noborder'>
	<tr style="height: 34px">
		<th><label>任务编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入任务编号'" name="q_code"  id="q_code" ></input></td>				
		<th><label>任务名称:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入任务名称'" name="q_name"  id="q_name" ></input></td>				
		<th><label>意向楼盘:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入意向楼盘'" name="q_premises"  id="q_premises" ></input></td>				
		<th><label>薪资:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入薪资'" name="q_salary"  id="q_salary" ></input></td>				
		<th><label>工作时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入工作时间'" name="q_workTimes"  id="q_workTimes" ></input></td>				
		<th><label>工作地点:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入工作地点'" name="q_workPlace"  id="q_workPlace" ></input></td>				
		<th><label>需求人数:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入需求人数'" name="q_reqNum"  id="q_reqNum" ></input></td>				
		<th><label>结算方式:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入结算方式'" name="q_settlementType"  id="q_settlementType" ></input></td>				
		<th><label>岗位综述:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入岗位综述'" name="q_postMsg"  id="q_postMsg" ></input></td>				
		<th><label>岗位要求:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入岗位要求'" name="q_postReq"  id="q_postReq" ></input></td>				
		<th><label>其他信息:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入其他信息'" name="q_otherMgs"  id="q_otherMgs" ></input></td>				
		<th><label>简历投递:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入简历投递'" name="q_resumeType"  id="q_resumeType" ></input></td>				
		<th><label>任务开始时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入任务开始时间'" name="q_jobBegin"  id="q_jobBegin" ></input></td>				
		<th><label>任务结束时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入任务结束时间'" name="q_jobEnd"  id="q_jobEnd" ></input></td>				
		<th><label>报名截止时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报名截止时间'" name="q_enrollEnd"  id="q_enrollEnd" ></input></td>				
		<th><label>发布人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入发布人'" name="q_pubUser"  id="q_pubUser" ></input></td>				
		<th><label>发布单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入发布单位'" name="q_pubOrg"  id="q_pubOrg" ></input></td>				
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
				<th data-options="field:'code',width:180,
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
				<th data-options="field:'salary',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">薪资</th>
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
				<th data-options="field:'reqNum',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">需求人数</th>
				<th data-options="field:'settlementType',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">结算方式</th>
				<th data-options="field:'postMsg',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">岗位综述</th>
				<th data-options="field:'postReq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">岗位要求</th>
				<th data-options="field:'otherMgs',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">其他信息</th>
				<th data-options="field:'resumeType',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">简历投递</th>
				<th data-options="field:'jobBegin',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">任务开始时间</th>
				<th data-options="field:'jobEnd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">任务结束时间</th>
				<th data-options="field:'enrollEnd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报名截止时间</th>
				<th data-options="field:'pubUser',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">发布人</th>
				<th data-options="field:'pubOrg',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">发布单位</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addLandParttimeJob()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editLandParttimeJob()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delLandParttimeJob()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailLandParttimeJob()">查看明细</a>
</div>
</body>
</html>