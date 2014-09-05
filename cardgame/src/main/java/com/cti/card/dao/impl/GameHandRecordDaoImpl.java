package com.cti.card.dao.impl;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.stereotype.Repository;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.GameHandRecordDao;
import com.cti.card.entity.GameHandRecord;

/**
 * GameHandRecordDaoImpl - implementation class
 * 
 * @author Bruce LIU
 * @version 1.0
 */


@Repository(value="gameHandRecordDao")
public class GameHandRecordDaoImpl extends BaseDaoImpl<GameHandRecord, Long> implements
		GameHandRecordDao {

	 
 

}
