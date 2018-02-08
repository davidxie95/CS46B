package CS46B_Final;

import java.util.Arrays;

//FORBIDDEN java.util

/**
 * ShippingQueue. This class is a priority queue. You can think of a priority
 * queue as an ArrayList that is always sorted with the highest priority
 * elements at the front. Then whenever an element is removed, it is removed
 * from the front, and must have the highest remaining priority.
 * 
 * Implement the add, remove, resize, and sort methods. You MUST implement merge
 * sort in order to get full credit. This will require a recursive helper
 * method.
 * 
 * You may not add any additional instance variables to this class. You may not
 * use sorting methods from the jcf. You may not use data structures from the
 * jcf other than the given array.
 * 
 * You may use System.arraycopy.
 * 
 * Code Check will reject any submission that uses anything from the java dot
 * util package.
 */
public class ShippingQueue {
	private Package[] packages;
	private int count;
	private final static int INITIAL_SIZE = 100;

	/**
	 * Constructor. Initialize the thePackage array. Set count to 0.
	 */
	public ShippingQueue() {
		packages = new Package[INITIAL_SIZE];
		count = 0;
	}

	public Package get(int i) {
		if (i < 0 || i >= count)
			throw new ArrayIndexOutOfBoundsException();

		return packages[i];
	}

	public int size() {
		return count;
	}

	/**
	 * add. Add a Package to the array. If the array isn't large enough to hold
	 * another package, then resize the array. Also make sure to sort the array.
	 * This is a priority queue, so the thePackage with the highest priority
	 * number should come first.
	 * 
	 * @param p
	 *            the package to add
	 */
	public void add(Package p) {
		Package temp;
		if (count == 0) {
			packages[count] = p;
			count++;
		} else if (count > 0) {
			if (p.getPriority() > packages[count - 1].getPriority()) {
				temp = packages[count - 1];
				packages[count - 1] = p;
				packages[count] = temp;
				count++;
			}
			if (p.getPriority() <= packages[count - 1].getPriority()) {

				packages[count] = p;
				count++;
			}

		}

	}

	/**
	 * remove. Remove the Package at position zero and return it. This should be
	 * the package with the highest remaining priority.
	 * 
	 * @return the Package at position 0
	 */
	public Package remove() {

		Package temp = packages[0];

		if (count > 1) {
			for (int i = 0; i < size() - 1; i++) {
				packages[i] = packages[i + 1];
			}
			count--;

		} else {
			packages[0] = null;
			count--;
		}
		return temp;
	}
}
