/**
 * 初始化01.来访信息详细页面
 */
function initDetailBaseVisitorPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"reception/BaseVisitor/getBaseVisitorById?id="+paramOpts.data.id;
	$('#detailbasevisitorform').form('load',SKY.urlCSRF(url));
}
