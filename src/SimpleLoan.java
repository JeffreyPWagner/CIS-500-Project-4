
public class SimpleLoan extends Loan {

	public SimpleLoan(String name, double rate, int years, double amount) {
		super(name, rate, years, amount);
	}

	public void calcMonthlyPayment() {
		double monthlyInterest = interestRate / 12;
		int lengthMonths = length * 12;
		
		monthlyPayment = (principle * (monthlyInterest * lengthMonths + 1)) / lengthMonths;
	}
	
	public String toString() {
		return "Simple Interest Loan";
	}
}
