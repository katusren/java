package chapter10.MultInterface;

public class InterMenuMain_03 implements Inter_Menu3 {

	public static void main(String[] args) {

		InterMenuMain_03 im = new InterMenuMain_03();

		// 부모(Inter_Menu) = 자식(InterMenuMain_03)
		Inter_Menu1 im1 = im;
		Inter_Menu2 im2 = im;
		Inter_Menu3 im3 = im;
		System.out.println("=====Inter_Menu1=====");
		System.out.println();

		System.out.println(im1.jajang());
		System.out.println(im1.jjambbong());
		im1.show();
	}

	@Override
	public String jajang() {
		return "꾸엥";
	}

	@Override
	public String jjambbong() {
		return "히유";
	}

	@Override
	public String tangsuyuck() {
		return "사천";
	}

	@Override
	public String boggembab() {
		return "꼬들";
	}

}
