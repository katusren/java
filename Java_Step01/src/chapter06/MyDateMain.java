package chapter06;

import java.util.Scanner;

public class MyDateMain {

	public static void main(String[] args) {

		MyDate_03 date = new MyDate_03();

		Scanner scar = new Scanner(System.in);

		int year = scar.nextInt();
		int month = scar.nextInt();
		int day = scar.nextInt();

		date.setYear(year);
		date.setMonth(month);
		date.setDay(day);

		date.Say();

	}

}
