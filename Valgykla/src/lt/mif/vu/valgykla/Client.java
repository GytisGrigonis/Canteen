package lt.mif.vu.valgykla;

public class Client extends Person{
	private int bill;
	private int tableNumber;
	
	public Client(String name, int bill, int tableNumber) {
		super(name);
		this.bill = bill;
		this.tableNumber = tableNumber;
	}
	
	public int getBill() {
		return bill;
	}
	
	public void setBill(int bill) {
		this.bill = bill;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	@Override
	public int getPeriod() {
		return 30;
	}
}
