package mainpackage;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Account {
	
	private String accountName;
	private double accountTotal;
	private ArrayList<AccountItem> AccountItemRA = new ArrayList<AccountItem>();
	private ArrayList<RecurringAccountItem> ReccuringAI_RA = new ArrayList<RecurringAccountItem>();
	
	public Account() {
		super();
		this.accountName = "";
		this.accountTotal = -1;
		this.AccountItemRA.add(new AccountItem("dummyAccountItem", -1, new Date(), "dummycategory", -1));
	}
	
	/**
	 * @param accountName
	 * @param accountTotal
	 * @param categoryRA
	 * @param dateRA
	 * @param AccountItemRA
	 */
	public Account(String accountName, double accountTotal) {
		super();
		this.accountName = accountName;
		this.accountTotal = accountTotal;
	}
	
	public ArrayList<AccountItem> getAccountItemRA()
	{
		return this.AccountItemRA;
	}

	public String getAccountName() {
		return accountName;
	}
	public String toString()
	{
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAccountTotal() {
		return accountTotal;
	}

	public void setAccountTotal(double accountTotal) {
		this.accountTotal = accountTotal;
	}
	
	/*
	 * Retrieve Item Methods
	 */
	
	/*
	 * Retrieve by Name
	 */
	public List<AccountItem> retrieveAccountItemByName(String target)
	{
		List<AccountItem> TargetItemList = new ArrayList<AccountItem>();
		
		for (AccountItem temp : AccountItemRA) 
		{
			if(temp.getName().equals(target))
			{
				TargetItemList.add(temp);
			}
		}
		
		return TargetItemList;  
	}
	
	/*
	 * Retrieve by Category
	 */
	public List<AccountItem> retrieveAccountItemByCategory(String target)
	{
		List<AccountItem> TargetItemList = new ArrayList<AccountItem>();

		for (AccountItem temp : AccountItemRA) //what if multiple items of same name?
		{
			if(temp.getCategory().equals(target))
			{
				TargetItemList.add(temp);
			}
		}
		
		return TargetItemList;  
	}
	
	/*
	 * Retrieve by Date
	 */
	public List<AccountItem> retrieveAccountItemByDate(Date target)
	{
		List<AccountItem> TargetItemList = new ArrayList<AccountItem>();

		for (AccountItem temp : AccountItemRA) //what if multiple items of same name?
		{
			if(temp.getDate().equals(target))
			{
				TargetItemList.add(temp);
			}
		}
		
		return TargetItemList;  
	}
	
	/*
	 * Function to return Item based on amount
	 * > target
	 * < target, etc.
	 */

	public void addAccountItem(AccountItem toBeAdded)
	{
		String AccountItemName = toBeAdded.getName();
		double AccountItemAmount = toBeAdded.getAmount();
		String AccountItemCategory = toBeAdded.getCategory();
		Date AccountItemDate = toBeAdded.getDate();
		Integer AccountItemIncomeFlag = toBeAdded.getIncomeFlag();
		
		if(AccountItemIncomeFlag.equals(0))
			this.setAccountTotal(this.getAccountTotal() - AccountItemAmount); //adjust account total
		else if(AccountItemIncomeFlag.equals(1))
			this.setAccountTotal(this.getAccountTotal() + AccountItemAmount); //adjust account total
		else
			System.out.println("Invalid incomeFlag."); //need to add loop or chance to correct
		/*
		 * Take user to display screen and let them review, two options:
		 * 1) info is correct, click OK to add
		 * 2) info is incorrect, return to add item screen
		 */
		
		this.AccountItemRA.add(toBeAdded); //add AccountItem to array
		
	}
	/**
	 * Adds account items from arrayList pulled from the XMLReader
	 * @param toBeAdded
	 */
	public void addMultipleAccountItems(ArrayList<AccountItem> toBeAdded)
	{
		for(AccountItem it : toBeAdded)
		{
			this.addAccountItem(it);
		}
	}
	
	//need "removeAccountItem" function
	
	/*
	 * Method to create a panel that displays information for a single account item
	 *    - that panel is then added as a component of the gridbag
	 
	public void CreateAccountItemPanel(AccountItem targetItem)
	{
		AIDisplayPanel_RAAPB = new JPanel(new GridLayout(2, 2, 5, 0));
		
		AIDisplayPanelName_RAAPB = new JLabel(targetItem.getName());
		AIDisplayPanelCategory_RAAPB = new JLabel(targetItem.getCategory());
		AIDisplayPanelAmount_RAAPB = new JLabel(Double.toString(targetItem.getAmount()));
		AIDisplayPanelDate_RAAPB = new JLabel(targetItem.getDate().toString());
		
		AIDisplayPanel_RAAPB.add(AIDisplayPanelName_RAAPB);
		AIDisplayPanel_RAAPB.add(AIDisplayPanelCategory_RAAPB);
		AIDisplayPanel_RAAPB.add(AIDisplayPanelAmount_RAAPB);
		AIDisplayPanel_RAAPB.add(AIDisplayPanelDate_RAAPB);
	}*/

}
