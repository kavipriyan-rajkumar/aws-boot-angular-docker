package aws.boot.user.services;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import aws.boot.user.helper.ModelConverter;
import aws.boot.user.model.UserModel;
import aws.boot.user.repository.IUserBaseRepository;

@Service("userService")
public class UserService implements IUserService {

	/**@Autowired 
	private UserSolrRepository userSolrRepository;**/
	
	@Autowired @Qualifier("userRepository")
	private IUserBaseRepository userRepository;
	@Override
	public List<UserModel> getAllUsers() {
		return StreamSupport.stream(userRepository.findAll().spliterator(),false)
				.map(userDomain -> ModelConverter.convertToModel(userDomain))
				.collect(Collectors.toList());
	}

	@Override
	public UserModel getUserById(Long userId) {
		return null;
	}

	@Override
	public boolean addUser(UserModel userModel) {
		return false;
	}

	@Override
	public void updateUser(UserModel userModel) {
	}

	@Override
	public void deleteUser(Long userId) {
	}

}
