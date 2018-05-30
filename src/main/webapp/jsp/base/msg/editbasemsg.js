/**
 * 初始化添加我的消息页面
 */
function initAddBaseMsgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑我的消息页面
 */
function initEditBaseMsgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseMsg/getBaseMsgById?id="+paramOpts.data.id;
	$('#addeditbasemsgform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑我的消息
 */
function submitAddEditBaseMsgForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbasemsgform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'base/BaseMsg/saveAddEditBaseMsg'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbasemsgform').ajaxSubmit(options);
	
}