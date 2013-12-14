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

	public User authenticate(String username, String password) {

		GeneralDAO<User, Integer> userDAO = new UserDAO();
		DAOService<User, Integer> userService = new DAOService<>(userDAO);
		List<User> listUser = userService.listObject();
		if (listUser.size() == 0)
			return null;
		User user = null;
		for (User u : listUser) {
			if(u.getUsername()!=null)
			if (u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		if (user == null)
			return null;
		else {
			System.out.println(user);
			byte[] pass = user.getPassword();
			byte[] salt = user.getSalt();
			boolean isRight = false;
			try {
				isRight = PasswordUtil.authenticate(password, pass, salt);
			} catch (Exception e) {
				System.err.println("error with password authenticate");
			}
			if (isRight) {
				return user;
			}
		}
		return null;
	}

	public boolean hasUser(String username) {
		GeneralDAO<User, Integer> userDao = new UserDAO();
		List<User> listUser = userDao.listObject();
		boolean hasUser = false;
		for (User user : listUser) {
			if (user.getUsername() != null) {
				if (user.getUsername().equals(username)) {
					hasUser = true;
				}
			}
		}
		return hasUser;
	}
}
