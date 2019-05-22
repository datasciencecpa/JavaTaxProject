package income;

/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Income extends AbstractIncome {
	public enum IncomeType {
		W2, 
		INTEREST, 
		ORD_DIVIDENDS, 
		QUA_DIVIDENDS, 
		SHORT_CAPITAL_GAIN,
		LONG_CAPITAL_GAIN, 
		IRA_DISTRIBUTION
	}
	private IncomeType incomeType;
	private float amount;
	private float taxWithheld = 0;
	public Income (IncomeType inType, float amt, float tax) {
		this.incomeType = inType;
		this.amount = amt;
		this.taxWithheld = tax;
	}
	public IncomeType getIncomeType () {
		return incomeType;
	}
	public float getAmount () {
		return amount;
	}
	public float getTaxWithheld() {
		return taxWithheld;
	}
	public void describe() {
		// This function may be overwritten by other subclasses that extend this Income class
		System.out.println ("Standard information " + " Income Type:" + incomeType + " Amount:" + amount + " Tax Withheld: " + taxWithheld);
	}
}
abstract class AbstractIncome {
	// This abstract class will have one abstract method describe()
	// which will be implemented by other subclass that extends it.
	public abstract void describe(); 
}