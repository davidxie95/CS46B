package hw02;

/**
 * CLASS: AtlantaWarehouseFormatter
 * 
 * This class realizes the OrderFormatter interface.
 * 
 * The single method returns a String representing an Order formatted as
 * the order id, then a dash, then the product id, then a dash, then the
 * first three letters for the product name.
 * 
 * For example: 123-456-Mot
 */
public class AtlantaWarehouseFormatter implements OrderFormatter{

	public AtlantaWarehouseFormatter() {
		
		
	}

	@Override
	public String FormatOrder(int orderId, int productId, String productName,
			String department) {

		
		String id = String.valueOf(orderId);
		String id2 = String.valueOf(productId);
		String name = productName.substring(0, 3);
	
		return id + "-" + id2 + "-" + name;
	}
}