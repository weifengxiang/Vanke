package org.sky.sys.utils.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sky.base.client.BaseChannelMapper;
import org.sky.base.model.BaseChannelExample;
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
		BaseChannelExample bce = new  BaseChannelExample();
	}

}
