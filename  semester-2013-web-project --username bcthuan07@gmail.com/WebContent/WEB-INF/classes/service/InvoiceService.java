package service;

import java.util.List;

import entity.Invoice;

public interface InvoiceService {

	public void addInvoice(Invoice invoice);
	public List<Invoice> listInvoice();
	public void removeInvoice(Integer id);
	public void updateInvoice(Invoice invoice);
	
}
