package deduction;

/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class HSA extends Deduction {
	public enum FilingStatus {
		SINGLE,
		FAMILY
	}
	private FilingStatus coveredType;
	private final static float limit1 = 3450;
	private final static float limit2 = 6900;
	public HSA (FilingStatus coveredType, float amt) {
		super(DeductionType.HSA, amt);
		this.coveredType = coveredType;
	}
	public float getAmount () {
		float limit = 0;
		if (coveredType == FilingStatus.SINGLE) {
			limit = limit1;
		}else {
			limit = limit2;
		}
		if (super.getAmount() > limit) {
			return limit;
		}
		return super.getAmount();
	}
	public FilingStatus getCoveredType () {
		return coveredType;
	}
	public void describe() {
		System.out.println ("Deduction type: " + super.getDeductionType() + " Cover:" + coveredType + " Amount: " + getAmount());
		System.out.println("IRS Reference: https://www.irs.gov/publications/p969");
	}
}
