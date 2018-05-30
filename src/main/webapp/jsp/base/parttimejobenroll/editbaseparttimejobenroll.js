/**
 * 初始化添加兼职报名信息页面
 */
function initAddBaseParttimeJobEnrollPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑兼职报名信息页面
 */
function initEditBaseParttimeJobEnrollPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollById?id="+paramOpts.data.id;
	$('#addeditbaseparttimejobenrollform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑兼职报名信息
 */
function submitAddEditBaseParttimeJobEnrollForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbaseparttimejobenrollform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'base/BaseParttimeJobEnroll/saveAddEditBaseParttimeJobEnroll'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbaseparttimejobenrollform').ajaxSubmit(options);
	
}