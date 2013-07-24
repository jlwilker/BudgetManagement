package mainpackage;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI_AddItemScreenPB extends JFrame implements ActionListener 
{
	/*
	 * Class Variables
	 * 
	 */
	private static GUI_PersonalBudget SessionGUI_Global;
	private static GUI_WelcomeScreenPB WelcomeScreen_Global;
	private static GUI_AccountDisplayScreenPB AccountDisplay_Global;
	private static GUI_AddItemScreenPB AddItemScreen_Global = new GUI_AddItemScreenPB();
	
	/*
	 * Variables to be passed to "AddItem" Function
	 */
	String TargetItemName;
	double TargetItemAmount;
	Date TargetItemDate;
	String TargetItemCategory;
	Integer TargetItemIncomeFlag;
	AccountItem CreatedAccountItem;
	
	/*
	 * JFrame:
	 */
	private JFrame AddItemScreen_PB;
	
	/*
	 * JLabels (Welcome Message, Instructions):
	 */
	private JLabel ItemNameLabel_AIPB;
	private JLabel ItemAmountLabel_AIPB;
	private JLabel ItemDateLabel_AIPB;
	private JLabel TargetItemDateLabel_AIPB;
	private JLabel ItemCategoryLabel_AIPB;
	private JLabel IncomeFlagLabel_AIPB;
	
	/*
	 * JTextFields
	 */
	private JTextField TargetItemNameField_AIPB;
	private JTextField TargetItemAmountField_AIPB;
	private JTextField TargetItemCategoryField_AIPB;
	
	/*
	 * JCheckBoxes
	 */
	private JCheckBox TargetIncomeFlagCheckBox_AIPB;
	
	/*
	 * Button Variables (OK, Cancel):
	 */
	private JButton OKButton_AIPB, CancelButton_AIPB;
	
	/*
	 * GridBag Components (GridBagLayout, GridBagConstraints):
	 */
	private GridBagLayout GBLayout_AIPB = new GridBagLayout();
	private GridBagConstraints GBConstraints_AIPB = new GridBagConstraints();
	
	public void CreateAndShowWindow(GUI_PersonalBudget SessionGUI_Local, 
			GUI_WelcomeScreenPB WelcomeScreen_Local, GUI_AccountDisplayScreenPB AccountDisplay_Local)
	{
		/*
		 * Assign passed SessionGUI to Global variable to enable passing to next window
		 */
		SessionGUI_Global = SessionGUI_Local;
		WelcomeScreen_Global = WelcomeScreen_Local;
		AccountDisplay_Global = AccountDisplay_Local;
		
		/*
		 * Design JFrame:
		 */
		AddItemScreen_PB = new JFrame("Add Item");
		//Size
		AddItemScreen_PB.setSize(300,350);
		//Actions on Close
		AddItemScreen_PB.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Layout Options
		AddItemScreen_PB.setLayout(GBLayout_AIPB);
		
		/*
		 * Initialize and Add Components to Layout:
		 */
		
		//Layout Component (0,0) Design and Implementation:
		ItemNameLabel_AIPB = new JLabel("Item Name: ");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 0;
		GBConstraints_AIPB.gridy = 0;
		
		//Add Component (0,0) to Layout
		AddItemScreen_PB.add(ItemNameLabel_AIPB, GBConstraints_AIPB);
		
		//Layout Component (1,0) Design and Implementation:
		TargetItemNameField_AIPB = new JTextField("Enter Item Name");
		//TargetItemNameField_AIPB.setForeground(Color.gray);
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 1;
		GBConstraints_AIPB.gridy = 0;
		
		//Add Component (1,0) to Layout
		AddItemScreen_PB.add(TargetItemNameField_AIPB, GBConstraints_AIPB);
		
		//Layout Component (0,1) Design and Implementation:
		ItemAmountLabel_AIPB = new JLabel("Item Amount: ");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 0;
		GBConstraints_AIPB.gridy = 1;
		
		//Add Component (0,1) to Layout
		AddItemScreen_PB.add(ItemAmountLabel_AIPB, GBConstraints_AIPB);
		
		//Layout Component (1,1) Design and Implementation:
		TargetItemAmountField_AIPB = new JTextField("Enter Item Amount");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 1;
		GBConstraints_AIPB.gridy = 1;
		
		//Add Component (1,1) to Layout
		AddItemScreen_PB.add(TargetItemAmountField_AIPB, GBConstraints_AIPB);
		
		//Layout Component (0,2) Design and Implementation:
		ItemDateLabel_AIPB = new JLabel("Item Date: ");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 0;
		GBConstraints_AIPB.gridy = 2;
		
		//Add Component (0,2) to Layout
		AddItemScreen_PB.add(ItemDateLabel_AIPB, GBConstraints_AIPB);
		
		//Layout Component (1,2) Design and Implementation:
		TargetItemDate = SessionGUI_Global.getSessionDate().getTime();
		TargetItemDateLabel_AIPB = new JLabel(TargetItemDate.toString());
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 1;
		GBConstraints_AIPB.gridy = 2;
		
		//Add Component (1,2) to Layout
		AddItemScreen_PB.add(TargetItemDateLabel_AIPB, GBConstraints_AIPB);
		
		//Layout Component (0,3) Design and Implementation:
		ItemCategoryLabel_AIPB = new JLabel("Item Category: ");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 0;
		GBConstraints_AIPB.gridy = 3;
		
		//Add Component (0,3) to Layout
		AddItemScreen_PB.add(ItemCategoryLabel_AIPB, GBConstraints_AIPB);
		
		//Layout Component (1,3) Design and Implementation:
		TargetItemCategoryField_AIPB = new JTextField("Enter Item Category");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 1;
		GBConstraints_AIPB.gridy = 3;
		
		//Add Component (1,3) to Layout
		AddItemScreen_PB.add(TargetItemCategoryField_AIPB, GBConstraints_AIPB);
		
		//Layout Component (0,4) Design and Implementation:
		TargetIncomeFlagCheckBox_AIPB = new JCheckBox();
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 0;
		GBConstraints_AIPB.gridy = 4;
		TargetIncomeFlagCheckBox_AIPB.addActionListener(this);
		
		//Add Component (0,4) to Layout
		AddItemScreen_PB.add(TargetIncomeFlagCheckBox_AIPB, GBConstraints_AIPB);
		
		//Layout Component (1,4) Design and Implementation:
		IncomeFlagLabel_AIPB = new JLabel("Check if Income");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 1;
		GBConstraints_AIPB.gridy = 4;
		
		//Add Component (1,4) to Layout
		AddItemScreen_PB.add(IncomeFlagLabel_AIPB, GBConstraints_AIPB);
		
		//Layout Component (0,5) Design and Implementation:
		OKButton_AIPB = new JButton("OK");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 0;
		GBConstraints_AIPB.gridy = 5;
		OKButton_AIPB.addActionListener(this);
		
		//Add Component (0,5) to Layout
		AddItemScreen_PB.add(OKButton_AIPB, GBConstraints_AIPB);
		
		//Layout Component (1,5) Design and Implementation:
		CancelButton_AIPB = new JButton("Cancel");
		GBConstraints_AIPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_AIPB.gridheight = 1;
		GBConstraints_AIPB.gridwidth = 1;
		GBConstraints_AIPB.gridx = 1;
		GBConstraints_AIPB.gridy = 5;
		CancelButton_AIPB.addActionListener(this);
		
		//Add Component (1,6) to Layout
		AddItemScreen_PB.add(CancelButton_AIPB, GBConstraints_AIPB);
		
		//Visibility Options
		AddItemScreen_PB.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == TargetIncomeFlagCheckBox_AIPB)
		{
			if (TargetIncomeFlagCheckBox_AIPB.getSelectedObjects() == null)
			{
				TargetItemIncomeFlag = 0;
			}
			else if (TargetIncomeFlagCheckBox_AIPB.getSelectedObjects() != null)
			{
				TargetItemIncomeFlag = 1;
			}
		}
		
		if (e.getSource() == OKButton_AIPB)
		{
			/*
			 * Get text from TextFields and make new Item (Put in function?)
			 */
			TargetItemName = TargetItemNameField_AIPB.getText();
			TargetItemAmount = Double.parseDouble(TargetItemAmountField_AIPB.getText());
			//date is already set: TargetItemDate
			TargetItemCategory = TargetItemCategoryField_AIPB.getText();
			
			//get IncomeFlag value
			if (TargetIncomeFlagCheckBox_AIPB.getSelectedObjects() == null)
			{
				TargetItemIncomeFlag = 0;
			}
			else if (TargetIncomeFlagCheckBox_AIPB.getSelectedObjects() != null)
			{
				TargetItemIncomeFlag = 1;
			}
			
			CreatedAccountItem = new AccountItem(TargetItemName, TargetItemAmount, TargetItemDate,
					TargetItemCategory, TargetItemIncomeFlag);
			/*
			 * Add New Item to Appropriate Account
			 */
			AccountDisplay_Global.TargetAccount.addAccountItem(CreatedAccountItem);
			
			//call next window
			AddItemScreen_PB.dispose(); //call "edit item" window, with newly added item details
		}
		
		if (e.getSource() == CancelButton_AIPB)
		{
			AddItemScreen_PB.dispose(); //"are you sure?" message?
		}
		
	}
}
