 package com.example.demo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class RequestInfo {

	@Email
	private String emailAdd;
	
	

	@NotNull
	private String userName;
	
	@NotNull
	private String Phone;
	
	

	
	public String getPhone() {
		return Phone;
	}



	public void setPhone(String phone) {
		Phone = phone;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getEmailAdd() {
		return emailAdd;
	}



	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}




	@Override
	public String toString() {
	    return "RequestInfo [email=" + emailAdd + ", text=" + "]";
	  }
}
