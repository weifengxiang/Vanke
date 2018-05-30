//初始化
function init(){
	$('#listlandparttimejobdg').datagrid('options').url=SKY.urlCSRF(basepath+'land/LandParttimeJob/getLandParttimeJobByPage');
	$('#listlandparttimejobdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加兼职任务信息
 **/
function addLandParttimeJob(){
	var opts={
				id:'addLandParttimeJob',
				title:'添加兼职任务信息',
				width:700,
				height:550,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'land/LandParttimeJob/initAddLandParttimeJobPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddLandParttimeJobPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddLandParttimeJobPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除兼职任务信息
 **/
function delLandParttimeJob(){
	var checkeds=$('#listlandparttimejobdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'land/LandParttimeJob/delLandParttimeJob');
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
		    				$('#listlandparttimejobdg').datagrid('reload');
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
*修改兼职任务信息
**/
function editLandParttimeJob(){
	var checkeds=$('#listlandparttimejobdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editLandParttimeJob',
				title:'修改兼职任务信息',
				width:700,
				height:550,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'land/LandParttimeJob/initEditLandParttimeJobPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditLandParttimeJobPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditLandParttimeJobPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailLandParttimeJob(){
	var checkeds=$('#listlandparttimejobdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailLandParttimeJob',
				title:'兼职任务信息明细',
				width:700,
				height:550,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'land/LandParttimeJob/initDetailLandParttimeJobPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailLandParttimeJobPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailLandParttimeJobPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listlandparttimejobdg').datagrid('options').url=SKY.urlCSRF(basepath+'land/LandParttimeJob/getLandParttimeJobByPage');
	$('#listlandparttimejobdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var code =$('#q_code').textbox("getValue");
			if(code){
				ft.put("code@like", "%"+code+"%");
			}
			var name =$('#q_name').textbox("getValue");
			if(name){
				ft.put("name@like", "%"+name+"%");
			}
			var premises =$('#q_premises').textbox("getValue");
			if(premises){
				ft.put("premises@like", "%"+premises+"%");
			}
			var workPlace =$('#q_workPlace').textbox("getValue");
			if(workPlace){
				ft.put("workPlace@like", "%"+workPlace+"%");
			}
			var jobBegin =$('#q_jobBegin').datebox("getValue");
			if(jobBegin){
				ft.put("jobBegin@>=", jobBegin);
			}
			var jobEnd =$('#q_jobEnd').datebox("getValue");
			if(jobEnd){
				ft.put("jobEnd@<=", jobEnd);
			}
			var enrollEnd =$('#q_enrollEnd').datebox("getValue");
			if(enrollEnd){
				ft.put("enrollEnd@=", enrollEnd);
			}
			return ft.getJSON();
		}
	});
}
/**
*报名人员管理
**/
function manageChannel(){
	var checkeds=$('#listlandparttimejobdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'manageChannel',
				title:'报名人员管理',
				width:900,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'land/LandParttimeJob/initManageChannel'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailLandParttimeJobPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailLandParttimeJobPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}