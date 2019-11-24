package org.kpu.ticketbox.cinema;

import java.util.HashMap;
import java.util.Scanner;

import org.kpu.ticketbox.payment.BankTransfer;
import org.kpu.ticketbox.payment.CardPay;
import org.kpu.ticketbox.payment.MobilePay;
import org.kpu.ticketbox.payment.MovieTicket;
import org.kpu.ticketbox.payment.Pay;
import org.kpu.ticketbox.payment.Receipt;

public abstract class Screen {
	Scanner scan = new Scanner(System.in);
	
	protected int nTicketPrice; // 티켓 가격
	protected int nRowMax; // 좌석 행 최대 값
	protected int nColMax; // 좌석 열 최대 값
	protected String strMovieName; // 상영중인 영화제목
	protected String strMovieStory; // 상영중인 영화 줄거리
	
	protected MovieTicket [][] seatArray; // 좌석 2차원 배열
	
	public abstract void showMovieInfo( ); // 영화 정보 보여주기
	
	private int nCurrentReservedId = 100; // 예약번호 100부터 시작
	
	public HashMap<Integer, Receipt> receiptMap = new HashMap<Integer, Receipt>(); // 추가기능 2번, 3번에서 private을 public으로 바꿈
	
	Screen(String name, String story, int price, int row, int col) { // 생성자
		
		this.strMovieName = name;
		this.strMovieStory = story;
		this.nTicketPrice = price;
		
		this.nRowMax = row;
		this.nColMax = col;
		
		seatArray = new MovieTicket [nRowMax][nColMax]; // 영화관 좌석 2차원 배열 생성
		for(int i = 0; i<nRowMax; i++) {
			for(int j = 0; j<nColMax; j++) {
				seatArray[i][j] = new MovieTicket(); // 객체 안만들면 NullPoint에러
				seatArray[i][j].setcStatus(MovieTicket.SEAT_EMPTY_MARK); // 빈자리로 초기화
			}
		}
		
	}
	
	public void showScreenMenu() { // 상영관 메뉴 보여주기
		System.out.println("\n-----------------");
		System.out.println("영화 메뉴 - " + strMovieName);
		System.out.println("-----------------");
		System.out.println("1. 상영 영화 정보");
		System.out.println("2. 좌석 예약 현황");
		System.out.println("3. 좌석 예약하기");
		System.out.println("4. 좌석 결제하기");
		System.out.println("5. 메인 메뉴 이동");
	}
	
	public void showSeatMap() { // 상영관 좌석 예약 현황 보여주기
		System.out.println("\t[좌석 예약 현황]");
		
		System.out.print("    \t");
		for(int i = 1; i<=nRowMax; i++) { // 열 번호 깔기
			System.out.print("[" + i + "] ");
		}
		System.out.println();
		
		for(int i = 0; i<nRowMax; i++) { // 2차원 배열 출력하는 반복문
			System.out.print("\n[" + (i + 1) + "]\t"); // 행 번호 깔기
			for(int j = 0; j<nColMax; j++) {
				System.out.print("[" + seatArray[i][j].getcStatus() + "] ");
			}
		}
		System.out.println();
		
	}
	
	public void reserveTicket() { // 좌석 예약

		int row, col; // row가 열

		System.out.println("\n[ 좌석 예약 ]");
		
		while (true) { // 이미 예약을 했을 경우 예외처리

			while (true) { // 행 입력 예외처리를 위한 반복문
				System.out.printf("좌석 행 번호 입력(" + "1 ~ " + nColMax + ") : ");
				col = scan.nextInt();

				if (col > nColMax || col < 1)
					System.out.println("행의 입력 범위를 벗어났습니다. 다시 입력해주세요");

				else if (0 < col && col <= nColMax)
					break;

				else
					System.out.println("다시 입력해주세요");
			}

			while (true) { // 열 입력 예외처리
				System.out.printf("좌석 열 번호 입력(" + "1 ~ " + nRowMax + ") : ");
				row = scan.nextInt();

				if (row > nColMax || row < 1)
					System.out.println("열의 입력 범위를 벗어났습니다. 다시 입력해주세요");

				else if (0 < row && row <= nColMax)
					break;

				else
					System.out.println("다시 입력해주세요");
			}

			if (seatArray[col - 1][row - 1].getcStatus() != MovieTicket.SEAT_EMPTY_MARK)
				System.out.println("이미 예약된 자리 입니다.");

			else
				break;
		}
		
		seatArray[col-1][row-1].setnReservedId(nCurrentReservedId); // 예약 번호 저장, 배열 번호는 0부터 시작하기 때문에 -1
		seatArray[col-1][row-1].setcStatus(MovieTicket.SEAT_RESERVED_MARK); // 예약 상태로 변경
		seatArray[col-1][row-1].setSeat(col-1, row-1); // 행, 열 위치 저장
		
		System.out.println("행[" + col + "] 열[" + row + "] " + nCurrentReservedId++ + " 예약 번호로 접수되었습니다.");
	}
	
	public void payment() { // 결제
		
		int a; // 예약 번호 입력받는 변수
		int b; // 결제 방식 입력받는 변수
		int rowNum = -1; // 좌석 번호 임시 저장
		int colNum = -1;
		char c = 'a'; // 이미 예약이 되어있는 경우를 판별하기 위한 변수
		
		Receipt receipt; // Map객체를 담기 위한 변수
		
		String name; // 고객 이름 입력받을 때
		String number; // 은행 번호, 카드 번호, 핸드폰 번호 등을 입력받을 때
		
		System.out.println("\n[ 좌석 예약 결제 ]");
		
		while (true) { // 예약 번호를 입력받았을 때 예약 번호가 존재하지 않는 경우, 이미 결제를 했을 경우 예외처리
			System.out.printf("예약 번호를 입력하세요 >> ");
			a = scan.nextInt();

			for (int i = 0; i < nRowMax; i++) { // 예약 번호 검사하는 반복문
				for (int j = 0; j < nColMax; j++) {
					if (seatArray[i][j].getnReservedId() != a) {
						continue;
					} else if (seatArray[i][j].getnReservedId() == a) {
						colNum = seatArray[i][j].getCol(); // 행 번호 가져옴
						rowNum = seatArray[i][j].getRow(); // 열 번호 가져옴
						c = seatArray[i][j].getcStatus(); // 좌석 상태 가져옴
					}
				}
				if (rowNum != -1)
					break; // 메모리 절약
			}

			if (rowNum == -1)
				System.out.println("해당 예약번호가 존재하지 않습니다. 예약 번호를 확인해주세요");
			
			else if (c == MovieTicket.SEAT_PAY_COMPLETION_MARK) { // 결제 완료된 상태면 메뉴로 다시 나감
				System.out.println("이미 결제된 예약번호 입니다. 두 번 긁으실 필요 없습니다");
				return;
			}

			else if (rowNum != -1)
				break;
			
			else
				System.out.println("예약 번호를 다시 입력해주세요");
		}
		
		while (true) {
			System.out.println("\n------------------------------");
			System.out.println("\t결제 방식 선택");
			System.out.println("------------------------------");
			System.out.println("1. 은행 이체");
			System.out.println("2. 카드 결제");
			System.out.println("3. 모바일 결제");
			System.out.printf("결제 방식 입력(1 ~ 3) >> ");
			b = scan.nextInt();

			if (b == Pay.BANK_TRANSFER_PAYMENT) { // 은행 이체일 경우
				Pay bankTransfer = new BankTransfer(); // 은행 이체 객체 생성
				scan.nextLine(); // 버퍼 비우기
				
				System.out.println("\n\t[ 은행 이체 ]");
				System.out.printf("이름 입력: ");
				name = scan.nextLine();
				
				while (true) {
					System.out.printf("은행 번호 입력(12자리수): ");
					number = scan.nextLine();
					
					if(number.length() == 12)
						break;
					
					else
						System.out.println("12자리 수를 입력해주세요");
				}
				
				seatArray[colNum][rowNum].setcStatus(MovieTicket.SEAT_PAY_COMPLETION_MARK); // 좌석 결제 상태로 변경

				receiptMap.put(seatArray[colNum][rowNum].getnReservedId(),
						bankTransfer.charge(strMovieName, nTicketPrice, name, number)); // 키(예약 번호) + Receipt 객체
				receipt = receiptMap.get(seatArray[colNum][rowNum].getnReservedId());

				System.out.println("은행 결제가 완료되었습니다. : " + receipt.getTotalAmount() + "원");
				break;
			}

			else if (b == Pay.CREDIT_CARD_PAYMENT) { // 카드 결제일 경우
				Pay cardPay = new CardPay(); // 카드 결제 객체 생성
				scan.nextLine(); // 버퍼 비우기

				System.out.println("\n\t[ 카드 결제 ]");
				System.out.printf("이름 입력: ");
				name = scan.nextLine();
				
				while (true) {
					System.out.printf("카드 번호 입력(12자리수): ");
					number = scan.nextLine();
					
					if(number.length() == 12)
						break;
					
					else
						System.out.println("12자리 수를 입력해주세요");
				}

				seatArray[colNum][rowNum].setcStatus(MovieTicket.SEAT_PAY_COMPLETION_MARK); // 좌석 결제상태로 변경

				receiptMap.put(seatArray[colNum][rowNum].getnReservedId(),
						cardPay.charge(strMovieName, nTicketPrice, name, number)); // 키(예약 번호) + Receipt 객체
				receipt = receiptMap.get(seatArray[colNum][rowNum].getnReservedId());

				System.out.println("카드 결제가 완료되었습니다. : " + receipt.getTotalAmount() + "원");
				break;
			}

			else if (b == Pay.MOBILE_PHONE_PAYMENT) {
				Pay mobilePay = new MobilePay(); // 모바일 결제 객체 생성
				scan.nextLine(); // 버퍼 비우기

				System.out.println("\n\t[ 모바일 결제 ]");
				System.out.printf("이름 입력: ");
				name = scan.nextLine();
				
				while (true) {
					System.out.printf("핸드폰 번호 입력(11자리수): ");
					number = scan.nextLine();
					
					if(number.length() == 11)
						break;
					
					else
						System.out.println("11자리 수를 입력해주세요");
				}

				seatArray[colNum][rowNum].setcStatus(MovieTicket.SEAT_PAY_COMPLETION_MARK); // 좌석 결제상태로 변경

				receiptMap.put(seatArray[colNum][rowNum].getnReservedId(),
						mobilePay.charge(strMovieName, nTicketPrice, name, number)); // 키(예약 번호) + Receipt 객체
				receipt = receiptMap.get(seatArray[colNum][rowNum].getnReservedId());

				System.out.println("모바일 결제가 완료되었습니다. : " + receipt.getTotalAmount() + "원");
				break;
			}

			else
				System.out.println("결제 방식을 선택해주세요");
		} // while문 끝
		
	}
	
}