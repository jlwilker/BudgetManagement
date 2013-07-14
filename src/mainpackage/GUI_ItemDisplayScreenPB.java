package mainpackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_ItemDisplayScreenPB extends JFrame implements ActionListener
{
	/*
	 * Class Variables
	 * 
	 */
	private static GUI_PersonalBudget SessionGUI_Global;
	private static GUI_WelcomeScreenPB WelcomeScreen_Global;
	private static GUI_AccountDisplayScreenPB AccountDisplay_Global;
	private static GUI_AddItemScreenPB AddItemScreen_Global;
	private static GUI_ItemDisplayScreenPB ItemDisplayScreen_Global = new GUI_ItemDisplayScreenPB();
	
	//Account and Account Items
	Account TargetAccount = AccountDisplay_Global.TargetAccount;
	
	/*
	 * JFrame:
	 */
	private JFrame ItemDisplayScreen_PB;
	
	/*
	 * JPanel
	 */
	private JPanel AIDisplayPanel_IDSPB;
	
	/*
	 * Button Variables (OK, Cancel):
	 */
	private JButton OKButton_IDSPB, CancelButton_IDSPB;
	
	/*
	 * GridBag Components (GridBagLayout, GridBagConstraints):
	 */
	private GridBagLayout GBLayout_IDSPB = new GridBagLayout();
	private GridBagConstraints GBConstraints_IDSPB = new GridBagConstraints();
	
	public void CreateAndShowWindow(GUI_PersonalBudget SessionGUI_Local, 
			GUI_WelcomeScreenPB WelcomeScreen_Local, 
			GUI_AccountDisplayScreenPB AccountDisplay_Local,
			GUI_AddItemScreenPB AddItemScreen_Local,
			AccountItem TargetItem)
	{
		/*
		 * Assign passed SessionGUI to Global variable to enable passing to next window
		 */
		SessionGUI_Global = SessionGUI_Local;
		WelcomeScreen_Global = WelcomeScreen_Local;
		AccountDisplay_Global = AccountDisplay_Local;
		AddItemScreen_Global = AddItemScreen_Local;
		
		//TargetItem = ;
		
		/*
		 * Design JFrame:
		 */
		ItemDisplayScreen_PB = new JFrame();
		//Size
		ItemDisplayScreen_PB.setSize(300,350);
		//Actions on Close
		ItemDisplayScreen_PB.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Layout Options
		ItemDisplayScreen_PB.setLayout(GBLayout_IDSPB);
		
		/*
		 * Initialize and Add Components to Layout:
		 */
		//Layout Component (0,0) Design and Implementation:
		AIDisplayPanel_IDSPB = new JPanel();
		GBConstraints_IDSPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_IDSPB.gridheight = 1;
		GBConstraints_IDSPB.gridwidth = 2;
		GBConstraints_IDSPB.gridx = 0;
		GBConstraints_IDSPB.gridy = 0;
		
		//Add Component (0,0) to Layout
		ItemDisplayScreen_PB.add(OKButton_IDSPB, GBConstraints_IDSPB);
		
		//Layout Component (0,5) Design and Implementation:
		OKButton_IDSPB = new JButton("OK");
		GBConstraints_IDSPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_IDSPB.gridheight = 1;
		GBConstraints_IDSPB.gridwidth = 1;
		GBConstraints_IDSPB.gridx = 0;
		GBConstraints_IDSPB.gridy = 5;
		OKButton_IDSPB.addActionListener(this);
		
		//Add Component (0,5) to Layout
		ItemDisplayScreen_PB.add(OKButton_IDSPB, GBConstraints_IDSPB);
		
		//Layout Component (1,5) Design and Implementation:
		CancelButton_IDSPB = new JButton("Cancel");
		GBConstraints_IDSPB.fill = GridBagConstraints.HORIZONTAL;
		GBConstraints_IDSPB.gridheight = 1;
		GBConstraints_IDSPB.gridwidth = 1;
		GBConstraints_IDSPB.gridx = 1;
		GBConstraints_IDSPB.gridy = 5;
		CancelButton_IDSPB.addActionListener(this);
		
		//Add Component (1,6) to Layout
		ItemDisplayScreen_PB.add(CancelButton_IDSPB, GBConstraints_IDSPB);
		
		//Visibility Options
		ItemDisplayScreen_PB.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == OKButton_IDSPB)
		{
			//next window or appropriate
			ItemDisplayScreen_PB.dispose(); 
		}
		
		if (e.getSource() == CancelButton_IDSPB)
		{
			ItemDisplayScreen_PB.dispose(); //"are you sure?" message?
		}
	}

}
