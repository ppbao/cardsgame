package com.cti.card.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Null;

/**
 * Card - Entity class 
 * 
 * @author Bruce LIU
 * @version 1.0
 */
@Entity
@Table(name = "t_card")
public class Card extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4398177810804880650L;

	private Suit suit;
	private int cardNumber;
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Card() {

	}

	public Card(Suit suit, int cardNumber, String text) {
		this.suit = suit;
		this.cardNumber = cardNumber;
		this.text = text;

	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Suit getSuit() {
		return suit;
	}

	public Suit setSuit(Suit suit) {
		return this.suit = suit;
	}

	public boolean isEqual(Card card) {

		if (this == card) {
			return true;
		}

		if (this.getCardNumber() == card.getCardNumber()
				&& this.getSuit() == card.getSuit()) {
			return true;
		} else
			return false;
	}

}
