package income;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class IRA_Distribution extends Income {
	private boolean isExempt;
	public IRA_Distribution (float amount, float taxWithheld, boolean isExempt) {
		super(IncomeType.IRA_DISTRIBUTION, amount, taxWithheld);
		this.isExempt = isExempt;
	}
	public void describe() {
		super.describe(); // Call superclass describe method
		System.out.println ("Meet the penalty exemption: " + isExempt);
		System.out.println ("IRS Reference: https://www.irs.gov/retirement-plans/individual-retirement-arrangements-iras");
	}
}
