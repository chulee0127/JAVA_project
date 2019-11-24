package org.kpu.ticketbox.util;

import java.util.HashMap;

import org.kpu.ticketbox.payment.Receipt;

public class Statistics {
	
	// 스크린 별 결제 금액 총액 계산
	public static double sum(HashMap<Integer, Receipt> map) {
		
		double money = 0.0;
		
		for (int ReservedId : map.keySet()) {

			Receipt receipt = map.get(ReservedId);

			money = money + receipt.getTotalAmount(); // 가격 총합 계산
		}
		
		return money;
	}
	
}