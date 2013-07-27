package mainpackage.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


/*
 * Add threads to update immediately? Does that make sense?
 * Possible to have something such as "EXIT_ON_CLOSE" where it calls a function and then closes?
 */
public class XMLWriter
{
	//XML attributes
	XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	XMLStreamWriter streamWriter = null;
	
	public void writeXML()
	{ 
		try
		{
			//if file not found? (should create)
			File targetFile = new File("C:/Users/jwilker201/Documents/Budget/PersonalBudget/BudgetManagement/practice.xml");
			
			streamWriter = outputFactory.createXMLStreamWriter(new FileOutputStream(targetFile), "UTF-8");
			streamWriter.writeStartDocument("UTF-8", "1.0");
			
			streamWriter.writeStartElement("accounts");
			
			streamWriter.writeStartElement("account");
			streamWriter.writeAttribute("id", "1");
			
			streamWriter.writeStartElement("name");
			streamWriter.writeCharacters("Zack");
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("total");
			streamWriter.writeCharacters("3000.00");
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("items");
			
			streamWriter.writeStartElement("item");
			
			streamWriter.writeStartElement("name");
			streamWriter.writeCharacters("food");
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("amount");
			streamWriter.writeCharacters("50.00");
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("date");
			streamWriter.writeCharacters("2013-07-14");
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("category");
			streamWriter.writeCharacters("grocery");
			streamWriter.writeEndElement();
			
			streamWriter.writeStartElement("incomeFlag");
			streamWriter.writeCharacters("0");
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