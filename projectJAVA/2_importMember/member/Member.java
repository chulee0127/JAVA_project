package member;

import show.Showable;

public abstract class Member implements Showable {

	protected int id;
	protected String name;
	protected String major;
	
	public Member(int _id, String _name) {
		id = _id;
		name = _name;
	}
	
	public void showData() {}
	
	public String mName() {
		return name;
	}
	
	public int mID() {
		return id;
	}
	
}

class Student extends Member{
	
	private String major;
	
	public Student(int _id, String _name, String _major) {
		super(_id, _name);
		major = _major;
		
	}
	
	public void showData() {
		System.out.println(id + "\t" + name + "\t" +major);
	}
}

class Mentor extends Member{
	
	private String company;
	
	public Mentor(int _id, String _name, String _company) {
		super(_id, _name);
		company = _company;
		
	}
	
	public void showData() {
		System.out.println(id + "\t" + name + "\t" + company);
	}
}