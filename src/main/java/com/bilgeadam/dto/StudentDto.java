package com.bilgeadam.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {
	private static final long serialVersionUID = 3020787013243576265L;
	
	private long studentId;
	private String studentName;
	private String studentSurname;
	private String emailAddress;
	private String studentPassword;
	
	// parametresiz constructor
	public StudentDto() {
		
	}
	
	// parametreli constructor
	public StudentDto(long studentId, String studentName, String studentSurname, String emailAddress,
			String studentPassword) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.emailAddress = emailAddress;
		this.studentPassword = studentPassword;
	}
	
	// toString
	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", studentSurname="
				+ studentSurname + ", emailAddress=" + emailAddress + ", studentPassword=" + studentPassword + "]";
	}
	
	// getter and setter
	public long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentSurname() {
		return studentSurname;
	}
	
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getStudentPassword() {
		return studentPassword;
	}
	
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	
}
