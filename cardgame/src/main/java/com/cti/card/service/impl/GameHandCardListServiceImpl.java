package com.cti.card.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.GameHandCardListDao;
import com.cti.card.dao.GameHandRecordDetailDao;
import com.cti.card.entity.GameHandCardList;
import com.cti.card.service.GameHandCardListService;

@Service(value="gameHandCardListService")
public class GameHandCardListServiceImpl extends BaseServiceImpl<GameHandCardList, Long>
		implements GameHandCardListService {

	@Resource(name = "gameHandCardListDao")
	private GameHandCardListDao gameHandCardListDao;

	@Resource(name = "gameHandCardListDao")
	public void setBaseDao(GameHandCardListDao gameHandCardListDao) {
		super.setBaseDao(gameHandCardListDao);
	}
 
	 
}
