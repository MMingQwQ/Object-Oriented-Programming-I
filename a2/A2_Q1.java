// -------------------------------------------------------------------- 
// Assignment 2 Q1
// Written by: Mingming Zhang 
// For COMP 248 Section (EC) – Winter 2023
// --------------------------------------------------------------------

/*
 * Algorithm 1: Static Latency Computer
 * Created: Sat Feb 11 2023
 * Author: Mingming Zhang
 * 
 * Purpose: Contribute to Project-S by processing all user's inputs (bandwidth, 
 * valid source IP address, valid destination IP address, transmitted format data amount) 
 * to compute the latency in milliseconds (ms) that is incurred from transmitting 
 * the predefined quantity of data from the source IP address to the destination 
 * IP address over the defined network (communication) channel.
 * 
 * Algorithm:
 * 1. Display a welcome message to the user of the program;
 * 2. Prompt users to enter the bandwidth of a given communication channel and do error check;
 * 3. Prompt users for source IP address and do error check;
 * 4. Prompt users for destination IP address and do error check;
 * 5. Prompt users for transmitted format data amount and do error check;
 * 6. Compute the latency;
 * 7. Display the latency result;
 * 8. Display a complimentary-close message
 * (More details as comments in code below)
 */

// Import
import java.util.Scanner;
public class A2_Q1 {

	public static void main(String[] args) {
		// Constant and variable declarations; 
		String bandwidth;
		double n1;		// n1 represents the number value of bandwidth;
		double x = 0;		// x represents the prefix quantifier of bandwidth;
		
		String dataAmount;
		double n2;		// n2 represents the number value of the data amount;
		double y = 0; 		// y represents the prefix quantifier of the data amount;
		
		int sourceIP1, sourceIP2, sourceIP3, sourceIP4 ;   //source IP
		int destinationIP1, destinationIP2, destinationIP3, destinationIP4;   //destination IP
		double latency;
		
		final int s = 1000; 	// 1s = 1000ms (milliseconds);
		
		final int BYTE = 8; 	// 1 byte = 8 bits;
		
		// Prefixes of Quantifiers;
		final double Kilo = Math.pow(2,10);   // 1 Kilo (1 K) = 2^10;
		final double Mega = Math.pow(2,20);   // 1 Mega (1 M) = 2^20;
		final double Giga = Math.pow(2,30);   // 1 Giga (1 G) = 2^30;
		final double Tera = Math.pow(2,40);   // 1 Tera (1 T) = 2^40;
		final double Peta = Math.pow(2,50);   // 1 Peta (1 P) = 2^50;
		final double Exa = Math.pow(2,60);    // 1 Exa (1 E) = 2^60;
		final double Zetta = Math.pow(2,70);  // 1 Zetta (1 Z) = 2^70; 
		final double Yotta = Math.pow(2,80);  //1 Yotta (1 Y) = 2^80.
		
		Scanner in = new Scanner(System.in);
		
		// Display a welcome message to the user of the program;
		System.out.println("Welcome to the Static Latency-Computer Program:");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		
		// Display a prompt message for the user to enter the bandwidth;
		System.out.print("Please enter the bandwidth, in {n}{x}bps format, for the network link: ");
		bandwidth = in.next();
		
		boolean b1 = bandwidth.substring(bandwidth.length()-3).equals("bps");  //Check "bps" is lower case;
		
		// Q1 stores prefix quantifier of bandwidth;
		String Q1 = bandwidth.substring(bandwidth.length()-4, bandwidth.length()-3); 
		
		// Q2 stores prefix quantifier of bandwidth in Upper Case version;
		String Q2 = bandwidth.substring(bandwidth.length()-4, bandwidth.length()-3).toUpperCase();
		
		boolean b2 = Q1.equals(Q2); // Check prefix quantifier is Upper Case;
		if (b1 && b2)
		{
			// Prompt user for source IP address;
			System.out.print("Please enter the source IP address: ");
			
			// Based on instruction and samples: 
			// Check user inputs are all integer by using Nested-if statement;
			if (in.hasNextInt()) 
			{
				sourceIP1 = in.nextInt();
				
				if (in.hasNextInt())
				{
					sourceIP2 = in.nextInt();
					
					if(in.hasNextInt())
					{
						sourceIP3 = in.nextInt();
						
						if(in.hasNextInt())
						{
							sourceIP4 = in.nextInt();
							
							boolean s1 = sourceIP1 >= 0 && sourceIP1 <= 255; // Check the validity of sourceIP1: {0 to 255};
							boolean s2 = sourceIP2 >= 0 && sourceIP2 <= 255; // Check the validity of sourceIP2: {0 to 255};
							boolean s3 = sourceIP3 >= 0 && sourceIP3 <= 255; // Check the validity of sourceIP3: {0 to 255};
							boolean s4 = sourceIP4 >= 0 && sourceIP4 <= 255; // Check the validity of sourceIP4: {0 to 255};
							
							if (s1 && s2 && s3 && s4)
							{
								// Prompt user for destination IP address;
								System.out.print("Please enter the destination IP address: ");
								
								// Based on instruction and samples: 
								// Check user inputs are all integer by using Nested-if statement;
								if (in.hasNextInt())
								{
									destinationIP1 = in.nextInt();
									
									if (in.hasNextInt())
									{
										destinationIP2 = in.nextInt();
										
										if (in.hasNextInt())
										{
											destinationIP3 = in.nextInt();
											
											if (in.hasNextInt())
											{
												destinationIP4 = in.nextInt();
												
												boolean d1 = destinationIP1 >= 0 && destinationIP1 <= 255; // Check the validity of destinationIP1: {0 to 255};
												boolean d2 = destinationIP2 >= 0 && destinationIP2 <= 255; // Check the validity of destinationIP2: {0 to 255};
												boolean d3 = destinationIP3 >= 0 && destinationIP3 <= 255; // Check the validity of destinationIP3: {0 to 255};
												boolean d4 = destinationIP4 >= 0 && destinationIP4 <= 255; // Check the validity of destinationIP4: {0 to 255};
												
												if (d1 && d2 && d3 && d4)
												{
													// Prompt user for transmitted format data amount;
													System.out.print("Please enter data amount, in {n}{y}B format, for transmission over the network link: ");
													dataAmount = in.next();
													
													boolean t1 = dataAmount.substring(dataAmount.length()-1).equals("B"); // Check "B" is Upper Case;
													
													// Q3 stores prefix quantifier of the data amount;
													String Q3 = dataAmount.substring(dataAmount.length()-2, dataAmount.length()-1);
													
													// Q4 stores prefix quantifier of the data amount in Upper Case version;
													String Q4 = dataAmount.substring(dataAmount.length()-2, dataAmount.length()-1).toUpperCase();
													
													boolean t2 = Q3.equals(Q4);  // Check prefix quantifier is Upper Case;
													
													if (t1 && t2)
													{
														// Get the number value of bandwidth in String format;
														String num1 = bandwidth.substring(0, bandwidth.length()-4);
														
														// Convert String to Double;
														n1 = Double.parseDouble(num1);
														
														// Get the number value of data amount in String format;
														String num2 = dataAmount.substring(0, dataAmount.length()-2);
														
														// Convert String to Double;
														n2 = Double.parseDouble(num2);
														
															
														// Check the value of prefix quantifier of bandwidth;
														switch (Q1) 
														{
															case "K": x = Kilo;  break;
															case "M": x = Mega;  break;
															case "G": x = Giga;  break;
															case "T": x = Tera;  break;
															case "P": x = Peta;  break;
															case "E": x = Exa;   break;
															case "Z": x = Zetta; break;
															case "Y": x = Yotta; break;
														}
														
														// Check the value of prefix quantifier of data amount;
														switch (Q3) 
														{
															case "K": y = Kilo;  break;
															case "M": y = Mega;  break;
															case "G": y = Giga;  break;
															case "T": y = Tera;  break;
															case "P": y = Peta;  break;
															case "E": y = Exa;   break;
															case "Z": y = Zetta; break;
															case "Y": y = Yotta; break;
														}
														
														// Compute the latency:
														// latency =[Data amount * 8 (convert to bits) * 1000 (convert to ms)] / Bandwidth;
														latency = (n2 * y * BYTE * s) / (n1 * x);
														
														// Display the latency result;
														System.out.println("Latency (" + sourceIP1 + "." + sourceIP2 + "." + sourceIP3 + "." + sourceIP4 
																+ " --> " + destinationIP1 + "." + destinationIP2 + "." + destinationIP3 + "." + destinationIP4 
																+ ") = " + latency + "ms");
													}
													else // Display error messages accordingly;
													{
														System.out.println("Invalid input for the amount of data; "
																+ "please retry with the data amount in {n}{y}B format.");
													}
												}
												else
												{
													System.out.println("Error: Your entry for destination IP address is incorrect."
															+ " Kindly retry with valid inputs.");	
												}
											}
											else
											{
												System.out.println("Error: Your entry for destination IP address is incorrect."
														+ " Kindly retry with valid inputs.");
											}
										}
										else
										{
											System.out.println("Error: Your entry for destination IP address is incorrect."
													+ " Kindly retry with valid inputs.");
										}
									}
									else
									{
										System.out.println("Error: Your entry for destination IP address is incorrect."
												+ " Kindly retry with valid inputs.");
									}
								}
								else
								{
									System.out.println("Error: Your entry for destination IP address is incorrect."
											+ " Kindly retry with valid inputs.");
								}
							}
							else
							{
								System.out.println("Error: Your entry for source IP address is incorrect."
										+ " Kindly retry with valid inputs.");
							}
							
						}
						else
						{
							System.out.println("Error: Your entry for source IP address is incorrect."
									+ " Kindly retry with valid inputs.");
						}
					}
					else
					{
						System.out.println("Error: Your entry for source IP address is incorrect."
								+ " Kindly retry with valid inputs.");
					}
				}
				else
				{
					System.out.println("Error: Your entry for source IP address is incorrect."
							+ " Kindly retry with valid inputs.");
				}
			}
			else
			{
				System.out.println("Error: Your entry for source IP address is incorrect."
						+ " Kindly retry with valid inputs.");
			}
		}
		else
		{
			System.out.println("Invalid input for bandwidth; "
					+ "please re-run and enter the bandwidth in {n}{x}bps format.");
		}
				
		// Display a complimentary-close message;
		System.out.println();
		System.out.print("Thank you for your contribution to Project-S.");
		
		// Close Scanner;
		in.close();
	}
}