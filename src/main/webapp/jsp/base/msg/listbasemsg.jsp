<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/msg/listbasemsg.js'></script>
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
		<th><label>消息编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入消息编号'" name="q_code"  id="q_code" ></input></td>				
		<th><label>消息内容:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入消息内容'" name="q_content"  id="q_content" ></input></td>				
		<th><label>发送人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入发送人'" name="q_sender"  id="q_sender" ></input></td>				
		<th><label>发送时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入发送时间'" name="q_sendTime"  id="q_sendTime" ></input></td>				
		<th><label>发送方式:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入发送方式'" name="q_sendType"  id="q_sendType" ></input></td>				
		<th><label>接收人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入接收人'" name="q_receiver"  id="q_receiver" ></input></td>				
		<th><label>接收时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入接收时间'" name="q_receiveTime"  id="q_receiveTime" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="我的消息管理">
<table  id="listbasemsgdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listbasemsgdg',rowIndex);
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
						}}">消息编号</th>
				<th data-options="field:'content',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">消息内容</th>
				<th data-options="field:'sender',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">发送人</th>
				<th data-options="field:'sendTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">发送时间</th>
				<th data-options="field:'sendType',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">发送方式</th>
				<th data-options="field:'receiver',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">接收人</th>
				<th data-options="field:'receiveTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">接收时间</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addBaseMsg()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editBaseMsg()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delBaseMsg()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailBaseMsg()">查看明细</a>
</div>
</body>
</html>