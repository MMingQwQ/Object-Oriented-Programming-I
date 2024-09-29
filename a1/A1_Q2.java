// -------------------------------------------------------------------- 
// Assignment 1
// Written by: Mingming Zhang
// For COMP 248 Section (EC) – Winter 2023
// --------------------------------------------------------------------

// -------------------------------------------------------------------- 
// Concordia Office of Community Engagement will lunch a movie theater project 
// that will screen movies which ended their run at theaters for a reduced ticket price of $6.99. 
// The cinema will accept only prepaid gift card. 

// This program is to generate an invoice with correct output according to users input.
// First of all, the program display the welcome message, then prompt for the
// gift card retailer name, and the gift card amount in order to compute the maximum
// amount of tickets they could buy and the balance. (display them)
// Then ask user for the amount of ticket they want to buy, then calculate the costs and 
// the remaining balance. (display them) 
// Then prompt user for day, month, year to get all info in order to generate the whole invoice.
// Finally display the invoice and the closing message. 

// Created: Sun Jan 29 2023
// Author: Mingming Zhang
// --------------------------------------------------------------------

import java.util.Scanner;
public class A1_Q2 {

	public static void main(String[] args) {
		// Variable and constant declarations
		final double priceOfTicket = 6.99;
		
		Scanner keyIn = new Scanner(System.in);
		String  cardRetailerName;
		
		int numOfTicket;
		int maxNumOfTicket;
		int day;
		int month;
		int year;
		
		double giftCardAmount;
		double costs;
		double minBalance;
		double balance; 
		
		// Display a welcome message
		System.out.println("Welcome to the Simple Cinema Tickets Invoice Program: ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// Prompt user to enter the gift card retailer/bank name and store the value
		System.out.print("Enter the prepaid gift card retailer/bank name: ");
		cardRetailerName = keyIn.nextLine().toUpperCase();
		
		System.out.println("You will be using " + cardRetailerName  
				+ " gift card for your ticket(s) purchase.");
		
		// Prompt user to enter the gift card amount and store the value
		System.out.print("Enter the amount on the gift card: ");
		giftCardAmount = keyIn.nextDouble();
		System.out.println("There is a fund of $" + giftCardAmount 
				+ " on your prepaid " + cardRetailerName + " gift card.");
		
		// Calculate the max number of ticket that user can buy and the balance
		// then output the result
		maxNumOfTicket = (int) (giftCardAmount / priceOfTicket);
		minBalance = giftCardAmount - (maxNumOfTicket * priceOfTicket);
		
		System.out.print("Using your " + cardRetailerName + " gift card"
				+ " you can purchase " + maxNumOfTicket + " tickets and"
				+ " have a balance of $");
		System.out.printf("%.2f",minBalance);
		System.out.println(" on the gift card." );
		
		// Prompt user to enter the amount of tickets user wants to buy and store the value
		System.out.print("Enter the number of tickets you want to purchase: ");
		numOfTicket = keyIn.nextInt();
		
		// Calculate the costs and the balance, then output the result
		costs = numOfTicket * priceOfTicket;
		balance = giftCardAmount - costs;
		
		System.out.print("The purchase of " + numOfTicket + " ticket(s)"
				+ " costs $");
		System.out.printf("%.2f",costs);
		System.out.println(".");
		
		System.out.print("The balance left on your " + cardRetailerName 
				+ " gift card is $");
		System.out.printf("%.2f",balance);
		System.out.println(".\n");
		
		//Prompt user for day, month, year and store the values
		System.out.println("Please enter your purchase info: \n");
		System.out.print("Day Of purchase (between 1 and 31): ");
		day = keyIn.nextInt();
		System.out.print("Month Of purchase (between 1 and 12): ");
		month = keyIn.nextInt();
		System.out.print("Year Of purchase (between 2023 and 2028): ");
		year = keyIn.nextInt();
		
		// Print the whole invoice
		System.out.println("__________________________________________________________________");
		System.out.println("                   Cinema Concordia         " + day 
				+ "/" + month + "/" + year + "                   \n\n" );
		
		System.out.println("__________________________________________________________________");
		System.out.print(numOfTicket + " Tickets                                                   $" );
		System.out.printf("%.2f",costs);
		System.out.println();
		
		System.out.print("$");
		System.out.printf("%.2f",costs);
		System.out.println(" was redeemed from " + cardRetailerName + " prepayed gift card.");
		
		System.out.print(cardRetailerName + " gift card balance                                $");
		System.out.printf("%.2f",balance);
		System.out.println();
		
		System.out.println("__________________________________________________________________");
		System.out.println("Invoice generated successfully.\n\n");
		System.out.println("Thank you for using my bespoke Cinema Tickets Invoice Program!");
		
		// Close the scanner
		keyIn.close();
	}

}// CinemaTicketsInvoiceProgram
