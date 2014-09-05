package com.cti.card.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.CardDao;
import com.cti.card.dao.LogInfoDao;
import com.cti.card.entity.LogInfo;
import com.cti.card.service.LogInfoService;

@Service(value="logInfoService")
public class LogInfoServiceImpl extends BaseServiceImpl<LogInfo, Long> implements
		LogInfoService {
	@Resource(name = "logInfoDao")
	private LogInfoDao logInfoDao;

	@Resource(name = "logInfoDao")
	public void setBaseDao(LogInfoDao logInfoDao) {
		super.setBaseDao(logInfoDao);
	}


	
}
