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

		double ret;

		//create all testing date
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);

		Date[] dateList;
		dateList = new Date[24];
		for (int i = 0; i < 24; ++i) {
			cal.set(2017 + i / 12, i % 12, 1);
			dateList[i] = cal.getTime();
		}

		//create polymorphic array account list
		Account[] accountList;
		accountList = new Account[4];
		accountList[0] = new CheckingAccount("John Smith", 1500.0, dateList[0]);
		accountList[1] = new SavingAccount("William Hurt", 1200.0, dateList[0]);
		accountList[2] = new CDAccount("Woody Allison", 1000.0, dateList[0]);
		accountList[3] = new LoanAccount("Judi Foster", -1500.0, dateList[0]);

		System.out.println("\n<Account Information>\n");

		for (int i = 0; i < 4; i++) {
			System.out.println("Open Date: " + accountList[i].openDate);
			System.out.println("Account <" + accountList[i].name() + "> now has $" + accountList[i].balance() + " balance\n");
		}

		System.out.println("\n<Checking Account>\n");

		System.out.println("<---- withdraw $400 from checking account for 2 times ---->");
		for (int i = 0; i < 2; ++i) {
			try {
				System.out.println("Date: " + dateList[1]);
				ret = accountList[0].withdraw(400.0, dateList[1]);
				System.out.println("Account <" + accountList[0].name() + "> withdraws $400.0");
				System.out.println("Account <" + accountList[0].name() + "> now has $" + ret + " balance\n");
			}
			catch (Exception e) {
				stdExceptionPrinting(e, accountList[0].balance());
			}
		}

		System.out.println("<---- deposit $400 into checking account ---->");
		try {
			System.out.println("Date: " + dateList[1]);
			ret = accountList[0].deposit(400.0, dateList[1]);
			System.out.println("Account <" + accountList[0].name() + "> now deposits $400.0");
			System.out.println("Account <" + accountList[0].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[0].balance());
		}

		System.out.println("\n<Saving Account>\n");

		System.out.println("<---- deposit $100 into saving account for 4 times in March 2017 ---->");
		for (int i = 0; i < 4; ++i) {
			try {
				System.out.println("Date: " + dateList[2]);
				ret = accountList[1].deposit(100.0, dateList[2]);
				System.out.println("Account <" + accountList[1].name() + "> deposits $100.0");
				System.out.println("Account <" + accountList[1].name() + "> now has $" + ret + " balance\n");
			}
			catch (Exception e) {
				stdExceptionPrinting(e, accountList[1].balance());
			}
		}

		System.out.println("<---- withdraw $500 from saving account for 4 times in April 2017 ---->");
		for (int i = 0; i < 4; ++i) {
			try {
				System.out.println("Date: " + dateList[3]);
				ret = accountList[1].withdraw(500.0, dateList[3]);
				System.out.println("Account <" + accountList[1].name() + "> withdraws $500.0");
				System.out.println("Account <" + accountList[1].name() + "> now has $" + ret + " balance\n");
			}
			catch (Exception e) {
				stdExceptionPrinting(e, accountList[1].balance());
			}
		}

		System.out.println("\n<CD Account>\n");

		System.out.println("<---- withdraw $300 from CD Account for 2 times in May 2017 (Still within 12 months) ---->");
		for (int i = 0; i < 2; ++i) {
			try {
				System.out.println("Date: " + dateList[4]);
				ret = accountList[2].withdraw(300.0, dateList[4]);
				System.out.println("Account <" + accountList[2].name() + "> withdraws $300.0");
				System.out.println("Account <" + accountList[2].name() + "> now has $" + ret + " balance\n");
			}
			catch (Exception e) {
				stdExceptionPrinting(e, accountList[2].balance());
			}
		}

		System.out.println("<---- deposit $300 into CD Account ---->");
		try {
			System.out.println("Date: " + dateList[4]);
			ret = accountList[2].deposit(300.0, dateList[4]);
			System.out.println("Account <" + accountList[2].name() + "> deposits $300.0");
			System.out.println("Account <" + accountList[2].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[2].balance());
		}

		System.out.println("\n<Loan Account>\n");

		System.out.println("<---- withdraw $300 from Loan Account ---->");
		try {
			System.out.println("Date: " + dateList[5]);
			ret = accountList[3].withdraw(300.0, dateList[5]);
			System.out.println("Account <" + accountList[3].name() + "> withdraws $300.0");
			System.out.println("Account <" + accountList[3].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[3].balance());
		}

		System.out.println("<---- deposit $300 into Loan Account ---->");
		try {
			System.out.println("Date: " + dateList[5]);
			ret = accountList[3].deposit(300.0, dateList[5]);
			System.out.println("Account <" + accountList[3].name() + "> deposits $300.0");
			System.out.println("Account <" + accountList[3].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[3].balance());
		}

		System.out.println("\n<Compute Interest>\n");

		System.out.println("<---- compute interest for all accounts in July 2017 ---->");
		for (int i = 0; i < 4; ++i) {
			try {
				System.out.println("Date: " + dateList[6]);
				double newBalance = accountList[i].computeInterest(dateList[6]);
				System.out.println("Account <" + accountList[i].name() + "> now has $" + newBalance + " balance\n");
			}
			catch (Exception e) {
				stdExceptionPrinting(e, accountList[i].balance());
			}
		}

		System.out.println("<---- compute interest for all accounts in July 2018 ---->");
		for (int i = 0; i < 4; ++i) {
			try {
				System.out.println("Date: " + dateList[18]);
				double newBalance = accountList[i].computeInterest(dateList[18]);
				System.out.println("Account <" + accountList[i].name() + "> now has $" + newBalance + " balance\n");
			}
			catch (Exception e) {
				stdExceptionPrinting(e, accountList[i].balance());
			}
		}

		System.out.println("<---- compute interest for all accounts in Jan 2018 ---->");
		for (int i = 0; i < 4; ++i) {
			try {
				System.out.println("Date: " + dateList[13]);
				double newBalance = accountList[i].computeInterest(dateList[13]);
				System.out.println("Account <" + accountList[i].name() + "> now has $" + newBalance + " balance\n");
			}
			catch (Exception e) {
				stdExceptionPrinting(e, accountList[i].balance());
			}
		}

		System.out.println("\n<Special Case>\n");

		System.out.println("<---- withdraw $300 from CD account after 12 months since Jan 2017 ---->");
		try {
			System.out.println("Date: " + dateList[12]);
			ret = accountList[2].withdraw(300.0, dateList[12]);
			System.out.println("Account <" + accountList[2].name() + "> withdraws $300.0");
			System.out.println("Account <" + accountList[2].name() + "> now has $" + ret + " balance\n");
		}
		catch (Exception e) {
			stdExceptionPrinting(e, accountList[2].balance());
		}
	}

	static void stdExceptionPrinting(Exception e, double balance) {
		System.out.println("EXCEPTION: Banking system throws a " + e.getClass() +
				" with message: \n\t" +
				"MESSAGE: " + e.getMessage());
		System.out.println("\tAccount balance remains $" + balance + "\n");
	}
}
