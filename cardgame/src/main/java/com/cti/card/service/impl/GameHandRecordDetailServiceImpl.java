package com.cti.card.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.CardDao;
import com.cti.card.dao.GameHandRecordDetailDao;
import com.cti.card.dao.GameTableDao;
import com.cti.card.entity.GameHandRecordDetail;
import com.cti.card.service.GameHandRecordDetailService;

@Service(value="gameHandRecordDetailService")
public class GameHandRecordDetailServiceImpl extends BaseServiceImpl<GameHandRecordDetail, Long>
		implements GameHandRecordDetailService {

	@Resource(name = "gameHandRecordDetailDao")
	private GameHandRecordDetailDao gameHandRecordDetailDao;

	@Resource(name = "gameHandRecordDetailDao")
	public void setBaseDao(GameHandRecordDetailDao gameHandRecordDetailDao) {
		super.setBaseDao(gameHandRecordDetailDao);
	}
 

}
