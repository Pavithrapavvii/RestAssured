package PojoClass;

public class Employee {
	String name;
	String email;
	int phone;
	int id;
	public Employee(String name, String email, int phone, int id) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.id = id;
	}
	
	public Employee() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
