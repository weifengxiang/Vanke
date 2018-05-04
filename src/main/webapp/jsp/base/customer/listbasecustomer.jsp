<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/customer/listbasecustomer.js'></script>
<script type="text/javascript">
var CUSTOMER_STATE=<%=DictUtils.getDictItem("CUSTOMER_STATE")%>;
var SEX=<%=DictUtils.getDictItem("SEX")%>;
var AGE=<%=DictUtils.getDictItem("AGE")%>;
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
		<th><label>来访时间:</label></th>
		<td><input  class="easyui-datebox" data-options="prompt:'输入来访时间'" name="q_visitTime"  id="q_visitTime" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="客户资源信息管理">
<table  id="listbasecustomerdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listbasecustomerdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'name',width:100,
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
				<th data-options="field:'age',width:150,
				editor:{
						type:'textbox',
						options:{
							required:true
						}},
				formatter: function(value,row,index){
					return SKY.formatterEnum(value,row,AGE);
				}">年龄</th>
				<th data-options="field:'tel',width:150,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">联系电话</th>
				<th data-options="field:'visitTime',width:150,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">来访时间</th>
				<th data-options="field:'state',width:90,
				editor:{
						type:'textbox',
						options:{
							required:true
						}},
				formatter: function(value,row,index){
					return SKY.formatterEnum(value,row,CUSTOMER_STATE);
				}">状态</th>
				<th data-options="field:'remark',width:200,
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
		data-options="iconCls:'icon-add',plain:true" onclick="addBaseCustomer()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editBaseCustomer()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delBaseCustomer()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailBaseCustomer()">查看明细</a>
</div>
</body>
</html>