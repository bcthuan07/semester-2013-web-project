package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.HibernateUtil;
import entity.Invoice;

public class InvoiceDAOImpl implements InvoiceDAO{

	@Override
	public void addInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.save(invoice);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public List<Invoice> listInvoice() {
		// TODO Auto-generated method stub
		List<Invoice> list = new ArrayList<>();
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		list = s.createQuery("from Invoice").list();
		s.getTransaction().commit();
		s.close();
		return list;
	}

	@Override
	public void removeInvoice(Integer id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		Invoice invoice = (Invoice) s.load(Invoice.class, id);
		s.delete(invoice);
		s.getTransaction().commit();
		s.close();
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.update(invoice);
		s.getTransaction().commit();
		s.close();
	}

}
