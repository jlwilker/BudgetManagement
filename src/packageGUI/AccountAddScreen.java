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
import javax.swing.SwingUtilities;

import mainpackage.Account;

public class AccountAddScreen extends WelcomeScreen implements ActionListener
{
	//Checked Account
	protected static CheckAccountAdd checkedAccount = new CheckAccountAdd();
	
	//JFrame
	JFrame AccountFrame = new JFrame("Add Account");
	
	//Necessary JPanels
	//JPanel AccountAddP = GUI_Functions.AccountAddPanel();
	JPanel ConfirmationPanel = new JPanel(new FlowLayout());
	JPanel AccountAddPanel = new JPanel(new GridLayout(3, 2, 1, 0));
	
	//JLabels to be included in Panel
    JLabel AA_NameLabel;
    JLabel AA_AmountLabel;
    
    //JTextFields to be included in Panel
    JTextField AA_NameTextField;
    JTextField AA_AmountTextField;
	
	//JButtons
	JButton OKButton = new JButton("OK");
	JButton CancelButton = new JButton("Cancel");
	
	protected static Account toBeAdded;
	
	public void CreateAndShowWindow()
	{
		
		/*
		 * Steps to create AccountAdd Panel
		 */
	    //Instantiate JComponents
	    AA_NameLabel = new JLabel("Account Name: ");
	    AA_NameTextField = new JTextField();
	    AA_AmountLabel = new JLabel("Initial Amount: ");
	    AA_AmountTextField = new JTextField();
	    
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
		if(ae.getSource() == OKButton)
		{
			toBeAdded = new Account(AA_NameTextField.getText(), 
					Double.parseDouble(AA_AmountTextField.getText()));
			
			AccountFrame.setVisible(false);
			
			checkedAccount.CreateAndShowWindow();
			
			//Dispose b/c "checked" should open up clean window
			
		}
		
		/*
		 * Technically want it so that the WelcomeScreen opens up, but inheritence problems ahoy!
		 */
		if(ae.getSource() == CancelButton)
		{
			AccountFrame.dispose();
		}
	}
}
