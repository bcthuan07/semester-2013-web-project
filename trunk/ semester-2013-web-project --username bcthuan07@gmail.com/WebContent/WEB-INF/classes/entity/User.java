package entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "user")
public class User {

	@Id
	@Column(name = "iduser", unique = true, nullable = false)
	private int iduser;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "age")
	private int age;

	@Column(name = "address")
	private String address;

	@Column(name = "datecreated", nullable = false)
	private Timestamp datecreated;

	@Column(name = "email")
	private String email;

	@Column(name = "permission", nullable=false)
	private int permission;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	private List<Feedback> lFeedback;
	
	public User(int iduser, String username, String password, String firstname,
			String lastname, int age, String address, Timestamp datecreated,
			String email, int permission) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.datecreated = datecreated;
		this.email = email;
		this.permission = permission;
		lFeedback = new ArrayList<>();
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public List<Feedback> getlFeedback() {
		return lFeedback;
	}

	public void setlFeedback(List<Feedback> lFeedback) {
		this.lFeedback = lFeedback;
	}

	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", username=" + username
				+ ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", age=" + age + ", address="
				+ address + ", datecreated=" + datecreated + ", email=" + email
				+ ", permission=" + permission + ", lFeedback=" + lFeedback
				+ "]";
	}
	
	
	
	

}
