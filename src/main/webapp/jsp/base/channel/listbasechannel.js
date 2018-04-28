//初始化
function init(){
	$('#listbasechanneldg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseChannel/getBaseChannelByPage');
	$('#listbasechanneldg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}
 /**
 *添加渠道人才信息
 **/
function addBaseChannel(){
	var opts={
				id:'addBaseChannel',
				title:'添加渠道人才信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseChannel/initAddBaseChannelPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initAddBaseChannelPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initAddBaseChannelPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
 /**
 *删除渠道人才信息
 **/
function delBaseChannel(){
	var checkeds=$('#listbasechanneldg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要删除的记录','info');
		return;
	}else{
		var msg="确定要删除"+checkeds.length+"条数据?";
		$.messager.confirm("删除确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行删除，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseChannel/delBaseChannel');
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
		    				$('#listbasechanneldg').datagrid('reload');
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
*修改渠道人才信息
**/
function editBaseChannel(){
	var checkeds=$('#listbasechanneldg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'editBaseChannel',
				title:'修改渠道人才信息',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseChannel/initEditBaseChannelPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initEditBaseChannelPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                	searchButton();
		                };
		            	this.content.initEditBaseChannelPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
*查看明细
**/
function detailBaseChannel(){
	var checkeds=$('#listbasechanneldg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var opts={
				id:'detailBaseChannel',
				title:'渠道人才信息明细',
				width:600,
				height:450,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseChannel/initDetailBaseChannelPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseChannelPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data=checkeds[0];
		                paramOpts.callBack=function(){
		                	dialog.close();
		                };
		            	this.content.initDetailBaseChannelPage(paramOpts);//调用并将参数传入，此处当然也可以传入其他内容 
		            } 
		        }
			  };
	SKY_EASYUI.open(opts);
}
/**
 * 查询按钮
 */
function searchButton(){
	$('#listbasechanneldg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseChannel/getBaseChannelByPage');
	$('#listbasechanneldg').datagrid('load', {
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
		
			return ft.getJSON();
		}
	});
}