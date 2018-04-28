/**
 * 初始化客户资源信息详细页面
 */
function initDetailBaseCustomerPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseCustomer/getBaseCustomerById?id="+paramOpts.data.id;
	$('#detailbasecustomerform').form('load',SKY.urlCSRF(url));
}
