import java.security.NoSuchAlgorithmException;
import java.util.Date;

import model.Address;
import model.PaymentMethod;
import model.User;
import service.DAOService;
import service.RegisterService;
import util.PasswordUtil;
import dao.UserDAO;
import exception.UsernameException;

public class testcsdl {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		DAOService<User, Integer> userDaoService = new DAOService<>(new UserDAO());
		User user = new User();
		byte[] salt = PasswordUtil.generateSalt();
		byte[] pass = PasswordUtil.getEncryptedPassword("thuan", salt);
		user.setUsername("bcthuan");
		user.setPassword(pass);
		user.setSalt(salt);
		user.setEmail("bcthuan@gaga.com");
		user.setFullname("bùi chính thuần");
		PaymentMethod p = new PaymentMethod();
		p.setPaymentMethodId(1);
		user.setPaymentMethod(p);
		user.setPermission(true);
		user.setDatecreated(new Date());
		user.setPhoneNumber(23553636+"");
		Address a = new Address();
		a.setBuildingNumber(1);
		a.setCity("Biên Hòa");
		a.setStreet("23");
		a.setZipCode(23);
		RegisterService registerService = new RegisterService();
		try {
			System.out.println(registerService.register(user, a));
		} catch (UsernameException e) {
			// TODO Auto-generated catch block
//			System.err.println(e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}
}