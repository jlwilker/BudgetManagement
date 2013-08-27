package mainpackage;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Account 
{
	
	private String accountName;
	private double accountTotal;
	private List<AccountItem> AccountItemRA = new ArrayList<AccountItem>();
	
	/**
	 * Create a default Account with dummy data
	 */
	public Account() 
	{
		this.accountName = "";
		this.accountTotal = -1;
	}
	
	/**
	 * Create an Account with the given attributes
	 * 
	 * @param accountName
	 * @param accountTotal
	 */
	public Account(String accountName, double accountTotal) 
	{
		this.accountName = accountName;
		this.accountTotal = accountTotal;
	}
	
	public List<AccountItem> getAccountItemRA()
	{
		return this.AccountItemRA;
	}

	public String getAccountName() 
	{
		return accountName;
	}
	public String toString()
	{
		return accountName;
	}

	public void setAccountName(String accountName) 
	{
		this.accountName = accountName;
	}

	public double getAccountTotal() 
	{
		return accountTotal;
	}

	public void setAccountTotal(double accountTotal) 
	{
		this.accountTotal = accountTotal;
	}
	
	/*
	 * Retrieve Item Methods
	 */
	
	/**
	 * Method to retrieve a list of account items with a given name
	 * 
	 * @param target
	 * @return List<AccountItem>
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
	
	/**
	 * Method to retrieve a list of account items with a given category
	 * 
	 * @param target
	 * @return List<AccountItem>
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
	
	/**
	 * Method to retrieve a list of account items with a given date
	 * 
	 * @param target
	 * @return List<AccountItem>
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

	/**
	 * Method to add an AccountItem to an Account
	 * 
	 * @param toBeAdded
	 */
	public void addAccountItem(AccountItem toBeAdded)
	{
		double AccountItemAmount = toBeAdded.getAmount();
		Integer AccountItemIncomeFlag = toBeAdded.getIncomeFlag();
		
		if(AccountItemIncomeFlag.equals(0))
			//adjust account total
			this.setAccountTotal(this.getAccountTotal() - AccountItemAmount); 
		else if(AccountItemIncomeFlag.equals(1))
			//adjust account total
			this.setAccountTotal(this.getAccountTotal() + AccountItemAmount); 
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
	 * Method to add an AccountItem to an Account from a file
	 * 
	 *  - Must be different from above method or else 
	 *    each AccountItem gets subtracted from the Account
	 *    total on every startup.
	 * 
	 * @param toBeAdded
	 */
	public void addAccountItemFromFile(AccountItem toBeAdded)
	{
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
			this.addAccountItemFromFile(it);
		}
	}
	
	//need "removeAccountItem" function
	/**
	* Goes in Account Class, function to remove AccountItem from a given Account
	*/

	public void RemoveAccountItem(AccountItem targetItem) 
	{
	    for (AccountItem temp : this.getAccountItemRA())
	    {
	        if (this.compareAccountItems(targetItem, temp))
	        {
	            this.AccountItemRA.remove(temp);
	        }
	    }    
	}

	/**
	* Goes in Account Class, function to compare two AccountItems
	*/

	public boolean compareAccountItems(AccountItem itemA, AccountItem itemB)
	{
		return((itemA.getName().equals(itemB.getName()) && 
			    (itemA.getAmount() == itemB.getAmount())) &&
			    (itemA.getCategory().equals(itemB.getCategory())) &&
			    (itemA.getDate().equals(itemB.getDate())) &&
			    (itemA.getIncomeFlag() == itemB.getIncomeFlag()));

	}
}
