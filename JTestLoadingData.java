package taxUtil;
import java.security.SecureRandom; // use to generate random taxable income for the testReadingLTG()
import static org.junit.Assert.*;

import org.junit.Test;

public class JTestLoadingData {

	@Test
	public void testReadingAOC() {
		// this testing method will test the return value of function readingAOC
		// Expected values of correct function is below:
		int [] MFJ = {160000,180000};
		int [] Single = {80000,90000};
		int [] MFS = {0,0};
		
		LoadingData test = new LoadingData();
	
		assertArrayEquals(MFJ, test.readingAOC(test.FilingStatusAbre[0]));
		assertArrayEquals(Single, test.readingAOC(test.FilingStatusAbre[1]));
		assertArrayEquals(MFS, test.readingAOC(test.FilingStatusAbre[2]));
	}
	@Test
	public void testReadingCTC() {
		// this testing method will test the return value of function readingCTC
		// Expected values of correct function is below:
		int [] MFJ = {400000,2000,500};
		int [] Single = {200000,2000,500};
		int [] MFS = {200000,2000,500};
		
		LoadingData test = new LoadingData();
	
		assertArrayEquals(MFJ, test.readingCTC(test.FilingStatusAbre[0]));
		assertArrayEquals(Single, test.readingCTC(test.FilingStatusAbre[1]));
		assertArrayEquals(MFS, test.readingCTC(test.FilingStatusAbre[2]));
	}
	@Test
	public void testReadingLL() {
		// this testing method will test the return value of function readingLifetimeLearning
		// Expected values of correct function is below:
		int [] MFJ = {114000,134000};
		int [] Single = {57000,67000};
		int [] MFS = {0,0};
		
		LoadingData test = new LoadingData();
	
		assertArrayEquals(MFJ, test.readingLifetimeLEarning(test.FilingStatusAbre[0]));
		assertArrayEquals(Single, test.readingLifetimeLEarning(test.FilingStatusAbre[1]));
		assertArrayEquals(MFS, test.readingLifetimeLEarning(test.FilingStatusAbre[2]));
	}
	@Test
	public void testReadingLTG() {
		// this testing method will test the return value of function readingLTGain
		// Expected values of correct function is below:
		// Initial value
		float delta = 0.0001f;
		float Single1 = 0.0f;
		float Single2 = 0.15f;
		float Single3 = 0.2f;
		float MFJ1 = 0.0f;
		float MFJ2 = 0.15f;
		float MFJ3 = 0.2f;
		float MFS1 = 0.0f;
		float MFS2 = 0.15f;
		float MFS3 = 0.2f;
		float HOH1 = 0.0f;
		float HOH2 = 0.15f;
		float HOH3 = 0.2f;
		
		SecureRandom randomNum = new SecureRandom();
		float num1 = randomNum.nextInt(38600);
		float num2 = num1 + randomNum.nextInt(425800-38600);
		float num3 = num2 + randomNum.nextInt(9999999 - 425800);
		float num4 = randomNum.nextInt(77200);
		float num5 = num4 + randomNum.nextInt(479000 - 77200);
		float num6 = num5 + randomNum.nextInt(9999999 - 479000);
		float num7 = randomNum.nextInt(38600);
		float num8 = num7 + randomNum.nextInt(239500-38600);
		float num9 = num8 + randomNum.nextInt(9999999 - 239500);
		float num10 = randomNum.nextInt(51700);
		float num11 = randomNum.nextInt(452400 - 51700) + num10;
		float num12 = num11 + randomNum.nextInt(9999999 - 452400);
		LoadingData test = new LoadingData();
		assertEquals(Single1, test.readingLTGain("SINGLE", num1), delta);
		assertEquals(Single2, test.readingLTGain("SINGLE", num2), delta);
		assertEquals(Single3, test.readingLTGain("SINGLE", num3), delta);
		// testing MFJ
		assertEquals(MFJ1, test.readingLTGain("MFJ", num4), delta);
		assertEquals(MFJ2, test.readingLTGain("MFJ", num5), delta);
		assertEquals(MFJ3, test.readingLTGain("MFJ", num6), delta);
	}
}
