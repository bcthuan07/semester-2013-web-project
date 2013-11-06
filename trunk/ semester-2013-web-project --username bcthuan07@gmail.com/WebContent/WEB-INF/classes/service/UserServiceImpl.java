package service;

import java.util.List;

import dao.UserDAO;
import entity.User;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	public UserServiceImpl(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDAO.addUser(user);
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userDAO.listUser();
	}

	@Override
	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		userDAO.removeUser(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.updateUser(user);
	}

}
