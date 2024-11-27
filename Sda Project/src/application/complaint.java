package application;
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class complaint {
	
	private String complain;
	private String dateregistered;
	
	public complaint(String complain) {
		this.complain = complain;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date();  
		this.dateregistered = formatter.format(date);
	}
	public String getComplain() {
		return complain;
	}
	public void setComplain(String complain) {
		this.complain = complain;
	}
	public String getDateregistered() {
		return dateregistered;
	}

	
	
}
