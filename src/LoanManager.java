import java.util.*;
import java.io.*;

/*****************************************************************
Loan management system for use with gui.

@author Jeffrey Wagner
@version Fall 2018
*****************************************************************/

public class LoanManager {
	
	/** ArrayList of loans being managed */
	private ArrayList<Loan> loans;
	
	/*****************************************************************
    Constructor creates new loan arraylist
    *****************************************************************/
	public LoanManager() {
		loans = new ArrayList<Loan>();
	}
	
	
	/*****************************************************************
    Adds a new loan to the collection
    @param name name of the applicant
    @param rate interest rate for the loan
    @param length length of the loan in years
    @param amount initial principle of loan
    @param simpleinterest determines if the loan is simple interest
    *****************************************************************/
	public void add(String name, double rate, int length, double amount, boolean simpleInterest) {
		if (simpleInterest)
			loans.add(new SimpleLoan(name, rate, length, amount));
		else
			loans.add(new AmortizedLoan(name, rate, length, amount));
	}
	
	
	/*****************************************************************
    Searches for a loan by name
    @param name name of the applicant
    @return the loan associated with the applicant
    *****************************************************************/
	public Loan search (String name) {
		for (Loan l: loans) {
			if (l.getName().equalsIgnoreCase(name)) {
				return l;
			}
		}
		return null;
	}
	
	
	/*****************************************************************
    Deletes a loan from the collection
    @param name name of applicant
    @return returns true if the loan was found and deleted, otherwise false
    *****************************************************************/
	public boolean delete(String name) {
		return loans.remove(search(name));
	}
	
	
	/*****************************************************************
    Counts the number of simple interest loans in the collection
    @return count of the simple interest loans
    *****************************************************************/
	public int countSimple() {
		int count = 0;
		for (Loan l: loans) {
			if (l instanceof SimpleLoan)
				count++;
		}
		return count;
	}
	
	
	/*****************************************************************
    Counts the number of amortized loans in the collection
    @return count of the amortized loans
    *****************************************************************/
	public int countAmor() {
		return countTotal() - countSimple();
	}
	
	
	/*****************************************************************
    Counts the number of loans in the collection
    @return count of the loans
    *****************************************************************/
	public int countTotal() {
		return loans.size();
	}
	
	
	/*****************************************************************
    Sums the total principle of all loans in the collection
    @return sum of the total principle of all loans in the collection
    *****************************************************************/
	public double calcTotal() {
		double total = 0;
		for (Loan l: loans) {
			total += l.getPrinciple();
		}
		return total;
	}
	
	
	/*****************************************************************
    Saves the collection of loans to a text file
    *****************************************************************/
	public void save() {
		try {
			Collections.sort(loans);
			FileWriter writer = new FileWriter("Loans.txt");
			for (Loan l: loans) {
				writer.write(l.toString());
			}
			writer.close();
		}
		catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	/*****************************************************************
    Loads the collection of loans from a text file
    *****************************************************************/
	public void load() {
		try {
			FileReader reader = new FileReader("Loans.txt");
			BufferedReader buffReader = new BufferedReader(reader);
			String readName;
			while ((readName = buffReader.readLine()) != null && !readName.equals("")) {
				String readPrin = buffReader.readLine();
				String readLength = buffReader.readLine();
				String readRate = buffReader.readLine();
				String readPay = buffReader.readLine();
				String readType = buffReader.readLine();
				
				if (readType.equals("simple interest"))
					loans.add(new SimpleLoan(readName, Double.parseDouble(readRate), Integer.parseInt(readLength), Double.parseDouble(readPrin)));
				else
					loans.add(new AmortizedLoan(readName, Double.parseDouble(readRate), Integer.parseInt(readLength), Double.parseDouble(readPrin)));
			}
			buffReader.close();
			reader.close();
		}
		catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}
