package Tax;
import deduction.*;
/**
 * @author Long Nguyen
 * @Date: 05/18/2019
 */
public class Taxpayer extends Person {

	/**
	 * @param args
	 */
	public enum FilingStatus {
		SINGLE,
		HEAD_OF_HOUSEHOLD,
		MARRIED_FILING_JOINTLY,
		MARRIED_FILING_SEPARATELY,
		QUALIFIED_WIDOWER
	}
	private FilingStatus filingStatus; 			// Store filing status such as Single, Married Filing Jointly
	private Person[] other; 				// Store other person will be filed with this taxpayer.
	private int numQualifyingChild = 0; 	// Store number of qualifying child
	private int numQualifyingRelative = 0;	// Store number of qualifying relative
	private Deduction[] myDeductions;   	// Store number of deductions. 
	public Taxpayer (String firstName, String lastName, int age, FilingStatus filingStatus) {
		super(firstName, lastName, age);
		this.filingStatus = filingStatus;
	}
	public FilingStatus getFilingStatus () {
		return filingStatus;
	}
	public void setNumQualifyingChild (int num) {
		this.numQualifyingChild = num;
	}
	public void setNumQualifyingRelative (int num) {
		this.numQualifyingRelative = num;
	}
	public int getNumQualifyingChild () {
		return numQualifyingChild;
	}
	public int getNumQualifyingRelative () {
		return numQualifyingRelative;
	}
	public void addOtherPerson (Person[] other) {
		this.other = other;
	}
	public Person[] getOther() {
		return other;
	}
	public void printAllPerson() {
		System.out.println("Main taxpayer: " + getFullName());
		for (Person person : getOther()) {
			System.out.println ("Person: " + person);
		}
	}
	// add Deduction class to taxpayer.
	public void addDeductions (Deduction [] d) {
		this.myDeductions = d;
	}
	public void information () {
		// This function may print out detail information about the taxpayer
		// such as incomes, deductions, credits, tax rates
		// Therefore, it will be implemented as the program progress.
		System.out.println ("Will be implemented!");
	}
}
class Person extends AbstractPerson  {
	
	public Person (String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	
	public String toString() {
		return super.getFullName();
	}
	public void information() {
		System.out.println ("This function will be implemented as the project progress");
	}
}
abstract class AbstractPerson {
	private String firstName;   	// Store firstName
	private String lastName; 		// Store lastName
	private int age;				// Store age
	public AbstractPerson (String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public String getFirstName () {
		return firstName;
	}
	public String getLastName () {
		return lastName;
	}
	public String getFullName () {
		return "First name: " + firstName + " Last Name: " + lastName + " Age " + age;
	}
	public int getAge() {
		return age;
	}
	public abstract void information();
}