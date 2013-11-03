package entity;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USERID", unique = true, nullable = false)
	private int userId;

	public static enum Gender {
		MALE, FEMALE
	};
	
	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER")
	private Gender gender;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "DAYOFBIRTH")
	private Date dayOfBirth;
	
	@Column(name = "FULLNAME")
	private String fullname;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "USER")
	private ArrayList<Invoice> invoiceList;

	public User(int id, String username, String password) {
		this.userId = id;
		this.username = username;
		this.password = password;
		invoiceList = new ArrayList<>();
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getName() {
		return fullname;
	}

	public void setName(String name) {
		this.fullname = name;
	}

	public ArrayList<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(ArrayList<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

}
