package chapter06;

public class TeamMain {

	public static void main(String[] args) {

		TeamGroup group = new TeamGroup();

		group.init();
		group.Disp();

		// --------------------
		System.out.println();

		TeamMember_05 t = new TeamMember_05();

		t.setmName("신인철");
		System.out.println("팀장이름: " + t.getmName());

		t.setmPhone("010-1234-5678");
		System.out.println("팀장 전화번호: " + t.getmPhone());

		t.setsName("김관호");
		System.out.println("부팀장이름: " + t.getsName());
	}

}
