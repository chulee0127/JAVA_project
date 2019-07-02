package mainctrl;

import java.util.Scanner;
import member.*;
import team.TeamList;

public class MainCtrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Member member = new Member(1, "홍학생", "아침이다", "소프트웨어");
		
		//member.showStudent();
		
		int choice;
		MainMenu mm = new MainMenu();
		
		TeamList tList = new TeamList(50);
		MemberList mList = new MemberList(50);
		
		while(true) {
			choice = mm.issueMenu();
			
			if(choice == 1) {
				mList.addStudent(tList);
			}
			else if(choice == 2) {
				mList.showStudentAll();
			}
			else if(choice == 3) {
				mList.addMentor(tList);
			}
			else if(choice == 4) {
				mList.showMentorAll();
			}
			else if(choice == 5) {
				mList.check();
			}
			else if(choice == 6) {
				mList.showAll();
			}
			else if(choice == 7) {
				tList.addTeam();
			}
			else if(choice == 8) {
				tList.showAll();
			}
			else if(choice == 9) {
				mList.checkTeam(tList);
			}
			else if(choice == 0) {
				return;
			}
			else {
				System.out.println("메뉴 번호를 다시 입력하세요");
			}
			
		}
		
	}

}

class MainMenu {
	
	Scanner scan = new Scanner(System.in);
	
	int choice;
	
	public int issueMenu() {
		
		System.out.println(" << 메 인 메 뉴 >>");
		System.out.println(" 1. 학생 멤버 추가");
		System.out.println(" 2. 학생 멤버 목록 출력\n");
		System.out.println(" 3. 멘토 멤버 추가");
		System.out.println(" 4. 멘토 멤버 목록 출력\n");
		System.out.println(" 5. 멤버 조회");
		System.out.println(" 6. 전체 멤버 목록 출력\n");
		System.out.println(" 7. Team 추가");
		System.out.println(" 8. Team 목록 출력");
		System.out.println(" 9. Team별 멤버 목록 출력\n");
		System.out.println(" 0. 종료");
		System.out.println("------------------------------");
		
		System.out.printf("메뉴 번호? >> "); choice = scan.nextInt();
		System.out.printf("\n"); 
		
		return choice;
	}
	
}