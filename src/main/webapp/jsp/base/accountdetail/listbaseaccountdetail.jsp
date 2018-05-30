<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/accountdetail/listbaseaccountdetail.js'></script>
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
		<th><label>编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入编号'" name="q_code"  id="q_code" ></input></td>				
		<th><label>账户编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入账户编号'" name="q_accountCode"  id="q_accountCode" ></input></td>				
		<th><label>收支方向(+:收入;-:支出):</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入收支方向(+:收入;-:支出)'" name="q_target"  id="q_target" ></input></td>				
		<th><label>金额:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入金额'" name="q_amount"  id="q_amount" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="账户明细管理">
<table  id="listbaseaccountdetaildg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listbaseaccountdetaildg',rowIndex);
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
				<th data-options="field:'accountCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">账户编号</th>
				<th data-options="field:'target',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">收支方向(+:收入;-:支出)</th>
				<th data-options="field:'amount',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">金额</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addBaseAccountDetail()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editBaseAccountDetail()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delBaseAccountDetail()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailBaseAccountDetail()">查看明细</a>
</div>
</body>
</html>