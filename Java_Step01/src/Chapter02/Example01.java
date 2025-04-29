package Chapter02;

public class Example01 {

	public static void main(String[] args) {
		// 534개의 책(books)을 학생(students) 30명에게 똑같은 갯수로 나눠줄 때,
		// 학생당 몇개씩 가지고, 최종적으로 몇개 남는지 구해보기
		
		int books = 534;
		int students = 30;
		
		int a = books / students;
		int b = books % students;
		
		System.out.println("학생당 책 "+a+"권씩 가지고, "+b+"개가 남는다.");

	}

}
