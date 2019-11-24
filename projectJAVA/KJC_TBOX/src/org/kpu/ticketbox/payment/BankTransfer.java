package org.kpu.ticketbox.payment;

public class BankTransfer implements Pay {
	
	public static final double BANK_TRANSFER_COMMISION = 0.1;
	
	public Receipt charge(String product, double amount, String name, String number) {
		
		Receipt receipt = new Receipt();
		
		receipt.productName = product;
		receipt.subTotalAmount = amount;
		receipt.totalAmount = amount + (amount * BANK_TRANSFER_COMMISION);
		receipt.client = name + "#" + number;
		receipt.payMethod = "BankTransfer";
		
		return receipt;
	}
	
}