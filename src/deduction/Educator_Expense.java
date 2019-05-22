package deduction;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Educator_Expense extends Deduction{
	private final static float limit = 250;
	public Educator_Expense (float amt) {
		super(DeductionType.EDUCATOR_EXP, amt);
	}
	public float getAmount() {
		if (super.getAmount() > limit) {
			return limit;
		}
		return super.getAmount();
	}
	public void describe() {
		System.out.println ("Deduction type: " + super.getDeductionType() + " Amount: " + getAmount());
		System.out.println ("IRS Reference: https://www.irs.gov/taxtopics/tc458");
	}
}

