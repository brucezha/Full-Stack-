package com.bean;

//Updated by Laukik

import java.util.Date;
public class Operator {
private int operatorId;
private String firstName;
private String lastName;
private String password; 
private String email;
private String phone;
private String shiftStart;
private String shiftEnd;
private int managedCustomers;
private Date creationDate;
private int activeCustomers;

	
	public int getOperatorId() {
	return operatorId;
}
public void setOperatorId(int operatorId) {
	this.operatorId = operatorId;
}
	public String getFirstName() {
	    return firstName;
	}
	public void setFirstName(String firstName) {
	    this.firstName = firstName;
	}
	public String getLastName() {
	    return lastName;
	}
	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
	    return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShiftStart() {
	    return shiftStart;
	}
	public void setShiftStart(String shiftStart) {
	    this.shiftStart = shiftStart;
	}
	public String getShiftEnd() {
	    return shiftEnd;
	}
	public void setShiftEnd(String shiftEnd) {
	    this.shiftEnd = shiftEnd;
	}
	public Date getCreationDate() {
	    return creationDate;
	}
	public void setCreationDate(Date creationDate) {
	    this.creationDate = creationDate;
	}
	public int getActiveCustomers() {
	    return activeCustomers;
	}
	public void setActiveCustomers(int activeCustomers) {
	    this.activeCustomers = activeCustomers;
	}
	public int getManagedCustomers() {
	    return managedCustomers;
	}
	public void setManagedCustomers(int managedCustomers) {
		this.managedCustomers = managedCustomers;
	}
	@Override
	public String toString() {
	    return "Operator [operatorId=" + operatorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
	            + email + ", phone=" + phone + ", shiftStart=" + shiftStart + ", shiftEnd=" + shiftEnd
	            + ", managedCustomers=" + managedCustomers + ", creationDate=" + creationDate + ", activeCustomers="
	            + activeCustomers + "]";
	}
}