package member;

import java.util.Scanner;

public class MemberList {

	private Member mList[];
	private int id;
	private String name;
	private String major;
	private String company;
	private int index = 0;
	
	private String fName;

	public MemberList(int n) {
		mList = new Member[n];
		id = index + 1;

		mList[index++] = new Student(id++, "홍학생", "소프트웨어");
		mList[index++] = new Student(id++, "김학생", "게임공학");
		mList[index++] = new Student(id++, "박학생", "컴퓨터공학");
		mList[index++] = new Mentor(id++, "홍멘토", "Happy Co.");
		mList[index++] = new Mentor(id++, "박멘토", "(주)행복");
	}

	public void addStudent() {

		Scanner scan = new Scanner(System.in);

		System.out.println(" - ID = " + id);
		System.out.printf(" - 이름: ");
		name = scan.nextLine();
		System.out.printf(" - 전공: ");
		major = scan.nextLine();

		mList[index++] = new Student(id++, name, major);

		System.out.println("=> " + name + ": 학생을 추가했습니다");
	}

	public void addMentor() {

		Scanner scan = new Scanner(System.in);

		System.out.println(" - ID = " + id);
		System.out.printf(" - 이름: ");
		name = scan.nextLine();
		System.out.printf(" - 소속 회사: ");
		company = scan.nextLine();

		mList[index++] = new Mentor(id++, name, company);

		System.out.println("=> " + name + ": 멘토을 추가했습니다");
	}
	
	public void findMember() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" < 5. 멤버 조회 > ");
		System.out.printf(" - 이름?: "); fName = scan.nextLine();
		System.out.println(" < 찾은 멤버 > ");
		
		System.out.println("--------------------------");
		System.out.println("구분\tID\t이름\t전공/회사");
		System.out.println("--------------------------");
		
		for(int i = 0; i<index; i++) {
			if(mList[i].mName().equals(fName)) {
				if(mList[i] instanceof Student) {
					System.out.printf("학생\t");
					mList[i].showData();
				}
				else if(mList[i] instanceof Mentor) {
					System.out.printf("멘토\t");
					mList[i].showData();
				}
			}
		}
		
		System.out.println("--------------------------\n");
	}

	public void showStudent() {
		System.out.println("--------------------------");
		System.out.println("ID\t이름\t전공");
		System.out.println("--------------------------");

		for (int i = 0; i < index; i++) {
			if (mList[i] instanceof Student) {
				mList[i].showData();
			}
		}

		System.out.println("--------------------------\n");
	}

	public void showMentor() {
		System.out.println("--------------------------");
		System.out.println("ID\t이름\t회사");
		System.out.println("--------------------------");

		for (int i = 0; i < index; i++) {
			if (mList[i] instanceof Mentor) {
				mList[i].showData();
			}
		}

		System.out.println("--------------------------\n");
	}
	
	public void showAll() {
		
		System.out.println("--------------------------");
		System.out.println("구분\tID\t이름\t전공/회사");
		System.out.println("--------------------------");

		for (int i = 0; i < index; i++) {
			if (mList[i] instanceof Student) {
				System.out.printf("학생\t");
				mList[i].showData();
			}
			else if (mList[i] instanceof Mentor) {
				System.out.printf("멘토\t");
				mList[i].showData();
			}
		}

		System.out.println("--------------------------\n");
	}

	public Member memberReturn(int k) {
		
		for(int i = 0; i<index; i++) {
			if(k == mList[i].mID()) {
				return mList[i];
			}
		}
		
		return null;
	}
	
}