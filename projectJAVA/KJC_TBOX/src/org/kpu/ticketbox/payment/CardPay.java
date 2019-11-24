package org.kpu.ticketbox.payment;

public class CardPay implements Pay{
	
	public static final double CARD_COMMISION = 0.15;

	public Receipt charge(String product, double amount, String name, String number) {

		Receipt receipt = new Receipt();

		receipt.productName = product;
		receipt.subTotalAmount = amount;
		receipt.totalAmount = amount + (amount * CARD_COMMISION);
		receipt.client = name + "#" + number;
		receipt.payMethod = "CardPay";
		
		return receipt;
	}

}