package entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="invoicedetail")
public class InvoiceDetail {

	@EmbeddedId
	private InvoiceDetailFieldKey id;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idinvoice",unique=true,nullable=false, insertable=false, updatable=false)
	private Invoice invoice;
	
	public InvoiceDetail(InvoiceDetailFieldKey id, Invoice invoice) {
		super();
		this.id = id;
		this.invoice = invoice;
	}
	
	public InvoiceDetail(){}

	public InvoiceDetailFieldKey getId() {
		return id;
	}

	public void setId(InvoiceDetailFieldKey id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "InvoiceDetail [id=" + id  + "]";
	}
	
	
	
	
}
