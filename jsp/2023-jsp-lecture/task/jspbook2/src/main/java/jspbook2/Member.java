package jspbook2;

public class Member {
	private String id; // 회원 정보 멤버 변수
	private String password;
	
	public Member(String id,String password) {
		this.id = id;
		this.password = password;
	}
	
	public Member() { // 기본 생성자인 경우 다음과 같이 신규 정보로 초기화
		id="홍길동";
		password="1234";
	}
	
	public String getId() { return id; }
	
	public String getPassword() { return password; }	
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPassword(String email) {
		this.password = email;
	}

}
