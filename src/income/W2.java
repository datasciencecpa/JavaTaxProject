package income;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class W2 extends Income {
	public W2(float amount, float taxWithheld) {
		super(IncomeType.W2, amount, taxWithheld);
	}
	public void describe() {
		super.describe();
		System.out.println ("IRS Reference: https://www.irs.gov/forms-pubs/about-form-w-2");
	}
}
