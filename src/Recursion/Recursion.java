package Recursion;

import java.util.ArrayList;

public class Recursion {
	/**
	 * factorialIterative.
	 * 
	 * Calculate the factorial of a number using iteration. Write this method
	 * first, to get an idea of how the following methods should work.
	 * 
	 * Recall: Factorial(5) = 5 * 4 * 3 * 2 * 1;
	 * 
	 * @param n
	 *            the argument for which to calculate the factorial
	 * @return the result of the calculation
	 */
	public static int factorialIterative(int n) {

		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial = factorial * i;
		}

		return factorial;
	}

	/**
	 * factorialRecursive.
	 * 
	 * Calculate the factorial of a number using recursion.
	 * 
	 * Recall: Factorial(4) = 4 * 3 * 2 * 1;
	 * 
	 * You will get zero points for this method if you do not use recursion.
	 * 
	 * @param n
	 *            the argument for which to calculate the factorial
	 * @return the result of the calculation
	 */
	public static int factorialRecursive(int n) {

		if (n == 1) {
			return 1;
		}

		return factorialRecursive(n * (n - 1));

	}

	/**
	 * powerRecursive.
	 * 
	 * Raise base to the power of exponent.
	 * 
	 * Recall: power(5, 3) = 5 * 5 * 5 Recall: power(4, 2) = 4 * 4
	 * 
	 * Don't forget to write the base case.
	 * 
	 * If you do not use recursion, you will get zero points for this method.
	 * 
	 * @param base
	 *            the base to multiply
	 * @param exponent
	 *            the number of times to multiply it by itself
	 * @return the result of the calculation
	 */
	public static int powerRecursive(int base, int exponent) {
		if (exponent == 0)
			return 1;

		if (exponent % 2 == 0)
			return base * base;

		return base * powerRecursive(base, exponent - 1);

	}

	/**
	 * reverseStringRecursive.
	 * 
	 * Use recursion to reverse a String.
	 * 
	 * reverseStringRecursive("qwerty") = "ytrewq"
	 * 
	 * Don't forget the base case.
	 * 
	 * If you do not use recursion to solve this problem, you will get zero
	 * points.
	 * 
	 * @param input
	 *            the String to reverse
	 * @return the reversed String
	 */
	public static String reverseStringRecursive(String input) {

		if (null == input) {
			return input;
		}
		if (input.length() <= 1) {
			return input;
		}

		return reverseStringRecursive(input.substring(1)) + input.charAt(0);
	}

	/**
	 * getAllFactorsRecursive.
	 * 
	 * Calculate all POSITIVE INTEGER factors for a given number. Factors are
	 * numbers that evenly divide another number.
	 * 
	 * So the factors of 6 are 1, 2, 3, and 6. The factors of 14 are 1, 2, 7,
	 * and 14.
	 * 
	 * You must use recursion to get any points.
	 * 
	 * Don't forget to write the base case.
	 * 
	 * HINT: Create a temporary ArrayList to store the results of your recursive
	 * call. Then add the contents of that ArrayList to the ArrayList you will
	 * return.
	 * 
	 * @param base
	 *            the number for which you want to calculate all factors
	 * @param currentFactor
	 *            the current factor to test
	 * @return an ArrayList containing all positive factors of base
	 */
	public static ArrayList<Integer> getAllFactorsRecursive(int base,
			int currentFactor) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (currentFactor == 1) {
			list.add(1);
			return list;
		}
		if (base % currentFactor == 0) {
			list.add(currentFactor);
		}

		ArrayList<Integer> temp = getAllFactorsRecursive(base,
				currentFactor - 1);
		for (Integer i : list)
			temp.add(i);
		return temp;

	}
}

// the base case
// the work
// recursive call
