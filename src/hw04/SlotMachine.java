package hw04;

import java.util.ArrayList;

public class SlotMachine {
	private String[] symbols;
	private int wheels;
	public ArrayList<String> outcomes;

	/**
	 * SlotMachine constructor. Set wheels and symbols, then call
	 * calculateAllOutcomes.
	 * 
	 * @param newWheels
	 *            the number of wheels displayed
	 * @param newSymbols
	 *            the symbols that appear on each wheel
	 */
	// String... is java VarArg
	public SlotMachine(int newWheels, String... newSymbols) {

		wheels = newWheels;
		outcomes = new ArrayList<String>();
		symbols = new String[newSymbols.length];
		symbols = newSymbols;
		calculateAllOutcomes();

	}

	/**
	 * printOutcomes. A convenience method for testing. Print everything in the
	 * outcomes ArrayList to console.
	 */
	public void printOutcomes() {

		for (int i = 0; i < outcomes.size(); i++) {
			System.out.println(i + 1 + ": " + outcomes.get(i));
		}
	}

	/**
	 * getNumberOfOutcomes. Calculate the total number of possible outcomes
	 * given the number of symbols, number of wheels, and that symbols may be
	 * repeated.
	 * 
	 * @return an integer representing the total number of possible outcomes
	 */
	public int getNumberOfOutcomes() {

		int total = (int) Math.pow(symbols.length, wheels);
		return total;
	}

	/**
	 * calculateAllOutcomes. Calculate all possible space-separated outcomes on
	 * this slot machine and store them in the outcomes ArrayList. Symbols can
	 * be repeated.
	 * 
	 * If the symbols are "lemon", "apple", and "cherry", then possible outcomes
	 * include "lemon apple cherry", "lemon lemon lemon", "apple cherry lemon"
	 * and many more.
	 * 
	 * You MUST use recursion to complete this method for full credit.
	 * 
	 * You MUST use a recursive helper method to complete this method for full
	 * credit.
	 * 
	 */
	public void calculateAllOutcomes() {
		for (int i = 0; i < symbols.length; i++) {
			calculateAllOutcomesHelper(0, symbols[i]);
		}
	}

	public void calculateAllOutcomesHelper(int wheel, String str) {
		if (wheel == wheels - 1) {
			outcomes.add(str);

		} else {
			for (int i = 0; i < symbols.length; i++) {
				calculateAllOutcomesHelper(wheel + 1, str + " " + symbols[i]);
			}
		}
	}

	/**
	 * calculateOutcomesWithoutRepeats. Calculate all possible space-separated
	 * outcomes that DO NOT INCLUDE REPEATED SYMBOLS and store them in the
	 * outcomes ArrayList. Symbols can be repeated.
	 * 
	 * If the symbols are "lemon", "apple", and "cherry", then possible outcomes
	 * include "lemon apple cherry", "apple cherry lemon", "cherry apple lemon"
	 * and more.
	 * 
	 * You MUST use recursion to complete this method for full credit.
	 * 
	 * You MUST use a recursive helper method to complete this method for full
	 * credit.
	 * 
	 */
	public void calculateOutcomesWithoutRepeats() {
		outcomes.clear();
		for (int i = 0; i < symbols.length; i++) {
			calculateOutcomesWithoutRepeatsHelper(0, symbols[i]);
		}
	}

	public void calculateOutcomesWithoutRepeatsHelper(int wheel, String str) {
		if (wheel == wheels - 1) {
			outcomes.add(str);

		} else {
			for (int i = 0; i < symbols.length; i++) {
				if (!str.contains(symbols[i]))
					calculateOutcomesWithoutRepeatsHelper(wheel + 1, str + " "
							+ symbols[i]);
			}
		}
	}
}
