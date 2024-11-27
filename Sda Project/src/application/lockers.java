package application;

public class lockers {

	private String lockerid;
	private String Assignedto;
	public lockers(String lockerid, String assignedto) {
		this.lockerid = lockerid;
		Assignedto = assignedto;
	}
	public String getLockerid() {
		return lockerid;
	}
	public void setLockerid(String lockerid) {
		this.lockerid = lockerid;
	}
	public String getAssignedto() {
		return Assignedto;
	}
	public void setAssignedto(String assignedto) {
		Assignedto = assignedto;
	}
}
