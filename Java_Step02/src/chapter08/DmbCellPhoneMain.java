package chapter08;

import java.util.Scanner;

public class DmbCellPhoneMain {

	public static void main(String[] args) {

		DmbCellPhone dmb = new DmbCellPhone(11, "Java폰", "검정");

		Scanner scar = new Scanner(System.in);

		int count = 0;

		// 상속받은 필드
		System.out.println("모델: " + dmb.model);
		System.out.println("색상: " + dmb.color);

		// 자식클래스 필드
		System.out.println("채널: " + dmb.channel);

		// 전화통화 구현

		boolean run = true;

		while (run) {
			System.out.println("기능을 선택해주시길 바랍니다.");
			System.out.println("1.전원On 2.전원Off 3.통화시작 4.DMB");

			int num = Integer.parseInt(scar.nextLine());

			switch (num) {
			case 1: {
				dmb.powerOn();
				break;
			}
			case 2: {
				dmb.powerOff();
				break;
			}
			case 3: {
				if (count == 0)
					;
			}
			}
		}

	}

}
