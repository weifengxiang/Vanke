/**
 * 初始化添加银行卡信息页面
 */
function initAddBaseBankCardPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑银行卡信息页面
 */
function initEditBaseBankCardPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseBankCard/getBaseBankCardById?id="+paramOpts.data.id;
	$('#addeditbasebankcardform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑银行卡信息
 */
function submitAddEditBaseBankCardForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbasebankcardform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'base/BaseBankCard/saveAddEditBaseBankCard'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbasebankcardform').ajaxSubmit(options);
	
}