<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/base/customer/detailbasecustomer.js'></script>
<script type="text/javascript">
var CAREER_TYPE=<%=DictUtils.getDictItem("CAREER_TYPE")%>;//职业类型
var FAMILY_STRUCTURE=<%=DictUtils.getDictItem("FAMILY_STRUCTURE")%>;//家庭结构
var MARRIAGE=<%=DictUtils.getDictItem("MARRIAGE")%>;//婚姻状况
var TARGET_LAYOUT=<%=DictUtils.getDictItem("TARGET_LAYOUT")%>;//目标房型
var CREDIT_CONDITION=<%=DictUtils.getDictItem("CREDIT_CONDITION")%>;//信贷情况
var HOUSE_PURPOSE=<%=DictUtils.getDictItem("HOUSE_PURPOSE")%>;//置业目的
var TARGET_YT=<%=DictUtils.getDictItem("TARGET_YT")%>;//目标业态
var TOTAL_BUDGET=<%=DictUtils.getDictItem("TOTAL_BUDGET")%>;//整体预算
var AGE=<%=DictUtils.getDictItem("AGE")%>;//年龄
var MONTH_INCOME=<%=DictUtils.getDictItem("MONTH_INCOME")%>;//月均收入
var TARGET_AREA=<%=DictUtils.getDictItem("TARGET_AREA")%>;//目标面积
var CUSTOMER_STATE=<%=DictUtils.getDictItem("CUSTOMER_STATE")%>;
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt',fit:true">
		<form id="detailbasecustomerform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<div style="width:100%;height:auto;padding:0px;">
				<div class="easyui-panel" title="基本属性" collapsible="true" style="width:100%;height:auto;padding:0px;">
				  <table style="width:100%">
					  <tr>
						<th><label>姓名:</label></th>
						<td><input class="easyui-textbox" name="name"
							data-options="required:true"></input></td>
						<th><label>性别:</label></th>
						<td>
							<input type="radio" name="sex" value='M' checked>男</input>
							<input type="radio" name="sex" value='F'>女</input>
						</td>
					  </tr>
					  <tr>
						<th><label>年龄:</label></th>
						<td><input class="easyui-textbox" name="age"
							></input></td>
						<th><label>联系电话:</label></th>
						<td><input class="easyui-textbox" name="tel"
							></input></td>
					  </tr>
					  <tr>
						<th><label>兴趣爱好:</label></th>
						<td colspan='3'>
							<input class="easyui-textbox" name="hobby" style='width:550px'
							></input></td>
					  </tr>
				  </table>
				</div>
				<div class="easyui-panel" title="职业属性" collapsible="true" style="width:100%;height:auto;padding:0px;">
					<table style="width:100%">
					  <tr>
						<th><label>职业类型:</label></th>
						<td><input class="easyui-combobox" name="careerType"
							data-options="required:true,editable:false,
									data:CAREER_TYPE,
									valueField:'code',    
									textField:'name'"></input></td>
						<th><label>工作单位:</label></th>
						<td><input class="easyui-textbox" name="workUnit"
							></input></td>
					  </tr>
					  <tr>
						<th><label>职位等级:</label></th>
						<td><input class="easyui-textbox" name="positionLevel"
							></input></td>
						<th><label>月均收入:</label></th>
						<td><input class="easyui-combobox" name="monthIncome"
							data-options="required:true,editable:false,
									data:MONTH_INCOME,
									valueField:'code',    
									textField:'name'"></input></td>
					  </tr>
					  <tr>
						<th><label>配偶单位:</label></th>
						<td><input class="easyui-textbox" name="spouseUnit"
							></input></td>
						<th><label>配偶职业:</label></th>
						<td><input class="easyui-combobox" name="spouseCareer"
							data-options="required:true,editable:false,
									data:CAREER_TYPE,
									valueField:'code',    
									textField:'name'"></input></td>
					  </tr>
				   </table>
				</div>
				<div class="easyui-panel" title="家庭属性" collapsible="true" style="width:100%;height:auto;padding:0px;">
					<table style="width:100%">
					  <tr>
						<th><label>婚姻状况:</label></th>
						<td><input class="easyui-combobox" name="marriage"
							data-options="required:true,editable:false,
									data:MARRIAGE,
									valueField:'code',    
									textField:'name'"></input></td>
						<th><label>家庭结构:</label></th>
						<td><input class="easyui-combobox" name="familyStructure"
							data-options="required:true,editable:false,
									data:FAMILY_STRUCTURE,
									valueField:'code',    
									textField:'name'"></input></td>
					  </tr>
					  <tr>
						<th><label>家庭人数:</label></th>
						<td><input class="easyui-numberbox" name="familyNum"
							data-options="min:1,max:10,precision:0"></input></td>
						<th><label>小孩年龄:</label></th>
						<td><input class="easyui-numberbox" name="childAge"
							data-options="min:1,max:18,precision:0"></input></td>
					  </tr>
				  </table>
				</div>
				<div class="easyui-panel" title="地理属性" collapsible="true" style="width:100%;height:auto;padding:0px;">
					<table style="width:100%">
					  <tr>
						<th><label>现居省份:</label></th>
						<td><input class="easyui-combobox" name="livingProvince" id="livingProvince"
							data-options="url:SKY.urlCSRF(basepath+'sys/SysArea/listSysAreaByPid/100000'),
                                          valueField:'id',
                                          textField:'name',
                                          onSelect:function(area){
                                          $('#livingCity').combobox('clear');
                                          $('#livingArea').combobox('clear');
                                          $('#livingCity').combobox('reload',SKY.urlCSRF(basepath+'sys/SysArea/listSysAreaByPid/'+area.id)),
                                          $('#livingArea').combobox('reload',SKY.urlCSRF(basepath+'sys/SysArea/listSysAreaByPid/0'))}"></input></td>
						<th><label>现居城市:</label></th>
						<td><input class="easyui-combobox" name="livingCity" id="livingCity"
							data-options="url:SKY.urlCSRF(basepath+'sys/SysArea/listSysAreaByPid/0'),
                                          valueField:'id',
                                          textField:'name',
                                          onSelect:function(area){
                                          $('#livingArea').combobox('clear');
                                          $('#livingArea').combobox('reload',SKY.urlCSRF(basepath+'sys/SysArea/listSysAreaByPid/'+area.id))
                                          }"></input></td>
					  </tr>
					  <tr>
						<th><label>现居区域:</label></th>
						<td colspan='3'><input class="easyui-combobox" name="livingArea" id="livingArea"
										data-options="url:SKY.urlCSRF(basepath+'sys/SysArea/listSysAreaByPid/0'),
						                              valueField:'id',
                                          			  textField:'name'"></input></td>
					  </tr>
					  <tr>
						<th><label>家庭地址:</label></th>
						<td colspan='3'><input class="easyui-textbox" name="familyAddress" style='width:550px'
							></input></td>
					  </tr>
					  <tr>
						<th><label>工作地址:</label></th>
						<td colspan='3'><input class="easyui-textbox" name="workAddress" style='width:550px'
							></input></td>
					  </tr>
				  	</table>
				</div>
				<div class="easyui-panel" title="营销属性" collapsible="true" style="width:100%;height:auto;padding:0px;">
					<table style="width:100%">
						  <tr>
							<th><label>认知途径:</label></th>
							<td><input class="easyui-textbox" name="knowWay"
								></input></td>
							<th><label>置业目的:</label></th>
							<td><input class="easyui-combobox" name="housePurpose"
								data-options="required:true,editable:false,
									data:HOUSE_PURPOSE,
									valueField:'code',    
									textField:'name'"></input></td>
						  </tr>
						  <tr>
							<th><label>整体预算:</label></th>
							<td><input class="easyui-combobox" name="totalBudget"
								data-options="required:true,editable:false,
									data:TOTAL_BUDGET,
									valueField:'code',
									textField:'name'"></input></td>
							<th><label>信贷情况:</label></th>
							<td><input class="easyui-combobox" name="creditCondition"
								data-options="required:true,editable:false,
									data:CREDIT_CONDITION,
									valueField:'code',    
									textField:'name'"></input></td>
						  </tr>
						  <tr>
							<th><label>目标业态:</label></th>
							<td><input class="easyui-combobox" name="targetYt"
								data-options="required:true,editable:false,
									data:TARGET_YT,
									valueField:'code',    
									textField:'name'"></input></td>
							<th><label>目标房型:</label></th>
							<td><input class="easyui-combobox" name="targetLayout"
								data-options="required:true,editable:false,
									data:TARGET_LAYOUT,
									valueField:'code',    
									textField:'name'"></input></td>
						  </tr>
						  <tr>
							<th><label>目标面积:</label></th>
							<td><input class="easyui-combobox" name="targetArea"
								data-options="required:true,editable:false,
									data:TARGET_AREA,
									valueField:'code',    
									textField:'name'"></input></td>
							<th><label>认可点1:</label></th>
							<td><input class="easyui-textbox" name="acceptP1"
								></input></td>
						  </tr>
						  <tr>
							<th><label>认可点2:</label></th>
							<td><input class="easyui-textbox" name="acceptP2"
								></input></td>
							<th><label>认可点3:</label></th>
							<td><input class="easyui-textbox" name="acceptP3"
								></input></td>
						  </tr>
						  <tr>
							<th><label>主要抗性:</label></th>
							<td><input class="easyui-textbox" name="resistance"
								></input></td>
							<th><label>考虑竞品:</label></th>
							<td><input class="easyui-textbox" name="competitor"
								></input></td>
						  </tr>
						  <tr>
							<th><label>销售团队:</label></th>
							<td><input class="easyui-textbox" name="saleTeam"
								></input></td>
							<th><label>置业顾问:</label></th>
							<td><input class="easyui-textbox" name="propertyConsultant"
								></input></td>
						  </tr>
						  <tr>
							<th><label>状态:</label></th>
							<td><input class="easyui-combobox" name="state"
								data-options="required:true,editable:false,
									data:CUSTOMER_STATE,
									valueField:'code',    
									textField:'name'"></input></td>
							<th><label>来访时间:</label></th>
							<td><input class="easyui-datebox" name="visitTime"
								></input></td>
						  </tr>
						  <tr>
							<th><label>备注:</label></th>
							<td colspan='3'><input class="easyui-textbox" name="remark" 
							data-options="multiline:true" style='width:550px;height:100px;'></input></td>
						  </tr>
					</table>
				</div>
				<div class="easyui-panel" title="拓展情况" collapsible="true" style="width:100%;height:auto;padding:0px;">
					<table style="width:100%">
						  <tr>
							<th><label>拓展时间:</label></th>
							<td><input class="easyui-datebox" name="expandTime"
								></input></td>
							<th><label>拓展顾问:</label></th>
							<td><input class="easyui-textbox" name="expandPropertyCon"
								></input></td>
						  </tr>
					</table>
				</div>
			</div>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
<style type="text/css">
.panel-body{
	background:#f0f0f0;
}
.panel-header{
	background:#fff url('../../skin/images/panel_header_bg.gif') no-repeat top right;
}
.panel-tool-collapse{
	background:url('../../skin/images/arrow_up.gif') no-repeat 0px -3px;
}
.panel-tool-expand{
	background:url('../../skin/images/arrow_down.gif') no-repeat 0px -3px;
}
</style>
</html>