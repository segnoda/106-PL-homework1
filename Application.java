/*****************************************************************
  CS4001301 Programming Languages

  Programming Assignment #1

  Java programming using subtype, subclass, and exception handling

  To compile: %> javac Application.java

  To execute: %> java Application

 ******************************************************************/

import java.util.*;

public class Application {

	public static void main( String args []) {
		/*
		Account a;
		Date d;
		double ret;

		a = new CheckingAccount("John Smith", 1500.0);

		try {
			ret = a.withdraw(500.00);
			System.out.println ("Account <" + a.name() + "> now has $" + ret + " balance\n");
		} catch (Exception e) {
			stdExceptionPrinting(e, a.balance());
		}

		a = new CheckingAccount("John Smith", 1500.0);

		try {
			ret = a.withdraw(600.00);
			System.out.println ("Account <" + a.name() + "> now has $" + ret + " balance\n");
		} catch (Exception e) {
			stdExceptionPrinting(e, a.balance());
		}
		*/

		/* put your own tests here ....... */
		/* if your implementaion is correct, you can do the following with polymorphic array accountList
		   public Account[] accountList;

		   accountList = new Account[4];

		// buid 4 different accounts in the same array
		accountList[0] = new CheckingAccount("John Smith", 1500.0);
		accountList[1] = new SavingAccount("William Hurt", 1200.0);
		accountList[2] = new CDAccount("Woody Allison", 1000.0);
		accountList[3] = new LoanAccount("Judi Foster", -1500.0);

		// compute interest for all accounts
		for (int count = 0; count < accountList.length; count++) {
		double newBalance = accountList[count].computeInterest();
		System.out.println ("Account <" + a.name() + "> now has $" + newBalance + " balance\n");
		}
		*/

		double ret;

		//get current time
		Date currentTime = new Date();

		// create polymorphic array account list
		Account[] accountList;
		accountList = new Account[4];
		accountList[0] = new CheckingAccount("Rem", 1500.0);
		accountList[1] = new SavingAccount("", 1200.0);
		accountList[2] = new CDAccount("", 1000.0);
		accountList[3] = new LoanAccount("", -1500.0);

		//withdraw $400 from checking account
		try {
			System.out.println("Data: " + currentTime);
			ret = accountList[0].withdraw(400.0);
			System.out.println("Account <" + accountList[0].name() + "> withdraws $400.0");
			System.out.println("Account <" + accountList[0].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[0].balance());
		}

		//withdraw $400 from checking account
		try {
			System.out.println("Data: " + currentTime);
			ret = accountList[0].withdraw(400.0);
			System.out.println("Account <" + accountList[0].name() + "> now withdraws $400.0");
			System.out.println("Account <" + accountList[0].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[0].balance());
		}

		//deposit $400 into checking account
		try {
			System.out.println("Data: " + currentTime);
			ret = accountList[0].deposit(400.0);
			System.out.println("Account <" + accountList[0].name() + "> now deposits $400.0");
			System.out.println("Account <" + accountList[0].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[0].balance());
		}
	}

	static void stdExceptionPrinting(Exception e, double balance) {
		System.out.println("EXCEPTION: Banking system throws a " + e.getClass() +
				" with message: \n\t" +
				"MESSAGE: " + e.getMessage());
		System.out.println("\tAccount balance remains $" + balance + "\n");
	}
}
