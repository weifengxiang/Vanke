//初始化
function init(){
	$('#listbasevisitordg').datagrid('options').url=SKY.urlCSRF(basepath+'reception/BaseVisitor/getBaseVisitorByPage');
	$('#listbasevisitordg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加01.来访信息
 **/
function addBaseVisitor(){
	var opts={
				id:'addBaseVisitor',
				title:'来访登记',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'reception/BaseVisitor/initAddBaseVisitorPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseVisitorPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseVisitorPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除01.来访信息
 **/
function delBaseVisitor(){
	var checkeds=$('#listbasevisitordg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'reception/BaseVisitor/delBaseVisitor');
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
		    				$('#listbasevisitordg').datagrid('reload');
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
*修改01.来访信息
**/
function editBaseVisitor(){
	var checkeds=$('#listbasevisitordg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseVisitor',
				title:'修改来访信息',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'reception/BaseVisitor/initEditBaseVisitorPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseVisitorPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseVisitorPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseVisitor(){
	var checkeds=$('#listbasevisitordg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseVisitor',
				title:'来访信息明细',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'reception/BaseVisitor/initDetailBaseVisitorPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseVisitorPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseVisitorPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbasevisitordg').datagrid('options').url=SKY.urlCSRF(basepath+'reception/BaseVisitor/getBaseVisitorByPage');
	$('#listbasevisitordg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var name =$('#q_name').textbox("getValue");
			if(name){
				ft.put("name@like", "%"+name+"%");
			}
			
			var visitTime =$('#q_visitTime').textbox("getValue");
			if(visitTime){
				//ft.put("visitTime@=", visitTime);
				ft.put("date_format(visitTime,concat(upper('%y'),'-%m-%d'))@<=", visitTime);
			}
			
			return ft.getJSON();
		}
	});
}