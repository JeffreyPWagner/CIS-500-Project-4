import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.event.*;
import java.awt.*;


@SuppressWarnings("serial")
public class LoanGUI extends JFrame implements ActionListener {

	LoanManager manager = null;

	JMenuBar menu = null;
	JMenu file = null;
	JMenuItem save = null;
	JMenuItem load = null;
	JMenuItem summary = null;
	
	JRadioButton simpleInterest = null;
	JRadioButton amortized = null;
	ButtonGroup buttGroup = null;
	
	ArrayList<JLabel> labels = null;
	
	JTextField name = null;
	JTextField principle = null;
	JTextField length = null;
	JTextField payment = null;
	
	JButton search = null;
	JButton calculate = null;
	JButton add = null;
	JButton delete = null;
	JButton clear = null;
	
	JComboBox<Double> rate = null;
	Double[] rates = {3.00, 4.00, 5.00, 6.00, 7.00};
	
	GridBagConstraints loc = null;
	int column = 0;
    int row = 0;
    int topIns = 5;
    int leftIns = 10;
    int botIns = 5;
    int rightIns = 10;
    
    Loan currentLoan = null;
    int currentLength;
    double currentPrinciple;
    
    DecimalFormat formatter = new DecimalFormat("#.00");
	
	public LoanGUI() {
        manager = new LoanManager();
        
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);

        
        file = new JMenu("File");
        save = new JMenuItem("Save");
        save.addActionListener(this);
        file.add(save);
        load = new JMenuItem("Load");
        load.addActionListener(this);
        file.add(load);
        summary = new JMenuItem("Summary");
        summary.addActionListener(this);
        file.add(summary);
        menu = new JMenuBar();
        setJMenuBar(menu);
        menu.add(file);
        
        simpleInterest = new JRadioButton("Simple Interest");
        loc.gridx = column + 1;
        loc.gridy = row;  
        add(simpleInterest, loc);
        
        amortized = new JRadioButton("Amortized");
        loc.gridx = column + 2;
        add(amortized, loc);
        
        buttGroup = new ButtonGroup();
        buttGroup.add(simpleInterest);
        buttGroup.add(amortized);
        
        labels = new ArrayList<JLabel>();
        labels.add(new JLabel("Loan Type"));
        labels.add(new JLabel("Name"));
        labels.add(new JLabel("Principle ($)"));
        labels.add(new JLabel("Length (Years)"));
        labels.add(new JLabel("Rate (%)"));
        labels.add(new JLabel("Payment ($)"));
        
        
        for (JLabel l: labels) {
            loc.gridx = column;
            loc.gridy = row;
            add(l, loc);
            row++;
        }
        
        row = 0;
        
        name = new JTextField(15);
        loc.gridx = column + 1;
        loc.gridy = row + 1;  
        loc.gridwidth = 2;
        add(name, loc);
        
        principle = new JTextField(15);
        loc.gridy = row + 2;  
        loc.gridwidth = 2;
        add(principle, loc);
        
        length = new JTextField(15);
        loc.gridy = row + 3;  
        add(length, loc);
        
        payment = new JTextField(15);
        loc.gridy = row + 5;  
        add(payment, loc);

        rate = new JComboBox<Double>(rates);
        loc.gridy = row + 4;  
        add(rate, loc);
        
        search = new JButton("Search");
        loc.gridx = column + 3;
        loc.gridy = row + 1; 
        loc.gridwidth = 1;
        search.addActionListener(this);
        add(search, loc);
        
        calculate = new JButton("Calculate");
        loc.gridy = row + 2;  
        calculate.addActionListener(this);
        add(calculate, loc);
        
        add = new JButton("Add Loan");
        loc.gridy = row + 3;  
        add.addActionListener(this);
        add(add, loc);
        
        delete = new JButton("Delete Loan");
        loc.gridy = row + 4;  
        delete.addActionListener(this);
        add(delete, loc);
        
        clear = new JButton("Clear");
        loc.gridy = row + 5;  
        clear.addActionListener(this);
        add(clear, loc);
        
        manager.add("Jeff",3 ,15 ,100000, true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == search) {
			currentLoan = manager.search(name.getText());
			if (currentLoan != null) {
				principle.setText(formatter.format(currentLoan.getPrinciple()) + "");
				length.setText(currentLoan.getLength() + "");
				rate.setSelectedIndex((int) (currentLoan.getInterestRate() - rates[0]));
				payment.setText(formatter.format(currentLoan.getMonthlyPayment()) + "");
				if (currentLoan instanceof SimpleLoan)
					simpleInterest.setSelected(true);
				else
					amortized.setSelected(true);
			}
			else
				JOptionPane.showMessageDialog(null, "Loan not found");
		}
		
		if (event.getSource() == calculate) {
			try {
				currentPrinciple = Double.parseDouble(principle.getText());
				currentLength = Integer.parseInt(length.getText());
				if (simpleInterest.isSelected())
					currentLoan = new SimpleLoan(name.getText(), (double) rate.getSelectedItem(), currentLength, currentPrinciple);
				else if (amortized.isSelected())
					currentLoan = new AmortizedLoan(name.getText(), (double) rate.getSelectedItem(), currentLength, currentPrinciple);
				else JOptionPane.showMessageDialog(null, "Must select loan type");
				payment.setText(formatter.format(currentLoan.getMonthlyPayment()) + "");
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Inputs");
			}
		}
		
		if (event.getSource() == add) {
			try {
				currentPrinciple = Double.parseDouble(principle.getText());
				currentLength = Integer.parseInt(length.getText());
				manager.add(name.getText(), (double) rate.getSelectedItem(), currentLength, currentPrinciple, simpleInterest.isSelected());
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid Inputs");
			}
		}
	}
	
	public static void main (String Args[]) {
		LoanGUI gui = new LoanGUI();
        gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        gui.setLocation(300, 300);
        gui.setTitle("Loan Manager");
        gui.setVisible(true);
        gui.pack();
	}
}
