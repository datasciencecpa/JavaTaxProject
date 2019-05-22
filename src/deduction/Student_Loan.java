package deduction;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */

import Tax.Taxpayer.FilingStatus;

public class Student_Loan extends Deduction {
	private final static int InterestLimit = 2500; // max limit of interest deduction before AGI limit.
	private FilingStatus filingStatus; // Use to check AGI Limit based on status
	private final static int [] AGI_Single = {65000,80000}; // AGI for Single, HOH, MFS, QW
	private final static int [] AGI_MFJ = {135000,165000};
	public Student_Loan (float amt, FilingStatus status ) {
		super (DeductionType.STUDENT_LOAN_INT, amt);
		this.filingStatus = status;
	}
	public float getAmount () {
		// Return the correct amount that can be deducted for tax purpose
		if (super.getAmount() > InterestLimit) {
			return InterestLimit;
		}
		return super.getAmount();
	} 
	public int [] getAGILimit () {
		if (filingStatus != FilingStatus.MARRIED_FILING_JOINTLY) {
			return AGI_Single;
		} else {
			return AGI_MFJ;
		}
	}
	public void describe() {
		System.out.println ("IRS Reference: https://www.irs.gov/taxtopics/tc456");
		System.out.println ("Deduction type: " + super.getDeductionType() + " Amount: " + getAmount());
		System.out.println ("Your filing status: " + filingStatus + "AGI Lower Limit: " + getAGILimit()[0] + " AGI Upper Limit: " + getAGILimit()[1]);
	}
}
