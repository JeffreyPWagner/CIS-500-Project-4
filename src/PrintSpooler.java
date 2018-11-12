
public class PrintSpooler {
	private static PrintSpooler spooler;
	
	public static PrintSpooler getSpooler() {
		if (spooler == null) {
			spooler = new PrintSpooler();
		}
		return spooler;
	}
	
	public void printDocument (String s) {
		System.out.println("Loan Information:");
		System.out.println(s);
	}

}
