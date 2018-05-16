package org.sky.sys.utils.schedule;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.base.client.BaseChannelImgMapper;
import org.sky.base.client.BaseChannelMapper;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.sky.base.model.BaseChannelImgExample;
import org.sky.base.model.BaseChannelImgWithBLOBs;
import org.sky.sys.utils.AliyunIdCardResult;
import org.sky.sys.utils.AliyunIdCardUtils;
import org.sky.sys.utils.BspUtils;
/**
 * 创建每天盘查计划（每周一执行一次）
 * @author weifx
 *
 */
public class QuartzRealNameAuthenticationJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		//先查出待实名认证的渠道
		BaseChannelMapper channelMapp = BspUtils.getBean(BaseChannelMapper.class);
		BaseChannelImgMapper channelImgMapper = BspUtils.getBean(BaseChannelImgMapper.class);
		BaseChannelExample bce = new  BaseChannelExample();
		bce.createCriteria().andStateEqualTo("05");
		List<BaseChannel> list = channelMapp.selectByExample(bce);
		for(BaseChannel channel:list){
			//获取最新的上传图片进行校验
			BaseChannelImgExample example = new BaseChannelImgExample();
			example.createCriteria().andChannelCodeEqualTo(channel.getCode());
			example.setOrderByClause("create_time desc");
			List<BaseChannelImgWithBLOBs> tempList = channelImgMapper.selectByExampleWithBLOBs(example);
			BaseChannelImgWithBLOBs temp = tempList.get(0);
			//调用阿里云校验接口
			AliyunIdCardResult result = AliyunIdCardUtils.readIdCard(temp.getIdcardPic1());
			//判断校验结果
			if(null!=result&&result.getNum().equals(channel.getIdcard())&&result.getName().equals(channel.getName())){//通过
				//设置为认证成功（更新时间不调整了）
				channel.setState("02");
				channelMapp.updateByPrimaryKeySelective(channel);
			}else{//认证失败
				//设置为认证失败（更新时间不调整了）
				channel.setState("04");
				channelMapp.updateByPrimaryKeySelective(channel);
			}
		}
	}

}
