package hw02;

/**
 * CLASS: ChicagoWarehouseFormatter
 * 
 * This class realizes the OrderFormatter interface.
 * 
 * The single method returns a String representing
 * an Order formatted as the first letter of the department,
 * plus an underscore, then the product id, then an underscore,
 * then the order id.
 * 
 * For example: O_12345_8888
 */
public class ChicagoWarehouseFormatter implements OrderFormatter{

	public ChicagoWarehouseFormatter() {
		

	}

	@Override
	public String FormatOrder(int orderId, int productId, String productName,
			String department) {
		
		String name = department.substring(0, 1);
		String id = String.valueOf(productId);
		String id2 = String.valueOf(orderId);
		
		return name + "_" + id + "_" + id2;
	}

}
