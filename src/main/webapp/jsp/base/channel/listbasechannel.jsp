<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/channel/listbasechannel.js'></script>
<script type="text/javascript">
var SEX=<%=DictUtils.getDictItem("SEX")%>;
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
		<th><label>姓名:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入姓名'" name="q_name"  id="q_name" ></input></td>				
		<th><label>性别:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入性别'" name="q_sex"  id="q_sex" ></input></td>				
		<th><label>年龄:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入年龄'" name="q_age"  id="q_age" ></input></td>				
		<th><label>电话:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入电话'" name="q_tel"  id="q_tel" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="渠道人才信息管理">
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
				<th data-options="field:'code',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">编号</th>
				<th data-options="field:'name',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">姓名</th>
				<th data-options="field:'sex',width:90,
				editor:{
						type:'textbox',
						options:{
							required:true
						}},
				formatter: function(value,row,index){
					return SKY.formatterEnum(value,row,SEX);
				}">性别</th>
				<th data-options="field:'age',width:90,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">年龄</th>
				<th data-options="field:'tel',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">电话</th>
				<th data-options="field:'workDate',width:90,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">工作时间</th>
				<th data-options="field:'remark',width:400,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">备注</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addBaseChannel()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editBaseChannel()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delBaseChannel()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailBaseChannel()">查看明细</a>
</div>
</body>
</html>