package com.cti.card.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

  

 

@Entity
@Table(name="t_gameHandRecord")
public class GameHandRecord extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7500361921083940134L;
 
	
	public Date getStartDate() {
		return startDate;
	}
	public Integer getPlayNumber() {
		return playNumber;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	public Player getWinner() {
		return winner;
	}
	public Result getResult() {
		return result;
	}
	 

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setPlayNumber(Integer playNumber) {
		this.playNumber = playNumber;
	}
 
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	private Date startDate;
	private Integer playNumber;
 
	private Player winner;
	private Result result;
	private GameTable gameTable;

	@ManyToOne(fetch = FetchType.EAGER)
	public GameTable getGameTable() {
		return gameTable;
	}
	public void setGameTable(GameTable gameTable) {
		this.gameTable = gameTable;
	}
	 
}
