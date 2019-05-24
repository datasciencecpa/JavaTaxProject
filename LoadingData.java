package taxUtil;
/**
 * @author Long Nguyen
 * @Date: 05/22/2019
 */
import java.util.Scanner;

import java.nio.file.Paths;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
public class LoadingData {
	private final static String [] FILE_NAMES = {"AOC.txt", "CTC.txt", "LifetimeLearning.txt", "LTGain.txt", "STD.txt",
												"StudentLoan.txt", "Taxbracket.txt"};
	public final static String [] FilingStatusAbre =  {
		"MFJ",
		"SINGLE",
		"MFS", 
		"HOH"
	};
	public String relativePath;
	public LoadingData() {
		this.relativePath = Paths.get("").toAbsolutePath().toString() + "/src/taxUtil/data/"; // get the relative path where the program is running.
	}
	// reading American Opportunity Credit data from a text file out.
	public int [] readingAOC(String status) {
		// This function will return the lower MAGI and upper MAGI of the American Opportunity Credit
		// amounts are stored in the AOC.txt file.
		// Using status to select the right data.
		int [] returnValues = {0,0}; //initialize returnValues array
		try {
			String URI = relativePath + FILE_NAMES[0];
			Scanner myFile = new Scanner(new File (URI));
			myFile.nextLine(); // skip header
			while (myFile.hasNext()) {
				String filingStatus = myFile.next();

				if (filingStatus.contains(status)) {
					returnValues[0] = myFile.nextInt();
					returnValues[1] = myFile.nextInt();
					break; // exist out the loop
				} else {
					myFile.nextLine();
				}	
			}
			myFile.close();
		}
		catch (FileNotFoundException ex) {
			System.err.println ("Cannot open file ... quitting");
			ex.printStackTrace();
		}
		catch (IOException ex) {
			System.err.println ("Cannot read file ... quitting");
			ex.printStackTrace();
		}
		return returnValues;
	}
	public int [] readingCTC (String status) {
		/**
		 * This function will read data from a file CTC.txt (Child Tax Credit).
		 * it will return an array of type integer. The first value represent Phase_out_agi, 
		 * second: Credit per child, and the last value is credit per other dependent.
		 * status is used as key to select the correct row of values.
		 */
		int []returnValues = {0,0,0}; // initial return values
		try {
			String URI = relativePath + FILE_NAMES[1]; // initial path to the file
			Scanner myFile = new Scanner(new File(URI));
			myFile.nextLine(); // skip header
			while (myFile.hasNext()) {

				String filingStatus = myFile.next();
				if (filingStatus.contains(status)) {
					returnValues[0] = myFile.nextInt(); // Phase out AGI
					returnValues[1] = myFile.nextInt(); // Credit per child
					returnValues[2] = myFile.nextInt(); // Credit per other dependent
					break;
				}
				else {
					myFile.nextLine();
				}
			}
			myFile.close();
		} 
		catch (FileNotFoundException ex) {
			System.err.println ("Cannot open file ... quitting");
			ex.printStackTrace();
		}
		catch (IOException ex) {
			System.err.println ("Cannot read file ... quitting");
			ex.printStackTrace();
		}
		return returnValues;
				
	}
	// Reading Lifetime Learning Credit
	public int [] readingLifetimeLEarning (String status) {
		/**
		 * This function will read data from a file LifetimeLearning.txt (Lifetime Learning Credit).
		 * it will return an array of type integer. The first value represent LOWER_MAGI, 
		 * second: Upper AGI
		 * 
		 */
		int []returnValues = {0,0}; // initial return values
		try {
			String URI = relativePath + FILE_NAMES[2]; // initial path to the file
			Scanner myFile = new Scanner(new File(URI));
			myFile.nextLine(); // skip header
			while (myFile.hasNext()) {

				String filingStatus = myFile.next();
				if (filingStatus.contains(status)) {
					returnValues[0] = myFile.nextInt(); // Lower MAGI
					returnValues[1] = myFile.nextInt(); // Upper MAGI
					break;
				}
				else {
					myFile.nextLine();
				}
			}
			myFile.close();
		} 
		catch (FileNotFoundException ex) {
			System.err.println ("Cannot open file ... quitting");
			ex.printStackTrace();
		}
		catch (IOException ex) {
			System.err.println ("Cannot read file ... quitting");
			ex.printStackTrace();
		}
		return returnValues;		
	}
	// Reading data of Long_term capital gain
	public double readingLTGain (String status, float taxableIncome) {
		/**
		 * This function will read data from a file LTGain.txt (Long Term capital gain).
		 * it will return LT capital gain tax rate of type float. 
		 * The function require 2 parameters: String status and taxable Income. 
		 * These parameters are used to identify the correct tax rate.
		 */
		float returnValue = 0.0f; // initial return values
		// Testing taxable income to make sure it is greater than zero.
		if (taxableIncome < 0) {
			return returnValue; // return 0%
		}
		
		try {
			String URI = relativePath + FILE_NAMES[3]; // initial path to the file
			Scanner myFile = new Scanner(new File(URI));
			myFile.nextLine(); // skip header
			while (myFile.hasNext()) {

				String filingStatus = myFile.next();
				float lowerAmt = myFile.nextFloat();
				float upperAmt = myFile.nextFloat();
				
				if (filingStatus.contains(status) & (lowerAmt <= taxableIncome) & (upperAmt>taxableIncome)){
					returnValue = myFile.nextFloat();
					break;
				}
				else {
					myFile.nextLine();
				}
			}
			myFile.close();
		} 
		catch (FileNotFoundException ex) {
			System.err.println ("Cannot open file ... quitting");
			ex.printStackTrace();
		}
		catch (IOException ex) {
			System.err.println ("Cannot read file ... quitting");
			ex.printStackTrace();
		}
		return returnValue;		
	}
}
