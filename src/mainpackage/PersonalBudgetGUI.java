package mainpackage;

import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	
	public class AccountItemAddPanel
	{
	    //JPanel and List to contain JComponents w/i Panel
	    private JPanel AccountItemAddPanel;
	    private List<JComponent> AIA_ComponentRA;
	    
	    //JLabels to be included in Panel
	    private JLabel AIA_NameLabel;
	    private JLabel AIA_AmountLabel;
	    private JLabel AIA_DateLabel;
	    private JLabel AIA_DateInstance;
	    private JLabel AIA_CategoryLabel;
	    private JLabel AIA_IncomeBoxInstruc;
	    private JLabel AIA_ExpenseBoxInstruc;
	    
	    //JTextFields to be included in Panel
	    private JTextField AIA_NameTextField;
	    private JTextField AIA_AmountTextField;
	    private JTextField AIA_CategoryTextField;
	    
	    //Radio Buttons for incomeFlag
	    private JRadioButton IncomeRButton;
	    private JRadioButton ExpenseRButton;
	    
	    public AccountItemAddPanel()
	    {
	        //Instantiate Panel, ArrayList
	        this.AccountItemAddPanel = new JPanel(new GridLayout(6, 2, 1, 0));
	        this.AIA_ComponentRA = new ArrayList<JComponent>();
	        
	        //Instantiate JComponents
	        this.AIA_NameLabel = new JLabel("Name:");
	        this.AIA_NameTextField = new JTextField();
	        this.AIA_AmountLabel = new JLabel("Amount:");
	        this.AIA_AmountTextField = new JTextField();
	        this.AIA_DateLabel = new JLabel("Date:");
	        //this line relies on top-level session GUI containing date
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        this.AIA_DateInstance = new JLabel((df.format(Calendar.getInstance())).toString());
	        this.AIA_CategoryLabel = new JLabel("Category:");
	        this.AIA_CategoryTextField = new JTextField();
	        
	        //Income CheckBox Instantiation
	        this.IncomeRButton = new JRadioButton();
	        this.AIA_IncomeBoxInstruc = new JLabel("Income");
	        this.ExpenseRButton = new JRadioButton();
	        this.AIA_ExpenseBoxInstruc = new JLabel("Expense");

	        //Group RadioButtons
	        ButtonGroup group = new ButtonGroup();
	        group.add(IncomeRButton);
	        group.add(ExpenseRButton);
	        
	        //Add JComponents to RA
	        this.AIA_ComponentRA.add(AIA_NameLabel);
	        this.AIA_ComponentRA.add(AIA_NameTextField);
	        this.AIA_ComponentRA.add(AIA_AmountLabel);
	        this.AIA_ComponentRA.add(AIA_AmountTextField);
	        this.AIA_ComponentRA.add(AIA_DateLabel);
	        this.AIA_ComponentRA.add(AIA_DateInstance);
	        this.AIA_ComponentRA.add(AIA_CategoryLabel);
	        this.AIA_ComponentRA.add(AIA_CategoryTextField);
	        this.AIA_ComponentRA.add(IncomeRButton);
	        this.AIA_ComponentRA.add(AIA_IncomeBoxInstruc);
	        this.AIA_ComponentRA.add(ExpenseRButton);
	        this.AIA_ComponentRA.add(AIA_ExpenseBoxInstruc);
	        
	        //Add JComponents to Panel
	        this.AccountItemAddPanel.add(AIA_NameLabel);
	        this.AccountItemAddPanel.add(AIA_NameTextField);
	        this.AccountItemAddPanel.add(AIA_AmountLabel);
	        this.AccountItemAddPanel.add(AIA_AmountTextField);
	        this.AccountItemAddPanel.add(AIA_DateLabel);
	        this.AccountItemAddPanel.add(AIA_DateInstance);
	        this.AccountItemAddPanel.add(AIA_CategoryLabel);
	        this.AccountItemAddPanel.add(AIA_CategoryTextField);
	        this.AccountItemAddPanel.add(IncomeRButton);
	        this.AccountItemAddPanel.add(AIA_IncomeBoxInstruc);
	        this.AccountItemAddPanel.add(ExpenseRButton);
	        this.AccountItemAddPanel.add(AIA_ExpenseBoxInstruc);
	    }

	public AccountItemAddPanel(AccountItem target)
	    {
	        //Instantiate Panel, ArrayList
	        this.AccountItemAddPanel = new JPanel(new GridLayout(6, 2, 1, 0));
	        this.AIA_ComponentRA = new ArrayList<JComponent>();
	        
	        //Instantiate JComponents
	        this.AIA_NameLabel = new JLabel("Name:");
	        this.AIA_NameTextField = new JTextField(target.getName());
	        this.AIA_AmountLabel = new JLabel("Amount:");
	        this.AIA_AmountTextField = new JTextField(Double.toString(target.getAmount()));
	        this.AIA_DateLabel = new JLabel("Date:");
	        //this line relies on top-level session GUI containing date
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        this.AIA_DateInstance = new JLabel(df.format(target.getDate().toString()));
	        this.AIA_CategoryLabel = new JLabel("Category:");
	        this.AIA_CategoryTextField = new JTextField(target.getCategory());
	        
	        //Radio Button Label Instantiation
	        this.AIA_IncomeBoxInstruc = new JLabel("Income");
	        this.AIA_ExpenseBoxInstruc = new JLabel("Expense");
	        
	        //Radio Button Instantiations
	        if(target.getIncomeFlag() == 1)
	            {this.IncomeRButton = new JRadioButton("", true);}
	        else if (target.getIncomeFlag() == 0)
	            {this.ExpenseRButton = new JRadioButton("", true);}
	        else
	            {
	                this.IncomeRButton = new JRadioButton();
	                this.ExpenseRButton = new JRadioButton();
	            }

	        //Group RadioButtons
	        ButtonGroup group = new ButtonGroup();
	        group.add(IncomeRButton);
	        group.add(ExpenseRButton);
	        
	        //Add JComponents to RA
	        this.AIA_ComponentRA.add(AIA_NameLabel);
	        this.AIA_ComponentRA.add(AIA_NameTextField);
	        this.AIA_ComponentRA.add(AIA_AmountLabel);
	        this.AIA_ComponentRA.add(AIA_AmountTextField);
	        this.AIA_ComponentRA.add(AIA_DateLabel);
	        this.AIA_ComponentRA.add(AIA_DateInstance);
	        this.AIA_ComponentRA.add(AIA_CategoryLabel);
	        this.AIA_ComponentRA.add(AIA_CategoryTextField);
	        this.AIA_ComponentRA.add(IncomeRButton);
	        this.AIA_ComponentRA.add(AIA_IncomeBoxInstruc);
	        this.AIA_ComponentRA.add(ExpenseRButton);
	        this.AIA_ComponentRA.add(AIA_ExpenseBoxInstruc);
	        
	        //Add JComponents to Panel
	        this.AccountItemAddPanel.add(AIA_NameLabel);
	        this.AccountItemAddPanel.add(AIA_NameTextField);
	        this.AccountItemAddPanel.add(AIA_AmountLabel);
	        this.AccountItemAddPanel.add(AIA_AmountTextField);
	        this.AccountItemAddPanel.add(AIA_DateLabel);
	        this.AccountItemAddPanel.add(AIA_DateInstance);
	        this.AccountItemAddPanel.add(AIA_CategoryLabel);
	        this.AccountItemAddPanel.add(AIA_CategoryTextField);
	        this.AccountItemAddPanel.add(IncomeRButton);
	        this.AccountItemAddPanel.add(AIA_IncomeBoxInstruc);
	        this.AccountItemAddPanel.add(ExpenseRButton);
	        this.AccountItemAddPanel.add(AIA_ExpenseBoxInstruc);
	    }
	}

	public class AccountItemDisplayPanel
	{
	    //JPanel and List to contain JComponents w/i Panel
	    private JPanel AccountItemDisplayPanel;
	    private List<JComponent> ADA_ComponentRA;
	    
	    //JLabels to be included in Panel
	    private JLabel ADA_NameLabel;
	    private JLabel ADA_RtdNameLabel;
	    private JLabel ADA_AmountLabel;
	    private JLabel ADA_RtdAmountLabel;
	    private JLabel ADA_DateLabel;
	    private JLabel ADA_DateInstance;
	    private JLabel ADA_CategoryLabel;
	    private JLabel ADA_RtdCategoryLabel;

	    private JLabel IncomeBoxInstruc;
	    private JLabel ExpenseBoxInstruc;
	    
	    //Radio Buttons for incomeFlag
	    private JRadioButton IncomeRButton;
	    private JRadioButton ExpenseRButton;
	    
	    public AccountItemDisplayPanel(AccountItem target)
	    {
	        //Instantiate Panel, ArrayList
	        this.AccountItemDisplayPanel = new JPanel(new GridLayout(6, 2, 1, 0));
	        this.ADA_ComponentRA = new ArrayList<JComponent>();
	        
	        //Instantiate JComponents
	        this.ADA_NameLabel = new JLabel("Name:");
	        this.ADA_RtdNameLabel = new JLabel(target.getName());
	        this.ADA_AmountLabel = new JLabel("Amount:");
	        this.ADA_RtdAmountLabel = new JLabel(Double.toString(target.getAmount()));
	        this.ADA_DateLabel = new JLabel("Date:");
	        //this line relies on top-level session GUI containing date
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        this.ADA_DateInstance = new JLabel(df.format(target.getDate()).toString());
	        this.ADA_CategoryLabel = new JLabel("Category:");
	        this.ADA_RtdCategoryLabel = new JLabel(target.getCategory());
	        
	        //Radio Button Instantiations
	        if(target.getIncomeFlag() == 1)
	            {this.IncomeRButton = new JRadioButton("", true);}
	        else if (target.getIncomeFlag() == 0)
	            {this.ExpenseRButton = new JRadioButton("", true);}
	        else
	            {
	                this.IncomeRButton = new JRadioButton();
	                this.ExpenseRButton = new JRadioButton();
	            }
	        
	        //Add JComponents to RA
	        this.ADA_ComponentRA.add(ADA_NameLabel);
	        this.ADA_ComponentRA.add(ADA_RtdNameLabel);
	        this.ADA_ComponentRA.add(ADA_AmountLabel);
	        this.ADA_ComponentRA.add(ADA_RtdAmountLabel);
	        this.ADA_ComponentRA.add(ADA_DateLabel);
	        this.ADA_ComponentRA.add(ADA_DateInstance);
	        this.ADA_ComponentRA.add(ADA_CategoryLabel);
	        this.ADA_ComponentRA.add(ADA_RtdCategoryLabel);
	        this.ADA_ComponentRA.add(IncomeRButton);
	        this.ADA_ComponentRA.add(IncomeBoxInstruc);
	        this.ADA_ComponentRA.add(ExpenseRButton);
	        this.ADA_ComponentRA.add(ExpenseBoxInstruc);
	        
	        //Add JComponents to Panel
	        this.AccountItemDisplayPanel.add(ADA_NameLabel);
	        this.AccountItemDisplayPanel.add(ADA_RtdNameLabel);
	        this.AccountItemDisplayPanel.add(ADA_AmountLabel);
	        this.AccountItemDisplayPanel.add(ADA_RtdAmountLabel);
	        this.AccountItemDisplayPanel.add(ADA_DateLabel);
	        this.AccountItemDisplayPanel.add(ADA_DateInstance);
	        this.AccountItemDisplayPanel.add(ADA_CategoryLabel);
	        this.AccountItemDisplayPanel.add(ADA_RtdCategoryLabel);
	        this.AccountItemDisplayPanel.add(IncomeRButton);
	        this.AccountItemDisplayPanel.add(IncomeBoxInstruc);
	        this.AccountItemDisplayPanel.add(ExpenseRButton);
	        this.AccountItemDisplayPanel.add(ExpenseBoxInstruc);
	        
	        /*Theoretically, w/o ActionListeners, buttons can't be changed*/
	    }
	}
}

