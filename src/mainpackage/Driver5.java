package mainpackage;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PersonalBudgetGUI gui = new PersonalBudgetGUI();
		
		PersonalBudgetGUI.AccountAddPanel addPanel = gui.new AccountAddPanel();
		//PersonalBudgetGUI.AccountAddPanel innerObject = gui.new AccountAddPanel();
		
		JFrame frame = new JFrame("Account Information");
		//Size
		frame.setSize(300,350);
		//Actions on Close
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		//Layout Options
		frame.setLayout(new FlowLayout());
		
		frame.add(addPanel);
	}

}
