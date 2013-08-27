package mainpackage;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonalBudgetGUI extends JFrame
{
	class AccountAddPanel
	{
		private JPanel AccountAddPanel;
		private List<JComponent> AAPComponentRA;
	
		private JLabel AAPNameLabel;
		private JLabel AAPTotalLabel;
	
		private JTextField AAPNameTextField;
		private JTextField AAPTotalTextField;
	
		//Constructor returns (hopefully) fully formatted JPanel
		public AccountAddPanel()
		{
			//Instantiate Panel, ArrayList
			this.AccountAddPanel = new JPanel(new GridLayout(2, 2, 1, 0));
			this.AAPComponentRA = new ArrayList<JComponent>();
			
			//Instantiate JComponents
			this.AAPNameLabel = new JLabel("Account Name:");
			this.AAPNameTextField = new JTextField();
			this.AAPTotalLabel = new JLabel("Account Total:");
			this.AAPTotalTextField = new JTextField();

			//Add JComponents to RA
			AAPComponentRA.add(AAPNameLabel);
			AAPComponentRA.add(AAPNameTextField);
			AAPComponentRA.add(AAPTotalLabel);
			AAPComponentRA.add(AAPTotalTextField);

			//Add JComponents to Panel
			AccountAddPanel.add(AAPNameLabel);
			AccountAddPanel.add(AAPNameTextField);
			AccountAddPanel.add(AAPTotalLabel);
			AccountAddPanel.add(AAPTotalTextField);
		}
	
		//This Constructor for use when “confirming” user info
		public AccountAddPanel(Account targetAccount)
		{
			//Instantiate Panel, ArrayList
			this.AccountAddPanel = new JPanel(new GridLayout(2, 2, 1, 0));
			this.AAPComponentRA = new ArrayList<JComponent>();
			
			//Instantiate JComponents
			this.AAPNameLabel = new JLabel("Account Name:");
			this.AAPNameTextField = new JTextField(targetAccount.getAccountName());
			this.AAPTotalLabel = new JLabel("Account Total:");
			this.AAPTotalTextField = new JTextField(
					Double.toString(targetAccount.getAccountTotal()));

			//Add JComponents to RA
			AAPComponentRA.add(AAPNameLabel);
			AAPComponentRA.add(AAPNameTextField);
			AAPComponentRA.add(AAPTotalLabel);
			AAPComponentRA.add(AAPTotalTextField);
		
			//Add JComponents to Panel
			AccountAddPanel.add(AAPNameLabel);
			AccountAddPanel.add(AAPNameTextField);
			AccountAddPanel.add(AAPTotalLabel);
			AccountAddPanel.add(AAPTotalTextField);
		}
	}

	class AccountDisplayPanel
	{
		private JPanel AccountDisplayPanel;
		private List<JComponent> ADPComponentRA;
	
		private JLabel ADPNameLabel;
		private JLabel ADPTotalLabel;
		private JLabel ADPAcctNoLabel;
	
		private JLabel ADPRtdNameLabel;
		private JLabel ADPRtdTotalLabel;
		private JLabel ADPRtdAcctNoLabel;

		//Constructor returns (hopefully) fully formatted JPanel
		public AccountDisplayPanel(Account targetAccount)
		{
			//Instantiate Panel, ArrayList
			this.AccountDisplayPanel = new JPanel(new GridLayout(3, 2, 1, 0));
			this.ADPComponentRA = new ArrayList<JComponent>();
			
			//Instantiate JComponents
			this.ADPNameLabel = new JLabel("Account Name:");
			this.ADPRtdNameLabel = new JLabel(targetAccount.getAccountName());
			this.ADPTotalLabel = new JLabel("Account Total:");
			this.ADPRtdTotalLabel = new JLabel("$" + 
					Double.toString(targetAccount.getAccountTotal()));
			this.ADPAcctNoLabel = new JLabel("Account #:");
			//this.ADPRtdAcctNoLabel = new  JLabel(
					//Integer.toString(targetAccount.getAcctNo()));

			//Add JComponents to RA
			ADPComponentRA.add(ADPNameLabel);
			ADPComponentRA.add(ADPRtdNameLabel);
			ADPComponentRA.add(ADPTotalLabel);
			ADPComponentRA.add(ADPRtdTotalLabel);
			ADPComponentRA.add(ADPAcctNoLabel);
			ADPComponentRA.add(ADPRtdAcctNoLabel);
		
			//Add JComponents to Panel
			AccountDisplayPanel.add(ADPNameLabel);
			AccountDisplayPanel.add(ADPRtdNameLabel);
			AccountDisplayPanel.add(ADPTotalLabel);
			AccountDisplayPanel.add(ADPRtdTotalLabel);
			AccountDisplayPanel.add(ADPAcctNoLabel);
			AccountDisplayPanel.add(ADPRtdAcctNoLabel);
		}
	}
}

