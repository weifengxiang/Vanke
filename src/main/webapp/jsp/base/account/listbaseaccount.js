//初始化
function init(){
	$('#listbaseaccountdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseAccount/getBaseAccountByPage');
	$('#listbaseaccountdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加账户信息
 **/
function addBaseAccount(){
	var opts={
				id:'addBaseAccount',
				title:'添加账户信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseAccount/initAddBaseAccountPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseAccountPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseAccountPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除账户信息
 **/
function delBaseAccount(){
	var checkeds=$('#listbaseaccountdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseAccount/delBaseAccount');
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
		    				$('#listbaseaccountdg').datagrid('reload');
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
*修改账户信息
**/
function editBaseAccount(){
	var checkeds=$('#listbaseaccountdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseAccount',
				title:'修改账户信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseAccount/initEditBaseAccountPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseAccountPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseAccountPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseAccount(){
	var checkeds=$('#listbaseaccountdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseAccount',
				title:'账户信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseAccount/initDetailBaseAccountPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseAccountPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseAccountPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbaseaccountdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseAccount/getBaseAccountByPage');
	$('#listbaseaccountdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var code =$('#q_code').textbox("getValue");
			if(code){
				ft.put("code@=", code);
			}
			var chaCode =$('#q_chaCode').textbox("getValue");
			if(chaCode){
				ft.put("chaCode@=", chaCode);
			}
			var balance =$('#q_balance').textbox("getValue");
			if(balance){
				ft.put("balance@=", balance);
			}
			var state =$('#q_state').textbox("getValue");
			if(state){
				ft.put("state@=", state);
			}
			return ft.getJSON();
		}
	});
}