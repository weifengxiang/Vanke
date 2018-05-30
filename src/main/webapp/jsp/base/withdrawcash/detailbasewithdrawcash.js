/**
 * 初始化提现申请信息详细页面
 */
function initDetailBaseWithdrawCashPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseWithdrawCash/getBaseWithdrawCashById?id="+paramOpts.data.id;
	$('#detailbasewithdrawcashform').form('load',SKY.urlCSRF(url));
}
