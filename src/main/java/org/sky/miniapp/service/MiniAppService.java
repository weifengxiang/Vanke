package org.sky.miniapp.service;

import java.util.List;

import org.sky.base.client.BaseChannelMapper;
import org.sky.base.model.BaseChannel;
import org.sky.base.model.BaseChannelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniAppService {
	
	@Autowired
	private BaseChannelMapper baseChannelMapper;

	public BaseChannel getBaseChannelById(String userid) {
		// TODO Auto-generated method stub
		return baseChannelMapper.selectByPrimaryKey(userid);
	}

	public List<BaseChannel> listBaseChannelByExample(BaseChannelExample example) {
		// TODO Auto-generated method stub
		return baseChannelMapper.selectByExample(example);
	}

}
