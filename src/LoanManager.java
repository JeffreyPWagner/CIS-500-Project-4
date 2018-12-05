import java.util.*;

/*****************************************************************
Loan management system for use with gui.

@author Jeffrey Wagner
@version Fall 2018
*****************************************************************/

public class LoanManager {
	
	/** ArrayList of loans being managed */
	private ArrayList<Loan> loans;
	
	public LoanManager() {
		loans = new ArrayList<Loan>();
	}
	
	public void add(String name, double rate, int length, double amount, boolean simpleInterest) {
		if (simpleInterest)
			loans.add(new SimpleLoan(name, rate, length, amount));
		else
			loans.add(new AmortizedLoan(name, rate, length, amount));
	}
	
	public Loan search (String name) {
		for (Loan l: loans) {
			if (l.getName().equalsIgnoreCase(name)) {
				return l;
			}
		}
		return null;
	}
	
	
	
	//TODO
	public void delete(Loan l) {
	}
	
	//TODO
	public int countSimple() {
		return 0;
	}
	
	//TODO
	public int countAmor() {
		return 0;
	}
	
	//TODO
	public double calcTotal() {
		return 0;
	}
	
	//TODO
	public void save() {
	}
	
	//TODO
	public void load() {
	}
}
