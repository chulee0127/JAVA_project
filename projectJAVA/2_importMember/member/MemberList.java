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

		mList[index++] = new Student(id++, "ȫ�л�", "����Ʈ����");
		mList[index++] = new Student(id++, "���л�", "���Ӱ���");
		mList[index++] = new Student(id++, "���л�", "��ǻ�Ͱ���");
		mList[index++] = new Mentor(id++, "ȫ����", "Happy Co.");
		mList[index++] = new Mentor(id++, "�ڸ���", "(��)�ູ");
	}

	public void addStudent() {

		Scanner scan = new Scanner(System.in);

		System.out.println(" - ID = " + id);
		System.out.printf(" - �̸�: ");
		name = scan.nextLine();
		System.out.printf(" - ����: ");
		major = scan.nextLine();

		mList[index++] = new Student(id++, name, major);

		System.out.println("=> " + name + ": �л��� �߰��߽��ϴ�");
	}

	public void addMentor() {

		Scanner scan = new Scanner(System.in);

		System.out.println(" - ID = " + id);
		System.out.printf(" - �̸�: ");
		name = scan.nextLine();
		System.out.printf(" - �Ҽ� ȸ��: ");
		company = scan.nextLine();

		mList[index++] = new Mentor(id++, name, company);

		System.out.println("=> " + name + ": ������ �߰��߽��ϴ�");
	}
	
	public void findMember() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" < 5. ��� ��ȸ > ");
		System.out.printf(" - �̸�?: "); fName = scan.nextLine();
		System.out.println(" < ã�� ��� > ");
		
		System.out.println("--------------------------");
		System.out.println("����\tID\t�̸�\t����/ȸ��");
		System.out.println("--------------------------");
		
		for(int i = 0; i<index; i++) {
			if(mList[i].mName().equals(fName)) {
				if(mList[i] instanceof Student) {
					System.out.printf("�л�\t");
					mList[i].showData();
				}
				else if(mList[i] instanceof Mentor) {
					System.out.printf("����\t");
					mList[i].showData();
				}
			}
		}
		
		System.out.println("--------------------------\n");
	}

	public void showStudent() {
		System.out.println("--------------------------");
		System.out.println("ID\t�̸�\t����");
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
		System.out.println("ID\t�̸�\tȸ��");
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
		System.out.println("����\tID\t�̸�\t����/ȸ��");
		System.out.println("--------------------------");

		for (int i = 0; i < index; i++) {
			if (mList[i] instanceof Student) {
				System.out.printf("�л�\t");
				mList[i].showData();
			}
			else if (mList[i] instanceof Mentor) {
				System.out.printf("����\t");
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