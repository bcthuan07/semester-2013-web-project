/**
 * 
 */
package service;

import java.util.List;

import model.User;
import dao.GeneralDAO;
import dao.UserDAO;

/**
 * @author Thuan
 * 
 */
public class RegisterService {

	public boolean register(User user) {
		try {
			GeneralDAO<User, Integer> userDAO = new UserDAO();
			DAOService<User, Integer> userService = new DAOService<>(userDAO);
			List<User> listUser = userService.listObject();
			for (User u : listUser) {
				if (u.getUsername().equals(user.getUsername())
						|| u.getEmail().equals(user.getEmail())) {
					System.out.println("tôÌn taòi");
					return false;
				}
			}
			userService.addObject(user);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println("lôÞi");
			return false;
		}
	}
}
