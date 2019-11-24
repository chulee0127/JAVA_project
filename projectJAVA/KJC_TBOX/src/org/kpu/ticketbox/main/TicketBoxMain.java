package org.kpu.ticketbox.main;

import java.util.Scanner;

import org.kpu.ticketbox.cinema.Screen;

public class TicketBoxMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		TicketBox ticketBox = new TicketBox();
		
		Screen screen = null;
		boolean bMainMenu = true; // 상영관 선택 메뉴 사용
		
		ticketBox.initScreen(); // 초기화 ( 3 스크린 객체를 생성 )
		
		while(true) {
			if (bMainMenu) {
				screen = ticketBox.selectScreen(); // 영화 선택창을 띄운다.

				if (screen == null) {
					System.out.print(" 안녕히 가세요 !");
					scan.close();
					System.exit(0);
				}

				bMainMenu = false; // 영화메뉴에서 메인메뉴로 돌아오기 위한 설정
			}

			screen.showScreenMenu();
			System.out.print("메뉴를 선택하세요 >> ");
			try {
				int select = scan.nextInt();
				
				switch(select) {
				case 1: // 스크린 상영 영화 정보 보기
					screen.showMovieInfo();
					break;
				
				case 2:
					screen.showSeatMap();
					break;
					
				case 3:
					screen.reserveTicket();
					break;
					
				case 4:
					screen.payment();
					break;
					
				case 5:
					bMainMenu = true; // 메인메뉴로 이동
					break;					
				}
			}catch(Exception e) {
				System.out.println("번호를 다시 입력하세요");
			}
		} // while문 끝
		
	}

}