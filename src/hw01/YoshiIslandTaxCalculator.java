package hw01;

public class YoshiIslandTaxCalculator extends TaxCalculator {


	private static double taxRate;
	public YoshiIslandTaxCalculator() {
		super(taxRate);
	}

	public String toString() {
		super.toString();

		return "YoshiIslandTaxCalculator[taxRate=" + super.getTaxRate() + "]";
	}

	public double calculateTax(double originalAmount) {
		super.calculateTax(originalAmount);

		double tax = 0;

		if (originalAmount < 100) {
			tax = originalAmount * super.getTaxRate();
		} else if (originalAmount >= 100) {
			tax = (originalAmount * super.getTaxRate()) + 1;
		}

		return tax;
	}

}