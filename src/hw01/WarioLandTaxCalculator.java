package hw01;

/**
 * This class should calculate the tax on an item sold to somewhere in Wario
 * Land. In Wario Land, the tax rate is 1% (0.01) plus a flat rate of ten
 * dollars (10.00) on every item plus 5% (0.05) times the original amount on any
 * item with a "5" in the amount.
 * 
 * You MUST extend TaxCalculator to get credit. You must use the taxRate
 * variable in the superclass and call the super class constructor.
 * 
 * You must also override the toString method to return
 * WarioLandTaxCalculator[taxRate=0.01]
 * 
 * This class must have a constructor with no arguments.
 */
public class WarioLandTaxCalculator extends TaxCalculator {
	private static double taxRate;

	public WarioLandTaxCalculator() {

		super(taxRate);
	}

	public String toString() {
		super.toString();

		return "WarioLandTaxCalculator[taxRate=" + super.getTaxRate() + "]";
	}

	public double calculateTax(double originalAmount) {
		super.calculateTax(originalAmount);

		String hasFive = String.valueOf(originalAmount);
		setTaxRate(0.01);
		double amount = 0;
		boolean found = false;

		for (int i = 0; i < hasFive.length(); i++) {

			if (hasFive.substring(i, i + 1).equals("5") && found == false) {
				amount = (originalAmount * super.getTaxRate()) + 10
						+ (originalAmount * 0.05);
				found = true;
			}

		}
		
		if (found == false){
			amount = (originalAmount * super.getTaxRate()) + 10;
		}

		return amount;
	}

}