package Chapter03.IfTest;

import javax.swing.JOptionPane;

public class IfTest_04 {

	public static void main(String[] args) {
		/*전시관의 입장료는 미취학 아동은 1000원 ->7
		전시관의 입장료는 초등학생은 2000원->13
		전시관의 입장료는 중,고등학생은 3500원 ->19
		전시관의 입장료는 성인은 5000원*/
		
		//a = 나이
		int a = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요"));
		int charge; // 입장료
		
		if(a<=7) {
			charge = 1000;
			System.out.println("미취학 아동입니다.");
		}else if(a<=13) {
			charge = 2000;
			System.out.println("초등학생 입니다.");
		}else if(a<=19) {
			charge = 3500;
			System.out.println("중,고등학생 입니다.");
		}else {
			charge = 5000;
			System.out.println("성인 입니다.");
		}
		System.out.println("입장료는 "+charge+" 입니다.");
		
		
	}

}
