/**
 * 初始化渠道人才信息详细页面
 */
function initDetailBaseChannelPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseChannel/getBaseChannelById?id="+paramOpts.data.id;
	$('#detailbasechannelform').form('load',SKY.urlCSRF(url));
}
