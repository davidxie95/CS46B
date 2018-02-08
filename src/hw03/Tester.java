package hw03;

public class Tester
{
	public static void main(String[] args)
	{

		Product p1 = new Product();
		p1.loadFromFile("Monitor.txt");
		System.out.println("Actual: " + p1.toString());
		System.out.println("Expected: Product [id=12345, name=Monitor, description=A freakin great monitor!]");
		
		p1.setId(11111);
		p1.setName("another product");
		p1.setDescription("Description of another product!");
		
		p1.saveToFile("SaveTest1.txt");
		p1 = null;
		p1 = new Product();
		
		p1.loadFromFile("SaveTest1.txt");
		System.out.println("Actual: " + p1.toString());
		System.out.println("Expected: Product [id=11111, name=another product, description=Description of another product!]");


		Order o1 = new Order();
		o1.loadFromFile("Order1.txt");
		System.out.println("Actual: " + o1.toString());
		System.out.println("Expected: Order [productId=[113489, 201934, 3488, 84432], quantity=[11, 22, 12, 3]]");
		
		o1 = null;
		o1 = new Order();
		o1.addProduct(1, 4);
		o1.addProduct(2, 3);
		o1.addProduct(3, 2);
		o1.addProduct(4, 1);
		
		o1.saveToFile("SaveTest2.txt");
		o1 = null;
		o1 = new Order();
		
		o1.loadFromFile("SaveTest2.txt");
		System.out.println("Actual: " + o1.toString());
		System.out.println("Expected: Order [productId=[1, 2, 3, 4], quantity=[4, 3, 2, 1]]");

		Order o2 = new Order();
		System.out.print("Actual: ");
		o2.loadFromFile("BadOrder.txt");
		System.out.println("Expected: Unable to load order from BadOrder.or.");

		
		Product p2 = new Product();
		System.out.print("Actual: ");
		p2.loadFromFile("BadProduct.txt");
		System.out.println("Expected: Unable to load product from BadProduct.pr.");

	}
}