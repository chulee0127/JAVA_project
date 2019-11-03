package org.kpu.atm.bank;

public class Account {
	
	private int nID; // 계좌번호
	private int nBalance; // 잔액
	private String strAccountName; // 고객명
	private String strPassword; // 계좌 비밀번호
	
	public Account(int id, int money, String name, String password) { // 생성자
		
		nID = id;
		nBalance = money;
		strAccountName = name;
		strPassword = password;
	}
	
	boolean authenticate(int id, String password) { // 계정 확인
		
		if(nID == id && strPassword.equals(password))
			return true;
		
		else
			return false;
	}
	
	public int getnID() {
		return nID;
	}
	
	public int getnBalance() {
		return nBalance;
	}
	
	public int deposit(int money) {
		
		nBalance += money;
		
		return nBalance;
	}
	
	public int widraw(int money) {
		
		nBalance = nBalance - money;

		return nBalance;
	}
	
	public String getAccountName() {
		return strAccountName;
	}
	
}