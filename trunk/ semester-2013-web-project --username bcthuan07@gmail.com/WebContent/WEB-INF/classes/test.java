import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Product;
import model.User;
import service.DAOService;
import service.LoginService;
import util.HibernateUtil;
import dao.UserDAO;

/**
 * 
 */

/**
 * @author Thuan
 *
 */
public class test {

	public static void main(String[] args) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Product p where str(p.productName) like :name ");
		query.setString("name", "%b%");
		List<Product> list = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(list);
	}
}
