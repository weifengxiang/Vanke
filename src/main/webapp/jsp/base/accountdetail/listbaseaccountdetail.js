//初始化
function init(){
	$('#listbaseaccountdetaildg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseAccountDetail/getBaseAccountDetailByPage');
	$('#listbaseaccountdetaildg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加账户明细
 **/
function addBaseAccountDetail(){
	var opts={
				id:'addBaseAccountDetail',
				title:'添加账户明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseAccountDetail/initAddBaseAccountDetailPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseAccountDetailPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseAccountDetailPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除账户明细
 **/
function delBaseAccountDetail(){
	var checkeds=$('#listbaseaccountdetaildg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseAccountDetail/delBaseAccountDetail');
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
		    				$('#listbaseaccountdetaildg').datagrid('reload');
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
*修改账户明细
**/
function editBaseAccountDetail(){
	var checkeds=$('#listbaseaccountdetaildg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseAccountDetail',
				title:'修改账户明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseAccountDetail/initEditBaseAccountDetailPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseAccountDetailPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseAccountDetailPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseAccountDetail(){
	var checkeds=$('#listbaseaccountdetaildg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseAccountDetail',
				title:'账户明细明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseAccountDetail/initDetailBaseAccountDetailPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseAccountDetailPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseAccountDetailPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbaseaccountdetaildg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseAccountDetail/getBaseAccountDetailByPage');
	$('#listbaseaccountdetaildg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var code =$('#q_code').textbox("getValue");
			if(code){
				ft.put("code@=", code);
			}
			var accountCode =$('#q_accountCode').textbox("getValue");
			if(accountCode){
				ft.put("accountCode@=", accountCode);
			}
			var target =$('#q_target').textbox("getValue");
			if(target){
				ft.put("target@=", target);
			}
			var amount =$('#q_amount').textbox("getValue");
			if(amount){
				ft.put("amount@=", amount);
			}
			return ft.getJSON();
		}
	});
}