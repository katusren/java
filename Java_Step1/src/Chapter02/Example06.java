package Chapter02;

import java.util.*;

public class Example06 {

	public static void main(String[] args) {
		/*Scanner 을 사용하여 
		두 개의 불리언(boolean) 변수 isSunny와 isWarm을 입력받아, 
		날씨가 화창하면서 따뜻한지 여부를 출력하는 프로그램을 작성하세요.
		(날씨가 화창하면서 따뜻한지에 대한 변수 isNiceWeather 으로 작성하세요.)*/
		
		System.out.println("날씨가 따뜻하면서 화창한지 판별을 시작합니다.");
		System.out.println("True나 False로만 대답해주세요.");
		
		boolean isSunny, isWarm; //참 거짓(1, 0)을 판별
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("오늘 화창한가요 ? : ");
		isSunny = sc.nextBoolean(); //T or F
		//System.out.println(isSunny);
		System.out.print("오늘 따뜻한가요 ? : ");
		isWarm = sc.nextBoolean(); // T or F
		//System.out.println(isWarm);
		
		String isNiceWeather;
		
		isNiceWeather = isSunny && isWarm ? "날씨가 화창하면서 따뜻합니다." : "그 외의 날씨입니다.";
		System.out.println(isNiceWeather);
		
		/*
		 * System.out.print("날씨가 화창한가요? (true/false) : ");
		 * boolean isSunny=sc.nextBoolean(); 
		 * 
		 * System.out.print("날씨가 따뜻한가요? (true/false) : ");
		 * boolean isWarm=sc.nextBoolean(); 
		 * 
		 * 판단(논리연산)
		 * boolean isNiceWeather = isSunny && isWarm;
		 * System.out.print("날씨가 화창하면서 따뜻한가요 ? " + isNiceWeather);
		 * 
		 */
		
		
	}

}
