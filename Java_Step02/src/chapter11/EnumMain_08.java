package chapter11;

import java.util.Scanner;

public class EnumMain_08 {

	public enum Item {
		Start, Pause, Exit
	}

	public static void main(String[] args) {

		Scanner scar = new Scanner(System.in);

		while (true) {
			System.out.print("숫자를 입력하세요[0:게임시작, 1:일시정지, 2:게임종료] :  ");

			int n = scar.nextInt();

			Item start = Item.Start; // start를 0정의
			Item pause = Item.Pause; // pause를 1정의
			Item exit = Item.Exit; // exit를 2정의

			if (n == start.ordinal()) {
				System.out.println("게임이 시작함");
			} else if (n == pause.ordinal()) {
				System.out.println("게임이 일시정지됨");
			} else if (n == exit.ordinal()) {
				System.out.println("게임종료");
				return;
			} else {
				System.err.println("서비스 지원이 없는 번호입니다.");
			}
		}
	}

}
