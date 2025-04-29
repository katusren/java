package Chapter02;

public class Example02 {

	public static void main(String[] args) {
		/*soldesk 과수원
		 * 배, 사과, 오렌지를 키우고 있는데 하루에 생산되는 양은 각각 5개, 7개, 5개 입니다.
		 * 과수원에서 하루에 생산되는 총 과일의 갯수를 출력하고,
		 * 시간당(24) 전체 과일의 평균 생산 갯수를 출력 하시오.
		 * (단, 평균값을 담는 데이터 타입은 float)로 정의한다.
		 */
		
		int a = 5; //배
		int b = 7; //사과
		int c = 5; //오렌지
		
		int total = a+b+c;
		float aver = (a+b+c)/24f;
		
		System.out.println("하루에 생산되는 과일의 갯수는 총 "+ total+"개 이고, 과일의 평균 생산 갯수는 "+aver+"개 입니다.");
		
	}

}
