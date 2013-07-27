package mainpackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mainpackage.xml.XMLWriter;

public class GUI_AccountDisplayScreenPB extends JFrame implements ActionListener 
{
	/*
	 * Class Variables
	 * 
	 */
	private static GUI_PersonalBudget SessionGUI_Global;
	private static GUI_WelcomeScreenPB WelcomeScreen_Global;
	private static GUI_RecentAccountActivityPB RecentAccountActivity_Global = new GUI_RecentAccountActivityPB();
	private static GUI_AddItemScreenPB AddItemScreen_Global = new GUI_AddItemScreenPB();
	
	/*
	 * Account to be operated on with Getter
	 */
	Account TargetAccount = new Account();
	
	public Account getTargetAccount()
	{
		return this.TargetAccount;
	}
	
	/*
	 * JFrame:
	 */
	private JFrame AccountDisplayScreen_PB;
	
	/*
	 * JPanel:
	 */
	private JPanel AIDisplayPanel_PB;
	
	/*
	 * JLabels (Welcome Message, Instructions):
	 */
	private JLabel AccountNameLabel_ADPB;
	private JLabel TargetAccountNameLabel_ADPB;
	private JLabel AccountTotalLabel_ADPB;
	private JLabel TargetAccountTotalLabel_ADPB;
	
	private JLabel AIDisplayPanelName_PB;
	private JLabel AIDisplayPanelCategory_PB;
	private JLabel AIDisplayPanelAmount_PB;
	private JLabel AIDisplayPanelDate_PB;
	
	/*
	 * Button Variables (OK, Cancel):
	 */
	private JButton OKButton_ADPB, CancelButton_ADPB;
	private JButton AddItemButton_ADPB;
	private JButton DisplayItemButton_ADPB;
	private JButton	RecentActivityButton_ADPB;
	
	/*
	 * GridBag Components (GridBagLayout, GridBagConstraints):
	 */
	private GridBagLayout GBLayout_ADPB = new GridBagLayout();
	private GridBagConstraints GBConstraints_ADPB = new GridBagConstraints();
	
	public JPanel CreateAccountItemPanel(AccountItem targetItem)
	{
		AIDisplayPanel_PB = new JPanel(new GridLayout(2, 2, 1, 0));
		
		AIDisplayPanelName_PB = new JLabel(targetItem.getName());
		//change show that $ symbol can be changed w/language pack?
		AIDisplayPanelAmount_PB = new JLabel("$" + Double.toString(targetItem.getAmount()));
		AIDisplayPanelCategory_PB = new JLabel(targetItem.getCategory());
		AIDisplayPanelDate_PB = new JLabel(DateFormat.getInstance().format(targetItem.getDate()));
		
		AIDisplayPanel_PB.add(AIDisplayPanelName_PB);
		AIDisplayPanel_PB.add(AIDisplayPanelAmount_PB);
		AIDisplayPanel_PB.add(AIDisplayPanelCategory_PB);
		AIDisplayPanel_PB.add(AIDisplayPanelDate_PB);
		
		return AIDisplayPanel_PB;
	}
	
	public void CreateAndShowWindow(GUI_PersonalBudget SessionGUI_Local, 
			GUI_WelcomeScreenPB WelcomeScreen_Local)
	{
		/*
		 * Assign passed SessionGUI to Global variable to enable passing to next window
		 */
		SessionGUI_Global = SessionGUI_Local;
		WelcomeScreen_Global = WelcomeScreen_Local;
		
		//Get Account Information from GUI AvailableAccounts Array
		String TargetAccountName = new String(WelcomeScreen_Global.getTargetAccountName());
		
		for (Account temp : SessionGUI_Global.getAvailableAccounts())
		{
			if(temp.getAccountName().equals(TargetAccountName))
			{
				TargetAccount = temp;
			}
		}
		
		/*
		 * Design JFrame:
		 */
		AccountDisplayScreen_PB = new JFrame("Account Information");
		//Size
		AccountDisplayScreen_PB.setSize(300,350);
		//Actions on Close
		AccountDisplayScreen_PB.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Layout Options
		AccountDisplayScreen_PB.setLayout(GBLayout_ADPB);
		
		/*
		 * Initialize and Add Components to Layout:
		 */
		
		//Layout Component (0,0) Design and Implementation:
		AccountNameLabel_ADPB = new JLabel("Account Name: ");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = 0;
		
		//Add Component (0,0) to Layout
		AccountDisplayScreen_PB.add(AccountNameLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,0) Design and Implementation:
		TargetAccountNameLabel_ADPB = new JLabel(TargetAccount.getAccountName());
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 1;
		GBConstraints_ADPB.gridy = 0;
		
		//Add Component (1,0) to Layout
		AccountDisplayScreen_PB.add(TargetAccountNameLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (0,2) Design and Implementation:
		AccountTotalLabel_ADPB = new JLabel("Account Total: ");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = 2;
		
		//Add Component (0,2) to Layout
		AccountDisplayScreen_PB.add(AccountTotalLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,2) Design and Implementation:
		//Decimal Format
		DecimalFormat DF = new DecimalFormat("#.##");
		TargetAccountTotalLabel_ADPB = new JLabel("$" + DF.format(TargetAccount.getAccountTotal()));
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 1;
		GBConstraints_ADPB.gridy = 2;
		
		//Add Component (1,2) to Layout
		AccountDisplayScreen_PB.add(TargetAccountTotalLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (0,3) Design and Implementation:
		AddItemButton_ADPB = new JButton("Add Item");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = 3;
		GBConstraints_ADPB.ipadx = 10;
		AddItemButton_ADPB.addActionListener(this);
		
		//Add Component (0,3) to Layout
		AccountDisplayScreen_PB.add(AddItemButton_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,3) Design and Implementation:
		DisplayItemButton_ADPB = new JButton("Display Item");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 1;
		GBConstraints_ADPB.gridy = 3;
		GBConstraints_ADPB.ipadx = 10;
		DisplayItemButton_ADPB.addActionListener(this);
		
		//Add Component (1,3) to Layout
		AccountDisplayScreen_PB.add(DisplayItemButton_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,3) Design and Implementation:
		RecentActivityButton_ADPB = new JButton("Recent Activity");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = 4;
		RecentActivityButton_ADPB.addActionListener(this);
		
		//Add Component (1,3) to Layout
		AccountDisplayScreen_PB.add(RecentActivityButton_ADPB, GBConstraints_ADPB);

		//Layout Component (0,6) Design and Implementation:
		OKButton_ADPB = new JButton("OK");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = 6;
		OKButton_ADPB.addActionListener(this);
		
		//Add Component (0,6) to Layout
		AccountDisplayScreen_PB.add(OKButton_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,6) Design and Implementation:
		CancelButton_ADPB = new JButton("Cancel");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 1;
		GBConstraints_ADPB.gridy = 6;
		CancelButton_ADPB.addActionListener(this);
		
		//Add Component (1,6) to Layout
		AccountDisplayScreen_PB.add(CancelButton_ADPB, GBConstraints_ADPB);
		
		//Visibility Options
		AccountDisplayScreen_PB.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == OKButton_ADPB)
		{
			//delete later, but testing now
			XMLWriter writer = new XMLWriter();
			writer.writeXML();
			
			//call next window
			AccountDisplayScreen_PB.dispose(); 
		}
		
		if (e.getSource() == CancelButton_ADPB)
		{
			AccountDisplayScreen_PB.dispose(); //"are you sure?" message?
		}
		
		if(e.getSource() == AddItemButton_ADPB)
		{
			System.out.println("Add Item Window");
			AddItemScreen_Global.CreateAndShowWindow(SessionGUI_Global, WelcomeScreen_Global, this);
		}
		
		if(e.getSource() == DisplayItemButton_ADPB)
		{
			System.out.println("Display Item Window");
		}
		
		if(e.getSource() == RecentActivityButton_ADPB)
		{
			RecentAccountActivity_Global.CreateAndShowWindow(SessionGUI_Global, WelcomeScreen_Global, this);
		}
	}

}
