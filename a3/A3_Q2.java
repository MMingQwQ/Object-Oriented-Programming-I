// -------------------------------------------------------------------- 
// Assignment 3 Q2
// Written by: Mingming Zhang
// For COMP 248 Section (EC) – Winter 2023
// --------------------------------------------------------------------

/*
 * Algorithm 2: Concordia CAERP Exam Registration Program (see more details in AlgA3_Q2.txt)
 * Created: Sun March 5 2023
 * Author: Mingming Zhang
 * 
 * Purpose: The program is designed for ACSD students to register courses by selecting different choices from menu. 
 * The menu is displayed as follows:
 * 1.     List of courses
 * 2.     Add a student
 * 3.     Add course(s)
 * 4.     Display details
 * 0.     Exit CAERP
 */
// import 
import java.util.Scanner;

public class A3_Q2 {

	public static void main(String[] args) {
		// Constant and variable declarations;
		Scanner in = new Scanner(System.in);
		String choice; // To store the value of choice;
		
		// Declare 3 arrays for courseName, courseNumber and the amount of student (named student)
		// and suppose size of these arrays are 20
		String [] courseName = new String [20];
		String [] courseNumber = new String [20];
		int [] student = new int [20];		
		
		// Display a welcome/salutation message to the user of the program.
		System.out.println("=======****======****======****======****======****=========");
		System.out.println("Welcome to Concordia ACSD Exam Registration Program (CAERP): ");
		System.out.println("=======****======****======****======****======****=========\n");
		;
		// Display a prompt message for the user to enter all the courses;
		System.out.println("Please enter a list of courses having ACSD students:");
		String line = in.nextLine();
		int i = 0; // index
		while(line.contains("-"))
		{
			if(line.length()>10)
			{
				int index2 = line.indexOf("-");
				courseName[i] = line.substring(0,index2).toUpperCase();
				courseNumber[i] = line.substring(index2+1,10);
				line = line.substring(11);
			}
			
			else if (line.length() == 10)
			{
				courseName[i] = line.substring(0,6).toUpperCase();
				courseNumber[i] = line.substring(7);
				line = line.substring(line.length());
			}
			i++;
		}
		
		// Display a prompt message to the user for a menu choice.
		System.out.println("===============================");
		System.out.println("| Choice. Description         |");
		System.out.println("===============================");
		System.out.println("|  1.     List of courses     |");
		System.out.println("|  2.     Add a student       |");
		System.out.println("|  3.     Add course(s)       |");
		System.out.println("|  4.     Display details     |");
		System.out.println("|  0.     Exit CAERP          |");
		System.out.println("===============================");
		
		System.out.println();
		// Display a prompt message for the choice
		System.out.print("Please enter you choice (1, 2, 3, 4 or 0): ");
		choice = in.next();
		// For choice check, using nested while loop. 
		// Outer while loop check the choice is not "0".
		// Inner while loop check the choice is "1","2","3","4".
		// Then, process the request according to different choice.
		while(!choice.equals("0"))
		{
			boolean choiceCheck = true;
			while (choiceCheck) // Then,make sure user enter valid choice
			{
				if ( !(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) )
				{
					System.out.print("\nKindly keep entering a valid choice from the menu: ");
					choice=in.next();
				}
				else
					choiceCheck = false;
			}
		
		
			if (choice.equals("1"))
			{
				System.out.println("=============================");
				System.out.println("| Course Name-Course Number |");
				System.out.println("=============================");
				for (int j = 0; j < i; j ++)
				{
					System.out.println("|  " + courseName[j] + "         " + courseNumber[j] + "       |");
					
				}
				System.out.println("=============================");
				
				System.out.print("\nKindly keep entering a valid choice from the menu: ");
				choice=in.next();
			}
			
			if (choice.equals("2"))
			{	
				System.out.print("\nPlease enter the course name you want to add student to: ");
				String course = in.next();
				int checklist = 0;
				for (int j = 0; j < i ; j++)
				{
					if (courseName[j].equals(course.toUpperCase()))
					{
						System.out.println("A student has been successfully added to the course : " + courseName[j]+
								"-" + courseNumber[j]);
						student[j] ++;
						checklist++;
					}
				}
				if (checklist == 0)
					System.out.println("Course name : " + course.toUpperCase() + " is inexistent in the list of courses.");
					
				System.out.print("\nKindly keep entering a valid choice from the menu: ");
				choice=in.next();
			}
			
			if (choice.equals("3"))
			{
				System.out.println("\nPlease enter a NEW list of courses to add to the ACSD: ");
				line = in.next();
				
				while(line.contains("-"))
				{
					if(line.length()>10)
					{
						int index2 = line.indexOf("-");
						courseName[i] = line.substring(0,index2).toUpperCase();
						courseNumber[i] = line.substring(index2+1,10);
						line = line.substring(11);
					}
					
					else if (line.length() == 10)
					{
						courseName[i] = line.substring(0,6).toUpperCase();
						courseNumber[i] = line.substring(7);
						line = line.substring(line.length());
					}
					i++;
				}
				System.out.println("Successfully added a NEW set of courses to Concordia ACSD Exam Registration (CAERP). ");
				System.out.print("\nKindly keep entering a valid choice from the menu: ");
				choice=in.next();
			}
			
			if (choice.equals("4"))
			{
				for (int j = 0; j < i; j++)
				{
					for (int k = j+1; k < i; k++)
					{
						if (student[j] < student[k])
						{
							int temp1 = student [j];
							student[j] = student[k];
							student[k] = temp1;
							
							String temp2 = courseName[j];
							courseName[j] = courseName[k];
							courseName[k] = temp2;
							
							String temp3 = courseNumber[j];
							courseNumber[j] = courseNumber[k];
							courseNumber[k] = temp3;
						}
						else if (student[j] == student[k])
						{
							if (courseNumber[j].compareTo(courseNumber[k]) < 0)
							{
								String temp2 = courseName[j];
								courseName[j] = courseName[k];
								courseName[k] = temp2;
								
								String temp3 = courseNumber[j];
								courseNumber[j] = courseNumber[k];
								courseNumber[k] = temp3;
							}
						}
					}
				}
				System.out.println("============================================");
				System.out.println("| Rank | #students | Course Name - Number|");
				System.out.println("============================================");
				
				for(int rank = 1, j = 0; j < i;j++)
				{
					if (student[j] > student [j+1])
					{
						System.out.println("|    " + rank + " |        " + student[j] + 
								"  |  " + courseName[j] + " - " + courseNumber[j] + "        |" );
						rank++;
					}
					else {
						System.out.println("|    " + rank + " |        " + student[j] + 
								"  |  " + courseName[j] + " - " + courseNumber[j] + "        |" );
					}
				}
				System.out.println("============================================");
				System.out.print("\nKindly keep entering a valid choice from the menu: ");
				choice=in.next();
			}
			
		}
		// Finally, if user enter "0", kindly terminate the execution of CAERP with a compliment- close message;
		if (choice.equals("0"))
		{
			System.out.println("\nThank you for using Concordia CAERP Exam Registration Program!");
		}
		// Close Scanner
		in.close();
	}
}
