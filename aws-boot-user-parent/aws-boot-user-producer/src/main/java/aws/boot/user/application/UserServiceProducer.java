package aws.boot.user.application;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import aws.boot.user.controller.UserRestController;
import aws.boot.user.model.UserModel;

@SpringBootApplication(scanBasePackages = {"aws.boot.user"})
public class UserServiceProducer{
    public static void main(String[] args) {
    	ConfigurableApplicationContext context = SpringApplication.run(UserServiceProducer.class, args);
    	List<UserModel> userModelList = context.getBean(UserRestController.class).getAllUsers().getBody();
    	userModelList.stream().forEach(userModel -> System.out.print(userModel));
    }
}