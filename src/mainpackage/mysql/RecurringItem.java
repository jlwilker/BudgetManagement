package mainpackage.mysql;

public class RecurringItem 
{
	private String name;
	private double amount;
	private Integer dueDate;
	private Integer frequency;
	private Integer type;
	
	/**
	 * @param name
	 * @param amount
	 * @param dueDate
	 * @param frequency
	 * @param type
	 */
	public RecurringItem(String name, double amount, Integer dueDate,
			Integer frequency, Integer type) 
	{
		super();
		this.name = name;
		this.amount = amount;
		this.dueDate = dueDate;
		this.frequency = frequency;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getDueDate() {
		return dueDate;
	}

	public void setDueDate(Integer dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
