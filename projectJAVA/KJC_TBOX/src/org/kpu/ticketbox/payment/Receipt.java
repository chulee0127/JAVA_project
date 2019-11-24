package org.kpu.ticketbox.payment;

public class Receipt {
	
	String client; // 사용자 이름 + 결제 정보
	String productName; // 영화 상품 이름
	String payMethod; // 결제 수단
	double subTotalAmount; // 커미션 제외한 금액
	double totalAmount; // 커미션 포함한 금액
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public String getClient() {
		return client;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public String getPayMethod() {
		return payMethod;
	}
	
	public double getSubTotalAmount() {
		return subTotalAmount;
	}
	
	@Override // 무슨 뜻일까요?
	public String toString() {
		return "client= " + client + ", productName=" + productName + ", payMethod=" + payMethod + ", subTotalAmount=" + subTotalAmount + ", totalAmount=" + totalAmount;
		}

}