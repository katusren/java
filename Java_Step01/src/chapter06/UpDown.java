package chapter06;

public class UpDown {
	// UP, DOWN, SUCCESS

	private int number = (int) (Math.random() * 50) + 1;
	private int count = 0;

	public String check(int select) {

		String answer = "";

		if (number == select)
			answer = "SUCCESS";
		else if (number > select)
			answer = "UP";
		else if (number < select)
			answer = "DOWN";
		count++;

		return answer;
	}

	public void showinfo() {
		System.out.println("총 " + count + "번 만에 정답을 맞추셨습니다.");
	}

}
