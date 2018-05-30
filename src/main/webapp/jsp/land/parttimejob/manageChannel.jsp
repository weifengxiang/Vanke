<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/land/parttimejob/manageChannel.js'></script>
<script type="text/javascript">
var ENROLL_STATE=<%=DictUtils.getDictItem("ENROLL_STATE")%>;
$(function() {
	init();
});
</script> 
</head>
<body class="easyui-layout" style="width: 100%; height: 100%; padding: 0; border: 0"
	  data-options='border:false,fit:true'>
<div data-options="region:'north',split:false,collapsible:false,iconCls:'icon-search'" class="easyui-panel" title="查询条件"
	   style="width:100%; height:65px; padding:0px;" cellpadding="0">
<table class='noborder'>
	<tr style="height: 34px">
		<th><label>状态:</label></th>
		<td><input  class="easyui-combobox" data-options="prompt:'请选择状态',editable:false,
									data:ENROLL_STATE,
									valueField:'code',    
									textField:'name'" name="q_state"  id="q_state" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="报名人员管理">
<table  id="listbasechanneldg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listbasechanneldg',rowIndex);
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
						}}">报名号</th>
				<th data-options="field:'chaCodeName',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报名人</th>
				<th data-options="field:'enrollDate',width:100,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报名时间</th>
				<th data-options="field:'state',width:100,
				editor:{
						type:'textbox',
						options:{
							required:true
						}},
				formatter: function(value,row,index){
					return SKY.formatterEnum(value,row,ENROLL_STATE);
				}">状态</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailBaseChannel()">查看明细</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="changState('1')">录用</a>
</div>
</body>
</html>