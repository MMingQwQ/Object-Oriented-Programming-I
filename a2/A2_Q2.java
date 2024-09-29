// -------------------------------------------------------------------- 
// Assignment 2 Q2
// Written by: Mingming Zhang
// For COMP 248 Section (EC) – Winter 2023
// --------------------------------------------------------------------

/*
 * Algorithm 2: Dynamic Latency Computer
 * Created: Sat Feb 11 2023
 * Author: Mingming Zhang
 * 
 * Purpose: According to users inputs [WEEKDAY(Monday to Sunday), 
 * MODES (bandwidth or latency), DATA QUANTITY] to determine 
 * which MODE formula to compute the latency 
 * incurred in transferring a given quantity of data between 
 * any two (2) given nodes within the Project-S. 
 * 
 * Algorithm:
 * 1. Display a welcome message to the user of the program;
 * 2. Display a prompt message for the user to enter the Weekday, the Mode, and Data Quantity;
 * 3. Do the error check of each element;
 * 4. Process user inputs (case-insensitive) to determine the corresponding real value 
 *    in either Bandwidth mode or latency mode and the real value of data quantity 
 *    by using switch() statement;
 * 5. Compute the latency accordingly;
 * 6. Display the latency result;
 * 7. Display a complimentary-close message;
 * (More details as comments in code below)
 */

// Import
import java.util.Scanner;
public class A2_Q2 {

	public static void main(String[] args) {
		// constants and variables declaration
		// Prefixes of Quantifiers
		final double M = Math.pow(2,20);   // 1 Mega (1 M) = 2^20;
		final double G = Math.pow(2,30);   // 1 Giga (1 G) = 2^30;
		final double T = Math.pow(2,40);   // 1 Tera (1 T) = 2^40;
		final double P = Math.pow(2,50);   // 1 Peta (1 P) = 2^50;
		final double E = Math.pow(2,60);    // 1 Exa (1 E) = 2^60;
		final double Z = Math.pow(2,70);  // 1 Zetta (1 Z) = 2^70; 
		final double Y = Math.pow(2,80);  //1 Yotta (1 Y) = 2^80.
		
		final double bandwidth1 = 999 * M;  // Monday Bandwidth = 999Mbps;
		final double bandwidth2 = 0.9 * Y;  // Tuesday Bandwidth = 0.9Ybps;
		final double bandwidth3 = 10 * G;   // Wednesday Bandwidth = 10Gbps;
		final double bandwidth4 = 2.5 * T;  // Thursday Bandwidth = 2.5Tbps;
		final double bandwidth5 = 0.9 * P;  // Friday Bandwidth = 0.9Pbps;
		final double bandwidth6 = 1.1 * E;  // Saturday Bandwidth = 1.1Ebps;
		final double bandwidth7 = 1.5 * Z;  // Sunday Bandwidth = 1.5Zbps;
		
		final double latency1 = 8.0 * Math.pow(10,-6);  // Monday latency = 8.0 * 10^-6ms;
		final double latency2 = 8.8 * Math.pow(10,-21);  // Tuesday latency = 8.8 * 10^-21ms;
		final double latency3 = 8.0 * Math.pow(10,-7);  // Wednesday latency = 8.0 * 10^-7ms;
		final double latency4 = 3.2 * Math.pow(10,-10);  // Thursday latency = 3.2 * 10^-10ms;
		final double latency5 = 8.8 * Math.pow(10,-12);  // Friday latency = 8.8 * 10^-12ms;
		final double latency6 = 7.2 * Math.pow(10,-15);  // Saturday latency = 7.2 * 10^-15ms;
		final double latency7 = 5.3 * Math.pow(10,-18);  // Sunday latency = 5.3 * 10^-18ms;
		
		final int S = 1000;   // 1s = 1000ms (milliseconds);
		final int B = 8; 	// 1 byte = 8 bits;
		
		double n1 = 0;  // n1 represents the value of bandwidth or latency
		
		double n2 = 0; // n2 represents the value of the transmitted data
		
		double latency = 0; 
		
		String weekday;
		String mode;
		String dataQuantity;
		
		Scanner in = new Scanner(System.in);
		// Display a welcome message to the user of the program;
		System.out.println("Welcome to the Dynamic Latency-Computer Program: ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		// Display a prompt message for the user to enter the Weekday, the Mode, and Data Quantity
		System.out.print("Please enter a Weekday, Mode, and Data Quantity, respectively: ");
		weekday = in.next();
		mode = in.next();
		dataQuantity = in.next();
		
		// Check the validity of modes
		boolean m1 = mode.equalsIgnoreCase("bandwidth");
		boolean m2 = mode.equalsIgnoreCase("latency");
		
		if (m1 || m2)
		{
			// Check the validity of weekdays
			boolean w1 = weekday.equalsIgnoreCase("Monday");
			boolean w2 = weekday.equalsIgnoreCase("Tuesday");
			boolean w3 = weekday.equalsIgnoreCase("Wednesday");
			boolean w4 = weekday.equalsIgnoreCase("Thursday");
			boolean w5 = weekday.equalsIgnoreCase("Friday");
			boolean w6 = weekday.equalsIgnoreCase("Saturday");
			boolean w7 = weekday.equalsIgnoreCase("Sunday");
			
			
			if (w1 || w2 || w3 || w4 || w5 || w6 || w7)
			{
				// Check the validity of Data Quantity
				boolean d1 = dataQuantity.equalsIgnoreCase("10GB");
				boolean d2 = dataQuantity.equalsIgnoreCase("20PB");
				boolean d3 = dataQuantity.equalsIgnoreCase("30ZB");
				
				if (d1 || d2 || d3)
				{
					switch(weekday.toUpperCase()) // Check the value of weekday by using switch();
					{
						case "MONDAY": 
							switch(mode.toUpperCase()) // Check the value of mode by using switch();
							{
								case "BANDWIDTH": n1 = bandwidth1; break;
								case "LATENCY" : n1 = latency1; break;
							}
						break;
						
						case "TUESDAY":
							switch(mode.toUpperCase())
							{
								case "BANDWIDTH": n1 = bandwidth2; break;
								case "LATENCY" : n1 = latency2; break;
							}
						break;
						
						case "WEDNESDAY":
							switch(mode.toUpperCase())
							{
								case "BANDWIDTH": n1 = bandwidth3; break;
								case "LATENCY" : n1 = latency3; break;
							}
						break;
						
						case "THURSDAY":
							switch(mode.toUpperCase())
							{
								case "BANDWIDTH": n1 = bandwidth4; break;
								case "LATENCY" : n1 = latency4; break;
							}
						break;
						
						case "FRIDAY":
							switch(mode.toUpperCase())
							{
								case "BANDWIDTH": n1 = bandwidth5; break;
								case "LATENCY" : n1 = latency5; break;
							}
						break;
						
						case "SATURDAY":
							switch(mode.toUpperCase())
							{
								case "BANDWIDTH": n1 = bandwidth6; break;
								case "LATENCY" : n1 = latency6; break;
							}
						break;
						
						case "SUNDAY":
							switch(mode.toUpperCase())
							{
								case "BANDWIDTH": n1 = bandwidth7; break;
								case "LATENCY" : n1 = latency7; break;
							}
						break;
					}
					
					switch(dataQuantity.toUpperCase()) // Check the value of Data Quantity by using switch();
					{
						case "10GB": n2 = 10 * G * B; break; // convert to bits
						case "20PB": n2 = 20 * P * B; break;
						case "30ZB": n2 = 30 * Z * B; break;
					}
					
					// Check the value of mode to decide which formula to use and compute the latency;
					if (n1 > 1) // n1 is bandwidth mode;
						latency = (n2 * S) / n1; // Bandwidth mode: latency = [Data quantity * 1000 (convert to ms)] / Bandwidth;
					
					else // n1 is latency mode;
						// According to instruction: "With regard to a microwave communication link on the Project-S network, 
						// the tabular data below defines the daily standard bandwidth and the daily (10 Gigabytes of data) latency."
						latency = (n2 * n1) / (10 * G * B); // Latency mode: latency = (Data Quantity * daily latency) / 10 GB;
					
					// Display the latency result;
					System.out.printf("Latency incurred in transmitting " + dataQuantity.toUpperCase() + " of data,"
							+ " over Project-S microwave network link, is: %.6fms",latency);
					System.out.println();
					
				}
				else  // Display the error messages;
				{
					System.out.println("Error: Invalid value entered for the 'Data Quantity' variable. Kindly retry with a valid input.");
				}
					
			}
			else
			{
				System.out.println("Error: Invalid value entered for the 'Weekday' variable. Kindly retry with a valid input.");
			}
		}
		else 
		{
			System.out.println("Error: Invalid value entered for the 'Mode' variable. Kindly retry with a valid input.");
		}
		
		
		// Display a complimentary-close message;
		System.out.println();
		System.out.print("Once again, thanks for your contribution to Project-S. ");

		// Close Scanner;
		in.close();
	}

}
