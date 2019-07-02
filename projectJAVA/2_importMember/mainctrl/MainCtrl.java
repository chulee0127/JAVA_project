package mainctrl;

import java.util.Scanner;
import member.*;
import team.TeamList;

public class MainCtrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;

		MainMenu mm = new MainMenu();
		MemberList ML = new MemberList(50);
		TeamList TL = new TeamList(50);

		while (true) {
			choice = mm.issueMenu();

			if (choice == 1) {
				ML.addStudent();
			} else if (choice == 2) {
				ML.showStudent();
			} else if (choice == 3) {
				ML.addMentor();
			} else if (choice == 4) {
				ML.showMentor();
			} else if (choice == 5) {
				ML.findMember();
			} else if (choice == 6) {
				ML.showAll();
			} else if (choice == 7) {
				TL.addTeam();
			} else if (choice == 8) {
				TL.addTeamMember(ML);
			} else if (choice == 9) {
				TL.showTeamMember();
			} else if (choice == 10) {
				TL.showAll();
			} else if (choice == 0) {
				return;
			} else {
				System.out.println("메뉴 번호를 다시 입력하세요\n");
			}
		}

	}

}

class MainMenu {

	Scanner scan = new Scanner(System.in);

	private int choice;

	public int issueMenu() {
		System.out.println(" << 메 인 메 뉴 >> ");
		System.out.println("1. 학생 멤버 추가 ");
		System.out.println("2. 학생 멤버 목록 출력\n");
		System.out.println("3. 멘토 멤버 추가");
		System.out.println("4. 멘토 멤버 목록 출력\n");
		System.out.println("5. 멤버 조회");
		System.out.println("6. 전체 멤버 목록 출력\n");
		System.out.println("7. 팀 추가");
		System.out.println("8. 팀별 멤버 추가");
		System.out.println("9. 팀 구성 내용 출력");
		System.out.println("10. 전체 팀 구성 내용 출력\n");

		System.out.printf("0. 종료\n");
		System.out.println("------------------------------");
		System.out.printf("메뉴 번호? >> ");
		choice = scan.nextInt();

		return choice;
	}
}