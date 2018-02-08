package hw03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class encapsulates an order in an online store.
 * 
 * Draft: Add the methods in the Loadable interface. Leave the implementation
 * empty.
 * 
 * Final: Add the implementation for the Loadable interface.
 *
 */
public class Order implements Loadable {
	private ArrayList<Integer> productId;
	private ArrayList<Integer> quantity;

	public Order() {
		productId = new ArrayList<Integer>();
		quantity = new ArrayList<Integer>();
	}

	public void addProduct(int id, int qty) {
		productId.add(id);
		quantity.add(qty);
	}

	public int size() {
		return productId.size();
	}

	public String toString() {
		return "Order [productId=" + productId.toString() + ", quantity="
				+ quantity.toString() + "]";
	}

	/**
	 * Save an order to a file. Each id, quantity pair be on its own line. id
	 * will come first, then a comma, then a newline. Then the next line will
	 * contain another id,quantity pair if there are more products in this
	 * order.
	 * 
	 * There may be arbitrarily many id,product pairs in an order.
	 * 
	 * You must catch and handle exceptions properly. Data in the file may be
	 * incorrectly formatted, or the file may be absent. Or other errors could
	 * occur. If an exception occurs, then print
	 * "Unable to save order to Filename.\n" where Filename is replaced with the
	 * actual value in Filename.
	 * 
	 * File Example: 12345,1 111,2 555,7 8888,23
	 * 
	 * @param Filename
	 *            the location of the file that contains the information for
	 *            this Order
	 */
	// YOUR CODE HERE
	@Override
	public void saveToFile(String filename) {

		try {
			PrintWriter out = new PrintWriter(filename);

			for (int i = 0; i < productId.size(); i++) {
				out.println(productId.get(i) + "," + quantity.get(i));
			}

			out.close();

		} catch (FileNotFoundException fnf) {
			System.out.println("Unable to save order to " + filename + "."
					+ "\n");
		}

		catch (Exception e) {
			System.out.println("Unknown Error");
		}

	}

	/**
	 * Load an order from a file. Each id, quantity pair be on its own line. id
	 * will come first, then a comma, then a newline. Then the next line will
	 * contain another id,quantity pair if there are more products in this
	 * order.
	 * 
	 * There may be arbitrarily many id,product pairs in an order.
	 * 
	 * You must catch and handle exceptions properly. Data in the file may be
	 * incorrectly formatted, or the file may be absent. Or other errors could
	 * occur. If an exception occurs, then print
	 * "Unable to load order from Filename.\n" where Filename is replaced with
	 * the actual value in Filename.
	 * 
	 * File Example: 12345,1 111,2 555,7 8888,23
	 * 
	 * @param Filename
	 *            the location of the file that contains the information for
	 *            this Order
	 */

	@Override
	public void loadFromFile(String filename) {
		Scanner in = null;
		try {

			in = new Scanner(new File(filename));
			while (in.hasNextLine()) {
				
				// read entire line then pinpoint the comma
				String line = in.nextLine();
				int comma = line.indexOf(",");

				String id = line.substring(0, comma);
				String qty = line.substring(comma + 1, line.length());
				
				addProduct(Integer.parseInt(id), Integer.parseInt(qty));
			}
			in.close();

		}

		catch (FileNotFoundException fnf) {
			System.out.println("Unable to load order from " + filename + ".");
		} catch (NumberFormatException nfe) {
			System.out.println("Unable to load order from " + filename + ".");

		}
	}
}
