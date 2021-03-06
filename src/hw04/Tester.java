package hw04;

public class Tester {
	public static void main(String[] args) {
		SlotMachine sm = new SlotMachine(3, "lemon", "apple", "cherry");

		System.out.println("Actual: " + sm.getNumberOfOutcomes());
		System.out.println("Expected: 27");

		System.out.println("Actual: "
				+ sm.outcomes.contains("lemon apple cherry"));
		System.out.println("Expected: true");

		System.out.println("Actual: "
				+ sm.outcomes.contains("apple cherry apple"));
		System.out.println("Expected: true");

		System.out.println("Actual: "
				+ sm.outcomes.contains("lemon cherry cherry"));
		System.out.println("Expected: true");

		System.out.println("Actual: " + sm.outcomes.contains("lemon"));
		System.out.println("Expected: false");

		System.out.println("Actual: " + sm.outcomes.contains("apple cherry"));
		System.out.println("Expected: false");

		sm.calculateOutcomesWithoutRepeats();

		System.out.println("Actual: "
				+ sm.outcomes.contains("lemon cherry apple"));
		System.out.println("Expected: true");

		System.out.println("Actual: " + sm.outcomes.contains("lemon"));
		System.out.println("Expected: false");

		System.out.println("Actual: "
				+ sm.outcomes.contains("apple cherry cherry"));
		System.out.println("Expected: false");

		System.out.println("Actual: "
				+ sm.outcomes.contains("cherry apple lemon"));
		System.out.println("Expected: true");
	}
}