package deduction;
import Tax.Taxpayer.FilingStatus;

/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class IRA_Deduction extends Deduction{
	
	private final static int additional = 1000;
	private final static int contributionLimit = 5500;
	private final static int ageLimit = 50;
	private final static int [] AGI_NO_LIMIT = {0,0};
	private final static int [] AGI_Single_Limit = {63000,73000};
	private final static int [] AGI_Married_Limit_YouCovered = {101000, 121000};
	private final static int [] AGI_Married_Limit_SpouseCovered = {189000,199000};
	private int taxpayerAge;
	private boolean IRACovered;
	private boolean isSpouseCovered = true;
	private FilingStatus filingStatus;
	public IRA_Deduction (float amt, int age, FilingStatus status, boolean covered, boolean spouseCovered) {
		super(DeductionType.IRA, amt);
		this.taxpayerAge = age;
		this.filingStatus = status;
		this.IRACovered = covered;
		this.isSpouseCovered = spouseCovered;
	}
	public int getAge() {
		return taxpayerAge;
	}
	public FilingStatus getFilingStatus () {
		return filingStatus;
	}
	public boolean isCoverred () {
		return IRACovered;
	}
	public float getAmount () {
		float limit = contributionLimit;
		if (taxpayerAge >=ageLimit) {
			limit += additional;
		}
		if (super.getAmount()> limit) {
			return limit;
		}
		return super.getAmount();
	}
	public int[] getAGILimit() {
		// This function will return the correct AGI Limit based on information provided by the taxpayer
		// For taxpayer with no AGI limit because of noncoverage, will return an array {0,0}
		// For example, Single/HOH/MFS taxpayer, IRACovered = false --> will return {0,0}
		// For example, Single/HOH/MFS taxpayer, IRACovered = true --> return AGI_Single_Limit {63,000 , 73000}
		// MFJ, not covered but other spouse is covered (isSpouseCovered = true) -> return {189000,199000}
		if ((filingStatus  != FilingStatus.MARRIED_FILING_JOINTLY) & (filingStatus  != FilingStatus.QUALIFIED_WIDOWER)) {

			if (!IRACovered) {
				return AGI_NO_LIMIT;
			} else {
				return AGI_Single_Limit;
			}
		} else if (filingStatus == FilingStatus.QUALIFIED_WIDOWER) {

			if (!IRACovered) {
				return AGI_NO_LIMIT;
			} else {
				return AGI_Married_Limit_YouCovered;
			}
		} else { // Case remain is MFJ

			if ((!IRACovered) & (!isSpouseCovered)) {

				return AGI_NO_LIMIT;
			} else if (!IRACovered) {
				return AGI_Married_Limit_SpouseCovered;
			} else {
				return AGI_Married_Limit_YouCovered;
			}
		}
	}
	public void describe() {
		System.out.println ("IRS Reference: https://www.irs.gov/retirement-plans/retirement-plans-faqs-regarding-iras");
		System.out.println ("Deduction type: " + super.getDeductionType() + " Amount: " + getAmount());
		System.out.println ("Your Age: " + taxpayerAge + " Filing Status: " + filingStatus);
		System.out.println ("Your IRACovered: " + IRACovered + " Spouse Covered: " + isSpouseCovered);
		System.out.println ("Your lower AGI Limit: " + getAGILimit()[0] + " Higher AGI Limit: " + getAGILimit()[1]);
	}
}
