package application;

public class Trainer {
	
	private String id ;
	private String fname ;
	private String lname ;
	private String dob ;
	private String salary ;
	private String password;
	private String phone;
	private String comission ;
	public Trainer() {
		this.id =null;
		this.fname = null;
		this.lname = null;
		this.dob = null;
		this.salary = null;
		this.password = null;
		this.phone = null;
		this.comission = null;
	};
	public Trainer(String id, String fname, String lname, String dob, String salary, String password, String phone,String comission) {
	
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.salary = salary;
		this.password = password;
		this.phone = phone;
		this.comission = comission;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getComission() {
		return comission;
	}
	public void setComission(String comission) {
		this.comission = comission;
	}
	
}
