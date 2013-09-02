package mainpackage;


import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

public class AccountItem {
	
	private String name;
	private double amount;
	private Date date;
	private String category;
	private Integer incomeFlag;
	
	public AccountItem()
	{
		this.name = "";
		this.amount = 0;
		this.date = new Date();
		this.category = "";
		this.incomeFlag = -1;
	}
	
	public AccountItem(String startName, double startAmount, Date startDate,
			String startCategory, Integer startIncomeFlag)
	{
		this.name = startName;
		this.amount = startAmount;
		this.date = startDate;
		this.category = startCategory;
		this.incomeFlag = startIncomeFlag;
	}
	
	//toString() function?
	
	public String getName()
	{
		return this.name;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public Integer getIncomeFlag()
	{
		return this.incomeFlag;
	}
	
	public void setName(String editName)
	{
		this.name = editName;
	}
	
	public void setAmount(double editAmount)
	{
		this.amount = editAmount;
	}
	
	public void setCategory(String editCategory)
	{
		this.category = editCategory;
	}
	
	public void setDate(Date editDate)
	{
		this.date = editDate;
	}
	
	public void setIncomeFlag(Integer editIncomeFlag)
	{
		this.incomeFlag = editIncomeFlag;
	}
}
