package PojoClass;

public class EmployeeArray {
	String name;
	String mail;
	int[] phno;
	
	
	public EmployeeArray(String name, String mail, int[] phn) {
		super();
		this.name = name;
		this.mail = mail;
		this.phno = phno;
		
	}
	public EmployeeArray()
	{
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int[] getPhno() {
		return phno;
	}
	public void setPhno(int[] phno) {
		this.phno = phno;
	}
	
	
	
	

}
