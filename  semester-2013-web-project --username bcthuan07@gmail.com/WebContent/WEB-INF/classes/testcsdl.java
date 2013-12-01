import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.DAOService;
import service.LoginService;
import service.RegisterService;
import sun.org.mozilla.javascript.internal.ast.ArrayLiteral;
import util.PasswordUtil;
import model.Address;
import model.PaymentMethod;
import model.ProductType;
import model.User;
import dao.AddressDAO;
import dao.GeneralDAO;
import dao.PaymentMethodDAO;
import dao.ProductTypeDAO;
import dao.UserDAO;

public class testcsdl {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
//		GeneralDAO<Address, Integer> dao = new AddressDAO();
//		Address pt = dao.getObject(new Integer(1));
//		System.out.println(pt);
//		List<Address> l = dao.listObject();
//		dao.removeObject(new Integer(4));
//		System.out.println(dao.getObject(new Integer(1)));
//		for(Address a: l){
//			System.out.println(a);
//			System.out.println(a.getProducts());
//		}
		
//		System.out.println(new LoginService().hasUser("thuansgs"));
//		GeneralDAO<User, Integer> dao = new UserDAO();
//		System.out.println(dao.getObject(new Integer(3)));
//		PasswordUtil pu = new PasswordUtil();
//		byte[] salt = pu.generateSalt();
//		byte[] p = pu.getEncryptedPassword("thuan", salt);
		
//		User user = new User();
//		PaymentMethod pm = new PaymentMethodDAO().getObject(new Integer(1));
//		user.setDatecreated(new Date());
//		user.setEmail("kjagk");
//		user.setFirstName("Mau");
//		user.setLastName("kajg");
//		user.setGender(false);
//		user.setPassword(p);
//		user.setSalt(salt);
//		user.setPermission(true);
//		user.setPaymentMethod(pm);
//		user.setUsername("testps");
//		user.setPhoneNumber(14562);
//		dao.addObject(user);
		
//		System.out.println(new LoginService().authenticate("testps", "thuan"));
		
//		DAOService<User, Integer> daoservice = new DAOService<>(new UserDAO());
//		System.out.println(daoservice.getObjectById(new Integer(6)));
		
		String t = "";
		boolean b = true;
		t = b ? "Nam" : "Nu";
		System.out.println(t);
	}
}
