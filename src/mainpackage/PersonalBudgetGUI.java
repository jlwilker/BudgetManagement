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
	public JPanel AccountItemAddPanel()
	{
	    //JPanel and List to contain JComponents w/i Panel
	    JPanel AccountItemAddPanel;
	    List<JComponent> AIA_ComponentRA;
	    
	    //JLabels to be included in Panel
	    JLabel AIA_NameLabel;
	    JLabel AIA_AmountLabel;
	    JLabel AIA_DateLabel;
	    JLabel AIA_DateInstance;
	    JLabel AIA_CategoryLabel;
	    JLabel AIA_IncomeBoxInstruc;
	    JLabel AIA_ExpenseBoxInstruc;
	    
	    //JTextFields to be included in Panel
	    JTextField AIA_NameTextField;
	    JTextField AIA_AmountTextField;
	    JTextField AIA_CategoryTextField;
	    
	    //Radio Buttons for incomeFlag
	    JRadioButton IncomeRButton;
	    JRadioButton ExpenseRButton;
	    
	    //Instantiate Panel, ArrayList
	    AccountItemAddPanel = new JPanel(new GridLayout(6, 2, 1, 0));
	    AIA_ComponentRA = new ArrayList<JComponent>();
	    
	    //Instantiate JComponents
	    AIA_NameLabel = new JLabel("Name:");
	    AIA_NameTextField = new JTextField();
	    AIA_AmountLabel = new JLabel("Amount:");
	    AIA_AmountTextField = new JTextField();
	    AIA_DateLabel = new JLabel("Date:");
	    //this line relies on top-level session GUI containing date
	    AIA_DateInstance = new JLabel((new Date().toString()));
	    AIA_CategoryLabel = new JLabel("Category:");
	    AIA_CategoryTextField = new JTextField();
	    
	    //Income CheckBox Instantiation
	    IncomeRButton = new JRadioButton();
	    AIA_IncomeBoxInstruc = new JLabel("Income");
	    ExpenseRButton = new JRadioButton();
	    AIA_ExpenseBoxInstruc = new JLabel("Expense");

	    //Group RadioButtons
	    ButtonGroup group = new ButtonGroup();
	    group.add(IncomeRButton);
	    group.add(ExpenseRButton);
	    
	    //Add JComponents to RA
	    AIA_ComponentRA.add(AIA_NameLabel);
	    AIA_ComponentRA.add(AIA_NameTextField);
	    AIA_ComponentRA.add(AIA_AmountLabel);
	    AIA_ComponentRA.add(AIA_AmountTextField);
	    AIA_ComponentRA.add(AIA_DateLabel);
	    AIA_ComponentRA.add(AIA_DateInstance);
	    AIA_ComponentRA.add(AIA_CategoryLabel);
	    AIA_ComponentRA.add(AIA_CategoryTextField);
	    AIA_ComponentRA.add(IncomeRButton);
	    AIA_ComponentRA.add(AIA_IncomeBoxInstruc);
	    AIA_ComponentRA.add(ExpenseRButton);
	    AIA_ComponentRA.add(AIA_ExpenseBoxInstruc);
	    
	    //Add JComponents to Panel
	    AccountItemAddPanel.add(AIA_NameLabel);
	    AccountItemAddPanel.add(AIA_NameTextField);
	    AccountItemAddPanel.add(AIA_AmountLabel);
	    AccountItemAddPanel.add(AIA_AmountTextField);
	    AccountItemAddPanel.add(AIA_DateLabel);
	    AccountItemAddPanel.add(AIA_DateInstance);
	    AccountItemAddPanel.add(AIA_CategoryLabel);
	    AccountItemAddPanel.add(AIA_CategoryTextField);
	    AccountItemAddPanel.add(IncomeRButton);
	    AccountItemAddPanel.add(AIA_IncomeBoxInstruc);
	    AccountItemAddPanel.add(ExpenseRButton);
	    AccountItemAddPanel.add(AIA_ExpenseBoxInstruc);

	    return AccountItemAddPanel;
	}

	public JPanel AccountItemAddPanel(AccountItem target)
	{
	    //JPanel and List to contain JComponents w/i Panel
	     JPanel AccountItemAddPanel;
	     List<JComponent> AIA_ComponentRA;
	    
	    //JLabels to be included in Panel
	     JLabel AIA_NameLabel;
	     JLabel AIA_AmountLabel;
	     JLabel AIA_DateLabel;
	     JLabel AIA_DateInstance;
	     JLabel AIA_CategoryLabel;
	     JLabel AIA_IncomeBoxInstruc;
	     JLabel AIA_ExpenseBoxInstruc;
	    
	    //JTextFields to be included in Panel
	     JTextField AIA_NameTextField;
	     JTextField AIA_AmountTextField;
	     JTextField AIA_CategoryTextField;
	    
	    //Radio Buttons for incomeFlag
	     JRadioButton IncomeRButton;
	     JRadioButton ExpenseRButton;
	    
	    //Instantiate Panel, ArrayList
	    AccountItemAddPanel = new JPanel(new GridLayout(6, 2, 1, 0));
	    AIA_ComponentRA = new ArrayList<JComponent>();
	    
	    //Instantiate JComponents
	    AIA_NameLabel = new JLabel("Name:");
	    AIA_NameTextField = new JTextField(target.getName());
	    AIA_AmountLabel = new JLabel("Amount:");
	    AIA_AmountTextField = new JTextField(Double.toString(target.getAmount()));
	    AIA_DateLabel = new JLabel("Date:");
	    //this line relies on top-level session GUI containing date
	    AIA_DateInstance = new JLabel(target.getDate().toString());
	    AIA_CategoryLabel = new JLabel("Category:");
	    AIA_CategoryTextField = new JTextField(target.getCategory());
	    
	    //Radio Button Label Instantiation
	    AIA_IncomeBoxInstruc = new JLabel("Income");
	    AIA_ExpenseBoxInstruc = new JLabel("Expense");
	    
	    //Radio Button Instantiations
	    if(target.getIncomeFlag() == 1)
	        {IncomeRButton = new JRadioButton("", true);
	        ExpenseRButton = new JRadioButton();}
	    else if (target.getIncomeFlag() == 0)
	        {ExpenseRButton = new JRadioButton("", true);
	         IncomeRButton = new JRadioButton();}
	    else
	        {
	            IncomeRButton = new JRadioButton();
	            ExpenseRButton = new JRadioButton();
	        }

	    //Group RadioButtons
	    ButtonGroup group = new ButtonGroup();
	    group.add(IncomeRButton);
	    group.add(ExpenseRButton);
	    
	    //Add JComponents to RA
	    AIA_ComponentRA.add(AIA_NameLabel);
	    AIA_ComponentRA.add(AIA_NameTextField);
	    AIA_ComponentRA.add(AIA_AmountLabel);
	    AIA_ComponentRA.add(AIA_AmountTextField);
	    AIA_ComponentRA.add(AIA_DateLabel);
	    AIA_ComponentRA.add(AIA_DateInstance);
	    AIA_ComponentRA.add(AIA_CategoryLabel);
	    AIA_ComponentRA.add(AIA_CategoryTextField);
	    AIA_ComponentRA.add(IncomeRButton);
	    AIA_ComponentRA.add(AIA_IncomeBoxInstruc);
	    AIA_ComponentRA.add(ExpenseRButton);
	    AIA_ComponentRA.add(AIA_ExpenseBoxInstruc);
	    
	    //Add JComponents to Panel
	    AccountItemAddPanel.add(AIA_NameLabel);
	    AccountItemAddPanel.add(AIA_NameTextField);
	    AccountItemAddPanel.add(AIA_AmountLabel);
	    AccountItemAddPanel.add(AIA_AmountTextField);
	    AccountItemAddPanel.add(AIA_DateLabel);
	    AccountItemAddPanel.add(AIA_DateInstance);
	    AccountItemAddPanel.add(AIA_CategoryLabel);
	    AccountItemAddPanel.add(AIA_CategoryTextField);
	    AccountItemAddPanel.add(IncomeRButton);
	    AccountItemAddPanel.add(AIA_IncomeBoxInstruc);
	    AccountItemAddPanel.add(ExpenseRButton);
	    AccountItemAddPanel.add(AIA_ExpenseBoxInstruc);

	    return AccountItemAddPanel;
	}

	public JPanel AccountItemDisplayPanel(AccountItem target)
	{
	    //JPanel and List to contain JComponents w/i Panel
	     JPanel AccountItemDisplayPanel;
	     List<JComponent> ADA_ComponentRA;
	    
	    //JLabels to be included in Panel
	     JLabel ADA_NameLabel;
	     JLabel ADA_RtdNameLabel;
	     JLabel ADA_AmountLabel;
	     JLabel ADA_RtdAmountLabel;
	     JLabel ADA_DateLabel;
	     JLabel ADA_DateInstance;
	     JLabel ADA_CategoryLabel;
	     JLabel ADA_RtdCategoryLabel;
	     JLabel ADA_IncomeBoxInstruc = new JLabel("Income");
	     JLabel ADA_ExpenseBoxInstruc = new JLabel("Expense");
	    
	    //Radio Buttons for incomeFlag
	     JRadioButton IncomeRButton;
	     JRadioButton ExpenseRButton;
	    
	    //Instantiate Panel, ArrayList
	    AccountItemDisplayPanel = new JPanel(new GridLayout(6, 2, 1, 0));
	    ADA_ComponentRA = new ArrayList<JComponent>();
	    
	    //Instantiate JComponents
	    ADA_NameLabel = new JLabel("Name:");
	    ADA_RtdNameLabel = new JLabel(target.getName());
	    ADA_AmountLabel = new JLabel("Amount:");
	    ADA_RtdAmountLabel = new JLabel(Double.toString(target.getAmount()));
	    ADA_DateLabel = new JLabel("Date:");
	    //this line relies on top-level session GUI containing date
	    ADA_DateInstance = new JLabel(target.getDate().toString());
	    ADA_CategoryLabel = new JLabel("Category:");
	    ADA_RtdCategoryLabel = new JLabel(target.getCategory());
	    
	    //Radio Button Instantiations, DISABLE?
	    if(target.getIncomeFlag() == 1)
	        {IncomeRButton = new JRadioButton("", true);
	         ExpenseRButton = new JRadioButton();}
	    else if (target.getIncomeFlag() == 0)
	        {ExpenseRButton = new JRadioButton("", true);
	         IncomeRButton = new JRadioButton();}
	    else
	        {
	            IncomeRButton = new JRadioButton();
	            ExpenseRButton = new JRadioButton();
	        }
	    
	    //Add JComponents to RA
	    ADA_ComponentRA.add(ADA_NameLabel);
	    ADA_ComponentRA.add(ADA_RtdNameLabel);
	    ADA_ComponentRA.add(ADA_AmountLabel);
	    ADA_ComponentRA.add(ADA_RtdAmountLabel);
	    ADA_ComponentRA.add(ADA_DateLabel);
	    ADA_ComponentRA.add(ADA_DateInstance);
	    ADA_ComponentRA.add(ADA_CategoryLabel);
	    ADA_ComponentRA.add(ADA_RtdCategoryLabel);
	    ADA_ComponentRA.add(IncomeRButton);
	    ADA_ComponentRA.add(ADA_IncomeBoxInstruc);
	    ADA_ComponentRA.add(ExpenseRButton);
	    ADA_ComponentRA.add(ADA_ExpenseBoxInstruc);
	    
	    //Add JComponents to Panel
	    AccountItemDisplayPanel.add(ADA_NameLabel);
	    AccountItemDisplayPanel.add(ADA_RtdNameLabel);
	    AccountItemDisplayPanel.add(ADA_AmountLabel);
	    AccountItemDisplayPanel.add(ADA_RtdAmountLabel);
	    AccountItemDisplayPanel.add(ADA_DateLabel);
	    AccountItemDisplayPanel.add(ADA_DateInstance);
	    AccountItemDisplayPanel.add(ADA_CategoryLabel);
	    AccountItemDisplayPanel.add(ADA_RtdCategoryLabel);
	    AccountItemDisplayPanel.add(IncomeRButton);
	    AccountItemDisplayPanel.add(ADA_IncomeBoxInstruc);
	    AccountItemDisplayPanel.add(ExpenseRButton);
	    AccountItemDisplayPanel.add(ADA_ExpenseBoxInstruc);

	    return AccountItemDisplayPanel;
	}


}

