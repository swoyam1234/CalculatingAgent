package Agent.calculator;
import jade.core.AID;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorGui extends JFrame {	
	private CalculatorAgent myAgent;
	
	private JTextField numberField;
	
	CalculatorGui(CalculatorAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 1));
		p.add(new JLabel("Enter number:"));
		numberField = new JTextField(15);
		p.add(numberField);
		getContentPane().add(p, BorderLayout.CENTER);
		
		JButton addButton1 = new JButton("Squre");
		JButton addButton2 = new JButton("Cube");
		addButton1.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String number = numberField.getText();
					int n1 = Integer.parseInt(number);
					myAgent.calculateSqure(n1);
					numberField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(CalculatorGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		addButton2.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String number = numberField.getText();
					int n2 = Integer.parseInt(number);
					myAgent.calculateCube(n2);
					numberField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(CalculatorGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		p = new JPanel();
		p.add(addButton1);
		p.add(addButton2);
		getContentPane().add(p, BorderLayout.SOUTH);
		
		// Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
	}
	
	public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}	
}
