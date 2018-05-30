//初始化
function init(){
	$('#listbasechanneldg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollByPage');
	$('#listbasechanneldg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
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
				title:'报名人员信息',
				width:700,
				height:550,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'base/BaseChannel/initDetailBaseChannelPage'),
				onLoad: function(dialog){ 
		            if(this.content && this.content.initDetailBaseChannelPage){//判断弹出窗体iframe中的driveInit方法是否存在 
		                var paramOpts=new Object();
		                paramOpts.dialog=dialog;
		                paramOpts.data={id:checkeds[0].chaId};
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
 *录用
 **/
function changState(state){
	var checkeds=$('#listbasechanneldg').datagrid('getChecked');
	if(null==checkeds||checkeds.length<1){
		$.messager.alert('提示','请选择要录用的记录','info');
		return;
	}else{
		var msg="确定要录用"+checkeds.length+"条数据?";
		$.messager.confirm("录用确认",msg,
		function (r){
			if(r){
				SKY_EASYUI.mask('正在进行录用，请稍等...');
				var url = SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/changeState');
				var params = {
							"delRows":JSON.stringify(checkeds),
							"state":state
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
 * 查询按钮
 */
function searchButton(){
	$('#listbasechanneldg').datagrid('options').url=SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollByPage');
	$('#listbasechanneldg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var state =$('#q_state').combobox("getValue");
			if(state){
				ft.put("state@=", state);
			}
			return ft.getJSON();
		}
	});
}