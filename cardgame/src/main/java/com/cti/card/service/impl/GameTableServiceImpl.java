package com.cti.card.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.FlushModeType;

import org.springframework.stereotype.Service;

import com.cti.card.common.Filter;
import com.cti.card.common.JudgeService;
import com.cti.card.common.JudgeServiceFaceImpl;
import com.cti.card.common.Order;
import com.cti.card.common.Page;
import com.cti.card.common.Pageable;
import com.cti.card.dao.CardDao;
import com.cti.card.dao.GameHandCardListDao;
import com.cti.card.dao.GameHandRecordDao;
import com.cti.card.dao.GameHandRecordDao;
import com.cti.card.dao.GameHandRecordDetailDao;
import com.cti.card.dao.GameTableDao;
import com.cti.card.dao.LogInfoDao;
import com.cti.card.dao.PlayerDao;
import com.cti.card.entity.Card;
import com.cti.card.entity.GameHandCardList;
import com.cti.card.entity.GameHandRecord;
import com.cti.card.entity.GameHandRecordDetail;
import com.cti.card.entity.GameTable;
import com.cti.card.entity.LogInfo;
import com.cti.card.entity.Player;
import com.cti.card.entity.Result;
import com.cti.card.service.GameTableService;

@Service(value = "gameTableService")
public class GameTableServiceImpl extends BaseServiceImpl<GameTable, Long>
		implements GameTableService {
	private static ArrayList<Card> baseDeck = new ArrayList<Card>(52);
	private static List<Player> players = new ArrayList<Player>(17);
	private static int chosedPlayerCounts = 2;
	private Long currentGameTableID;
	
	@Resource(name = "judgeService")
	private JudgeService judgeService;

	@Resource(name = "gameHandRecordDao")
	private GameHandRecordDao gameHandRecordDao;
	
	@Resource(name = "logInfoDao")
	private LogInfoDao logInfoDao;
	
	@Resource(name = "gameHandRecordDetailDao")
	GameHandRecordDetailDao gameHandRecordDetailDao;
	
	@Resource(name = "gameHandCardListDao")
	private GameHandCardListDao gameHandCardListDao;

	@Resource(name = "playerDao")
	private PlayerDao playerDao;

	@Resource(name = "gameTableDao")
	private GameTableDao gameTableDao;
	@Resource(name = "cardDao")
	private CardDao cardDao;

	@Resource(name = "gameTableDao")
	public void setBaseDao(GameTableDao gameTableDao) {
		super.setBaseDao(gameTableDao);
	}

	public GameTableServiceImpl() {

	}
	
	public void newGame() {
		if (baseDeck.size() == 0) {
			List<Card> cards = cardDao.findList();
			for (int i = 0; i < cards.size(); i++) {
				baseDeck.add(cards.get(i));
			}
		}
		StringBuilder sb = new StringBuilder();
	
		for (Card card : baseDeck) {
			sb.append(card.getText() + " ");
		}
	
		LogInfo logInfo = new LogInfo();
		logInfo.setStages(LogInfo.Stage.before);
		logInfo.setGameTable(gameTableDao.find(currentGameTableID));
		logInfo.setCardsStringInfo(sb.toString());
		logInfoDao.persist(logInfo);

	}

	private void shuffle() {

		Collections.shuffle(baseDeck);
		StringBuilder sb = new StringBuilder();
		for (Card card : baseDeck) {
				sb.append(card.getText() + " ");
			}			
		LogInfo logInfo = new LogInfo();
		logInfo.setStages(LogInfo.Stage.shuffled);
		logInfo.setCardsStringInfo(sb.toString());
		logInfo.setGameTable(gameTableDao.find(currentGameTableID));
		logInfoDao.persist(logInfo);
		
		
		

		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < baseDeck.size(); i++) {
			sb2.append(baseDeck.get(i).getId()).append(',');
		}
		String strCards = sb2.substring(0, sb2.lastIndexOf(","));
		GameHandCardList cardList = new GameHandCardList();
		cardList.setCards(strCards);
		cardList.setGameTable(gameTableDao.find(currentGameTableID));
		gameHandCardListDao.persist(cardList);
	}

	

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.cti.card.service.GameTableService#dealt()
	 */
	 void dealt() {
		Card[][] cardsArray = new Card[chosedPlayerCounts][3];

		for (int index = 0; index < chosedPlayerCounts; index++) {
			cardsArray[index][0] = baseDeck.get(index);
			cardsArray[index][1] = baseDeck.get(chosedPlayerCounts + index);
			cardsArray[index][2] = baseDeck.get(chosedPlayerCounts * 2 + index);
		}

		StringBuilder sb = new StringBuilder();
		for (int icount = 0; icount < chosedPlayerCounts; icount++) {

			sb.append(cardsArray[icount][0].getText() + " ");
			sb.append(cardsArray[icount][1].getText() + " ");
			sb.append(cardsArray[icount][2].getText() + " ");

		}

		LogInfo logInfo = new LogInfo();
		logInfo.setStages(LogInfo.Stage.dealt);
		logInfo.setGameTable(gameTableDao.find(currentGameTableID));
		logInfo.setCardsStringInfo(sb.toString());
		logInfoDao.persist(logInfo);
		
		

		int calcResult = judgeService.calculatewhowin(cardsArray,chosedPlayerCounts);
		GameHandRecord record = new GameHandRecord();
		record.setPlayNumber(chosedPlayerCounts);
		record.setGameTable(gameTableDao.find(currentGameTableID));
		record.setStartDate(new Date());

		if (calcResult > -1) {
			record.setResult(Result.win);
			record.setWinner(players.get(calcResult));
		} else {
			record.setResult(Result.draw);
		}

		gameHandRecordDao.persist(record);
		GameHandRecordDetail detail = null;
		for (int i = 0; i < chosedPlayerCounts; i++) {
			detail = new GameHandRecordDetail();

			detail.setFirstCard(cardsArray[i][0]);
			detail.setThirdCard(cardsArray[i][1]);
			detail.setSecondCard(cardsArray[i][2]);
			detail.setGameHandRecord(record);
			detail.setPlayer(players.get(i));
			gameHandRecordDetailDao.persist(detail);
		}

	}

	/*
	 * random select N number players (non-Javadoc)
	 * 
	 * @see com.cti.card.service.GameTableService#choosePlayer(int)
	 */
	 	Long choosePlayer(int counts) {
		chosedPlayerCounts = counts;
		players = (List<Player>) playerDao.findList();
		Collections.shuffle(players);
		// players.subList(fromIndex, toIndex);
		int playerSize = players.size();
		if (playerSize < 2 || playerSize > 17) {
			new Exception("Player size error!");
			return (long) -1;
		}

		GameTable gameTable = new GameTable();

		StringBuilder sb = new StringBuilder();

		for (int index = 0; index < chosedPlayerCounts; index++) {
			Long id = players.get(index).getId();
			sb.append(id);
			sb.append(",");
		}
		String strPlayers = sb.substring(0, sb.lastIndexOf(","));
		gameTable.setPlayers(strPlayers);
		gameTable.setUserCounts(chosedPlayerCounts);
		gameTableDao.persist(gameTable);
		currentGameTableID = gameTable.getId();
		return currentGameTableID;

	}

	public Long start(int counts) {	
			newGame();
			Long gameTableId= choosePlayer(counts);
			shuffle();
			dealt();
		
		return gameTableId;
	}

}
