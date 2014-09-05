package com.cti.card.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.CardDao;
import com.cti.card.dao.GameHandRecordDao;
import com.cti.card.dao.impl.BaseDaoImpl;
import com.cti.card.entity.Card;
import com.cti.card.entity.GameHandRecord;
import com.cti.card.service.CardService;
import com.cti.card.service.GameHandRecordService;
 


@Service(value="gameHandRecordService")
public class GameHandRecordServiceImpl extends BaseServiceImpl<GameHandRecord, Long>
		implements GameHandRecordService {

	@Resource(name = "gameHandRecordDao")
	private GameHandRecordDao gameHandRecordDao;

	@Resource(name = "gameHandRecordDao")
	public void setBaseDao(GameHandRecordDao gameHandRecordDao) {
		super.setBaseDao(gameHandRecordDao);
	}

}
