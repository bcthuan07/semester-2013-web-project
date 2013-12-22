import java.security.NoSuchAlgorithmException;
import java.util.Date;

import model.Address;
import model.City;
import model.PaymentMethod;
import model.Role;
import model.User;
import service.DAOService;
import service.RegisterService;
import util.PasswordUtil;
import dao.UserDAO;
import exception.UsernameException;

public class testcsdl {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		DAOService<User, Integer> userDaoService = new DAOService<>(
				new UserDAO());
		
		User user = new User();
		byte[] salt = PasswordUtil.generateSalt();
		byte[] pass = PasswordUtil.getEncryptedPassword("thuan", salt);
		user.setUsername("bcthuan07");
		user.setPassword(pass);
		user.setSalt(salt);
		user.setEmail("bcthuan07@gmail.com");
		user.setFullname("Bùi Chính Thuần");
		PaymentMethod p = new PaymentMethod();
		p.setPaymentMethodId(1);
		user.setPaymentMethod(p);
		user.setDatecreated(new Date());
		Address a = new Address();
		a.setBuildingNumber(1);
		a.setStreet("23");
		City city = new City(1, "TP. HCM");
		a.setCity(city);
		a.setPhonenumber("23456578");
		RegisterService registerService  = new RegisterService();
		try {
			registerService.register(user, a);
		} catch (UsernameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}