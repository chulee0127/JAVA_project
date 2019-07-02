package member;

import show.Showable;

public abstract class Member implements Showable {
	
	protected int ID;
	protected String name;
	protected String team;
	
	public Member(int _ID, String _name, String _team) {
		ID = _ID;
		name = _name;
		team = _team;
	}
	
	public void showData() {
		//System.out.println(ID + "     " + name + "      " + team + "       " + major);
	}
	
}

class Student extends Member{

	protected String major;
	
	public Student(int _ID, String _name, String _team, String _major) {
		super(_ID, _name, _team);
		major = _major;
	}
	
	public void showData() {
		System.out.println(ID + "     " + name + "      " + team + "       " + major);
	}
	
	public int aID() {
		return ID;
	}
	
	public String aName() {
		return name;
	}
	
	public String aTeam() {
		return team;
	}
}

class Mentor extends Member{
	
	private String org;
	
	public Mentor(int _ID, String _name, String _team, String _org) {
		super(_ID, _name, _team);
		org = _org;
	}
	
	public void showData() {
		System.out.println(ID + "     " + name + "      " + team + "       " + org);
	}
	
	public int aID() {
		return ID;
	}
	
	public String aName() {
		return name;
	}
	
	public String aTeam() {
		return team;
	}
}