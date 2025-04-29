package chapter05;

public class FuncTest_04 {

	// 반환값이 있음 ~ return
	public int channelUp(int volume) {
		System.out.println("현재 소리는 " + volume + " 입니다.");
		System.out.println("소리를 높이겠습니다.");

		// String str="Up";

		return volume + 2; // 소리 2 높임
		// return str;
	}

	// 반환 값이 없음
	public void channelDown(int volume) {
		System.out.println("현재 소리를 " + volume + " 만큼 내립니다.");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FuncTest_04 tv = new FuncTest_04();

		int volume = 5;
		// 반환값이 있음 volume+2
		int v = tv.channelUp(volume);
		System.out.println("소리를 " + v + " 만큼 올립니다.");
		System.out.println("======================");
		System.out.println("소리를 " + tv.channelUp(v) + " 만큼 올립니다.");
		System.out.println("======================");

		// 반환값이 없음
		tv.channelDown(volume);
	}

}
