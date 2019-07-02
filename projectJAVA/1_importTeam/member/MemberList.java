package member;

import java.util.Scanner;
import team.TeamList;

public class MemberList {

	private Student student[];
	private Mentor mentor[];

	private int ID;
	private String name;
	private String team;
	private String major;

	private int a;
	private int b;

	private String org;

	private int tNum;

	public MemberList(int k) {
		student = new Student[k];
		mentor = new Mentor[k];
		ID = 1;
		a = 0;
		b = 0;

		student[a++] = new Student(ID++, "ȫ�л�", "��ħ�̴�", "����Ʈ����");
		student[a++] = new Student(ID++, "���л�", "���ɸ԰�", "���Ӱ���");
		student[a++] = new Student(ID++, "���л�", "��ħ�̴�", "��ǻ�Ͱ���");
		mentor[b++] = new Mentor(ID++, "ȫ����", "��ħ�̴�", "Happy co.");
		mentor[b++] = new Mentor(ID++, "�ڸ���", "��ٰ���", "(��)�ູ");
	}

	public void addStudent(TeamList tList) {
		Scanner scan = new Scanner(System.in);

		System.out.println("< �л� ��� �߰� >");
		System.out.println("- ID: " + ID);
		System.out.printf("- �̸� >> ");
		name = scan.nextLine();
		System.out.printf("- ���� >> ");
		major = scan.nextLine();

		tList.showAll();

		System.out.printf("- Team ID >> ");
		tNum = scan.nextInt();

		team = tList.findTeam(tNum);

		student[a++] = new Student(ID++, name, team, major);

		System.out.println("=> " + name + ": �л��� �߰��߽��ϴ�\n");
	}

	public void addMentor(TeamList tList) {
		Scanner scan = new Scanner(System.in);

		System.out.println("< ���� ��� �߰� >");
		System.out.println("- ID: " + ID);
		System.out.printf("- �̸� >> ");
		name = scan.nextLine();
		System.out.printf("- ȸ�� >> ");
		org = scan.nextLine();

		tList.showAll();

		System.out.printf("- Team ID >> ");
		tNum = scan.nextInt();

		team = tList.findTeam(tNum);

		mentor[b++] = new Mentor(ID++, name, team, org);

		System.out.println("=> " + name + ": ���並 �߰��߽��ϴ�\n");
	}

	public void showStudentAll() {

		System.out.println("< �л� ��� ��� >");
		System.out.println("----------------------------------------");
		System.out.println("ID    �̸�       Team        ����");
		System.out.println("----------------------------------------");

		for (int i = 0; i < a; i++) {
			student[i].showData();
		}

		System.out.println("----------------------------------------\n");
	}

	public void showMentorAll() {

		System.out.println("< ���� ��� ��� >");
		System.out.println("----------------------------------------");
		System.out.println("ID    �̸�       Team        ȸ��");
		System.out.println("----------------------------------------");

		for (int i = 0; i < b; i++) {
			mentor[i].showData();
		}

		System.out.println("----------------------------------------\n");
	}

	public void check() {
		Scanner scan = new Scanner(System.in);

		String cName;

		System.out.printf("- �̸�: ");
		cName = scan.nextLine();

		System.out.println("\n < ã�� ��� > ");
		System.out.println("--------------------------------------------------");
		System.out.println("����     ID    �̸�       Team        ����/ȸ��");
		System.out.println("--------------------------------------------------");

		int i = 0;
		int j = 0;

		while (true) {
			if (student[i] != null && student[i].aName().equals(cName)) {
				System.out.printf("�л�      ");
				student[i].showData();
				break;
			}

			if (mentor[j] != null && mentor[j].aName().equals(cName)) {
				System.out.printf("����      ");
				mentor[j].showData();
				break;
			}

			i++;
			j++;
		}

		System.out.println("---------------------------------------------------\n");
	}

	public void showAll() {

		System.out.println("< ��� ��� ��� >");
		System.out.println("--------------------------------------------------");
		System.out.println("����     ID    �̸�       Team        ����/ȸ��");
		System.out.println("--------------------------------------------------");

		int i = 0;
		int j = 0;
		int k = 1; // ID ���� ����

		while (true) {
			if (student[i] != null && student[i].aID() == k) {
				System.out.printf("�л�      ");
				student[i++].showData();
				k++;
			} else if (mentor[j] != null && mentor[j].aID() == k) {
				System.out.printf("����      ");
				mentor[j++].showData();
				k++;
			}

			if (k > a + b)
				break;

		}

		System.out.println("---------------------------------------------------\n");
	}

	public void checkTeam(TeamList tList) {

		Scanner scan = new Scanner(System.in);

		tList.showAll();

		System.out.printf("- Team ID >> ");
		tNum = scan.nextInt();

		team = tList.findTeam(tNum);

		System.out.println(" < " + team + ": ��� ��� > ");
		System.out.println("--------------------------------------------------");
		System.out.println("����     ID    �̸�       Team        ����/ȸ��");
		System.out.println("--------------------------------------------------");
		
		int i = 0;
		int j = 0;
		int k = 1;

		while (true) {
			if (student[i] != null && student[i].aTeam().equals(team)) {
				System.out.printf("�л�      ");
				student[i].showData();
			}

			if (mentor[j] != null && mentor[j].aTeam().equals(team)) {
				System.out.printf("����      ");
				mentor[j].showData();
			}
			
			i++;
			j++;
			k++;
			if (k > a + b)
				break;
		}

		System.out.println("---------------------------------------------------\n");
	}

}