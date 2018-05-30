/**
 * 初始化我的消息详细页面
 */
function initDetailBaseMsgPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseMsg/getBaseMsgById?id="+paramOpts.data.id;
	$('#detailbasemsgform').form('load',SKY.urlCSRF(url));
}
