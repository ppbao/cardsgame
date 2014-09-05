package com.cti.card.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cti.card.common.Filter;
import com.cti.card.common.Filter.Operator;
import com.cti.card.common.StringUtils;
import com.cti.card.entity.Card;
import com.cti.card.entity.GameHandCardList;
import com.cti.card.entity.GameHandRecord;
import com.cti.card.entity.GameHandRecordDetail;
import com.cti.card.service.CardService;
import com.cti.card.service.GameHandCardListService;
import com.cti.card.service.GameHandRecordDetailService;
import com.cti.card.service.GameHandRecordService;
import com.cti.card.service.PlayerService;

@Controller
@RequestMapping("/round")
public class GameHistoryController {

	@Resource
	CardService cardService;

	@Resource
	PlayerService playerService;

	@Resource
	private GameHandCardListService gameHandCardListService;

	@Resource(name = "gameHandRecordService")
	private GameHandRecordService gameHandRecordService;

	@Resource(name = "gameHandRecordDetailService")
	private GameHandRecordDetailService gameHandRecordDetailService;

	@RequestMapping("/list")
	public ModelAndView gameTableList(ModelAndView mdv) {
		List<GameHandRecord> recordList = gameHandRecordService.findAll();
		mdv.addObject("recordList", recordList);
		mdv.setViewName("/handRecord/List");
		return mdv;
	}

	/*
	 * query certain player took part in how many times
	 * 
	 * @Param id
	 */
	@RequestMapping("/player/{id}")
	public ModelAndView gameTableByPlayerId(@PathVariable int id,
			ModelAndView mdv)

	{
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		filter.setOperator(Operator.eq);
		filter.setProperty("player");
		filter.setValue(playerService.find((long) id));
		filters.add(filter);
		List<GameHandRecordDetail> recordList = gameHandRecordDetailService
				.findList(null, null, filters, null);
		mdv.addObject("recordListOfPlayer", recordList);
		mdv.setViewName("handRecordList");

		return mdv;

	}

	/*
	 * query certain player win how many times
	 * 
	 * @Param id
	 */
	@RequestMapping("/player/win/{id}")
	public ModelAndView wingameTableByPlayerId(@PathVariable int id,
			ModelAndView mdv)

	{
		List<Filter> filters = new ArrayList<Filter>();
		Filter filter = new Filter();
		filter.setOperator(Operator.eq);
		filter.setProperty("winner");
		filter.setValue(playerService.find((long) id));
		filters.add(filter);
		List<GameHandRecord> recordList = gameHandRecordService.findList(null,
				null, filters, null);
		mdv.addObject("recordList", recordList);
		mdv.setViewName("handRecordList");

		return mdv;

	}

	@RequestMapping(value = "/detail/{id}")
	public ModelAndView roundDetail(@PathVariable Long id, ModelAndView mdv) {
		if (gameHandRecordService.find(id) != null) {

			List<Filter> filters = new ArrayList<Filter>();

			Filter filter = new Filter();
			filter.setOperator(Operator.eq);
			filter.setProperty("gameHandRecord");
			filter.setValue(gameHandRecordService.find(id));
			filters.add(filter);

			List<GameHandRecordDetail> detailList = gameHandRecordDetailService
					.findList(null, null, filters, null);

			mdv.addObject("detailList", detailList);
			mdv.setViewName("/handRecord/index");

		} else {
			mdv.addObject("detailList", null);
			mdv.setViewName("/handRecord/index");
		}

		return mdv;

	}

}
