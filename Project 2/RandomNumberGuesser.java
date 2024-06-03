/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: Build an application that will receive a guess and report if your guess is the random number that was generated
 * Due: 09/26/2022
 * Platform/compiler: Java Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Dolev Peleg
*/

import java.util.Scanner;
/**
 * 
 * This is the driver class
 * It generates a random number, and let the user guess it as long as they do not exceed 7 tries
 * It contains a static method to get the user's number
 * @author Dolev Peleg
 */
public class RandomNumberGuesser 
{
	public static void main(String[] args) 
	{
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Create variables
		int lowestNumber = 0;
		int highestNumber = 100;
		int userNumber = 0;
		int guessCount = RNG.getCount();
		int randomNum = 0;
		
		// Print an explanation about the application
		System.out.println("This application generates a random integer between 0 and 100\n"
				+ "and asks the user to guess repeatedly until they guess correctly.\n");
		
		// Let the user guess a random number between 0 and 100, as long as count is less or equal than 7
		do
		{
			// If the guess count is 0, generate a random number, and prompt the user to guess if
			if (guessCount == 0)
			{
				randomNum = RNG.rand();
				System.out.println("Enter your first guess:");
				userNumber = getNumber(lowestNumber, highestNumber);
			}
			
			// If the guess count is not 0, prompt the user their next guess
			else
			{
				System.out.println("Enter your next guess:");
				userNumber = getNumber(lowestNumber, highestNumber);
			}
			
			// If the user guess is correct, ask the user if they want to try again
			if (userNumber == randomNum)
			{
				System.out.println("Congratulations, you guessed correctly");
				System.out.println("Try again? (yes or no)");
				String againAnswer = input.nextLine();
				
				// If the user's input is 'no', print an ending message and my name, and exit the program
				if (againAnswer.equalsIgnoreCase("no") == true)
				{
					System.out.println("Thanks for playing...\n");
					System.out.print("Programmer name: Dolev Peleg");
					System.exit(0);
				}
				
				// If the user's input is 'yes', reset the guess count and the bounds, restart the loop
				else
				{
					lowestNumber = 0;
					highestNumber = 100;
					RNG.resetCount();
					guessCount = RNG.getCount();
					continue;
				}
			}
			
			// If the user's guess is higher than the random number, notify the user, and initialize the high bound possible to the user's guess
			else if (userNumber > randomNum)
			{
				System.out.println("Your guess is too high");
				highestNumber = userNumber;
			}
			
			// If the user's guess is lower than the random number, notify the user, and initialize the low bound possible to the user's guess
			else
			{
				System.out.println("Your guess is too low");
				lowestNumber = userNumber;
			}
			
			// Print the range of the possible numbers as long as it is not the last guess
			if (guessCount <= 5) 
			{
				System.out.println("Enter your next guess between " + lowestNumber + 
						" and " + highestNumber);
			}
			
			// Print the current guess count and increase it by 1
			guessCount++;
			System.out.println("Number of guesses is: " + guessCount);
			
		}while (guessCount <= 6);
		
		// Print a message that the user exceeded the maximum numbers, an ending message, and my name, and exit the program
		System.out.println("You have exceeded the maximum number of guesses, 7. Try again.");
		System.out.println("Thanks for playing...\n");
		System.out.print("Programmer name: Dolev Peleg");
	}
	
	/**
	 * Get an integer from the user, validates its input
	 * @param lowestNumber
	 * @param highestNumber
	 * @return an integer, the user's guess
	 */
	public static int getNumber(int lowestNumber, int highestNumber)
	{
		int userNumber;
		Scanner input = new Scanner(System.in);
		userNumber = input.nextInt();
		while (RNG.inputValidation(userNumber, lowestNumber, highestNumber) == false)
		{
			userNumber = input.nextInt();
		}
		return userNumber;
	}
}