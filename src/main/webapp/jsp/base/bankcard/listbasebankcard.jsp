<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/bankcard/listbasebankcard.js'></script>
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
		<th><label>开户行:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入开户行'" name="q_bankCode"  id="q_bankCode" ></input></td>				
		<th><label>卡号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入卡号'" name="q_cardCode"  id="q_cardCode" ></input></td>				
		<th><label>渠道编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入渠道编号'" name="q_chaCode"  id="q_chaCode" ></input></td>				
		<th><label>绑定日期:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入绑定日期'" name="q_bindingDate"  id="q_bindingDate" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="银行卡信息管理">
<table  id="listbasebankcarddg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listbasebankcarddg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'bankCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">开户行</th>
				<th data-options="field:'cardCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">卡号</th>
				<th data-options="field:'chaCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">渠道编号</th>
				<th data-options="field:'bindingDate',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">绑定日期</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addBaseBankCard()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editBaseBankCard()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delBaseBankCard()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailBaseBankCard()">查看明细</a>
</div>
</body>
</html>