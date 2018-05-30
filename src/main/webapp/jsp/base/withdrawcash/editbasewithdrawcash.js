/**
 * 初始化添加提现申请信息页面
 */
function initAddBaseWithdrawCashPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑提现申请信息页面
 */
function initEditBaseWithdrawCashPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseWithdrawCash/getBaseWithdrawCashById?id="+paramOpts.data.id;
	$('#addeditbasewithdrawcashform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑提现申请信息
 */
function submitAddEditBaseWithdrawCashForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbasewithdrawcashform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'base/BaseWithdrawCash/saveAddEditBaseWithdrawCash'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbasewithdrawcashform').ajaxSubmit(options);
	
}