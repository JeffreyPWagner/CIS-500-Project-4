
public class AmortizedLoan extends Loan{

	public AmortizedLoan(String name, double rate, int years, double amount) {
		super(name, rate, years, amount);
	}
	
	public void calcMonthlyPayment() {
		double monthlyInterest = interestRate / 12;
		int lengthMonths = length * 12;
		double n = Math.pow(1 + monthlyInterest, lengthMonths);
		
		monthlyPayment = (principle * monthlyInterest * n) / (n - 1);
	}
	
	public String toString() {
		return "Full Amortized Loan";
	}

}
