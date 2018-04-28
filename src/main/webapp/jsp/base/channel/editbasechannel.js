/**
 * 初始化添加渠道人才信息页面
 */
function initAddBaseChannelPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑渠道人才信息页面
 */
function initEditBaseChannelPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseChannel/getBaseChannelById?id="+paramOpts.data.id;
	$('#addeditbasechannelform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑渠道人才信息
 */
function submitAddEditBaseChannelForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbasechannelform').form('enableValidation').form('validate');
       },   
       success:function(data){
    	    $.messager.alert('提示',data.name,'info',function(){
    		   if(data.code=='1'){
    			   _callbacks.fire();  
    		   }  	
    	   	});     	   
       },
       error:function(e){
    	   $.messager.alert('提示',JSON.stringify(e),'info');
       },
       url:SKY.urlCSRF(basepath+'base/BaseChannel/saveAddEditBaseChannel'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbasechannelform').ajaxSubmit(options);
	
}