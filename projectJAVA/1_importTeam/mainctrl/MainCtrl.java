package mainctrl;

import java.util.Scanner;
import member.*;
import team.TeamList;

public class MainCtrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Member member = new Member(1, "ȫ�л�", "��ħ�̴�", "����Ʈ����");
		
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
				System.out.println("�޴� ��ȣ�� �ٽ� �Է��ϼ���");
			}
			
		}
		
	}

}

class MainMenu {
	
	Scanner scan = new Scanner(System.in);
	
	int choice;
	
	public int issueMenu() {
		
		System.out.println(" << �� �� �� �� >>");
		System.out.println(" 1. �л� ��� �߰�");
		System.out.println(" 2. �л� ��� ��� ���\n");
		System.out.println(" 3. ���� ��� �߰�");
		System.out.println(" 4. ���� ��� ��� ���\n");
		System.out.println(" 5. ��� ��ȸ");
		System.out.println(" 6. ��ü ��� ��� ���\n");
		System.out.println(" 7. Team �߰�");
		System.out.println(" 8. Team ��� ���");
		System.out.println(" 9. Team�� ��� ��� ���\n");
		System.out.println(" 0. ����");
		System.out.println("------------------------------");
		
		System.out.printf("�޴� ��ȣ? >> "); choice = scan.nextInt();
		System.out.printf("\n"); 
		
		return choice;
	}
	
}