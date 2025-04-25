package chapter06;

public class TakeTrans {

	public static void main(String[] args) {

		StdInfo studentJames = new StdInfo("제임스", 20000);
		StdInfo studentTom = new StdInfo("톰", 23000);

		// 버스타기(100)
		Bus bus100 = new Bus(100);
		studentJames.takeBus(bus100);
		// stduentJames info
		studentJames.showinfo();
		System.out.println("-----------------------");

		Bus bus999 = new Bus(999);
		studentTom.takeBus(bus999);
		studentTom.showinfo();
		bus999.showinfo();
		studentJames.takeBus(bus999);
		bus999.showinfo();

		System.out.println("------------------------");
		Subway subwayGreen = new Subway(2);
		studentTom.takeSubway(subwayGreen);
		// 정보 확인
		studentTom.showinfo();
		subwayGreen.showinfo();

		studentJames.takeSubway(subwayGreen);
		studentJames.showinfo();
		subwayGreen.showinfo();
		System.out.println("------------------------");

		Subway subwayOrange = new Subway(3);

		studentTom.takeSubway(subwayOrange);
		studentTom.showinfo();
		subwayGreen.showinfo();
		subwayOrange.showinfo();

	}

}
