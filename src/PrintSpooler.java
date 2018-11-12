/*****************************************************************
Centralized printing service for the entire system

@author Jeffrey Wagner
@version Fall 2018
*****************************************************************/

public class PrintSpooler {
	
	/** single instance of printing service */
	private static PrintSpooler spooler;
	
	//create instance if it does not already exist
	public static PrintSpooler getSpooler() {
		if (spooler == null) {
			spooler = new PrintSpooler();
		}
		return spooler;
	}
	
	
	/*****************************************************************
    Print a string representation of a loan
    @param s the loan data
    @param type the type of loan
    *****************************************************************/
	public void printDocument (String s, String type) {
		if (type.equalsIgnoreCase("SI"))
			System.out.println("Simple Interest Loan");
		if (type.equalsIgnoreCase("AL"))
			System.out.println("Full Amortized Loan");
		System.out.println(s);
	}
}
