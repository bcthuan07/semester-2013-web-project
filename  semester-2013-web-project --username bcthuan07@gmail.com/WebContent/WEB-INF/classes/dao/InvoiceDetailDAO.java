package dao;

import java.util.List;

import entity.InvoiceDetail;

public interface InvoiceDetailDAO {

	public void addInvoiceDetail(InvoiceDetail invoicedetail);
	public List<InvoiceDetail> listInvoiceDetail();
	public void removeInvoiceDetail(Integer idinvoice, Integer idmeal);
	public void updateInvoiceDetail(InvoiceDetail invoicedetail);
}
