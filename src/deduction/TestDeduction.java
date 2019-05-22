package deduction;

/**
 * @author Long Nguyen
 * @Date: 05/20/2019
 */
import deduction.Deduction.DeductionType;
import deduction.HSA; // Use to test HSA class
import Tax.Taxpayer.FilingStatus;  // use to test IRA class
public class TestDeduction {
	// This class is used to test classes in the Deduction package

	public static void main (String [] args) {
		test1();
		test2();
	}
	
	public static void test1() {
		Educator_Expense edx1 = new Educator_Expense(100); // conform with limit $250
		Educator_Expense edx2 = new Educator_Expense(300); // non-conform
		System.out.println("Educator Expense 1 Amount $100. Limit: " + edx1.getAmount());
		System.out.println("Educator Expense 2 Amount $300. Limit: " + edx2.getAmount()); // reduce to $250
		edx1.describe();
		System.out.println ("-------------------------------------------------------------");
		
		// Testing HSA
		HSA hs1 = new HSA(HSA.FilingStatus.SINGLE, 1500); // conform with limit for Single HSA $3450
		HSA hs2 = new HSA(HSA.FilingStatus.SINGLE, 5000);  // nonconform with limit for Single HSA
		System.out.println ("HSA Contribution  $1500. Limit: " + hs1.getAmount());
		System.out.println ("HSA Contribution $5000. Limit: " + hs2.getAmount());
		hs2.describe();
		System.out.println ("-------------------------------------------------------------");
		
		hs1 = new HSA(HSA.FilingStatus.FAMILY, 4000); // conform with limit for Family HSA $6900
		hs2 = new HSA(HSA.FilingStatus.FAMILY, 7000);  // nonconform with limit for Family HSA
		System.out.println ("HSA Contribution  $4000. Limit: " + hs1.getAmount());
		System.out.println ("HSA Contribution $7000. Limit: " + hs2.getAmount());
		hs2.describe();
		System.out.println ("-------------------------------------------------------------");
		
		// Testing IRA
		IRA_Deduction ira1 = new IRA_Deduction(3000, 50, FilingStatus.SINGLE, false, false); // conform case, non covered
		
		ira1.describe();
		System.out.println ("-------------------------------------------------------------");
		IRA_Deduction ira2 = new IRA_Deduction(7500, 50, FilingStatus.SINGLE, true, false); // nonconform, covered
		// Max IRA contribution $6500, $5500 +  $1000 catch up for age >= 50
		ira2.describe();
		System.out.println ("-------------------------------------------------------------");
		IRA_Deduction ira3 = new IRA_Deduction(4000, 30, FilingStatus.HEAD_OF_HOUSEHOLD, true, false);
		ira3.describe();
		System.out.println ("-------------------------------------------------------------");
		IRA_Deduction ira4 = new IRA_Deduction(4000, 30, FilingStatus.MARRIED_FILING_JOINTLY, false, false); // no limit
		ira4.describe();
		System.out.println ("-------------------------------------------------------------");
		IRA_Deduction ira5 = new IRA_Deduction(4000, 30, FilingStatus.MARRIED_FILING_JOINTLY, false, true); // spouse covered.
		ira5.describe();
		System.out.println ("-------------------------------------------------------------");
		
		// Testing Student loan class
		Student_Loan st1 = new Student_Loan(1000, FilingStatus.MARRIED_FILING_SEPARATELY); // conform case, amount <$2500.
		// Expect return : $1000, [65000,80000]
		st1.describe();
		System.out.println ("-------------------------------------------------------------");
		st1 = new Student_Loan(3000,  FilingStatus.MARRIED_FILING_JOINTLY); // nonconform case, amount > 2500
		st1.describe();
		System.out.println ("-------------------------------------------------------------");
	}
	public static void test2 () {
		// This function will demonstrate downcasting technique
		
		// Step 1 - create some variable of different classes
		Deduction edx2 = new Educator_Expense(300); // non-conform
		Deduction hs2 = new HSA(HSA.FilingStatus.SINGLE, 5000);
		Deduction hs1 = new HSA(HSA.FilingStatus.FAMILY, 4000); // conform with limit for Family HSA $6900
		Deduction ira1 = new IRA_Deduction(3000, 50, FilingStatus.SINGLE, false, false); // conform case, non covered
		Deduction st1 = new Student_Loan(1000, FilingStatus.MARRIED_FILING_SEPARATELY); // conform case, amount <$2500.
		
		// Step 2 - create an array of Deduction class that contains those variables above
		Deduction [] myDeduction = {edx2, hs2, hs1, ira1, st1};
		for (Deduction deduction: myDeduction) {
			// Need to check type of each iteration
			switch (deduction.getDeductionType()) {
			case EDUCATOR_EXP:
				deduction.describe(); // polymorphism
				break;
			case HSA:
				System.out.println ("HSA Covered Type: " + ((HSA)deduction).getCoveredType()); // Downcasting example
				deduction.describe(); // polymorphism
				break;
			case IRA:
				System.out.println ("AGI Lower Limit: " + ((IRA_Deduction)deduction).getAGILimit()[0]); //Downcasting example
				deduction.describe(); // polymorphism
				break;
			case STUDENT_LOAN_INT:
				System.out.println ("AGI Limit: Lower " + ((Student_Loan)deduction).getAGILimit()[0]); 
				deduction.describe(); // polymorphism
			default:
				break;
			}
			System.out.println("*********************************************************************");
		}
		
	}
	
}
