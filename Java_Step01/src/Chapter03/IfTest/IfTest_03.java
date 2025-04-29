package Chapter03.IfTest;

import javax.swing.JOptionPane;

public class IfTest_03 {

	public static void main(String[] args) {

		char grade =0; //반드시 초기화 필요 ' ' or 0
		int jumsu;
		
		jumsu = Integer.parseInt(JOptionPane.showInputDialog("Java 평가점수"));
		/*
		//#1
		if(jumsu>=90) {
			grade = 'A';
			System.out.println("점수 : "+grade);
		}else if(jumsu>=80) {
			grade = 'B';
			System.out.println("점수 : "+grade);
		}else if(jumsu>=70) {
			grade = 'C';
			System.out.println("점수 : "+grade);
		}else if(jumsu>=60) {
			grade = 'D';
			System.out.println("점수 : "+grade);
		}else{
			grade = 'F';
			System.out.println("점수 : "+grade);
		}
		*/
		
		
		//#2
		if(jumsu>100 || jumsu<0) {
			System.out.println("없는 점수 입니다.");
		}else if(jumsu>=90) {
			grade = 'A';
			System.out.println("최우수 학생입니다.");
		}else if(jumsu>=80) {
			grade = 'B';
			System.out.println("우수 학생입니다.");
		}else if(jumsu>=70) {
			grade = 'C';
		}else if(jumsu>=60) {
			grade = 'D';
		}else{
			grade = 'F';
		}//if
		
		System.out.println("당신의 점수는 : " + grade + " 입니다.");
		
		
		
	}//main

}//class
