package income;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Interest extends Income{
	public Interest(float amount, float taxWithheld) {
		super(IncomeType.INTEREST, amount, taxWithheld);
	}
	public void describe() {
		super.describe();
		System.out.println("IRS Reference: https://www.irs.gov/faqs/interest-dividends-other-types-of-income/1099-int-interest-income/1099-int-interest-income");
	}
}
