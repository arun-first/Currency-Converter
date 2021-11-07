/**
 *																Om Namah Shivaay
 * 
 * Converts one kind of currency to another.
 * @author: arun-first
 *
 * Compilation: javac Currency.java
 * Execution: java sensex.Currency
 */

package sensex; // package

import java.util.Scanner; // scanner class
import java.util.InputMismatchException; // exception for wrong input

public class Currency {
	// necessary variables
	double convertTo = 0.00d, convertFrom = 0.00d, rate = 0.00d; // for conversion
	int orderTo = 0, orderFrom = 0; // for menu options

	// array to hold the options
	public static String[] menuOpt = {"","INR Ruppees","US Dollar","Pound Sterling","Euro","Japanese Yen","Swiss Franc"};

	// for conversion purposes
	static double[] ruppee = {0,0,0.013,0.0100,0.012,1.53,2.40}; // 1 Ruppee = to the following sensex
	static double[] dollar = {0,74.19,0,0.74,0.87,113.42,0.91};
	static double[] pound = {0,100.14,1.35,0,1.17,153.09,1.23};
	static double[] euro = {0,85.70,1.16,0.86,0,130.94,1.05};
	static double[] yen = {0,0.65,0.0088,0.0065,0.0076,0,0.0080};
	static double[] franc = {0,81.33,1.10,0.81,0.95,124.33,0};

	// necessary instantiation
	static Scanner stdInput = new Scanner(System.in); // scanner
	static Currency curr = new Currency(); // class instantiation

	// main method
	public static void main(String[] args) {
		// convert to screen
		curr.startScreen ();
		System.out.println("\t\tConvert to, ");
		curr.orderTo = curr.mainMenu(); // taking the menu input
		curr.endScreen ();

		// convert from screen
		curr.startScreen();
		System.out.println("\t\tConvert from, ");
		curr.orderFrom = curr.mainMenu(); // taking the menu input
		System.out.print("\n\tAmount: ");
		curr.convertFrom = stdInput.nextDouble(); // taking input the amount to convert
		curr.endScreen();

		if (curr.orderTo == curr.orderFrom) { // if currencies are equal
			System.out.println("\tERROR: Both Currencies same");
			System.exit(0);
		}

		// conversino printing 
		curr.startScreen();
		curr.convert(); // conversion	
		curr.endScreen(); // end screen
	}

	// start screen
	public void startScreen () {
		System.out.println("\t#################################################");
		System.out.println("\t\t\tCURRENCY SENSEX");
		System.out.println("\t\t\t***************");
		System.out.println(); // new line
	}

	// end screen
	public void endScreen () {
		System.out.println("\n");
		System.out.println("\t#################################################");
	}

	// main menu
	public int mainMenu () {
		int k = 0; // for input
		for (int i = 1, n = menuOpt.length; i < n; i++)
			System.out.println("\t\t[ "+i+" ] "+menuOpt[i]);

		// taking the input
		do {
			try {
				System.out.print("\n\tPress [1 - 6]: ");
				k = stdInput.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("ERROR: invalid input");
				System.exit(0);
			}
		} while (k < 0 || k > 7);

		return k;
	}

	// method for conversion
	public void convert () {
		// converting as per the option
		switch (curr.orderFrom) {
			case 1: curr.rate = ruppee[curr.orderTo];
					break;
			case 2: curr.rate = dollar[curr.orderTo];
					break;
			case 3: curr.rate = pound[curr.orderTo];
					break;
			case 4: curr.rate = euro[curr.orderTo];
					break;
			case 5: curr.rate = yen[curr.orderTo];
					break;
			case 6: curr.rate  = franc[curr.orderTo];
					break;
		}

		curr.convertTo = curr.convertFrom * curr.rate; // conversion done

		// printing the converted rate
		System.out.printf("\t%.2f %s = %.2f %s\n",curr.convertFrom, menuOpt[curr.orderFrom], curr.convertTo, menuOpt[orderTo]);
	}
 }
