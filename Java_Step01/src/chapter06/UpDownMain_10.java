package chapter06;

import java.util.Scanner;

public class UpDownMain_10 {

	public static void main(String[] args) {

		int select;
		String check;

		// 객체생성
		UpDown updown = new UpDown();

		Scanner scar = new Scanner(System.in);

		while (true) {
			System.out.print("숫자를 입력하세요(1~50): ");
			select = Integer.parseInt(scar.nextLine());
			check = updown.check(select);

			if (check.equals("SUCCESS")) {
				System.out.println(check);
				break;
			} else
				System.out.println(check);
		}

		updown.showinfo();

	}

}
