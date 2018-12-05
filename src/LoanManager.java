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
	
	public boolean delete(String name) {
		return loans.remove(search(name));
	}
	
	public int countSimple() {
		int count = 0;
		for (Loan l: loans) {
			if (l instanceof SimpleLoan)
				count++;
		}
		return count;
	}
	
	public int countAmor() {
		return countTotal() - countSimple();
	}
	
	public int countTotal() {
		return loans.size();
	}
	
	public double calcTotal() {
		double total = 0;
		for (Loan l: loans) {
			total += l.getPrinciple();
		}
		return total;
	}
	
	//TODO
	public void save() {
		Collections.sort(loans);
		
	}
	
	//TODO
	public void load() {
	}
}
