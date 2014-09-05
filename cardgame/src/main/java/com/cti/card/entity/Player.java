package com.cti.card.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity - Player
 * 
 * @author Bruce LIU
 * @version 1.0
 */

@Entity
@Table(name = "t_player")
public class Player extends BaseEntity {

	private static final long serialVersionUID = -7029461795708909304L;

	private String username;
	private String password;
	private String email;

	public Player(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Player(String username) {
		super();
		this.username = username;

	}

	public Player() {
		super();

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
