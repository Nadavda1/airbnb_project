package model;

import java.io.Serializable;

import exception.ClientNameExc;
import exception.PhoneNumberExc;

public class Client implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String phoneNumber;
	
	public Client(String name, String phoneNumber)throws Exception {
		setName(name);
		setPhoneNumber(phoneNumber);
	}

	public String getName() {
		return name;
	}

	public void setName(String name)throws Exception {
		if(name.length() > 0) {
			this.name = name;
		}
		else {
			throw new ClientNameExc();
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)throws Exception {
		if(phoneNumber.length() > 0) {
			this.phoneNumber = phoneNumber;
		}
		else {
			throw new PhoneNumberExc();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		Client tmp = (Client)obj;
		return tmp.phoneNumber.equals(phoneNumber);
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString () {
		return "Name: " + name + " ,his phone number is: " + phoneNumber;
	}
}
