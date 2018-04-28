/**
 * 初始化添加客户资源信息页面
 */
function initAddBaseCustomerPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑客户资源信息页面
 */
function initEditBaseCustomerPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseCustomer/getBaseCustomerById?id="+paramOpts.data.id;
	$('#addeditbasecustomerform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑客户资源信息
 */
function submitAddEditBaseCustomerForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbasecustomerform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'base/BaseCustomer/saveAddEditBaseCustomer'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbasecustomerform').ajaxSubmit(options);
	
}