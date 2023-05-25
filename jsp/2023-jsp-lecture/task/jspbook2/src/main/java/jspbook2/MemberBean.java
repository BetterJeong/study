package jspbook2;

import java.util.ArrayList;

public class MemberBean {
	ArrayList<Member> members = new ArrayList<>();
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	public void addMember(Member m) {
		members.add(m);
	}
}
