package mainpackage;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_WelcomeScreenPB extends JFrame implements ActionListener 
{
	/*
	 * Class Variables
	 * 
	 * Need to pass Session GUI on through, need to assign Global variable
	 * This class needs to "return" an account name, need a string and a getter function
	 */
	private static GUI_PersonalBudget SessionGUI_Global;
	private static PersonalBudgetGUI GUI = new PersonalBudgetGUI();
	private static GUI_AccountDisplayScreenPB AccountDisplay = new GUI_AccountDisplayScreenPB();
	
	private String TargetAccountName;
	
	public String getTargetAccountName()
	{
		return TargetAccountName;
	}
	
	/*
	 * JFrame:
	 */
	private JFrame WelcomeScreen_PB;
	
	/*
	 * JLabels (Welcome Message, Instructions):
	 */
	private JLabel Instruction_WSPB;
	private JLabel SessionDate_WSPB;
	
	/*
	 * Combo Box Variables (JCombo Box, Default ComboBox):
	 */
	private DefaultComboBoxModel AccountSelectionList_WSPB;
	//need to initialize above with elements in list
	private JComboBox AccountSelectionComboBox_WSPB;
	
	/*
	 * Button Variables (OK, Cancel):
	 */
	private JButton OKButton_WSPB, CancelButton_WSPB;
	
	/*
	 * GridBag Components (GridBagLayout, GridBagConstraints):
	 */
	private GridBagLayout GBLayout_WSPB = new GridBagLayout();
	private GridBagConstraints GBConstraints_WSPB = new GridBagConstraints();
	
	
	public void CreateAndShowWindow(GUI_PersonalBudget SessionGUI_Local)
	{
		/*
		 * Assign passed SessionGUI to Global variable to enable passing to next window
		 */
		SessionGUI_Global = SessionGUI_Local;
		
		/*
		 * Design JFrame that holds appropriate JComponents:
		 */
		WelcomeScreen_PB = new JFrame("Personal Budget Management Program");
		//Size
		WelcomeScreen_PB.setSize(300, 350);
		//Actions on Close
		WelcomeScreen_PB.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Layout Options
		WelcomeScreen_PB.setLayout(GBLayout_WSPB);
		
		/*
		 * Initialize and Add Frame Components to Layout:
		 */
		
		//Layout Component (0,1) Design and Initialization:
		Instruction_WSPB = new JLabel("Please select account:");
		GBConstraints_WSPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_WSPB.gridheight = 1;
		GBConstraints_WSPB.gridwidth = 1;
		GBConstraints_WSPB.gridx = 0;
		GBConstraints_WSPB.gridy = 1;
		GBConstraints_WSPB.ipady = 0;
		GBConstraints_WSPB.anchor = GridBagConstraints.LINE_START;
		
		//Add (0,1) Component to Layout
		WelcomeScreen_PB.add(Instruction_WSPB, GBConstraints_WSPB);
		
		//Layout Component (0,2) Design and Initialization:
		AccountSelectionList_WSPB = new DefaultComboBoxModel();
		
		for (Account temp : SessionGUI_Global.getAvailableAccounts())
		{
			AccountSelectionList_WSPB.addElement(temp);
		}
		
		AccountSelectionComboBox_WSPB = new JComboBox(AccountSelectionList_WSPB); //DON'T DELETE
		
		
		GBConstraints_WSPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_WSPB.gridheight = 1;
		GBConstraints_WSPB.gridwidth = 2;
		GBConstraints_WSPB.gridx = 0;
		GBConstraints_WSPB.gridy = 2;
		GBConstraints_WSPB.anchor = GridBagConstraints.LINE_START;
				
		//Add (0,2) Component to Layout
		WelcomeScreen_PB.add(AccountSelectionComboBox_WSPB, GBConstraints_WSPB);
		
		//Layout Component (0,3) Design and Initialization:
		OKButton_WSPB = new JButton("OK");
		//JButton Listeners
		OKButton_WSPB.addActionListener(this);
		GBConstraints_WSPB.fill = GridBagConstraints.HORIZONTAL; //Size of button?
		GBConstraints_WSPB.gridheight = 1;
		GBConstraints_WSPB.gridwidth = 1;
		GBConstraints_WSPB.gridx = 0;
		GBConstraints_WSPB.gridy = 3;
		GBConstraints_WSPB.ipady = 10;
		
		//Add (0,3) Component to Layout
		WelcomeScreen_PB.add(OKButton_WSPB, GBConstraints_WSPB);
		
		//Layout Component (1,3) Design and Initialization:
		CancelButton_WSPB = new JButton("Cancel");
		//JButton Listeners
		CancelButton_WSPB.addActionListener(this);
		GBConstraints_WSPB.fill = GridBagConstraints.HORIZONTAL; //Size of button?
		GBConstraints_WSPB.gridheight = 1;
		GBConstraints_WSPB.gridwidth = 1;
		GBConstraints_WSPB.gridx = 1;
		GBConstraints_WSPB.gridy = 3;
		GBConstraints_WSPB.ipady = 10;
		
		//Add (1,3) Component to Layout
		WelcomeScreen_PB.add(CancelButton_WSPB, GBConstraints_WSPB);
		
		//Visibility Options
		WelcomeScreen_PB.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == OKButton_WSPB)
		{
			TargetAccountName = AccountSelectionComboBox_WSPB.getSelectedItem().toString();
			AccountDisplay.CreateAndShowWindow(SessionGUI_Global, this); //this might not be the way to call next window
			WelcomeScreen_PB.dispose(); 
		}
		
		if (e.getSource() == CancelButton_WSPB)
		{
			PersonalBudgetGUI gui = new PersonalBudgetGUI();
			AccountItem item = new AccountItem("name", 0.00, new Date(),
					"category", 0);
			
			JPanel addPanel = gui.AccountItemAddPanel();
			JPanel initAddPanel = gui.AccountItemAddPanel(item);
			JPanel displayPanel = gui.AccountItemDisplayPanel(item);
			//PersonalBudgetGUI.AccountAddPanel innerObject = gui.new AccountAddPanel();
			
			JFrame frame = new JFrame("Account Information");
			//Size
			frame.setSize(600,650);
			//Actions on Close
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			//Layout Options
			frame.setLayout(new FlowLayout());
			
			frame.add(addPanel); //"are you sure?" message?
			frame.add(initAddPanel);
			frame.add(displayPanel);
			
			frame.setVisible(true);
		}
		
	}
	
	
}
