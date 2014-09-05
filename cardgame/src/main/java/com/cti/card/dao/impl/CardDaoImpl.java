package com.cti.card.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cti.card.dao.CardDao;
import com.cti.card.entity.Card;
 
@Repository(value="cardDao")
public class CardDaoImpl extends BaseDaoImpl<Card, Long> implements CardDao {
	 
}
