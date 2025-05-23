package chapter10.MultInterface;

public class CustomerMain_02 {

	public static void main(String[] args) {

		Customer customer = new Customer();

		System.out.println("======Buy======");
		Buy buyer = customer;
		buyer.buy();
		buyer.order();

		System.out.println("======Sell======");
		Sell seller = customer;
		seller.sell();
		seller.sellorder();
		seller.order();

		// seller 부모 | customer 자식
		if (seller instanceof Customer) {
			System.out.println("======Down Chasting======");
			Customer customer2 = (Customer) seller;
			customer2.buy();
			customer2.sell();
			customer2.sellorder();
		}

	}

}
