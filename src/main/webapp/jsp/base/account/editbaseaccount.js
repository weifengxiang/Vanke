/**
 * 初始化添加账户信息页面
 */
function initAddBaseAccountPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑账户信息页面
 */
function initEditBaseAccountPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseAccount/getBaseAccountById?id="+paramOpts.data.id;
	$('#addeditbaseaccountform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑账户信息
 */
function submitAddEditBaseAccountForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbaseaccountform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'base/BaseAccount/saveAddEditBaseAccount'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbaseaccountform').ajaxSubmit(options);
	
}