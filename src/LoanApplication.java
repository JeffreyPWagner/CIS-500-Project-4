import java.util.*;

/*****************************************************************
A new loan application in the system

@author Jeffrey Wagner
@version Fall 2018
*****************************************************************/

public class LoanApplication {

	/** loan to be processed */
	 private Loan loan;
	 
	 /** text summary of processed loan */
	 private String summary;
	 
	 /** name of applicant */
	 private String name;
	 
	 /** type of loan */
	 private String type;
	 
	 /** annual interest rate */
	 private double interestRate;
	 
	 /** length in years */
	 private int length;
	 
	 /** amount of loan */
	 private double principle;
	 
	 /** determines if the user would like to process more loans */
	 private boolean moreLoans = true;


	 /*****************************************************************
	 Processes loan based on user input
	 *****************************************************************/
	 public void run() {
		 
		 //gather loan data and store temporarily
		 while (moreLoans) {
			 
			//create scanner to take user input
			 Scanner scnr = new Scanner(System.in);
			 
			 System.out.println("Enter applicant's name");
			 name = scnr.nextLine();
			 System.out.println("Enter the interest rate (ex. 0.03 = 3.00%)");
			 interestRate = scnr.nextDouble();
			 System.out.println("Enter length of the loan in years");
			 length = scnr.nextInt();
			 System.out.println("Enter the amount of the loan in dollars");
			 principle = scnr.nextDouble();
			 System.out.println("Enter SI for simple interest or AL for amortized loan");
			 type = scnr.next();
			 
			 //create appropriate loan
			 if (type.equalsIgnoreCase("SI")) 
				 loan = new SimpleLoan(name, interestRate, length, principle);
			 else if (type.equalsIgnoreCase("AL")) 
				 loan = new AmortizedLoan(name, interestRate, length, principle);
			 else {
				 System.out.println("Invalid loan type, start again");
				 continue;
			 }
			 
			 //process loan and store text representation
			 summary = loan.process();
			 
			 //print processed loan
			 PrintSpooler.getSpooler().printDocument(summary, type);
			 
			 
			 //determine if user would like to process another loan
			 System.out.println("\nProcess another loan? (Y/N)");
			 String keepGoing = scnr.next();
			 
			 while (!keepGoing.equalsIgnoreCase("N") && !keepGoing.equalsIgnoreCase("Y")) {
				 System.out.println("Invalid choice, enter Y or N");
				 keepGoing = scnr.next();
			 }	 
			 if (keepGoing.equalsIgnoreCase("N"))
				 moreLoans = false;
		 }
	 }
}
