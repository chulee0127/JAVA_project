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

		student[a++] = new Student(ID++, "홍학생", "아침이다", "소프트웨어");
		student[a++] = new Student(ID++, "김학생", "점심먹고", "게임공학");
		student[a++] = new Student(ID++, "박학생", "아침이다", "컴퓨터공학");
		mentor[b++] = new Mentor(ID++, "홍멘토", "아침이다", "Happy co.");
		mentor[b++] = new Mentor(ID++, "박멘토", "놀다가자", "(주)행복");
	}

	public void addStudent(TeamList tList) {
		Scanner scan = new Scanner(System.in);

		System.out.println("< 학생 멤버 추가 >");
		System.out.println("- ID: " + ID);
		System.out.printf("- 이름 >> ");
		name = scan.nextLine();
		System.out.printf("- 전공 >> ");
		major = scan.nextLine();

		tList.showAll();

		System.out.printf("- Team ID >> ");
		tNum = scan.nextInt();

		team = tList.findTeam(tNum);

		student[a++] = new Student(ID++, name, team, major);

		System.out.println("=> " + name + ": 학생을 추가했습니다\n");
	}

	public void addMentor(TeamList tList) {
		Scanner scan = new Scanner(System.in);

		System.out.println("< 멘토 멤버 추가 >");
		System.out.println("- ID: " + ID);
		System.out.printf("- 이름 >> ");
		name = scan.nextLine();
		System.out.printf("- 회사 >> ");
		org = scan.nextLine();

		tList.showAll();

		System.out.printf("- Team ID >> ");
		tNum = scan.nextInt();

		team = tList.findTeam(tNum);

		mentor[b++] = new Mentor(ID++, name, team, org);

		System.out.println("=> " + name + ": 멘토를 추가했습니다\n");
	}

	public void showStudentAll() {

		System.out.println("< 학생 멤버 목록 >");
		System.out.println("----------------------------------------");
		System.out.println("ID    이름       Team        전공");
		System.out.println("----------------------------------------");

		for (int i = 0; i < a; i++) {
			student[i].showData();
		}

		System.out.println("----------------------------------------\n");
	}

	public void showMentorAll() {

		System.out.println("< 멘토 멤버 목록 >");
		System.out.println("----------------------------------------");
		System.out.println("ID    이름       Team        회사");
		System.out.println("----------------------------------------");

		for (int i = 0; i < b; i++) {
			mentor[i].showData();
		}

		System.out.println("----------------------------------------\n");
	}

	public void check() {
		Scanner scan = new Scanner(System.in);

		String cName;

		System.out.printf("- 이름: ");
		cName = scan.nextLine();

		System.out.println("\n < 찾은 멤버 > ");
		System.out.println("--------------------------------------------------");
		System.out.println("구분     ID    이름       Team        전공/회사");
		System.out.println("--------------------------------------------------");

		int i = 0;
		int j = 0;

		while (true) {
			if (student[i] != null && student[i].aName().equals(cName)) {
				System.out.printf("학생      ");
				student[i].showData();
				break;
			}

			if (mentor[j] != null && mentor[j].aName().equals(cName)) {
				System.out.printf("멘토      ");
				mentor[j].showData();
				break;
			}

			i++;
			j++;
		}

		System.out.println("---------------------------------------------------\n");
	}

	public void showAll() {

		System.out.println("< 모든 멤버 목록 >");
		System.out.println("--------------------------------------------------");
		System.out.println("구분     ID    이름       Team        전공/회사");
		System.out.println("--------------------------------------------------");

		int i = 0;
		int j = 0;
		int k = 1; // ID 비교할 변수

		while (true) {
			if (student[i] != null && student[i].aID() == k) {
				System.out.printf("학생      ");
				student[i++].showData();
				k++;
			} else if (mentor[j] != null && mentor[j].aID() == k) {
				System.out.printf("멘토      ");
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

		System.out.println(" < " + team + ": 멤버 목록 > ");
		System.out.println("--------------------------------------------------");
		System.out.println("구분     ID    이름       Team        전공/회사");
		System.out.println("--------------------------------------------------");
		
		int i = 0;
		int j = 0;
		int k = 1;

		while (true) {
			if (student[i] != null && student[i].aTeam().equals(team)) {
				System.out.printf("학생      ");
				student[i].showData();
			}

			if (mentor[j] != null && mentor[j].aTeam().equals(team)) {
				System.out.printf("멘토      ");
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