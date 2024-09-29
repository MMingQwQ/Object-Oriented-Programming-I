// -------------------------------------------------------------------- 
// Assignment 3 Q1
// Written by: Mingming Zhang 
// For COMP 248 Section (EC) – Winter 2023
// --------------------------------------------------------------------

/*
 * Algorithm 1: Simple Brilliant Mind Game Jackpot Program (see more details in AlgA3_Q1.txt)
 * Created: Sun March 5 2023
 * Author: Mingming Zhang
 * 
 * Purpose: the program was designed for students aged from 15 to 125 years old 
 * computing the total score of all the numbers of 
 * the category’s score value that are NOT multiple of the category number.  
 */

// import 
import java.util.Scanner;

public class A3_Q1 {

	public static void main(String[] args) {
		// Constant and variable declarations;
		final int numOfCate = 10;
		
		// Using array to store the values in the table
		int[] scoreValue = {19, 18, 19, 20, 19, 18, 19, 19, 18, 19};
		String[] category = {"Science", "Literature", "Sports", "Animals", "Television", "Music", "Business", 
				"Geography", "Cities","Opera"};

		final int ageMax = 125;
		final int ageMin = 15;
		
		int age = 0;
		int totalValue = 0;
		int count1 = 0; // count the amount of the numbers that are not multiple of the category number;
		int count2 = 0; // count the amount of the numbers that are multiple of the category number;
		Scanner in = new Scanner(System.in);

		// Display a welcome/salutation message to the user of the program;
		System.out.println("____****_______****_______****_______****_______****___");
		System.out.println("   Welcome to the Simple Brilliant Mind Game Jackpot!");
		System.out.println("____****_______****_______****_______****_______****___");
		System.out.println();
		
		// Display a prompt message for the user to enter a valid age 
		do
		{
			System.out.println("How old are you?");
			age = in.nextInt();
			if (age<= ageMin || age >= ageMax)
			{
				System.out.println("Error: Your input/entry is not a valid integer between 15 to 125. Kingly retry again!");
			}
		}while(age<= ageMin || age >= ageMax); //age should be higher than 15 and less than 125 years
		
		System.out.println(); // Display the output in the same format as the sample shown
		System.out.println("____****_______****_______****_______****_______****____");
		System.out.println("      Your Jackpot for the Simple Brilliant Mind Game is: ");
		System.out.println("____****_______****_______****_______****_______****____\n\n\n");
		
		
		// Process for each category the numbers in its score value that are NOT multiple of that category number;
		// Outer For-loop to iterate the scoreValue in the table
		for (int i = 1; i <= numOfCate; i++)
		{
			count1 = 0; // reset count1 to 0 each time when start to loop a new category score value
			// Display for each category's result
			System.out.println("In the score of " + category[i-1] + ", the numbers that are not multiple of category " + i + " are:" );
			
			// Inner For-loop to find for each category the numbers, the numbers that are NOT multiple of that category number
			for(int j = 1; j <= scoreValue[i-1]; j++)
			{
				if(j % i != 0)
				{
					count1 ++;
					if (count1 == 10)
					{
						System.out.println(j + ", ");
					}
					else
					{
						System.out.print(j + ", ");
					}
					//Process the cumulative Cryptom money;
					totalValue += j;
				}
				else
				{
					count2++;
				}
			}
			
			if (count1 == 0 && count2 != 0)
			{
				System.out.println("No numbers are found in this category! ==> The Cryptom Value " + totalValue + ".");
			}
			else {
				System.out.println("==> The Cryptom Value " + totalValue + ".");
			}
			System.out.println();
		}
		
		// Display a complimentary-close message
		System.out.println("Thank you for using my bespoke the Simple brilliant Mind Game Jackpot Program!");
		
		// Close Scanner
		in.close();
	}

}
