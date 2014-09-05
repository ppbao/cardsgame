package com.cti.card.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cti.card.common.Filter;
import com.cti.card.common.Filter.Operator;
import com.cti.card.common.StringUtils;
import com.cti.card.entity.Card;
import com.cti.card.entity.GameHandCardList;
import com.cti.card.entity.GameHandRecord;
import com.cti.card.entity.GameHandRecordDetail;
import com.cti.card.entity.LogInfo;
import com.cti.card.entity.LogInfo.Stage;
import com.cti.card.service.CardService;
import com.cti.card.service.GameHandCardListService;
import com.cti.card.service.GameHandRecordDetailService;
import com.cti.card.service.GameHandRecordService;
import com.cti.card.service.GameTableService;
import com.cti.card.service.LogInfoService;
import com.cti.card.service.PlayerService;

@Controller
public class GameTableController {

	@Resource(name = "gameTableService")
	private GameTableService gameTableService;
	@Resource
	private PlayerService playerService;

	@Resource
	private CardService cardService;
	
	@Resource
	private GameHandCardListService gameHandCardListService;
	
	  
	@Resource(name="gameHandRecordService") 
	private GameHandRecordService gameHandRecordService;
	
	@Resource(name="gameHandRecordDetailService")
	private GameHandRecordDetailService gameHandRecordDetailService;
	
	@RequestMapping("/")
	public String play()
	{
		return "home";
	}
	
	
	@RequestMapping("/newGame")
	public ModelAndView newGame(@RequestParam int numberOfPlayer,ModelAndView mdv) {
		if(numberOfPlayer<2||numberOfPlayer>17)
		{
			new Exception("Number of player should more than 2 or less than 17");
		}
		Long gameTableId =(Long) gameTableService.start(numberOfPlayer);
		
		List<Filter>filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		filter.setOperator(Operator.eq);
		filter.setProperty("gameTable");
		filter.setValue(gameTableService.find(gameTableId));
		filters.add(filter);
		List<GameHandCardList>gameHandCardLists =gameHandCardListService.findList(null, null, filters, null);
		if(gameHandCardLists!=null &&gameHandCardLists.size()>0)
		{
			
			String strIds= gameHandCardLists.get(0).getCards();
			
			String[]ids = strIds.split(",");
		  	Long[]Lids = StringUtils.convertionToLong(ids);
		  	
		  	List<Card> cards =cardService.findList(Lids);
		  	
			mdv.addObject("cards", cards);
		}
		 
			filter.setOperator(Operator.eq);
			filter.setProperty("gameTable");
			filter.setValue(gameTableService.find(gameTableId));
			filters.clear();
			filters.add(filter);
		  	List<GameHandRecord> record = gameHandRecordService.findList(null,null,filters,null);
		 
		  	
		  	filter.setOperator(Operator.eq);
			filter.setProperty("gameHandRecord");
			filter.setValue(record.get(0));
			filters.clear();
			filters.add(filter);
		  	
		  List<	GameHandRecordDetail> detailList =(List<GameHandRecordDetail>) gameHandRecordDetailService.findList(null, null, filters, null);
	
			mdv.addObject("detailList",detailList);
			 
		 
		mdv.setViewName("home");
		return mdv;
	}
	

}
