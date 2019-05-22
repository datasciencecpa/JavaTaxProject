package income;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Long_Capital_Gain extends Income{
	public Long_Capital_Gain (float amount, float taxWithheld) {
		super(IncomeType.LONG_CAPITAL_GAIN, amount, taxWithheld);
	}
	public void describe() {
		super.describe();
		System.out.println("IRS Reference: https://www.irs.gov/taxtopics/tc409");
	}
}
