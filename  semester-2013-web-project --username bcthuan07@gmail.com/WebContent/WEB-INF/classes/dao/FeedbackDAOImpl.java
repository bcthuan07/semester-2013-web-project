package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.Feedback;
import entity.HibernateUtil;

public class FeedbackDAOImpl implements FeedbackDAO {

	@Override
	public void addFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.save(feedback);
		s.getTransaction().commit();
		s.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> listFeedback() {
		// TODO Auto-generated method stub
		List<Feedback> list = new ArrayList<>();
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		list = s.createQuery("from Feedback").list();
		s.getTransaction().commit();
		s.close();
		return list;
	}

	@Override
	public void removeFeedback(Integer id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		Feedback feedback = (Feedback) s.load(Feedback.class, id);
		s.delete(feedback);
		s.getTransaction().commit();
		s.close();

	}

	@Override
	public void updateFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.openSession();
		s.beginTransaction();
		s.update(feedback);
		s.getTransaction().commit();
		s.close();

	}

}
