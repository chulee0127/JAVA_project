package team;

import java.util.Scanner;

public class TeamList {
	
	Scanner scan = new Scanner(System.in);

	private Team team[];
	private int ID;
	private String name;
	private int index;
	private int num;
	
	private String teamName;
	
	public TeamList(int a) {
		team = new Team[a];
		index = 0;
		ID = 1;
		
		team[index++] = new Team(ID++, "��ħ�̴�");
		team[index++] = new Team(ID++, "���ɸ԰�");
		team[index++] = new Team(ID++, "��ٰ���");
		team[index++] = new Team(ID++, "�޲۴�");
	}
	
	public void addTeam() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" < Team �߰� > ");
		System.out.println("- ID: " + ID);
		System.out.printf("- �� �̸�: "); name = scan.nextLine();
		
		team[index++] = new Team(ID++, name);
		
		System.out.println(name + ": Team�� �߰��Ͽ����ϴ�.");
	}
	
	public void showAll() {
		System.out.println(" < ��� Team ��� > ");
		System.out.println("----------------------------------------");
		System.out.println("ID         Team�̸�");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i<index; i++) {
			team[i].showData();
		}
		
		System.out.println("----------------------------------------");
	}
	
	public String findTeam(int tNum) {
		
		for(int i = 0; i<index; i++) {
			if(tNum-1 == i) {				
				teamName = team[i].tName();
			}
		}
		return teamName;
		
	}
	
}