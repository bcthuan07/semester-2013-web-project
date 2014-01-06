import java.security.NoSuchAlgorithmException;
import java.util.Date;

import model.Address;
import model.Ads;
import model.City;
import model.PaymentMethod;
import model.Role;
import model.User;
import service.DAOService;
import service.RegisterService;
import util.PasswordUtil;
import dao.AdDAO;
import dao.AddressDAO;
import dao.UserDAO;
import exception.UsernameException;

public class testcsdl {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		DAOService<Ads, Integer> daoService = new DAOService<>(new AdDAO());
		for(Ads a: daoService.listObject())
		{
			System.out.println(a);
		}
	}
}