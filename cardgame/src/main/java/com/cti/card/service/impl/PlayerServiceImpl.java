package com.cti.card.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.cti.card.common.Filter;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.PlayerDao;
import com.cti.card.entity.Player;

import com.cti.card.service.PlayerService;
 

@Service(value="playerService")
public class PlayerServiceImpl extends BaseServiceImpl<Player, Long> implements
		PlayerService {
	@Resource(name = "playerDao")
	private PlayerDao playerDao;

	@Resource(name = "playerDao")
	public void setBaseDao(PlayerDao playerDao) {
		super.setBaseDao(playerDao);
	}
	
 

 
}
