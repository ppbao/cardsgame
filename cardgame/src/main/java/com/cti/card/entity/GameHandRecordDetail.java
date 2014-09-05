package com.cti.card.entity;

/**
 * GameRecordDetail - GameRecordDetail
 * 
 * @author Bruce LIU
 * @version 1.0
 */

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_gameHandRecordDetail")
public class GameHandRecordDetail extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5286361461868275634L;

	private GameHandRecord gameHandRecord;
	private Player player;
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private Card firstCard;

	private Card secondCard;

	private Card thirdCard;

	@ManyToOne(fetch = FetchType.EAGER)
	public GameHandRecord getGameHandRecord() {
		return gameHandRecord;
	}

	public void setGameHandRecord(GameHandRecord gameHandRecord) {
		this.gameHandRecord = gameHandRecord;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	public Card getFirstCard() {
		return firstCard;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	public Card getSecondCard() {
		return secondCard;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	public Card getThirdCard() {
		return thirdCard;
	}

	public void setFirstCard(Card firstCard) {
		this.firstCard = firstCard;
	}

	public void setSecondCard(Card secondCard) {
		this.secondCard = secondCard;
	}

	public void setThirdCard(Card thirdCard) {
		this.thirdCard = thirdCard;
	}

	 

	
	
 

}
