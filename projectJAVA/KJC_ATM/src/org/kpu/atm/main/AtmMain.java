package org.kpu.atm.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.kpu.atm.bank.ATMachine;

public class AtmMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ATMachine atm = new ATMachine(1000, 500000, "admin"); // atm객체 초기화
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			atm.displayMenu(); // 메뉴를 보여준다
			System.out.printf("메뉴를 선택하세요 >>> ");
			try {
				int select = scan.nextInt();
				
				switch(select) {
				case 1: // 계좌 개설
					atm.createAccount();
					break;
					
				case 2: // 계좌 조회
					atm.checkMoney();
					break;
					
				case 3: // 계좌 입금
					atm.depositMoney();
					break;
					
				case 4: // 계좌 출금
					atm.widrawMoney();
					break;
					
				case 5: // 고객 관리
					atm.managerMode();
					break;
					
				case 9: // 종료
					System.out.println("안녕히 가세요!");
					return;
				}
			} catch(InputMismatchException e) {
				System.out.println("정확하게 입력해주세요");
				continue;
			}
		}
		
	}
}