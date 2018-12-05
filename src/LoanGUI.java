import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;


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
	
	JComboBox<Integer> rate = null;
	
	GridBagConstraints loc = null;
	
	Integer[] rates = {3, 4, 5, 6, 7};
	
	public LoanGUI() {
        int column = 0;
        int row = 0;
        int topIns = 5;
        int leftIns = 10;
        int botIns = 5;
        int rightIns = 10;
        
        manager = new LoanManager();
        
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();
        
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
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        add(simpleInterest, loc);
        
        amortized = new JRadioButton("Amortized");
        loc = new GridBagConstraints();
        loc.gridx = column + 2;
        loc.gridy = row;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        add(amortized, loc);
        
        buttGroup = new ButtonGroup();
        buttGroup.add(simpleInterest);
        buttGroup.add(amortized);
        
        labels = new ArrayList<JLabel>();
        labels.add(new JLabel("Loan Type"));
        labels.add(new JLabel("Name"));
        labels.add(new JLabel("Principle"));
        labels.add(new JLabel("Length"));
        labels.add(new JLabel("Rate"));
        labels.add(new JLabel("Payment"));
        
        
        for (JLabel l: labels) {
        	loc = new GridBagConstraints();
            loc.gridx = column;
            loc.gridy = row;  
            loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
            add(l, loc);
            row++;
        }
        
        row = 0;
        
        name = new JTextField(15);
        loc = new GridBagConstraints();
        loc.gridx = column + 1;
        loc.gridy = row + 1;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        loc.gridwidth = 2;
        add(name, loc);
        
        principle = new JTextField(15);
        loc = new GridBagConstraints();
        loc.gridx = column + 1;
        loc.gridy = row + 2;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        loc.gridwidth = 2;
        add(principle, loc);
        
        length = new JTextField(15);
        loc = new GridBagConstraints();
        loc.gridx = column + 1;
        loc.gridy = row + 3;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        loc.gridwidth = 2;
        add(length, loc);
        
        payment = new JTextField(15);
        loc = new GridBagConstraints();
        loc.gridx = column + 1;
        loc.gridy = row + 5;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        loc.gridwidth = 2;
        add(payment, loc);

        rate = new JComboBox<Integer>(rates);
        rate.setSelectedIndex(0);
        loc = new GridBagConstraints();
        loc.gridx = column + 1;
        loc.gridy = row + 4;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        loc.gridwidth = 2;
        add(rate, loc);
        
        search = new JButton("Search");
        loc = new GridBagConstraints();
        loc.gridx = column + 3;
        loc.gridy = row + 1;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        search.addActionListener(this);
        add(search, loc);
        
        calculate = new JButton("Calculate");
        loc = new GridBagConstraints();
        loc.gridx = column + 3;
        loc.gridy = row + 2;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        calculate.addActionListener(this);
        add(calculate, loc);
        
        add = new JButton("Add Loan");
        loc = new GridBagConstraints();
        loc.gridx = column + 3;
        loc.gridy = row + 3;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        add.addActionListener(this);
        add(add, loc);
        
        delete = new JButton("Delete Loan");
        loc = new GridBagConstraints();
        loc.gridx = column + 3;
        loc.gridy = row + 4;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        delete.addActionListener(this);
        add(delete, loc);
        
        clear = new JButton("Clear");
        loc = new GridBagConstraints();
        loc.gridx = column + 3;
        loc.gridy = row + 5;  
        loc.insets = new Insets(topIns, leftIns, botIns, rightIns);
        clear.addActionListener(this);
        add(clear, loc);

	}
	
	public void actionPerformed(ActionEvent e) {
		
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
