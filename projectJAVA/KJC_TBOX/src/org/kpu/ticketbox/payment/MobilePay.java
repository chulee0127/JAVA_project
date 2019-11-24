package org.kpu.ticketbox.payment;

public class MobilePay implements Pay {
	
	public static final double MOBILE_COMMISION = 0.2;

	public Receipt charge(String product, double amount, String name, String number) {

		Receipt receipt = new Receipt();

		receipt.productName = product;
		receipt.subTotalAmount = amount;
		receipt.totalAmount = amount + (amount * MOBILE_COMMISION);
		receipt.client = name + "#" + number;
		receipt.payMethod = "MobilePay";
		
		return receipt;
	}

}