/**
 * 初始化账户明细详细页面
 */
function initDetailBaseAccountDetailPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseAccountDetail/getBaseAccountDetailById?id="+paramOpts.data.id;
	$('#detailbaseaccountdetailform').form('load',SKY.urlCSRF(url));
}
