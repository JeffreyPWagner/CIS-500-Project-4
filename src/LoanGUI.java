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
	
	ArrayList<JTextField> textFields = null;
	
	ArrayList<JButton> buttons = null;
	
	GridBagConstraints loc = null;
	
	public LoanGUI() {
        int column = 0;
        int row = 0;
        int topIns = 5;
        int leftIns = 10;
        int botIns = 5;
        int rightIns = 10;
        
        manager = new LoanManager();
        
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
        

	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
