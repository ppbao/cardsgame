package com.cti.card.common;

import org.springframework.stereotype.Component;

import com.cti.card.entity.Card;

@Component(value = "judgeService")
public class JudgeServiceFaceImpl implements JudgeService {

	@Override
	public int calculatewhowin(Card[][] array, int row) {

		// step one to store each player face card number and cardnum sum value;
		int[][] playerSumValueArray = new int[row][2];// strore each player
														// cardNumSum,
														// cardwithFaceNumber

		for (int rowIndex = 0; rowIndex < row; rowIndex++) {
			int faceNum = 0;
			int cardNumberSum = 0;
			for (int i = 0; i < 3; i++) {
				int cardNum = array[rowIndex][i].getCardNumber();

				cardNumberSum += cardNum;
				if (cardNum > 10) // if >10 then J,Q,K,A
				{
					faceNum++;
				}
			}

			playerSumValueArray[rowIndex][0] = faceNum;
			playerSumValueArray[rowIndex][1] = cardNumberSum;
		}
		// step two to check whether some player's face card is more than
		// other's

		int baseMax = 0;
		boolean repeat = false;

		int baseFaceNum = playerSumValueArray[0][0];
		for (int ncount = 1; ncount < row; ncount++) {
			if (playerSumValueArray[ncount][0] < baseFaceNum)
				continue;
			if (playerSumValueArray[ncount][0] == baseFaceNum) {
				repeat = true;
			}
			if (playerSumValueArray[ncount][0] > baseFaceNum) {
				baseFaceNum = playerSumValueArray[ncount][0];
				repeat = false;
				baseMax = ncount;
			}
		}

		if (!repeat) {
			return baseMax;
		}
		// step three
		// if more than one people share the same max face card then
		// check the sum value of each card
		// to check whether some player's card sum num is more than other's
		repeat = false;
		baseMax = 0;
		int baseSumNum = playerSumValueArray[0][1];

		for (int ncount = 1; ncount < row; ncount++) {
			if (playerSumValueArray[ncount][1] < baseSumNum)
				continue;
			if (playerSumValueArray[ncount][1] == baseSumNum) {
				repeat = true;
			}
			if (playerSumValueArray[ncount][1] > baseSumNum) {
				baseSumNum = playerSumValueArray[ncount][1];
				repeat = false;
				baseMax = ncount;
			}
		}

		if (!repeat) {
			return baseMax;
		}

		return -1;
	}

}
