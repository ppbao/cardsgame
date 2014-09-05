package com.cti.card.dao.impl;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.stereotype.Repository;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.GameHandRecordDetailDao;
import com.cti.card.entity.GameHandRecordDetail;

/**
 * GameHandRecordDetailDaoImpl - implementation class
 * 
 * @author Bruce LIU
 * @version 1.0
 */

@Repository(value="gameHandRecordDetailDao")
public class GameHandRecordDetailDaoImpl extends BaseDaoImpl<GameHandRecordDetail, Long> implements
		GameHandRecordDetailDao {
	

}
