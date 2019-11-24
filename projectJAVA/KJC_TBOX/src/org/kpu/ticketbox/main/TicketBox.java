package org.kpu.ticketbox.main;

import org.kpu.ticketbox.cinema.*;
import org.kpu.ticketbox.util.BackupWriter;
import org.kpu.ticketbox.util.Statistics;

import java.util.Scanner;

public class TicketBox {
	
	Scanner scan = new Scanner(System.in);
	// Screen(영화제목, 영화 줄거리, 티켓가격, 좌석(rowMax), 좌석(colMax))
	private FamilyScreen familyScreen;
	private AnimationScreen animationScreen;
	private PremiumScreen premiumScreen;
	
	public static final String ADMIN_PASSWORD = "admin";

	public void initScreen() {
		familyScreen = new FamilyScreen("굿 월 헌팅", "천재적 두뇌를 가진 불우한 반항아", 8000, 10, 10);
		animationScreen = new AnimationScreen("아담스 패밀리", "세상에서 가장 무섭고 사랑스러운 가족 어드벤처", 10000, 10, 10);
		premiumScreen = new PremiumScreen("매트릭스", "인공 두뇌를 가진 컴퓨터가 지배하는 가상현실 공간 매트릭스 ", 30000, 5, 5);
	}

	public void managerMode() { // 관리자 기능
		
		double familyMoney; // 결제 총합 결과를 임시 저장할 변수
		double aniMoney;
		double preMoney;
		int count; // 영화관 총 티켓 판매량 계산을 위한 변수
		
		BackupWriter writer = new BackupWriter(); // 백업 객체 생성
		
		System.out.println("-------------------------");
		System.out.println("----   관리자 기능   ----");
		System.out.println("-------------------------");
		
		familyMoney = Statistics.sum(familyScreen.receiptMap); // 결제 총합 계산
		System.out.println("가족 영화관 결제 총액: " + familyMoney + "원");
		
		aniMoney = Statistics.sum(animationScreen.receiptMap);
		System.out.println("애니메이션 영화관 결제 총액: " + aniMoney + "원");
		
		preMoney = Statistics.sum(premiumScreen.receiptMap);
		System.out.println("프리미엄 영화관 결제 총액: " + preMoney + "원");
		
		count = familyScreen.receiptMap.size() + animationScreen.receiptMap.size() + premiumScreen.receiptMap.size(); // 총 티켓 판매량 총합
		System.out.println("영화관 총 티켓 판매량: " + count);
		
		System.out.println("\n <<< c:\\\\temp\\\\receipt.txt 백업 시작합니다. >>> ");
		writer.backupFile("가족 영화관", familyScreen.receiptMap);
		writer.backupFile("애니메이션 영화관", animationScreen.receiptMap);
		writer.backupFile("프리미엄 영화관", premiumScreen.receiptMap);
	}
	
	public Screen selectScreen() {
		int a; // 선택한 메뉴 번호를 저장하기 위한 변수

		while (true) {
			System.out.println("-------------------------");
			System.out.println("- 상영관 선택 메인 메뉴 -");
			System.out.println("-------------------------");
			System.out.println("1. 가족 영화 1관");
			System.out.println("2. 애니메이션 영화 2관");
			System.out.println("3. 프리미엄 영화 3관 (식사, 커피 제공) ");
			System.out.println("9. 관리자 메뉴");
			System.out.println("	선택 (1~3, 9)외 종료");

			System.out.printf("상영관 선택 >> ");
			a = scan.nextInt();

			if (a == 1)
				return familyScreen;

			else if (a == 2)
				return animationScreen;

			else if (a == 3)
				return premiumScreen;
			
			else if (a == 9) {
				String passwd;
				scan.nextLine(); // 버퍼 비우기

				System.out.printf("암호입력: ");
				passwd = scan.nextLine();

				if (passwd.equals(ADMIN_PASSWORD)) {
					managerMode();
					return null; // 관리자 모드 실행하고 끝냄
				}

				else
					System.out.println("관리자 비밀번호가 일치하지 않습니다.");
			}

			else // 종료하기 위한 else문
				return null;
		} // while문 끝
	}
	
}