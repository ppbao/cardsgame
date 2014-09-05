package com.cti.card.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_loginfo")
public class LogInfo extends BaseEntity {
	private static final long serialVersionUID = -459125481216973160L;
	private GameTable gameTable;
	public enum Stage
	{
		before,
		shuffled,
		dealt
	} 
	@ManyToOne(fetch=FetchType.LAZY)
	public GameTable getGameTable() {
		return gameTable;
	}

	public Stage getStages() {
		return stages;
	}

	public String getCardsStringInfo() {
		return cardsStringInfo;
	}

	public void setGameTable(GameTable gameTable) {
		this.gameTable = gameTable;
	}

	public void setStages(Stage stages) {
		this.stages = stages;
	}

	public void setCardsStringInfo(String cardsStringInfo) {
		this.cardsStringInfo = cardsStringInfo;
	}

	private Stage stages;
	
	private String cardsStringInfo;
}
