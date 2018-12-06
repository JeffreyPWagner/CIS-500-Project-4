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
