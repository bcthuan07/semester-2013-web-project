package dao;

import java.util.List;

import entity.User;

public interface UserDAO {

	public void addUser(User user);
	public List<User> listUser();
	public void removeUser(Integer iduser);
	public void updateUser(User user);
}
