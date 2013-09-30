package packageGUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mainpackage.Account;

public class CheckAccountAdd extends AccountAddScreen implements ActionListener
{
	//JFrame
	JFrame AccountFrame = new JFrame("Confirm Account Add");
	
	//Necessary JPanels
	//JPanel AccountAddP = GUI_Functions.AccountAddPanel();
	JPanel ConfirmationPanel = new JPanel(new FlowLayout());
	JPanel AccountAddPanel = new JPanel(new GridLayout(3, 2, 1, 0));
	
	//JLabels to be included in Panel
    JLabel AA_NameLabel;
    JLabel AA_AmountLabel;
    
    //JTextFields to be included in Panel
    JLabel AA_NameTextField;
    JLabel AA_AmountTextField;
	
	//JButtons
	JButton OKButton = new JButton("OK");
	JButton CancelButton = new JButton("Cancel");
	
	public void CreateAndShowWindow()
	{
		
		/*
		 * Steps to create AccountAdd Panel
		 */
	    //Instantiate JComponents
	    AA_NameLabel = new JLabel("Account Name: ");
	    AA_NameTextField = new JLabel(toBeAdded.getAccountName());
	    AA_AmountLabel = new JLabel("Initial Amount: ");
	    AA_AmountTextField = new JLabel(Double.toString(toBeAdded.getAccountTotal()));
	    
	    //Add JComponents to Panel
	    AccountAddPanel.add(AA_NameLabel);
	    AccountAddPanel.add(AA_NameTextField);
	    AccountAddPanel.add(AA_AmountLabel);
	    AccountAddPanel.add(AA_AmountTextField);
	    /*
	     * End of Account Add Panel stuff
	     */
	    
		//Set layout for AccountAdd Frame
		AccountFrame.getContentPane().setLayout(new BoxLayout(AccountFrame.getContentPane(),
				BoxLayout.Y_AXIS));
		
		//Confirmation Buttons w/ActionListeners
		OKButton.addActionListener(this);
	    CancelButton.addActionListener(this);

	    //Add Buttons to Panel
	    ConfirmationPanel.add(OKButton);
	    ConfirmationPanel.add(CancelButton);
	    
	    //Add panels to frame
	    AccountFrame.add(AccountAddPanel);
	    AccountFrame.add(ConfirmationPanel);
	    
	    //MAKE SURE FRAME IS VISIBLE, CHRIST
	    AccountFrame.pack();
	    AccountFrame.setDefaultCloseOperation(AccountFrame.EXIT_ON_CLOSE);
	    AccountFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		/*
		 * OPTION 1: User entered correct info, go to AccountDisplay with confirmed as target and close all others
		 */
		if(ae.getSource() == OKButton)
		{
			Account confirmed = new Account(AA_NameTextField.getText(), 
					Double.parseDouble(AA_AmountTextField.getText()));
			
			AvailableAccounts.add(confirmed);
			
			//GO TO ACCOUNT DISPLAY WINDOW WITH CURRENT INFO (set target account to "confirmed") AND CLOSE ALL OTHERS
		}
		/*
		 * OPTION 2: User entered incorrect info, open new add window and give chance to try again
		 * 
		 * Maybe someday I can figure out how to make it so the info is displayed, but that may involve ANOTHER 
		 * GOD DAMN WINDOW
		 */
		if(ae.getSource() == CancelButton)
		{
			System.out.println("Canceled!");
			AccountFrame.setVisible(true);
		}
	}
}
