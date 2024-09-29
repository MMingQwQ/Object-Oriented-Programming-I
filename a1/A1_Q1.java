// -------------------------------------------------------------------- 
// Assignment 1
// Written by: Mingming Zhang
// For COMP 248 Section (EC) – Winter 2023
// --------------------------------------------------------------------

// -------------------------------------------------------------------- 
// Crpto Change Program is a program that determines the change to be 
// given by a 3rd millennium scalper selling tickets to a grimvalor game.
// In this program, user will use the crypto coins of the forthcoming 
// millennium (year 2050- 3000): Pesico, Bitom, Ditom, Zitom and Cryptom.
// A Pesico coin will be the largest denomination. 
// 7500 Cryptom coins will be equivalent to 1 Pesico.
// 500 Cryptom coins will be equivalent to 1 Bitom. 
// 200 Cryptom coins will be equivalent to 1 Ditom. 
// 50 Cryptom coins will be equivalent to 1 Zitom.

// The program display the welcome message, then prompt users for the price of ticket.
// Then calculate the change by using Pesico minus the price of ticket. 
// Then use that change to compute the amount of each type of coins by maximizing 
// larger denominations. And then, display the result with the order of Bitom,
//  Ditom, Zitom, and Cryptom. Finally display closing message.

// Created: Sun Jan 29 2023
// Author: Mingming Zhang
// --------------------------------------------------------------------

import java.util.Scanner;
public class A1_Q1 {

	public static void main(String[] args) {
		// Variable and constant declarations
		// These constants represent the exchange rate between Cryptom and each other type of coins
		final int pesico = 7500;
		final int bitom = 500;
		final int ditom = 200;
		final int zitom = 50;
		final int cryptom = 1;
		
		int num_bitom = 0;
		int num_ditom = 0;
		int num_zitom = 0;
		int num_cryptom = 0;
		int change = 0;
		int priceOfTicket = 0;
		
		Scanner keyIn = new Scanner(System.in);
		
		// Display a welcome message
		System.out.println("Welcome to the Crypto Change Program:");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// Prompt the user for input and assign the value to price
		System.out.print("Enter the price of the ticket in Cryptom(at most 7500): ");
		priceOfTicket = keyIn.nextInt();
		
		// Compute the total amount of change
		change = pesico - priceOfTicket;
		
		// Compute the number of bitom and store the remainder as new change
		num_bitom = change / bitom;
		change %= bitom;
		
		// Compute the number of ditom and store the remainder as new change
		num_ditom = change / ditom;
		change %= ditom;
		
		// Compute the number of zitom and store the remainder as new change
		num_zitom = change / zitom;
		change %= zitom;
		
		// Compute the number of cryptom
		num_cryptom = change / cryptom;
		change %= cryptom;
		
		// Output the result
		System.out.println();
		System.out.println("You bought a ticket for " + priceOfTicket + " Cryptom. "
				+ "and gave me a Pesico, so your change is");
		System.out.println(num_bitom + " Bitom,");
		System.out.println(num_ditom + " Ditom,");
		System.out.println(num_zitom + " Zitom, and");
		System.out.println(num_cryptom + " Cryptom.\n\n\nThank you for using my bespoke Crypto Change Program!"
				+ "\n\nEngjoy the Game!");
		
		// Close the scanner
		keyIn.close();
	}

} // CryptomChangeProgram
