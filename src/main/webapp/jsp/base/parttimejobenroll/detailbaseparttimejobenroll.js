/**
 * 初始化兼职报名信息详细页面
 */
function initDetailBaseParttimeJobEnrollPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseParttimeJobEnroll/getBaseParttimeJobEnrollById?id="+paramOpts.data.id;
	$('#detailbaseparttimejobenrollform').form('load',SKY.urlCSRF(url));
}
