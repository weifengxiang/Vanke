//初始化
function init(){
	$('#listbasewithdrawcashdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseWithdrawCash/getBaseWithdrawCashByPage');
	$('#listbasewithdrawcashdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加提现申请信息
 **/
function addBaseWithdrawCash(){
	var opts={
				id:'addBaseWithdrawCash',
				title:'添加提现申请信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseWithdrawCash/initAddBaseWithdrawCashPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseWithdrawCashPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseWithdrawCashPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除提现申请信息
 **/
function delBaseWithdrawCash(){
	var checkeds=$('#listbasewithdrawcashdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseWithdrawCash/delBaseWithdrawCash');
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
		    				$('#listbasewithdrawcashdg').datagrid('reload');
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
*修改提现申请信息
**/
function editBaseWithdrawCash(){
	var checkeds=$('#listbasewithdrawcashdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseWithdrawCash',
				title:'修改提现申请信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseWithdrawCash/initEditBaseWithdrawCashPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseWithdrawCashPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseWithdrawCashPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseWithdrawCash(){
	var checkeds=$('#listbasewithdrawcashdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseWithdrawCash',
				title:'提现申请信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseWithdrawCash/initDetailBaseWithdrawCashPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseWithdrawCashPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseWithdrawCashPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbasewithdrawcashdg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseWithdrawCash/getBaseWithdrawCashByPage');
	$('#listbasewithdrawcashdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var chaCode =$('#q_chaCode').textbox("getValue");
			if(chaCode){
				ft.put("chaCode@=", chaCode);
			}
			var bankCode =$('#q_bankCode').textbox("getValue");
			if(bankCode){
				ft.put("bankCode@=", bankCode);
			}
			var cardCode =$('#q_cardCode').textbox("getValue");
			if(cardCode){
				ft.put("cardCode@=", cardCode);
			}
			var amount =$('#q_amount').textbox("getValue");
			if(amount){
				ft.put("amount@=", amount);
			}
			var reqDate =$('#q_reqDate').textbox("getValue");
			if(reqDate){
				ft.put("reqDate@=", reqDate);
			}
			var state =$('#q_state').textbox("getValue");
			if(state){
				ft.put("state@=", state);
			}
			var note =$('#q_note').textbox("getValue");
			if(note){
				ft.put("note@=", note);
			}
			return ft.getJSON();
		}
	});
}