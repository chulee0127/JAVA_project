package team;

import java.util.Scanner;
import member.*;

public class TeamList {

	private Team tList[];
	private int id;
	private String title;
	private int index = 0;

	private int teamNum;
	private int memberNum;
	private Member memberList[];
	private int a = 0;
	private String tTitle;

	public TeamList(int n) {
		tList = new Team[n];
		memberList = new Member[10];
		id = index + 1;

		tList[index++] = new Team(id++, "��ħ�̴�");
		tList[index++] = new Team(id++, "���ɸ԰�");
		tList[index++] = new Team(id++, "��ٰ���");
	}

	public void showAll() {
		System.out.println("--------------------------");
		System.out.println("ID\tTeam �̸�");
		System.out.println("--------------------------");

		for (int i = 0; i < index; i++) {
			tList[i].showData();
		}

		System.out.println("--------------------------");
	}

	public void addTeam() {

		Scanner scan = new Scanner(System.in);

		System.out.println(" < 7. �� �߰� > ");
		System.out.println(" - ID = " + id);
		System.out.printf(" - Ÿ��Ʋ: ");
		title = scan.nextLine();

		tList[index++] = new Team(id++, title);

		System.out.println(">> " + title + ": �� �߰�");
	}

	public void addTeamMember(MemberList ML) {

		Scanner scan = new Scanner(System.in);

		System.out.println(" < 8. �� ��� �߰� > ");

		showAll();

		System.out.printf(" - �� ID: ");
		teamNum = scan.nextInt();

		ML.showAll();

		while (true) {
			System.out.printf(" - ��� ID(0 = ������): ");
			memberNum = scan.nextInt();

			if (memberNum == 0)
				break;
			else {
				memberList[a++] = ML.memberReturn(memberNum);
			}
		}

		System.out.println(teamNum + "���� ���" + a + "�� �߰�");
	}

	public void showTeamMember() {
		Scanner scan = new Scanner(System.in);

		showAll();

		System.out.printf(" - �� ID: ");
		teamNum = scan.nextInt();
		for (int i = 0; i < index; i++) {
			if (title.equals(tList[i].tName())) {
				tTitle = title;
			}
		}
			
		System.out.println("\n" + tTitle + ": ������");
		System.out.println("--------------------------");
		System.out.println("ID\t�̸�\t����/ȸ��");
		System.out.println("--------------------------");
		for (int i = 0; i < a; i++) {
				memberList[i].showData();
			} 
		
		System.out.println("--------------------------");
		}
}