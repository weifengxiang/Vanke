/**
 * 初始化兼职任务信息详细页面
 */
function initDetailLandParttimeJobPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"land/LandParttimeJob/getLandParttimeJobById?id="+paramOpts.data.id;
	$('#detaillandparttimejobform').form('load',SKY.urlCSRF(url));
}
