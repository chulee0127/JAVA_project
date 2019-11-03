package org.kpu.atm.util;

import org.kpu.atm.bank.Account;

public class Statistics {
	
	public Statistics() { }
	
	public static int ATMoney(Account[] accountArray, int num, int machineBalance) {
		int sum = 0; // 고객잔고 총액
		int ATMsum = 0; // ATM기의 잔고 총액
		
		for(int i = 0; i < num; i++) { // 잔고의 총합을 더한다
			sum += accountArray[i].getnBalance();
		}
		
		ATMsum = sum + machineBalance; // ATM기의 잔고와 고객 잔고를 더함
		
		return ATMsum;
	}
	
	public static int sumMoney(Account[] accountArray, int num) { // 고객 잔고의 총합
		int sum = 0; // 잔고의 총합을 구할 변수
		
		for(int i = 0; i < num; i++) { // 잔고의 총합을 더한다
			sum += accountArray[i].getnBalance();
		}
		
		return sum;
	}
	
	public static int AVGMoney(Account[] accountArray, int num){ // 고객 잔고의 평균
		int avg = 0; // 평균값을 담을 변수
		int sum = 0; // 합을 구할 변수
		
		for(int i = 0; i < num; i++) { // 잔고의 총합을 더한다
			sum += accountArray[i].getnBalance();
		}
		
		avg = sum/num;
		
		return avg;
	}
	
	public static Account highMoney(Account[] accountArray, int num) { // 가장 많은 잔고를 가지고 있는 고객
		
		Account Arr = accountArray[0]; // 최고 금액을 가진 고객을 임시 저장하기 위한 변수
		
		for(int i = 0; i<num; i++) { // for문으로 비교한다
			if(accountArray[i+1] != null && accountArray[i+1].getnBalance() > accountArray[i].getnBalance()) {
				Arr = accountArray[i+1];
			}
		}
		
		return Arr;
	}
	
	public static Account[] cusSort(Account[] accountArray, int num) { // 고객 잔고순으로 내림차순 정렬
		
		Account temp = null; // 고객계좌 내림차순 정렬을 위한 변수
		
		for(int i = 0; i<num; i++) { // 이중 for문으로 내림차순 정렬
			for(int j = 0; j<num - 1; j++) {
				if(accountArray[j].getnBalance() < accountArray[j+1].getnBalance()) {
					temp = accountArray[j];
					accountArray[j] = accountArray[j+1];
					accountArray[j+1] = temp;
				}
			}
		}
		
		return accountArray;
	}
	
}