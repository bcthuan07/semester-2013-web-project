package service;

import java.util.List;

import entity.User;

public interface UserService {

	public void addUser(User user);
	public List<User> listUser();
	public void removeUser(Integer id);
	public void updateUser(User user);
}
