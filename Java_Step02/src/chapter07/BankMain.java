package chapter07;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class BankMain {

	public static void main(String[] args) {

		// 일산점 031-1234-5678 이자율 5.3f
		// 종로점 02-852-9856

		String point1 = JOptionPane.showInputDialog("지점명");
		String tel1 = JOptionPane.showInputDialog("전화번호");

		Bank_03 bank1 = new Bank_03(point1, tel1);
		Scanner scar = new Scanner(System.in);
		System.out.print(point1 + "지점의 퇴직 연금의 이자를 입력하세요: ");
		Bank_03.interest = scar.nextFloat();

		bank1.getBank();

		String point2 = JOptionPane.showInputDialog("지점명");
		String tel2 = JOptionPane.showInputDialog("전화번호");
		Bank_03 bank2 = new Bank_03(point2, tel2);

		bank2.getBank();

	}

}
