package chapter06;

public class MyDate_03 {

	// 멤버변수 = 필드
	public int day;
	public int month;
	public int year;

	// 디폴트 작성자

	// 메소드

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void Say() {
		System.out.println("입력하신 날짜는 " + year + "년 " + month + "월 " + day + "일 입니다.");
	}

}
