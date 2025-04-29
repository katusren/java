package Chapter03.IfTest;

//import java.util.Scanner;

import javax.swing.JOptionPane;

public class IfTest_02 {

	public static void main(String[] args) {
		// 10의 배수를 판단
		// 조건 : data에 있는 값을 10으로 나는 나머지가 0이면 배수
		
		//Scanner sc = new Scanner(System.in);
		
		int data;
		//Integer.parseInt() : 문자열을 정수로 변환해주는 method
		data = Integer.parseInt(JOptionPane.showInputDialog("값을 입력하세요.")); //JOption + ctrl + spacebar
		System.out.println(data);
		
		if(data%10==0) {
			System.out.println(data+"은(는) "+"10의 배수입니다.");
		}else {
			System.out.println(data+"은(는) "+"10의 배수가 아닙니다.");
		}//if
		
		
	}//main

}//class
