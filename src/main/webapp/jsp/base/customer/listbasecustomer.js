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
				width:800,
				height:600,
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
				width:800,
				height:600,
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
				width:800,
				height:600,
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
				ft.put("name@like", "%"+name+"%");
			}
			
			var visitTime =$('#q_visitTime').textbox("getValue");
			if(visitTime){
				//ft.put("visitTime@=", visitTime);
				ft.put("date_format(visitTime,concat(upper('%y'),'-%m-%d'))@=", visitTime);
			}
			return ft.getJSON();
		}
	});
}