package income;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Ordinary_Dividends extends Income{
	public Ordinary_Dividends (float amount, float taxWithheld) {
		super(IncomeType.ORD_DIVIDENDS, amount, taxWithheld);
	}
	public void describe() {
		super.describe();
		System.out.println ("Reference: https://www.investopedia.com/terms/o/ordinary-dividends.asp");
	}
}
