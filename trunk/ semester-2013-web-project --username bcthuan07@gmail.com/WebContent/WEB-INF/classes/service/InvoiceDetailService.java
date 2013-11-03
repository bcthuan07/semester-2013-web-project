package service;

import java.util.List;

import entity.InvoiceDetail;

public interface InvoiceDetailService {

	public void addInvoiceDetailService(InvoiceDetail invoicedetail);
	public List<InvoiceDetail> listInvoiceDetail();
	public void removeInvoiceDetail(Integer id1, Integer id2);
	public void updateInvoiceDetailService(InvoiceDetail invoicedetail);
}
