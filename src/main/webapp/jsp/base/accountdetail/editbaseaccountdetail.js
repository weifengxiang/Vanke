/**
 * 初始化添加账户明细页面
 */
function initAddBaseAccountDetailPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑账户明细页面
 */
function initEditBaseAccountDetailPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseAccountDetail/getBaseAccountDetailById?id="+paramOpts.data.id;
	$('#addeditbaseaccountdetailform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑账户明细
 */
function submitAddEditBaseAccountDetailForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbaseaccountdetailform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'base/BaseAccountDetail/saveAddEditBaseAccountDetail'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbaseaccountdetailform').ajaxSubmit(options);
	
}