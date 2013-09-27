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

//import mainpackage.mysql.Retrieve;
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
	
	private JPanel UpcomingActivityPanel_PB;
	private JPanel UpcomingActivityPanel_ADPB;
	
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
	
	private JLabel UpcomingActivityLabel_PB;
	private JLabel UpcomingActivityLabel_ADPB;
	
	/*
	 * Button Variables (OK, Cancel):
	 */
	private JButton OKButton_ADPB, CancelButton_ADPB;
	private JButton AddItemButton_ADPB;
	private JButton DisplayItemButton_ADPB;
	private JButton	RecentActivityButton_ADPB;
	
	/*
	 * MySQL Retrieve Commands
	 */
	//Retrieve retrieve = new Retrieve();
	
	/*
	 * GridBag Components (GridBagLayout, GridBagConstraints):
	 */
	private GridBagLayout GBLayout_ADPB = new GridBagLayout();
	private GridBagConstraints GBConstraints_ADPB = new GridBagConstraints();
	
	//Get rid of below function b/c replaced w/horizontal display?
	public JPanel CreateAccountItemPanel(AccountItem targetItem)
	{
		AIDisplayPanel_PB = new JPanel(new GridLayout(2, 2, 1, 2));
		
		AIDisplayPanelName_PB = new JLabel(targetItem.getName());
		//change show that $ symbol can be changed w/language pack?
		//Need to update with Decimal Format so that it looks like "X.XX" instead of "X.X"
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
		//Use variable so that when adding/subtracting, don't have to constantly update
		int gridValueY = 0; 
		
		//Layout Component (0,0) Design and Implementation:
		AccountNameLabel_ADPB = new JLabel("Account Name: ");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = gridValueY;
		
		//Add Component (0,0) to Layout
		AccountDisplayScreen_PB.add(AccountNameLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,0) Design and Implementation:
		TargetAccountNameLabel_ADPB = new JLabel(TargetAccount.getAccountName());
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 1;
		GBConstraints_ADPB.gridy = gridValueY;
		
		//Add Component (1,0) to Layout
		AccountDisplayScreen_PB.add(TargetAccountNameLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (0,2) Design and Implementation:
		AccountTotalLabel_ADPB = new JLabel("Account Total: ");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = ++gridValueY;
		
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
		GBConstraints_ADPB.gridy = gridValueY;
		
		//Add Component (1,2) to Layout
		AccountDisplayScreen_PB.add(TargetAccountTotalLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (0,3) Design and Implementation:
		AccountNameLabel_ADPB = new JLabel("----------------------------------------");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 2;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = ++gridValueY;
		
		//Add Component (0,3) to Layout
		AccountDisplayScreen_PB.add(AccountNameLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (0,4) Design and Implementation:
		AccountNameLabel_ADPB = new JLabel("Upcoming Activity: ");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = ++gridValueY;
		
		//Add Component (0,4) to Layout
		AccountDisplayScreen_PB.add(AccountNameLabel_ADPB, GBConstraints_ADPB);
		
		/*
		 * This populates the resultSetRA with appropriate values
		 */
		//retrieve.upcomingActivityRetrieveMySQL(); //uncomment once mysql is back
		
		//this is going to need to be updated for Accounts that have large numbers of items
		/*//probably going to need to be outside function, because will need passed in boundary
		for(gridValueY=5; gridValueY < retrieve.getResultSetRA().size()+5; gridValueY++) 
		{	
			UpcomingActivityPanel_ADPB = CreateAccountItemPanel
					(retrieve.getResultSetRA().get(gridValueY-5));
			
			//Layout Component (0,i) Design and Implementation
			GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
			GBConstraints_ADPB.gridheight = 1;
			GBConstraints_ADPB.gridwidth = 2;
			GBConstraints_ADPB.gridx = 0;
			GBConstraints_ADPB.gridy = gridValueY;
			GBConstraints_ADPB.weightx = 1;
			
			//Add Component (0,i) to Layout
			AccountDisplayScreen_PB.add(UpcomingActivityPanel_ADPB, GBConstraints_ADPB);
		}*/
		
		//Layout Component (0,5) Design and Implementation:
		AccountNameLabel_ADPB = new JLabel("----------------------------------------");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 2;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = ++gridValueY;
		
		//Add Component (0,5) to Layout
		AccountDisplayScreen_PB.add(AccountNameLabel_ADPB, GBConstraints_ADPB);
		
		//Layout Component (0,6) Design and Implementation:
		AddItemButton_ADPB = new JButton("Add Item");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = ++gridValueY;
		GBConstraints_ADPB.ipadx = 10;
		AddItemButton_ADPB.addActionListener(this);
		
		//Add Component (0,6) to Layout
		AccountDisplayScreen_PB.add(AddItemButton_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,6) Design and Implementation:
		DisplayItemButton_ADPB = new JButton("Display Item");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 1;
		GBConstraints_ADPB.gridy = gridValueY;
		GBConstraints_ADPB.ipadx = 10;
		DisplayItemButton_ADPB.addActionListener(this);
		
		//Add Component (1,6) to Layout
		AccountDisplayScreen_PB.add(DisplayItemButton_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,7) Design and Implementation:
		RecentActivityButton_ADPB = new JButton("Recent Activity");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = ++gridValueY;
		RecentActivityButton_ADPB.addActionListener(this);
		
		//Add Component (1,7) to Layout
		AccountDisplayScreen_PB.add(RecentActivityButton_ADPB, GBConstraints_ADPB);

		//Layout Component (0,8) Design and Implementation:
		OKButton_ADPB = new JButton("OK");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 0;
		GBConstraints_ADPB.gridy = ++gridValueY;
		OKButton_ADPB.addActionListener(this);
		
		//Add Component (0,8) to Layout
		AccountDisplayScreen_PB.add(OKButton_ADPB, GBConstraints_ADPB);
		
		//Layout Component (1,8) Design and Implementation:
		CancelButton_ADPB = new JButton("Cancel");
		GBConstraints_ADPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_ADPB.gridheight = 1;
		GBConstraints_ADPB.gridwidth = 1;
		GBConstraints_ADPB.gridx = 1;
		GBConstraints_ADPB.gridy = gridValueY;
		CancelButton_ADPB.addActionListener(this);
		
		//Add Component (1,8) to Layout
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
			writer.writeXML(SessionGUI_Global.getAvailableAccounts());
			
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
