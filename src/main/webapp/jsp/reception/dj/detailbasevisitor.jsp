<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/reception/dj/detailbasevisitor.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailbasevisitorform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>姓名:</label></th>
					<td><input class="easyui-textbox" name="name"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>性别:</label></th>
					<td><input class="easyui-textbox" name="sex"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>年龄:</label></th>
					<td><input class="easyui-textbox" name="age"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>联系电话:</label></th>
					<td><input class="easyui-textbox" name="tel"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>兴趣爱好:</label></th>
					<td><input class="easyui-textbox" name="hobby"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>职业类型:</label></th>
					<td><input class="easyui-textbox" name="careerType"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>工作单位:</label></th>
					<td><input class="easyui-textbox" name="workUnit"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>职位等级:</label></th>
					<td><input class="easyui-textbox" name="positionLevel"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>月均收入:</label></th>
					<td><input class="easyui-textbox" name="monthIncome"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>婚姻状况:</label></th>
					<td><input class="easyui-textbox" name="marriage"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>配偶职业:</label></th>
					<td><input class="easyui-textbox" name="spouseCareer"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>配偶单位:</label></th>
					<td><input class="easyui-textbox" name="spouseUnit"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>家庭结构:</label></th>
					<td><input class="easyui-textbox" name="familyStructure"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>家庭人数:</label></th>
					<td><input class="easyui-textbox" name="familyNum"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>小孩年龄:</label></th>
					<td><input class="easyui-textbox" name="childAge"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>现居省份:</label></th>
					<td><input class="easyui-textbox" name="livingProvince"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>现居城市:</label></th>
					<td><input class="easyui-textbox" name="livingCity"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>现居区域:</label></th>
					<td><input class="easyui-textbox" name="livingArea"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>家庭地址:</label></th>
					<td><input class="easyui-textbox" name="familyAddress"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>工作地址:</label></th>
					<td><input class="easyui-textbox" name="workAddress"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>认知途径:</label></th>
					<td><input class="easyui-textbox" name="knowWay"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>置业目的:</label></th>
					<td><input class="easyui-textbox" name="housePurpose"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>整体预算:</label></th>
					<td><input class="easyui-textbox" name="totalBudget"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>信贷情况:</label></th>
					<td><input class="easyui-textbox" name="creditCondition"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>目标业态:</label></th>
					<td><input class="easyui-textbox" name="targetYt"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>目标房型:</label></th>
					<td><input class="easyui-textbox" name="targetLayout"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>目标面积:</label></th>
					<td><input class="easyui-textbox" name="targetArea"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>认可点1:</label></th>
					<td><input class="easyui-textbox" name="acceptP1"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>认可点2:</label></th>
					<td><input class="easyui-textbox" name="acceptP2"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>认可点3:</label></th>
					<td><input class="easyui-textbox" name="acceptP3"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>主要抗性:</label></th>
					<td><input class="easyui-textbox" name="resistance"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>考虑竞品:</label></th>
					<td><input class="easyui-textbox" name="competitor"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>来访时间:</label></th>
					<td><input class="easyui-textbox" name="visitTime"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>销售团队:</label></th>
					<td><input class="easyui-textbox" name="saleTeam"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>置业顾问:</label></th>
					<td><input class="easyui-textbox" name="propertyConsultant"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>状态:</label></th>
					<td><input class="easyui-textbox" name="state"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td><input class="easyui-textbox" name="remark"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>