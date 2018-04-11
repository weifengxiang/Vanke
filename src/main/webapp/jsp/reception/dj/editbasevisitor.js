/**
 * 初始化添加01.来访信息页面
 */
function initAddBaseVisitorPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑01.来访信息页面
 */
function initEditBaseVisitorPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"reception/BaseVisitor/getBaseVisitorById?id="+paramOpts.data.id;
	$('#addeditbasevisitorform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑01.来访信息
 */
function submitAddEditBaseVisitorForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditbasevisitorform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'reception/BaseVisitor/saveAddEditBaseVisitor'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditbasevisitorform').ajaxSubmit(options);
	
}