package chapter06;

import java.util.Scanner;

public class CanMain_09 {

	public static void main(String[] args) {

		Scanner scar = new Scanner(System.in);
		int money = 0;

		// 음료 준비
		Vending vend = new Vending();
		vend.init(); // 음료준비 완료
		System.out.print("돈을 투입하세요: ");
		money = Integer.parseInt(scar.nextLine()); // 돈 투입
		vend.showCans(money);
		System.out.println("=================");

		System.out.print("음료를 선택하세요: ");
		String select = scar.nextLine();
		vend.outCan(select);
	}

}
