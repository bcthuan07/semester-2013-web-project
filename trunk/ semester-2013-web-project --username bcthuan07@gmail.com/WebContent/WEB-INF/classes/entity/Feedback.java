package entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="idfeedback",unique=true,nullable=false)
	private int idFeedback;
	
	@Column(name="content",unique=true,nullable=false)
	private String content;
	
	@Column(name="datecreated")
	private Timestamp datecreated;
	
	@ManyToOne
	@JoinColumn(name="iduser",nullable=false)
	private User user;

	public Feedback(int idFeedback, String content, Timestamp datecreated,
			User user) {
		super();
		this.idFeedback = idFeedback;
		this.content = content;
		this.datecreated = datecreated;
		this.user = user;
	}

	public int getIdFeedback() {
		return idFeedback;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}

	public String getContent() {
		return content;
	}
	
	

	public Feedback() {
		super();
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Feedback [idFeedback=" + idFeedback + ", content=" + content
				+ ", datecreated=" + datecreated + "]";
	}
	
	
	
}
