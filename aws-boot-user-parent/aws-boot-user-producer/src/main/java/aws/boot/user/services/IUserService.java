package aws.boot.user.services;


import java.util.List;

import aws.boot.user.model.UserModel;


public interface IUserService {
	public List<UserModel> getAllUsers();
	public UserModel getUserById(Long userId);
	public boolean addUser(UserModel userModel);
	public void updateUser(UserModel userModel);
	public void deleteUser(Long userId);
}
