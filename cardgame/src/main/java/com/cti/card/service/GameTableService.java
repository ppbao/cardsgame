package com.cti.card.service;

import com.cti.card.entity.GameTable;
 

public interface GameTableService extends BaseService<GameTable, Long> {
	
	public Long start(int numberOfPlayer);
}
