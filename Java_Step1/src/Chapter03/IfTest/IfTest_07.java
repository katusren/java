package Chapter03.IfTest;

import javax.swing.JOptionPane;

public class IfTest_07 {

	public static void main(String[] args) {
		// 데이터셋 
		String ID = "soldesk";
		int PW = 250408;
		
		//고객
		String id = JOptionPane.showInputDialog("아이디");
		
		//.equals()(String 일때) -> .앞과 () 안이 같냐고 물어봄
		if(ID.equals(id)) {
			//비밀번호
			int pass = Integer.parseInt(JOptionPane.showInputDialog("비밀번호"));
			if(PW==pass) {
				System.out.println(ID+"님 환영합니다.");
			}else {
				System.out.println(id+"과(와) 일치하는 비밀번호가 없습니다.");
			}
		}else {
			System.out.println("일치하는 아이디가 없습니다.");
		}
			 

	}

}
