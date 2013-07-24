package mainpackage.xml;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import mainpackage.Account;
import mainpackage.AccountItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader 
{
	private final String validatorLoc = "accountvalidator.xsd";
	private final String accountsTag = "account";
	private final String itemsTag = "items";
	private final String itemTag = "item";
	private ArrayList<Account> accountList;
	private final File curDir = new File(".");
	private File[] files;
	/**
	 * 
	 * @param xmlFileLoc
	 */
	public XMLReader()
	{
		this.accountList = new ArrayList<Account>();

		// populate files[] with all .xml files in current directory
		this.files = this.curDir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".xml");
			}
		});
		
	}
	/**
	 * 
	 * @return
	 */
	private boolean validate(String xmlLoc)
	{
		boolean ret = false;
		Source xmlFile = null;
		try
		{
			// set schema and XML file
			URL schemaFile = new File(this.validatorLoc).toURI().toURL();
			xmlFile = new StreamSource(new File(xmlLoc));
			
			// generate schema factory and set schema file
			SchemaFactory schemaFactory = SchemaFactory
			    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			
			// validate, if it gets past validator.validate then it is correct and
			// sets return to true
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			ret = true;
		} 
		catch (SAXException e) 
		{
		  System.out.println(xmlFile.getSystemId() + " is NOT valid");
		  System.out.println("Reason: " + e.getLocalizedMessage());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return(ret);
	}
	/**
	 * Call this function after object instantiation to try to load
	 * xml files from current directory
	 */
	public void populateAccounts()
	{
		for(int i = 0; i < this.files.length; i++)
		{
			this.readXml(this.files[i].getPath());
		}
	}
	/**
	 * attempts to validate the loaded xml file via constructor or setXmlFile
	 * if it validates, read and populate account objects and add them to the GUI
	 */
	private void readXml(String curXmlFile)
	{
		if(this.validate(curXmlFile))
		{
			try
			{			
				File xmlFile = new File(curXmlFile);
				
				// make document builder factory to parse xml file
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				
				// parse
				Document doc = dBuilder.parse(xmlFile);
				
				// normalize
				doc.getDocumentElement().normalize();
				
				// set up DateFormat
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				// get accounts through <accounts> tag
				NodeList nList = doc.getElementsByTagName(this.accountsTag);
				
				for(int i = 0; i < nList.getLength(); i++)
				{
					// get node item at i index
					Node nNode = nList.item(i);
					
					// if its a <account> start tag (wont parse </account>
					if(nNode.getNodeType() == Node.ELEMENT_NODE)
					{
						
						Element ele = (Element)nNode;
						// get name, total
						String name = ele.getElementsByTagName("name").item(0).getTextContent();
						double total = Double.parseDouble(ele.getElementsByTagName("total").item(0).getTextContent());
						
						// pull items the same way we are pulling accounts, populate an arraylist
						// and add to the specific account
						
						// get <items>
						Node itemsNode = ele.getElementsByTagName(this.itemsTag).item(0);
						Element itemsEle = (Element)itemsNode;
						
						// get list of <item>
						NodeList itemsList = itemsEle.getElementsByTagName(this.itemTag);
						ArrayList<AccountItem> accountItemList = new ArrayList<AccountItem>();
						
						// iterate through list of <item> tags
						for(int j = 0; j < itemsList.getLength(); j++)
						{
							Node itemNode = itemsList.item(j);
							
							if(itemNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element itemEle = (Element)itemNode;
								
								// get all the information from the specific accountitem
								String itemName = itemEle.getElementsByTagName("name").item(0).getTextContent();
								double amount = Double.parseDouble(itemEle.getElementsByTagName("amount").item(0).getTextContent());;
								Date date = (Date)df.parse(itemEle.getElementsByTagName("date").item(0).getTextContent());
								String category = itemEle.getElementsByTagName("category").item(0).getTextContent();
								Integer incomeFlag = Integer.parseInt(itemEle.getElementsByTagName("incomeFlag").item(0).getTextContent());
								
								AccountItem newAccItem = new AccountItem(itemName, amount, date, category, incomeFlag);
								accountItemList.add(newAccItem);
							} // end if
						} // end accountitem for loop
						
						// create account here, after it parses all the items and the name/amount
						Account acc = new Account(name, total);
						// add items if they even exist
						if(itemsList.getLength() != 0)
						{
							 acc.addMultipleAccountItems(accountItemList);
						}
						
						// add to accountList
						this.accountList.add(acc);
					} // end if
				} // end account for loop
			} // end try
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} // end read xml
	/**
	 * 
	 * @return
	 */
	public ArrayList<Account> getAccountList()
	{
		return(this.accountList);
	}
} // end class
