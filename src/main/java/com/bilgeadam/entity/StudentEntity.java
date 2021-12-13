package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "studentEntity")
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 8254402310579127680L;
	
	// optimistic locking, one transaction at moment
	// optimistik Locking: kilitlenme
	// @Version: Birden fazla transaction durumlarında: datalarımızın aynı anda
	// değişiklik yapılmasına izin verimiyor
	@Version
	private Long version;
	
	// LOB: Large Object Binary
	@Lob
	@Column(name = "big_data")
	private String bigData;
	
	@Id // PK+NN+UN
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.AUTO) // for postgres
	@Column(name = "student_id", insertable = false, updatable = false)
	// generator="key" map için kullanıyoruz
	// sequenceName sequenceAdi
	// allocationSize: artırma miktarı
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "key")
	// @SequenceGenerator(name = "key", sequenceName = "STUDENT_ID_SEQ",
	// allocationSize = 1)
	// insertable = false bu bize bu kolon için ekleme yapamazsın
	// updatable = false bu bize bu kolon için güncelleme yapamazsın
	private long studentId;
	
	@Column(name = "student_name", length = 255)
	private String studentName;
	
	@Column(name = "student_surname")
	private String studentSurname;
	
	@Column(name = "student_email_address")
	private String emailAddress;
	
	@Column(name = "student_password")
	private String studentPassword;
	
	// DATE:yıl ay gün
	// TIME:saat dakika saniye
	// TIMESTAMP:yıl ay gün saat dakika saniye
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date date;
	
	@Column(name = "tc_number", length = 11, nullable = false)
	private int tcNumber;
	
	@Transient // not insert to database
	private int counter;
	
	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}
	
	// parametreli constructor
	public StudentEntity(String studentName, String studentSurname, String emailAddress, String studentPassword) {
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.emailAddress = emailAddress;
		this.studentPassword = studentPassword;
	}
	
	// parametreli constructor
	public StudentEntity(String bigData, String studentName, String studentSurname, String emailAddress,
			String studentPassword, int tcNumber) {
		super();
		this.bigData = bigData;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.emailAddress = emailAddress;
		this.studentPassword = studentPassword;
		this.tcNumber = tcNumber;
	}
	
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", studentName=" + studentName + ", studentSurname="
				+ studentSurname + ", emailAddress=" + emailAddress + ", studentPassword=" + studentPassword + ", date="
				+ date + ", tcNumber=" + tcNumber + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, emailAddress, studentId, studentName, studentPassword, studentSurname, tcNumber);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntity other = (StudentEntity) obj;
		return Objects.equals(date, other.date) && Objects.equals(emailAddress, other.emailAddress)
				&& studentId == other.studentId && Objects.equals(studentName, other.studentName)
				&& Objects.equals(studentPassword, other.studentPassword)
				&& Objects.equals(studentSurname, other.studentSurname) && tcNumber == other.tcNumber;
	}
	
}
