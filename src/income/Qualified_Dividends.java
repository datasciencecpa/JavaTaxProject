package income;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Qualified_Dividends extends Income{
	public Qualified_Dividends (float amount, float taxWithheld) {
		super(IncomeType.QUA_DIVIDENDS, amount, taxWithheld);
	}
	public void describe() {
		super.describe();
		System.out.println ("Reference:https://www.investopedia.com/terms/q/qualifieddividend.asp");
	}
}
