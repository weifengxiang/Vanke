//初始化
function init(){
	$('#listbasecustomerdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseCustomer/getBaseCustomerByPage');
	$('#listbasecustomerdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加客户资源信息
 **/
function addBaseCustomer(){
	var opts={
				id:'addBaseCustomer',
				title:'添加客户资源信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseCustomer/initAddBaseCustomerPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseCustomerPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseCustomerPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除客户资源信息
 **/
function delBaseCustomer(){
	var checkeds=$('#listbasecustomerdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseCustomer/delBaseCustomer');
				var params = {
							"delRows":JSON.stringify(checkeds)
						};
				$.ajax({
		    		url:url,
		    		type: "POST",
		    		data:params,
		    		dataType:'json',
		    		success:function(data){
		    			SKY_EASYUI.unmask();
		    			$.messager.alert("提示",data.name,"info");
		    			if(data.code != '0'){
		    				$('#listbasecustomerdg').datagrid('reload');
		    			}
		    		}
				});
			}else{
				return;
			}
		}
		);
	}
}
/**
*修改客户资源信息
**/
function editBaseCustomer(){
	var checkeds=$('#listbasecustomerdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseCustomer',
				title:'修改客户资源信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseCustomer/initEditBaseCustomerPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseCustomerPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseCustomerPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseCustomer(){
	var checkeds=$('#listbasecustomerdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseCustomer',
				title:'客户资源信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseCustomer/initDetailBaseCustomerPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseCustomerPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseCustomerPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbasecustomerdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseCustomer/getBaseCustomerByPage');
	$('#listbasecustomerdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var name =$('#q_name').textbox("getValue");
			if(name){
				ft.put("name@=", name);
			}
			var sex =$('#q_sex').textbox("getValue");
			if(sex){
				ft.put("sex@=", sex);
			}
			var age =$('#q_age').textbox("getValue");
			if(age){
				ft.put("age@=", age);
			}
			var tel =$('#q_tel').textbox("getValue");
			if(tel){
				ft.put("tel@=", tel);
			}
			var hobby =$('#q_hobby').textbox("getValue");
			if(hobby){
				ft.put("hobby@=", hobby);
			}
			var careerType =$('#q_careerType').textbox("getValue");
			if(careerType){
				ft.put("careerType@=", careerType);
			}
			var workUnit =$('#q_workUnit').textbox("getValue");
			if(workUnit){
				ft.put("workUnit@=", workUnit);
			}
			var positionLevel =$('#q_positionLevel').textbox("getValue");
			if(positionLevel){
				ft.put("positionLevel@=", positionLevel);
			}
			var monthIncome =$('#q_monthIncome').textbox("getValue");
			if(monthIncome){
				ft.put("monthIncome@=", monthIncome);
			}
			var marriage =$('#q_marriage').textbox("getValue");
			if(marriage){
				ft.put("marriage@=", marriage);
			}
			var spouseCareer =$('#q_spouseCareer').textbox("getValue");
			if(spouseCareer){
				ft.put("spouseCareer@=", spouseCareer);
			}
			var spouseUnit =$('#q_spouseUnit').textbox("getValue");
			if(spouseUnit){
				ft.put("spouseUnit@=", spouseUnit);
			}
			var familyStructure =$('#q_familyStructure').textbox("getValue");
			if(familyStructure){
				ft.put("familyStructure@=", familyStructure);
			}
			var familyNum =$('#q_familyNum').textbox("getValue");
			if(familyNum){
				ft.put("familyNum@=", familyNum);
			}
			var childAge =$('#q_childAge').textbox("getValue");
			if(childAge){
				ft.put("childAge@=", childAge);
			}
			var livingProvince =$('#q_livingProvince').textbox("getValue");
			if(livingProvince){
				ft.put("livingProvince@=", livingProvince);
			}
			var livingCity =$('#q_livingCity').textbox("getValue");
			if(livingCity){
				ft.put("livingCity@=", livingCity);
			}
			var livingArea =$('#q_livingArea').textbox("getValue");
			if(livingArea){
				ft.put("livingArea@=", livingArea);
			}
			var familyAddress =$('#q_familyAddress').textbox("getValue");
			if(familyAddress){
				ft.put("familyAddress@=", familyAddress);
			}
			var workAddress =$('#q_workAddress').textbox("getValue");
			if(workAddress){
				ft.put("workAddress@=", workAddress);
			}
			var knowWay =$('#q_knowWay').textbox("getValue");
			if(knowWay){
				ft.put("knowWay@=", knowWay);
			}
			var housePurpose =$('#q_housePurpose').textbox("getValue");
			if(housePurpose){
				ft.put("housePurpose@=", housePurpose);
			}
			var totalBudget =$('#q_totalBudget').textbox("getValue");
			if(totalBudget){
				ft.put("totalBudget@=", totalBudget);
			}
			var creditCondition =$('#q_creditCondition').textbox("getValue");
			if(creditCondition){
				ft.put("creditCondition@=", creditCondition);
			}
			var targetYt =$('#q_targetYt').textbox("getValue");
			if(targetYt){
				ft.put("targetYt@=", targetYt);
			}
			var targetLayout =$('#q_targetLayout').textbox("getValue");
			if(targetLayout){
				ft.put("targetLayout@=", targetLayout);
			}
			var targetArea =$('#q_targetArea').textbox("getValue");
			if(targetArea){
				ft.put("targetArea@=", targetArea);
			}
			var acceptP1 =$('#q_acceptP1').textbox("getValue");
			if(acceptP1){
				ft.put("acceptP1@=", acceptP1);
			}
			var acceptP2 =$('#q_acceptP2').textbox("getValue");
			if(acceptP2){
				ft.put("acceptP2@=", acceptP2);
			}
			var acceptP3 =$('#q_acceptP3').textbox("getValue");
			if(acceptP3){
				ft.put("acceptP3@=", acceptP3);
			}
			var resistance =$('#q_resistance').textbox("getValue");
			if(resistance){
				ft.put("resistance@=", resistance);
			}
			var competitor =$('#q_competitor').textbox("getValue");
			if(competitor){
				ft.put("competitor@=", competitor);
			}
			var visitTime =$('#q_visitTime').textbox("getValue");
			if(visitTime){
				ft.put("visitTime@=", visitTime);
			}
			var saleTeam =$('#q_saleTeam').textbox("getValue");
			if(saleTeam){
				ft.put("saleTeam@=", saleTeam);
			}
			var propertyConsultant =$('#q_propertyConsultant').textbox("getValue");
			if(propertyConsultant){
				ft.put("propertyConsultant@=", propertyConsultant);
			}
			var registrant =$('#q_registrant').textbox("getValue");
			if(registrant){
				ft.put("registrant@=", registrant);
			}
			var state =$('#q_state').textbox("getValue");
			if(state){
				ft.put("state@=", state);
			}
			var remark =$('#q_remark').textbox("getValue");
			if(remark){
				ft.put("remark@=", remark);
			}
			return ft.getJSON();
		}
	});
}