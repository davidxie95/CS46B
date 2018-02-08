package hw01;

/**
 * This class should calculate the tax on an item sold to somewhere in Mario
 * World. In Mario World, the tax rate is 4% (0.04) for any item weighing under
 * 100 pounds, and 8% on any item weighing 100 pounds or more.
 * 
 * You MUST extend TaxCalculator to get credit. You must use the taxRate
 * variable in the superclass and call the super class constructor.
 * 
 * You must also override the toString method to return
 * MarioWorldTaxCalculator[taxRate=TAX_RATE] Where TAX_RATE should be either
 * 0.04 or 0.08 based on the weight of the item being taxed.
 * 
 * This class must have a constructor with one arguments, which is a double that
 * represents the weight in pounds of the object to be taxed.
 */
public class MarioWorldTaxCalculator extends TaxCalculator {


	private static double taxRate;
	private double weight;
	
	public MarioWorldTaxCalculator(double theWeight) {

		super(taxRate);
		weight = theWeight;
	}

	public String toString() {
		super.toString();

		return "MarioWorldTaxCalculator[taxRate=" + super.getTaxRate() + "]";
		
	}

	public double calculateTax(double originalAmount) {
		super.calculateTax(originalAmount);

		double amount = 0;
		
		if (weight < 100){
			super.setTaxRate(0.04);
			amount = (originalAmount * super.getTaxRate()) ;
		}
		else{
			super.setTaxRate(0.08);
			amount = (originalAmount * super.getTaxRate());
		}
		
		return amount;
	}

}
