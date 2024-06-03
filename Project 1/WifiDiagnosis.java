/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Build an application that will step through some possible problems to restore Internet connectivity
 * Due: 09/12/2022
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dolev Peleg
*/

import java.util.Scanner;

public class WifiDiagnosis 
{
	// Main method
	public static void main(String[] args)
	{
		// Declaring constants
		final String FIX_PROMPT = "Did that fix the problem? (Yes or No)";
		final String NEGATIVE = "No";
		final String POSITIVE = "Yes";
		final String PROGRAMMER_NAME = "Programmer: Dolev Peleg";
		
		// Creating a Scanner
		Scanner input = new Scanner(System.in);
		
		// Explanation to the user about the program
		System.out.println("If you have a problem with internet connectivity this WiFi Diagnosis might work.\n");
		
		// Prompting the user to reboot the computer
		System.out.println("Reboot the computer and try to connect");
		
		// Prompting the user to see if the issue is fixed
		System.out.println(FIX_PROMPT);
		String userAnswer = input.nextLine();
		
		// If the user's answer is 'yes', 'no', or invalid
		checkAnswer(POSITIVE, NEGATIVE,userAnswer, PROGRAMMER_NAME);
		
		// Prompting the user to reboot the router
		System.out.println("Reboot the router and try to connect");

		// Prompting the user to see if the issue is fixed
		System.out.println(FIX_PROMPT);
		userAnswer = input.nextLine();

		// If the user's answer is 'yes', 'no', or invalid
		checkAnswer(POSITIVE, NEGATIVE, userAnswer, PROGRAMMER_NAME);
				
		/* Prompting the user to make sure the cables connecting the router are firmly plugged in
		 * and power is getting to the router */
		System.out.println("Make sure the cables connecting the router are firmly plugged in "
				+ "and power is getting to the router");

		// Prompting the user to see if the issue is fixed
		System.out.println(FIX_PROMPT);
		userAnswer = input.nextLine();

		// If the user's answer is 'yes', 'no', or invalid
		checkAnswer(POSITIVE, NEGATIVE, userAnswer, PROGRAMMER_NAME);

		// Prompting the user to move the computer closer to the router
		System.out.println("Move the computer closer to the router and try to connect");

		// Prompting the user to see if the issue is fixed
		System.out.println(FIX_PROMPT);
		userAnswer = input.nextLine();

		// If the user's answer is 'yes', 'no', or invalid
		checkAnswer(POSITIVE, NEGATIVE, userAnswer, PROGRAMMER_NAME);
		
		// If the program got to this line of code, it means that the user can only contact their ISP
		System.out.println("Contact your ISP\n");
		System.out.println(PROGRAMMER_NAME);
		
	}
	
	// This method checks what the user input is, and exit the program if it is positive or invalid
	public static void checkAnswer(String positive, String negative, String userAnswer, String programmerName)
	{
		// If the user's input is not 'no'
		if (negative.equalsIgnoreCase(userAnswer) == false)
		{
			// If the user's input is not 'yes' either (invalid answer), print an error message
			if (positive.equalsIgnoreCase(userAnswer) == false)
			{
				System.out.println("\nInvalid answer; try again");
			}
			else
			{
				System.out.println("\nDone");
			}
			
			// Print my name and exiting the program
			System.out.println(programmerName);
			System.exit(0);
		}
	}
}