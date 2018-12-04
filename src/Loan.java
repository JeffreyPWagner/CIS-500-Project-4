import java.text.NumberFormat;

/*****************************************************************
Representation of a loan in the system, subclasses include simple
interest and fully amortized loans.

@author Jeffrey Wagner
@version Fall 2018
*****************************************************************/

public abstract class Loan implements Comparable {

	/** name of applicant */
	protected String name;
	
	/** annual interest rate */
	protected double interestRate;
	
	/** length in years */
	protected int length;
	
	/** amount of loan */
	protected double principle;
	
	/** monthly loan payment */
	protected double monthlyPayment;
	
	//create currency formatter for dollar figures
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	
	/*****************************************************************
    Constructor creates a loan with specified attributes
    @param name the name of the applicant
    @param rate the interest rate of the loan
    @param years the length of the loan in years
    @param amount the amount of the loan
    *****************************************************************/
	public Loan (String name, double rate, int years, double amount) {
		this.name = name;
		this.interestRate = rate;
		this.length = years;
		this.principle = amount;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}


	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}


	/**
	 * @return the principle
	 */
	public double getPrinciple() {
		return principle;
	}


	/**
	 * @return the monthlyPayment
	 */
	public double getMonthlyPayment() {
		return monthlyPayment;
	}


	/*****************************************************************
    Compares the name on this loan to that of another loan.
    @param other the loan to compare names with
    @return an integer indicating if the name goes before or after the
    other name
    *****************************************************************/
	public int compareTo(Loan other) {
		return name.compareTo(other.name);
	}
	
	
	/*****************************************************************
    Processes the loan application
    @return a string representation of the processes loan application
    *****************************************************************/
	public String process () {
		calcMonthlyPayment();
		return makeSummary();
	}
	
	
	/*****************************************************************
    Calculates the monthly loan payment
    *****************************************************************/
	abstract public void calcMonthlyPayment();
	
	
	/*****************************************************************
	Creates a string that represents the processed loan
	@return string representing the processed loan
	*****************************************************************/
	public String makeSummary() {
		return "Name: " + name + "\nInterest Rate: " + String.format("%.2f%%",interestRate*100) + "\nLength: " + length + "\nAmount: "
				+ formatter.format(principle) + "\nPayment: " + formatter.format(monthlyPayment);
	}
	
	
	/*****************************************************************
	Converts the loan to a printable string
	*****************************************************************/
	public String toString() {
		return "Loan";
	}
}
