package application;

public class workOutplan {
	private String trainerid;
	private String Customerid;
	private String plan;
	public String getTrainerid() {
		return trainerid;
	}
	public void setTrainerid(String trainerid) {
		this.trainerid = trainerid;
	}
	public String getCustomerid() {
		return Customerid;
	}
	public void setCustomerid(String customerid) {
		Customerid = customerid;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public workOutplan(String trainerid, String customerid, String plan) {
		super();
		this.trainerid = trainerid;
		Customerid = customerid;
		this.plan = plan;
	}
	
}
