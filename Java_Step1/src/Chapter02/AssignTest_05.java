package Chapter02;

public class AssignTest_05 {

	public static void main(String[] args) {
		//전위연산
		System.out.println("===전위연산===");
		int gameScore = 150;
		
		//#1 ++gameScore => gameScore = gameScore+1; -> gameScore에 연산을 먼저함
		//#2 int lastScore1 = gameScore;
		int lastScore1 = ++gameScore;
		System.out.println(gameScore); //151
		System.out.println(lastScore1); //151
		System.out.println("---------------------");
		
		//#1 --gameScore => gameScore = gameScore-1;
		//#2 int lastScore1 = gameScore;
		int lastScore2 = --gameScore;
		System.out.println(gameScore); //150
		System.out.println(lastScore2); //150
		System.out.println("---------------------");
		
		//후위연산
		System.out.println("===후위연산===");
		//#1 int lastScore3 = gameScore -> gameScore 값을 먼저 저장시킴
		//#2 gameScore++ => gameScore + 1
		int lastScore3 = gameScore++;
		System.out.println(lastScore3); //150
		System.out.println(gameScore); //151
		System.out.println("---------------------");
		
		//#1 int lastScore4 = gameScore
		//#2 gameScore-- => gameScore - 1
		int lastScore4 = gameScore--;
		System.out.println(lastScore4); //151
		System.out.println(gameScore); //150
		
		
	}

}
