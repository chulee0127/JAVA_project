package team;

import show.Showable;

public class Team implements Showable {
	
	private int id;
	private String title;
	
	public Team(int _id, String _title) {
		id = _id;
		title = _title;
		
	}
	
	public void showData() {
		System.out.println(id + "\t" + title);
	}
	
	public String tName() {
		return title;
	}
	
}