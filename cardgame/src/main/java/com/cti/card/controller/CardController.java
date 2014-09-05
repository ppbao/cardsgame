package com.cti.card.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cti.card.entity.Card;
 
import com.cti.card.entity.Player;
import com.cti.card.entity.Suit;
import com.cti.card.service.CardService;
import com.cti.card.service.PlayerService;

@Controller
public class CardController {
	@Resource(name="cardService")
	private CardService cardService;
	@Resource(name="playerService")
	private PlayerService playerService;
	
	@RequestMapping("/initdb")
	public String populateData()
	{
	 
		if(cardService.count()>0)
		{
			return "home";
		}
		initializePlayer();
		initiliazeSpades();
		initiliazeClubs();
		initiliazeHearts();
		initiliazeDiamonds();
			
		return "home";
	}
	
	private void initiliazeClubs()
	{
	 	Card card1 = new Card(Suit.Clubs,2,"2C");
		Card card2 = new Card(Suit.Clubs,3,"3C");
		Card card3 = new Card(Suit.Clubs,4,"4C");
		Card card4 = new Card(Suit.Clubs,5,"5C");
		Card card5 = new Card(Suit.Clubs,6,"6C");
		Card card6 = new Card(Suit.Clubs,7,"7C");
		Card card7 = new Card(Suit.Clubs,8,"8C");
		Card card8 = new Card(Suit.Clubs,9,"9C");
		Card card9 = new Card(Suit.Clubs,10,"10C");
		Card card10 = new Card(Suit.Clubs,11,"JC");
		Card card11 = new Card(Suit.Clubs,12,"QC");
		Card card12 = new Card(Suit.Clubs,13,"KD");
		Card card13 = new Card(Suit.Clubs,14,"AC");
		
		cardService.save(card1);
		cardService.save(card2);
		cardService.save(card3);
		cardService.save(card4);
		cardService.save(card5);
		cardService.save(card6);
		cardService.save(card7);
		cardService.save(card8);
		cardService.save(card9);
		cardService.save(card10);
		cardService.save(card11);
		cardService.save(card12);
		cardService.save(card13);
		
	}
	private void initiliazeHearts()
	{
	 
		Card card1 = new Card(Suit.Heats,2,"2H");
		Card card2 = new Card(Suit.Heats,3,"3H");
		Card card3 = new Card(Suit.Heats,4,"4H");
		Card card4 = new Card(Suit.Heats,5,"5H");
		Card card5 = new Card(Suit.Heats,6,"6H");
		Card card6 = new Card(Suit.Heats,7,"7H");
		Card card7 = new Card(Suit.Heats,8,"8H");
		Card card8 = new Card(Suit.Heats,9,"9H");
		Card card9 = new Card(Suit.Heats,10,"10H");
		Card card10 = new Card(Suit.Heats,11,"JH");
		Card card11 = new Card(Suit.Heats,12,"QH");
		Card card12 = new Card(Suit.Heats,13,"KH");
		Card card13 = new Card(Suit.Heats,14,"AH");
		
		
		cardService.save(card1);
		cardService.save(card2);
		cardService.save(card3);
		cardService.save(card4);
		cardService.save(card5);
		cardService.save(card6);
		cardService.save(card7);
		cardService.save(card8);
		cardService.save(card9);
		cardService.save(card10);
		cardService.save(card11);
		cardService.save(card12);
		cardService.save(card13);
	}
	
	
	private void initiliazeDiamonds()
	{
 
		
		Card card1 = new Card(Suit.Diamonds,2,"2D");
		Card card2 = new Card(Suit.Diamonds,3,"3D");
		Card card3 = new Card(Suit.Diamonds,4,"4D");
		Card card4 = new Card(Suit.Diamonds,5,"5D");
		Card card5 = new Card(Suit.Diamonds,6,"6D");
		Card card6 = new Card(Suit.Diamonds,7,"7D");
		Card card7 = new Card(Suit.Diamonds,8,"8D");
		Card card8 = new Card(Suit.Diamonds,9,"9D");
		Card card9 = new Card(Suit.Diamonds,10,"10D");
		Card card10 = new Card(Suit.Diamonds,11,"JD");
		Card card11 = new Card(Suit.Diamonds,12,"QD");
		Card card12 = new Card(Suit.Diamonds,13,"KD");
		Card card13 = new Card(Suit.Diamonds,14,"AD");
		
		
		
		cardService.save(card1);
		cardService.save(card2);
		cardService.save(card3);
		cardService.save(card4);
		cardService.save(card5);
		cardService.save(card6);
		cardService.save(card7);
		cardService.save(card8);
		cardService.save(card9);
		cardService.save(card10);
		cardService.save(card11);
		cardService.save(card12);
		cardService.save(card13);
	}
	
	
	
	private void initiliazeSpades()
	{
		Card card1 = new Card(Suit.Spades,2,"2S");
		Card card2 = new Card(Suit.Spades,3,"3S");
		Card card3 = new Card(Suit.Spades,4,"4S");
		Card card4 = new Card(Suit.Spades,5,"5S");
		Card card5 = new Card(Suit.Spades,6,"6S");
		Card card6 = new Card(Suit.Spades,7,"7S");
		Card card7 = new Card(Suit.Spades,8,"8S");
		Card card8 = new Card(Suit.Spades,9,"9S");
		Card card9 = new Card(Suit.Spades,10,"10S");
		Card card10 = new Card(Suit.Spades,11,"JS");
		Card card11 = new Card(Suit.Spades,12,"QS");
		Card card12 = new Card(Suit.Spades,13,"KS");
		Card card13 = new Card(Suit.Spades,14,"AS");
		
		cardService.save(card1);
		cardService.save(card2);
		cardService.save(card3);
		cardService.save(card4);
		cardService.save(card5);
		cardService.save(card6);
		cardService.save(card7);
		cardService.save(card8);
		cardService.save(card9);
		cardService.save(card10);
		cardService.save(card11);
		cardService.save(card12);
		cardService.save(card13);
	}
	
	
	private void initializePlayer()
	{
		
		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		Player player3 = new Player("player3");
		Player player4 = new Player("player4");
		Player player5 = new Player("player5");
		Player player6 = new Player("player6");
		Player player7 = new Player("player7");
		Player player8 = new Player("player8");
		Player player9 = new Player("player9");
		Player player10 = new Player("player10");
		Player player11 = new Player("player11");
		Player player12 = new Player("player12");
		Player player13 = new Player("player13");
		Player player14 = new Player("player14");
		Player player15 = new Player("player15");
		Player player16 = new Player("player16");
		Player player17 = new Player("player17");
			
		playerService.save(player1);
		playerService.save(player2);
		playerService.save(player3);
		playerService.save(player4);
		playerService.save(player5);
		playerService.save(player6);
		playerService.save(player7);
		playerService.save(player8);
		playerService.save(player9);
		playerService.save(player10);
		playerService.save(player11);
		playerService.save(player12);
		playerService.save(player13);
		playerService.save(player14);
		playerService.save(player15);
		playerService.save(player16);
		playerService.save(player17);
	 		
	}
	 
 
	
}
