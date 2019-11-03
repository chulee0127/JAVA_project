package org.kpu.atm.bank;

import java.util.Scanner;

import org.kpu.atm.util.Statistics;

public class ATMachine {
	
	private Account[] accountArray; // 고객계좌배열 참조변수
	private int nMachineBalance; // ATM기의 현금 잔액 != 총 계좌 잔액
	private int nMaxAccountNum = 0; // 고객계좌 참조변수 배열크기
	private int nCurrentAccountNum = 0; // 개설된 고객계좌 수
	private String strManagerPassword; // 관리자 비밀번호
	
	public static final int BASE_ACCOUNT_ID = 100; // 고객 계좌 발급시 시작 번호
	private int nID = BASE_ACCOUNT_ID; // final값이라 변경 안되서 임시 저장
	
	private String name; // 고객 이름 입력받을 때
	private String password; // 고객 비밀번호 입력받을 때
	private int inputID; // 계좌번호 입력 받을 때
	private String inputPassword; // 고객 비밀번호 입력 받을 때
	private boolean wow = false; // 개인정보 인증할 때 true, false 담는 변수
	private int deposit; // 입금액 입력 받음
	private int widraw; // 출금액 입력 받음
	private String inputAdmin; // 관리자 비밀번호 입력 받음
	
	public ATMachine(int size, int balance, String password) { // 생성자
		
		accountArray = new Account[size]; // 사이즈만큼 계좌 객체를 생성
		this.nMachineBalance = balance; // ATM잔고 초기화
		this.strManagerPassword = password; // 관리자 비밀번호 초기화
	}
	
	public void createAccount() { // 계좌 개설
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------------개설------------");
		System.out.printf("이름 입력: ");
		name = scan.nextLine();
		System.out.printf("암호 입력: ");
		password = scan.nextLine();
		
		accountArray[nMaxAccountNum++] = new Account(nID, 0, name, password);
		System.out.println(name + "님 " + nID + "번 계좌번호가 정상적으로 개설되었습니다. 감사합니다");
		
		nID++; // 계좌번호
		nCurrentAccountNum++; // 개설된 고객계좌 수
	}
	
	public void checkMoney() { // 계좌 조회
		Scanner scan = new Scanner(System.in);
		int a; // 계좌번호 확인용
		int b; // 배열번호 임시저장
		int c; // 비밀번호 확인용
		
		while (true) {
			a = 0;
			b = 0;
			c = 0;
			
			System.out.println("------------조회------------");
			System.out.printf("계좌번호 입력: ");
			inputID = scan.nextInt();

			for (int i = 0; i < nCurrentAccountNum; i++) { // 입력받은 계좌번호가 있는지 먼저 조회한다
				if (inputID == accountArray[i].getnID()) { // 입력받은 계좌번호가 존재한다면
					b = i;
					a++;
				}
			}
			
			if (a == 0) {
				System.out.println("계좌번호가 존재하지 않습니다. 다시 입력해주세요");
				continue;
			}
			
			scan.nextLine(); // 개행

			while(true) {
			System.out.printf("비밀번호 입력: ");
			inputPassword = scan.nextLine();
			
			wow = accountArray[b].authenticate(inputID, inputPassword); // boolean 함수로 들어가 검사한다
			// System.out.println(wow);
			if (wow == true) { // 비밀번호가 맞다면
				System.out.println("계좌 잔액: " + accountArray[b].getnBalance());
				c++;
				break;
			}
			else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
				continue;
				}
			
			}
			
			if(c > 0)
				break;
		}
		
	}
	
	public void depositMoney() {
		Scanner scan = new Scanner(System.in);
		int a; // 계좌번호 확인용
		int b; // 배열번호 임시저장
		int c; // 비밀번호 확인용

		while (true) {
			a = 0;
			b = 0;
			c = 0;

			System.out.println("------------입금------------");
			System.out.printf("계좌번호 입력: ");
			inputID = scan.nextInt();

			for (int i = 0; i < nCurrentAccountNum; i++) { // 입력받은 계좌번호가 있는지 먼저 조회한다
				if (inputID == accountArray[i].getnID()) { // 입력받은 계좌번호가 존재한다면
					b = i;
					a++;
				}
			}

			if (a == 0) {
				System.out.println("계좌번호가 존재하지 않습니다. 다시 입력해주세요");
				continue;
			}

			scan.nextLine(); // 개행

			while (true) {
				System.out.printf("비밀번호 입력: ");
				inputPassword = scan.nextLine();

				wow = accountArray[b].authenticate(inputID, inputPassword); // boolean 함수로 들어가 검사한다
				// System.out.println(wow);
				if (wow == true) {
					System.out.printf("입금액 입력: ");
					deposit = scan.nextInt();

					System.out.println("입금 후 잔액: " + accountArray[b].deposit(deposit)); // 금액을 넣어줌과 동시에 출력
					c++;
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
					continue;
				}
			}

			if (c > 0)
				break;
		}

	}
	
	public void widrawMoney() {
		Scanner scan = new Scanner(System.in);
		int a; // 계좌번호 확인용
		int b; // 배열번호 임시저장
		int c; // 비밀번호 확인용

		while (true) {
			a = 0; // 재접속을 생각하여 while문 안에서 초기화
			b = 0;
			c = 0;

			System.out.println("------------출금------------");
			System.out.printf("계좌번호 입력: ");
			inputID = scan.nextInt();

			for (int i = 0; i < nCurrentAccountNum; i++) { // 입력받은 계좌번호가 있는지 먼저 조회한다
				if (inputID == accountArray[i].getnID()) { // 입력받은 계좌번호가 존재한다면
					b = i;
					a++;
				}
			}

			if (a == 0) {
				System.out.println("계좌번호가 존재하지 않습니다. 다시 입력해주세요");
				continue;
			} else
				break;

		}

		scan.nextLine(); // 개행

		while (true) {
			System.out.printf("비밀번호 입력: ");
			inputPassword = scan.nextLine();

			wow = accountArray[b].authenticate(inputID, inputPassword); // boolean 함수로 들어가 검사한다
			// System.out.println(wow);
			if (wow == true) {
				while (true) {
					System.out.printf("출금액 입력: ");
					widraw = scan.nextInt();

					// 출금액이 잔액보다 많으면 예외처리 추가
					if (accountArray[b].getnBalance() < widraw) {
						System.out.println("입력하신 금액이 잔액보다 많습니다. 다시 입력해주세요");
						continue;
					}
					// 정상입력 했을 때
					System.out.println("출금 후 잔액: " + accountArray[b].widraw(widraw)); // 금액을 넣어줌과 동시에 출력
					c++;
					break;

				}
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
				continue;
			}

			if (c > 0)
				break;
		}

	}
	
	public void managerMode() { // 관리자 모드
		Scanner scan = new Scanner(System.in);
		Account Arr; // 잔고가 제일 많은 고객의 정보를 담기위한 임시변수
		int sum; // 잔고의 총합을 임시저장하기 위한 변수
		int ATMsum; // ATM기 잔고의 총액을 임시저장하기 위한 변수
		int avg; // 고객 잔고의 평균 금액을 임시저장하기 위한 변수
		
		while(true) {
		System.out.println("------------고객관리------------");
		System.out.printf("관리자 비밀번호 입력: ");
		inputAdmin = scan.nextLine();
		
		if(inputAdmin.equals(strManagerPassword)) { // 관리자 비밀번호가 같다면
			
			ATMsum = Statistics.ATMoney(accountArray, nCurrentAccountNum, nMachineBalance);  // ATMoney메서드에서 ATM기 잔고 총합을 구해서 온다
			System.out.println("ATM현금 잔고: " + ATMsum);
			
			sum = Statistics.sumMoney(accountArray, nCurrentAccountNum); // sumMoney메서드에 들어가서 잔고 총액을 구한다
			System.out.println("고객 잔고 총액: " + sum + "(" + nCurrentAccountNum + "명)"); // 잔고의 총 합
			
			avg = Statistics.AVGMoney(accountArray, nCurrentAccountNum); // AVGMoney메소드에 들어가 고객잔고 평균을 구한다
			System.out.println("고객 잔고 평균: " + avg); // 잔고의 총 합을 고객수로 나눈다
			
			Arr = Statistics.highMoney(accountArray, nCurrentAccountNum); // static메소드 highMoney로 들어가 잔고가 제일 많은 고객을 구한다
			System.out.println("고객 잔고 최고: " +  Arr.getnBalance());
			
			System.out.println("고객 계좌 현황(고객 잔고 내림차순 정렬)");
			Statistics.cusSort(accountArray, nCurrentAccountNum); // static메소드 cusSort로 들어가 내림차순 정렬을 하고
			for(int i = 0; i<nCurrentAccountNum; i++) { // 출력한다
				System.out.println(accountArray[i].getAccountName() + "    " + accountArray[i].getnID() + "     " + accountArray[i].getnBalance());
			}
		
			break;
		}
		else
			System.out.println("관리자 비밀번호가 틀립니다. 다시 입력해주세요");
		
		}
	}
	
	public void displayMenu() { // 메인 메뉴 표시
		System.out.println("\n------------------------");
		System.out.println("-       KPU bank       -");
		System.out.println("------------------------");
		System.out.println(" 1. 계좌 개설");
		System.out.println(" 2. 계좌 조회");
		System.out.println(" 3. 계좌 입금");
		System.out.println(" 4. 계좌 출금");
		System.out.println(" 5. 고객 관리");
		System.out.println(" 9. 업무 종료");
	}
	
}