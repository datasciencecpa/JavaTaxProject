package Tax;
import Tax.Taxpayer.FilingStatus;
public class TestTaxpayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Taxpayer myTaxpayer = new Taxpayer("Long", "Nguyen", 32, FilingStatus.SINGLE);
		System.out.println ("My Taxpayer: " + myTaxpayer.getFullName());
		System.out.println ("Num Qualifying Child: " + myTaxpayer.getNumQualifyingChild());
		System.out.println ("Get others: " + myTaxpayer.getOther());
		Person person1 = new Person("AA", "BB", 10);
		Person person2 = new Person("AA2", "BB2", 11);
		Person [] other = {person1, person2};
		myTaxpayer.addOtherPerson(other);
		myTaxpayer.printAllPerson();
	}

}
