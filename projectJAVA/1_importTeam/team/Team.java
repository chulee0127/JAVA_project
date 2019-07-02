package team;

import show.Showable;

public class Team implements Showable {
	
	private int ID;
	private String name;
	
	public Team(int _ID, String _name) {
		ID = _ID;
		name = _name;
	}
	
	public void showData() {
		System.out.println(ID + "        " + name);
	}
	
	public String tName() {
		return name;
	}
	
	public int tID() {
		return ID;
	}
	
}