package chapter08;

public class EmployeeMain {

	public static void main(String[] args) {

		Employee emp = new Employee("김직원", 4000);
		emp.work();
		emp.getInfo();

		Manager mgr = new Manager("박관리", 5000, "영업");
		mgr.work();
		mgr.getInfo();
		mgr.approveLeave("김직원");

		// 다형성
		Employee emp2 = new Manager("최팀장", 5500, "개발");
		emp2.work();
		emp2.getInfo();
		// emp.approveLeave("김직원"); // 컴파일 에러(객체가 Employee 타입이여서 Manager 고유 메서드라 불가능)
	}

}
