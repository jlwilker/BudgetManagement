package mainpackage;

import java.awt.GridLayout;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_PersonalBudget {
	private static GUI_WelcomeScreenPB WelcomeScreen;
	private static GUI_AccountDisplayScreenPB AccountDisplay;
	private static Calendar sessionDate;
	
	private static ArrayList<Account> AvailableAccounts = new ArrayList<Account>();
	
	public ArrayList<Account> getAvailableAccounts()
	{
		return AvailableAccounts;
	}
	
	
	public Calendar getSessionDate() {
		return sessionDate;
	}


	public void setSessionDate(Calendar sessionDate) {
		GUI_PersonalBudget.sessionDate = sessionDate;
	}


	public GUI_PersonalBudget()
	{
		/*
		 * Create Calendar Reference for Session
		 */
		setSessionDate(Calendar.getInstance());
		
		//Initialize Array for Testing:
		Account AccountOne, AccountTwo;
		AccountItem AccountOneItemOne, AccountOneItemTwo, AccountTwoItemOne, AccountTwoItemTwo;
		
		AccountOne = new Account("Account One", 305.11);
		AccountOneItemOne = new AccountItem("A1 Item1", 2.34, new Date(), "Food", 0);
		AccountOneItemTwo = new AccountItem("A1 Item2", 4.59, new Date(), "Entertainment", 0);
		AccountOne.addAccountItem(AccountOneItemOne);
		AccountOne.addAccountItem(AccountOneItemTwo);
		
		AccountTwo = new Account("Account Two", 3942.12);
		AccountTwoItemOne = new AccountItem("A2 Item1", 692.06, new Date(), "Paycheck", 1);
		AccountTwoItemTwo = new AccountItem("A2 Item2", 63.21, new Date(), "Groceries", 0);
		AccountTwo.addAccountItem(AccountTwoItemOne);
		AccountTwo.addAccountItem(AccountTwoItemTwo);
		
		AvailableAccounts.add(AccountOne);
		AvailableAccounts.add(AccountTwo);
		
		//*
		WelcomeScreen = new GUI_WelcomeScreenPB();
		
		WelcomeScreen.CreateAndShowWindow(this); 
	}

}
