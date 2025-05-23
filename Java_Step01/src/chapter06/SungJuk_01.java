package chapter06;

import javax.swing.JOptionPane;

public class SungJuk_01 {

	// 멤버 변수 = 필드 = 속성
	private String std_num;
	private String std_name;
	private int java, oracle, spring;

	public void Sum() {

		int sum = java + oracle + spring;

		System.out.println("성적의 합계는: " + sum + "입니다.");
	}

	public void Avg() {

		double avg = (java + oracle + spring) / (double) 3;

		System.out.println("성적의 평균은: " + avg + "입니다.");
	}

	public static void main(String[] args) {

		SungJuk_01 rec = new SungJuk_01();

		rec.std_num = JOptionPane.showInputDialog("학번");
		rec.std_name = JOptionPane.showInputDialog("이름");

		rec.java = Integer.parseInt(JOptionPane.showInputDialog("자바점수"));
		rec.oracle = Integer.parseInt(JOptionPane.showInputDialog("오라클점수"));
		rec.spring = Integer.parseInt(JOptionPane.showInputDialog("스프링점수"));

		System.out.println("학번 - " + rec.std_num + "| 성명 - " + rec.std_name + "님의 성적입니다.");
		rec.Sum();
		rec.Avg();

	}

}
