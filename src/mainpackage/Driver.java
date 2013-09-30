package mainpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;

import packageGUI.WelcomeScreen;
import mainpackage.GUI_PersonalBudget;

/** main class **/
public class Driver 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				//GUI_PersonalBudget GUI = new GUI_PersonalBudget();
				
				/*
				 * I think this will be key.
				 */
				WelcomeScreen ws = new WelcomeScreen();
				
				ws.CreateAndShowWindow();
			}
		});
	}
}
