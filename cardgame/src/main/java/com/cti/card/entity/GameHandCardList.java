package com.cti.card.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_gameHandCardList")
public class GameHandCardList extends BaseEntity{
	
	 
	private GameTable gameTable;
 
	private String cards;
	 

	public String getCards() {
		return cards;
	}


	public void setCards(String cards) {
		this.cards = cards;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	public GameTable getGameTable() {
		return gameTable;
	}
	 

	public void setGameTable(GameTable gameTable) {
		this.gameTable = gameTable;
	}

	 
	
	
	
}
