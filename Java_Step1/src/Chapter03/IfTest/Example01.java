package Chapter03.IfTest;

import javax.swing.JOptionPane;

public class Example01 {
	
	public static void main(String[] args) {
		// wizard 라는 이름과 일치하면 문이 열리고
		// 문이 열린 후 퀴즈의 답은 fire다. 퀴즈까지 맞히면 "정답입니다 동굴의 문이 열립니다."
		// 이름이 일치하지 않으면 "이름이 틀렸습니다. 접근이 거부됩니다."
		// 이름은 일치, 퀴즈의 답이 틀리면 "틀렸습니다. 도망치세요."
		
		System.out.println("====비밀동굴====");
		System.out.println("위대한 마법사여. 어서오세요!");
		
		String name, Q; //이름, 퀴즈
		
		name = JOptionPane.showInputDialog("이름을 입력하세요");
		
		if(name.equalsIgnoreCase("wizard")) {//이름일치 if string은 == 대신 .equals()를 사용하기
			Q = JOptionPane.showInputDialog("가장 두려워 하는 것을 입력하세요");
			if(Q.equalsIgnoreCase("fire")) {//퀴즈일치 if
				System.out.println("정답입니다. 동굴의 문이 열립니다.");
			}else {//퀴즈불일치
				System.out.println("틀렸습니다. 도망치세요.");
			}
		}else {//이름불일치
			System.out.println("이름이 틀렸습니다. 접근이 거부됩니다.");
		}
		
		/*
		 * String correctName, correctQ;
		 * Scanner sc = new Scaneer(System.in);
		 * 
		 * System.out.println("====비밀동굴====");
		 * System.out.println("당신의 이름을 입력하세요 : ");
		 * nextLine() : 한줄 전체 문자열 입력(공백포함)
		 * next() : 문자 단어 하나(공백포함X)
		 * String name = scan.nextLine(); 
		 * 
		 * 대소문자 상관없이 같으면 통과 : equalsIgnoreCase()
		 * if(correctName.equals(name)){
		 * 	System.out.println("\n[문지기] 오, 위대한 마법사여. 마지막 관문은 퀴즈로 정해졌소.");
		 * 	System.out.println("문제 : 불, 물, 바람 중에서 드래곤이 가장 두려워하는 것은?");
		 * 	System.out.println("정답을 입력하세요 : ");
		 * 	String answer = scan.nextLine();
		 *  if(correctQ.equalsIgnoreCase(answer)){
		 *  	System.out.println("정답입니다. 동굴의 문이 열립니다.. 들어가세요");
		 *  	}else{
		 *  		System.out.println("틀렸습니다. 드래곤이 나타납니다. 도망가세요");
		 *  	}
		 * }else{
		 * 	System.out.println("이름이 틀렸습니다. 접근할 수 없습니다.");
		 * }
		 *
		 */
		
	}
	
}
