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
		<th><label>性别:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入性别'" name="q_sex"  id="q_sex" ></input></td>				
		<th><label>年龄:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入年龄'" name="q_age"  id="q_age" ></input></td>				
		<th><label>联系电话:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入联系电话'" name="q_tel"  id="q_tel" ></input></td>				
		<th><label>兴趣爱好:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入兴趣爱好'" name="q_hobby"  id="q_hobby" ></input></td>				
		<th><label>职业类型:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入职业类型'" name="q_careerType"  id="q_careerType" ></input></td>				
		<th><label>工作单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入工作单位'" name="q_workUnit"  id="q_workUnit" ></input></td>				
		<th><label>职位等级:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入职位等级'" name="q_positionLevel"  id="q_positionLevel" ></input></td>				
		<th><label>月均收入:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入月均收入'" name="q_monthIncome"  id="q_monthIncome" ></input></td>				
		<th><label>婚姻状况:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入婚姻状况'" name="q_marriage"  id="q_marriage" ></input></td>				
		<th><label>配偶职业:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入配偶职业'" name="q_spouseCareer"  id="q_spouseCareer" ></input></td>				
		<th><label>配偶单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入配偶单位'" name="q_spouseUnit"  id="q_spouseUnit" ></input></td>				
		<th><label>家庭结构:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入家庭结构'" name="q_familyStructure"  id="q_familyStructure" ></input></td>				
		<th><label>家庭人数:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入家庭人数'" name="q_familyNum"  id="q_familyNum" ></input></td>				
		<th><label>小孩年龄:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入小孩年龄'" name="q_childAge"  id="q_childAge" ></input></td>				
		<th><label>现居省份:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入现居省份'" name="q_livingProvince"  id="q_livingProvince" ></input></td>				
		<th><label>现居城市:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入现居城市'" name="q_livingCity"  id="q_livingCity" ></input></td>				
		<th><label>现居区域:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入现居区域'" name="q_livingArea"  id="q_livingArea" ></input></td>				
		<th><label>家庭地址:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入家庭地址'" name="q_familyAddress"  id="q_familyAddress" ></input></td>				
		<th><label>工作地址:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入工作地址'" name="q_workAddress"  id="q_workAddress" ></input></td>				
		<th><label>认知途径:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入认知途径'" name="q_knowWay"  id="q_knowWay" ></input></td>				
		<th><label>置业目的:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入置业目的'" name="q_housePurpose"  id="q_housePurpose" ></input></td>				
		<th><label>整体预算:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入整体预算'" name="q_totalBudget"  id="q_totalBudget" ></input></td>				
		<th><label>信贷情况:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入信贷情况'" name="q_creditCondition"  id="q_creditCondition" ></input></td>				
		<th><label>目标业态:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入目标业态'" name="q_targetYt"  id="q_targetYt" ></input></td>				
		<th><label>目标房型:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入目标房型'" name="q_targetLayout"  id="q_targetLayout" ></input></td>				
		<th><label>目标面积:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入目标面积'" name="q_targetArea"  id="q_targetArea" ></input></td>				
		<th><label>认可点1:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入认可点1'" name="q_acceptP1"  id="q_acceptP1" ></input></td>				
		<th><label>认可点2:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入认可点2'" name="q_acceptP2"  id="q_acceptP2" ></input></td>				
		<th><label>认可点3:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入认可点3'" name="q_acceptP3"  id="q_acceptP3" ></input></td>				
		<th><label>主要抗性:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入主要抗性'" name="q_resistance"  id="q_resistance" ></input></td>				
		<th><label>考虑竞品:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入考虑竞品'" name="q_competitor"  id="q_competitor" ></input></td>				
		<th><label>来访时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入来访时间'" name="q_visitTime"  id="q_visitTime" ></input></td>				
		<th><label>销售团队:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入销售团队'" name="q_saleTeam"  id="q_saleTeam" ></input></td>				
		<th><label>置业顾问:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入置业顾问'" name="q_propertyConsultant"  id="q_propertyConsultant" ></input></td>				
		<th><label>接待人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入接待人'" name="q_registrant"  id="q_registrant" ></input></td>				
		<th><label>状态:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入状态'" name="q_state"  id="q_state" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_remark"  id="q_remark" ></input></td>				
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