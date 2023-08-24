package PojoClass;

public class EmployeeArrayWithComplex {
	String name;
	String mail;
	int[] phno;
	Spouse spouse;
	
	public EmployeeArrayWithComplex(String name, String mail, int[] phno, Spouse spouse) {
		super();
		this.name = name;
		this.mail = mail;
		this.phno = phno;
		this.spouse = spouse;
	}
	public EmployeeArrayWithComplex()
	{
		
	}
	
	public Spouse getSpouse() {
		return spouse;
	}
	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
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
