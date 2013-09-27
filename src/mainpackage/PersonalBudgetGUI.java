package mainpackage;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import mainpackage.mysql.RecurringItem;

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

	public JPanel ConfirmationPanel()
	{
	    //JPanel Declaration/Instantiation
	    JPanel ConfirmationPanel = new JPanel(new FlowLayout());
	    
	    //JButton Declarations/Instanstiations
	    JButton OKButton = new JButton("OK");
	    JButton CancelButton = new JButton("Cancel");
	    
	    //Add Buttons to Panel
	    ConfirmationPanel.add(OKButton);
	    ConfirmationPanel.add(CancelButton);
	    
	    return ConfirmationPanel;
	}

	public JPanel HorizontalItemDisplayPanel(AccountItem item)
    {
		 JPanel HorizontalItemPanel;
		 List<JComponent> HorizontalItemsRA;
		    
		 JLabel NameLabel;
		 JLabel CategoryLabel;
		 JLabel DateLabel;
		 JLabel AmountLabel;

        //Instantiate JPanel, ComponentsRA
        HorizontalItemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        HorizontalItemsRA = new ArrayList<JComponent>();
        
        //Instantiate JComponents
        NameLabel = new JLabel(item.getName());
        CategoryLabel = new JLabel(item.getCategory());
        DateLabel = new JLabel(item.getDate().toString());
        AmountLabel = new JLabel(Double.toString(item.getAmount()));
        
        //Add JComponents to RA
        HorizontalItemsRA.add(NameLabel);
        HorizontalItemsRA.add(CategoryLabel);
        HorizontalItemsRA.add(DateLabel);
        HorizontalItemsRA.add(AmountLabel);
        
        //Add JComponents to Panel
        HorizontalItemPanel.add(NameLabel);
        HorizontalItemPanel.add(CategoryLabel);
        HorizontalItemPanel.add(DateLabel);
        HorizontalItemPanel.add(AmountLabel);
        
        return HorizontalItemPanel; 
    }
	
	public JPanel RecurringItemAddPanel()
    {
	    //JPanel, ComponentRA
	     JPanel RecurringAddPanel;
	     List<JComponent> RecurringPanelRA;
	    
	    //JLabels
	     JLabel NameLabel;
	     JLabel AmountLabel;
	     JLabel DueDateLabel;
	     JLabel FrequencyLabel;
	     JLabel TypeLabel;
	    
	    //JTextFields
	     JTextField NameTextField;
	     JTextField AmountTextField;
	     JTextField DueDateTextField;
	    
	    //JRadioButtons
	     JRadioButton BiWeeklyRB;
	     JRadioButton MonthlyRB;
	     JRadioButton IncomeRB;
	     JRadioButton ExpenseRB;
		//Instantiate Panel, ComponentRA
		RecurringAddPanel = new JPanel(new GridLayout(6, 3, 1, 0));
		RecurringPanelRA = new ArrayList<JComponent>();
		
		//Instantiate Components
		NameLabel = new JLabel("Name:");
		NameTextField = new JTextField();
		JLabel space1 = new JLabel("");
		JLabel space2 = new JLabel("");
		JLabel space3 = new JLabel("");
		AmountLabel = new JLabel("Amount:");
		AmountTextField = new JTextField();
		DueDateLabel = new JLabel("Day Charged/Received:");
		DueDateTextField = new JTextField();
		FrequencyLabel = new JLabel("Repeats:");
		
		//JRadio Buttons assoc. w/Frequency Label
		BiWeeklyRB = new JRadioButton();
		MonthlyRB = new JRadioButton();
		
		//Group RadioButtons assoc w/Frequency Label
		ButtonGroup group = new ButtonGroup();
		group.add(BiWeeklyRB);
		group.add(MonthlyRB);
		
		TypeLabel = new JLabel("Type:");
		
		//JRadioButtons assoc. w/Type Label
		IncomeRB = new JRadioButton();
		ExpenseRB = new JRadioButton();
		
		//Group RadioButtons assoc w/Type Label
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(IncomeRB);
		buttonGroup.add(ExpenseRB);
		
		//Add Components to RA
		RecurringPanelRA.add(NameLabel);
		RecurringPanelRA.add(NameTextField);
		RecurringPanelRA.add(AmountLabel);
		RecurringPanelRA.add(AmountTextField);
		RecurringPanelRA.add(DueDateLabel);
		RecurringPanelRA.add(DueDateTextField);
		RecurringPanelRA.add(FrequencyLabel);
		RecurringPanelRA.add(BiWeeklyRB);
		RecurringPanelRA.add(MonthlyRB);
		RecurringPanelRA.add(TypeLabel);
		RecurringPanelRA.add(IncomeRB);
		RecurringPanelRA.add(ExpenseRB);
		
		//Add Components to Panel
		RecurringAddPanel.add(NameLabel);
		RecurringAddPanel.add(NameTextField);
		RecurringAddPanel.add(space1);
		RecurringAddPanel.add(AmountLabel);
		RecurringAddPanel.add(AmountTextField);
		RecurringAddPanel.add(space2);
		RecurringAddPanel.add(DueDateLabel);
		RecurringAddPanel.add(DueDateTextField);
		RecurringAddPanel.add(space3);
		RecurringAddPanel.add(FrequencyLabel);
		RecurringAddPanel.add(BiWeeklyRB);
		RecurringAddPanel.add(MonthlyRB);
		RecurringAddPanel.add(TypeLabel);
		RecurringAddPanel.add(IncomeRB);
		RecurringAddPanel.add(ExpenseRB);
		
		return RecurringAddPanel;
    }

	/*For add confirmation*/
	
	public JPanel RecurringItemAddPanel(RecurringItem item)
	    {
	    //JPanel, ComponentRA
	     JPanel RecurringAddPanel;
	     List<JComponent> RecurringPanelRA;
	    
	    //JLabels
	     JLabel NameLabel;
	     JLabel AmountLabel;
	     JLabel DueDateLabel;
	     JLabel FrequencyLabel;
	     JLabel TypeLabel;
	    
	    //JLabels, formally JTextFields
	     JLabel RtdNameLabel;
	     JLabel RtdAmountLabel;
	     JLabel RtdDueDate;
	    
	    //JRadioButtons
	     JRadioButton BiWeeklyRB;
	     JRadioButton MonthlyRB;
	     JRadioButton IncomeRB;
	     JRadioButton ExpenseRB;
	    
	    //Instantiate Panel, ComponentRA
	    RecurringAddPanel = new JPanel(new GridLayout(6, 3, 1, 0));
	    RecurringPanelRA = new ArrayList<JComponent>();
	    
	    //Instantiate Components
	    NameLabel = new JLabel("Name:");
	    RtdNameLabel = new JLabel(item.getName());
	    JLabel space1 = new JLabel("");
		JLabel space2 = new JLabel("");
		JLabel space3 = new JLabel("");
	    AmountLabel = new JLabel("Amount:");
	    RtdAmountLabel = new JLabel(Double.toString(item.getAmount()));
	    DueDateLabel = new JLabel("Day Charged/Received:");
	    RtdDueDate = new JLabel(item.getDueDate().toString());
	    FrequencyLabel = new JLabel("Repeats:");
	    
	    //JRadio Buttons assoc. w/Frequency Label
	    BiWeeklyRB = new JRadioButton();
	    MonthlyRB = new JRadioButton();
	    
	    //Group RadioButtons assoc w/Frequency Label
	    ButtonGroup group = new ButtonGroup();
	    group.add(BiWeeklyRB);
	    group.add(MonthlyRB);
	    
	    TypeLabel = new JLabel("Type:");
	    
	    //JRadioButtons assoc. w/Type Label
	    IncomeRB = new JRadioButton();
	    ExpenseRB = new JRadioButton();
	    
	    //Group RadioButtons assoc w/Type Label
	    ButtonGroup bGroup = new ButtonGroup();
	    bGroup.add(IncomeRB);
	    bGroup.add(ExpenseRB);
	    
	    //Add Components to RA
	    RecurringPanelRA.add(NameLabel);
	    RecurringPanelRA.add(RtdNameLabel);
	    RecurringPanelRA.add(AmountLabel);
	    RecurringPanelRA.add(RtdAmountLabel);
	    RecurringPanelRA.add(DueDateLabel);
	    RecurringPanelRA.add(RtdDueDate);
	    RecurringPanelRA.add(FrequencyLabel);
	    RecurringPanelRA.add(BiWeeklyRB);
	    RecurringPanelRA.add(MonthlyRB);
	    RecurringPanelRA.add(TypeLabel);
	    RecurringPanelRA.add(IncomeRB);
	    RecurringPanelRA.add(ExpenseRB);
	    
	    //Add Components to Panel
	    RecurringAddPanel.add(NameLabel);
	    RecurringAddPanel.add(RtdNameLabel);
	    RecurringAddPanel.add(space1);
	    RecurringAddPanel.add(AmountLabel);
	    RecurringAddPanel.add(RtdAmountLabel);
	    RecurringAddPanel.add(space2);
	    RecurringAddPanel.add(DueDateLabel);
	    RecurringAddPanel.add(RtdDueDate);
	    RecurringAddPanel.add(space3);
	    RecurringAddPanel.add(FrequencyLabel);
	    RecurringAddPanel.add(BiWeeklyRB);
	    RecurringAddPanel.add(MonthlyRB);
	    RecurringAddPanel.add(TypeLabel);
	    RecurringAddPanel.add(IncomeRB);
	    RecurringAddPanel.add(ExpenseRB);
	
	    return RecurringAddPanel;
	}

	public JPanel RecurringItemDisplayPanel(RecurringItem item)
	{
	    //JPanel, ComponentRA
	     JPanel RecurringDisplayPanel;
	     List<JComponent> RecurringPanelRA;
	    
	    //JLabels
	     JLabel NameLabel;
	     JLabel AmountLabel;
	     JLabel DueDateLabel;
	     JLabel FrequencyLabel;
	     JLabel TypeLabel;
	    
	    //JLabels (former TextFields)
	     JLabel RtdName;
	     JLabel RtdAmount;
	     JLabel RtdDueDate;
	    
	    //JRadioButtons
	     JRadioButton BiWeeklyRB;
	     JRadioButton MonthlyRB;
	     JRadioButton IncomeRB;
	     JRadioButton ExpenseRB;
	    
	    //Instantiate Panel, ComponentRA
	    RecurringDisplayPanel = new JPanel(new GridLayout(6, 3, 1, 0));
	    RecurringPanelRA = new ArrayList<JComponent>();
	    
	    //Instantiate Components
	    NameLabel = new JLabel("Name:");
	    RtdName = new JLabel(item.getName());
	    JLabel space1 = new JLabel("");
		JLabel space2 = new JLabel("");
		JLabel space3 = new JLabel("");
	    AmountLabel = new JLabel("Amount:");
	    RtdAmount = new JLabel(String.valueOf(item.getAmount()));
	    DueDateLabel = new JLabel("Day Charged/Received:");
	    RtdDueDate = new JLabel(item.getDueDate().toString());
	    FrequencyLabel = new JLabel("Repeats:");
	    
	    //Radio Button Instantiations
	    if(item.getFrequency() == 2)
	        {BiWeeklyRB = new JRadioButton("", true);
	         MonthlyRB = new JRadioButton();}
	    else if (item.getFrequency() == 4)
	        {MonthlyRB = new JRadioButton("", true);
	         BiWeeklyRB = new JRadioButton();}
	    else
	        {
	            BiWeeklyRB = new JRadioButton();
	            MonthlyRB = new JRadioButton();
	        }
	    
	    //Group RadioButtons assoc w/Frequency Label
	    ButtonGroup group = new ButtonGroup();
	    group.add(BiWeeklyRB);
	    group.add(MonthlyRB);
	    
	    TypeLabel = new JLabel("Type:");
	    
	    //Radio Button Instantiations
	    if(item.getType() == 1)
	        {IncomeRB = new JRadioButton("", true);
	        ExpenseRB = new JRadioButton();}
	    else if(item.getType() == 0)
	        {ExpenseRB = new JRadioButton("", true);
	        IncomeRB = new JRadioButton();}
	    else
	        {
	            IncomeRB = new JRadioButton();
	            ExpenseRB = new JRadioButton();
	        }
	    
	    //Group RadioButtons assoc w/Type Label
	    ButtonGroup buGroup = new ButtonGroup();
	    buGroup.add(IncomeRB);
	    buGroup.add(ExpenseRB);
	    
	    //Add Components to RA
	    RecurringPanelRA.add(NameLabel);
	    RecurringPanelRA.add(RtdName);
	    RecurringPanelRA.add(AmountLabel);
	    RecurringPanelRA.add(RtdAmount);
	    RecurringPanelRA.add(DueDateLabel);
	    RecurringPanelRA.add(RtdDueDate);
	    RecurringPanelRA.add(FrequencyLabel);
	    RecurringPanelRA.add(BiWeeklyRB);
	    RecurringPanelRA.add(MonthlyRB);
	    RecurringPanelRA.add(TypeLabel);
	    RecurringPanelRA.add(IncomeRB);
	    RecurringPanelRA.add(ExpenseRB);
	    
	    //Add Components to Panel
	    RecurringDisplayPanel.add(NameLabel);
	    RecurringDisplayPanel.add(RtdName);
	    RecurringDisplayPanel.add(space1);
	    RecurringDisplayPanel.add(AmountLabel);
	    RecurringDisplayPanel.add(RtdAmount);
	    RecurringDisplayPanel.add(space2);
	    RecurringDisplayPanel.add(DueDateLabel);
	    RecurringDisplayPanel.add(RtdDueDate);
	    RecurringDisplayPanel.add(space3);
	    RecurringDisplayPanel.add(FrequencyLabel);
	    RecurringDisplayPanel.add(BiWeeklyRB);
	    RecurringDisplayPanel.add(MonthlyRB);
	    RecurringDisplayPanel.add(TypeLabel);
	    RecurringDisplayPanel.add(IncomeRB);
	    RecurringDisplayPanel.add(ExpenseRB);

	    return RecurringDisplayPanel;
	}
}

