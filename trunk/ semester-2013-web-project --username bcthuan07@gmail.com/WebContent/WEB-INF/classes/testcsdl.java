import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public static void main(String[] args) throws NoSuchAlgorithmException {
		DAOService<User, Integer> userDaoService = new DAOService<>(new UserDAO());
		User user = new User();
		byte[] salt = PasswordUtil.generateSalt();
		byte[] pass = PasswordUtil.getEncryptedPassword("thuan", salt);
		user.setUsername("bcthuan07");
		user.setPassword(pass);
		user.setSalt(salt);
		user.setEmail("Thuần");
		user.setFullname("test");
		PaymentMethod p = new PaymentMethod();
		p.setPaymentMethodId(1);
		user.setPaymentMethod(p);
		user.setPermission(true);
		user.setDatecreated(new Date());
		user.setPhoneNumber(23553636+"");
		userDaoService.addObject(user);
	}
}