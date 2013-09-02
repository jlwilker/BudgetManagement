package mainpackage;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Driver5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PersonalBudgetGUI gui = new PersonalBudgetGUI();
				AccountItem item = new AccountItem("name", 0.00, new Date(),
						"category", 0);
				
				JPanel addPanel = gui.AccountItemAddPanel();
				JPanel initAddPanel = gui.AccountItemAddPanel(item);
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
		});
		
		
	}

}
