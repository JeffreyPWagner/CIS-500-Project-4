/*****************************************************************
Representation of a simple interest loan in the system

@author Jeffrey Wagner
@version Fall 2018
*****************************************************************/

public class SimpleLoan extends Loan {

	/*****************************************************************
    Constructor creates a loan with specified attributes
    @param name the name of the applicant
    @param rate the interest rate of the loan
    @param years the length of the loan in years
    @param amount the amount of the loan
    *****************************************************************/
	public SimpleLoan(String name, double rate, int years, double amount) {
		super(name, rate, years, amount);
	}

	
	/*****************************************************************
    Calculates the monthly loan payment
    *****************************************************************/
	public void calcMonthlyPayment() {
		
		/** monthly interest rate */
		double monthlyInterest = interestRate / 12;
		
		/** length of the loan in months */
		int lengthMonths = length * 12;
		
		monthlyPayment = (principle * (monthlyInterest * lengthMonths + 1)) / lengthMonths;
	}
	
	
	/*****************************************************************
	Converts the loan to a printable string
	*****************************************************************/
	public String toString() {
		return "Simple Interest Loan";
	}
	
	
	/*****************************************************************
    Compares the name on this loan to that of another loan.
    @param other the loan to compare names with
    @return an integer indicating if the name goes before or after the
    other name
    *****************************************************************/
	public int compareTo(Object other) {
		if (other instanceof Loan) {
			Loan otherLoan = (Loan) other;
			return name.compareTo(otherLoan.name);
		}
		else {
			System.out.println("Object is not a loan, returning 0");
			return 0;
		}
	}
}
