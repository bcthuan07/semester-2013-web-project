package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class InvoiceDetailFieldKey implements Serializable{

	@Column(name="idinvoice")
	private int idInvoice;
	
	@Column(name="idmeal")
	private int idMeal;

	public InvoiceDetailFieldKey(int idInvoice, int idMeal) {
		super();
		this.idInvoice = idInvoice;
		this.idMeal = idMeal;
	}
	
	public InvoiceDetailFieldKey(){}

	public int getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(int idInvoice) {
		this.idInvoice = idInvoice;
	}

	public int getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}

	@Override
	public String toString() {
		return "InvoiceDetailFieldKey [idInvoice=" + idInvoice + ", idMeal="
				+ idMeal + "]";
	}
	
	
}
