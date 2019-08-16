package model;

public class CustomerDetail {

	String name,email,address;
	
	long phoneNumber;
	
	public CustomerDetail(String name,String email,String address,long phonenum) {
		this.name=name;
		this.email=email;
		this.address=address;
		this.phoneNumber=phonenum;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	
}
