package chapter10.MultInterface;

import java.util.Scanner;

public class SchedulerMain_01 {

	public static void main(String[] args) {

		Scanner scar = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("R or r : 한명씩 차례로 할당");
			System.out.println("L or l : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
			System.out.println("P or p : 업무 skill 값이 높은 상담원에게 할당");
			System.out.println("S or s : 종료");
			System.out.print("전화 상담 방식을 선택하세요 : ");

			// toUpperCase(): 대소문자를 구분하지 않음
			// 방법1(char)
			char input = scar.next().toUpperCase().charAt(0);

			// 방법2(String)
			// String mun = scar.nextLine();
			// int ch = (int) mun.charAt(0);

			// ASCII 즉 - 문자값을 int 로 인식
			int ch = (int) input;

			Scheduler scheduler = null;

			// 객체를 생성
			if (ch == 'R' || ch == 'r')
				scheduler = new RoundRobin();
			else if (ch == 'L' || ch == 'l')
				scheduler = new LeastJob();
			else if (ch == 'P' || ch == 'p')
				scheduler = new PriorityAllocation();
			else if (ch == 'S' || ch == 's') {
				System.out.println("업무를 종료합니다.");
				break;
			} else {
				System.err.println("오류입니다.");
				continue;
			}

			scheduler.getNextCall();
			scheduler.sendCallToAgent();
		}

	}

}
