package deduction;

/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Deduction extends Abstract_Deduction {
	public enum DeductionType {
		EDUCATOR_EXP, 
		HSA,
		IRA,
		STUDENT_LOAN_INT
	}
	private DeductionType deductionType;
	
	public Deduction (DeductionType deType, float amt) {
		super(amt);
		this.deductionType = deType;

	}
	public DeductionType getDeductionType() {
		return deductionType;
	}
	public void describe() {
		System.out.println ("Deduction type: " + deductionType + " Amount: " + super.getAmount());
	}
}

abstract class Abstract_Deduction {
	private float amount;
	public Abstract_Deduction (float amt) {
		this.amount = amt;
	}
	public float getAmount () {
		return amount;
	}
	public abstract void describe(); // To be implemented by subclass
}