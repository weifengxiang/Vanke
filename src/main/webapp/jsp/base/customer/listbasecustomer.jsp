<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/customer/listbasecustomer.js'></script>
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
				<th data-options="field:'name',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">姓名</th>
				<th data-options="field:'sex',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">性别</th>
				<th data-options="field:'age',width:180,
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
						}}">联系电话</th>
				<th data-options="field:'hobby',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">兴趣爱好</th>
				<th data-options="field:'careerType',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">职业类型</th>
				<th data-options="field:'workUnit',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">工作单位</th>
				<th data-options="field:'positionLevel',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">职位等级</th>
				<th data-options="field:'monthIncome',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">月均收入</th>
				<th data-options="field:'marriage',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">婚姻状况</th>
				<th data-options="field:'spouseCareer',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">配偶职业</th>
				<th data-options="field:'spouseUnit',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">配偶单位</th>
				<th data-options="field:'familyStructure',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">家庭结构</th>
				<th data-options="field:'familyNum',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">家庭人数</th>
				<th data-options="field:'childAge',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">小孩年龄</th>
				<th data-options="field:'livingProvince',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">现居省份</th>
				<th data-options="field:'livingCity',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">现居城市</th>
				<th data-options="field:'livingArea',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">现居区域</th>
				<th data-options="field:'familyAddress',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">家庭地址</th>
				<th data-options="field:'workAddress',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">工作地址</th>
				<th data-options="field:'knowWay',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">认知途径</th>
				<th data-options="field:'housePurpose',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">置业目的</th>
				<th data-options="field:'totalBudget',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">整体预算</th>
				<th data-options="field:'creditCondition',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">信贷情况</th>
				<th data-options="field:'targetYt',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">目标业态</th>
				<th data-options="field:'targetLayout',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">目标房型</th>
				<th data-options="field:'targetArea',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">目标面积</th>
				<th data-options="field:'acceptP1',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">认可点1</th>
				<th data-options="field:'acceptP2',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">认可点2</th>
				<th data-options="field:'acceptP3',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">认可点3</th>
				<th data-options="field:'resistance',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">主要抗性</th>
				<th data-options="field:'competitor',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">考虑竞品</th>
				<th data-options="field:'visitTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">来访时间</th>
				<th data-options="field:'saleTeam',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">销售团队</th>
				<th data-options="field:'propertyConsultant',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">置业顾问</th>
				<th data-options="field:'registrant',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">接待人</th>
				<th data-options="field:'state',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">状态</th>
				<th data-options="field:'remark',width:180,
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