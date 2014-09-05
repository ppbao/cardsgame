package com.cti.card.dao.impl;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.stereotype.Repository;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.LogInfoDao;
import com.cti.card.entity.LogInfo;

@Repository(value="logInfoDao")
public class LogInfoDaoImpl extends BaseDaoImpl<LogInfo, Long> implements LogInfoDao {

}
