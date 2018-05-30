/**
 * 初始化账户信息详细页面
 */
function initDetailBaseAccountPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseAccount/getBaseAccountById?id="+paramOpts.data.id;
	$('#detailbaseaccountform').form('load',SKY.urlCSRF(url));
}
