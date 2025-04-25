package Chapter04;

import java.util.Scanner;

public class Example04 {

	public static void main(String[] args) {
		// 학생수를 입력받아, 점수를 입력하고 점수리스트를 출력하고
		// 총점과 평균을 분석하는 프로젝트

		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int studentNum = 0; // 초기화
		int[] score = null; // 비어져있는 점수 배열 선언 score = new int [studentNum]

		while (run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");

			// 1~5 중 숫자 선택
			int selectNo = Integer.parseInt(sc.nextLine());

			if (selectNo == 1) {
				// 학생 수 입력(배열의 첨자)
				System.out.print("학생 수를 입력하세요: ");
				studentNum = Integer.parseInt(sc.nextLine());
				score = new int[studentNum]; // 학생 수 크기의 배열 생성

			} else if (selectNo == 2) {
				// 점수 입력
				if (score == null) {// 학생수가 입력되지 않았다면
					System.out.println("먼저 학생 수를 입력해주세요.");
				} else {
					System.out.println("학생들의 점수를 입력하세요 : ");
					for (int i = 0; i < studentNum; i++) {// 학생 수 만큼 입력
						System.out.print((i + 1) + "번 학생 점수: ");
						score[i] = Integer.parseInt(sc.nextLine()); // 배열의 요소 채우기
					}
				}

			} else if (selectNo == 3) {
				if (score == null) {
					System.out.println("먼저 학생 수와 점수를 입력해주세요.");
				} else {
					System.out.println("학생들의 점수 리스트 : ");
					for (int i = 0; i < studentNum; i++) {
						System.out.println((i + 1) + "번 학생 점수: " + score[i]);
					}
				}

			} else if (selectNo == 4) {
				// 4. 총점과 평균 분석
				if (score == null) {// 배열이 비어져있음
					System.out.println("먼저 학생 수와 점수를 입력해주세요.");
				} else {// 학생 수와 점수가 모두 입력되어 있다면
					int sum = 0; // 합계
					double avg = 0.0; // 평균
					int max = 0;// 최고점수
					for (int lang : score) {// score 배열의 길이
						sum += lang;
					}

					for (int i = 0; i < score.length; i++) {
						max = max < score[i] ? score[i] : max;
					}
					avg = (double) sum / studentNum;

					System.out.println("최고 점수 : " + max);
					System.out.println("총점: " + sum);
					System.out.println("평균: " + avg);
				}

			} else if (selectNo == 5) {
				// 5. 종료
				run = false;
				System.out.println("프로그램을 종료!");
			} else {
				System.out.println("잘못된 접근입니다.");
			}
		} // while

		sc.close(); // Scanner 자원 해제
	} // main

} // class
