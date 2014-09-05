package com.cti.card.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * GameTable - Entity class
 * 
 * @author Bruce LIU
 * @version 1.0
 */
@Entity
@Table(name = "t_gameTable")
public class GameTable extends BaseEntity {

	private static final long serialVersionUID = 2939519789702506671L;

	private String players;
	private Integer userCounts;

	public String getPlayers() {
		return players;
	}

	public Integer getUserCounts() {
		return userCounts;
	}

	public void setPlayers(String players) {
		this.players = players;
	}

	public void setUserCounts(Integer userCounts) {
		this.userCounts = userCounts;
	}

}
