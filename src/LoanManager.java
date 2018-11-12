import java.util.*;

/*****************************************************************
Loan management system for use with gui.

@author Jeffrey Wagner
@version Fall 2018
*****************************************************************/

public class LoanManager {
	
	/** ArrayList of loans being managed */
	private ArrayList<Loan> loans;
	
	
	public void addLoan(String name, double rate, int length, double amount, String type) {
		if (type.equalsIgnoreCase("si"))
			loans.add(new SimpleLoan(name, rate, length, amount));
		else if (type.equalsIgnoreCase("al"))
			loans.add(new AmortizedLoan(name, rate, length, amount));
		else
			System.out.println("Invalid loan type");
	}
}
