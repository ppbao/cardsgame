package com.cti.card.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 
import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.CardDao;
import com.cti.card.entity.Card;
import com.cti.card.service.CardService;

@Service(value="cardService")
public  class CardServiceImpl extends BaseServiceImpl<Card, Long> implements
		CardService {
	@Resource(name = "cardDao")
	private CardDao cardDao;

	@Resource(name = "cardDao")
	public void setBaseDao(CardDao cardDao) {
		super.setBaseDao(cardDao);
	}

 
 
	 
}
