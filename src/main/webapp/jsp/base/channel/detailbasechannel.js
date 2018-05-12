/**
 * 初始化渠道人才信息详细页面
 */
function initDetailBaseChannelPage(paramOpts){
	_callbacks.add(paramOpts.callBack);
	$('#cloBtn').on('click',function(){
		paramOpts.dialog.close();
	});
	var url=basepath+"base/BaseChannel/getBaseChannelById?id="+paramOpts.data.id;
	$('#detailbasechannelform').form('options').onLoadSuccess=function(data){
		onLoadSuccess(data);
	};
	$('#detailbasechannelform').form('load',SKY.urlCSRF(url));
}
/**
 * 表单加载完毕事件
 * @param data
 * @returns
 */
function onLoadSuccess(data){
	var url = basepath+'base/BaseChannel/getBaseChannelImgByCode/'+data.code;
	$.ajax({
		url:SKY.urlCSRF(url),
		type: "GET",
		dataType:'json',
		success:function(data){
			if(!data){
				return;
			}
			if(data.studPic1){
				$('#studPic1').attr('src',data.studPic1);
			}
			if(data.studPic2){
				$('#studPic2').attr('src',data.studPic1);
			}
			if(data.idcardPic1){
				$('#idcardPic1').attr('src',data.studPic1);
			}
			if(data.idcardPic2){
				$('#idcardPic2').attr('src',data.studPic1);
			}
		}
	});
}