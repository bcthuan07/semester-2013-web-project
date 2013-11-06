package entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@Column(name="idinvoice",nullable=false)
	private int idinvoice;
	
	@Column(name="datecreated",nullable=false)
	private Timestamp datecreated;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="iduser",unique=true,nullable=false)
	private User user;
	
//	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name="id.idInvoice",unique=true,nullable=false)
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="invoice")
	private List<InvoiceDetail> lInvoiceDetail;

	public Invoice(int idinvoice, Timestamp datecreated, User user,
			List<InvoiceDetail> lInvoiceDetail) {
		super();
		this.idinvoice = idinvoice;
		this.datecreated = datecreated;
		this.user = user;
		this.lInvoiceDetail = lInvoiceDetail;
	}
	
	public Invoice(){}

	public int getIdinvoice() {
		return idinvoice;
	}

	public void setIdinvoice(int idinvoice) {
		this.idinvoice = idinvoice;
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

	public List<InvoiceDetail> getlInvoiceDetail() {
		return lInvoiceDetail;
	}

	public void setlInvoiceDetail(List<InvoiceDetail> lInvoiceDetail) {
		this.lInvoiceDetail = lInvoiceDetail;
	}

	@Override
	public String toString() {
		return "Invoice [idinvoice=" + idinvoice + ", datecreated="
				+ datecreated +  ", lInvoiceDetail="
				+ lInvoiceDetail + "]";
	}
	
	
	
	
	
}
