package hw03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class encapsulates a product in an online store.
 * 
 * Draft: Add the methods in the Loadable interface. Leave the implementation
 * empty.
 * 
 * Final: Add the implementation for the Loadable interface.
 *
 */
public class Product implements Loadable {
	private int id;
	private String name;
	private String description;

	public Product() {
	}

	public Product(int newId, String newName, String newDescription) {
		id = newId;
		name = newName;
		description = newDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int newId) {
		id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

	/**
	 * Save a product to a file. Each value will be on its own line. id will be
	 * on the first line, name will be on the second line, and description will
	 * be on the third line.
	 * 
	 * You must catch and handle exceptions properly. Data in the file may be
	 * incorrectly formatted, or the file may be absent. Or other errors could
	 * occur. If an exception occurs, then print
	 * "Unable to save product to Filename.\n" where Filename is replaced with
	 * the actual value in Filename.
	 * 
	 * File Example: 12345 Mechanical Keyboard The greatest mechanical keyboard
	 * that has ever existed.
	 * 
	 * @param Filename
	 *            the location of the file that contains the information for
	 *            this Product
	 */
	// YOUR CODE HERE
	@Override
	public void saveToFile(String filename) {
		try {

			PrintWriter out = new PrintWriter(filename);
			out.println(id);
			out.println(name);
			out.println(description);
			out.close();

		} catch (Exception e) {
			System.out.println("Error while saving to " + filename + ".");
		}

	}

	/**
	 * Load a product from a file. Each value will be on its own line. id will
	 * be on the first line, name will be on the second line, and description
	 * will be on the third line.
	 * 
	 * You must catch and handle exceptions properly. Data in the file may be
	 * incorrectly formatted, or the file may be absent. Or other errors could
	 * occur. If an exception occurs, then print
	 * "Unable to load product from Filename.\n" where Filename is replaced with
	 * the actual Filename.
	 * 
	 * File Example: 12345 Mechanical Keyboard The greatest mechanical keyboard
	 * that has ever existed.
	 * 
	 * @param Filename
	 *            the location of the file that contains the information for
	 *            this Product
	 */
	// YOUR CODE HERE
	@Override
	public void loadFromFile(String filename) {

		Scanner in = null;
		try {
			in = new Scanner(new File(filename));

			int num = Integer.parseInt(in.nextLine());
			String s1 = in.nextLine();
			String s2 = in.nextLine();

			setId(num);
			setName(s1);
			setDescription(s2);

			in.close();
		}

		catch (FileNotFoundException fnf) {
			System.out.println("Unable to load product from " + filename + ".");

		}

		catch (Exception e) {
			System.out.println("Unknown Error");
		}

	}
}
