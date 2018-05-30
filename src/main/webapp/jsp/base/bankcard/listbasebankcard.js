//初始化
function init(){
	$('#listbasebankcarddg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseBankCard/getBaseBankCardByPage');
	$('#listbasebankcarddg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加银行卡信息
 **/
function addBaseBankCard(){
	var opts={
				id:'addBaseBankCard',
				title:'添加银行卡信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseBankCard/initAddBaseBankCardPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseBankCardPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseBankCardPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除银行卡信息
 **/
function delBaseBankCard(){
	var checkeds=$('#listbasebankcarddg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseBankCard/delBaseBankCard');
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
		    				$('#listbasebankcarddg').datagrid('reload');
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
*修改银行卡信息
**/
function editBaseBankCard(){
	var checkeds=$('#listbasebankcarddg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseBankCard',
				title:'修改银行卡信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseBankCard/initEditBaseBankCardPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseBankCardPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseBankCardPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseBankCard(){
	var checkeds=$('#listbasebankcarddg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseBankCard',
				title:'银行卡信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseBankCard/initDetailBaseBankCardPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseBankCardPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseBankCardPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbasebankcarddg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseBankCard/getBaseBankCardByPage');
	$('#listbasebankcarddg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var bankCode =$('#q_bankCode').textbox("getValue");
			if(bankCode){
				ft.put("bankCode@=", bankCode);
			}
			var cardCode =$('#q_cardCode').textbox("getValue");
			if(cardCode){
				ft.put("cardCode@=", cardCode);
			}
			var chaCode =$('#q_chaCode').textbox("getValue");
			if(chaCode){
				ft.put("chaCode@=", chaCode);
			}
			var bindingDate =$('#q_bindingDate').textbox("getValue");
			if(bindingDate){
				ft.put("bindingDate@=", bindingDate);
			}
			return ft.getJSON();
		}
	});
}