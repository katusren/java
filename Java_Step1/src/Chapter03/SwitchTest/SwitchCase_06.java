package Chapter03.SwitchTest;

public class SwitchCase_06 {

	public static void main(String[] args) {

		int time = (int) (Math.random() * 10) + 9;
		System.out.println("[현재시간 ] : " + time + "시");
		System.out.print("할 일 : ");

		switch (time) {
		case 9:
			System.out.println("씻는 중~~");
			break;
		case 10:
			System.out.println("나갈 준비 하기");
			break;
		case 11:
			System.out.println("지하철 맛집 검색하기");
			break;
		case 12:
			System.out.println("연남동 도착~~~");
			break;
		case 13:
			System.out.println("점심 먹기");
			break;
		case 14:
			System.out.println("팝업스토어 구경하러 가기");
			break;
		case 15:
			System.out.println("예쁜 카페에서 카공하기");
			break;
		case 16:
			System.out.println("아직 카공중~~");
			break;
		case 17:
			System.out.println("영화 or PC방 or 베이커리카페");
			break;
		case 18:
			System.out.println("저녁 먹기!");
			break;
		default:
			System.out.println(time + "시는 아직 일어나지 않은 시간입니다.");
		}

	}// main

}// class
