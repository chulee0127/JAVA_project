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
				System.out.println("�޴� ��ȣ�� �ٽ� �Է��ϼ���\n");
			}
		}

	}

}

class MainMenu {

	Scanner scan = new Scanner(System.in);

	private int choice;

	public int issueMenu() {
		System.out.println(" << �� �� �� �� >> ");
		System.out.println("1. �л� ��� �߰� ");
		System.out.println("2. �л� ��� ��� ���\n");
		System.out.println("3. ���� ��� �߰�");
		System.out.println("4. ���� ��� ��� ���\n");
		System.out.println("5. ��� ��ȸ");
		System.out.println("6. ��ü ��� ��� ���\n");
		System.out.println("7. �� �߰�");
		System.out.println("8. ���� ��� �߰�");
		System.out.println("9. �� ���� ���� ���");
		System.out.println("10. ��ü �� ���� ���� ���\n");

		System.out.printf("0. ����\n");
		System.out.println("------------------------------");
		System.out.printf("�޴� ��ȣ? >> ");
		choice = scan.nextInt();

		return choice;
	}
}