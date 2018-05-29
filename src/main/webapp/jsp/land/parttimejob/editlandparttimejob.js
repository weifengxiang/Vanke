/**
 * 初始化添加兼职任务信息页面
 */
function initAddLandParttimeJobPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
}
/**
 * 初始化编辑兼职任务信息页面
 */
function initEditLandParttimeJobPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"land/LandParttimeJob/getLandParttimeJobById?id="+paramOpts.data.id;
	$('#addeditlandparttimejobform').form('load',SKY.urlCSRF(url));
}
/**
 * 保存添加/编辑兼职任务信息
 */
function submitAddEditLandParttimeJobForm() {
	var options = { 
	   data:{
    	   "data":function(){
    		   //return JSON.stringify();
    	   }
       },   
       beforeSubmit:function(data){
			return $('#addeditlandparttimejobform').form('enableValidation').form('validate');
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
       url:SKY.urlCSRF(basepath+'land/LandParttimeJob/saveAddEditLandParttimeJob'), 
       type:'post',   
       dataType:'json',   
       timeout:-1    
	};  
	$('#addeditlandparttimejobform').ajaxSubmit(options);
	
}