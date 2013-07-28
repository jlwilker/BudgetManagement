package mainpackage.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import mainpackage.Account;
import mainpackage.AccountItem;
import mainpackage.GUI_PersonalBudget;


/*
 * Add threads to update immediately? Does that make sense?
 * Possible to have something such as "EXIT_ON_CLOSE" where it calls a function and then closes?
 */
public class XMLWriter
{
	//XML attributes
	XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	XMLStreamWriter streamWriter = null;
	
	// set up DateFormat
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public void writeXML(ArrayList<Account> accountsToWrite)
	{ 
		try
		{
			//create file for writing; rewrite if file exists already
			File targetFile = new File("practice.xml");
			
			streamWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(targetFile), "UTF-8");
			streamWriter.writeStartDocument("UTF-8", "1.0");
			
			//"Accounts" tag
			streamWriter.writeStartElement("accounts");
			
			for (Account temp : accountsToWrite)
			{
				//"Account" tag for each account
				streamWriter.writeStartElement("account");
				
				//set account name tag
				streamWriter.writeStartElement("name");
				streamWriter.writeCharacters(temp.getAccountName());
				streamWriter.writeEndElement();
				
				//set account total tag
				streamWriter.writeStartElement("total");
				streamWriter.writeCharacters(String.valueOf((long)temp.getAccountTotal()));
				streamWriter.writeEndElement();
				
				//"Items" tag
				streamWriter.writeStartElement("items");
				
				for (AccountItem tempItem : temp.getAccountItemRA())
				{
					//"Item" tag for each item
					streamWriter.writeStartElement("item");
					
					//Item name tag
					streamWriter.writeStartElement("name");
					streamWriter.writeCharacters(tempItem.getName());
					streamWriter.writeEndElement();
					
					//Item amount tag
					streamWriter.writeStartElement("amount");
					streamWriter.writeCharacters(String.valueOf((long)tempItem.getAmount()));
					streamWriter.writeEndElement();
					
					//Item date tag
					streamWriter.writeStartElement("date");
					streamWriter.writeCharacters(df.format(tempItem.getDate()));
					streamWriter.writeEndElement();
					
					//Item category tag
					streamWriter.writeStartElement("category");
					streamWriter.writeCharacters(tempItem.getCategory());
					streamWriter.writeEndElement();
					
					//Item incomeFlag tag
					streamWriter.writeStartElement("incomeFlag");
					streamWriter.writeCharacters(String.valueOf((int)tempItem.getIncomeFlag()));
					streamWriter.writeEndElement();
					
					//End "Item" tag
					streamWriter.writeEndElement();
				}
				
				//End "Items" tag
				streamWriter.writeEndElement();
			
				//End "Account" tag
				streamWriter.writeEndElement();
			}
			
			//End "Accounts" tag
			streamWriter.writeEndElement();
			
			streamWriter.writeEndDocument();
			
			streamWriter.flush();
			streamWriter.close();
			
		}
		catch (XMLStreamException e)
		{
			e.printStackTrace();
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}
		finally
		{
			if (streamWriter != null)
			{
				try
				{
					streamWriter.close();
				}
				catch (XMLStreamException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}