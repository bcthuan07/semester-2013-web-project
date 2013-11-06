package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.HibernateUtil;
import entity.InvoiceDetail;
import entity.InvoiceDetailFieldKey;

public class InvoiceDetailDAOImpl implements InvoiceDetailDAO{

	@Override
	public void addInvoiceDetail(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.save(invoicedetail);
		s.getTransaction().commit();
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InvoiceDetail> listInvoiceDetail() {
		// TODO Auto-generated method stub
		List<InvoiceDetail> list = new ArrayList<>();
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		list = s.createQuery("from InvoiceDetail").list();
		s.getTransaction().commit();
		s.close();
		return list;
	}

	

	@Override
	public void updateInvoiceDetail(InvoiceDetail invoicedetail) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.update(invoicedetail);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void removeInvoiceDetail(Integer idinvoice, Integer idmeal) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		InvoiceDetail i = (InvoiceDetail) s.load(InvoiceDetail.class, new InvoiceDetailFieldKey(idinvoice, idmeal));
		s.delete(i);
		s.getTransaction().commit();
		s.close();
	}

}
