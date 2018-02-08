package hw02;

/**
 * This class represents an order placed to an online marketplace such as
 * Amazon, ebay, or buy.com.
 * 
 * The key method is GetFormattedOrder. This method returns a String that
 * represents an order in the format specified by the OrderFormatter that is
 * passed in as an argument.
 * 
 * For the draft, you must implement the Comparable interface on this class.
 */
public class Order implements Comparable<Order> {
	private int orderId;
	private int productId;

	private String productName;
	private String department;

	public Order(int newOrderId, int newProductId, String newProductName,
			String newDepartment) {
		this.orderId = newOrderId;
		this.productId = newProductId;
		this.productName = newProductName;
		this.department = newDepartment;
	}

	public String GetFormattedOrder(OrderFormatter f) {
		return f.FormatOrder(orderId, productId, productName, department);
	}

	public int getOrderId() {
		return orderId;
	}

	public int getProductId() {
		return productId;
	}

	/*
	 * YOUR CODE HERE. Implement the Comparable interface on objects of type
	 * Order. Compare orderId, then productId. The lesser orderId should come
	 * first. If the orderIds match, then the lesser productId should come
	 * first.
	 */
	@Override
	public int compareTo(Order second) {
		Order first = new Order(orderId, productId, productName, department);
		if (first.getOrderId() != second.getOrderId()) {
			return first.getOrderId() - second.getOrderId();
		} else
			return first.getProductId() - second.getProductId();
	}
}





