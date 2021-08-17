package aws.boot.user.helper;

import org.springframework.stereotype.Component;

import aws.boot.user.entity.UserDomain;
import aws.boot.user.model.UserModel;

@Component
public class ModelConverter {
	public static UserModel convertToModel(UserDomain userEntityDocument) {
		UserModel userModel = new UserModel();
		userModel.setUserId(userEntityDocument.getUserId());
		userModel.setUserName(userEntityDocument.getUserName());
		return userModel;
	}
}
