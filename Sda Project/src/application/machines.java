package application;

public class machines {
	public machines(String name, int quantity, String buyDate, String repairs) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.buyDate = buyDate;
		this.repairs = repairs;
	}
	private String name ;
	private int quantity ;
	private String buyDate ;
	private String repairs ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getRepairs() {
		return repairs;
	}
	public void setRepairs(String repairs) {
		this.repairs = repairs;
	}
}
