package hw02;

/**
 * CLASS: SanJoseWarehouseFormatter
 * 
 * This class realizes the OrderFormatter interface.
 * 
 * The single method returns a String representing
 * an Order formatted as the product name with spaces removed,
 * then the product id, then a dash, then the department, then
 * a dash, then the order id.
 * 
 * For example: WhitePaper12345-Office-8888
 */


public class SanJoseWarehouseFormatter implements OrderFormatter{

	public SanJoseWarehouseFormatter() {
		
		
	}

	@Override
	public String FormatOrder(int orderId, int productId, String productName,
			String department) {
		
		
		//used the replaceAll method from stackflows.com
		//http://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
		
		String name = productName.replaceAll("\\s" , "");
		
		String id = String.valueOf(productId);
		String name2 = department;
		String id2 = String.valueOf(orderId);
		
		return name + id + "-" + name2 + "-" + id2;
	}

}



