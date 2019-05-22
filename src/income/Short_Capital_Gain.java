package income;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Short_Capital_Gain extends Income {
	public Short_Capital_Gain (float amount, float taxWithheld) {
		super(IncomeType.SHORT_CAPITAL_GAIN, amount, taxWithheld);
	}
	public void describe() {
		super.describe();
		System.out.println("IRS Reference: https://www.irs.gov/taxtopics/tc409");
	}
}
