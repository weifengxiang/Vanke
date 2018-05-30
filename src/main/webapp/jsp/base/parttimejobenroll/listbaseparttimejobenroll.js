//初始化
function init(){
	$('#listbaseparttimejobenrolldg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollByPage');
	$('#listbaseparttimejobenrolldg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加兼职报名信息
 **/
function addBaseParttimeJobEnroll(){
	var opts={
				id:'addBaseParttimeJobEnroll',
				title:'添加兼职报名信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/initAddBaseParttimeJobEnrollPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseParttimeJobEnrollPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseParttimeJobEnrollPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除兼职报名信息
 **/
function delBaseParttimeJobEnroll(){
	var checkeds=$('#listbaseparttimejobenrolldg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/delBaseParttimeJobEnroll');
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
		    				$('#listbaseparttimejobenrolldg').datagrid('reload');
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
*修改兼职报名信息
**/
function editBaseParttimeJobEnroll(){
	var checkeds=$('#listbaseparttimejobenrolldg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseParttimeJobEnroll',
				title:'修改兼职报名信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/initEditBaseParttimeJobEnrollPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseParttimeJobEnrollPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseParttimeJobEnrollPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseParttimeJobEnroll(){
	var checkeds=$('#listbaseparttimejobenrolldg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseParttimeJobEnroll',
				title:'兼职报名信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/initDetailBaseParttimeJobEnrollPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseParttimeJobEnrollPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseParttimeJobEnrollPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbaseparttimejobenrolldg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollByPage');
	$('#listbaseparttimejobenrolldg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var jobCode =$('#q_jobCode').textbox("getValue");
			if(jobCode){
				ft.put("jobCode@=", jobCode);
			}
			var code =$('#q_code').textbox("getValue");
			if(code){
				ft.put("code@=", code);
			}
			var chaCode =$('#q_chaCode').textbox("getValue");
			if(chaCode){
				ft.put("chaCode@=", chaCode);
			}
			var enrollDate =$('#q_enrollDate').textbox("getValue");
			if(enrollDate){
				ft.put("enrollDate@=", enrollDate);
			}
			var state =$('#q_state').textbox("getValue");
			if(state){
				ft.put("state@=", state);
			}
			return ft.getJSON();
		}
	});
}