package packageGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mainpackage.Account;
import mainpackage.GUI_PersonalBudget;
import mainpackage.PersonalBudgetGUI;

public class WelcomeScreen extends GUI_PersonalBudget implements ActionListener
{
	//1) Create JFrame to create window
	JFrame welcomeFrame = new JFrame("Personal Budget Management");
	
	//2) Create JPanel to which to add components
	JPanel welcomePanel = new JPanel();
	
	//3) JComponents
	JLabel welcomeMessage = new JLabel("Welcome! To begin, create ");
	JButton newAccountButton = new JButton("New Account");
	JLabel welcomeInstruction = new JLabel("Or, select existing account below: ");
	JButton OKButton = new JButton("OK");
	JButton CancelButton = new JButton("Cancel");
	
	//4) Account Selection Components
	DefaultComboBoxModel accountList = new DefaultComboBoxModel();
	JComboBox accountComboBox;
	
	//5) Confirmation Panel
	JPanel confirmPanel;
	
	public void CreateAndShowWindow()
	{	
		//Frame stats
		welcomeFrame.getContentPane().setLayout(new BoxLayout(welcomeFrame.getContentPane(),
				BoxLayout.Y_AXIS));
		
		//FIRST JPanel
		welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
		
		welcomePanel.add(welcomeMessage);
		
		newAccountButton.addActionListener(this);
		
		welcomePanel.add(newAccountButton);
		welcomePanel.add(welcomeInstruction);
		
		for (Account temp : AvailableAccounts)
		{
			accountList.addElement(temp);
		}
		
		accountComboBox = new JComboBox(accountList);
		
		welcomePanel.add(accountComboBox);
		
		JPanel ConfirmationPanel = new JPanel(new FlowLayout());
		
		//Confirmation Buttons w/ActionListeners
		OKButton.addActionListener(this);
	    CancelButton.addActionListener(this);

	    //Add Buttons to Panel
	    ConfirmationPanel.add(OKButton);
	    ConfirmationPanel.add(CancelButton);
		
		//Add Panels to JFrame
		welcomeFrame.add(welcomePanel);
		welcomeFrame.add(ConfirmationPanel);
		
		welcomeFrame.pack();
		welcomeFrame.setDefaultCloseOperation(welcomeFrame.EXIT_ON_CLOSE);
		welcomeFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == newAccountButton)
		{
			System.out.println("New Stuff!");
		}
		
		if(ae.getSource() == OKButton)
		{
			System.out.println("OK!");
		}
		
		if(ae.getSource() == CancelButton)
		{
			System.out.println("Canceled!");
		}
	}
	
}
