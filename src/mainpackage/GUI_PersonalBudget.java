package mainpackage;

import java.awt.GridLayout;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packageGUI.WelcomeScreen;
import mainpackage.xml.XMLReader;

public class GUI_PersonalBudget 
{
	//DELETE LATER MAYBE
	private static WelcomeScreen theOtherWelcomeScreen;
	protected static PersonalBudgetGUI GUI_Functions = new PersonalBudgetGUI();
	
	private static GUI_WelcomeScreenPB WelcomeScreen;
	private static GUI_AccountDisplayScreenPB AccountDisplay;
	private static Calendar sessionDate;
	
	protected static ArrayList<Account> AvailableAccounts = new ArrayList<Account>();
	
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
		
		// instantiate XMLReader here, have it populate all .xml files in current directory
		// the XMLReader object will store an ArrayList of accounts once it finishes
		XMLReader readAccounts = new XMLReader();
		readAccounts.populateAccounts();
		
		// get arraylist of accounts here
		ArrayList<Account> accountsToAdd = readAccounts.getAccountList();
		
		/*
		 * DELETE WHEN HAVE ACTUAL XML FILE. CHRIST.
		 */
		Account myAccount = new Account("Jess Checking", 2.02);
		AvailableAccounts.add(myAccount);
		/*
		 * DELETE WHEN HAVE ACTUAL XML FILE. CHRIST.
		 */

		// add them to AvailableAccounts
		AvailableAccounts.addAll(accountsToAdd);
		
		//*
		/*WelcomeScreen = new GUI_WelcomeScreenPB();
		
		WelcomeScreen.CreateAndShowWindow(this); */
	}

}
