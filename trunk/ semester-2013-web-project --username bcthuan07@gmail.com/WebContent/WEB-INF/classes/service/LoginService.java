/**
 * 
 */
package service;

import java.util.List;

import util.PasswordUtil;
import model.User;
import dao.GeneralDAO;
import dao.UserDAO;

/**
 * @author Thuan
 * 
 */
public class LoginService {

	public boolean authenticate(String username, String password) {

		GeneralDAO<User, Integer> userDAO = new UserDAO();
		DAOService<User, Integer> userService = new DAOService<>(userDAO);
		List<User> listUser = userService.listObject();
		if (listUser.size() == 0)
			return false;
		User user = null;
		for (User u : listUser) {
			if (u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		if (user == null)
			return false;
		else {
			byte[] pass = user.getPassword();
			byte[] salt = user.getSalt();
			boolean isRight = false;
			try {
				isRight = PasswordUtil.authenticate(password, pass, salt);
			} catch (Exception e) {
				System.err.println("error with password authenticate");
			}
			return isRight;
		}
	}
}
