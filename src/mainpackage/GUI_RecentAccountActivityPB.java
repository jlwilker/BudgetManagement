package mainpackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_RecentAccountActivityPB extends JFrame implements ActionListener 
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
	 * JFrame:
	 */
	private JFrame RecentAccountActivity_PB;
	
	/*
	 * JPanel:
	 */
	private JPanel AIDisplayPanel_RAAPB = new JPanel();
	
	/*
	 * Button Variables (OK, Cancel):
	 */
	private JButton OKButton_RAAPB, CancelButton_RAAPB;
	
	/*
	 * GridBag Components (GridBagLayout, GridBagConstraints):
	 */
	private GridBagLayout GBLayout_RAAPB = new GridBagLayout();
	private GridBagConstraints GBConstraints_RAAPB = new GridBagConstraints();
	
	public void CreateAndShowWindow(GUI_PersonalBudget SessionGUI_Local, 
			GUI_WelcomeScreenPB WelcomeScreen_Local, 
			GUI_AccountDisplayScreenPB AccountDisplay_Local)
	{
		/*
		 * Assign passed SessionGUI to Global variable to enable passing to next window
		 */
		SessionGUI_Global = SessionGUI_Local;
		WelcomeScreen_Global = WelcomeScreen_Local;
		AccountDisplay_Global = AccountDisplay_Local;
		
		//Account*
		Account TargetAccount = AccountDisplay_Global.getTargetAccount();
		
		/*
		 * Design JFrame:
		 */
		RecentAccountActivity_PB = new JFrame("Recent Activity for " + 
		 AccountDisplay_Global.TargetAccount.toString());
		//Size
		RecentAccountActivity_PB.setSize(300,350);
		//Actions on Close
		RecentAccountActivity_PB.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Layout Options
		RecentAccountActivity_PB.setLayout(GBLayout_RAAPB);
		
		/*
		 * Initialize and Add Components to Layout:
		 */
		//Grid will have variable amount of Y sections
		int gridValueY;
		
		//this is going to need to be updated for Accounts that have large numbers of items
		//probably going to need to be outside function, because will need passed in boundary
		for(gridValueY=0; gridValueY < TargetAccount.getAccountItemRA().size(); gridValueY++) 
		{	
			AIDisplayPanel_RAAPB = AccountDisplay_Global.CreateAccountItemPanel
					(TargetAccount.getAccountItemRA().get(gridValueY));
			
			//Layout Component (0,i) Design and Implementation
			GBConstraints_RAAPB.fill = GridBagConstraints.HORIZONTAL;
			GBConstraints_RAAPB.gridheight = 1;
			GBConstraints_RAAPB.gridwidth = 2;
			GBConstraints_RAAPB.gridx = 0;
			GBConstraints_RAAPB.gridy = gridValueY;
			GBConstraints_RAAPB.weightx = 1;
			
			//Add Component (0,i) to Layout
			RecentAccountActivity_PB.add(AIDisplayPanel_RAAPB, GBConstraints_RAAPB);
		}
		
		//Layout Component (0,++gridValueY) Design and Implementation:
		OKButton_RAAPB = new JButton("OK");
		GBConstraints_RAAPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_RAAPB.gridheight = 1;
		GBConstraints_RAAPB.gridwidth = 1;
		GBConstraints_RAAPB.gridx = 0;
		GBConstraints_RAAPB.gridy = ++gridValueY;
		OKButton_RAAPB.addActionListener(this);
		
		//Add Component (0,++gridValueY) to Layout
		RecentAccountActivity_PB.add(OKButton_RAAPB, GBConstraints_RAAPB);
		
		//Layout Component (1,gridValueY) Design and Implementation:
		CancelButton_RAAPB = new JButton("Cancel");
		GBConstraints_RAAPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_RAAPB.gridheight = 1;
		GBConstraints_RAAPB.gridwidth = 1;
		GBConstraints_RAAPB.gridx = 1;
		GBConstraints_RAAPB.gridy = gridValueY; 
		CancelButton_RAAPB.addActionListener(this);
		
		//Add Component (1,gridValueY) to Layout
		RecentAccountActivity_PB.add(CancelButton_RAAPB, GBConstraints_RAAPB);
		
		//Visibility Options
		RecentAccountActivity_PB.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == OKButton_RAAPB)
		{
			//next window or appropriate
			RecentAccountActivity_PB.dispose(); 
		}
		
		if (e.getSource() == CancelButton_RAAPB)
		{
			RecentAccountActivity_PB.dispose(); //"are you sure?" message?
		}
		
	}
	
}
