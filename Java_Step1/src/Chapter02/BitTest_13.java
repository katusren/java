package Chapter02;

public class BitTest_13 {

	public static void main(String[] args) {
		
		//0B:이진법이라고 설명
		int num = 0B00000101; //5
		System.out.println(num);
		
		// 몫만 나옴
		System.out.println(num << 2); //증가 -> 5*4=20
		System.out.println(num >> 2); //감소 -> 5/4=1 
		
		System.out.println("------------------------------");
		
		int a,b,c;
		
		//질문하기 b에 3을 넣었을때 값이 이상함
		// -> 밑이 아니라 지수로 올라가는 것!
		
		a=5;
		b=2;
		c=a>>b; //5 나누기 2에 2승 5/4=1
		System.out.println(c);
		
		c=a<<b; // 5 곱하기 2에 2승 5*4=20
		System.out.println(c);
		
	}

}
