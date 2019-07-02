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
		
		team[index++] = new Team(ID++, "아침이다");
		team[index++] = new Team(ID++, "점심먹고");
		team[index++] = new Team(ID++, "놀다가자");
		team[index++] = new Team(ID++, "꿈꾼다");
	}
	
	public void addTeam() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" < Team 추가 > ");
		System.out.println("- ID: " + ID);
		System.out.printf("- 팀 이름: "); name = scan.nextLine();
		
		team[index++] = new Team(ID++, name);
		
		System.out.println(name + ": Team을 추가하였습니다.");
	}
	
	public void showAll() {
		System.out.println(" < 모든 Team 목록 > ");
		System.out.println("----------------------------------------");
		System.out.println("ID         Team이름");
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