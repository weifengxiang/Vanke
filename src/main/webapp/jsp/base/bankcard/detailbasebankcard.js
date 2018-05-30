/**
 * 初始化银行卡信息详细页面
 */
function initDetailBaseBankCardPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseBankCard/getBaseBankCardById?id="+paramOpts.data.id;
	$('#detailbasebankcardform').form('load',SKY.urlCSRF(url));
}
